package com.valid.dao;

import com.valid.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    // 获取全部用户
    List<User> getUserList();

    // 根据id查询用户
    User getUserById(int id);

    // 插入一个用户
    int insertUser(User user);

    // 修改用户
    int updateUser(User user);

    // 删除一个用户
    int deleteUser(int id);

    // Map添加用户
    int addUser(Map<String ,Object> map);

    // Map查询用户
    User getUserByIdMap(Map<String, Object> map);

    // 模糊查询
    List<User> getUserLike(String name);
}
