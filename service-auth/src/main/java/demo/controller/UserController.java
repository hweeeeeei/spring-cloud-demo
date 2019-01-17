package demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

//对外暴露获取token的API和验证token的API
@RestController
@RequestMapping("/users")
public class UserController {


    Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(value = "/current", method = RequestMethod.GET)
    public Principal getUser(Principal principal) {

        logger.info(">>>>>>>>>>>>>>>>>>>>>>>>");
        logger.info(principal.toString());

        return principal;
    }



}
