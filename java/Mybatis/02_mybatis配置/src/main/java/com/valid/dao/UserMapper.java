package com.valid.dao;

import com.valid.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    // 根据id查询用户
    User getUserById(int id);
}
