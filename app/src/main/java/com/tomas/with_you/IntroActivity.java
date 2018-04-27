package com.tomas.with_you;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class IntroActivity extends AppCompatActivity {

    ImageView iv;
    Timer timer=new Timer(); //스케쥴 비서
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        iv= findViewById(R.id.iv);
        //View에게 애니메이션 효과를 주는 객체 생성

        //appear_logo.xml문서를 읽어서 Animation객체로 생성
        Animation ani= AnimationUtils.loadAnimation(this, R.anim.appear_logo);
        iv.startAnimation(ani);

        //4초 후에 MainActivity 실행
        //스케쥴관리 객체에게 스케쥴 등록
        timer.schedule(task,4000);


    }

    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            Intent intent=new Intent(IntroActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
    };
}
