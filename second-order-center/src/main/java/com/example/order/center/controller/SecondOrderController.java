package com.example.order.center.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.order.center.dao.*;
import com.example.order.center.manual.*;
import com.example.order.center.model.*;
import com.example.order.center.service.BalanceService;
import com.example.order.center.service.Impl.PayOrderServiceImpl;
import com.example.order.center.service.PayOrderService;
import com.second.common.utils.PageTool;
import com.second.utils.response.handler.ResponseEntity;
import com.second.utils.response.handler.ResponseUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.time.FastDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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
    @Resource
    private RedisTemplate<String, Object> redisTemplate;
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
    private SecondStoreAddressMapper secondStoreAddressMapper;
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
    //余额明细
    @Autowired
    private SecondStoreBalanceDetailMapper secondStoreBalanceDetailMapper;
    //视频商品
    @Autowired
    private SecondProductVideoMapper secondProductVideoMapper;
    //视频订单
    @Autowired
    private SecondOrderVideoMapper secondOrderVideoMapper;
    @RequestMapping(path = "/addOrder", method = RequestMethod.POST)
    @ApiOperation(value = "创建订单", notes = "创建订单")
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public ResponseEntity<JSONObject> addCategory(CreateOrderRequest request, HttpServletRequest requests, HttpServletResponse response) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder();

        SecondStoreExample secondStoreExample = new SecondStoreExample();
        secondStoreExample.createCriteria().andUserIdEqualTo(request.getUserId())
                .andIsDeletedEqualTo((short) 0);
        List<SecondStore> secondStores = secondStoreMapper.selectByExample(secondStoreExample);
        if (!secondStores.get(0).getSecondStatus().equals(Authentication.State.PASS.getState())){
            response.sendError(HttpStatus.FORBIDDEN.value(), "没有认证");
            return builder.body(ResponseUtils.getResponseBody(1));
        }
        List list = checkResp(request.getGoodsList());

        System.out.println(list);
                if(list.size()!=0){
                    response.sendError(HttpStatus.FORBIDDEN.value(), "库存不足,或者商品已经卖出");
                    return builder.body(ResponseUtils.getResponseBody(list));
                }
        //
        JSONArray jsonArray= JSONArray.parseArray(request.getGoodsList());
        List<goods> list1 = JSONObject.parseArray(jsonArray.toJSONString(), goods.class);
                //扣减库存
//        list1.forEach(good->{
        for (goods good: list1){
           int a=  payOrderService.stock(good.getQuantity(),good.getGoodsId());
            if (a<=0){
                response.sendError(HttpStatus.FORBIDDEN.value(), "库存不足,或者商品已经卖出");
                return builder.body(ResponseUtils.getResponseBody(list));
            }
        };
                //支付订单
        SecondPayOrder secondPayOrder = new SecondPayOrder();
        secondPayOrder.setType(OrderEnum.PayType.ORDER.getPayTypeType());
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
            //地址 地址id为空说明是商家创建订单 不为空用户创建订单
            if (request.getAddressId() ==null){
                SecondProductAddressExample secondProductAddressExample = new SecondProductAddressExample();
                secondProductAddressExample.createCriteria().andProductIdEqualTo(secondProduct.getId())
                        .andIsDeletedEqualTo((short) 0);
                List<SecondProductAddress> secondProductAddresses =
                        secondProductAddressMapper.selectByExample(secondProductAddressExample);
                //添加订单地址
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
            } else {
                SecondStoreAddress secondStoreAddress = secondStoreAddressMapper.selectByPrimaryKey(request.getAddressId());
                SecondOrderAddress secondOrderAddress = new SecondOrderAddress();
                secondOrderAddress.setOrderId(secondOrder.getId());
                secondOrderAddress.setSecondProvince(secondStoreAddress.getSecondProvince());
                secondOrderAddress.setSecondCity(secondStoreAddress.getSecondCity());
                secondOrderAddress.setSecondConty(secondStoreAddress.getContact());
                secondOrderAddress.setSecondConty(secondStoreAddress.getSecondConty());
                secondOrderAddress.setSecondAddressDetail(secondStoreAddress.getSecondAddressDetail());
                secondOrderAddress.setLongitude(secondStoreAddress.getLongitude());
                secondOrderAddress.setLatitude(secondStoreAddress.getLatitude());
                secondOrderAddress.setContact(secondStoreAddress.getContact());
                secondOrderAddress.setPhone(secondStoreAddress.getPhoneNumber());
                secondOrderAddress.setSecondDesc(secondStoreAddress.getSecondDesc());
                secondOrderAddress.setCreateTime(LocalDateTime.now());
                secondOrderAddress.setModifyTime(LocalDateTime.now());
                secondOrderAddress.setIsDeleted((short) 0);
                secondOrderAddressMapper.insertSelective(secondOrderAddress);
            }

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
            //判断库存
            SecondGoods secondGoods = secondGoodsMapper.selectByPrimaryKey(lists.getGoodsId());
            if (secondGoods.getGoodsResp()<lists.getQuantity()) {
                goods goods1 = new goods();
                goods1.setGoodsId(lists.getGoodsId());
                goods1.setStoneId(lists.getStoneId());
                goods.add(goods1);
            }
            //判断商品是否卖出
            SecondProduct secondProduct = secondProductMapper.selectByPrimaryKey(secondGoods.getProductId());
            if (secondProduct.getProductState().equals(ProductEnum.ProductState.SELLOUT.getState())){
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
            @ApiImplicitParam(paramType = "query", name = "sonId", value = "子站点id", required = false, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "userId", value = "用户id", required = false, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "storeId", value = "所属的店铺id 和userId只需填一个", required = false, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "showType", value = "商品展示类型", required = true, type = "String"),
    })
    public ResponseEntity<JSONObject> selectOrder(String orderType,String OrderStatus,Integer sonId,Integer userId,String showType,Integer storeId) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder();
        SecondOrderExample secondOrderExample = new SecondOrderExample();
        secondOrderExample.setOrderByClause("create_time desc");
        if (OrderStatus.equals(OrderEnum.OrderStatus.ALL.getOrderStatus())){
            SecondOrderExample.Criteria criteria = secondOrderExample.createCriteria().andIsDeletedEqualTo((byte) 0)
                    .andOrderStatusNotEqualTo(OrderEnum.OrderStatus.PAYMENT.getOrderStatus())
                    .andOrderTypeEqualTo(orderType);
            if (userId!=null){
                criteria.andUserIdEqualTo(userId);
            }
            if (storeId!=null){
                criteria.andStoneIdEqualTo(storeId);
            }
        }else{
            SecondOrderExample.Criteria criteria = secondOrderExample.createCriteria().andIsDeletedEqualTo((byte) 0)
                    .andOrderTypeEqualTo(orderType)
            .andOrderStatusEqualTo(OrderStatus);
            if (userId!=null){
                criteria.andUserIdEqualTo(userId);
            }
        }
        List<SecondOrder> secondOrders = secondOrderMapper.selectByExample(secondOrderExample);
        List<OrderList> orderLists = new ArrayList<>();
        secondOrders.forEach(secondOrder -> {
            SecondStore secondStore = secondStoreMapper.selectByPrimaryKey(secondOrder.getStoneId());
            SecondUserSonExample secondUserSonExample = new SecondUserSonExample();
            secondUserSonExample.createCriteria().andStoreIdEqualTo(secondOrder.getStoneId())
            .andIsDeletedEqualTo((byte) 0)
            .andUserIdEqualTo(secondStore.getUserId());
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
            orderList.setPayOrderId(secondOrder.getPayOrderId());
            orderList.setOrderStatus(secondOrder.getOrderStatus());
            orderList.setOrderCode(secondOrder.getOrderCode());
            orderList.setOrderId(secondOrder.getId());
            orderList.setStoreId(secondOrder.getStoneId());

            SecondOrderAddressExample secondOrderAddressExample = new SecondOrderAddressExample();
            secondOrderAddressExample.createCriteria()
                    .andOrderIdEqualTo(secondOrder.getId())
                    .andIsDeletedEqualTo((short) 0);
            List<SecondOrderAddress> secondOrderAddresses
                    =secondOrderAddressMapper.selectByExample(secondOrderAddressExample);
            if (secondOrderAddresses.size()!=0){
                orderList.setNameAddress(secondOrderAddresses.get(0).getContact());
                orderList.setPhoneAddress(secondOrderAddresses.get(0).getPhone());
                orderList.setStoreAddress(secondOrderAddresses.get(0).getSecondAddressDetail());
            }
            orderList.setStoreName(secondStore.getStoreName());
            orderList.setCreateTime(secondStore.getCreateTime());
            orderList.setStoreUserId(secondStore.getUserId());
            SecondUser secondUser1 = secondUserMapper.selectByPrimaryKey(secondStore.getUserId());
            orderList.setStoreUserFile(secondUser1.getFile());
            orderList.setStoreNickName(secondUser1.getNickName());

            orderList.setUserId(secondOrder.getUserId());
            SecondUser secondUser = secondUserMapper.selectByPrimaryKey(secondOrder.getUserId());
            orderList.setNickName(secondUser.getNickName());
            orderList.setUserFile(secondUser.getFile());
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
                orderProductList.setShowType(secondProduct.getShowType());
                orderProductList.setProductType(secondProduct.getProductType());
                orderProductLists.add(orderProductList);
            });
            orderList.setOrderProductLists(orderProductLists);
            orderLists.add(orderList);
        });
        List<OrderList> orderLists2 = orderLists.stream().filter(a-> a.getOrderProductLists().get(0).getShowType().equals(showType)).collect(Collectors.toList());
        //筛选站点订单
        if (sonId!=null){
            List<OrderList> orderLists1
                    = orderLists2.stream().filter(a-> a.getSonId().equals(sonId)).collect(Collectors.toList());
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
            @ApiImplicitParam(paramType = "query", name = "productName", value = "商品名称", required = true, type = "String"),
    })
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public ResponseEntity<JSONObject> updateOrder(Integer orderId,
                                                  String orderCode,
                                                  String originalOrderStatus,
                                                  String productName,
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
            /**
             * 退款处理
             */
            if (originalOrderStatus.equals(OrderEnum.OrderStatus.CONTROVERSIAL.getOrderStatus())
                    && targetOrderStatus.equals("refuse")){
                //拒绝退款 返回原始订单状态
                secondOrder.setOrderStatus(String.valueOf(redisTemplate.opsForValue().get("refund"+String.valueOf(orderId))));
            }else {
                secondOrder.setOrderStatus(targetOrderStatus);
            }

            secondOrder.setModifyTime(LocalDateTime.now());
            secondOrderMapper.updateByExampleSelective(secondOrder,secondOrderExample);
            /**
             * 确认收货
             */
            if (originalOrderStatus.equals(OrderEnum.OrderStatus.TRANSPORT.getOrderStatus())
                    && targetOrderStatus.equals(OrderEnum.OrderStatus.EVALUATE.getOrderStatus())){
                //店铺余额加-加入记录
                balanceService.addBalance(
                        secondOrders.get(0).getStoneId(),
                        BanlaceEnum.Relation.MONEY.getState(),
                        secondOrders.get(0).getAmount());
                SecondStoreBalanceDetail secondStoreBalanceDetail = new SecondStoreBalanceDetail();
                secondStoreBalanceDetail.setPayName("订单");
                secondStoreBalanceDetail.setPayDesc(productName);
                secondStoreBalanceDetail.setAmount(secondOrders.get(0).getAmount());
                secondStoreBalanceDetail.setDetailType(BanlaceEnum.Relation.MONEY.getState());
                secondStoreBalanceDetail.setIncomeExpenses(BanlaceEnum.incomeExpenses.PUT.getState());
                secondStoreBalanceDetail.setStoreId(secondOrders.get(0).getStoneId());
                SecondStore secondStore = secondStoreMapper.selectByPrimaryKey(secondOrders.get(0).getStoneId());
                secondStoreBalanceDetail.setUserId(secondStore.getUserId());
                secondStoreBalanceDetail.setCreateTime(LocalDateTime.now());
                secondStoreBalanceDetail.setModifyTime(LocalDateTime.now());
                secondStoreBalanceDetail.setIsDeleted((short) 0);
                secondStoreBalanceDetailMapper.insertSelective(secondStoreBalanceDetail);
                //购买商品后用户加积分-加入记录
                SecondStoreExample secondStoreExample = new SecondStoreExample();
                secondStoreExample.createCriteria().andIsDeletedEqualTo((short) 0)
                        .andUserIdEqualTo(secondOrders.get(0).getUserId())
                        .andSecondStatusEqualTo(0);
                List<SecondStore> secondStores = secondStoreMapper.selectByExample(secondStoreExample);
                balanceService.addBalance(secondStores.get(0).getId(),
                                          BanlaceEnum.Relation.INTEGRAL.getState(),
                                          secondOrders.get(0).getAmount());
                secondStoreBalanceDetail.setAmount(secondOrders.get(0).getAmount());
                secondStoreBalanceDetail.setDetailType(BanlaceEnum.Relation.INTEGRAL.getState());
                secondStoreBalanceDetail.setIncomeExpenses(BanlaceEnum.incomeExpenses.PUT.getState());
                secondStoreBalanceDetail.setStoreId(secondStores.get(0).getId());
                secondStoreBalanceDetail.setUserId(secondOrders.get(0).getUserId());
                secondStoreBalanceDetail.setCreateTime(LocalDateTime.now());
                secondStoreBalanceDetail.setModifyTime(LocalDateTime.now());
                secondStoreBalanceDetail.setIsDeleted((short) 0);
                secondStoreBalanceDetailMapper.insertSelective(secondStoreBalanceDetail);
            }
            /**
             * 申请退款
             */
            if (targetOrderStatus.equals(OrderEnum.OrderStatus.CONTROVERSIAL.getOrderStatus())){
                redisTemplate.opsForValue().set("refund"+String.valueOf(orderId),secondOrders.get(0).getOrderStatus());
            }

            return builder.body(ResponseUtils.getResponseBody(0));
        }

        return builder.body(ResponseUtils.getResponseBody(1));
    }
    @ApiOperation(value = "创建视频会员订单", notes = "创建视频会员订单")
    @RequestMapping(value = "/addVideoOrder", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "userId", value = "用户id", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "productId", value = "视频商品id", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "quantity", value = "购买数量", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "remark", value = "订单备注", required = true, type = "String"),
            @ApiImplicitParam(paramType = "query", name = "paymentType", value = "支付类型", required = true, type = "String"),
            @ApiImplicitParam(paramType = "query", name = "uid", value = "充值账号", required = true, type = "String"),
    })
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public ResponseEntity<JSONObject> addVideoOrder(
            @RequestParam(value = "userId", required = false) Integer userId,
            @RequestParam(value = "productId", required = false) Integer productId,
            @RequestParam(value = "quantity", required = false) Integer quantity,
            @RequestParam(value = "remark", required = false) String remark,
            @RequestParam(value = "paymentType", required = false) String paymentType,
            @RequestParam(value = "uid", required = false) String uid,
            HttpServletResponse response
    ) throws Exception {
        //
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder(HttpStatus.OK);
        synchronized(this){
            SecondProductVideo secondProductVideo = secondProductVideoMapper.selectByPrimaryKey(productId);
            if (secondProductVideo.getIsPutaway().equals(ProductEnum.IsPutaway.PUTAWAY.getState())
            && secondProductVideo.getProductState().equals(ProductEnum.ProductState.SELL.getState())
            && secondProductVideo.getIsDeleted() == 0){
                if (payOrderService.stockVideo(quantity,productId)>0){
                    SecondPayOrder secondPayOrder = new SecondPayOrder();
                    secondPayOrder.setPayCode(getC("video"));
                    secondPayOrder.setUserId(userId);
                    secondPayOrder.setType(OrderEnum.PayType.VIDEO.getPayTypeType());//OrderEnum.PayType.VIDEO.getPayTypeType()
                    System.out.println(OrderEnum.PayType.VIDEO.getPayTypeType());
                    System.out.println(secondPayOrder.getType());
                    secondPayOrder.setPayStatus(OrderEnum.PaymentStatus.UNPAID.getPaymentStatus());
                    secondPayOrder.setPaymentName(paymentType);
                    secondPayOrder.setCreateTime(LocalDateTime.now());
                    secondPayOrder.setModifyTime(LocalDateTime.now());
                    secondPayOrder.setIsDeleted((byte) 0);
                    secondPayOrder.setAmount(secondProductVideo.getPrice());
                    secondPayOrder.setActualPrice(secondProductVideo.getPrice());
                    secondPayOrderMapper.insertSelective(secondPayOrder);
                    //创建订单
                    SecondOrderVideo secondOrder = new SecondOrderVideo();
                    secondOrder.setOrderCode(getC(UUID.randomUUID().toString()));
                    secondOrder.setUserId(userId);
                    secondOrder.setPayStatus(OrderEnum.PaymentStatus.UNPAID.getPaymentStatus());
                    secondOrder.setOrderStatus(OrderEnum.OrderStatus.PAYMENT.getOrderStatus());
                    secondOrder.setPaymentName(paymentType);
                    secondOrder.setAmount(secondProductVideo.getPrice());
                    secondOrder.setPracticalAmount(secondProductVideo.getPrice());
                    secondOrder.setPaymentType(OrderEnum.PaymentType.getPaymentTypeEnum(paymentType).getPaymentType());
                    secondOrder.setHfRemark(remark);
                    secondOrder.setPayOrderId(secondPayOrder.getId());
                    secondOrder.setCreateTime(LocalDateTime.now());
                    secondOrder.setModifyTime(LocalDateTime.now());
                    secondOrder.setIsDeleted((byte) 0);
                    secondOrder.setVideoId(productId);
                    secondOrder.setUid(uid);
                    if (quantity==null){
                        quantity = 1;
                    }
                    secondOrder.setAmt(quantity);
                    secondOrderVideoMapper.insertSelective(secondOrder);
                    return builder.body(ResponseUtils.getResponseBody(secondPayOrder));
                }else {
                    response.sendError(HttpStatus.FORBIDDEN.value(), "库存不足");
                    return builder.body(ResponseUtils.getResponseBody(1));
                }
            }
        }
        return builder.body(ResponseUtils.getResponseBody(0));
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
