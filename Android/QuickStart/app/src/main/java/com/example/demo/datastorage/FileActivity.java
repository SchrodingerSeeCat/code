package com.example.demo.datastorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.demo.R;

import org.w3c.dom.Text;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;


/*
 * 实现点击btnSave保存editText中内容，点击btnShow将保存的内容展示到tvShow
 * openFileOutput返回的是内部存储的位置，会随着应用的删除而删除
 *
 * 如果是存储在外部存储上的文件，则不会随着应用的删除而删除
 * File file = new File(Environment.getExternalStorageState(), "test") 在外部存储上新建文件夹，
 * */
public class FileActivity extends AppCompatActivity {

    private EditText editText;
    private Button btnSave;
    private Button btnShow;
    private TextView tvShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);

        editText = findViewById(R.id.et_name);
        btnSave = findViewById(R.id.btn_save);
        btnShow = findViewById(R.id.btn_show);
        tvShow = findViewById(R.id.tv_show);


        // 点击保存editText中的内容
        btnSave.setOnClickListener(v -> {
            save(editText.getText().toString());
        });

        // 点击btnShow将保存的内容展示到tvShow
        btnShow.setOnClickListener(v -> {
            tvShow.setText(read());
        });
    }

    // 保存的方法
    private void save(String content) {
        FileOutputStream out = null;
        try {
            out = openFileOutput("test.txt", MODE_PRIVATE);
            out.write(content.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // 读取信息
    private String read() {
        InputStreamReader in = null;
        StringBuffer sb = new StringBuffer();
        try {

            // openFileInput返回一个FileInputStream，但对于中文应该使用字符流，否则会乱码
            in = new InputStreamReader(openFileInput("test.txt"));
            char[] buffer = new char[1024];
            int n;
            while((n = in.read(buffer)) != -1) {
                sb.append(new String(buffer, 0, n));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }
}