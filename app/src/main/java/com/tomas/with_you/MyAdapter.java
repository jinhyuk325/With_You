package com.tomas.with_you;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by jinhyuk on 2018-02-28.
 */

public class MyAdapter extends BaseAdapter {

    //멤버변수
    ArrayList<Member> members;
    LayoutInflater inflater;

    public MyAdapter(ArrayList<Member> members, LayoutInflater inflater) {
        this.members=members;
        this.inflater=inflater;
    }



    @Override
    public int getCount() {
        return members.size();
    }

    @Override
    public Object getItem(int position) {
        return members.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        if(view==null) {
            view = inflater.inflate(R.layout.listview_item, null);
        }


        Member member=members.get(position);

        TextView event=view.findViewById(R.id.item_event);
        TextView day=view.findViewById(R.id.item_day);
        TextView dday=view.findViewById(R.id.item_dday);

        event.setText(member.event);
        day.setText(member.day);
        dday.setText(member.dday);


        return view;
    }
}
