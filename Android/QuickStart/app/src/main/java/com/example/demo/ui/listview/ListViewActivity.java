package com.example.demo.ui.listview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.demo.R;

// 列表视图
public class ListViewActivity extends Activity {

    private ListView mLv1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        mLv1 = findViewById(R.id.lv_1);

        // 添加列表项
        mLv1.setAdapter(new MyListAdapter(ListViewActivity.this));

        // 添加点击事件
        mLv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListViewActivity.this, "pos: " + position, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
