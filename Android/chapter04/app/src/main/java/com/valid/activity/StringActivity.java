package com.valid.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class StringActivity extends AppCompatActivity {

    private TextView tv_string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_string);

        tv_string = findViewById(R.id.tv_string);

        // 从资源文件中获取字符串
        tv_string.setText(getString(R.string.title));
    }
}