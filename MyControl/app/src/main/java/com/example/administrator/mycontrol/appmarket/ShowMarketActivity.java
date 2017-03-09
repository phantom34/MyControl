package com.example.administrator.mycontrol.appmarket;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.mycontrol.R;

import java.util.ArrayList;

/**
 * Created by phantom on 2017/3/1.
 */

public class ShowMarketActivity extends AppCompatActivity{
    private Button btnGetAppStoreList1;
    private TextView tvAppList1;
    ArrayList<String> pkgsAppList1 = new ArrayList<String>();

    private Button btnGetAppStoreList;
    private TextView tvAppList;
    ArrayList<String> pkgsAppList = new ArrayList<String>();

    private Button btnScore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_market);

        btnScore = (Button) findViewById(R.id.btn_score);
        btnScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ScoreUtils.launchAppDetail("com.wqdl.dqxt","",ShowMarketActivity.this);
            }
        });

        tvAppList = (TextView) findViewById(R.id.tv_app_list);
        btnGetAppStoreList = (Button) findViewById(R.id.btn_get_app_store);
        btnGetAppStoreList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pkgsAppList = ScoreUtils.getInstallAppMarkets(ShowMarketActivity.this);
                String str = "";
                for(int i = 0;i < pkgsAppList.size();i++){
                    str += pkgsAppList.get(i)+"\n";
                }
                tvAppList.setText(str);
            }
        });

        tvAppList1 = (TextView) findViewById(R.id.tv_app_list_1);
        btnGetAppStoreList1 = (Button) findViewById(R.id.btn_get_app_store_1);
        btnGetAppStoreList1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pkgsAppList1 = ScoreUtils.InstalledAPPs(ShowMarketActivity.this);
                String str = "";
                for(int i = 0;i < pkgsAppList1.size();i++){
                    str += pkgsAppList1.get(i)+"\n";
                }
                tvAppList1.setText(str);
            }
        });
    }
}
