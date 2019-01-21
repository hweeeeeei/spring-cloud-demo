package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;


/***
 * spring cloud oauth2.0认证服务器
 * 认证服务器本身也是资源服务
 * <p>
 * 官方文档:http://projects.spring.io/spring-security-oauth/docs/oauth2.html
 * 官方数据库表:https://github.com/spring-projects/spring-security-oauth/blob/master/spring-security-oauth2/src/test/resources/schema.sql
 */
@SpringBootApplication
@EnableEurekaClient
@EnableResourceServer
public class AuthorizationApp {

    public static void main(String[] args) {

        SpringApplication.run(AuthorizationApp.class, args);
    }


    /**
     *测试url：http://localhost:9089/oauth/token?username=user_1&password=123456&grant_type=password&scope=server&client_id=client_2&client_secret=123456
     */
}
