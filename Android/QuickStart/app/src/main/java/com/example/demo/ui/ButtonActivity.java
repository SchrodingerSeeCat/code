package com.example.demo.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.demo.R;

public class ButtonActivity extends AppCompatActivity {
    private Button mBtn6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);

        // 第一种实现点击的方式(常用)
        mBtn6 = findViewById(R.id.btn_6);
        mBtn6.setOnClickListener(view -> {
            Toast.makeText(ButtonActivity.this, "java点击事件", Toast.LENGTH_SHORT).show();
        });
    }

    // 第二种实现点击的方式 (不常用)
    // 点击 会弹出提示框
    public void showToast(View view) {
        Toast.makeText(this, "点击事件", Toast.LENGTH_SHORT).show();
    }
}