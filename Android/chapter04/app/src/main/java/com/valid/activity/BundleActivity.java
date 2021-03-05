package com.valid.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BundleActivity extends AppCompatActivity {

    private TextView tv_msg;
    private Button btn_finish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bundle);

        // 获取上一个页面传递的bundle
        Bundle bundle = getIntent().getExtras();

        // 取出信息
        String request = bundle.getString("request");

        tv_msg = findViewById(R.id.tv_msg);
        tv_msg.setText(request);

        btn_finish = findViewById(R.id.btn_finish);
        btn_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(); // 创建一个新意图
                Bundle bundle = new Bundle(); // 创建一个bundle

                // 存储响应信息
                bundle.putString("response", "我是BundleActivity返回的信息");
                intent.putExtras(bundle);

                // 携带intent返回上一个页面，RESULT_OK表示处理成功
                setResult(Activity.RESULT_OK, intent);

                finish();
            }
        });
    }
}