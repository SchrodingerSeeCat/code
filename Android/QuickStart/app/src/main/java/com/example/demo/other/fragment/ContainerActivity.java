package com.example.demo.other.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.demo.R;

public class ContainerActivity extends AppCompatActivity implements AFragment.IOnMessageClick {

    private AFragment aFragment;
    private Button btnChange;
    private BFragment bFragment;
    private TextView tvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        tvTitle = findViewById(R.id.tv_title);

        // 当发生点击事件时，将AFragment替换为BFragment
        btnChange = findViewById(R.id.btn_change);
        btnChange.setOnClickListener(view -> {
            if (bFragment == null) {
                bFragment = new BFragment();
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, bFragment).addToBackStack(null).commitAllowingStateLoss();
        });

        // 实例化AFragment
        aFragment = AFragment.newInstance("测试传参");

        // 把AFragment添加到Activity中
        // add 第一个参数 fragment的容器 第二个参数fragment 第三个参数fragment的标识
        getSupportFragmentManager().beginTransaction().add(R.id.fl_container, aFragment, "a").commitAllowingStateLoss();
    }

    // 接受来自Fragment的参数,并展示 不推荐
    public void setData(String msg) {
        tvTitle.setText(msg);
    }

    // 推荐的做法，在Fragment中编写一个接口，Activity通过接口回调的方式来传递消息
    @Override
    public void onClick(String msg) {
        tvTitle.setText(msg);
    }
}