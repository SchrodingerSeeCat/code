package com.valid.jdbc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

@DisplayName("快速入门")
public class JDBCTest01 {
    @Test
    @DisplayName("第一种连接方式")
    public void test() throws SQLException {
        // 1. 注册驱动
        Driver driver = new com.mysql.cj.jdbc.Driver();

        // 2. 得到连接
        String url = "jdbc:mysql://localhost:3306/test?useSSL=true&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "123456");
        Connection connect = driver.connect(url, info);

        // 3. crud
        String sql = "INSERT INTO actor VALUES(NULL, '刘德华', '男', '1970-11-11', '110')";
        Statement statement = connect.createStatement();
        int rows = statement.executeUpdate(sql); // 返回影响的行数
        System.out.println(rows);

        // 4. 关闭连接
        statement.close();
        connect.close();
    }

    @Test
    @DisplayName("第二种连接方式")
    public void test2() throws Exception {
        // 反射加载
        Class<?> cls = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver)cls.getConstructor().newInstance();

        String url = "jdbc:mysql://localhost:3306/test?useSSL=true&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "123456");
        Connection connect = driver.connect(url, info);

        connect.close();
    }

    @Test
    @DisplayName("DriverManager")
    public void test3() throws Exception{
        // 加载Driver
        Class<?> cls = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver)cls.getConstructor().newInstance();

        // 使用DriverManager管理
        String url = "jdbc:mysql://localhost:3306/test?useSSL=true&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
        String user = "root";
        String password = "123456";

        DriverManager.registerDriver(driver); // 注册驱动
        Connection connect = DriverManager.getConnection(url, user, password);

        connect.close();
    }

    @Test
    @DisplayName("自动注册驱动")
    public void test4() throws Exception{
        // 加载Driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 使用DriverManager管理
        String url = "jdbc:mysql://localhost:3306/test?useSSL=true&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
        String user = "root";
        String password = "123456";

        Connection connect = DriverManager.getConnection(url, user, password);

        connect.close();
    }

    @Test
    @DisplayName("配置文件")
    public void test5() throws Exception{
        // 加载Driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 使用DriverManager管理
        Properties info = new Properties();
        info.load(new FileInputStream("jdbc.properties"));

        Connection connect = DriverManager.getConnection((String) info.get("url"), info);

        connect.close();
    }
}
