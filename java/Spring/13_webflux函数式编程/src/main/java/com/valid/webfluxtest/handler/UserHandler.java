package com.valid.webfluxtest.handler;

import com.valid.webfluxtest.entity.User;
import com.valid.webfluxtest.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromProducer;

public class UserHandler {

    private final UserService userService;
    public UserHandler(UserService userService) {
        this.userService = userService;
    }

    // 根据id查询
    public Mono<ServerResponse> getUserById(ServerRequest request) {
        // 获取id
        int id = Integer.parseInt(request.pathVariable("id"));

        // 调用service得到数据
        Mono<User> userMono = this.userService.getUserById(id);

        // 把userMono进行转换返回
        return userMono
                .flatMap(user -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                    .body(fromProducer(user, user.getClass())))
                    .switchIfEmpty(ServerResponse.notFound().build());
    }

    // 查询所有
    public Mono<ServerResponse> getAllUser(ServerRequest request) {
        // 调用service得到结果
        Flux<User> users = this.userService.getAllUser();
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(users, User.class);
    }

    // 添加
    public Mono<ServerResponse> saveUser(ServerRequest request) {
        // 得到user对象

        Mono<User> userMono = request.bodyToMono(User.class);

        return ServerResponse.ok().build(this.userService.saveUserInfo(userMono));
    }
}
