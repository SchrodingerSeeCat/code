package com.example.demo.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import com.example.demo.R;

public class TextViewActivity extends AppCompatActivity {

    // 声明
    private TextView mTv4;
    private TextView mTv5;
    private TextView mTv6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);

        mTv4 = findViewById(R.id.tv_4);

        // 中划线
        mTv4.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        mTv4.getPaint().setAntiAlias(true); // 去除锯齿


        // 下划线
        mTv5 = findViewById(R.id.tv_5);
        mTv5.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);

        // 下划线 html方式
        mTv6 = findViewById(R.id.tv_6);
        mTv6.setText(Html.fromHtml("<u>Hello Android</u>"));
    }
}