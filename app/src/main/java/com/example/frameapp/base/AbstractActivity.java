package com.example.frameapp.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import android.view.Window;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import com.example.frameapp.view.dialog.WaitDialog;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 基础Activity
 * 2020-02-12
 *
 * @author
 */
public abstract class AbstractActivity extends AppCompatActivity {

    public Context context;
    private Unbinder unbinder;
    private WaitDialog waitDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        initLayout();
    }

    protected void initLayout() {
        setContentView(getLayout());
        unbinder = ButterKnife.bind(this);
        initData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    /**
     * 获取布局
     *
     * @return
     */
    protected abstract int getLayout();

    /**
     * 初始化数据
     */
    protected abstract void initData();

    public ViewGroup getContentView() {
        return findViewById(Window.ID_ANDROID_CONTENT);
    }

    /**
     * startActivity 方法简化
     *
     * @param clazz class类
     */
    public void startActivity(Class<? extends Activity> clazz) {
        startActivity(new Intent(this, clazz));
    }

    /**
     * 显示加载中(默认)
     */
    public void showLoading() {
        showLoading("加载中...");
    }

    /**
     * 显示加载中
     *
     * @param id id资源
     */
    public void showLoading(@StringRes int id) {
        showLoading(getString(id));
    }

    /**
     * 显示加载中
     *
     * @param text 填写
     */
    public void showLoading(String text) {
        if (waitDialog == null) {
            waitDialog = new WaitDialog.Builder(context)
                    .setMessage(text).create();
        }
        if (!waitDialog.isShowing()) {
            waitDialog.show();
        }
    }

    /**
     * 显示加载完成
     */
    public void showComplete() {
        if (waitDialog != null && waitDialog.isShowing()) {
            waitDialog.dismiss();
        }
    }
}
