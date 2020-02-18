package com.example.frameapp.base;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;

import com.example.frameapp.action.TitleBarAction;
import com.example.frameapp.view.dialog.WaitDialog;
import com.hjq.bar.TitleBar;

import butterknife.ButterKnife;

/**
 * 基类Activity
 * 2020-02-12
 *
 * @author
 */
public abstract class BaseActivity extends AbstractActivity implements
        TitleBarAction {

    private TitleBar titleBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * 获取标题栏 id
     */
    protected int getTitleId() {
        return 0;
    }

    @Override
    protected void initLayout() {
        super.initLayout();
        //TitleBar点击事件
        if (getTitleBar() != null) {
            getTitleBar().setOnTitleBarListener(this);
        }
        if (getTitleId() > 0) {
            // 勤快模式
            View view = findViewById(getTitleId());
            if (view instanceof TitleBar) {
                titleBar = (TitleBar) view;
            }
        } else if (getTitleId() == 0) {
            // 懒人模式
            titleBar = findTitleBar(getContentView());
        }
        ButterKnife.bind(this);
    }

    /**
     * 设置标题栏的标题
     */
    @Override
    public void setTitle(@StringRes int id) {
        setTitle(getString(id));
    }

    /**
     * 设置标题栏的标题
     */
    @Override
    public void setTitle(CharSequence title) {
        super.setTitle(title);
        if (titleBar != null) {
            titleBar.setTitle(title);
        }
    }

    /**
     * 获取标题栏
     *
     * @return
     */
    @Override
    @Nullable
    public TitleBar getTitleBar() {
        if (titleBar == null) {
            titleBar = findTitleBar(getContentView());
        }
        return titleBar;
    }

    /**
     * 左图标点击事件
     *
     * @param v 被点击的左项View
     */
    @Override
    public void onLeftClick(View v) {
        onBackPressed();
    }
}
