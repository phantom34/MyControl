package com.example.administrator.mycontrol.animation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.administrator.mycontrol.R;

/**
 * Created by phantom on 2017/3/1.
 */

public class AnimationShowActivity extends AppCompatActivity {


    TextView tvShow;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showanimation);
        init();
    }

    private void init() {
        tvShow = (TextView) findViewById(R.id.tv_show);
        startScaleBreathAnimation();
    }

    private void startAlphaBreathAnimation() {
        ObjectAnimator alphaAnimator = ObjectAnimator.ofFloat(tvShow, "alpha", 0f, 1f);
        alphaAnimator.setDuration(4000);
        alphaAnimator.setInterpolator(new BreatheInterpolator());//设置插值
        alphaAnimator.setRepeatCount(ValueAnimator.INFINITE);//设置次数
        alphaAnimator.start();
    }

    private void startScaleBreathAnimation() {
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(tvShow, "scaleX", 0.4f, 1f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(tvShow, "scaleY", 0.4f, 1f);
        ObjectAnimator alphaAnimator = ObjectAnimator.ofFloat(tvShow, "alpha", 0f, 1f);
        scaleX.setRepeatCount(ValueAnimator.INFINITE);
        scaleY.setRepeatCount(ValueAnimator.INFINITE);
        alphaAnimator.setRepeatCount(ValueAnimator.INFINITE);
        alphaAnimator.setDuration(1000);
        scaleX.setDuration(6000);
//        alphaAnimator.setRepeatMode(ValueAnimator.REVERSE);
        AnimatorSet mAnimatorSet = new AnimatorSet();
        mAnimatorSet.playTogether(scaleX,scaleY,alphaAnimator);
//        mAnimatorSet.setDuration(1000);
        mAnimatorSet.setInterpolator(new BreatheInterpolator());
        mAnimatorSet.start();
    }
}
