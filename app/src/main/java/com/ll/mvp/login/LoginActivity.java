package com.ll.mvp.login;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ll.mvp.R;
import com.ll.mvp.base.BaseActivity;
import com.ll.mvp.bean.User;

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginView {
    private EditText name_et, password_et;
    private String name, password;
    private Button login_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();
    }

    private void init() {
        name_et = (EditText) findViewById(R.id.et_name);
        password_et = (EditText) findViewById(R.id.et_password);
        login_btn = (Button) findViewById(R.id.btn_login);
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = name_et.getText().toString().trim();
                password = password_et.getText().toString().trim();
                presenter.login();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

    }


    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }


    @Override
    public void toMainActivity(User user) {
        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
      /*  final AlertDialog.Builder normalDialog = new AlertDialog.Builder(LoginActivity.this);
        normalDialog.setTitle("我是一个普通Dialog");
        normalDialog.setMessage("你要点击哪一个按钮呢?");
        normalDialog.setPositiveButton("确定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //...To-do
                    }
                });
        normalDialog.setNegativeButton("关闭",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //...To-do
                    }
                });
        // 显示
        normalDialog.show();*/
    }

    @Override
    public void showFailedError() {
        Toast.makeText(this, "登录失败", Toast.LENGTH_SHORT).show();
    }
}
