package com.example.demo.broadcast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.demo.R;

public class BroadActivity extends AppCompatActivity {

    private Button btn1;
    private TextView mTvTest;
    private MyBroadcast broadcast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad);

        btn1 = findViewById(R.id.btn_1);
        mTvTest = findViewById(R.id.tv_test);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BroadActivity.this, BroadActivity2.class);
                startActivity(intent);
            }
        });

        // 注册广播
        broadcast = new MyBroadcast();
        IntentFilter intentFilter = new IntentFilter();
        // 添加要处理的广播
        intentFilter.addAction("com.example.update");
        LocalBroadcastManager.getInstance(this).registerReceiver(broadcast, intentFilter);
    }

    // 编写接受广播的类
    private class MyBroadcast extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            switch (intent.getAction()) {
                case "com.example.update":
                    mTvTest.setText("123");
                    break;
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        // 将注册的广播注销
        LocalBroadcastManager.getInstance(this).unregisterReceiver(broadcast);
    }
}