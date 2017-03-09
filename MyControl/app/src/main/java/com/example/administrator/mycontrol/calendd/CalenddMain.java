package com.example.administrator.mycontrol.calendd;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.administrator.mycontrol.R;

/**
 * Created by phantom on 2017/3/6.
 */

public class CalenddMain extends AppCompatActivity {
    private ListView listView;
    private String[] items = new String[]{"GridCalendarView", "CircleCalendarView", "ADCircleCalendarView"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendd_main);
        listView = (ListView) findViewById(R.id.listView);
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                android.R.id.text1, items);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = null;
                switch (position) {
                    case 0:
                        intent = new Intent(CalenddMain.this, GridCalendarActivity.class);
                        break;
                    case 1:
                        intent = new Intent(CalenddMain.this, CircleCalendarActivity.class);
                        break;
                    case 2:
                        intent = new Intent(CalenddMain.this, ADCircleCalendarActivity.class);
                        break;
                    default:
                        break;
                }
                if (null != intent)
                    startActivity(intent);
            }
        });
    }
}
