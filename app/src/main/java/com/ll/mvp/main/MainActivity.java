package com.ll.mvp.main;

import android.os.Bundle;
import android.widget.Toast;

import com.ll.mvp.R;
import com.ll.mvp.base.BaseActivity;
import com.ll.mvp.register.RegisterPresenter;
import com.ll.mvp.register.RegisterView;

public class MainActivity extends BaseActivity<RegisterPresenter> implements RegisterView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

       /* presenter.register();*/
    }


    @Override
    public String getName() {
        return "name";
    }

    @Override
    public String getPassword() {
        return "password";
    }

    @Override
    public void RegisterSuccess() {
        Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void RegisterFail() {
        Toast.makeText(this, "注册失败", Toast.LENGTH_SHORT).show();
    }
}
