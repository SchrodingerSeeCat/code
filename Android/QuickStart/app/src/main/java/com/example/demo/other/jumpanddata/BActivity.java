package com.example.demo.other.jumpanddata;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.demo.R;

import org.w3c.dom.Text;

public class BActivity extends AppCompatActivity {

    private TextView dataName;
    private TextView dataAge;
    private Button dataBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        dataName = findViewById(R.id.data_name);
        dataAge = findViewById(R.id.data_age);
        dataBtn = findViewById(R.id.data_finish);

        // 获取前一个Activity传递的数据
        Bundle bundle = getIntent().getExtras();

        dataName.setText("name: " + bundle.get("name").toString());
        dataAge.setText("age: " + bundle.getInt("age"));

        // 设置当返回时，所携带的数据
        dataBtn.setOnClickListener(view -> {
            Intent intent = new Intent();

            Bundle bundle1 = new Bundle();
            bundle1.putString("name", "java");
            intent.putExtras(bundle1);

            setResult(Activity.RESULT_OK, intent);
            finish();
        });
    }
}