package com.valid.dao;

import com.valid.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    @Select("SELECT * FROM user")
    List<User> getUsers();
}
