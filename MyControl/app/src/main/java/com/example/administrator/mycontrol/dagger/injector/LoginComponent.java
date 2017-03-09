package com.example.administrator.mycontrol.dagger.injector;


import com.example.administrator.mycontrol.dagger.LoginActivity;
import com.example.administrator.mycontrol.dagger.PerActivity;

import dagger.Component;

/**
 * Created by phantom on 2017/3/8.
 */
@PerActivity
@Component(modules = LoginModule.class)
public interface LoginComponent {

    void inject(LoginActivity activity);
//    LoginPresenter presenter();
}
