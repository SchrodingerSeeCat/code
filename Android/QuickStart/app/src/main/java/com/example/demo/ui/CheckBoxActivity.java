package com.example.demo.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.example.demo.R;

// 多选框
public class CheckBoxActivity extends AppCompatActivity {

    private CheckBox mCb5;
    private CheckBox mCb6;
    private CheckBox mCb7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);

        mCb5 = findViewById(R.id.cb_5);
        mCb6 = findViewById(R.id.cb_6);
        mCb7 = findViewById(R.id.cb_7);

        mCb5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(CheckBoxActivity.this, isChecked ? "5选中" : "5未选中", Toast.LENGTH_SHORT).show();
            }
        });

        mCb6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(CheckBoxActivity.this, isChecked ? "6选中" : "6未选中", Toast.LENGTH_SHORT).show();
            }
        });

        mCb7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(CheckBoxActivity.this, isChecked ? "7选中" : "7未选中", Toast.LENGTH_SHORT).show();
            }
        });
    }
}