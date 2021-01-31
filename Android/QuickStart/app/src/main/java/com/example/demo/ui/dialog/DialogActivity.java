package com.example.demo.ui.dialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.demo.R;
import com.example.demo.util.ToastUtil;

public class DialogActivity extends AppCompatActivity {

    private Button btnDialog1;
    private Button btnDialog2;
    private Button btnDialog3;
    private Button btnDialog4;
    private Button btnDialog5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        btnDialog1 = findViewById(R.id.btn_dialog1);
        btnDialog2 = findViewById(R.id.btn_dialog2);
        btnDialog3 = findViewById(R.id.btn_dialog3);
        btnDialog4 = findViewById(R.id.btn_dialog4);
        btnDialog5 = findViewById(R.id.btn_dialog5);

        // 设置点击事件
        OnClick onClick = new OnClick();
        btnDialog1.setOnClickListener(onClick);
        btnDialog2.setOnClickListener(onClick);
        btnDialog3.setOnClickListener(onClick);
        btnDialog4.setOnClickListener(onClick);
        btnDialog5.setOnClickListener(onClick);
    }
    private class OnClick implements View.OnClickListener {

        @Override
        public void onClick(View v) {

            switch (v.getId()) {
                case R.id.btn_dialog1:
                    // 默认
                    AlertDialog.Builder builder = new AlertDialog.Builder(DialogActivity.this);
                    builder.setTitle("请回答");
                    builder.setMessage("编程好玩不?");
                    // 积极按钮
                    builder.setPositiveButton("好玩", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtil.showMsg(DialogActivity.this, "生活的乐趣在于编程");
                        }
                    });

                    // 中立按钮
                    builder.setNeutralButton("一般", ((dialog, which) -> {
                        ToastUtil.showMsg(DialogActivity.this, "一壶水，一包烟，一行代码写一天");
                    }));

                    // 消极按钮
                    builder.setNegativeButton("不好", ((dialog, which) -> {
                        ToastUtil.showMsg(DialogActivity.this, "字节和心脏只能有一个跳动");
                    }));

                    // 调用显示
                    builder.show();

                    // 还可以通过使用setIcon(Drawable icon)来设置icon
                    break;
                case R.id.btn_dialog2:
                    // 带选项的
                    String[] shops = new String[]{"手机", "平板", "笔记本", "相机"};

                    // AlertDialog.Builder 支持链式调用
                    AlertDialog.Builder builder2 = new AlertDialog.Builder(DialogActivity.this);
                    builder2.setTitle("选择商品").setItems(shops, ((dialog, which) -> {
                        ToastUtil.showMsg(DialogActivity.this, shops[which]);
                    })).show();
                    break;
                case R.id.btn_dialog3:
                    // 单选
                    String[] gender = new String[]{"男", "女"};

                    // AlertDialog.Builder 支持链式调用
                    AlertDialog.Builder builder3 = new AlertDialog.Builder(DialogActivity.this);
                    builder3.setTitle("选择性别");

                    // 0表示默认选中的item
                    builder3.setSingleChoiceItems(gender, 0, ((dialog, which) -> {
                        ToastUtil.showMsg(DialogActivity.this, gender[which]);

                        // 点击对话框的item后，取消对话框的显示
                        dialog.dismiss();
                    }));

                    // 设置只有点击了选项，对话框才消失
                    builder3.setCancelable(false);

                    builder3.show();
                    break;
                case R.id.btn_dialog4:
                    // 多选
                    String[] comic = new String[]{"多罗罗", "奇蛋物语", "黑色四叶草", "动物狂想曲"};
                    boolean[] isSelected = new boolean[comic.length];

                    AlertDialog.Builder builder4 = new AlertDialog.Builder(DialogActivity.this);
                    builder4.setTitle("选择番剧");

                    // isSelected 表示是否被选中
                    builder4.setMultiChoiceItems(comic, isSelected, new DialogInterface.OnMultiChoiceClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                            ToastUtil.showMsg(DialogActivity.this, comic[which] + ": " + isChecked);
                        }
                    });

                    builder4.setPositiveButton("确定", (dialog, which) -> {
                        // 点击确定之后要做的事
                    });

                    builder4.setNegativeButton("取消", (dialog, which) -> {
                        // 点击取消之后要做的事
                    });

                    builder4.setCancelable(false);
                    builder4.show();

                    break;
                case R.id.btn_dialog5:

                    AlertDialog.Builder builder5 = new AlertDialog.Builder(DialogActivity.this);

                    // 设置builder的布局
                    View view = LayoutInflater.from(DialogActivity.this).inflate(R.layout.layout_dialog, null);
                    // 获取控件
                    EditText user = view.findViewById(R.id.et_username);
                    EditText pwd = view.findViewById(R.id.et_password);
                    Button login = view.findViewById(R.id.et_login);

                    login.setOnClickListener(item -> {
                        // 设置登录的逻辑
                    });

                    builder5.setView(view);

                    builder5.setTitle("请先登录");
                    builder5.show();
                    break;
            }
        }
    }
}