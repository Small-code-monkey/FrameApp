package com.example.frameapp.base;

import android.app.Application;

import com.example.frameapp.R;
import com.hjq.toast.ToastUtils;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMOptions;
import com.tencent.mmkv.MMKV;

/**
 * 基类Application
 * 2020-02-12
 *
 * @author
 */
public class BaseApplication extends Application {

    public static int[] urlInt = {R.mipmap.bg_guide_1, R.mipmap.bg_guide_2, R.mipmap.bg_guide_3};

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化Toast
        ToastUtils.init(this);
        //初始化TenCentMMKV 配置数据存储地址
        MMKV.initialize(this);
        //初始化环信
        EMOptions options = new EMOptions();
        //添加好友无需认证
        options.setAcceptInvitationAlways(false);
        EMClient.getInstance().init(getApplicationContext(), options);
    }
}
