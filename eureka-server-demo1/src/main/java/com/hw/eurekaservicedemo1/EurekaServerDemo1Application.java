package com.hw.eurekaservicedemo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer //服务注册中心
public class EurekaServerDemo1Application {

    public static void main(String[] args) {

        SpringApplication.run(EurekaServerDemo1Application.class, args);
    }
}
