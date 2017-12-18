package com.example.administrator.intent;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    private Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//设置页面布局

        button1=(Button)findViewById(R.id.button1);//获取按钮控件
        button1.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                EditText editText1=(EditText)findViewById(R.id.URL);//获得编辑框控件
                Intent intent=new Intent();//创建Intent对象
                intent.setAction(Intent.ACTION_VIEW);//为Intent设置动作
                String data=editText1.getText().toString();//获取编辑框里面的文本内容
                intent.setData(Uri.parse(data));//为Intent设置数据
                startActivity(intent);//将Intent传递给Activity
            }
        });
    }

}
