package com.example.order.center.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.order.center.manual.goods;
import com.example.order.center.model.SecondGoods;
import com.second.utils.response.handler.ResponseEntity;
import com.second.utils.response.handler.ResponseUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shihao
 * @Title: EvaluateController
 * @ProjectName Second-order-center
 * @Description: 评价
 * @date Created in
 * @Version: $
 */
@RestController
@Api
@RequestMapping("/Evaluate")
@CrossOrigin
public class EvaluateController {
    @ApiOperation(value = "添加评价", notes = "添加评价")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "userId", value = "用户id", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "storeId", value = "店铺id", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "orderDetails", value = "订单详情id", required = true, type = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "files", value = "评价图", required = true, type = "List<String>"),
            @ApiImplicitParam(paramType = "query", name = "evaluate", value = "评价内容", required = true, type = "String"),
            @ApiImplicitParam(paramType = "query", name = "parentEvaluateId", value = "父级评价id", required = true, type = "Integer"),
    })
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    @RequestMapping(value = "/addEvaluate", method = RequestMethod.POST)
    public ResponseEntity<JSONObject> addEvaluate(Integer userId,
                                                Integer storeId,
                                                Integer orderDetails,
                                                String evaluate,
                                                Integer parentEvaluateId,
                                                List<String> files)
            throws JSONException {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder();

        return builder.body(ResponseUtils.getResponseBody(0));
    }
}
