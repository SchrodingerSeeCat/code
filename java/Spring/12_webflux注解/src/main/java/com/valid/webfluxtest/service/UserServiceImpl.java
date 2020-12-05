package com.valid.webfluxtest.service;

import com.valid.webfluxtest.entity.User;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService{
    // map集合模拟数据库
    private final static Map<Integer, User> users = new HashMap<>();
    static {
        users.put(1, new User("lucy", "women", 20));
        users.put(2, new User("mary", "man", 30));
        users.put(3, new User("jack", "man", 50));
    }

    @Override
    public Mono<User> getUserById(int id) {
        return Mono.justOrEmpty(users.get(id));
    }

    @Override
    public Flux<User> getAllUser() {
        return Flux.fromIterable(users.values());
    }

    @Override
    public Mono<Void> saveUserInfo(Mono<User> user) {
        return user.doOnNext(u -> {
            // 向map集合里面放值
            users.put(users.size() + 1, u);
        }).thenEmpty(Mono.empty());
    }
}
