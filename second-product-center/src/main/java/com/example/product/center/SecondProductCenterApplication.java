package com.example.product.center;

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
@MapperScans({@MapperScan("com.example.product.center.dao"),@MapperScan("com.example.product.center.manual.dao")})
@EnableTransactionManagement//shiwu
public class SecondProductCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecondProductCenterApplication.class, args);
    }

}
