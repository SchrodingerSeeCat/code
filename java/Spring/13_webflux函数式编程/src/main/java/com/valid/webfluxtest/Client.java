package com.valid.webfluxtest;

import com.valid.webfluxtest.entity.User;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

public class Client {
    public static void main(String[] args) {
        // 指定调用服务器的地址
        WebClient webClient = WebClient.create("http://127.0.0.1:60490");

        // 根据id查询
        String id = "1";
        webClient.get().uri("/user").accept(MediaType.APPLICATION_JSON).retrieve().bodyToFlux(User.class);
    }
}
