package com.example.demo.ui.webview;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

public class JSObj {
    private Context context;

    public JSObj(Context context) {
        this.context = context;
    }
    @JavascriptInterface
    public void test(String str) {
        Toast.makeText(context, "调用了", Toast.LENGTH_SHORT).show();
    }
}
