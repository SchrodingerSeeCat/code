package com.valid.admin;

import com.valid.admin.bean.User;
import com.valid.admin.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

@Slf4j
@SpringBootTest
public class ApplicationTests {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Test
    public void test1() {
        int count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM user", Integer.class);
        System.out.println(count);
    }

    @Autowired
    DataSource dataSource;

    @Test
    public void test2() {
        log.info("数据源类型：{}", dataSource.getClass());
    }

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test3() {
        User user = userMapper.selectById(1);
        log.info("用户信息：{}", user);
    }

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Transactional
    @Test
    public void test4() {
        ValueOperations<String, String> operations = redisTemplate.opsForValue();

        operations.set("hello", "world");

        System.out.println(operations.get("hello"));
    }
}
