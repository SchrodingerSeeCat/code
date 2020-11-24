import java.sql.*;

public class JDBCTest2 {
    public static void main(String[] args) {
        // 配置信息
        String url = "jdbc:mysql://localhost:3306/jdbc?useUnicode=true&characterEncoding=utf-8";
        String username = "root";
        String password = "123456";

        // 获取数据库的连接
        Connection con = null;
        PreparedStatement ps = null;
        try {
            // 加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(url, username, password);

            // 开启事物,false开启
            con.setAutoCommit(false);

            String sql = "update account set money = money - 100 where name='A'";
            ps = con.prepareStatement(sql);
            ps.executeUpdate();

            int i = 1/0;

            String sql2 = "update account set money = money + 100 where name='B'";
            ps = con.prepareStatement(sql2);
            ps.executeUpdate();

            con.commit();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }   catch (SQLException e) {
            e.printStackTrace();
        }  finally {


            if (con != null) {
                try {
                    con.rollback();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

    }
}
