package com.example.administrator.mycontrol.dagger.injector;

import com.example.administrator.mycontrol.dagger.LoginActivity;
import com.example.administrator.mycontrol.dagger.LoginPresenter;
import com.example.administrator.mycontrol.dagger.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by phantom on 2017/3/8.
 */
@Module
public class LoginModule {
    private final LoginActivity mView;

    public LoginModule(LoginActivity mView) {
        this.mView = mView;
    }


    @PerActivity
    @Provides
    public LoginPresenter provideLoginPresenter() {
        return new LoginPresenter(mView);
    }
}
