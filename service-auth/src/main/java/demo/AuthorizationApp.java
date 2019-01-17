package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;


/***
 * 认证服务器
 */
@SpringBootApplication
@EnableEurekaClient
@EnableResourceServer
//@EntityScan("com.demo.entity")
public class AuthorizationApp {

    public static void main(String[] args) {

        SpringApplication.run(AuthorizationApp.class, args);
    }


    /**
     *
     *测试url：http://localhost:9089/oauth/token?username=user_1&password=123456&grant_type=password&scope=server&client_id=client_2&client_secret=123456
     */
}
