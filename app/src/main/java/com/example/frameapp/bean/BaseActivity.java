package com.example.frameapp.bean;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;

import com.example.frameapp.action.TitleBarAction;
import com.hjq.bar.TitleBar;

/**
 * 基类Activity
 * 2020-02-12
 *
 * @author
 */
public abstract class BaseActivity extends BasicActivity implements
        TitleBarAction {

    private TitleBar titleBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
}
