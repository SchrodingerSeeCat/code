import org.junit.Test;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class Dao {
    // 查询
    @Test
    public void check() {
        List<User> users = new LinkedList<>();

        // 创建预处理对象和结果集
        PreparedStatement ps = null;
        ResultSet rs = null;

        // 获取数据库连接
        Connection con = Util.getCon();

        // 编写sql
        String sql = "SELECT * FROM users";
        try {
            // 执行sql
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setBirthday(rs.getDate("birthday"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Util.close(rs, ps);
        }

        System.out.println(users);
    }

    // 增加、删除、更改
    @Test
    public void increase() {
        Connection con = Util.getCon();
        PreparedStatement ps = null;
        String sql = "INSERT INTO users(id, name, password, email, birthday) VALUES (?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);

            ps.setInt(1, 6);
            ps.setString(2, "多拉格尼尔");
            ps.setString(3, "123456");
            ps.setString(4, "jsfdg@qq.com");
            ps.setDate(5, new Date(System.currentTimeMillis()));

            int count = ps.executeUpdate();
            System.out.println("受影响的条数：" + count);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Util.close(null, ps);
        }
    }

}
