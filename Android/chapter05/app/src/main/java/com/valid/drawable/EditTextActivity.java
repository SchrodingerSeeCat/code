package com.valid.drawable;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import org.w3c.dom.Text;

public class EditTextActivity extends AppCompatActivity {

    private EditText et_username;
    private EditText et_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);

        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);

        // 添加监听事件
        et_username.addTextChangedListener(new TextWatcher() {

            // 在编辑框输入文本变化前触发
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            // 在编辑框输入文本变化时触发
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            // 在编辑框输入文本变化后触发
            @Override
            public void afterTextChanged(Editable s) {
                String str = s.toString();

                // 如果输入文本达到10位时关闭输入法
                if(str.length() == 10) {
                    hideOneInputMethod(EditTextActivity.this, et_username);
                }
            }
        });
    }

    // 关闭软键盘
    public static void hideOneInputMethod(Activity act, View v) {
        // 从系统服务中获取输入法管理器
        InputMethodManager imm = (InputMethodManager) act.getSystemService(Context.INPUT_METHOD_SERVICE);

        // 关闭屏幕上的输入法软键盘
        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }
}