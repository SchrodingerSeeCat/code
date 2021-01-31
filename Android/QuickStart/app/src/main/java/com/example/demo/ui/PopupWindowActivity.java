package com.example.demo.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.demo.R;
import com.example.demo.util.ToastUtil;

import org.w3c.dom.Text;

// PopupWindow
public class PopupWindowActivity extends AppCompatActivity {

    private Button btnPOP;
    private PopupWindow popupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_window);

        btnPOP = findViewById(R.id.btn_pop);
        btnPOP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = getLayoutInflater().inflate(R.layout.layout_pop, null);

                // 获取控件，设置点击事件
                TextView textView = view.findViewById(R.id.tv_good);
                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                        ToastUtil.showMsg(PopupWindowActivity.this, textView.getText().toString());
                    }
                });

                popupWindow = new PopupWindow(view, btnPOP.getWidth(), ViewGroup.LayoutParams.WRAP_CONTENT);

                // 设置点击其他部分隐藏
                popupWindow.setOutsideTouchable(true);

                // 设置点击按钮实现隐藏
                popupWindow.setFocusable(true);

                // 显示popupWindow
                popupWindow.showAsDropDown(btnPOP);
            }
        });
    }
}