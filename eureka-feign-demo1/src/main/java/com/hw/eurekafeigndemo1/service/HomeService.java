package com.hw.eurekafeigndemo1.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "eureka-service-demo1")
public interface HomeService {
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    String home(@RequestParam(value = "name") String name);

}
