package com.hw.eurekaservicedemo1.socket;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

//实现接口来配置Websocket请求的路径和拦截器。
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {


    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        //handler是webSocket的核心，配置入口
        webSocketHandlerRegistry.addHandler(new MyHandler(), "/myHandler/{ID}").setAllowedOrigins("*").addInterceptors(new WebSocketInterceptor());

/*
1.@Configuration：注解标识该类为Spring的配置类
2.@EnableWebSocket：开启注解接收和发送消息
3.实现WebSocketConfigurer接口，重写registerWebSocketHandlers方法，
这是一个核心实现方法，配置websocket入口，允许访问的域、注册Handler、定义拦截器。
客户端通过“/myHandler/{ID}”直接访问Handler核心类，
进行socket的连接、接收、发送等操作，这里由于还加了个拦截器，
所以建立新的socket访问时，都先进来拦截器再进去Handler类，
“new WebSocketInterceptor()”是我实现的拦截器，
“new MyHandler()”是我实现的一个Handler类。

原文：https://blog.csdn.net/Ouyzc/article/details/79994401

集成spring boot https://www.cnblogs.com/bianzy/p/5822426.html*/

    }
}
