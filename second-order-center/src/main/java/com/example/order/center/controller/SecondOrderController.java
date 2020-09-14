package com.example.order.center.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.order.center.dao.*;
import com.example.order.center.manual.CreateOrderRequest;
import com.example.order.center.manual.OrderEnum;
import com.example.order.center.manual.goods;
import com.example.order.center.model.*;
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
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    //店铺地址
    @Autowired
    private SecondStoreMapper secondStoreMapper;
    //订单地址
    @Autowired
    private SecondOrderAddressMapper secondOrderAddressMapper;

    @RequestMapping(path = "/addOrder", method = RequestMethod.POST)
    @ApiOperation(value = "创建订单", notes = "创建订单")
    public ResponseEntity<JSONObject> addCategory(CreateOrderRequest request, HttpServletRequest requests, HttpServletResponse response) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder();
        List list = checkResp(request.getGoodsList());
                if(list.size()!=0){
                    response.sendError(HttpStatus.FORBIDDEN.value(), "库存不足");
                    return builder.body(ResponseUtils.getResponseBody(list));
                }
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
        //
        JSONArray jsonArray= JSONArray.parseArray(request.getGoodsList());
        List<goods> list1 = JSONObject.parseArray(jsonArray.toJSONString(), goods.class);
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
            secondOrderMapper.insertSelective(secondOrder);
            //地址，不支持购物车情况每次一件商品
            SecondGoods secondGoods = secondGoodsMapper.selectByPrimaryKey(goodsList.get(0).getGoodsId());
            SecondProduct secondProduct = secondProductMapper.selectByPrimaryKey(secondGoods.getProductId());
            secondStoreMapper.selectByPrimaryKey(secondProduct.getAddressId());
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
        return builder.body(ResponseUtils.getResponseBody(0));
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
            }
        });
        return goods;
    }
    private void detailNomalOrders(SecondOrder request) {

    }
}
