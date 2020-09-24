package com.example.order.center.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.order.center.dao.*;
import com.example.order.center.manual.*;
import com.example.order.center.model.*;
import com.example.order.center.service.BalanceService;
import com.example.order.center.service.Impl.PayOrderServiceImpl;
import com.example.order.center.service.PayOrderService;
import com.second.utils.response.handler.ResponseEntity;
import com.second.utils.response.handler.ResponseUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.time.FastDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.InetAddress;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * @author shihao
 * @Title: SecondOrderController
 * @ProjectName Second-order-center
 * @Description: 订单
 * @date Created in
 * @Version: $
 */
@RestController
@Api
@RequestMapping("/SecondOrder")
@CrossOrigin
public class SecondOrderController {
    /**
     * 订单号
     */
    private static final FastDateFormat pattern = FastDateFormat.getInstance("yyyyMMddHHmmss");
    private static final AtomicInteger atomicInteger = new AtomicInteger(1);
    private static ThreadLocal<StringBuilder> threadLocal = new ThreadLocal<StringBuilder>();
    public static String getC(String lock) {
        lock = Objects.isNull(lock) ? UUID.randomUUID().toString() : lock;
        StringBuilder builder = new StringBuilder(pattern.format(Instant.now().toEpochMilli()));// 取系统当前时间作为订单号前半部分
        builder.append(Math.abs(lock.hashCode()));// HASH-CODE
        builder.append(atomicInteger.getAndIncrement());// 自增顺序
        threadLocal.set(builder);
        return threadLocal.get().toString();
    }

    //物品
    @Autowired
    private SecondGoodsMapper secondGoodsMapper;
    //订单
    @Autowired
    private SecondOrderMapper secondOrderMapper;
    //支付订单
    @Autowired
    private SecondPayOrderMapper secondPayOrderMapper;
    //订单详情
    @Autowired
    private SecondOrderDetailMapper secondOrderDetailMapper;
    //商品
    @Autowired
    private SecondProductMapper secondProductMapper;
    //商品地址
    @Autowired
    private SecondProductAddressMapper secondProductAddressMapper;
    //店铺地址
    @Autowired
    private SecondStoreMapper secondStoreMapper;
    //订单地址
    @Autowired
    private SecondOrderAddressMapper secondOrderAddressMapper;
    //用户
    @Autowired
    private SecondUserMapper secondUserMapper;
    //扣减库存
    @Autowired
    private PayOrderService payOrderService;
    //站点和用户
    @Autowired
    private SecondUserSonMapper secondUserSonMapper;
    //站点
    @Autowired
    private SecondSonMapper secondSonMapper;
    //余额管理
    @Autowired
    private BalanceService balanceService;
    @RequestMapping(path = "/addOrder", method = RequestMethod.POST)
    @ApiOperation(value = "创建订单", notes = "创建订单")
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public ResponseEntity<JSONObject> addCategory(CreateOrderRequest request, HttpServletRequest requests, HttpServletResponse response) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder();
        List list = checkResp(request.getGoodsList());

        System.out.println(list);
                if(list.size()!=0){
                    response.sendError(HttpStatus.FORBIDDEN.value(), "库存不足");
                    return builder.body(ResponseUtils.getResponseBody(list));
                }
        //
        JSONArray jsonArray= JSONArray.parseArray(request.getGoodsList());
        List<goods> list1 = JSONObject.parseArray(jsonArray.toJSONString(), goods.class);
                //扣减库存
        list1.forEach(good->{
           int a=  payOrderService.stock(good.getQuantity(),good.getGoodsId());
            System.out.println(a);
        });
                //支付订单
        SecondPayOrder secondPayOrder = new SecondPayOrder();
        secondPayOrder.setPayCode(UUID.randomUUID().toString());
        secondPayOrder.setUserId(request.getUserId());
        secondPayOrder.setPayStatus(OrderEnum.PaymentStatus.UNPAID.getPaymentStatus());
        secondPayOrder.setPaymentName(request.getPaymentType());
        secondPayOrder.setCreateTime(LocalDateTime.now());
        secondPayOrder.setModifyTime(LocalDateTime.now());
        secondPayOrder.setIsDeleted((byte) 0);
        secondPayOrderMapper.insertSelective(secondPayOrder);

        //店铺
        Set<Integer> stoneIds = list1.stream().map(goods::getStoneId).collect(Collectors.toSet());
        for (Integer storeId : stoneIds){
            List<goods> goodsList = list1.stream().filter(a->a.getStoneId().equals(storeId)).collect(Collectors.toList());
            List<Integer> money = new ArrayList<>();
            List<SecondOrderDetail> secondOrderDetails = new ArrayList<>();
            goodsList.forEach(goods -> {
                SecondOrderDetail secondOrderDetail = new SecondOrderDetail();
                SecondGoods secondGoods = secondGoodsMapper.selectByPrimaryKey(goods.getGoodsId());
                money.add(secondGoods.getSellPrice()*goods.getQuantity());
                secondOrderDetail.setGoodsId(goods.getGoodsId());
                secondOrderDetail.setSellPrice(secondGoods.getSellPrice()*goods.getQuantity());
                secondOrderDetail.setActualPrice(secondGoods.getSellPrice()*goods.getQuantity());
                secondOrderDetail.setQuantity(goods.getQuantity());
                secondOrderDetails.add(secondOrderDetail);
            });
            Integer moneys = money.stream().mapToInt(a->a).sum();
            SecondOrder secondOrder = new SecondOrder();
            secondOrder.setOrderCode(getC(UUID.randomUUID().toString()));
            secondOrder.setUserId(request.getUserId());
            secondOrder.setPayStatus(OrderEnum.PaymentStatus.UNPAID.getPaymentStatus());
            secondOrder.setOrderStatus(OrderEnum.OrderStatus.PAYMENT.getOrderStatus());
            secondOrder.setPaymentName(request.getPaymentType());
            secondOrder.setAmount(moneys);
            secondOrder.setPracticalAmount(moneys);
            secondOrder.setPaymentType(OrderEnum.PaymentType.getPaymentTypeEnum(request.getPaymentType()).getPaymentType());
            secondOrder.setStoneId(storeId);
            secondOrder.setHfRemark(request.getRemark());
            secondOrder.setPayOrderId(secondPayOrder.getId());
            secondOrder.setCreateTime(LocalDateTime.now());
            secondOrder.setModifyTime(LocalDateTime.now());
            secondOrder.setIsDeleted((byte) 0);
            SecondStore secondStore = secondStoreMapper.selectByPrimaryKey(storeId);
            secondOrder.setOrderType(secondStore.getStoreType());
            secondOrderMapper.insertSelective(secondOrder);
            //地址，不支持购物车情况每次一件商品
            SecondGoods secondGoods = secondGoodsMapper.selectByPrimaryKey(goodsList.get(0).getGoodsId());
            SecondProduct secondProduct = secondProductMapper.selectByPrimaryKey(secondGoods.getProductId());
            if (secondGoods.getGoodsResp()==0){
                secondProduct.setProductState(ProductEnum.ProductState.SELLOUT.getState());
                secondProductMapper.updateByPrimaryKeySelective(secondProduct);
            }
            SecondProductAddressExample secondProductAddressExample = new SecondProductAddressExample();
            secondProductAddressExample.createCriteria().andProductIdEqualTo(secondProduct.getId())
                    .andIsDeletedEqualTo((short) 0);
            List<SecondProductAddress> secondProductAddresses =
            secondProductAddressMapper.selectByExample(secondProductAddressExample);
            //添加商品地址
            SecondOrderAddress secondOrderAddress = new SecondOrderAddress();
            secondOrderAddress.setOrderId(secondOrder.getId());
            secondOrderAddress.setSecondProvince(secondProductAddresses.get(0).getSecondProvince());
            secondOrderAddress.setSecondCity(secondProductAddresses.get(0).getSecondCity());
            secondOrderAddress.setSecondConty(secondProductAddresses.get(0).getContact());
            secondOrderAddress.setSecondConty(secondProductAddresses.get(0).getSecondConty());
            secondOrderAddress.setSecondAddressDetail(secondProductAddresses.get(0).getSecondAddressDetail());
            secondOrderAddress.setLongitude(secondProductAddresses.get(0).getLongitude());
            secondOrderAddress.setLatitude(secondProductAddresses.get(0).getLatitude());
            secondOrderAddress.setContact(secondProductAddresses.get(0).getContact());
            secondOrderAddress.setPhone(secondProductAddresses.get(0).getPhoneNumber());
            secondOrderAddress.setSecondDesc(secondProductAddresses.get(0).getSecondDesc());
            secondOrderAddress.setCreateTime(LocalDateTime.now());
            secondOrderAddress.setModifyTime(LocalDateTime.now());
            secondOrderAddress.setIsDeleted((short) 0);
            secondOrderAddressMapper.insertSelective(secondOrderAddress);
            //详情
            secondOrderDetails.forEach(secondOrderDetail -> {
                secondOrderDetail.setOrderId(secondOrder.getId());
                secondOrderDetailMapper.insertSelective(secondOrderDetail);
            });
        }
        SecondOrderExample secondOrderExample  = new SecondOrderExample();
        secondOrderExample.createCriteria().andPayOrderIdEqualTo(secondPayOrder.getId());
        List<SecondOrder> secondOrders = secondOrderMapper.selectByExample(secondOrderExample);
        Integer sum = secondOrders.stream().mapToInt(SecondOrder::getAmount).sum();
        secondPayOrder.setAmount(sum);
        secondPayOrder.setActualPrice(sum);
        secondPayOrderMapper.updateByPrimaryKeySelective(secondPayOrder);
        return builder.body(ResponseUtils.getResponseBody(secondPayOrder));
    }
    @ApiOperation(value = "校检库存", notes = "校检库存")
    @RequestMapping(value = "/checkResp", method = RequestMethod.POST)
    public List<goods> checkResp(String goodsList)
            throws JSONException {
        JSONArray jsonArray= JSONArray.parseArray(goodsList);
        List<goods> list = JSONObject.parseArray(jsonArray.toJSONString(), goods.class);
        List<goods> goods = new ArrayList<>();
        list.forEach(lists->{
            SecondGoods secondGoods = secondGoodsMapper.selectByPrimaryKey(lists.getGoodsId());
            if (secondGoods.getGoodsResp()<lists.getQuantity()) {
                goods goods1 = new goods();
                goods1.setGoodsId(lists.getGoodsId());
                goods1.setStoneId(lists.getStoneId());
                goods.add(goods1);
            }
        });
        return goods;
    }

    @RequestMapping(path = "/selectOrder", method = RequestMethod.GET)
    @ApiOperation(value = "查询订单", notes = "查询订单")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "orderType", value = "订单类型,user,store", required = true, type = "String"),
            @ApiImplicitParam(paramType = "query", name = "OrderStatus", value = "订单状态", required = true, type = "String"),
            @ApiImplicitParam(paramType = "query", name = "sonId", value = "子站点id", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "userId", value = "用户id", required = true, type = "Integer"),
    })
    public ResponseEntity<JSONObject> selectOrder(String orderType,String OrderStatus,Integer sonId,Integer userId) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder();
        SecondOrderExample secondOrderExample = new SecondOrderExample();
        if (OrderStatus.equals(OrderEnum.OrderStatus.ALL.getOrderStatus())){
            secondOrderExample.createCriteria().andIsDeletedEqualTo((byte) 0)
                    .andOrderTypeEqualTo(orderType);
            if (userId!=null){
                secondOrderExample.createCriteria().andUserIdEqualTo(userId);
            }
        }else{
            secondOrderExample.createCriteria().andIsDeletedEqualTo((byte) 0)
                    .andOrderTypeEqualTo(orderType)
            .andOrderStatusEqualTo(OrderStatus);
            if (userId!=null){
                secondOrderExample.createCriteria().andUserIdEqualTo(userId);
            }
        }
        List<SecondOrder> secondOrders = secondOrderMapper.selectByExample(secondOrderExample);
        List<OrderList> orderLists = new ArrayList<>();
        secondOrders.forEach(secondOrder -> {
            SecondUserSonExample secondUserSonExample = new SecondUserSonExample();
            secondUserSonExample.createCriteria().andStoreIdEqualTo(secondOrder.getStoneId())
            .andIsDeletedEqualTo((byte) 0);
            List<SecondUserSon> secondUserSons =
            secondUserSonMapper.selectByExample(secondUserSonExample);
            //站点
            SecondSon secondSon = new SecondSon();
            if (secondUserSons.size()!=0){
                secondSon = secondSonMapper.selectByPrimaryKey(secondUserSons.get(0).getSonId());
            }

            OrderList orderList = new OrderList();
            if (secondSon.getId()!=null){
                orderList.setSonId(secondSon.getId());
            } else {
                orderList.setSonId(0);
            }
            orderList.setOrderStatus(secondOrder.getOrderStatus());
            orderList.setOrderCode(secondOrder.getOrderCode());
            orderList.setOrderId(secondOrder.getId());
            orderList.setStoreId(secondOrder.getStoneId());
            SecondStore secondStore = secondStoreMapper.selectByPrimaryKey(secondOrder.getStoneId());
            orderList.setStoreName(secondStore.getStoreName());
            orderList.setCreateTime(secondStore.getCreateTime());
            orderList.setUserId(secondOrder.getUserId());
            SecondUser secondUser = secondUserMapper.selectByPrimaryKey(secondOrder.getUserId());
            orderList.setNickName(secondUser.getNickName());
            SecondOrderDetailExample secondOrderDetailExample = new SecondOrderDetailExample();
            secondOrderDetailExample.createCriteria().andOrderIdEqualTo(secondOrder.getId());
            List<SecondOrderDetail> secondOrderDetails =
            secondOrderDetailMapper.selectByExample(secondOrderDetailExample);
            List<OrderProductList> orderProductLists = new ArrayList<>();
            secondOrderDetails.forEach(secondOrderDetail -> {
                OrderProductList orderProductList = new OrderProductList();
                orderProductList.setOrderDetails(secondOrderDetail.getId());
                orderProductList.setGoodsId(secondOrderDetail.getGoodsId());
                SecondGoods secondGoods = secondGoodsMapper.selectByPrimaryKey(secondOrderDetail.getGoodsId());
                orderProductList.setProductId(secondGoods.getProductId());
                orderProductList.setSellPrice(secondGoods.getSellPrice());
                orderProductList.setLinePrice(secondGoods.getLinePrice());
                SecondProduct secondProduct = secondProductMapper.selectByPrimaryKey(secondGoods.getProductId());
                orderProductList.setProductName(secondProduct.getProductName());
                orderProductList.setProductDesc(secondProduct.getProductDesc());
                orderProductList.setProuctFile(secondProduct.getFile());
                orderProductList.setIsPutaway(secondProduct.getIsPutaway());
                orderProductList.setProductState(secondProduct.getProductState());
                orderProductList.setQuantity(secondOrderDetail.getQuantity());
                orderProductLists.add(orderProductList);
            });
            orderList.setOrderProductLists(orderProductLists);
            orderLists.add(orderList);
        });
        //删选站点订单
        if (sonId!=null){
            List<OrderList> orderLists1
                    = orderLists.stream().filter(a-> a.getSonId().equals(sonId)).collect(Collectors.toList());
            return builder.body(ResponseUtils.getResponseBody(orderLists1));
        }
        return builder.body(ResponseUtils.getResponseBody(orderLists));
    }

    /**
     * 修改订单状态
     * @param orderId
     * @param orderCode
     * @param originalOrderStatus
     * @param targetOrderStatus
     * @return
     * @throws JSONException
     */
    @ApiOperation(value = "修改订单状态", notes = "修改订单状态")
    @RequestMapping(value = "/updateOrder", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "orderId", value = "订单id", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "orderCode", value = "订单号", required = true, type = "String"),
            @ApiImplicitParam(paramType = "query", name = "originalOrderStatus", value = "原始订单状态", required = true, type = "String"),
            @ApiImplicitParam(paramType = "query", name = "targetOrderStatus", value = "目标的订单状态", required = true, type = "String"),
    })
    public ResponseEntity<JSONObject> updateOrder(Integer orderId,
                                                  String orderCode,
                                                  String originalOrderStatus,
                                                  String targetOrderStatus
    )
            throws JSONException {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder();
        SecondOrderExample secondOrderExample = new SecondOrderExample();
        secondOrderExample.createCriteria()
                .andIdEqualTo(orderId)
                .andOrderCodeEqualTo(orderCode)
                .andOrderStatusEqualTo(originalOrderStatus)
                .andIsDeletedEqualTo((byte) 0);
        List<SecondOrder> secondOrders
                = secondOrderMapper.selectByExample(secondOrderExample);

        SecondOrder secondOrder = new SecondOrder();
        if (secondOrders.size()!=0){
            secondOrder.setOrderStatus(targetOrderStatus);
            secondOrder.setCreateTime(LocalDateTime.now());
            secondOrderMapper.updateByExampleSelective(secondOrder,secondOrderExample);
            /**
             * 确认收货
             */
            if (originalOrderStatus.equals(OrderEnum.OrderStatus.TRANSPORT.getOrderStatus())
                    && targetOrderStatus.equals(OrderEnum.OrderStatus.EVALUATE.getOrderStatus())){
                balanceService.addBalance(secondOrders.get(0).getUserId(),
                        secondOrders.get(0).getStoneId(),
                        BanlaceEnum.Relation.MONEY.getState(),
                        secondOrders.get(0).getAmount());
            }
            return builder.body(ResponseUtils.getResponseBody(0));
        }

        return builder.body(ResponseUtils.getResponseBody(1));
    }

    public static void main(String[] args) {
        InetAddress ip = null;
               try {
                   ip=ip.getLocalHost();
                        String localname=ip.getHostName();
                        String localip=ip.getHostAddress();
                        System.out.println("本机名称是："+ localname);
                        System.out.println("本机的ip是 ："+localip);
                   } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                     }
    }
}
