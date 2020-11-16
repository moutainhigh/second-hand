package com.example.order.center.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.order.center.dao.SecondAuthMapper;
import com.example.order.center.dao.SecondOrderMapper;
import com.example.order.center.manual.Authentication;
import com.example.order.center.manual.IntegralEnum;
import com.example.order.center.manual.OrderEnum;
import com.example.order.center.model.SecondAuth;
import com.example.order.center.model.SecondAuthExample;
import com.example.order.center.model.SecondOrder;
import com.example.order.center.service.OrderCloudService;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.second.common.utils.PageTool;
import com.second.common.utils.QRCodeUtils;
import com.second.utils.response.handler.ResponseEntity;
import com.second.utils.response.handler.ResponseUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author shihao
 * @Title: CancelController
 * @ProjectName Second-order-center
 * @Description: 核销商家商品订单
 * @date Created in
 * @Version: $
 */
@RestController
@Api
@RequestMapping("/Cancel")
@CrossOrigin
public class CancelController {
    @Resource
    private RedisTemplate<String, Object> redisTemplate;
    //订单
    @Autowired
    private SecondOrderMapper secondOrderMapper;
    //
    @Autowired
    private SecondAuthMapper secondAuthMapper;
    //
    @Autowired
    private OrderCloudService orderCloudService;
    @ApiOperation(value = "普通商家商品订单二维码核销", notes = "普通商家商品二维码核销")
    @RequestMapping(value = "/code", method = RequestMethod.POST)
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public ResponseEntity<JSONObject> code(
            @RequestParam(value = "IntegralRecordCode", required = false) String IntegralRecordCode,
            @RequestParam(value = "userId", required = false) Integer userId,
            HttpServletResponse response
    ) throws Exception {
        //
        ResponseEntity.BodyBuilder builder = ResponseUtils.getBodyBuilder(HttpStatus.OK);
        String key = "MIGfMA0GCSqGSIb3";
        String IntegralRecord = String.valueOf(IntegralRecordCode).replace("思维创造", "");
        String decrypt = PageTool.decrypt(IntegralRecord, key);
        Integer orderId=Integer.valueOf(decrypt);
        if (redisTemplate.opsForValue().get(decrypt) == null){
            response.sendError(HttpStatus.FORBIDDEN.value(), "二维码已失效");
            return builder.body(ResponseUtils.getResponseBody("二维码已失效"));
        }
        SecondOrder secondOrder = secondOrderMapper.selectByPrimaryKey(orderId);
        SecondAuthExample secondAuthExample = new SecondAuthExample();
        secondAuthExample.createCriteria().andUserIdEqualTo(userId)
                .andLoginTypeEqualTo(Authentication.LoginType.STOREWX.getState())
                .andStoreIdEqualTo(secondOrder.getStoneId())
                .andIsDeletedEqualTo((byte) 0)
                .andAuthStatusEqualTo((byte) 0);
        List<SecondAuth> secondAuths =
                secondAuthMapper.selectByExample(secondAuthExample);
        if (secondAuths.size()==0){
            response.sendError(HttpStatus.FORBIDDEN.value(), "您不是核销员");
            return builder.body(ResponseUtils.getResponseBody("您不是核销员"));
        }
        if (secondOrder.getOrderStatus().equals(OrderEnum.OrderStatus.EVALUATE.getOrderStatus())
         || secondOrder.getOrderStatus().equals(OrderEnum.OrderStatus.COMPLETE.getOrderStatus())){
            response.sendError(HttpStatus.FORBIDDEN.value(), "已经被核销");
            return builder.body(ResponseUtils.getResponseBody("已经被核销"));
        }
        //修改订单状态
        orderCloudService.updateOrder(orderId,
                secondOrder.getOrderCode(),
                secondOrder.getOrderStatus(),
                OrderEnum.OrderStatus.EVALUATE.getOrderStatus());
        return builder.body(ResponseUtils.getResponseBody(0));
    }
}
