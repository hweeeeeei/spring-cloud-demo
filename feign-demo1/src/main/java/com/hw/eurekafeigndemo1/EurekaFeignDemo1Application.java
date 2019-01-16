package com.hw.eurekafeigndemo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 服务消费者
 * Feign 基于接口的注解
 * Feign 整合了ribbon现了负载均衡
 * Feign是一个声明式的伪Http客户端。使用Feign，只需要创建一个接口并注解。
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class EurekaFeignDemo1Application {

    public static void main(String[] args) {

        SpringApplication.run(EurekaFeignDemo1Application.class, args);
    }
}
