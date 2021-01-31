package com.example.demo.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.demo.R;

// 登录界面的制作
public class EditTextActivity extends AppCompatActivity {

    // 声明控件
    private Button mBtn7;
    private EditText user;
    private EditText pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);

        mBtn7 = findViewById(R.id.btn_login);
        mBtn7.setOnClickListener(view -> {
            Toast.makeText(EditTextActivity.this, "登录", Toast.LENGTH_SHORT).show();
        });


        // 监听EditText内容的变化
        user = findViewById(R.id.et_1);
        user.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // 文本改变之前
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // 文本改变时
                Log.d("editText", s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                // 文本改变之后
            }
        });
    }
}