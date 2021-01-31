package com.example.demo.ui.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.demo.R;

/*
* WebView 从本地或者网络上加载html文件并显示
* 网络的URL需要设置 js的支持
* */
public class WebViewActivity extends AppCompatActivity {

    private WebView webView;
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        webView = findViewById(R.id.web_view);

        // 设置支持js
        webView.getSettings().setJavaScriptEnabled(true);

        // 设置只在本页面打开url，而不唤醒浏览器
        webView.setWebViewClient(new MyWebViewClient());

        // 实现一些常用功能
        webView.setWebChromeClient(new MyWebChromeClient());

        // 加载本地的html文件
//         webView.loadUrl("file:///android_asset/index.html");

        // 加载网络URL
        webView.loadUrl("https://m.baidu.com");
    }

    // 重写按键事件 使得WebView能够使用回退按键
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
            webView.goBack();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            String url = request.getUrl().toString();
            try{
                if((!url.startsWith("https://")) || (!url.startsWith("http://"))){
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(intent);
                    return true;
                }
            }catch (Exception e){
                return false;
            }

            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            Log.d("WebView", "开始加载之前");
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            Log.d("WebView", "加载结束之后");

            // 加载js代码
            // 方式一
            // webView.loadUrl("javascript:alert('hello1')");

            // 方式二
            // webView.evaluateJavascript("javascript:alert('hello2')", null);

            // 方式三
//            webView.addJavascriptInterface(new JSObj(WebViewActivity.this), "android_run");
        }
    }

    private class MyWebChromeClient extends WebChromeClient {
        private String title;
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            // 实现进度条的功能 newProgress 取值0-100
            if (newProgress < 100) {
                setTitle(newProgress + "%");
            } else {
                setTitle(title);
            }
        }

        @Override
        public void onReceivedTitle(WebView view, String title) {
            // 获取网页的标题栏 title
            this.title = title;
        }
    }
}