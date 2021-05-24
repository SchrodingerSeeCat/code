package com.valid.chapter08.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.valid.chapter08.entity.Book;
import com.valid.chapter08.fragment.DynamicFragment;

import java.util.List;

public class MobilePagerAdapter extends FragmentPagerAdapter {
    private List<Book> list;

    public MobilePagerAdapter(@NonNull FragmentManager fm, List<Book> list) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.list = list;
    }

    // 获取指定位置的碎片
    @NonNull
    @Override
    public Fragment getItem(int position) {
        return DynamicFragment.newInstance(position,
                                            list.get(position).getPic(),
                                            list.get(position).getDesc());
    }

    // 获取Fragment的个数
    @Override
    public int getCount() {
        return list.size();
    }

    // 获取指定碎片页的标题文本
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position).getDesc();
    }
}
