package com.hw.eurekafeigndemo1.controller;

import com.hw.eurekafeigndemo1.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @Autowired
    HomeService homeService;


    @GetMapping("/home")
    String home(@RequestParam(value = "name") String name) {

        return homeService.home(name);
    }
}
