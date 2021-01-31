package com.example.demo.other.handler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.Toast;

import com.example.demo.R;

/*
* Handler 未来某时做某事、线程间通信
* */
public class HandlerActivity extends AppCompatActivity {
    // 声明Handler
    private Handler mHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);

        // 延时3s跳转至TestActivity
//        mHandler = new Handler();
//        mHandler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Intent intent = new Intent(HandlerActivity.this, TestActivity.class);
//                startActivity(intent);
//            }
//        }, 3000);


        //线程通信
        mHandler = new Handler(Looper.myLooper()){
            @Override
            public void handleMessage(@NonNull Message msg) {
                switch (msg.what) {
                    case 1:
                        Toast.makeText(HandlerActivity.this, "我收到了消息：1", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        };

        new Thread(){
            @Override
            public void run() {
                Message message = new Message();
                // 设置消息标志
                message.what = 1;
                mHandler.sendMessage(message);
            }
        }.start();
    }
}