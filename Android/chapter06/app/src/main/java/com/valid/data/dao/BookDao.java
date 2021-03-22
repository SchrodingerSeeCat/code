package com.valid.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.valid.data.entity.BookInfo;

import java.util.List;

@Dao
public interface BookDao {
    @Query("SELECT * FROM BookInfo") // 设置查询语句
    List<BookInfo> getAllBook(); // 加载所有图书信息

    @Query("SELECT * FROM BookInfo WHERE name=:name") // 根据名字查询图书
    BookInfo getBookByName(String name);

    @Insert(onConflict = OnConflictStrategy.REPLACE) // 记录重复时替换原记录
    void insertOneBook(BookInfo book); // 插入一条图书信息

    @Insert
    void insertBookList(List<BookInfo> bookList); // 插入多条图书信息

    @Delete
    int updateBook(BookInfo book); // 删除图书信息

    @Query("DELETE FROM BookInfo WHERE 1=1") // 设置删除语句
    void deleteAllBook(); // 删除所有图书的信息
}
