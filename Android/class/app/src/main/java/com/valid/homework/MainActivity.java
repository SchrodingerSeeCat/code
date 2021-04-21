package com.valid.homework;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RadioGroup rg_season;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rg_season = findViewById(R.id.rg_season);
        rg_season.setOnCheckedChangeListener((RadioGroup group, int checkedId) -> {
            String str = null;
            switch (checkedId) {
                case R.id.rb_spring:
                    str = "春天";
                    break;
                case R.id.rb_summer:
                    str = "夏天";
                    break;
                case R.id.rb_fall:
                    str = "秋天";
                    break;
                case R.id.rb_winter:
                    str = "冬天";
            }

            if (str != null) {
                Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
            }
        });
    }
}