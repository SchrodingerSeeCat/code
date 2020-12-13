package com.valid.dao;


import com.valid.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {
    // 添加一本书
    int addBook(Books book);

    // 删除一本书
    int deleteBookById(@Param("id") int id);

    // 更新一本书
    int updateBook(Books book);

    // 查询一本书
    Books queryById(@Param("id") int id);

    // 查询全部书
    List<Books> queryAll();

    // 根据名字查询书籍
    Books queryBookByName(String bookName);
}
