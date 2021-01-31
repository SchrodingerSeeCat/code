package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.demo.animation.AnimationActivity;
import com.example.demo.broadcast.BroadActivity;
import com.example.demo.datastorage.DataStorageActivity;
import com.example.demo.event.EventActivity;
import com.example.demo.other.OtherActivity;
import com.example.demo.ui.UIActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnUI;
    private Button btnOther;
    private Button btnEvent;
    private Button btnData;
    private Button btnBroadCast;
    private Button btnAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Onclick onclick = new Onclick();

        // 跳转至UI界面
        btnUI = findViewById(R.id.btn_ui);
        btnUI.setOnClickListener(onclick);

        // 跳转至Other界面
        btnOther = findViewById(R.id.btn_other);
        btnOther.setOnClickListener(onclick);

        // 跳转至Event界面
        btnEvent = findViewById(R.id.btn_event);
        btnEvent.setOnClickListener(onclick);

        // 跳转至数据存储界面
        btnData = findViewById(R.id.btn_data);
        btnData.setOnClickListener(onclick);

        // 跳转至广播界面
        btnBroadCast = findViewById(R.id.btn_broadcast);
        btnBroadCast.setOnClickListener(onclick);

        // 跳转至动画界面
        btnAnimation = findViewById(R.id.btn_animation);
        btnAnimation.setOnClickListener(onclick);

        // 申请外部存储的权限
        ActivityCompat.requestPermissions(
                this,
                new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                1);
    }

    private class Onclick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Intent intent = null;

            switch (v.getId()) {
                case R.id.btn_ui:
                    intent = new Intent(MainActivity.this, UIActivity.class);
                    break;
                case R.id.btn_other:
                    intent = new Intent(MainActivity.this, OtherActivity.class);
                    break;
                case R.id.btn_event:
                    intent = new Intent(MainActivity.this, EventActivity.class);
                    break;
                case R.id.btn_data:
                    intent = new Intent(MainActivity.this, DataStorageActivity.class);
                    break;
                case R.id.btn_broadcast:
                    intent = new Intent(MainActivity.this, BroadActivity.class);
                    break;
                case R.id.btn_animation:
                    intent = new Intent(MainActivity.this, AnimationActivity.class);
                    break;
            }

            startActivity(intent);
        }
    }
}