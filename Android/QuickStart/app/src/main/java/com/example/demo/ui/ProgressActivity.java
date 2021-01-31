package com.example.demo.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.demo.R;
import com.example.demo.util.ToastUtil;

public class ProgressActivity extends AppCompatActivity {

    private ProgressBar mPb3;
    private Button pbBtn;
    private Button btnProgressDialog1; // 旋转类型
    private Button btnProgressDialog2; // 进度条类型

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

        mPb3 = findViewById(R.id.pb3);
        pbBtn = findViewById(R.id.pb_btn);
        btnProgressDialog1 = findViewById(R.id.btn_progress_dialog1);
        btnProgressDialog2 = findViewById(R.id.btn_progress_dialog2);

        // 设置进度
        pbBtn.setOnClickListener(view -> {
            handler.sendEmptyMessage(0);
            pbBtn.setEnabled(false);
        });

        // 设置普通ProgressDialog
        btnProgressDialog1.setOnClickListener(view -> {
            ProgressDialog progressDialog = new ProgressDialog(ProgressActivity.this);
            progressDialog.setTitle("提示");
            progressDialog.setMessage("正在加载");

            // 设置监听事件
            progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialog) {
                    ToastUtil.showMsg(ProgressActivity.this, "取消...");
                }
            });

            // 设置不能取消
            progressDialog.setCancelable(false);
            progressDialog.show();
        });

        // 设置进度条的ProgressDialog
        btnProgressDialog2.setOnClickListener(view -> {
            ProgressDialog progressDialog = new ProgressDialog(ProgressActivity.this);

            // 设置进度条
            progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            progressDialog.setTitle("提示");
            progressDialog.setMessage("正在下载");

            // 添加按钮 点击事件
            progressDialog.setButton(DialogInterface.BUTTON_POSITIVE, "取消", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            progressDialog.show();
        });
    }

    Handler handler = new Handler(Looper.myLooper()){
        @Override
        public void handleMessage(@NonNull Message msg) {
            if(mPb3.getProgress() < 100) {
                handler.postDelayed(runnable, 500);
            } else {
                ToastUtil.showMsg(ProgressActivity.this, "加载完成");
            }
        }
    };

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            mPb3.setProgress(mPb3.getProgress() + 5);
            handler.sendEmptyMessage(0);
        }
    };
}