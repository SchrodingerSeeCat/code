package com.example.demo.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.demo.R;
import com.example.demo.util.ToastUtil;

// Toast
public class ToastActivity extends AppCompatActivity {

    private Button btnToast1;
    private Button btnToast2;
    private Button btnToast3;
    private Button btnToast4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);

        btnToast1 = findViewById(R.id.btn_toast_1);
        btnToast2 = findViewById(R.id.btn_toast_2);
        btnToast3 = findViewById(R.id.btn_toast_3);
        btnToast4 = findViewById(R.id.btn_toast_4);

        // 设置点击事件
        Onclick onClick = new Onclick();
        btnToast1.setOnClickListener(onClick);
        btnToast2.setOnClickListener(onClick);
        btnToast3.setOnClickListener(onClick);
        btnToast4.setOnClickListener(onClick);
    }
    private class Onclick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_toast_1:
                    Toast.makeText(ToastActivity.this, "默认", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn_toast_2:
                    Toast toastCenter = Toast.makeText(ToastActivity.this, "居中Toast", Toast.LENGTH_SHORT);
                    toastCenter.setGravity(Gravity.CENTER, 0, 0);
                    toastCenter.show();
                    break;
                case R.id.btn_toast_3:
                    // 创建toast
                    Toast toastCustom = new Toast(ToastActivity.this);

                    // 创建视图
                    View view = LayoutInflater.from(ToastActivity.this).inflate(R.layout.layout_toast, null);

                    // 此处可以拿到布局文件中的控件，设置其属性
//                    ImageView imageView = view.findViewById(R.id.iv_toast);
//                    TextView textView = view.findViewById(R.id.tv_toast);

                    toastCustom.setView(view);
                    toastCustom.setDuration(Toast.LENGTH_LONG);
                    toastCustom.show();
                    break;
                case R.id.btn_toast_4:
                    ToastUtil.showMsg(ToastActivity.this, "包装过的Toast");
                    break;
            }
        }
    }
}