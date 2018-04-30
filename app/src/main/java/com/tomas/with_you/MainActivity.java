package com.tomas.with_you;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TabHost;

import java.text.Collator;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TabHost tabHost;
    ArrayList<Member> members = new ArrayList<>();
    ListView listView;
//    ArrayAdapter adapter;
    MyAdapter adapter;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabHost = findViewById(android.R.id.tabhost);

        //탭버튼(TabSpec)을 생성해서 TabHost에 추가
        tabHost.setup();//탭호스트에게 탭위젯의 버튼이 변경(생성)된다는 것을 알리는 목적.

        tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("Main").setContent(R.id.tab1));
        tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator("기념일").setContent(R.id.tab2));
        tabHost.addTab(tabHost.newTabSpec("tab3").setIndicator("설정").setContent(R.id.tab3));


//        String day = DateFormat.getDateInstance().format(new Date());

//        long day = System.currentTimeMillis();
//        Date date = new Date(day);
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        String getTime = sdf.format(date);

//        int Y;
//        int M;
//        int D;
//
//        // 현재 날짜 구하기
//        Calendar calendar = new GregorianCalendar(Locale.KOREA);
//        Y = calendar.get(Calendar.YEAR);
//        M = calendar.get(Calendar.MONTH) + 1;
//        D = calendar.get(Calendar.DAY_OF_MONTH);


        // Date 로 구하기
        SimpleDateFormat fm1 = new SimpleDateFormat("yyyy년MM월dd일");
        String date = fm1.format(new Date());




        listView = findViewById(R.id.listview);
//        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, members);

        adapter=new MyAdapter(members,getLayoutInflater());
        listView.setAdapter(adapter);



        for (int i = 0; i < 100; i++) {

            Calendar cal = new GregorianCalendar(Locale.KOREA);
            cal.setTime(new Date());
//        cal.add(Calendar.YEAR, 1); // 1년을 더한다.
//        cal.add(Calendar.MONTH, 1); // 한달을 더한다.
            cal.add(Calendar.DAY_OF_YEAR, (i+1)*100-1); // 하루를 더한다.


//        cal.add(Calendar.HOUR, 1); // 시간을 더한다

            SimpleDateFormat fm = new SimpleDateFormat("yyyy년MM월dd일");
            String strDate = fm.format(cal.getTime());

            Date Date1=fm.parse(strDate, new ParsePosition(0));
            Date Date2=fm1.parse(date, new ParsePosition(0));

            long diff=Date1.getTime()-Date2.getTime();
            String s= String.valueOf("D-"+diff/1000/60/24/60+"일");


            members.add(new Member((i+1)+"00일",strDate,s));
        }

        for (int i = 0; i < 30; i++) {

            Calendar cal = new GregorianCalendar(Locale.KOREA);
            cal.setTime(new Date());
//        cal.add(Calendar.YEAR, 1); // 1년을 더한다.
//        cal.add(Calendar.MONTH, 1); // 한달을 더한다.
            cal.add(Calendar.DAY_OF_YEAR, (i+1)*365);
//        cal.add(Calendar.HOUR, 1); // 시간을 더한다

            SimpleDateFormat fm = new SimpleDateFormat("yyyy년MM월dd일");
            String strDate = fm.format(cal.getTime());

            Date Date1=fm.parse(strDate, new ParsePosition(0));
            Date Date2=fm.parse(date, new ParsePosition(0));

            long diff=Date1.getTime()-Date2.getTime();
            String s= String.valueOf("D-"+diff/1000/60/24/60+"일");

            members.add(new Member((i+1)+"주년",strDate,s));
        }





//        for (int i = 0; i < 30; i++) {
//        d_day.add(Calendar.YEAR, 1); // 1년을 더한다.
////        cal.add(Calendar.MONTH, 1); // 한달을 더한다.
////            cal.add(Calendar.DAY_OF_YEAR, (i+1)*365);
////        cal.add(Calendar.HOUR, 1); // 시간을 더한다
//
//            SimpleDateFormat fm = new SimpleDateFormat("yyyy년MM월dd일");
//            String strDate = fm.format(d_day.getTime());
//

//        }




    }


}
