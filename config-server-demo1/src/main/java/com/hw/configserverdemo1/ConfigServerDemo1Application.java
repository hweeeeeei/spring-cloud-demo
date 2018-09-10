package com.hw.configserverdemo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * EnableConfigServer 注解开启配置服务器的功能
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServerDemo1Application {

    public static void main(String[] args) {

        SpringApplication.run(ConfigServerDemo1Application.class, args);
    }
}
