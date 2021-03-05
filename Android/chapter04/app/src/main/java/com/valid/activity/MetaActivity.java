package com.valid.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/*
* 获取meta信息到展示界面
* meta的value只允许当前活动获取
* */
public class MetaActivity extends AppCompatActivity {

    private TextView tv_value;
    private Button btn_meta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meta);

        tv_value = findViewById(R.id.tv_value);
        btn_meta = findViewById(R.id.btn_meta);

        btn_meta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 获取应用包管理器
                PackageManager pm = getPackageManager();

                // 从应用包管理器中获取当前的活动信息
                try {
                    ActivityInfo act = pm.getActivityInfo(getComponentName(), PackageManager.GET_META_DATA);
                    Bundle bundle = act.metaData; //获取活动附加的元数据信息
                    String value = bundle.getString("weather"); // 从bundle取出数据

                    tv_value.setText(value);
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}