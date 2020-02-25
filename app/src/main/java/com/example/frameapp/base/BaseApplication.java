package com.example.frameapp.base;

import android.app.ActivityManager;
import android.app.Application;
import android.content.pm.PackageManager;
import android.util.Log;

import com.example.frameapp.R;
import com.hjq.toast.ToastUtils;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMOptions;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.mmkv.MMKV;

import java.util.Iterator;
import java.util.List;

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
        //初始化TenChet Bugly
        CrashReport.initCrashReport(getApplicationContext(), "a59db56776", false);
        //初始化Toast
        ToastUtils.init(this);
        //初始化TenCentMMKV 配置数据存储地址
        MMKV.initialize(this);
        //优化环信
        int pid = android.os.Process.myPid();
        String processAppName = getAppName(pid);
        // 如果APP启用了远程的service，此application:onCreate会被调用2次
        // 为了防止环信SDK被初始化2次，加此判断会保证SDK被初始化1次
        // 默认的APP会在以包名为默认的process name下运行，如果查到的process name不是APP的process name就立即返回
        if (processAppName == null || !processAppName.equalsIgnoreCase(this.getPackageName())) {
            Log.e("--->", "enter the service process!");
            // 则此application::onCreate 是被service 调用的，直接返回
            return;
        }
        //初始化环信
        EMOptions options = new EMOptions();
        //添加好友 false：无需认证 true：需要认证
        options.setAcceptInvitationAlways(true);
        EMClient.getInstance().init(getApplicationContext(), options);
    }

    private String getAppName(int pid) {
        String processName = null;
        ActivityManager am = (ActivityManager) this.getSystemService(ACTIVITY_SERVICE);
        assert am != null;
        List l = am.getRunningAppProcesses();
        Iterator i = l.iterator();
        PackageManager pm = this.getPackageManager();
        while (i.hasNext()) {
            ActivityManager.RunningAppProcessInfo info = (ActivityManager.RunningAppProcessInfo) (i.next());
            try {
                if (info.pid == pid) {
                    processName = info.processName;
                    return processName;
                }
            } catch (Exception ignored) {

            }
        }
        return processName;
    }
}
