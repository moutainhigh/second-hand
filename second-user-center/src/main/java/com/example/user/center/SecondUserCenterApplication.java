package com.example.user.center;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
@MapperScans({@MapperScan("com.example.user.center.dao")})
public class SecondUserCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecondUserCenterApplication.class, args);
    }

}
