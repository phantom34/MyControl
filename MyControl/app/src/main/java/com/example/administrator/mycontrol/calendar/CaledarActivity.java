package com.example.administrator.mycontrol.calendar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.mycontrol.R;

import java.util.Date;

/**
 * Created by phantom on 2017/3/1.
 */

public class CaledarActivity extends AppCompatActivity {

    CalendarDateView calendarDateView;
    TextView tvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar);
        init();
    }

    private void init() {
        tvTitle= (TextView) findViewById(R.id.title);
        calendarDateView = (CalendarDateView) findViewById(R.id.calendarDateView);
        calendarDateView.invalidate();
        calendarDateView.setAdapter(new CaledarAdapter() {
            @Override
            public View getView(View convertView, ViewGroup parentView, CalendarBean bean) {
                //判断convertView为null，可以有效利用view的回收重用，左右滑动的效率高
                if (convertView == null) {
                    convertView = LayoutInflater.from(parentView.getContext()).inflate(R.layout.cbk_list_item_calendar, null);
                }

                TextView chinaText = (TextView) convertView.findViewById(R.id.chinaDateTv);
                TextView text = (TextView) convertView.findViewById(R.id.dateTv);

                text.setText("" + bean.day);
                //mothFlag 0是当月，-1是月前，1是月后
                if (bean.mothFlag != 0) {
                    text.setTextColor(0xff9299a1);
                } else {
                    text.setTextColor(0xff444444);
                }
                chinaText.setText(bean.chinaDay);

                return convertView;
            }
        });
        int[] data = CalendarUtil.getYMD(new Date());
        tvTitle.setText(data[0] + "/" + data[1] + "/" + data[2]);
        calendarDateView.setOnItemClickListener(new CalendarView.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int postion, CalendarBean bean) {
                tvTitle.setText(bean.year + "/" + bean.moth + "/" + bean.day);
            }
        });
    }

}
