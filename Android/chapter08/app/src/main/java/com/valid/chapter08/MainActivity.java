package com.valid.chapter08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.valid.chapter08.activity.DynamicActivity;
import com.valid.chapter08.activity.StaticActivity;
import com.valid.chapter08.activity.TestBottomNavigation;

public class MainActivity extends AppCompatActivity {
    
    private Button btn_static;  // 静态碎片
    private Button btn_dynamic; // 动态碎片
    private Button btn_bottom;  // 动态碎片

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        btn_dynamic = findViewById(R.id.btn_dynamic);
        btn_static = findViewById(R.id.btn_static);
        btn_bottom = findViewById(R.id.btn_bottom);

        View.OnClickListener click = new MyClick();

        btn_dynamic.setOnClickListener(click);
        btn_static.setOnClickListener(click);
        btn_bottom.setOnClickListener(click);
    }


    private class MyClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()){
                case R.id.btn_static:
                    intent = new Intent(MainActivity.this, StaticActivity.class);
                    break;
                case R.id.btn_dynamic:
                    intent = new Intent(MainActivity.this, DynamicActivity.class);
                    break;
                case R.id.btn_bottom:
                    intent = new Intent(MainActivity.this, TestBottomNavigation.class);
                    break;
            }
            startActivity(intent);
        }
    }
}