package dao;

import entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

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

    @Override
    public int count() {
        // 查询总数
        String sql = "SELECT COUNT(*) FROM book";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    @Override
    public Book findOne(String id) {
        // 根据ID查询某一条记录

        String sql = "SELECT * FROM book WHERE user_id=?";
        // 第二个参数是一个接口，返回不同类型数据，使用这个接口里面实现类完成数据的封装
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Book>(Book.class), id);
    }

    @Override
    public List<Book> AllBook() {
        // 查询多条记录

        String sql = "SELECT * FROM book";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Book>(Book.class));
    }

    @Override
    public void batchAddBook(List<Object[]> batchArgs) {
        // 插入多条记录

        String sql = "INSERT INTO book VALUES(?, ?, ?)";
        int[] ints = jdbcTemplate.batchUpdate(sql, batchArgs);
        System.out.println(Arrays.toString(ints));
    }

    @Override
    public void batchUpdateBook(List<Object[]> batchArgs) {
        // 批量修改

        String sql = "UPDATE book set username=?, ustatus=? WHERE user_id=?";
        int[] ints = jdbcTemplate.batchUpdate(sql, batchArgs);
        System.out.println(Arrays.toString(ints));
    }
}
