package com.example.user.center.controller;


import com.example.user.center.service.ProductService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


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
    @Autowired
    private AmqpTemplate rabbitTemplate;
    //交换机
    private static String EXCHANGE_NAME="hello111";

    @RequestMapping(value = "/getcort")
//    @PreAuthorize("hasPermission('/getcort','r')")
    public String getProduct() {
//        String str =  productService.getProduct();
        return "7878";
    }
    @RequestMapping(value = "/getcort1")
    public void send() {
        String context = "hello " + new Date();
        System.out.println("Sender : " + context);
// 调用 发送消息的方法
        this.rabbitTemplate.convertAndSend("myQueue2", context);
    }
    //交换机订阅模式
    @RequestMapping(value = "/getcort2")
    public void send2() {
        String context = "hello " + new Date();
        System.out.println("Sender 交换机: " + context);
// 调用 发送消息的方法
        this.rabbitTemplate.convertAndSend(EXCHANGE_NAME,"fanout", context);
    }
    //监听消息
    @RabbitListener(queuesToDeclare = @Queue("myQueue2"))
    public void process2(String message){
        System.out.println("MqReceiver2: {}"+ message);
//        log.info("MqReceiver2: {}", message);

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
