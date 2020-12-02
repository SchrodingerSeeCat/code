package dao;

import entity.Book;

import java.util.List;

public interface BookDao {
    void add(Book book);
    void update(Book book);
    void delete(String id);
    int count();
    Book findOne(String id);
    List<Book> AllBook();

    // 批量操作
    void batchAddBook(List<Object[]> batchArgs);
    void batchUpdateBook(List<Object[]> batchArgs);
}
