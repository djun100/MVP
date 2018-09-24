package com.ll.mvp.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ll.mvp.utils.UtilType;


/**
 * view
 * presenter
 * Created by LiLei on 2017/7/3.Go.
 */
public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity {
    public T presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = UtilType.getTypeInstance(this,1);
        if (presenter!=null) {
            presenter.attach(BaseActivity.this, this);
        }

    }


    @Override
    protected void onDestroy() {
        if (presenter!=null) {
            presenter.detach();
        }
        super.onDestroy();
    }

}
