package com.example.administrator.mycontrol.dagger;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.mycontrol.R;
import com.example.administrator.mycontrol.dagger.injector.DaggerLoginComponent;
import com.example.administrator.mycontrol.dagger.injector.LoginModule;

import javax.inject.Inject;


public class LoginActivity extends BaseActivity<LoginPresenter, LoginModel> implements LoginContract.View {

    private Button btnLogin;
    private EditText edtAccount;
    private EditText edtPassword;
    private TextView tvForget;
    private String rsapublickey;
    private String random;
    private Boolean flag = false;
    private Boolean btnFlag = false;// 登录按钮锁
    private Boolean updateFlag = false; // 升级锁
    private Integer updatetype;// 是否升级
    private String updatedesc;// 版本内容
    private String updateurl;// 升级链接
    @Inject
    LoginPresenter loginPresenter;

    @Override
    protected void initInjector() {
        DaggerLoginComponent.builder()
                .loginModule(new LoginModule(this))
                .build()
                .inject(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void initPresenter() {
//        mPresenter.setVM(this,mModel);
    }

    @Override
    public void init() {
        btnLogin = (Button) findViewById(R.id.btn_login_login);
        edtAccount = (EditText) findViewById(R.id.edt_login_account);
        edtPassword = (EditText) findViewById(R.id.edt_login_password);
        tvForget = (TextView) findViewById(R.id.tv_forgetpassword);

        tvForget.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
//                Intent intent = new Intent(LoginActivity.this, ForgetPasswordActivity.class);
//                LoginActivity.this.startActivity(intent);
            }
        });
        btnLogin.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                mPresenter.login("123", "12312");
            }
        });
    }


    public void btnLogin() {
        String account = edtAccount.getText().toString();
        String password = edtPassword.getText().toString();
        if (account.equals("")) {
            Toast.makeText(LoginActivity.this, "请输入用户名", Toast.LENGTH_LONG);
            return;
        }
        if (password.equals("")) {
            Toast.makeText(LoginActivity.this, "请输入密码", Toast.LENGTH_SHORT);
            return;
        }
    }


    public void openBrowserForUpdate(Uri url) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(url);
        startActivity(intent);
    }

    @Override
    public void startLoading() {

    }

    @Override
    public void stopLoading() {

    }

    @Override
    public void showMeaasge(String msg) {

    }

    @Override
    public String getUserName() {
        return null;
    }

    @Override
    public String getPwd() {
        return null;
    }

    @Override
    public boolean checkNull() {
        return false;
    }
}