package com.example.demo.other.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowAnimationFrameStats;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.demo.R;

public class AFragment extends Fragment {

    private TextView frgTitle;
    private Button frgChange;
    private Button frgReset;
    private BFragment bFragment;
    private Button frgMessage;

    // 用于Fragment向Activity传递消息时进行接口回调
    private IOnMessageClick listener;

    // 传递参数一般不通过构造函数，因为当Fragment重新构建时，参数可能会丢失
    public static AFragment newInstance(String msg) {
        AFragment fragment = new AFragment();

        Bundle bundle = new Bundle();
        bundle.putString("msg", msg);
        fragment.setArguments(bundle);

        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // 设置布局文件
        return inflater.inflate(R.layout.fragment_a, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        frgTitle = view.findViewById(R.id.frg_a_title);
        frgChange = view.findViewById(R.id.frg_a_change);
        frgReset = view.findViewById(R.id.frg_a_reset);
        frgMessage = view.findViewById(R.id.frg_a_message);

        // 替换为BFragment
        frgChange.setOnClickListener(v -> {
            if (bFragment == null) {
                bFragment = new BFragment();
            }

            // addToBackStack将当前的fragment添加到 回退栈 中，使得在添加多个fragment时能够回退到上一个fragment
            Fragment fragment = getFragmentManager().findFragmentByTag("a");
            if(fragment != null) {
                getFragmentManager().beginTransaction().hide(fragment).add(R.id.fl_container, bFragment).addToBackStack(null).commitAllowingStateLoss();
            } else {
                getFragmentManager().beginTransaction().replace(R.id.fl_container, bFragment).addToBackStack(null).commitAllowingStateLoss();
            }
        });

        // 替换文字
        frgReset.setOnClickListener(v -> {
            frgTitle.setText("我是新文字");
        });

        // 点击向Activity发送消息
        frgMessage.setOnClickListener(v -> {
            // getActivity 获取宿主Activity， 如果需要使用Activity做一些操作时，应该在使用之前判断是否为null值
            // 这种传递方式不推荐使用
//            if(getActivity() != null) {
//                ((ContainerActivity) getActivity()).setData("我是Fragment发送过来的消息");
//            }

            // 接口回调
            listener.onClick("我是接口回调发来的信息");
        });



        // 获取Activity传递的参数
        if(getArguments() != null) {
            frgTitle.setText(getArguments().getString("msg"));
        }
    }


    // 设置Fragment向Activity传递消息的接口
    public interface IOnMessageClick{
        void onClick(String msg);
    }
    // 与Activity建立关系时
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            listener = (IOnMessageClick) context;
        } catch (ClassCastException e) {
            throw new ClassCastException("Activity 必须实现IOnMessageClick接口");
        }
    }

    // 当宿主Activity关闭时
    @Override
    public void onDetach() {
        super.onDetach();

    }

    // Fragment 销毁时
    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
