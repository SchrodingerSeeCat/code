package com.valid.data;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SharedPreferencesActivity extends AppCompatActivity {

    private Button btn_get;
    private TextView tv_name;
    private TextView tv_age;
    private TextView tv_married;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);

        // 从share.xml中获取共享参数实例
        SharedPreferences share = getSharedPreferences("share", MODE_PRIVATE);

        // 获取编辑对象
        SharedPreferences.Editor editor = share.edit();

        // 存储数据
        editor.putString("name", "信阳学院");
        editor.putInt("age", 30);
        editor.putBoolean("married", false);

        // 提交
        editor.commit();

        tv_name = findViewById(R.id.tv_name);
        tv_age = findViewById(R.id.tv_age);
        tv_married = findViewById(R.id.tv_married);



        btn_get = findViewById(R.id.btn_get);
        btn_get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = share.getString("name", "");
                int age = share.getInt("age", 0);
                boolean married = share.getBoolean("married", false);

                tv_name.setText(name);
                tv_age.setText(age + "");
                tv_married.setText(married + "");
            }
        });
    }

}