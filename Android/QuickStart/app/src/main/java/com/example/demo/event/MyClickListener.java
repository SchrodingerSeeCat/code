package com.example.demo.event;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.example.demo.R;

public class MyClickListener implements View.OnClickListener {

    private Context context;

    public MyClickListener(Context context) {
        this.context = context;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_event_1:
                Toast.makeText(context, "Click4...", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
