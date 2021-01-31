package com.example.demo.ui.dialog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.demo.R;
import com.example.demo.widget.CustomDialog;

public class CustomDialogActivity extends AppCompatActivity {

    private Button btnDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_dialog);

        btnDialog = findViewById(R.id.dialog);
        btnDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 传递样式
                CustomDialog customDialog = new CustomDialog(CustomDialogActivity.this, R.style.CustomDialog);
                customDialog.setTitle("提示").setMessage("确认删除此项？")
                    .setCancel("取消", new CustomDialog.MyOnCancelListener() {
                        @Override
                        public void onCancel(CustomDialog dialog) {
                            dialog.dismiss();
                        }
                    })
                    .setConfirm("确定", new CustomDialog.MyOnConfirmListener() {
                        @Override
                        public void onConfirm(CustomDialog dialog) {
                            dialog.dismiss();
                        }
                    }).show();
            }
        });
    }
}