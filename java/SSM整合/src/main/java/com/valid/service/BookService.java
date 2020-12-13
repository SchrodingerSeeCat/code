package com.valid.service;

import com.valid.pojo.Books;

import java.util.List;

public interface BookService {

    // 添加一本书
    int addBook(Books book);

    // 删除一本书
    int deleteBookById(int id);

    // 更新一本书
    int updateBook(Books book);

    // 查询一本书
    Books queryById(int id);

    // 查询全部书
    List<Books> queryAll();

    // 根据名字查询书籍
    Books queryBookByName(String bookName);
}
