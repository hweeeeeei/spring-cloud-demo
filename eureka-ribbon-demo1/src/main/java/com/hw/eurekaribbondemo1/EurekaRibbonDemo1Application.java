package com.hw.eurekaribbondemo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Ribbon 服务消费者
 * Ribbon 是一个负载均衡客户端
 *
 * Spring Cloud Ribbon是基于Http和Tcp协议的客户端负载均衡工具，
 * 基于Netflix Ribbon实现，它只是一个工具类，不需要独立部署。
 * 而微服务间的调用，API请求转发等内容，都是通过Ribbon来实现的。
 *
 * 简单说就是: 服务与服务的通讯
 */

@SpringBootApplication
@EnableEurekaClient
public class EurekaRibbonDemo1Application {

    public static void main(String[] args) {

        SpringApplication.run(EurekaRibbonDemo1Application.class, args);
    }


    /**
     * 注入ioc容器
     * LoadBalanced 开启负载均衡
     * restTemplate 负责微服务间的调用，API请求转发
     */
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {

        return new RestTemplate();
    }
}
