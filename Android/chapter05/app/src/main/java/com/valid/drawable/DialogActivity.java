package com.valid.drawable;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

public class DialogActivity extends AppCompatActivity {

    private Button btn_alert;
    private Button btn_date_alert;
    private TextView tv_date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        // 用来显示用户选取的时间
        tv_date = findViewById(R.id.tv_date);

        btn_alert = findViewById(R.id.btn_alert);
        btn_alert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialog();
            }
        });

        btn_date_alert = findViewById(R.id.btn_date_alert);
        btn_date_alert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });
    }

    // AlertDialog
    public void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("尊敬的用户"); // 设置对话框的标题文本
        builder.setMessage("你整的要卸载我吗?"); // 设置对话框的内容文本

        // 设置对话框的肯定按钮文本及点击事件
        builder.setPositiveButton("残忍卸载", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(DialogActivity.this, "下次再见", Toast.LENGTH_SHORT).show();
            }
        });

        // 设置对话框的否定按钮文本及其点击监听器
        builder.setNegativeButton("我再想想", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(DialogActivity.this, "nice", Toast.LENGTH_SHORT).show();
            }
        });

        // 根据builder构建对话框对象
        AlertDialog alert = builder.create();
        alert.show(); //显示提醒对话框
    }

    // DatePickerDialog
    public void showDatePickerDialog() {
        // 获取一个日期对话框，该对话框已经集成了日期选择器
        Calendar calendar = Calendar.getInstance();

        // 构建一个日期对话框，该对话框已经集成了日期选择器
        DatePickerDialog dialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    // 如果点击日期对话框上的确定按钮，就会触发监听器的onDateSet方法
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        // 获取日期对话框设定的年份、月份
                        String desc = String.format("你选择的日期是%d年%d月%d日", year, month, dayOfMonth);
                        tv_date.setText(desc);
                    }
                },
                calendar.get(Calendar.YEAR), // 年份
                calendar.get(Calendar.MONTH), // 月份
                calendar.get(Calendar.DAY_OF_MONTH)); // 日期
        dialog.show();
    }
}