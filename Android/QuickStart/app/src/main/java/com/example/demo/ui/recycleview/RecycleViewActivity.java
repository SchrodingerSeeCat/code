package com.example.demo.ui.recycleview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.demo.R;
import com.example.demo.ui.recycleview.grid.GridRecycleViewActivity;
import com.example.demo.ui.recycleview.horizontal.HorRecycleViewActivity;
import com.example.demo.ui.recycleview.linear.LinearRecycleViewActivity;
import com.example.demo.ui.recycleview.waterfall.StaggeredGridActivity;

// RecycleView
public class RecycleViewActivity extends AppCompatActivity {

    private Button btnLinear;
    private Button btnHorizontal;
    private Button btnGrid;
    private Button btnWaterFall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);

        // Linear
        btnLinear = findViewById(R.id.btn_linear);
        btnLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecycleViewActivity.this, LinearRecycleViewActivity.class);
                startActivity(intent);
            }
        });

        // Horizontal
        btnHorizontal = findViewById(R.id.btn_horizontal);
        btnHorizontal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecycleViewActivity.this, HorRecycleViewActivity.class);
                startActivity(intent);
            }
        });

        // Grid
        btnGrid = findViewById(R.id.btn_grid);
        btnGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecycleViewActivity.this, GridRecycleViewActivity.class);
                startActivity(intent);
            }
        });

        // 瀑布流效果
        btnWaterFall = findViewById(R.id.btn_waterfall);
        btnWaterFall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecycleViewActivity.this, StaggeredGridActivity.class);
                startActivity(intent);
            }
        });
    }
}