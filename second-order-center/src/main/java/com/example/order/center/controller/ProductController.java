package com.example.order.center.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @author shihao
 * @Title: ProductController
 * @ProjectName Second-order-center
 * @Description: TODO
 * @date 2020/9/3-14:18
 */
@RestController
public class ProductController {

    @RequestMapping(value = "/getProduct")
    public String getProduct() {
//     Product product = new Product();
//        System.out.println("我是服务的提供者");
        return "789";
    }
}
