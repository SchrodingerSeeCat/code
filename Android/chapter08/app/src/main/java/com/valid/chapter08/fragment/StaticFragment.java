package com.valid.chapter08.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.valid.chapter08.R;

public class StaticFragment extends Fragment {

    protected View mView;           // 视图对象
    protected Context mContext;     // 上下文对象

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mContext = getActivity();   // 获取上下文对象
        mView = inflater.inflate(R.layout.fragment_static, container, false);
        TextView tv_adv = mView.findViewById(R.id.tv_adv);
        ImageView iv_adv = mView.findViewById(R.id.iv_adv);

        iv_adv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "点击了广告", Toast.LENGTH_LONG).show();
            }
        });

        return mView;
    }
}
