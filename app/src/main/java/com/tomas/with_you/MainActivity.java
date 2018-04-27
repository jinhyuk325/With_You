package com.tomas.with_you;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    TabHost tabHost;
    ArrayList<String> datas= new ArrayList<>();

    ListView listView;
    ArrayAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabHost = findViewById(android.R.id.tabhost);

        //탭버튼(TabSpec)을 생성해서 TabHost에 추가
        tabHost.setup();//탭호스트에게 탭위젯의 버튼이 변경(생성)된다는 것을 알리는 목적.

        tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("탭1").setContent(R.id.tab1));
        tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator("탭2").setContent(R.id.tab2));
        tabHost.addTab(tabHost.newTabSpec("tab3").setIndicator("탭3").setContent(R.id.tab3));


//        String day = DateFormat.getDateInstance().format(new Date());

        long day=System.currentTimeMillis();
        Date date=new Date(day);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String getTime=sdf.format(date);



        listView= findViewById(R.id.listview);
        adapter= new ArrayAdapter(this, android.R.layout.simple_list_item_1, datas);
        listView.setAdapter(adapter);
        datas.add("1일\n"+getTime);
        for(int i=0;i<100;i++){
            datas.add((i+1)+"00일\n");
        }




    }
    public class dday{ public int caldate(int myear, int mmonth, int mday) {
        try {

            Calendar today = Calendar.getInstance(); //현재 오늘 날짜
            Calendar dday = Calendar.getInstance();
            dday.set(myear,mmonth,mday);// D-day의 날짜를 입력합니다.
            long day = dday.getTimeInMillis()/86400000;
            long tday = today.getTimeInMillis()/86400000;
            long count = tday - day; // 오늘 날짜에서 dday 날짜를 빼주게 됩니다.
            return (int) count+1; // 날짜는 하루 + 시켜줘야합니다.
        }

        catch (Exception e)
        {
            e.printStackTrace(); return -1;
        }

        }
    }
}
