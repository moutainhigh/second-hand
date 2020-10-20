package com.example.order.center.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.order.center.dao.SecondUserMapper;
import com.example.order.center.manual.Authentication;
import com.example.order.center.manual.Evaluate;
import com.example.order.center.manual.Statistics.StatisticsList;
import com.example.order.center.model.*;
import com.second.utils.response.handler.ResponseEntity;
import com.second.utils.response.handler.ResponseUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
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
    @Autowired
    private SecondUserMapper secondUserMapper;
    @ApiOperation(value = "用户统计", notes = "用户统计")
//    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    @RequestMapping(value = "/userStatistics", method = RequestMethod.GET)
    public ResponseEntity<JSONObject> userStatistics(Date startTime,
                                                     Date endTime
    )
            throws JSONException {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder();
        Instant instant = startTime.toInstant();//开始时间
        Instant instant1 = endTime.toInstant();//结束时间
        //date转LocalDateTime
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();
        LocalDateTime localDateTime1 = instant1.atZone(zoneId).toLocalDateTime();

        SecondUserExample secondUserExample = new SecondUserExample();
        secondUserExample.createCriteria()
                .andIdDeletedEqualTo((byte) 0)
        .andCreateDateGreaterThanOrEqualTo(localDateTime)
        .andCreateDateLessThanOrEqualTo(localDateTime1);
        List<SecondUser> secondUsers =
        secondUserMapper.selectByExample(secondUserExample);
        StatisticsList statisticsList = new StatisticsList();
        statisticsList.setUserNumber(secondUsers.size());
        //筛选用户未审核的数量
        List<SecondUser> secondUsers1 = secondUsers.stream()
                .filter(a->a.getUserType().equals(Authentication.LoginType.USERWX.getState())
                && a.getIsAuthentication().equals(Authentication.UserState.NOPASS.getState()))
                .collect(Collectors.toList());
        statisticsList.setUserGeneral(secondUsers1.size());
        //筛选认证的用户
        List<SecondUser> secondUsers2 = secondUsers.stream()
                .filter(a->a.getUserType().equals(Authentication.LoginType.USERWX.getState())
                        && a.getIsAuthentication().equals(Authentication.UserState.PASS.getState()))
                .collect(Collectors.toList());
        statisticsList.setUserAuthentication(secondUsers2.size());
        //筛选商家店铺用户
        List<SecondUser> secondUsers3 = secondUsers.stream()
                .filter(a->a.getUserType().equals(Authentication.LoginType.STOREWX.getState())
                        && a.getIsAuthentication().equals(Authentication.UserState.PASS.getState()))
                .collect(Collectors.toList());
        statisticsList.setUserStore(secondUsers3.size());
        return builder.body(ResponseUtils.getResponseBody(statisticsList));
    }
}
