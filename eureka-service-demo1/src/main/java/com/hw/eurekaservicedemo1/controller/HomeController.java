package com.hw.eurekaservicedemo1.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomeController {


    @Value("${server.port}")
    String port;


    @GetMapping("/home")
    String home(@RequestParam(value = "name") String name) {

        return "home  " + port + "  " + name;
    }
}
