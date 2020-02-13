package com.example.frameapp.bean;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import com.example.frameapp.action.TitleBarAction;
import com.hjq.bar.TitleBar;

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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        initLayout();
    }

    protected void initLayout() {
        setContentView(setLayout());
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
    protected abstract int setLayout();

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
}
