package com.example.administrator.webview;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;

import java.util.List;

public class MainActivity extends Activity {
    WebView show;
    Button search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取页面中文本框,WebView组件
        show = (WebView) findViewById(R.id.show);
        search = (Button) findViewById(R.id.button1);
        search.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                EditText  url =(EditText)findViewById(R.id.URL);//获得编辑框控件
                Intent intent=new Intent();//创建Intent对象
                intent.setAction(Intent.ACTION_VIEW);//为Intent设置动作
                String data=url.getText().toString();//获取编辑框里面的文本内容
                intent.setData(Uri.parse(data));//为Intent设置数据
                intent.addCategory(Intent.CATEGORY_DEFAULT);
                intent.putExtra("url", "http://www.baidu.com");
                PackageManager pm = getPackageManager();
                List<ResolveInfo> resolveList = pm.queryIntentActivities(intent, PackageManager.MATCH_ALL);
                Log.i("MainActivity", "resolveList size:"+resolveList.size());
                if(resolveList.size() > 0) {
                    String title = "open with mybrowser";
                    Intent intentChooser = Intent.createChooser(intent, title);
                    startActivity(intentChooser);

                }else {
                    Toast.makeText(MainActivity.this, "no match activity to start!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}


