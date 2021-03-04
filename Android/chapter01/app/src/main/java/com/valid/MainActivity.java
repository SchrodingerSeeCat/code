package com.valid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Button的测试Activity
    private Button btn_btn;
    // ImageView的测试Activity
    private Button btn_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 当前界面使用 activity_main 布局文件
        setContentView(R.layout.activity_main);

        MyOnclickListener click = new MyOnclickListener();

        btn_btn = findViewById(R.id.btn_btn);
        btn_btn.setOnClickListener(click);

        btn_image = findViewById(R.id.btn_image);
        btn_image.setOnClickListener(click);
    }

    private class MyOnclickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()) {
                case R.id.btn_btn:
                    intent = new Intent(MainActivity.this, ButtonActivity.class);
                    break;
                case R.id.btn_image:
                    intent = new Intent(MainActivity.this, ImageActivity.class);
                    break;
                default:
                    intent = new Intent(MainActivity.this, MainActivity.class);
            }
            startActivity(intent);
        }
    }
}