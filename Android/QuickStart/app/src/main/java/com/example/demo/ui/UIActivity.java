package com.example.demo.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.demo.MainActivity;
import com.example.demo.R;
import com.example.demo.ui.dialog.CustomDialogActivity;
import com.example.demo.ui.dialog.DialogActivity;
import com.example.demo.ui.gridview.GridViewActivity;
import com.example.demo.ui.listview.ListViewActivity;
import com.example.demo.ui.recycleview.RecycleViewActivity;
import com.example.demo.ui.webview.WebViewActivity;

public class UIActivity extends AppCompatActivity {

    // 声明button
    private Button btnTextView;
    private Button btnButton;
    private Button btnEditText;
    private Button btnRadioButton;
    private Button btnCheckBox;
    private Button btnImageView;
    private Button btnListView;
    private Button btnGridView;
    private Button btnRecycleView;
    private Button btnWebView;
    private Button btnToast;
    private Button btnDialog;
    private Button btnProgress;
    private Button btnCustomDialog;
    private Button btnPopupWindow;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui);

        // 通过ID获取btn
        btnTextView = findViewById(R.id.btn_text_view);
        btnButton = findViewById(R.id.btn_button);
        btnEditText = findViewById(R.id.btn_edittext);
        btnRadioButton = findViewById(R.id.btn_radiobtn);
        btnCheckBox = findViewById(R.id.btn_checkbox);
        btnImageView = findViewById(R.id.btn_imageview);
        btnListView = findViewById(R.id.btn_listview);
        btnGridView = findViewById(R.id.btn_gridview);
        btnRecycleView = findViewById(R.id.btn_recycleview);
        btnWebView = findViewById(R.id.btn_webview);
        btnToast = findViewById(R.id.btn_toast);
        btnDialog = findViewById(R.id.btn_dialog);
        btnProgress = findViewById(R.id.btn_progress);
        btnCustomDialog = findViewById(R.id.btn_custom_dialog);
        btnPopupWindow = findViewById(R.id.btn_popup_window);

        setListeners();
    }


    private void setListeners() {
        OnClick onClick = new OnClick();
        // TextView演示界面
        btnTextView.setOnClickListener(onClick);

        // Button演示界面
        btnButton.setOnClickListener(onClick);

        // EditText演示界面
        btnEditText.setOnClickListener(onClick);

        // RadioButton演示界面
        btnRadioButton.setOnClickListener(onClick);

        // CheckBox复选框界面
        btnCheckBox.setOnClickListener(onClick);

        // ImageView图片界面
        btnImageView.setOnClickListener(onClick);

        // ListView演示界面
        btnListView.setOnClickListener(onClick);

        // GridView演示界面
        btnGridView.setOnClickListener(onClick);

        // RecycleView演示界面
        btnRecycleView.setOnClickListener(onClick);

        // WebView演示界面
        btnWebView.setOnClickListener(onClick);

        // Toast演示界面
        btnToast.setOnClickListener(onClick);

        // AlertDialog演示界面
        btnDialog.setOnClickListener(onClick);

        // Progress演示界面
        btnProgress.setOnClickListener(onClick);

        // 自定义一dialog演示界面
        btnCustomDialog.setOnClickListener(onClick);

        // PopupWindow演示界面
        btnPopupWindow.setOnClickListener(onClick);
    }

    // 处理事件的类型
    private class OnClick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()) {
                case R.id.btn_text_view:
                    intent = new Intent(UIActivity.this, TextViewActivity.class);
                    break;
                case R.id.btn_button:
                    intent = new Intent(UIActivity.this, ButtonActivity.class);
                    break;
                case R.id.btn_edittext:
                    intent = new Intent(UIActivity.this, EditTextActivity.class);
                    break;
                case R.id.btn_radiobtn:
                    intent = new Intent(UIActivity.this, RadioButtonActivity.class);
                    break;
                case R.id.btn_checkbox:
                    intent = new Intent(UIActivity.this, CheckBoxActivity.class);
                    break;
                case R.id.btn_imageview:
                    intent = new Intent(UIActivity.this, ImageViewActivity.class);
                    break;
                case R.id.btn_listview:
                    intent = new Intent(UIActivity.this, ListViewActivity.class);
                    break;
                case R.id.btn_gridview:
                    intent = new Intent(UIActivity.this, GridViewActivity.class);
                    break;
                case R.id.btn_recycleview:
                    intent = new Intent(UIActivity.this, RecycleViewActivity.class);
                    break;
                case R.id.btn_webview:
                    intent = new Intent(UIActivity.this, WebViewActivity.class);
                    break;
                case R.id.btn_toast:
                    intent = new Intent(UIActivity.this, ToastActivity.class);
                    break;
                case R.id.btn_dialog:
                    intent = new Intent(UIActivity.this, DialogActivity.class);
                    break;
                case R.id.btn_progress:
                    intent = new Intent(UIActivity.this, ProgressActivity.class);
                    break;
                case R.id.btn_custom_dialog:
                    intent = new Intent(UIActivity.this, CustomDialogActivity.class);
                    break;
                case R.id.btn_popup_window:
                    intent = new Intent(UIActivity.this, PopupWindowActivity.class);
                    break;
                default:
                    intent = new Intent(UIActivity.this, MainActivity.class);
            }
            startActivity(intent);
        }
    }
}