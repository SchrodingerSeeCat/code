package com.valid.data;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MemoryCardActivity extends AppCompatActivity {

    private TextView tv_file_path;
    private EditText et_input; // 输入要存储的数据
    private Button btn_get; // 获取数据
    private Button btn_set; // 获取数据
    private TextView tv_show; // 数据展示框

    private Button btn_get_image; // 读取图片
    private Button btn_save_image; // 保存图片

    private ImageView iv_image; // 展示图片

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory_card);

        tv_file_path = findViewById(R.id.tv_file_path);
        et_input = findViewById(R.id.et_input);
        btn_get = findViewById(R.id.btn_get);
        tv_show = findViewById(R.id.tv_show);
        btn_set = findViewById(R.id.btn_set);
        btn_get_image = findViewById(R.id.btn_get_image);
        btn_save_image = findViewById(R.id.btn_save_image);
        iv_image = findViewById(R.id.iv_image);

        String filePath = getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).toString() + "/userinfo";
        String downloads = getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).toString() + "/";

        // 获取系统的公共存储路径
        String publicPath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString();

        // 获取当前App的私有存储路径
        String privatePath = getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).toString();

        tv_file_path.setText("系统的公共存储路径: \n" + publicPath + "\n\n当前App的私有路径: \n" + privatePath);


        // 获取文件中的数据
        btn_get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = openText(filePath);
                tv_show.setText(text);
            }
        });

        // 保存数据到文件
        btn_set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveText(filePath, et_input.getText().toString());
                et_input.setText("");
            }
        });

        // 从当前项目资源文件中获取图片
        btn_get_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.sddssd);
                Bitmap bitmap = openImage(downloads + "123.jpg");
                iv_image.setImageBitmap(bitmap);
            }
        });

        // 保存图片
        btn_save_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveImage(downloads + "123.jpg", BitmapFactory.decodeResource(getResources(), R.drawable.sddssd));
            }
        });
    }

    // 把字符串保存到指定路径的文本文件
    public static void saveText(String path, String txt) {
        // 根据指定的文件构建文件输出流对象
        try (FileOutputStream out = new FileOutputStream(path)){
            out.write(txt.getBytes()); //把字符串写入到文件输出流
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 从指定路径的文本文件中读取内容字符串
    public static String openText(String path) {
        String str = "";

        try(FileInputStream in = new FileInputStream(path)) {
            // 构建文件输出的字节数组
            byte[] buffer = new byte[in.available()];
            in.read(buffer);
            str = new String(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    // 图片的读取, ImageView可以直接使用setImageBitmap设置试图的位图对象
    public static Bitmap openImage(String path) {
        Bitmap bitmap = null; //声明一个位图对象

        // 根据指定的文件路径构建文件输入流对象
        try (FileInputStream in = new FileInputStream(path)) {
            bitmap = BitmapFactory.decodeStream(in); // 从文件输入流中解码位图数据
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    // 图片保存,
    public static void saveImage(String path, Bitmap bitmap) {
        try (FileOutputStream out = new FileOutputStream(path)) {
            // 把位图数据压缩到文件输出流中
            bitmap.compress(Bitmap.CompressFormat.JPEG, 80, out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}