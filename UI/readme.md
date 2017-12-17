## Android ListView的用法



利用SimpleAdapter实现如下界面效果：

![](https://github.com/123012013021/androidSpace/blob/master/UI/img/1demo.png)<br>
------------------------------------------
（1）注意列表项的布局
（2）图片使用QQ群附件资源
（3）使用Toast显示选中的列表项信息

1. 建一个.xml文件
``` <?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context="com.example.administrator.activitylist.MainActivity">
    <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
        android:orientation="vertical"
        android:layout_width="fill_parent"
        android:layout_height="fill_parent"
        >
        <!-- 定义一个List -->
        <ListView android:id="@+id/mylist"
            android:layout_width="fill_parent"
            android:layout_height="wrap_content"
            />
        <LinearLayout android:orientation="horizontal"
            android:layout_width="fill_parent"
            android:layout_height="fill_parent">
            <!-- 定义一个ImageView，用于作为列表项的一部分。 -->
            <!-- 定义一个TextView，用于作为列表项的一部分。 -->
            <TextView android:id="@+id/name"
                android:layout_width="80dp"
                android:layout_height="50dp"
                android:textSize="16dp"
                android:layout_alignParentLeft="true"
                android:gravity="center_vertical"
                android:paddingLeft="10dp"
                />
            <ImageView android:id="@+id/imag"
                android:layout_width="50dp"
                android:layout_height="50dp"
                android:layout_alignParentRight="true"
               android:paddingLeft="10dp"
               android:layout_marginLeft="250dp"
                />
        </LinearLayout>
    </LinearLayout>


</android.support.constraint.ConstraintLayout>```

2. 将picture资源放到drawable文件夹里，再建.java文件
```


public class MainActivity extends AppCompatActivity {

    private String[] names = new String[]
            { "Lion", "Tiger","Monkey","Dog","Cat","Elephant" };
    private int[] imageIds = new int[]
            { R.drawable.lion , R.drawable.tiger,R.drawable.monkey,R.drawable.dog,R.drawable.cat,R.drawable.elephant};

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //创建一个List集合，List集合的元素是Map
        final List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < names.length; i++)
        {
            Map<String, Object> listItem = new HashMap<String, Object>();
            listItem.put("image", imageIds[i]);
            listItem.put("name", names[i]);
            listItems.add(listItem);
        }
        //创建一个SimpleAdapter
        SimpleAdapter simpleAdapter = new SimpleAdapter(this
                , listItems
                , R.layout.activity_main
                , new String[]{ "image", "name" }
                , new int[]{R.id.imag , R.id.name});


        final ListView list = (ListView)findViewById(R.id.mylist);
        final TextView text = (TextView)findViewById(R.id.name);
        //为ListView设置Adapter
        list.setAdapter(simpleAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                HashMap<String,Object> map = (HashMap<String,Object> )list.getItemAtPosition(position);
                String Name = (String) map.get("name");
                Toast.makeText(getApplicationContext(),Name,Toast.LENGTH_SHORT).show();
            }
        });

    }
} 


#### 实验结果截图：

![](https://github.com/123012013021/androidSpace/blob/master/UI/img/1.png)<br>

![](https://github.com/123012013021/androidSpace/blob/master/UI/img/1click.png)<br>
  
  
  
## Android ListView的用法

创建如图所示的自定义对话框


![](https://github.com/123012013021/androidSpace/blob/master/UI/img/2demo.png)<br>

调用 AlertDialog.Builder 对象上的 setView() 将布局添加到 AlertDialog。

------------------------

1. 建activity_main.xml文件 该界面只有一个button点击button 触发登录框
2. 建alertdialog.xml文件  登录窗口
```
//相对布局
    <RelativeLayout
        android:layout_width="250dp"
        android:layout_height="250dp"
        android:layout_centerInParent="true"
        android:layout_gravity="center">

        <TextView
            android:id="@+id/dialog_title"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginTop="30dp"
            android:background="@drawable/dialog_bg"
            android:gravity="center"
            android:text="ANDROID APP"
            android:textSize="18sp" />


        <EditText
            android:id="@+id/username"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_below="@+id/dialog_title"
            android:padding="20dp"
            android:textSize="18sp"
            android:hint="Username"
         ></EditText>

        <EditText
            android:id="@+id/passward"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:padding="20dp"
            android:textSize="18sp"
            android:hint="Password"
            android:layout_below="@+id/username"
            android:layout_alignParentStart="true"></EditText>


        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_alignParentBottom="true"
            android:orientation="horizontal">

            <Button
                android:id="@+id/dialog_btn_cancel"
                android:layout_width="0dp"
                android:layout_height="wrap_content"
                android:layout_weight="1"
                android:background="@null"
                android:text="cancle"
                android:textSize="14sp" />

            <Button
                android:id="@+id/dialog_btn_sure"
                android:layout_width="0dp"
                android:layout_height="wrap_content"
                android:layout_weight="1"
                android:background="@null"
                android:text="sign in"
                android:textSize="14sp" />
        </LinearLayout>
    </RelativeLayout>```

3. 建.java文件 实现逻辑联系
```
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button bn = (Button)findViewById(R.id.bn);
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        bn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                LinearLayout linerout = (LinearLayout)getLayoutInflater().inflate(R.layout.alertdialog,null);
                builder.setView(linerout);
                builder.show();
            }
        });
    }

#### 实验结果截图：

 登录框：<br>

![](https://github.com/123012013021/androidSpace/blob/master/UI/img/2.png)<br>

 输入时：<br>

![](https://github.com/123012013021/androidSpace/blob/master/UI/img/2click.png)<br>

## 使用XML定义菜单


创建如图所示的自定义对话框<br>


![](https://github.com/123012013021/androidSpace/blob/master/UI/img/3demo.png)<br>

使用XML定义菜单
字体大小（有小，中，大这3个选项；分别对应10号字，16号字和20号字）；点击之后设置测试文本的字体
普通菜单项，点击之后弹出Toast提示
字体颜色（有红色和黑色这2个选项），点击之后设置测试文本的字体

1. 创建 测试文字 的xml文件


 <EditText
            android:id="@+id/et"
            android:layout_width="fill_parent"
            android:layout_height="wrap_content"
            android:text="用于测试的内容"
            android:editable="false"
            />
            
  2.  .java文件中创建菜单栏
 public boolean onCreateOptionsMenu(Menu menu){
        SubMenu fontMenu = menu.addSubMenu("字体大小");
        fontMenu.setHeaderTitle("选择字体大小");
        fontMenu.add(0,Font_10,0,"10号字体");
        fontMenu.add(0,Font_16,0,"16号字体");
        fontMenu.add(0,Font_20,0,"20号字体");
        menu.add(0,Plain_Item,0,"普通菜单选项");
        SubMenu colorMenu = menu.addSubMenu("字体颜色");
        colorMenu.setHeaderTitle("选择字体颜色");
        colorMenu.add(0,Font_red,0,"红色");
        colorMenu.add(0,Font_black,0,"黑色");
        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(MenuItem mi){
        switch (mi.getItemId()){
            case Font_10:
                edit.setTextSize(10*2);
                break;
            case Font_16:
                edit.setTextSize(16*2);
                break;
            case Font_20:
                edit.setTextSize(20*2);
                break;
            case Plain_Item:
                Toast toast=Toast.makeText(MainActivity.this,"点击普通菜单选项",Toast.LENGTH_SHORT);
                toast.show();
                break;
            case Font_red:
                edit.setTextColor(Color.RED);
                break;
            case Font_black:
                edit.setTextColor(Color.BLACK);
                break;
        }
        return
                true;
    }


#### 实验结果截图：

字体变黑：
<br>

![](https://github.com/123012013021/androidSpace/blob/master/UI/img/3.png)<br>

字体变红：<br>

![](https://github.com/123012013021/androidSpace/blob/master/UI/img/3click.png)<br>



    

