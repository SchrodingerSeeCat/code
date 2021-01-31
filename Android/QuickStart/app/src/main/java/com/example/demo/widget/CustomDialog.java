package com.example.demo.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.demo.R;

// 自定义dialog
public class CustomDialog extends Dialog implements View.OnClickListener {

    private TextView tvTitle;
    private TextView tvMessage;
    private TextView tvCancel;
    private TextView tvConfirm;

    private String title;
    private String message;
    private String cancel;
    private String confirm;

    private MyOnCancelListener myOnCancelListener;
    private MyOnConfirmListener myOnConfirmListener;

    public CustomDialog setTitle(String title) {
        this.title = title;
        return this;
    }

    public CustomDialog setMessage(String message) {
        this.message = message;
        return this;
    }

    // 设置内容与监听事件
    public CustomDialog setCancel(String cancel, MyOnCancelListener listener) {
        this.cancel = cancel;
        this.myOnCancelListener = listener;
        return this;
    }

    // 设置内容与监听事件
    public CustomDialog setConfirm(String confirm, MyOnConfirmListener listener) {
        this.confirm = confirm;
        this.myOnConfirmListener = listener;
        return this;
    }

    public CustomDialog(@NonNull Context context) {
        super(context);
    }

    public CustomDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_custom_dialog);

        // 设置Dialog的宽度
        WindowManager m = getWindow().getWindowManager();
        Display d = m.getDefaultDisplay();
        WindowManager.LayoutParams p = getWindow().getAttributes();
        Point size = new Point();
        d.getSize(size);
        p.width = (int) (size.x * 0.8); // 设置Dialog的宽度为当前手机屏幕宽度的80%
        getWindow().setAttributes(p);

        tvTitle = findViewById(R.id.tv_title);
        tvMessage = findViewById(R.id.tv_message);
        tvCancel = findViewById(R.id.tv_cancel);
        tvConfirm = findViewById(R.id.tv_confirm);

        // 赋值
        if(title != null || title.length() != 0) {
            tvTitle.setText(title);
        }

        if(message != null || message.length() != 0) {
            tvMessage.setText(message);
        }

        if(cancel != null || cancel.length() != 0) {
            tvCancel.setText(cancel);
        }

        if(confirm != null || cancel.length() != 0) {
            tvConfirm.setText(confirm);
        }

        // 设置 cancel 和 confirm 的点击事件
        tvCancel.setOnClickListener(this);
        tvConfirm.setOnClickListener(this);

        // 设置点击外侧不能取消dialog
        setCancelable(false);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_cancel:
                if(myOnCancelListener != null) {
                    myOnCancelListener.onCancel(this);
                }
                break;
            case R.id.tv_confirm:
                if(myOnConfirmListener != null) {
                    myOnConfirmListener.onConfirm(this);
                }
                break;
        }
    }

    // 取消按钮点击事件的接口
    public interface MyOnCancelListener   {
        void onCancel(CustomDialog dialog);
    }

    // 确定按钮点击事件的接口
    public interface MyOnConfirmListener {
        void onConfirm(CustomDialog dialog);
    }
}
