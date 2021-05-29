package com.valid.jdbc.datasource;

import com.alibaba.druid.pool.DruidAbstractDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

//@DisplayName("Druid测试")
public class DruidTest {
    public static void main(String[] args) throws Exception{
        // 1. 创建Properties
        Properties properties = new Properties();
        properties.load(new FileInputStream(DruidTest.class.getResource("/").getFile() + "druid.properties"));
        // 2. 创建数据源
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        Connection connection = dataSource.getConnection();

        connection.close();
    }
}
