package com.valid.dao;

import com.valid.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    // 查询用户
    User getUserByID(@Param("id") int id);
}
