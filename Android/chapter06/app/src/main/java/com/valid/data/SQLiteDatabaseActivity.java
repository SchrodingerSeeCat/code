package com.valid.data;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

public class SQLiteDatabaseActivity extends AppCompatActivity {

    private TextView tv_msg;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_database_activity);

        // 创建名为test.db的数据库。数据库如果不存在就创建它，如果存在就打开它
        SQLiteDatabase db = openOrCreateDatabase(getFilesDir() + "/test.db", Context.MODE_PRIVATE, null);

        tv_msg = findViewById(R.id.tv_msg);
        tv_msg.setText(db != null ? db.getPath() : "数据库创建失败");
    }
}