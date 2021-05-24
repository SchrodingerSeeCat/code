package com.valid.jdbc;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.*;

public class ResultSetTest {
    private static Connection connect;
    @BeforeAll
    public static void before() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 使用DriverManager管理
        String url = "jdbc:mysql://localhost:3306/test?useSSL=true&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
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
    @DisplayName("结果集测试")
    public void test() throws Exception {
        Statement statement = connect.createStatement();
        String sql = "SELECT * FROM actor";
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            System.out.print(resultSet.getInt(1) + " ");
            System.out.print(resultSet.getString(2) + " ");
            System.out.print(resultSet.getString(3) + " ");
            System.out.print(resultSet.getDate(4) + " ");
            System.out.println(resultSet.getString(5));
        }

        // 关闭连接
        resultSet.close();
        statement.close();
    }

    @Test
    @DisplayName("预处理")
    public void test2() throws Exception {
        String username = "1' OR";
        String password = "OR '1' = '1";

        String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
        PreparedStatement statement = connect.prepareStatement(sql);
        statement.setString(1, username);
        statement.setString(2, password);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            System.out.println("登陆成功");
        } else {
            System.out.println("登陆失败");
        }

        resultSet.close();
        statement.close();
    }
}
