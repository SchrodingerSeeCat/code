package com.example.demo.broadcast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.demo.R;

/*
* 实现当点击btnClick时，通过广播改变BroadActivity中TextView的数据
* */
public class BroadActivity2 extends AppCompatActivity {

    private Button btnClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad2);

        btnClick = findViewById(R.id.btn_click);
        btnClick.setOnClickListener(v -> {

            // 动作的名称随便起
            Intent intent = new Intent("com.example.update");
            // 发起广播
            LocalBroadcastManager.getInstance(BroadActivity2.this).sendBroadcast(intent);
        });
    }
}