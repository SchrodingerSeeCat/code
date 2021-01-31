package com.example.demo.event;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.demo.R;
import com.example.demo.widget.MyButton;

public class EventActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnEvent;
    private MyButton btnMyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        btnEvent = findViewById(R.id.btn_event_1);
        btnMyButton = findViewById(R.id.btn_event_2);

        /*
        * 如果监听器和事件回调同时存在，则监听器优于事件回调前执行
        * */
        btnMyButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Log.d("Listener", "---onTouchEvent---");
                        break;
                }
                return false;
            }
        });

        btnMyButton.setOnClickListener(v -> {
            Log.d("Listener", "---onClick---");
        });

        /*
        * 设置事件监听器的五种方法
        * 如果对同一控件设置了多个相同类型的事件监听器，执行最后一个声明的方法 属性声明默认为第一个声明方法
        * */
        // 1. 内部类设置点击事件
//        OnClick onClick = new OnClick();
//        btnEvent.setOnClickListener(onClick);

        // 2. 匿名内部类
//        btnEvent.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(EventActivity.this, "Click2...", Toast.LENGTH_SHORT).show();
//            }
//        });

        // 3. 通过事件源所在的类实现，需要此类实现对应的事件接口
//        btnEvent.setOnClickListener(this);

        // 4. 通过外部类实现
//        btnEvent.setOnClickListener(new MyClickListener(EventActivity.this));
    }

    // 5. 通过布局文件中的onClick属性实现
    public void show(View v) {
        switch (v.getId()) {
            case R.id.btn_event_1:
                Toast.makeText(EventActivity.this, "Click5...", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_event_1:
                Toast.makeText(EventActivity.this, "Click3...", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    // 内部类实现事件处理
    private class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_event_1:
                    Toast.makeText(EventActivity.this, "Click1...", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }


    // 基于接口回调的事件处理方式
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d("Activity", "---onTouchEvent---");
                break;
        }

        // true表示事件在在本次处理过之后，不会再向上传播，false则相反
        return false;
    }
}