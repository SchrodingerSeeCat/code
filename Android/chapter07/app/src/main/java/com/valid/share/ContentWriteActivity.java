package com.valid.share;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.text.format.DateUtils;

import com.valid.share.bean.UserInfo;
import com.valid.share.provider.UserInfoContent;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ContentWriteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_write);
    }

    private void addUser(UserInfo user) {
        ContentValues name = new ContentValues();

        name.put("name", user.name);
        name.put("age", user.age);
        name.put("height", user.height);
        name.put("weight", user.weight);
        name.put("update_time", System.currentTimeMillis());

        // 通过内容给你解析器往指定Uri添加用户信息
        getContentResolver().insert(UserInfoContent.CONTENT_URI, name);
    }

    private void deleteAllUser() {
        getContentResolver().delete(UserInfoContent.CONTENT_URI, "1=1", null);
    }

    private void showAllUser() {
        List<UserInfo> list = new ArrayList<>();

        // 通过内容解析器从指定Uri中获取用户记录的游标
        Cursor cursor = getContentResolver().query(UserInfoContent.CONTENT_URI, null, null, null);

        // 循环取出游标指向的每条用户记录
        while (cursor.moveToNext()) {
            UserInfo user = new UserInfo();
            user.name = cursor.getString(cursor.getColumnIndex(UserInfoContent.USER_NAME));
        }
    }
}