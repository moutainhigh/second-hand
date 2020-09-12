package com.example.payment.center;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
@MapperScans({@MapperScan("com.example.payment.center.dao")})
@EnableTransactionManagement//shiwu
public class SecondPaymentCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecondPaymentCenterApplication.class, args);
    }

}
