package com.tomas.with_you;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;

public class MainActivity extends AppCompatActivity {

    TabHost tabHost;

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

    }
}
