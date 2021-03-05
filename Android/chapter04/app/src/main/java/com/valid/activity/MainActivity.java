package com.valid.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn_go_finish;
    private Button btn_stack;
    private Button btn_intent;
    private Button btn_string;
    private Button btn_meta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_go_finish = findViewById(R.id.btn_go_finish);
        btn_go_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ActFinishActivity.class));
            }
        });

        btn_stack = findViewById(R.id.btn_stack);
        btn_stack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, StackActivity.class));
            }
        });

        btn_intent = findViewById(R.id.btn_intent);
        btn_intent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, IntentActivity.class));
            }
        });

        btn_string = findViewById(R.id.btn_string);
        btn_string.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, StringActivity.class));
            }
        });

        btn_meta = findViewById(R.id.btn_meta);
        btn_meta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MetaActivity.class));
            }
        });
    }
}