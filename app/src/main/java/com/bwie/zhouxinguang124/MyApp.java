package com.bwie.zhouxinguang124;
/*
 *@auther:周鑫光
 *@Date: 2019/12/4
 *@Time:8:45
 *@Description:${DESCRIPTION}
 * */

import android.app.Application;
import android.content.Context;

public class MyApp extends Application {
    public static Context context;
    public static DaoSession mdaoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        inisDataBase();
    }

    private void inisDataBase() {
        DaoMaster.OpenHelper openHelper = new DaoMaster.DevOpenHelper(this, "12.4.db");
        DaoMaster daoMaster = new DaoMaster(openHelper.getWritableDb());
        mdaoSession = daoMaster.newSession();
    }

    public static DaoSession daoSession() {
        return mdaoSession;
    }
}
