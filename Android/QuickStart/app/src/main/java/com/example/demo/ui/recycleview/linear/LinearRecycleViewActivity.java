package com.example.demo.ui.recycleview.linear;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;

import com.example.demo.R;

public class LinearRecycleViewActivity extends AppCompatActivity {

    private RecyclerView rvMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_recycle_view);

        rvMain = findViewById(R.id.rv_main);

        // 设置RecycleView的布局形式
        rvMain.setLayoutManager(new LinearLayoutManager(LinearRecycleViewActivity.this));

        // 添加分割线
        rvMain.addItemDecoration(new MyDecoration());

        // 设置列表的内容
        rvMain.setAdapter(new LinearAdapter(LinearRecycleViewActivity.this));


    }

    private class MyDecoration extends  RecyclerView.ItemDecoration {
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);

            outRect.set(0, 0, 0, getResources().getDimensionPixelOffset(R.dimen.dividerHeight));
        }
    }
}