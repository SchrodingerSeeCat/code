package com.example.demo.ui.recycleview.waterfall;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import com.example.demo.R;

// 实现瀑布流
public class StaggeredGridActivity extends AppCompatActivity {

    private RecyclerView rvWaterFall;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staggered_grid);

        rvWaterFall = findViewById(R.id.rv_waterfall);

        // 设置布局方式 VERTICAL垂直排列
        // 如果是垂直排列的 2表示有两列
        // 如果是水平排列的 2表示有两行
        rvWaterFall.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        rvWaterFall.setAdapter(new StaggeredGridAdapter(StaggeredGridActivity.this));
    }
}