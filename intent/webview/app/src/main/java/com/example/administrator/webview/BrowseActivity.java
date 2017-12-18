package com.example.administrator.webview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class BrowseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);
        WebView wv = (WebView)findViewById(R.id.my_webview);//通过findViewById寻找元素
        wv.loadUrl(url);//调用其loadUrl函数显示网页
    }

}
