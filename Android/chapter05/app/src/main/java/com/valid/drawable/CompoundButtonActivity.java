package com.valid.drawable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class CompoundButtonActivity extends AppCompatActivity {

    private CheckBox ck_default;
    private RadioGroup rg_gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compound_button);


        // 复选框
        ck_default = findViewById(R.id.ck_default);
        // 设置选中状态的改变
        ck_default.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    Toast.makeText(CompoundButtonActivity.this, "被选中", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(CompoundButtonActivity.this, "被取消", Toast.LENGTH_SHORT).show();
                }
            }
        });


        // 单选框
        rg_gender = findViewById(R.id.rg_gender);
        rg_gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rb_boy) {
                    Toast.makeText(CompoundButtonActivity.this, "帅气的男孩", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(CompoundButtonActivity.this, "漂亮的女孩", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}