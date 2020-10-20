package com.example.order.center.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.order.center.dao.SecondOrderMapper;
import com.example.order.center.dao.SecondUserMapper;
import com.example.order.center.manual.Authentication;
import com.example.order.center.manual.OrderEnum;
import com.example.order.center.manual.Statistics.StatisticsOrderList;
import com.example.order.center.manual.Statistics.StatisticsUserList;
import com.example.order.center.model.*;
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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
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
    @ApiOperation(value = "用户统计", notes = "用户统计")
//    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    @RequestMapping(value = "/userStatistics", method = RequestMethod.GET)
    public ResponseEntity<JSONObject> userStatistics(Date startTime,
                                                     Date endTime
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
                                                     Date endTime
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
        List<SecondOrder> secondOrders =
                secondOrderMapper.selectByExample(secondOrderExample);
        StatisticsOrderList statisticsOrderList = new StatisticsOrderList();
        statisticsOrderList.setOrderNumber(secondOrders.size());
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
    //商品
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
}
