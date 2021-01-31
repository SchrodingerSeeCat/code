package com.example.demo.datastorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.demo.R;

import org.w3c.dom.Text;


/*
* 实现点击btnSave保存editText中内容，点击btnShow将保存的内容展示到tvShow
* */
public class SharedPreferencesActivity extends AppCompatActivity {

    private EditText editText;
    private Button btnSave;
    private Button btnShow;
    private TextView tvShow;

    // 读
    private SharedPreferences mSharedPreferences;
    // 编辑
    private SharedPreferences.Editor mEditor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);

        editText = findViewById(R.id.et_name);
        btnSave = findViewById(R.id.btn_save);
        btnShow = findViewById(R.id.btn_show);
        tvShow = findViewById(R.id.tv_show);

        // 获取SharedPreferences实例
        // 第一个参数，保存的文件名，第二参数，保存的模式 MODE_PRIVATE 只允许当前应用进行读写
        mSharedPreferences = getSharedPreferences("data", MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();

        // 点击保存editText中的内容
        btnSave.setOnClickListener(v -> {
            mEditor.putString("msg", editText.getText().toString());
            // 数据写入之后一定要提交
            /*
            * 提交的方式有两种
            * 1. commit 这是一个同步的过程，内存和硬盘上的数据会同时修改
            * 2. apply 这是一个异步的过程，它会直接修改内存中的数据，硬盘中的数据的修改则会在后台进行
            * */
            mEditor.apply();

            // 清除输入框中的内容，并让其失去焦点
            editText.setText("");
            editText.clearFocus();
        });

        // 点击btnShow将保存的内容展示到tvShow
        btnShow.setOnClickListener(v -> {
            String msg = mSharedPreferences.getString("msg", "没有读到值");
            tvShow.setText(msg);
        });
    }
}