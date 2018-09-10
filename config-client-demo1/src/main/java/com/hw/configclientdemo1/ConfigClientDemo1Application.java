package com.hw.configclientdemo1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *  配置中心客户端

 */
@SpringBootApplication
@RestController
@EnableEurekaClient
public class ConfigClientDemo1Application {

    public static void main(String[] args) {

        SpringApplication.run(ConfigClientDemo1Application.class, args);
    }



    @Value("${hi}")
    String message;

    @GetMapping("/hi")
    public String hiMessage(){

        return message;
    }
}
