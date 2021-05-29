package com.valid.jdbc.dao;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.valid.jdbc.datasource.DruidTest;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public class BasicDao<E> {
    private static DataSource dataSource;
    private QueryRunner qr = new QueryRunner();
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

    // 更新
    public int update(String sql, Object ...parameters) {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            return qr.update(connection, sql, parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            this.close(connection);
        }
    }

    // 查询多条
    public List<E> queryList(String sql,
                             Class<E> clazz,
                             Object ...parameters) {
        return (List<E>) this.query(sql, clazz, new BeanListHandler<>(clazz), parameters);
    }

    // 查询单条结果
    public E querySingle(String sql,
                         Class<E> clazz,
                         Object ...parameters) {
        return (E) this.query(sql, clazz, new BeanHandler<>(clazz), parameters);
    }

    // 查询单值
    public Object queryScalar(String sql, Class<E> clazz, Object ...parameters) {
        return this.query(sql, clazz, new ScalarHandler<>(), parameters);
    }

    private Object query(String sql,
                         Class<E> clazz,
                         ResultSetHandler handler,
                         Object ...parameters) {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            return qr.query(connection, sql, handler, parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            this.close(connection);
        }
    }

    // 关闭连接
    private void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
