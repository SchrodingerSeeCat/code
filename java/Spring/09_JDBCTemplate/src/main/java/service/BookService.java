package service;

import dao.BookDao;
import entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
