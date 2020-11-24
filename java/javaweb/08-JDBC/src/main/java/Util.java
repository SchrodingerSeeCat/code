import java.sql.*;

public class Util {
    // 配置信息
    private static final String url = "jdbc:mysql://localhost:3306/jdbc?useUnicode=true&characterEncoding=utf-8";
    private static final String username = "root";
    private static final String password = "123456";

    private static Connection con = null;

    static {

        try {
            // 加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 获取数据库的连接
            con = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static Connection getCon() {
        return con;
    }

    public static void close(ResultSet rs, PreparedStatement ps) {
        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
