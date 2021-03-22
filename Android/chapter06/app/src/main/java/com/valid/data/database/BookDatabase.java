package com.valid.data.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.valid.data.dao.BookDao;
import com.valid.data.entity.BookInfo;

// entities表示数据库中的表, version数据库的版本号, exportSchema 表示是否导出数据库的json字符串
@Database(entities = {BookInfo.class}, version = 1, exportSchema = false)
public abstract class BookDatabase extends RoomDatabase {
    // 获取该数据库中某张表的持久化对象
    public abstract BookDao bookDao();
}
