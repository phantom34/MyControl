package com.example.administrator.mycontrol.dagger;

import android.widget.Toast;

/**
 * Created by CJ on 2016/12/2.
 */

public class LoginPresenter extends LoginContract.Presenter {

    private final LoginActivity mView;

    public LoginPresenter(LoginActivity view) {
        mView = view;
    }

    @Override
    public void login(final String account, final String password) {
        Toast.makeText(mView,"Asdasdasdasdasd",Toast.LENGTH_SHORT).show();
        mView.startLoading();
    }
}
