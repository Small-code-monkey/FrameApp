package com.example.frameapp.base;

import android.app.Application;

import com.hjq.toast.ToastUtils;

/**
 * 基类Application
 * 2020-02-12
 *
 * @author
 */
public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化Toast
        ToastUtils.init(this);
    }
}
