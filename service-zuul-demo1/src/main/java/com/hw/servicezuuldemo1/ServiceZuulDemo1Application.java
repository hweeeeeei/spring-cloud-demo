package com.hw.servicezuuldemo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**\
 * Zuul 路由网关
 * 主要功能是路由转发和过滤器。
 * 路由功能是微服务的一部分，比如／api/user转发到到user服务，/api/shop转发到到shop服务。
 * zuul默认和Ribbon结合实现了负载均衡的功能。
 * @EnableZuulProxy 打开路由功能
 */
@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class ServiceZuulDemo1Application {

    public static void main(String[] args){

        SpringApplication.run(ServiceZuulDemo1Application.class, args);
    }
}
