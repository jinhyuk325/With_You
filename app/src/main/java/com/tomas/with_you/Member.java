package com.tomas.with_you;

import android.support.annotation.NonNull;

/**
 * Created by jinhyuk on 2018-02-28.
 */

public class Member implements Comparable<Member>{
    String dday;  //디데이
    String event;    //기념일자
    String day;  //기념일


    //생성(new) 할때 자동으로 실행되는 메소드
    //생성자 메소드
    Member(String dday, String event, String day){
        this.dday=dday;
        this.event =event;
        this.day=day;


    }

    @Override
    public int compareTo(@NonNull Member member) {
        return 0;
    }
}
