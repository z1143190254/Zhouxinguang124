package com.bwie.zhouxinguang124.base;
/*
 *@auther:周鑫光
 *@Date: 2019/12/4
 *@Time:8:58
 *@Description:${DESCRIPTION}
 * */

import com.bwie.zhouxinguang124.Contract;

import java.lang.ref.WeakReference;

public abstract class BasePresenter<V extends Contract.Iview> implements Contract.Presenter {
    protected WeakReference<V> weakReference;

    public BasePresenter() {
        inisModel();
    }

    protected abstract void inisModel();

    protected void onAttach(V iview) {
        weakReference = new WeakReference<>(iview);
    }

    protected void onDesAttach() {
        if (weakReference != null) {
            weakReference.clear();
            weakReference = null;
        }
    }

    protected V get() {
        return weakReference.get();
    }
}
