package com.example.administrator.mycontrol.dagger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * 作者：yangxiaobo on 2016/11/29 15:06 邮箱：15869034922@163.com 描述:activity的基类
 */
public abstract class BaseActivity<T extends BasePresenter, E> extends FragmentActivity {


    @Inject
    public T mPresenter;
    public E mModel;
    public Context mContext;
    private int count = -1;
    protected String TAG = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        doBeforeSetcontentView();
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        mContext = this;
//        mPresenter = TUtil.getT(this, 0);
//        mModel = TUtil.getT(this, 1);
//        if (mPresenter != null) {
//            mPresenter.mContext = this;
//        }
        init();
        initInjector();
        initPresenter();

        TAG = getClass().getSimpleName();
    }

    /**
     * Dagger 注入
     */
    protected abstract void initInjector();

    /*********************
     * 子类实现
     *****************************/
    //获取布局文件
    public abstract int getLayoutId();

    //简单页面无需mvp就不用管此方法即可,完美兼容各种实际场景的变通
    public abstract void initPresenter();

    //初始化view
    protected abstract void init();

    public T getPresenter() {
        return mPresenter;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        ButterKnife.unbind(this);
        //避免mvp的内存泄漏
        if (mPresenter != null) {
            mPresenter.onDestroy();
            mPresenter = null;
        }
    }

    private void doBeforeSetcontentView() {
        // 把actvity放到application栈中管理
        // 无标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // 设置竖屏
        // setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
//        // 默认着色状态栏
//        SetStatusBarColor();
//        SetTranslanteBar();
    }


    /**
     * 通过Class跳转界面
     **/
    public void startActivity(Class<?> cls) {
        startActivity(cls, null);
    }

    /**
     * 含有Bundle通过Class跳转界面
     **/
    public void startActivityForResult(Class<?> cls, Bundle bundle,
                                       int requestCode) {
        Intent intent = new Intent();
        intent.setClass(this, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
    }

    /**
     * 含有Bundle通过Class跳转界面
     **/
    public void startActivity(Class<?> cls, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(this, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }


    /**
     * activity动画的设置
     */
    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
    }


    /**
     * activity动画的设置
     */


    /*@Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK
                && event.getRepeatCount() == 0) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }*/
    protected void setComponet() {
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {

            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public View getContentView() {
        ViewGroup view = (ViewGroup) getWindow().getDecorView();
        FrameLayout content = (FrameLayout) view.findViewById(android.R.id.content);
        return content;
//        return ((ViewGroup) findViewById(android.R.id.content)).getChildAt(0);
    }


}
