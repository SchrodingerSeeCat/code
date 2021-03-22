package com.valid.drawable;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.valid.drawable.util.VerificationCode;

import java.util.Random;

public class LoginActivity extends AppCompatActivity {

    private RadioGroup rb_login; // 选择密码登陆还是验证码登陆
    private Button btn_login; // 登陆按钮
    private Button btn_forget; // 忘记密码按钮或者获取验证码按钮
    private EditText et_phone; //手机号输入框
    private TextView tv_password; // 密码或验证码输入提示框
    private EditText et_password; // 密码或验证码输入框
    private CheckBox cb_remember; // 记住密码复选框

    private String password = "123456"; // 用户密码

    private static int checkedId = R.id.rb_password; // 默认使用密码登陆的方式
    private static String code; // 保存的验证码

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        cb_remember = findViewById(R.id.cb_remember);

        rb_login = findViewById(R.id.rb_login);
        btn_login = findViewById(R.id.btn_login);
        btn_forget = findViewById(R.id.btn_forget);

        tv_password = findViewById(R.id.tv_password);
        et_password = findViewById(R.id.et_password);
        et_phone = findViewById(R.id.et_phone);

        rb_login.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // 选择使用密码登陆还是验证码登陆
                LoginActivity.checkedId = checkedId;
                if(checkedId == R.id.rb_code) {
                    tv_password.setText("    验证码: ");
                    et_password.setHint("请输入验证码");
                    btn_forget.setText("验证码");
                    cb_remember.setVisibility(View.INVISIBLE);
                } else {
                    tv_password.setText("登陆密码: ");
                    et_password.setHint("请输入密码");
                    btn_forget.setText("忘记密码");
                    cb_remember.setVisibility(View.VISIBLE);
                }
            }
        });

        // 点击登陆按钮
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 点击了登陆按钮，收集用户填写的数据
                String msg = "";
                if (checkedId == R.id.rb_password) {
                    if(password.contentEquals(et_password.getText())) {
                        msg = "登陆成功";
                    } else {
                        msg = "密码错误";
                        et_password.setText("");
                    }
                } else {
                    if(code.contentEquals(et_password.getText())) {
                        msg = "登陆成功";
                    } else {
                        msg = "验证码错误, 请重新获取验证码";
                        et_password.setText("");
                    }
                }

                if("登陆成功".equals(msg)) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                    builder.setTitle("登陆成功")
                           .setMessage("你已登陆成功是否返回上一个界面")
                           .setPositiveButton("返回上一界面", new DialogInterface.OnClickListener() {
                               @Override
                               public void onClick(DialogInterface dialog, int which) {
                                   startActivity(new Intent(LoginActivity.this, MainActivity.class));
                               }
                           })
                           .setNegativeButton("我再想想", new DialogInterface.OnClickListener() {
                               @Override
                               public void onClick(DialogInterface dialog, int which) {

                               }
                           }).show();
                }
                Toast.makeText(LoginActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        });

        // 忘记密码或者个获取验证码
        btn_forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkedId == R.id.rb_password) {
                    // 前往忘记密码界面，重新设置密码
                    startActivityForResult(new Intent(LoginActivity.this, ModifyActivity.class), 0);
                } else {
                    // 获取验证码
                    Editable phone = et_phone.getText();
                    if(phone.length() < 11) return;

                    // 生成验证码
                    String code = VerificationCode.code();
                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                    builder.setTitle("请记住密码")
                           .setMessage("手机号: " + phone + ", 本次验证码是: " + code + ", 请输入验证码")
                           .setPositiveButton("好的", new DialogInterface.OnClickListener() {
                               @Override
                               public void onClick(DialogInterface dialog, int which) {
                                   // 保存验证码用于校验
                                   LoginActivity.code = code;
                               }
                           }).show();
                }
            }
        });

        // 手机号输入框
        et_phone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                // 手机号输入11位后关闭软键盘
                if(s.length() == 11) {
                    // 从系统服务中获取输入法管理器
                    InputMethodManager imm = (InputMethodManager) LoginActivity.this.getSystemService(Context.INPUT_METHOD_SERVICE);
                    // 关闭屏幕上的输入法软键盘
                    imm.hideSoftInputFromWindow(et_phone.getWindowToken(), 0);
                }
            }
        });

        // 验证码或密码输入框
        et_password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                // 密码或验证码输入6位后关闭软键盘
                if(s.length() == 6) {
                    // 从系统服务中获取输入法管理器
                    InputMethodManager imm = (InputMethodManager) LoginActivity.this.getSystemService(Context.INPUT_METHOD_SERVICE);
                    // 关闭屏幕上的输入法软键盘
                    imm.hideSoftInputFromWindow(et_phone.getWindowToken(), 0);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 0 && resultCode == Activity.RESULT_OK) {
            this.password = data.getStringExtra("password");
        }
    }
}