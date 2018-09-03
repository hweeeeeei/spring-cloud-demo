package com.hw.eurekaservicedemo1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * 服务提供者 (eureka client)
 * 当client向server注册时，它会提供一些元数据，例如主机和端口，URL，主页等。
 * Eureka server 从每个client实例接收心跳消息。
 * 如果心跳超时，则通常将该实例从注册server中删除。
 */
@SpringBootApplication
//@EnableEurekaClient
@RestController
public class EurekaServiceDemo1Application {

    public static void main(String[] args) {

        SpringApplication.run(EurekaServiceDemo1Application.class, args);
    }


    @Value("${server.port}")
    String port;


    @GetMapping("/home")
    public String home (@RequestParam(value = "name") String name){

        return "home  "+port+"  "+name;
    }

}
