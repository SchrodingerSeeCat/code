package com.valid.data.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.valid.data.entity.UserInfo;

import java.util.ArrayList;
import java.util.List;


public class MySQLite extends SQLiteOpenHelper {

    private static final String DB_MANE = "user.db"; // 数据库的名称
    private static MySQLite mySQLite = null; // 数据库帮助器
    private SQLiteDatabase mDB = null; //数据库的实例
    public static final String TABLE_NAME = "user_info"; // 表的名称

    public MySQLite(Context context, int version) {
        super(context, DB_MANE, null, version);
    }

    // 利用单例模式获取数据库帮助器的唯一实例
    public static MySQLite getInstance(Context context, int version) {
        if (version > 0 && mySQLite == null) {
            mySQLite = new MySQLite(context, version);
        }
        return mySQLite;
    }

    // 打开数据库的读连接
    public SQLiteDatabase openReadLink() {
        if (mDB == null || !mDB.isOpen()) {
            mDB = mySQLite.getReadableDatabase();
        }
        return mDB;
    }

    // 打开数据库的写连接
    public SQLiteDatabase openWriteLink() {
        if (mDB == null || !mDB.isOpen()) {
            mDB = mySQLite.getWritableDatabase();
        }
        return mDB;
    }

    // 关闭数据库的连接
    public void closeLink() {
        if (mDB != null && mDB.isOpen()) {
            mDB.close();
            mDB = null;
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // 第一次打开数据库时触发, 一般用于创建数据库，执行建表语句
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ("
                     + "_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                     + "name VARCHAR NOT NULL,"
                     + "age INTEGER NOT NULL,"
                     + "weight FLOAT NOT NULL,"
                     + "height INTEGER NOT NULL,"
                     + "married INTEGER NOT NULL,"
                     + "update_time VERCHAR NOT NULL,"
                     + "phone VARCHAR,"
                     + "password VARCHAR);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // 数据库版本升级时触发
    }

    // 根据指定条件删除表记录
    public int delete(String condition) {
        // 执行删除动作，该语句返回删除记录的数目
//        mDB.execSQL("DELETE FROM " + TABLE_NAME + "");
        return mDB.delete(TABLE_NAME, condition, null);
    }

    // 往该表中添加多条记录
    public long insert(List<UserInfo> list) {

        long result = 0;
        for(int i = 0; i < list.size(); i++) {
            UserInfo info = list.get(i);

            // 不存在唯一性重复的记录，则插入新记录
            ContentValues cv = new ContentValues();
            cv.put("name", info.getName());
            cv.put("age", info.getAge());
            cv.put("height", info.getHeight());
            cv.put("weight", info.getWeight());
            cv.put("married", info.getMarried());
            cv.put("update_time", info.getUpdateTime().toString());
            cv.put("phone", info.getPhone());
            cv.put("password", info.getPassword());

            // 执行插入记录动作，该语句返回插入记录的行号
            long count = mDB.insert(TABLE_NAME, "", cv);
            if (count == -1) {
                return count; //添加失败返回-1；
            } else {
                result++;
            }
        }
        return result;
    }

    // 根据条件更新指定的表记录
    public int update(UserInfo info, String condition) {
        ContentValues cv = new ContentValues();
        cv.put("name", info.getName());
        cv.put("age", info.getAge());
        cv.put("height", info.getHeight());
        cv.put("weight", info.getWeight());
        cv.put("married", info.getMarried());
        cv.put("phone", info.getPhone());
        cv.put("password", info.getPassword());

        return mDB.update(TABLE_NAME, cv, condition, null);
    }

    // 根据指定条件查询记录，并返回结果数据列表
    public List<UserInfo> query(String condition) {
        String sql = String.format("SELECT name, age, weight, height, married, update_time, phone, password "
                                    + "FROM %s WHERE %s;", TABLE_NAME, condition);
        List<UserInfo> list = new ArrayList<>(); // 存储结果

        // 执行记录查询动作，该语句返回结果集的游标
        Cursor cursor = mDB.rawQuery(sql, null);
        while(cursor.moveToNext()) {
            UserInfo info = new UserInfo();
            info.setName(cursor.getString(1));
            info.setAge(cursor.getInt(2));
            info.setWeight(cursor.getDouble(3));
            info.setHeight(cursor.getInt(4));
            info.setMarried(cursor.getInt(5) == 1);
            info.setUpdateTime(Long.parseLong(cursor.getString(6)));
            info.setPhone(cursor.getString(7));
            info.setPassword(cursor.getString(8));

            list.add(info);
        }
        cursor.close();
        return list;
    }
}
