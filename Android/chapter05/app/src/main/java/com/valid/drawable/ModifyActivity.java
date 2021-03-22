package com.valid.drawable;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.valid.drawable.util.VerificationCode;

public class ModifyActivity extends AppCompatActivity {

    private EditText et_first_password; //第一次输密码的输入框
    private EditText et_second_password; // 第二次输密码的输入框
    private Button btn_code; // 获取验证码的按钮
    private Button btn_modify; // 确认修改密码的按钮
    private EditText et_code; // 验证码的输入框

    private static String code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify);

        et_first_password = findViewById(R.id.et_first_password);
        et_second_password = findViewById(R.id.et_second_password);

        btn_code = findViewById(R.id.btn_code);
        btn_modify = findViewById(R.id.btn_modify);
        et_code = findViewById(R.id.et_code);

        // 修改密码并将密码返回给登陆界面
        btn_modify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(code.equals(et_code.getText().toString())) {
                    Intent intent = new Intent();
                    intent.putExtra("password", et_first_password.getText().toString());
                    setResult(Activity.RESULT_OK, intent);
                    finish();
                }
            }
        });

        // 监控当第二次密码输入为位时，检验密码的合法性
        et_second_password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.length() == 6 &&
                        !et_first_password.getText().toString().equals(et_second_password.getText().toString())) {
                    Toast.makeText(ModifyActivity.this, "两次密码输入不一致，请重新输入", Toast.LENGTH_SHORT).show();
                    et_first_password.setText("");
                    et_second_password.setText("");
                } else {
                    Toast.makeText(ModifyActivity.this, "两次密码一致，请获取验证码并输入", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // 获取验证码
        btn_code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ModifyActivity.this);

                String code = VerificationCode.code();
                builder.setTitle("验证码")
                       .setMessage("本次修改密码的验证码为: " + code + ", 请在下方输入验证码")
                       .setPositiveButton("好的", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                ModifyActivity.code = code;
                            }
                       }).show();
            }
        });
    }
}