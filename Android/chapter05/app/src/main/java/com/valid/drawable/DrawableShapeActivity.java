package com.valid.drawable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class DrawableShapeActivity extends AppCompatActivity {

    private View v_content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawable_shape);

        v_content = findViewById(R.id.v_content);
        v_content.setBackgroundResource(R.drawable.shape_rect_gold);
    }
}