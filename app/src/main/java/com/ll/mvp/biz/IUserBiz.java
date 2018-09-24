package com.ll.mvp.biz;

import com.ll.mvp.login.LoginListener;
import com.ll.mvp.register.RegisterListener;

/**
 * 请求类接口
 * Created by LiLei on 2017/7/3.Go.
 */
public interface IUserBiz {
    void login(String name, String password, LoginListener listener);

    void register(String name, String password, RegisterListener listener);
}
