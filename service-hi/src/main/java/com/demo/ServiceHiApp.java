package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 资源服务器
 */
@SpringBootApplication
@EnableEurekaClient
@FeignClient
public class ServiceHiApp {

    public static void main(String[] args) {

        SpringApplication.run(ServiceHiApp.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {

        return new RestTemplate();
    }

}
