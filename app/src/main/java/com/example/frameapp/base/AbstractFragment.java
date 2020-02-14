package com.example.frameapp.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * 基类Fragment
 * 2020-02-12
 *
 * @author
 */
public abstract class AbstractFragment<A extends AbstractActivity> extends Fragment {

    public Context context;

    /**
     * 是否进行过懒加载
     */
    private boolean isLazyLoad;
    /**
     * 根布局
     */
    private View view;
    /**
     * Activity对象
     */
    private A activity;

    /**
     * 是否初始化过
     */
    private boolean mInitialize;

    @SuppressWarnings("unchecked")
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        activity = (A) requireActivity();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (!mInitialize) {
            mInitialize = true;
            initFragment();
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context = getActivity();
        if (view == null && getLayoutId() > 0) {
            view = inflater.inflate(getLayoutId(), null);
        }
        ViewGroup parent = (ViewGroup) view.getParent();
        if (parent != null) {
            parent.removeView(view);
        }
        return view;
    }

    @Nullable
    @Override
    public View getView() {
        return view;
    }

    /**
     * 获取绑定的 activity
     */
    public A getAttachActivity() {
        return activity;
    }

    /**
     * 初始化懒加载
     */
    private void initLayout() {
        if (!isLazyLoad) {
            isLazyLoad = true;
            initFragment();
        }
    }

    /**
     * 初始化Fragment
     */
    protected void initFragment() {
        initData();
    }

    /**
     * 是否进行了懒加载
     */
    protected boolean isLazyLoad() {
        return isLazyLoad;
    }

    /**
     * 获取布局
     *
     * @return
     */
    protected abstract int getLayoutId();

    /**
     * 初始化数据
     */
    protected abstract void initData();
}
