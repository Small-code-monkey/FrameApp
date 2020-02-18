package com.example.frameapp.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.frameapp.action.TitleBarAction;
import com.hjq.bar.TitleBar;

import butterknife.ButterKnife;

/**
 * 基类Fragment
 * 2020-02-13
 *
 * @author
 */
public abstract class BaseFragment<A extends AbstractActivity> extends AbstractFragment<A> implements
        TitleBarAction {

    private TitleBar titleBar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    protected void initFragment() {
        assert getView() != null;
        if (getTitleBar() != null) {
            getTitleBar().setOnTitleBarListener(this);
        }
        super.initFragment();
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
            assert getView() != null;
            titleBar = findTitleBar((ViewGroup) getView());
        }
        return titleBar;
    }
}
