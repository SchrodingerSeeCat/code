package com.valid.chapter08.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.valid.chapter08.R;
import com.valid.chapter08.adapter.MobilePagerAdapter;
import com.valid.chapter08.entity.Book;

import java.util.List;

public class DynamicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic);

        List<Book> list = Book.getDefaultList();

        MobilePagerAdapter adapter = new MobilePagerAdapter(getSupportFragmentManager(), list);

        ViewPager vp_content = findViewById(R.id.vp_content);
        vp_content.setAdapter(adapter);
        vp_content.setCurrentItem(0);
    }
}