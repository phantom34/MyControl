package com.example.administrator.mycontrol;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.mycontrol.View.CircleView;
import com.example.administrator.mycontrol.View.WaveLoadingView;

public class MainActivity extends AppCompatActivity {

    WaveLoadingView asdasd;
    CircleView circleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dfghjk);
        asdasd = (WaveLoadingView) findViewById(R.id.asdasd);
        circleView = (CircleView) findViewById(R.id.asd);

    }
}
