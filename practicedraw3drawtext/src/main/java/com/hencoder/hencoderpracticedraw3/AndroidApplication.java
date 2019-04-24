package com.hencoder.hencoderpracticedraw3;

import android.app.Application;

/**
 * Created by huangyong on 2018/11/30
 */
public class AndroidApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        //应用程序异常崩溃处理
        CrashHandler.getInstance().init(this);
    }
}
