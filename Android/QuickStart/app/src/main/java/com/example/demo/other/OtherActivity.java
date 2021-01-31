package com.example.demo.other;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.demo.R;
import com.example.demo.other.fragment.ContainerActivity;
import com.example.demo.other.handler.HandlerActivity;
import com.example.demo.other.jumpanddata.AActivity;
import com.example.demo.other.life.LifeCycleActivity;

public class OtherActivity extends AppCompatActivity {

    private Button btnLifeCycle;
    private Button btnJump;
    private Button btnFragment;
    private Button btnHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        btnLifeCycle = findViewById(R.id.btn_lief_cycle);
        btnJump = findViewById(R.id.btn_jump);
        btnFragment = findViewById(R.id.btn_fragment);
        btnHandler = findViewById(R.id.btn_handler);

        setListener();
    }

    public void setListener() {
        OnClick onClick = new OnClick();

        btnLifeCycle.setOnClickListener(onClick);
        btnJump.setOnClickListener(onClick);
        btnFragment.setOnClickListener(onClick);
        btnHandler.setOnClickListener(onClick);
    }
    private class OnClick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()) {
                case R.id.btn_lief_cycle:
                    // 跳转至生命周期演示界面
                    intent = new Intent(OtherActivity.this, LifeCycleActivity.class);
                    break;
                case R.id.btn_jump:
                    // 跳转至activity数据传送演示界面
                    intent = new Intent(OtherActivity.this, AActivity.class);
                    break;
                case R.id.btn_fragment:
                    // 跳转至Fragment演示界面
                    intent = new Intent(OtherActivity.this, ContainerActivity.class);
                    break;

                case R.id.btn_handler:
                    // 跳转至Fragment演示界面
                    intent = new Intent(OtherActivity.this, HandlerActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}