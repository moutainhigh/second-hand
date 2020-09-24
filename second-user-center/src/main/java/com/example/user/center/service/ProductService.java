package com.example.user.center.service;


import com.alibaba.fastjson.JSONObject;
import com.second.utils.response.handler.ResponseEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author YangPeng
 * @Title: ProductService
 * @ProjectName springbootdemo
 * @Description: TODO
 * @date 2019/3/27-11:23
 */
//name 为product项目中application.yml配置文件中的application.name;
//path 为product项目中application.yml配置文件中的context.path;
@FeignClient(name = "product-center",path ="/product" )
@Component
public interface ProductService {
    @RequestMapping(value = "/SecondProduct/selectProduct")
    JSONObject getProduct(@RequestParam("pageNum") Integer pageNum,@RequestParam("pageSize") Integer pageSize);
}
