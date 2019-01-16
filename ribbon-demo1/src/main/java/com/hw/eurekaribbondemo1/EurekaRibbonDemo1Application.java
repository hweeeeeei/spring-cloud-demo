package com.hw.eurekaribbondemo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
    Ribbon 服务消费者  服务与服务的通讯
    Ribbon 是一个负载均衡客户端

     Ribbon是基于Http和Tcp协议的客户端负载均衡工具，
    基于Netflix Ribbon实现，它只是一个工具类，不需要独立部署。
    而微服务间的调用，API请求转发等内容，都是通过Ribbon来实现的。
 */

/**
    Hystrix 断路器
    分布式系统中出微服务节点出现故障，
    会执行定义的容错方法，在若干秒后通知所有的微服务调用者，
    该节点为故障节点，之后会从可用列表中选择调用。
 */
@SpringBootApplication
@EnableEurekaClient
@EnableHystrix  // 第二阶段学习 升级hystrix 断路器
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
