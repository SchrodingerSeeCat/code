package com.valid.service;

import com.valid.dao.BookMapper;
import com.valid.pojo.Books;

import java.util.List;

public class BookServiceImpl implements BookService{
    // service调dao层：注入dao层实例
    private BookMapper bookMapper;

    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @Override
    public int addBook(Books book) {
        return bookMapper.addBook(book);
    }

    @Override
    public int deleteBookById(int id) {
        return bookMapper.deleteBookById(id);
    }

    @Override
    public int updateBook(Books book) {
        return bookMapper.updateBook(book);
    }

    @Override
    public Books queryById(int id) {
        return bookMapper.queryById(id);
    }

    @Override
    public List<Books> queryAll() {
        return bookMapper.queryAll();
    }
}
