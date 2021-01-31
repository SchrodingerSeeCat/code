package com.example.demo.other.jumpanddata;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.demo.R;
import com.example.demo.util.ToastUtil;

public class AActivity extends AppCompatActivity {

    private Button btnJump;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);

        btnJump = findViewById(R.id.jump);
        btnJump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 显示跳转1
                Intent intent = new Intent(AActivity.this, BActivity.class);

                // 数据传递
                Bundle bundle = new Bundle();

                bundle.putString("name", "Android");
                bundle.putInt("age", 14);

                intent.putExtras(bundle);

//                startActivity(intent);

                // 此方法用于从 跳转的 Activity 返回到此 Activity 携带一些数据
                // requestCode: 0用于区分不同的Activity
                startActivityForResult(intent, 0);

                // 显示跳转2
//                Intent intent = new Intent();
//                intent.setClass(AActivity.this, BActivity.class);
//                startActivity(intent);

                // 显示跳转3
//                Intent intent = new Intent();
//                intent.setClassName(AActivity.this, "com.example.demo.other.jumpanddata.BActivity");
//                startActivity(intent);

                // 显示跳转4
//                Intent intent = new Intent();
//                intent.setComponent(new ComponentName(AActivity.this, "com.example.demo.other.jumpanddata.BActivity"));
//                startActivity(intent);

                // 隐式跳转
//                Intent intent = new Intent();
//                intent.setAction("com.expample.test"); // 此处的字符串在AndroidManifest.xml文件中指定
//                startActivity(intent);
            }
        });
    }

    // 接受从BActivity返回的参数

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(AActivity.this, data.getExtras().getString("name"), Toast.LENGTH_LONG).show();
    }
}