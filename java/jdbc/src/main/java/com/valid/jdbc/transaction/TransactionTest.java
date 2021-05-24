package com.valid.jdbc.transaction;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@DisplayName("事物")
public class TransactionTest {
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
    @DisplayName("默认情况下的事务")
    public void transaction() {
        String sql = "UPDATE account SET balance = balance - 100 WHERE name = '马云'";
        Statement statement = null;
        try {
            statement = connect.createStatement();
            statement.executeUpdate(sql);

            if (true) {
                throw new Exception("模拟出现异常");
            }

            sql = "UPDATE account SET balance = balance + 100 WHERE name = '马化腾'";
            statement.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    @DisplayName("手动提交事务")
    public void transaction2() {
        String sql = "UPDATE account SET balance = balance - 100 WHERE name = '马云'";
        Statement statement = null;
        try {
            connect.setAutoCommit(false); // 使用事物
            statement = connect.createStatement();
            statement.executeUpdate(sql);

            if (true) {
                throw new Exception("模拟出现异常");
            }

            sql = "UPDATE account SET balance = balance + 100 WHERE name = '马化腾'";
            statement.executeUpdate(sql);

            connect.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                connect.rollback();
            } catch (SQLException re) {
                re.printStackTrace();
            }
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
