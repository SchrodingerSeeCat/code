package com.valid.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class IntentActivity extends AppCompatActivity {

    private Button btn_implicit;
    private Button btn_bundle;
    private TextView tv_intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);

        tv_intent = findViewById(R.id.tv_intent);


        // 隐式跳转
        btn_implicit = findViewById(R.id.btn_implicit);
        btn_implicit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_DIAL); // 设置intent为待拨号动作
                Uri uri = Uri.parse("tel:" + "12345"); // 声明一个拨号的url
                intent.setData(uri); // 设置意图前往的路径
                startActivity(intent); // 启动意图通过的活动页面
            }
        });

        // Bundle携带数据
        btn_bundle = findViewById(R.id.btn_bundle);
        btn_bundle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 创建intent 准备跳转
                Intent intent = new Intent(IntentActivity.this, BundleActivity.class);

                // 创建bundle 放入数据
                Bundle bundle = new Bundle();
                bundle.putString("request", "我是IntentActivity携带过来的数据");
                intent.putExtras(bundle);

                // 期望下个页面的返回数据。第二个参数为本次的请求代码
                startActivityForResult(intent, 0);
            }
        });

    }

    // 接受返回数据
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        // intent非空，且请求代码为之前传的0，结果代码也成功
        if (intent != null && requestCode == 0 && resultCode == Activity.RESULT_OK) {
            Bundle bundle = intent.getExtras(); // 从返回的意图中获取bundle

            String response = bundle.getString("response");
            tv_intent.setText(response);
        }
    }
}