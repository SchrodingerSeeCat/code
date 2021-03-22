package com.valid.data;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.valid.data.dao.MySQLite;
import com.valid.data.entity.UserInfo;

import java.util.LinkedList;
import java.util.List;

public class SQLiteReadActivity extends AppCompatActivity {

    private EditText et_name;
    private EditText et_age;
    private EditText et_height;
    private EditText et_weight;
    private EditText et_phone;
    private EditText et_password;

    private CheckBox cb_married;

    private Button btn_save;

    // 声明一个用户数据库的帮助器对象
    private MySQLite mySQLite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_read);

        et_name = findViewById(R.id.et_name);
        et_age = findViewById(R.id.et_age);
        et_height = findViewById(R.id.et_height);
        et_weight = findViewById(R.id.et_weight);
        et_phone = findViewById(R.id.et_phone);
        et_password = findViewById(R.id.et_password);

        cb_married = findViewById(R.id.cb_married);

        btn_save = findViewById(R.id.btn_save);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = et_name.getText().toString();
                int age = Integer.parseInt(et_age.getText().toString());
                Integer height = Integer.parseInt(et_height.getText().toString());

                Double weight = Double.parseDouble(et_weight.getText().toString());
                String phone = et_phone.getText().toString();
                String password = et_password.getText().toString();
                Boolean married = cb_married.isChecked();

                List<UserInfo> list = new LinkedList<>();
                list.add(new UserInfo(name, age, weight, height, married, System.currentTimeMillis(), phone, password));
                Long count = mySQLite.insert(list);
                Log.d("插入成功的条数: ", count + "");
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        mySQLite = MySQLite.getInstance(SQLiteReadActivity.this, 1); //获取数据库连接

        mySQLite.openWriteLink(); // 恢复页面,则打开数据库连接
    }

    @Override
    protected void onPause() {
        super.onPause();
        mySQLite.closeLink(); //暂停页面,则关闭数据库连接
    }
}