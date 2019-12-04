package com.bwie.zhouxinguang124.model;
/*
 *@auther:周鑫光
 *@Date: 2019/12/4
 *@Time:8:57
 *@Description:${DESCRIPTION}
 * */

import com.bwie.zhouxinguang124.Contract;
import com.bwie.zhouxinguang124.until.OkHttp;

public class IModel implements Contract.IModel {
    @Override
    public void onget(String url, final Contract.MycallBack mycallBack) {
        OkHttp.getInstance().onget(url, new OkHttp.MycallBack() {
            @Override
            public void onsuccess(String json) {
                mycallBack.onsuccess(json);
            }

            @Override
            public void onError(String error) {
                mycallBack.onError(error);
            }
        });
    }

    @Override
    public void onpost(String url, Contract.MycallBack mycallBack) {

    }
}
