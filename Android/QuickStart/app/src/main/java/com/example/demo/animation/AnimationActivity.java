package com.example.demo.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.demo.R;

public class AnimationActivity extends AppCompatActivity {

    private TextView tvTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        tvTest = findViewById(R.id.tv);

        // 在2s内沿Y轴平移500个单位
//        tvTest.animate().translationYBy(500).setDuration(2000).start();

        // 在2s内渐变到0
//        tvTest.animate().alpha(0).setDuration(2000).start();

        // 2000内高度变为200
//        ValueAnimator valueAnimator = ValueAnimator.ofInt(0, 200);
//        valueAnimator.setDuration(2000);
//        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(){
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//
//                // getAnimatedValue 实际的值
//                Log.d("getAnimatedValue: ", animation.getAnimatedValue() + "");
//
//                tvTest.setY((int) animation.getAnimatedValue());
//
//                // getAnimatedFraction 动画的进度
//                Log.d("getAnimatedFraction: ", animation.getAnimatedFraction() + "");
//            }
//        });
//        valueAnimator.start();

        // 第二个参数为动画的类型
        // translationX translationY alpha rotation rotationX...
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(tvTest, "translationY", 0, 500);
        objectAnimator.setDuration(2000);
        objectAnimator.start();
    }
}