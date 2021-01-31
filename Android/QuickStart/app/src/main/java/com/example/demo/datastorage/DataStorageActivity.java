package com.example.demo.datastorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.demo.R;

/*
* 数据存储
* */
public class DataStorageActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnSharedPreferences;
    private Button btnFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_storage);


        btnSharedPreferences = findViewById(R.id.btn_sharedPreferences);
        btnFile = findViewById(R.id.btn_file);

        btnSharedPreferences.setOnClickListener(this);
        btnFile.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;

        switch (v.getId()) {
            case R.id.btn_sharedPreferences:
                intent = new Intent(DataStorageActivity.this, SharedPreferencesActivity.class);
                break;
            case R.id.btn_file:
                intent = new Intent(DataStorageActivity.this, FileActivity.class);
                break;
        }

        startActivity(intent);
    }
}