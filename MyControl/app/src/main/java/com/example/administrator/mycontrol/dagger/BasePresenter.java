package com.example.administrator.mycontrol.dagger;

import android.content.Context;


public abstract class BasePresenter<E extends BaseModel, T extends BaseView> {

    public Context mContext;
    public E mModel;
    public T mView;


    public void onDestroy() {
        mView = null;
        if (mModel != null) {
            mModel = null;
        }
    }

    protected void handleFailMsg(String error) {
        mView.stopLoading();
        mView.showMeaasge(error);
    }

}
