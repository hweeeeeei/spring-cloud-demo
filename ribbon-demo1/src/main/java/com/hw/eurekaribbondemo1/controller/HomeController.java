package com.hw.eurekaribbondemo1.controller;

import com.hw.eurekaribbondemo1.service.HomeService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    HomeService homeService;

    @Value("${server.port}")
    String port;

    /**
     * 使用 @HystrixCommand 注解的 fallbackMethod 指定失败方法
     */
    @GetMapping("/home")
    @HystrixCommand(fallbackMethod = "homeFall")
    String home(@RequestParam(value = "name") String name) {

        return homeService.homeService(name);
    }


    /**
     * 失败方法
     * 注意参数要一致
     */
    public String homeFall(String name) {

        return "home 接口异常 - error:" + port;
    }

}
