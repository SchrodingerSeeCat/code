package com.valid.share;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PowerActivity extends AppCompatActivity {

    private Button btn_store;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_power);

        btn_store = findViewById(R.id.btn_store);
        btn_store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkSelfPermission(PowerActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    // 检查某个权限 返回true表示已启用该权限,返回false表示未启用该权限
    private boolean checkSelfPermission(String[] permissions, int requestCode) {
        // 通过权限数组检查是否开启了这些权限
        for (String permission : permissions) {
            if (!check(permission)) {
                break; //如果权限没有开启就跳出循环
            }
        }

        if (check != PackageManager.PERMISSION_GRANTED) {
            // 未开启该权限,则请求系统弹窗,让用户手动开启
            ActivityCompat.requestPermissions(PowerActivity.this, permissions, requestCode);
            check = ContextCompat.checkSelfPermission(PowerActivity.this, permissions);
            if (check != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }

    // 检查权限是否开启
    private boolean check(String permission) {
        return PackageManager.PERMISSION_GRANTED == ContextCompat.checkSelfPermission(PowerActivity.this, permission);
    }
}