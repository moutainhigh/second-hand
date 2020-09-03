package com.example.user.center.controller;


import com.example.springbootdemoentity.entity.Product;
import com.example.user.center.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author shihao
 * @Title: ProductController
 * @ProjectName Second-order-center
 * @Description: TODO
 * @date 2020/9/3-14:18
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
