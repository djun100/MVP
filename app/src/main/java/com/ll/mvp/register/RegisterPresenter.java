package com.ll.mvp.register;

import android.os.Handler;
import android.os.Looper;

import com.ll.mvp.base.BasePresenter;
import com.ll.mvp.biz.IUserBiz;
import com.ll.mvp.biz.UserBizIml;

/**
 * 注册presenter
 * Created by LiLei on 2017/7/3.Go.
 */
public class RegisterPresenter extends BasePresenter<RegisterView,IUserBiz> {
    private Handler handler;

    public RegisterPresenter() {
        handler = new Handler(Looper.getMainLooper());
    }

    @Override
    protected IUserBiz newModel() {
        return new UserBizIml();
    }

    //实际逻辑实现
    public void register() {

        mModel.register(getMvpView().getName(), getMvpView().getPassword(), new RegisterListener() {
            @Override
            public void RegisterSuccess() {
                //异步
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        getMvpView().RegisterSuccess();
                    }
                });
            }

            @Override
            public void RegisterFailed() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        getMvpView().RegisterFail();
                    }
                });
            }
        });
    }
}
