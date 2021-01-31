package com.example.demo.ui.recycleview.horizontal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;

import com.example.demo.R;

// RecycleView 水平滚动
public class HorRecycleViewActivity extends AppCompatActivity {

    private RecyclerView rvHorizontal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hor_recycle_view);

        rvHorizontal = findViewById(R.id.rv_hor);

        // 设置布局方式
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(HorRecycleViewActivity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        // 添加分割线
        rvHorizontal.addItemDecoration(new HorRecycleViewActivity.MyDecoration());

        rvHorizontal.setLayoutManager(linearLayoutManager);

        // 设置item
        rvHorizontal.setAdapter(new HorizontalAdapter(HorRecycleViewActivity.this));
    }

    private class MyDecoration extends  RecyclerView.ItemDecoration {
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);

            outRect.set(0, 0, getResources().getDimensionPixelOffset(R.dimen.dividerHeight), 0);
        }
    }
}