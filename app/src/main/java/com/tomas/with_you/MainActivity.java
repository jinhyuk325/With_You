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
import java.util.GregorianCalendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TabHost tabHost;
    ArrayList<String> datas = new ArrayList<>();
    ListView listView;
    ArrayAdapter adapter;



    ListView listView2;
    ArrayList<String> datas2 = new ArrayList<>();
    ArrayAdapter adapter2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabHost = findViewById(android.R.id.tabhost);

        //탭버튼(TabSpec)을 생성해서 TabHost에 추가
        tabHost.setup();//탭호스트에게 탭위젯의 버튼이 변경(생성)된다는 것을 알리는 목적.

        tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("달력").setContent(R.id.tab1));
        tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator("100일단위\n기념일").setContent(R.id.tab2));
        tabHost.addTab(tabHost.newTabSpec("tab3").setIndicator("1년단위\n기념일").setContent(R.id.tab3));


//        String day = DateFormat.getDateInstance().format(new Date());

//        long day = System.currentTimeMillis();
//        Date date = new Date(day);
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        String getTime = sdf.format(date);

        int Y;
        int M;
        int D;

        // 현재 날짜 구하기
        Calendar calendar = new GregorianCalendar(Locale.KOREA);
        Y = calendar.get(Calendar.YEAR);
        M = calendar.get(Calendar.MONTH) + 1;
        D = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println("GregorianCalendar = " + Y + "-"
                + M  + "-" + D);

        // Date 로 구하기
        SimpleDateFormat fm1 = new SimpleDateFormat("yyyy년MM월dd일");
        String date = fm1.format(new Date());



        listView = findViewById(R.id.listview);
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, datas);
        listView.setAdapter(adapter);
        datas.add("1일\n" + date);
        for (int i = 0; i < 100; i++) {

            Calendar cal = new GregorianCalendar(Locale.KOREA);
            cal.setTime(new Date());
//        cal.add(Calendar.YEAR, 1); // 1년을 더한다.
//        cal.add(Calendar.MONTH, 1); // 한달을 더한다.
            cal.add(Calendar.DAY_OF_YEAR, (i+1)*100); // 하루를 더한다.
            if(i==0){
                cal.add(Calendar.DAY_OF_YEAR, -1);
            }
//        cal.add(Calendar.HOUR, 1); // 시간을 더한다

            SimpleDateFormat fm = new SimpleDateFormat("yyyy년MM월dd일");
            String strDate = fm.format(cal.getTime());

            datas.add((i + 1) + "00일\n" +strDate);
        }

        listView2 = findViewById(R.id.listview2);
        adapter2 = new ArrayAdapter(this, android.R.layout.simple_list_item_1, datas2);
        listView2.setAdapter(adapter2);
        for (int i = 0; i < 30; i++) {

            Calendar cal = new GregorianCalendar(Locale.KOREA);
            cal.setTime(new Date());
//        cal.add(Calendar.YEAR, 1); // 1년을 더한다.
//        cal.add(Calendar.MONTH, 1); // 한달을 더한다.
            cal.add(Calendar.DAY_OF_YEAR, (i+1)*365);
//        cal.add(Calendar.HOUR, 1); // 시간을 더한다

            SimpleDateFormat fm = new SimpleDateFormat("yyyy년MM월dd일");
            String strDate = fm.format(cal.getTime());

            datas2.add((i + 1) + "주년\n" +strDate);
        }


    }


}
