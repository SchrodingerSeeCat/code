package com.example.demo.ui.recycleview.linear;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demo.R;

public class LinearAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;

    public LinearAdapter(Context context) {
        this.context = context;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 设置每一个item的样式
        // 通过viewType设置不同的控件

        if (viewType == 0) return new LinearViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_linear_item, parent, false));

        return new LinearViewHolder2(LayoutInflater.from(context).inflate(R.layout.layout_linear_item2, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof LinearViewHolder) {
            ((LinearViewHolder) holder).textView.setText("LinearViewHolder");

            // 给item添加点击事件
            ((LinearViewHolder) holder).textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "pos: " + position, Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            ((LinearViewHolder2) holder).textView.setText("LinearViewHolder2");

            // 给item添加点击事件
            ((LinearViewHolder2) holder).textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "pos: " + position, Toast.LENGTH_SHORT).show();
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        // 用于构建列表的长度
        return 30;
    }

    @Override
    public int getItemViewType(int position) {
        // 偶数
        if((position & 1) == 0) return 0;

        // 奇数
        return 1;
    }

    class LinearViewHolder extends  RecyclerView.ViewHolder{

        private TextView textView;

        // 传入的View为每一个item的样式
        public LinearViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.tv_title);
        }
    }

    class LinearViewHolder2 extends  RecyclerView.ViewHolder{

        private TextView textView;
        private ImageView imageView;

        // 传入的View为每一个item的样式
        public LinearViewHolder2(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.tv_title);
            imageView = itemView.findViewById(R.id.iv_image);
        }
    }
}
