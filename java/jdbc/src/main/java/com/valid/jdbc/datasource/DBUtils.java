package com.valid.jdbc.datasource;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.valid.jdbc.entity.Actor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.List;
import java.util.Properties;

// Apache DBUtils
public class DBUtils {
    private static DataSource dataSource;
    static {
        // 1. 创建Properties
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(DruidTest.class.getResource("/").getFile() + "druid.properties"));
            // 2. 创建数据源
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public static void main(String ...args) throws Exception{
//        // 1. 获取连接
//        Connection connection = dataSource.getConnection();
//
//        // 2. 创建QueryRunner
//        QueryRunner queryRunner = new QueryRunner();
//
//        // 3. 执行SQL
//        List<Actor> list = queryRunner.query(
//                connection,
//                "SELECT * FROM actor WHERE id > ?",
//                new BeanListHandler<>(Actor.class), 1);
//
//        System.out.println(list);
//
//        connection.close();
//    }

    public static void main(String ...args) throws Exception{
        // 1. 获取连接
        Connection connection = dataSource.getConnection();

        // 2. 创建QueryRunner
        QueryRunner queryRunner = new QueryRunner();

        // 3. 执行SQL
        int rows = queryRunner.update(
                connection,
                "UPDATE actor SET name = ? WHERE id = ?",
                "彭于晏", 1);

        System.out.println(rows);

        connection.close();
    }
}
