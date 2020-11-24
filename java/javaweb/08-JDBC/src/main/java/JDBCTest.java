import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCTest {
    public static void main(String[] args) throws Exception {
        // 配置信息
        String url = "jdbc:mysql://localhost:3306/jdbc?useUnicode=true&characterEncoding=utf-8";
        String username = "root";
        String password = "123456";

        // 加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 获取数据库的连接
        Connection con = DriverManager.getConnection(url, username, password);

        // 获取向数据库发送SQL的对象statement：
        Statement statement = con.createStatement();

        // 编写SQL
        String sql = "SELECT * FROM users";

        // 执行查询SQL,返回一个结果集
        ResultSet result = statement.executeQuery(sql);


        while (result.next()) {
            System.out.print("id = " + result.getObject("id"));
            System.out.print("\tname = " + result.getObject("name"));
            System.out.print("\tpassword = " + result.getObject("password"));
            System.out.print("\temail = " + result.getObject("email"));
            System.out.print("\tbirthday = " + result.getObject("birthday") + "\n");
        }
        // 关闭连接
        result.close();
        statement.close();
        con.close();
    }
}
