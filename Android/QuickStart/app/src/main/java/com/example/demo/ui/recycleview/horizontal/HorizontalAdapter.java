package com.example.demo.ui.recycleview.horizontal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demo.R;

public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.LinearViewHolder> {

    private Context context;

    public HorizontalAdapter(Context context) {
        this.context = context;
    }
    @NonNull
    @Override
    public HorizontalAdapter.LinearViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 设置每一个item的样式
        return new LinearViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_hor_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalAdapter.LinearViewHolder holder, int position) {

        // 设置item的内容
        holder.textView.setText("Hello Horizontal");

        // 给item添加点击事件
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "pos: " + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        // 用于构建列表的长度
        return 30;
    }

    class LinearViewHolder extends  RecyclerView.ViewHolder{

        private TextView textView;

        // 传入的View为每一个item的样式
        public LinearViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.tv_title);
        }
    }
}
