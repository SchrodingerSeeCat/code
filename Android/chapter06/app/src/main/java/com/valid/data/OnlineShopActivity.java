package com.valid.data;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.valid.data.entity.Good;


import java.util.List;

public class OnlineShopActivity extends AppCompatActivity {

    private GridLayout gl_channel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online_shop);

        showGoods();
    }

    public void showGoods() {
        gl_channel = findViewById(R.id.gl_channel);

        gl_channel.removeAllViews(); // 移除下面的所有子视图

        // 查询数据库中的所有商品记录
        List<Good> goods = MainApplication.getInstance().getGoodDatabase().goodDao().getAllGoods();

        // 将所有的商品渲染至页面
        readerView(goods);
    }

    public void readerView(List<Good> goods) {

        for(Good good : goods) {
        good.setName("haa");
        good.setPrice(1234.0);
            View view = LayoutInflater.from(OnlineShopActivity.this).inflate(R.layout.item_goods, null);
            ImageView iv_thumb = view.findViewById(R.id.iv_thumb);
            TextView tv_name = view.findViewById(R.id.tv_name);
            TextView tv_price = view.findViewById(R.id.tv_price);

            Button btn_add = view.findViewById(R.id.btn_add);

            tv_name.setText(good.getName()); // 设置商品的名字
            iv_thumb.setImageURI(Uri.parse(good.getPath())); // 设置商品图片
            iv_thumb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(OnlineShopActivity.this, ChartActivity.class);
                    intent.putExtra("goods_id", good.getId());
                    startActivity(intent);
                }
            });
            tv_price.setText("" + good.getPrice()); //设置商品价格
            btn_add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // 添加商品到购物车
                }
            });
            gl_channel.addView(view); // 把商品视图添加到网格布局
        }
    }
}