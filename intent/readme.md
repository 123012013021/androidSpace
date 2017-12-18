## 新建一个工程用来获取URL地址并启动Intent



输入URL网址，点击按钮，将发起浏览网页的行为


1. 建一个.xml文件。给布局包含有 一个文本输入框、以及一个按钮
```  <EditText
            android:id="@+id/URL"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:inputType="textUri"
            android:text="http://www.baidu.com/"></EditText>

            <Button
                android:id="@+id/button1"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_gravity="center"
                android:layout_below="@+id/URL"
                android:layout_marginTop="50px"
                android:layout_marginLeft="80px"
                android:background="@color/btn_color"
                android:text="浏览该网页"
                android:textSize="14sp" />
```

2. 建.java文件
```

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
                startActivity(intent);//将Intent传递给Activity```


#### 实验结果截图：

![](https://github.com/123012013021/javaSpace/blob/master/IO_2/img/1.png)<br>

![](https://github.com/123012013021/javaSpace/blob/master/IO_2/img/1.png)<br>
  
  
  
## 新建一个工程使用WebView来加载URL

跳转之后，出现选择项，选择自定义的MyBrowser进行浏览




1. 建activity_main.xml以及browseractivity.xml文件 activity_main该界面包含有 一个文本输入框、以及一个按钮.browseractivity中包含webview

<WebView
        android:id="@+id/my_webview"
        android:layout_width="match_parent"
        android:layout_height="match_parent">
    </WebView>

2. 修改AndroidManifest.xml，加入
<uses-permission android:name="android.permission.INTERNET"/>
<activity android:name=".BrowseActivity" android:label="自定义浏览器" android:exported="true">
            <intent-filter>
                    <action android:name="android.intent.action.VIEW" />
                    <category android:name="android.intent.category.DEFAULT" />
                    <data android:scheme="http" />
                    <data android:scheme="https" />
            </intent-filter>
```
3 编辑mainactivity.java以及browseractivity.java文件实现逻辑联系

``` EditText  url =(EditText)findViewById(R.id.URL);//获得编辑框控件
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
```


#### 实验结果截图：

<br>

![](https://github.com/123012013021/javaSpace/blob/master/IO_2/img/2.png)<br>

<br>

![](https://github.com/123012013021/javaSpace/blob/master/IO_2/img/2.png)<br>





    

