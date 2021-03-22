package com.valid.share;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn_power;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyClick click = new MyClick();

        btn_power = findViewById(R.id.btn_power);
        btn_power.setOnClickListener(click);
    }

    private class MyClick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()) {
                case R.id.btn_power:
                    intent = new Intent(MainActivity.this, PowerActivity.class);
            }

            startActivity(intent);
        }
    }
}