package com.example.order.center.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.order.center.manual.CreateOrderRequest;
import com.second.utils.response.handler.ResponseEntity;
import com.second.utils.response.handler.ResponseUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

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

    @RequestMapping(path = "/addOrder", method = RequestMethod.POST)
    @ApiOperation(value = "创建订单", notes = "创建订单")
    public ResponseEntity<JSONObject> addCategory(CreateOrderRequest request, HttpServletRequest requests) throws Exception {
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder();

        return builder.body(ResponseUtils.getResponseBody(0));
    }
}
