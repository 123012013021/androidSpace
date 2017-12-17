package com.example.administrator.activitylist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.widget.SimpleAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
