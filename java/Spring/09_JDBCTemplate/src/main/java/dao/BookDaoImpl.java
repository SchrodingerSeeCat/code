package dao;

import entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao{
    // 注入jdbcTemplate
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public void add(Book book) {
        // 创建sql语句
        String sql = "INSERT INTO book(username, ustatus) VALUES (?,?)";

        // 调用方法实现
        int update = jdbcTemplate.update(sql, book.getUsername(), book.getStatus());
        System.out.println("受影响的行数: " + update);
    }

    @Override
    public void update(Book book) {
        // 修改操作
        String sql = "UPDATE book set username=?, ustatus=? WHERE user_id=?";
        int update = jdbcTemplate.update(sql, book.getUsername(), book.getStatus(), book.getUserId());
        System.out.println("受影响的行数：" + update);
    }

    @Override
    public void delete(String id) {
        // 删除操作
        String sql = "DELETE FROM book WHERE user_id=?";
        int update = jdbcTemplate.update(sql, id);
        System.out.println("受影响的行数：" + update);
    }
}
