package com.valid.data.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.valid.data.dao.GoodDao;
import com.valid.data.entity.Good;

@Database(entities = {Good.class}, version = 1, exportSchema = false)
public abstract class GoodDatabase extends RoomDatabase {
    public abstract GoodDao goodDao();
}
