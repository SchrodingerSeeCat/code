package com.valid.chapter08.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.valid.chapter08.R;

public class DynamicFragment extends Fragment {
    protected View mView;           // 声明一个视图对象
    protected Context mContext;     // 上下文对象
    private int mPosition;          // 位置序号
    private int mImageId;           // 图片的资源编号
    private String mDesc;           // 商品的文字描述

    public static DynamicFragment newInstance(int position, int image_id, String desc) {
        DynamicFragment fragment = new DynamicFragment();   // 创建该碎片的一个实例
        Bundle bundle = new Bundle();                       // 创建一个新包裹
        bundle.putInt("position", position);
        bundle.putInt("image_id", image_id);
        bundle.putString("desc", desc);
        fragment.setArguments(bundle);  // 包裹放入碎片
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mContext = getActivity();   // 获取上下文
        if(getArguments() != null) {
            mPosition = getArguments().getInt("position", 0);   // 从包裹取出位置序号
            mImageId = getArguments().getInt("image_id", 0);    // 从包裹取出图片的资源编号
            mDesc = getArguments().getString("desc");                       // 从包裹取出商品的文字描述
        }
        mView = inflater.inflate(R.layout.fragment_dynamic, container, false);

        TextView tv_desc = mView.findViewById(R.id.tv_dy_adv);
        ImageView iv_pic = mView.findViewById(R.id.iv_dy_adv);
        iv_pic.setImageResource(mImageId);
        tv_desc.setText(mDesc);

        return mView;
    }
}
