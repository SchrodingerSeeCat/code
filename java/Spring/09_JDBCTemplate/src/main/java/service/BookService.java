package service;

import dao.BookDao;
import entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    // 注入dao
    @Autowired
    private BookDao bookDao;

    // 添加方法
    public void addBook(Book book) {
        bookDao.add(book);
    }

    // 修改的方法
    public void updateBook(Book book) {
        bookDao.update(book);
    }

    // 删除
    public void deleteBook(String id) {
        bookDao.delete(id);
    }

    // 查询表的记录数
    public int allSum() {
        return bookDao.count();
    }

    // 返回某一条记录
    public Book findOne(String id) {
        return bookDao.findOne(id);
    }

    // 返回集合
    public List<Book> findAll() {
        return bookDao.AllBook();
    }

    // 批量添加
    public void batchAdd(List<Object[]> batchArgs) {
        bookDao.batchAddBook(batchArgs);
    }
}
