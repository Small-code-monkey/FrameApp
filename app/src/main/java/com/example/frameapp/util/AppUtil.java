package com.example.frameapp.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;

/**
 * 工具类
 * 2020-02-12
 *
 * @author
 */
public class AppUtil {

    /**
     * 网络是否已连接
     *
     * @return true:已连接 false:未连接
     */
    @SuppressLint("MissingPermission")
    public static boolean iConnected(@NonNull Context context) {
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (manager != null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                NetworkCapabilities networkCapabilities = manager.getNetworkCapabilities(manager.getActiveNetwork());
                if (networkCapabilities != null) {
                    return networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
                            || networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)
                            || networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET);
                }
            } else {
                NetworkInfo networkInfo = manager.getActiveNetworkInfo();
                return networkInfo != null && networkInfo.isConnected();
            }
        }
        return false;
    }

    /**
     * 设置Dialog
     *
     * @param window
     */
    public static void setWindow(Window window) {
        if (window != null) {
            WindowManager.LayoutParams params = window.getAttributes();
            params.width = ViewGroup.LayoutParams.WRAP_CONTENT;
            params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
            params.gravity = Gravity.CENTER;
            params.windowAnimations = 0;
            window.setAttributes(params);
            window.setWindowAnimations(android.R.style.Animation_Toast);
            window.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
            window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
    }
}
