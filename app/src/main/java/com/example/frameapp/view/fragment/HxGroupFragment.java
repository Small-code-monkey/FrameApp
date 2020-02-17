package com.example.frameapp.view.fragment;

import android.os.Bundle;

import com.example.frameapp.R;
import com.example.frameapp.base.BaseFragment;
import com.example.frameapp.view.activity.HxImActivity;

/**
 * 环信功能-群组
 * 2020-02-17
 *
 * @author
 */
public class HxGroupFragment extends BaseFragment<HxImActivity> {

    public static HxGroupFragment newInstance() {
        Bundle args = new Bundle();
        HxGroupFragment fragment = new HxGroupFragment();
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
        return R.layout.fragment_hx_group;
    }

    /**
     * 初始化数据
     */
    @Override
    protected void initData() {

    }
}
