package com.valid.dao;

import com.valid.pojo.User;
import com.valid.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoTest {
    @Test
    public void test() {
        // 测试获取所有用户

        // 1. 获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        // 2. getMapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = userMapper.getUserList();

        System.out.println(list);

        // 3.关闭sqlSession
        sqlSession.close();
    }

    @Test
    public void test1() {
        // 测试获取指定id的用户
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.getUserById(1);
        System.out.println(user);

        sqlSession.close();
    }

    @Test
    public void test2() {
        // 测试添加
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int count = userMapper.insertUser(new User(4, "狠人大帝", "57823495"));
        System.out.println(count);

        // 增删改需要提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test3() {
        // 测试修改
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int res =userMapper.updateUser(new User(1, "完美世界", "234453"));

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test4() {
        // 测试删除
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.deleteUser(1);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test5() {
        // 测试map添加
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        Map<String, Object> map = new HashMap<>();
        map.put("userid", 1);
        map.put("userName", "石昊");
        map.put("password", "3456772");
        userMapper.addUser(map);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test6() {
        // 测试map查询
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        Map<String, Object> map = new HashMap<>();
        map.put("id", 1);
        map.put("pwd", 3456772);

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserByIdMap(map);
        System.out.println(user);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test7() {
        // 测试模糊查询
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.getUserLike("%石%");
        System.out.println(users);

        sqlSession.close();
    }
}
