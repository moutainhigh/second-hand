package com.example.order.center.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.order.center.dao.SecondOrderMapper;
import com.example.order.center.dao.SecondUserMapper;
import com.example.order.center.dao.SecondUserSonMapper;
import com.example.order.center.manual.Authentication;
import com.example.order.center.manual.OrderEnum;
import com.example.order.center.manual.Statistics.*;
import com.example.order.center.model.*;
import com.example.order.center.service.StatisticsService;
import com.google.common.collect.Lists;
import com.second.utils.response.handler.ResponseEntity;
import com.second.utils.response.handler.ResponseUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;

/**
 * @author shihao
 * @Title: StatisticsController
 * @ProjectName Second-order-center
 * @Description: 数据统计
 * @date Created in
 * @Version: $
 */
@RestController
@Api
@RequestMapping("/Statistics")
@CrossOrigin
public class StatisticsController {
    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {
        //转换日期
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// CustomDateEditor为自定义日期编辑器
    }
    //用户
    @Autowired
    private SecondUserMapper secondUserMapper;
    //订单
    @Autowired
    private SecondOrderMapper secondOrderMapper;
    //
    @Autowired
    private StatisticsService statisticsService;
    @Autowired
    private SecondUserSonMapper secondUserSonMapper;
    @ApiOperation(value = "用户统计", notes = "用户统计")
//    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    @RequestMapping(value = "/userStatistics", method = RequestMethod.GET)
    public ResponseEntity<JSONObject> userStatistics(Date startTime,
                                                     Date endTime,
                                                     Integer sonId
    )
            throws JSONException {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder();
        SecondUserExample secondUserExample = new SecondUserExample();
        SecondUserExample.Criteria criteria =  secondUserExample.createCriteria()
                .andIdDeletedEqualTo((byte) 0);

        if (startTime!=null && endTime!=null){
            Instant instant = startTime.toInstant();//开始时间
            Instant instant1 = endTime.toInstant();//结束时间
            //date转LocalDateTime
            ZoneId zoneId = ZoneId.systemDefault();
            LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();
            LocalDateTime localDateTime1 = instant1.atZone(zoneId).toLocalDateTime();
            criteria.andCreateDateGreaterThanOrEqualTo(localDateTime)
                    .andCreateDateLessThanOrEqualTo(localDateTime1);
        }

        List<SecondUser> secondUsers =
        secondUserMapper.selectByExample(secondUserExample);
        StatisticsUserList statisticsUserList = new StatisticsUserList();
        statisticsUserList.setUserNumber(secondUsers.size());
        //筛选用户未审核的数量
        List<SecondUser> secondUsers1 = secondUsers.stream()
                .filter(a->a.getUserType().equals(Authentication.LoginType.USERWX.getState())
                && a.getIsAuthentication().equals(Authentication.UserState.NOPASS.getState()))
                .collect(Collectors.toList());
        statisticsUserList.setUserGeneral(secondUsers1.size());
        //筛选认证的用户
        List<SecondUser> secondUsers2 = secondUsers.stream()
                .filter(a->a.getUserType().equals(Authentication.LoginType.USERWX.getState())
                        && a.getIsAuthentication().equals(Authentication.UserState.PASS.getState()))
                .collect(Collectors.toList());
        if (sonId!=null){
            SecondUserSonExample secondUserSonExample = new SecondUserSonExample();
            secondUserSonExample.createCriteria().andSonIdEqualTo(sonId)
                    .andIsDeletedEqualTo((byte) 0);
            List<SecondUserSon> secondUserSons =
            secondUserSonMapper.selectByExample(secondUserSonExample);
            List<Integer>  userIntList=secondUserSons.stream().map(SecondUserSon::getUserId).collect(Collectors.toList());
            secondUsers2 = secondUsers2.stream().filter(s -> userIntList.contains(s.getId())).collect(Collectors.toList());
        }
        statisticsUserList.setUserAuthentication(secondUsers2.size());
        //筛选商家店铺用户
        List<SecondUser> secondUsers3 = secondUsers.stream()
                .filter(a->a.getUserType().equals(Authentication.LoginType.STOREWX.getState())
                        && a.getIsAuthentication().equals(Authentication.UserState.PASS.getState()))
                .collect(Collectors.toList());
        statisticsUserList.setUserStore(secondUsers3.size());
        return builder.body(ResponseUtils.getResponseBody(statisticsUserList));
    }
    //订单
    @ApiOperation(value = "订单统计", notes = "订单统计")
    @RequestMapping(value = "/orderStatistics", method = RequestMethod.GET)
    public ResponseEntity<JSONObject> orderStatistics(Date startTime,
                                                     Date endTime,
                                                      Integer sonId
    )
            throws JSONException {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder();
        SecondOrderExample secondOrderExample = new SecondOrderExample();
        SecondOrderExample.Criteria criteria = secondOrderExample.createCriteria()
                .andIsDeletedEqualTo((byte) 0);
        if (startTime!=null && endTime!=null){
            Instant instant = startTime.toInstant();//开始时间
            Instant instant1 = endTime.toInstant();//结束时间
            //date转LocalDateTime
            ZoneId zoneId = ZoneId.systemDefault();
            LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();
            LocalDateTime localDateTime1 = instant1.atZone(zoneId).toLocalDateTime();
            criteria.andCreateTimeGreaterThanOrEqualTo(localDateTime)
                    .andCreateTimeLessThanOrEqualTo(localDateTime1);
        }
        if (sonId!=null){
            SecondUserSonExample secondUserSonExample = new SecondUserSonExample();
            secondUserSonExample.createCriteria().andSonIdEqualTo(sonId)
                    .andIsDeletedEqualTo((byte) 0);
            List<SecondUserSon> secondUserSons =
                    secondUserSonMapper.selectByExample(secondUserSonExample);
            List<Integer>  storeIntList=secondUserSons.stream().map(SecondUserSon::getStoreId).collect(Collectors.toList());
            if (storeIntList.size()==0){
                StatisticsOrderList statisticsOrderList = new StatisticsOrderList();
                statisticsOrderList.setTotal(0);
                statisticsOrderList.setComplete(0);
                statisticsOrderList.setEvaluate(0);
                statisticsOrderList.setPickUp(0);
                statisticsOrderList.setProcess(0);
                statisticsOrderList.setOrderNumber(0);
                return builder.body(ResponseUtils.getResponseBody(statisticsOrderList));
            }
            criteria.andStoneIdIn(Lists.newArrayList(storeIntList));
        }
        List<SecondOrder> secondOrders =
                secondOrderMapper.selectByExample(secondOrderExample);
        StatisticsOrderList statisticsOrderList = new StatisticsOrderList();
        statisticsOrderList.setOrderNumber(secondOrders.size());
        //收入总额
        List<SecondOrder> secondOrders5 =
                secondOrders.stream().filter(
                a->!a.getOrderStatus().equals(OrderEnum.OrderStatus.PAYMENT.getOrderStatus())
                        && !a.getOrderStatus().equals(OrderEnum.OrderStatus.CONTROVERSIAL.getOrderStatus()
                        )&& !a.getOrderStatus().equals(OrderEnum.OrderStatus.CANCEL.getOrderStatus())
                )
                        .collect(Collectors.toList());
        Integer tolal = secondOrders5.stream().mapToInt(SecondOrder::getAmount).sum();
        statisticsOrderList.setTotal(tolal);
        //待发货
        List<SecondOrder> secondOrders1 = secondOrders.stream().filter(
                a->a.getOrderStatus().equals(OrderEnum.OrderStatus.PROCESS.getOrderStatus())
        ).collect(Collectors.toList());
        statisticsOrderList.setProcess(secondOrders1.size());
        //待提货
        List<SecondOrder> secondOrders2 = secondOrders.stream().filter(
                a->a.getOrderStatus().equals(OrderEnum.OrderStatus.TRANSPORT.getOrderStatus())
        ).collect(Collectors.toList());
        statisticsOrderList.setPickUp(secondOrders2.size());
        //待评价
        List<SecondOrder> secondOrders3 = secondOrders.stream().filter(
                a->a.getOrderStatus().equals(OrderEnum.OrderStatus.EVALUATE.getOrderStatus())
        ).collect(Collectors.toList());
        statisticsOrderList.setEvaluate(secondOrders3.size());
        //已完成
        List<SecondOrder> secondOrders4 = secondOrders.stream().filter(
                a->a.getOrderStatus().equals(OrderEnum.OrderStatus.COMPLETE.getOrderStatus())
        ).collect(Collectors.toList());
        statisticsOrderList.setComplete(secondOrders4.size());
        return builder.body(ResponseUtils.getResponseBody(statisticsOrderList));
    }
    //商品统计后台
    @ApiOperation(value = "商品统计", notes = "商品统计")
    @RequestMapping(value = "/productStatistics", method = RequestMethod.GET)
    public ResponseEntity<JSONObject> productStatistics(Date startTime,
                                                      Date endTime
    )
            throws JSONException {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder();
        SecondProductExample secondProductExample = new SecondProductExample();
        SecondProductExample.Criteria criteria = secondProductExample.createCriteria()
                .andIsDeletedEqualTo((short) 0);
        if (startTime!=null && endTime!=null){
            Instant instant = startTime.toInstant();//开始时间
            Instant instant1 = endTime.toInstant();//结束时间
            //date转LocalDateTime
            ZoneId zoneId = ZoneId.systemDefault();
            LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();
            LocalDateTime localDateTime1 = instant1.atZone(zoneId).toLocalDateTime();
            criteria.andCreateTimeGreaterThanOrEqualTo(localDateTime)
                    .andCreateTimeLessThanOrEqualTo(localDateTime1);
        }
        return builder.body(ResponseUtils.getResponseBody(0));
    }

    //商家端小程序统计
    @ApiOperation(value = "商品统计", notes = "商品统计")
    @RequestMapping(value = "/MiniStore", method = RequestMethod.GET)
    public ResponseEntity<JSONObject> MiniStore(Integer storeId)
            throws JSONException {
                ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder();
                List<StatisticsAmount> statisticsAmounts =
                statisticsService.dataAmount(storeId);
        //        //每天最大收入
        Optional<Integer> max = statisticsAmounts.stream()
                .map(StatisticsAmount::getAmount).reduce(Integer::max);
        //日均收入
        double avg = statisticsAmounts.stream()
                .collect(Collectors.averagingInt(StatisticsAmount::getAmount));
        Integer dayAmount = (int) Math.ceil(avg);
        //七日的收入
        List<StatisticsDaySum> statisticsDaySums = statisticsService.dayAmount(storeId);
        StatisticsMiniStore statisticsMiniStore = new StatisticsMiniStore();
        System.out.println(statisticsDaySums.get(0));
        if (statisticsDaySums.size()!=0 && statisticsDaySums.get(0) != null){
            statisticsMiniStore.setSevenAmount(statisticsDaySums.get(0).getSum());
        }else {
            statisticsMiniStore.setSevenAmount(0);
        }
        statisticsMiniStore.setDaySum(dayAmount);
        statisticsMiniStore.setDayMax(max.get());
        SecondOrderExample secondOrderExample = new SecondOrderExample();
        SecondOrderExample.Criteria criteria =
        secondOrderExample.createCriteria()

                .andIsDeletedEqualTo((byte) 0);
        if (storeId!=null){
            criteria.andStoneIdEqualTo(storeId);
        }
//                .andOrderStatusNotEqualTo(OrderEnum.OrderStatus.PAYMENT.getOrderStatus());
        List<SecondOrder> secondOrders =
                secondOrderMapper.selectByExample(secondOrderExample);
        statisticsMiniStore.setOrderNumber(secondOrders.size());
        criteria.andOrderStatusNotEqualTo(OrderEnum.OrderStatus.PAYMENT.getOrderStatus());
        List<SecondOrder> secondOrders1 =
        secondOrderMapper.selectByExample(secondOrderExample);
        statisticsMiniStore.setPaymentOrder(secondOrders1.size());
        secondOrderExample.clear();
        SecondOrderExample.Criteria criteria1 =
                secondOrderExample.createCriteria()
                        .andOrderStatusEqualTo(OrderEnum.OrderStatus.EVALUATE.getOrderStatus())
                        .andIsDeletedEqualTo((byte) 0);
        if (storeId!=null){
            criteria1.andStoneIdEqualTo(storeId);
        }
        SecondOrderExample.Criteria criteria2 =
                secondOrderExample.createCriteria()
                        .andOrderStatusEqualTo(OrderEnum.OrderStatus.COMPLETE.getOrderStatus())
                        .andIsDeletedEqualTo((byte) 0);
        if (storeId!=null){
            criteria2.andStoneIdEqualTo(storeId);
        }
        secondOrderExample.or(criteria2);
        List<SecondOrder> secondOrders2 =
                secondOrderMapper.selectByExample(secondOrderExample);
        statisticsMiniStore.setCancelOrder(secondOrders2.size());
        return builder.body(ResponseUtils.getResponseBody(statisticsMiniStore));

    }
    //商家端小程序统计
    @ApiOperation(value = "后台每月收入图标", notes = "后台每月收入图标")
    @RequestMapping(value = "/backendData", method = RequestMethod.GET)
    public ResponseEntity<JSONObject> backendData(Integer sonId)
            throws JSONException {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder();
        Calendar cal = Calendar.getInstance();
        Integer year = cal.get(Calendar.YEAR);
        List<Integer> storeIntList= new ArrayList<>();
        if (sonId != 0){
            SecondUserSonExample secondUserSonExample = new SecondUserSonExample();
            secondUserSonExample.createCriteria().andSonIdEqualTo(sonId)
                    .andIsDeletedEqualTo((byte) 0);
            List<SecondUserSon> secondUserSons =
                    secondUserSonMapper.selectByExample(secondUserSonExample);
            storeIntList = secondUserSons.stream().map(SecondUserSon::getStoreId).collect(Collectors.toList());
            if (storeIntList.size()==0){
                MonthAmount monthAmount = new MonthAmount();
                monthAmount.setJanuary(0);
                monthAmount.setFebruary(0);
                monthAmount.setMarch(0);
                monthAmount.setApril(0);
                monthAmount.setMay(0);
                monthAmount.setJune(0);
                monthAmount.setJuly(0);
                monthAmount.setAugust(0);
                monthAmount.setSeptember(0);
                monthAmount.setOctober(0);
                monthAmount.setNovember(0);
                monthAmount.setDecember(0);
                return builder.body(ResponseUtils.getResponseBody(monthAmount));
            }
        }

        return builder.body(ResponseUtils.getResponseBody(statisticsService.monthAmount(sonId,year,storeIntList)));

    }
}
