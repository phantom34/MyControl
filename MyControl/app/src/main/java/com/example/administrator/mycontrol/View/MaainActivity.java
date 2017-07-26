package com.example.administrator.mycontrol.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.administrator.mycontrol.R;
import com.example.administrator.mycontrol.weight.CustomPopWindow;

/**
 * Created by phantom on 2017/7/13.
 */

public class MaainActivity extends AppCompatActivity {

    XxxxView xxx;
    Button button;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maain);
        xxx = (XxxxView) findViewById(R.id.xxx);
        xxx.setOnClickListener(v-> showPop());
        button= (Button) findViewById(R.id.asdasdasdasd);
        button.setOnClickListener(v -> showPop());
    }

    public void showPop() {

        new CustomPopWindow.Builder()
                .setContext(this)
                .setContentviewid(R.layout.dfghjk)
                .setWidth(LinearLayout.LayoutParams.WRAP_CONTENT)
                .setHeight(LinearLayout.LayoutParams.WRAP_CONTENT)
                .setOutsidecancer(true)
                .builder()
                .showAtlocation(xxx, Gravity.CENTER, 1, 1);
    }
}
