package com.valid.data;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn_share;
    private Button btn_sqlite;
    private Button btn_sqlite_helper;
    private Button btn_memory_card;
    private Button btn_zoom;
    private Button btn_online;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 查找控件对应的id
        findId();

        // 绑定点击事件
        addOnClick();
    }

    private void findId() {
        btn_share = findViewById(R.id.btn_share);
        btn_sqlite = findViewById(R.id.btn_sqlite);
        btn_sqlite_helper = findViewById(R.id.btn_sqlite_helper);
        btn_memory_card = findViewById(R.id.btn_memory_card);
        btn_zoom = findViewById(R.id.btn_zoom);
        btn_online = findViewById(R.id.btn_online);
    }

    private void addOnClick() {
        MyOnClick click = new MyOnClick();

        btn_share.setOnClickListener(click);
        btn_sqlite.setOnClickListener(click);
        btn_sqlite_helper.setOnClickListener(click);
        btn_memory_card.setOnClickListener(click);
        btn_zoom.setOnClickListener(click);
        btn_online.setOnClickListener(click);
    }
    private class MyOnClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()) {
                case R.id.btn_share:
                    intent = new Intent(MainActivity.this, SharedPreferencesActivity.class);
                    break;
                case R.id.btn_sqlite:
                    intent = new Intent(MainActivity.this, SQLiteDatabaseActivity.class);
                    break;
                case R.id.btn_sqlite_helper:
                    intent = new Intent(MainActivity.this, SQLiteReadActivity.class);
                    break;
                case R.id.btn_memory_card:
                    intent = new Intent(MainActivity.this, MemoryCardActivity.class);
                    break;
                case R.id.btn_zoom:
                    intent = new Intent(MainActivity.this, BookActivity.class);
                    break;
                case R.id.btn_online:
                    intent = new Intent(MainActivity.this, OnlineShopActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}