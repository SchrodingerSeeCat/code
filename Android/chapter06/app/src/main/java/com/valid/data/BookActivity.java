package com.valid.data;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.valid.data.entity.BookInfo;

public class BookActivity extends AppCompatActivity {

    private EditText et_name;
    private EditText et_author;
    private EditText et_press;
    private EditText et_price;
    private Button btn_save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        et_name = findViewById(R.id.et_name);
        et_author = findViewById(R.id.et_author);
        et_press = findViewById(R.id.et_press);
        et_price = findViewById(R.id.et_price);
        btn_save = findViewById(R.id.btn_save);

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = et_name.getText().toString();
                String author = et_author.getText().toString();
                String press = et_press.getText().toString();
                double price = Double.parseDouble(et_price.getText().toString());

                BookInfo book = new BookInfo();
                book.setName(name);
                book.setAuthor(author);
                book.setPress(press);
                book.setPrice(price);
                MainApplication.getInstance().getBookDatabase().bookDao().insertOneBook(book);

                Toast.makeText(BookActivity.this, "插入成功", Toast.LENGTH_SHORT).show();
            }
        });
    }
}