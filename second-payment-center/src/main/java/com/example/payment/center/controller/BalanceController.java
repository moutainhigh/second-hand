package com.example.payment.center.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.payment.center.dao.SecondStoreBalanceDetailMapper;
import com.example.payment.center.manual.Authentication;
import com.example.payment.center.manual.SecondWithdrawalList;
import com.example.payment.center.manual.WithdrawalEnum;
import com.example.payment.center.model.*;
import com.second.utils.response.handler.ResponseEntity;
import com.second.utils.response.handler.ResponseUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @author shihao
 * @Title: BalanceController
 * @ProjectName Second-order-center
 * @Description: 余额
 * @date Created in
 * @Version: $
 */
@CrossOrigin
@RestController
@RequestMapping("/Balance")
@Api
public class BalanceController {
    //余额明细
    @Autowired
    private SecondStoreBalanceDetailMapper secondStoreBalanceDetailMapper;

    @RequestMapping(path = "/selectBalanceDetail", method = RequestMethod.GET)
    @ApiOperation(value = "查询余额明细", notes = "查询余额明细")
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "userId", value = "用户id", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "storeId", value = "店铺", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "type", value = "明细类型", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "incomeExpenses", value = "收支", required = true, type = "Integer"),
    })
    public ResponseEntity<JSONObject> selectBalanceDetail(
                              @RequestParam(value = "userId", required = false) Integer userId,
                              @RequestParam(value = "storeId", required = false) Integer storeId,
                              @RequestParam(value = "type", required = false) String type,
                              @RequestParam(value = "incomeExpenses", required = false) String incomeExpenses,
                                                       HttpServletResponse response) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder();
        SecondStoreBalanceDetailExample secondStoreBalanceDetailExample = new SecondStoreBalanceDetailExample();
        SecondStoreBalanceDetailExample.Criteria criteria =
        secondStoreBalanceDetailExample.createCriteria().andUserIdEqualTo(userId)
                .andStoreIdEqualTo(storeId)
                .andIsDeletedEqualTo((short) 0);
        if (type!=null){
            criteria.andDetailTypeEqualTo(type);
        }
        if (incomeExpenses!=null){
            criteria.andIncomeExpensesEqualTo(incomeExpenses);
        }
        return builder.body(ResponseUtils.getResponseBody(secondStoreBalanceDetailMapper.selectByExample(secondStoreBalanceDetailExample)));
    }
}
