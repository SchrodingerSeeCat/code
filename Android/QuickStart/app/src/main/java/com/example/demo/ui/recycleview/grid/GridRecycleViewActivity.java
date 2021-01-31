package com.example.demo.ui.recycleview.grid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.demo.R;

// RecycleView Grid布局
public class GridRecycleViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_recycle_view);

        recyclerView = findViewById(R.id.rv_grid);

        // 设置布局方式, 3表示一行展示三个item
        recyclerView.setLayoutManager(new GridLayoutManager(GridRecycleViewActivity.this, 3));
        recyclerView.setAdapter(new GridAdapter(GridRecycleViewActivity.this));
    }
}