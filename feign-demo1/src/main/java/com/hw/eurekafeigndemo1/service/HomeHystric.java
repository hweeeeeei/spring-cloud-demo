package com.hw.eurekafeigndemo1.service;

import org.springframework.beans.factory.annotation.Value;

/**
 * Feign是自带hystrix断路器的
 *
 * 只需要在接口上指定回滚类fallback = HomeHystric.class
 * 再实现回滚具体方法
 */
public class HomeHystric implements HomeService {

    @Value("${server.port}")
    String port;

    @Override
    public String home(String name) {
        return "error "+name+ " port:"+port;
    }
}
