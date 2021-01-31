package com.example.demo.widget;


import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import androidx.appcompat.widget.AppCompatButton;

// 自定义的Button
public class MyButton extends AppCompatButton {

    // 三个构造方法 一定都要重写
    public MyButton(Context context) {
        super(context);
    }

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {

        Log.d("MyButton", "事件分发的入口方法");
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);

        // 处理事件
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                // 按下的事件
                Log.d("MyButton", "---onTouchEvent---");
                break;
        }

        // true表示事件在在本次处理过之后，不会再向上传播，false则相反
        return true;
    }
}
