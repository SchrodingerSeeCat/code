package com.example.demo.ui.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.demo.R;

public class MyListAdapter extends BaseAdapter {

    // 列表的长度
    private int count = 10;

    private Context context;
    private LayoutInflater layoutInflater;

    public MyListAdapter(Context context) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return count;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView == null) {
            convertView = layoutInflater.inflate(R.layout.layout_list_item, null);

            holder = new ViewHolder();
            holder.imageView = convertView.findViewById(R.id.iv);
            holder.tvTitle = convertView.findViewById(R.id.tv_title);
            holder.tvTime = convertView.findViewById(R.id.tv_time);
            holder.tvContent = convertView.findViewById(R.id.tv_content);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        // 给控件赋值
        holder.tvTitle.setText("标题");
        holder.tvTime.setText("2022-02-22 22:22");
        holder.tvContent.setText("测试ListView");
        Glide.with(context).load("https://bkimg.cdn.bcebos.com/pic/77c6a7efce1b9d16fdfad17f0494a38f8c5494eeced0?x-bce-process=image/resize,m_lfit,w_640,limit_1").into(holder.imageView);

        return convertView;
    }

    private static class ViewHolder{
        public ImageView imageView;
        public TextView tvTitle, tvTime, tvContent;
    }
}
