package com.valid.webfluxtest;

import com.valid.webfluxtest.handler.UserHandler;
import com.valid.webfluxtest.service.UserServiceImpl;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.netty.http.server.HttpServer;

import java.io.IOException;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.toHttpHandler;

public class Server {
    // 1. 创建Router路由
    public RouterFunction<ServerResponse> routingFunction() {

        UserHandler handler = new UserHandler(new UserServiceImpl());
        return RouterFunctions.route(
                GET("/user/{id}").and(accept(MediaType.APPLICATION_JSON)), handler::getUserById)
                .andRoute(GET("/user").and(accept(MediaType.APPLICATION_JSON)), handler::getAllUser);
    }

    // 2. 创建服务器完成适配
    public void createReactorServer() {
        // 路由和handler适配
        RouterFunction<ServerResponse> router = routingFunction();
        HttpHandler httpHandler = toHttpHandler(router);
        ReactorHttpHandlerAdapter adapter = new ReactorHttpHandlerAdapter(httpHandler);

        // 创建服务器
        HttpServer httpServer = HttpServer.create();
        httpServer.handle(adapter).bindNow();
    }

    // 3. 启动服务
    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.createReactorServer();
        System.in.read();
    }
}
