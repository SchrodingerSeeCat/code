package com.valid.jdbc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCUtilsTest {
    @Test
    @DisplayName("JDBCUtils测试")
    public void test() throws SQLException {
        // 1. 得到连接
        Connection connect = JDBCUtils.getConnect();

        // 2. 组织一个sql
        String sql = "UPDATE actor SET name = ? WHERE id = ?";

        // 3. 创建PreparedStatement对象
        PreparedStatement preparedStatement = connect.prepareStatement(sql);
        preparedStatement.setString(1, "王威");
        preparedStatement.setInt(2, 1);

        int i = preparedStatement.executeUpdate();
        System.out.println(i);
        preparedStatement.close();
    }
}
