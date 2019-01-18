package com.demo.controller;

import com.demo.entity.User;
import com.demo.service.UsersService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;


@RestController
public class OrderTestController {


    Logger logger = LoggerFactory.getLogger(OrderTestController.class);


    @Autowired
    UsersService userService;

    @RequestMapping(value = "/registry", method = RequestMethod.POST)
    public User createUser(@RequestParam("username") String username, @RequestParam("password") String password) {
        if (StringUtils.isNotEmpty(username) && StringUtils.isNotEmpty(password)) {
            return userService.create(username, password);
        }

        return null;
    }


    @GetMapping("/product/{id}")
    public String getProduct(@PathVariable String id) {
        return "product id : " + id;
    }

    @GetMapping("/order/{id}")
    public String getOrder(@PathVariable String id) {
        return "order id : " + id;
    }

    /**
     *
     获取用户所有信息
      */
    @GetMapping("/getPrinciple")
    public OAuth2Authentication getPrinciple(OAuth2Authentication oAuth2Authentication, Principal principal, Authentication authentication) {

        logger.info(oAuth2Authentication.getUserAuthentication().getAuthorities().toString());
        logger.info(oAuth2Authentication.toString());
        logger.info("principal.toString() " + principal.toString());
        logger.info("principal.getName() " + principal.getName());
        logger.info("authentication: " + authentication.getAuthorities().toString());

        return oAuth2Authentication;
    }


}
