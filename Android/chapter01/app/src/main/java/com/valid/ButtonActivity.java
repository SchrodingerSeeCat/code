package com.valid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class ButtonActivity extends AppCompatActivity {

    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;

    private TextView tv_msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);

        tv_msg = findViewById(R.id.tv_msg);
        btn5 = findViewById(R.id.btn5);

        btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(v -> {
            tv_msg.setText("发生了点击事件");
        });

        btn2 = findViewById(R.id.btn2);
        btn2.setOnLongClickListener(v -> {
            // 按钮需要被按住在500ms以上
            tv_msg.setText("发生了长按事件");
            return false;
        });

        btn3 = findViewById(R.id.btn3);
        btn3.setOnClickListener(v -> {
            btn5.setEnabled(true);
            btn5.setText("已启用");
        });

        btn4 = findViewById(R.id.btn4);
        btn4.setOnClickListener(v -> {
            btn5.setEnabled(false);
            btn5.setText("已禁用");
        });
    }
}