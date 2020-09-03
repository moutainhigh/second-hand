package com.example.user.center.controller;


import com.example.springbootdemoentity.entity.Product;
import com.example.user.center.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author YangPeng
 * @Title: ProductController
 * @ProjectName springbootdemo
 * @Description: TODO
 * @date 2019/3/25-19:26
 */
@RestController
public class ProductController {
    @Autowired
    private ProductService productService;


    @RequestMapping(value = "getcort")
    public String getProduct() {
        String str =  productService.getProduct();
        return str;
    }
}
