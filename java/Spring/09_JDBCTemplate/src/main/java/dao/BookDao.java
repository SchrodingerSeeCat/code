package dao;

import entity.Book;

public interface BookDao {
    void add(Book book);
    void update(Book book);
    void delete(String id);
}
