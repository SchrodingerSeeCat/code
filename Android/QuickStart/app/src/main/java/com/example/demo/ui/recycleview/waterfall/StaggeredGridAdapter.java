package com.example.demo.ui.recycleview.waterfall;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demo.R;

public class StaggeredGridAdapter extends RecyclerView.Adapter<StaggeredGridAdapter.LinearViewHolder> {

    private Context context;

    public StaggeredGridAdapter(Context context) {
        this.context = context;
    }
    @NonNull
    @Override
    public StaggeredGridAdapter.LinearViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 设置每一个item的样式
        return new LinearViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_staggered_grid_rc_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull StaggeredGridAdapter.LinearViewHolder holder, int position) {
        if((position & 1) == 0) {
            // 设置item的内容
            holder.imageView.setImageResource(R.drawable.image1);
        } else {
            holder.imageView.setImageResource(R.drawable.image2);
        }
        // 给item添加点击事件
        holder.imageView.setOnClickListener(new View.OnClickListener() {
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

        private ImageView imageView;

        // 传入的View为每一个item的样式
        public LinearViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.iv);
        }
    }
}
