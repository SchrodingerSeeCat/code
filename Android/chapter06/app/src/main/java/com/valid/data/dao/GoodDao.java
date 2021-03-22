package com.valid.data.dao;

import androidx.room.Dao;
import androidx.room.Query;

import com.valid.data.entity.Good;

import java.util.List;

@Dao
public interface GoodDao {

    @Query("SELECT * FROM Good")
    List<Good> getAllGoods();
}
