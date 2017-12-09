## Android布局实验



利用线性布局实现如下界面：

![](https://github.com/123012013021/androidSpace/blob/master/Layout/img/4.png)<br>
------------------------------------------
先在res/drawable文件夹下添加一个xml文件btn_styles，可以在button中使用该样式上色。
···
<?xml version="1.0" encoding="UTF-8"?>
<layer-list xmlns:android="http://schemas.android.com/apk/res/android">

    <item>
        <shape>
            <solid android:color="@android:color/white" />
        </shape>
    </item>
    <item
        android:bottom="3dp"
        android:top="3dp"
        android:left="3dp"
        android:right="3dp">
        <shape>
            <solid android:color="@android:color/black" />
        </shape>
    </item>

</layer-list>···
布局选择垂直布局嵌套四个水平布局。
···
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    android:orientation="vertical"
   >
    <LinearLayout
        android:orientation="horizontal">
        <Button />
        <Button/>
        <Button />
        <Button/>
 </LinearLayout>

       <LinearLayout
        android:orientation="horizontal">
        <Button />
        <Button/>
        <Button />
        <Button/>
    </LinearLayout>
           <LinearLayout
        android:orientation="horizontal">
        <Button />
        <Button/>
        <Button />
        <Button/>
    </LinearLayout>
           <LinearLayout
        android:orientation="horizontal">
        <Button />
        <Button/>
        <Button />
        <Button/>
    </LinearLayout>
</LinearLayout>
···
  

  

#### 实验结果截图：

![](https://github.com/123012013021/androidSpace/blob/master/Layout/img/1.png)<br>
  
  
利用相对布局实现如下界面

![](https://github.com/123012013021/androidSpace/blob/master/Layout/img/5.png)<br>

```
采用相对布局管理器
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
> 
//red按钮贴近父元素左边<br>

    <Button
        android:layout_alignParentLeft="true"
      " />
      
      
//ORANG按钮相对于父元素完全居中<br>

    <Button
        android:layout_centerHorizontal="true"
      />
      

//yellow按钮相对于父元素右边<br>

    <Button
        android:layout_alignParentRight="true"
      />


//blue按钮相对于父元素完全居中并在red元素的下方<br>
    <Button
        android:layout_below="@+id/Left"
        android:layout_centerHorizontal="true"
     
        />
//green在red元素的下方 在blue按钮的左边<br>
    <Button
        android:layout_below="@+id/Left"
        android:layout_toLeftOf="@+id/Butten3"
        android:layout_toStartOf="@+id/Butten3"
        />
//indigo在red元素的下方 在blue按钮的右边<br>
    <Button
        android:layout_below="@+id/Left"
        android:layout_toEndOf="@+id/Butten3"
        android:layout_toRightOf="@+id/Butten3"
    />
//VIOLET在离某元素blue的距离37dp，紧贴父元素结束位置开始<br>
 
    <Button      
        android:layout_marginTop="37dp"
        android:layout_below="@+id/Butten3"
        android:layout_alignParentStart="true" />
</RelativeLayout>

```
#### 实验结果截图：

![](https://github.com/123012013021/androidSpace/blob/master/Layout/img/2.png)<br><br><br>

    

利用表格布局实现如下界面：<br>
![](https://github.com/123012013021/androidSpace/blob/master/Layout/img/6.png)<br>
```
//定义表格布局管理器  tablelayout内嵌套多个tablerow

<TableLayout >
    <TableRow        
    </TableRow>
    <TableRow
    </TableRow>
    <TableRow
    </TableRow>
    <TableRow
    <TableRow
    </TableRow>
</TableLayout>```

#### 实验结果截图：

![](https://github.com/123012013021/androidSpace/blob/master/Layout/img/3.png)
