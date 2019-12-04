package com.bwie.zhouxinguang124.base;
/*
 *@auther:周鑫光
 *@Date: 2019/12/4
 *@Time:8:59
 *@Description:${DESCRIPTION}
 * */

import android.app.Application;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.bwie.zhouxinguang124.Contract;

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements Contract.Iview {
    protected P menter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (inisid() != 0) {
            setContentView(inisid());
            inisView();
            menter = inisPresenter();
            menter.onAttach(this);
        }
        startCoding();
    }

    protected abstract void startCoding();

    protected abstract P inisPresenter();

    protected abstract void inisView();

    protected abstract int inisid();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        menter.onDesAttach();
    }
}
