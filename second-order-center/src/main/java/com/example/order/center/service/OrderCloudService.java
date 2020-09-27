package com.example.order.center.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author shihao
 * @Title: OrderCloudService
 * @ProjectName Second-order-center
 * @Description: 订单
 * @date Created in
 * @Version: $
 */
@FeignClient(name = "order-server",path ="/order" )
@Component
public interface OrderCloudService {
    @RequestMapping(value = "/SecondOrder/updateOrder",method = RequestMethod.POST)
    JSONObject updateOrder(@RequestParam("orderId") Integer orderId,
                           @RequestParam("orderCode") String orderCode,
                           @RequestParam("originalOrderStatus") String originalOrderStatus,
                           @RequestParam("targetOrderStatus") String targetOrderStatus);
}
