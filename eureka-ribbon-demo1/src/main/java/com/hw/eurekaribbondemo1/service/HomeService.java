package com.hw.eurekaribbondemo1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HomeService {

    @Autowired
    RestTemplate restTemplate;


    public String homeService(String name) {

        // restTemplate代理请求
        return restTemplate.getForObject("http://eureka-service-demo1/home?name=" + name, String.class);
    }


}
