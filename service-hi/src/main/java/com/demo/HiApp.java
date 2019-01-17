package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * 资源服务器
 */
@SpringBootApplication
@EnableEurekaClient
@FeignClient
public class HiApp {

    public static void main(String[] args) {

        SpringApplication.run(HiApp.class, args);
    }
}
