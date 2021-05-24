package com.valid.jdbc;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

// 封装自己的JDBCUtils
public class JDBCUtils {
    private static final String user;         // 用户名
    private static final String password;     // 密码
    private static final String url;          // url
    private static final String driver;       // 驱动

    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("jdbc.properties"));
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            url = properties.getProperty("url");
            driver = properties.getProperty("driver");
        } catch (Exception e) {
            throw new RuntimeException(e); // 将编译异常转为运行异常
        }
    }

    // 获取连接
    public static Connection getConnect() {
        try {
            Class.forName(driver);
            return DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // 关闭连接
    public static void close(ResultSet set, Statement statement, Connection connection) {
        if (set != null) {
            try {
                set.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
