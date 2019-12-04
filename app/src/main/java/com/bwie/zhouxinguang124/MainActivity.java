package com.bwie.zhouxinguang124;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bwie.zhouxinguang124.adapter.MyBase;
import com.bwie.zhouxinguang124.base.BaseActivity;
import com.bwie.zhouxinguang124.base.BasePresenter;
import com.bwie.zhouxinguang124.bean.Studentbean;
import com.bwie.zhouxinguang124.presenter.Presenter;
import com.google.gson.Gson;
import com.stx.xhb.xbanner.XBanner;

import java.util.List;

public class MainActivity extends BaseActivity {

    private RecyclerView recy;
    String url = "http://172.17.8.100/small/commodity/v1/bannerShow";

    @Override
    protected void startCoding() {
        menter.onstart(url);
    }

    @Override
    protected BasePresenter inisPresenter() {
        return new Presenter();
    }

    @Override
    protected void inisView() {
        recy = (RecyclerView) findViewById(R.id.recy);
        recy.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected int inisid() {
        return R.layout.activity_main;
    }

    @Override
    public void onsuccess(String json) {
        Studentbean studentbean = new Gson().fromJson(json, Studentbean.class);
        List<Studentbean.ResultBean> result = studentbean.getResult();
        MyBase myBase = new MyBase(this, result);
        recy.setAdapter(myBase);
    }

    @Override
    public void onError(String error) {

    }
}
