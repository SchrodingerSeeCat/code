package com.valid.jdbc.batch;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@DisplayName("批处理")
public class BatchTest {
    private static Connection connect;
    @BeforeAll
    public static void before() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 使用DriverManager管理
        String url = "jdbc:mysql://localhost:3306/test?useSSL=true&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai&rewriteBatchedStatements=true";
        String user = "root";
        String password = "123456";

        connect = DriverManager.getConnection(url, user, password);
    }

    @AfterAll
    public static void after() throws SQLException {
        if (connect != null) {
            connect.close();
        }
    }

    @Test
    public void test() throws SQLException {
        String sql = "INSERT INTO account VALUES (?, ?)";
        PreparedStatement preparedStatement = connect.prepareStatement(sql);
        long begin = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            preparedStatement.setString(1, "jack" + i);
            preparedStatement.setInt(2, i);
            preparedStatement.execute();
        }
        System.out.println(System.currentTimeMillis() - begin);
        preparedStatement.close();
    }

    @Test
    public void test2() throws SQLException {
        String sql = "INSERT INTO account VALUES (?, ?)";
        PreparedStatement preparedStatement = connect.prepareStatement(sql);
        long begin = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            preparedStatement.setString(1, "jack" + i);
            preparedStatement.setInt(2, i);
            preparedStatement.addBatch(); // 加入到批处理
        }
        preparedStatement.executeBatch(); // 执行
        System.out.println(System.currentTimeMillis() - begin);
        preparedStatement.close();
    }
}
