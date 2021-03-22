package com.valid.data;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import com.valid.data.dao.BookDao;
import com.valid.data.database.BookDatabase;
import com.valid.data.database.GoodDatabase;

import java.util.HashMap;

/*
* App启动时第一个加载的类,需要在AndroidManifest.xml中配置<application />的name属性为当前类名
* */
public class MainApplication extends Application {

    private static MainApplication mApp; // 设计单例模式
    private HashMap<String, String> infoMap = new HashMap<>(); // 保存全局变量
    private BookDatabase bookDatabase; // 声明一个图书数据库对象
    private GoodDatabase goodDatabase; // 声明一个图书数据库对象

    public void saveInfo(String name, String value) {
        infoMap.put(name, value);
    }

    public String getInfo(String name) {
        return infoMap.get("name");
    }

    // 获取实例
    public static MainApplication getInstance() {
        return mApp;
    }

    // App启动时调用此方法
    @Override
    public void onCreate() {
        super.onCreate();
        mApp = this; // 保存application的唯一实例

        // 生成BookInfo的数据库对象
        bookDatabase = Room.databaseBuilder(mApp, BookDatabase.class, "BookInfo")
                           .addMigrations() // 允许自动迁移
                           .allowMainThreadQueries() // 允许在主线程中操作数据库(默认不能)
                           .build();
        goodDatabase = Room.databaseBuilder(mApp, GoodDatabase.class, "Good")
                           .addMigrations()
                           .allowMainThreadQueries()
                           .build();
    }

    // 获取图书数据库的实例
    public BookDatabase getBookDatabase() {
        return bookDatabase;
    }

    // 获取商品数据库的实例
    public GoodDatabase getGoodDatabase() {
        return goodDatabase;
    }

    // App终止时调用 但该方法共模拟环境使用,真机上永远不会被调用
    @Override
    public void onTerminate() {
        super.onTerminate();
        Log.d("onTerminate(): ", "被调用了");
    }
}
