package com.valid.jdbc.datasource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

@DisplayName("C3P0测试")
public class C3P0Test {
    @Test
    @DisplayName("普通使用")
    public void test() throws Exception {
        // 1. 通过配置文件读取相关信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("jdbc.properties"));

        // 2. 创建数据源并设置相关参数
        ComboPooledDataSource dataSource = new ComboPooledDataSource();

        dataSource.setDriverClass(properties.getProperty("driver"));    // 驱动
        dataSource.setUser(properties.getProperty("user"));             // 用户名
        dataSource.setPassword(properties.getProperty("password"));     // 密码
        dataSource.setJdbcUrl(properties.getProperty("url"));           // url
        dataSource.setInitialPoolSize(10);                              // 初始化连接数
        dataSource.setMaxPoolSize(20);                                  // 最大连接数

        for (int i = 0; i < 5000; i++) {
            Connection connection = dataSource.getConnection();             // 获取连接

            connection.close();                                             // 关闭连接
        }
    }

    @Test
    @DisplayName("模板文件")
    public void test1() throws SQLException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource("my-config");
        Connection connection = comboPooledDataSource.getConnection();

        connection.close();
    }
}
