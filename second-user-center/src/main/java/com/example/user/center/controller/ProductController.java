package com.example.user.center.controller;


import com.example.springbootdemoentity.entity.Product;
import com.example.user.center.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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


    @RequestMapping(value = "/getcort")
//    @PreAuthorize("hasPermission('/getcort','r')")
    public String getProduct() {
//        String str =  productService.getProduct();
        return "7878";
    }

    public static void main(String[] args) {
        BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
        String a = bcryptPasswordEncoder.encode("123456");
        System.out.println(a);
//                BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
       boolean b = bcryptPasswordEncoder.matches("123456",a);
        System.out.println(b);
    }
}
