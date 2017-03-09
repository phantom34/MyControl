package com.example.administrator.mycontrol.dagger;

/**
 * Created by CJ on 2016/12/2.
 */

public interface LoginContract {

    interface View extends BaseView {

        String getUserName();

        String getPwd();

        boolean checkNull();

    }

    abstract static class Presenter extends BasePresenter<Model, View> {

        public abstract void login(String account, String password);

    }

    interface Model extends BaseModel {

    }
}
