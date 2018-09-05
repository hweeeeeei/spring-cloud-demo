package com.hw.eurekafeigndemo1.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * FeignClient 指定需要调用服务的名称
 */
@FeignClient(value = "eureka-service-demo1")
public interface HomeService {

    /**
     * 代理请求的路径
     * 调用 eureka-service-demo1 的 home接口
     */
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    String home(@RequestParam(value = "name") String name);

}
