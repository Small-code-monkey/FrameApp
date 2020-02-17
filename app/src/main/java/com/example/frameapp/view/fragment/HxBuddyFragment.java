package com.example.frameapp.view.fragment;

import android.os.Bundle;

import com.example.frameapp.R;
import com.example.frameapp.base.BaseFragment;
import com.example.frameapp.view.activity.HxImActivity;

/**
 * 环信功能-好友
 * 2020-02-17
 *
 * @author
 */
public class HxBuddyFragment extends BaseFragment<HxImActivity> {

    public static HxBuddyFragment newInstance() {
        Bundle args = new Bundle();
        HxBuddyFragment fragment = new HxBuddyFragment();
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
        return R.layout.fragment_hx_buddy;
    }

    /**
     * 初始化数据
     */
    @Override
    protected void initData() {

    }
}
