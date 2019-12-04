package com.bwie.zhouxinguang124.presenter;
/*
 *@auther:周鑫光
 *@Date: 2019/12/4
 *@Time:8:57
 *@Description:${DESCRIPTION}
 * */

import com.bwie.zhouxinguang124.Contract;
import com.bwie.zhouxinguang124.base.BasePresenter;
import com.bwie.zhouxinguang124.model.IModel;

public class Presenter extends BasePresenter {

    private Contract.IModel iModel;

    @Override
    protected void inisModel() {
        iModel = new IModel();
    }

    @Override
    public void onstart(String url) {
        iModel.onget(url, new Contract.MycallBack() {
            @Override
            public void onsuccess(String json) {
                get().onsuccess(json);
            }

            @Override
            public void onError(String error) {
                get().onError(error);
            }
        });
    }
}
