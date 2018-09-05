package com.hw.eurekaservicedemo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
        import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


/**
 * 服务提供者 (eureka client)
 * 当client向server注册时，它会提供一些元数据，例如主机和端口，URL，主页等。
 * Eureka server 从每个client实例接收心跳消息。
 * 如果心跳超时，则通常将该实例从注册server中删除。
 */

@SpringBootApplication
@EnableEurekaClient
public class EurekaServiceDemo1Application {


    public static void main(String[] args) {

        SpringApplication.run(EurekaServiceDemo1Application.class, args);
    }


}
