package com.valid.webfluxtest.service;

import com.valid.webfluxtest.entity.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

// 用户操作接口
public interface UserService {
    // 根据id查询查询用户
    Mono<User> getUserById(int id);

    // 查询所有用户
    Flux<User> getAllUser();

    // 添加用户
    Mono<Void> saveUserInfo(Mono<User> user);
}
