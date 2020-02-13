package com.example.frameapp.view.fragment;

import android.os.Bundle;

import com.example.frameapp.MainActivity;
import com.example.frameapp.R;
import com.example.frameapp.base.BaseFragment;

/**
 * Tab 首页Fragment
 * 2020-02-13
 *
 * @author
 */
public class HomeFragment extends BaseFragment<MainActivity> {

    public static HomeFragment newInstance() {
        Bundle args = new Bundle();
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * 获取布局
     *
     * @return
     */
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    /**
     * 初始化数据
     */
    @Override
    protected void initData() {

    }
}
