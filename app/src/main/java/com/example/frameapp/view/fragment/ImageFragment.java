package com.example.frameapp.view.fragment;

import android.os.Bundle;

import com.example.frameapp.MainActivity;
import com.example.frameapp.R;
import com.example.frameapp.base.BaseFragment;

/**
 * Tab 图片ImageFragment
 * 2020-02-14
 *
 * @author
 */
public class ImageFragment extends BaseFragment<MainActivity> {

    public static ImageFragment newInstance() {
        Bundle args = new Bundle();
        ImageFragment fragment = new ImageFragment();
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
        return R.layout.fragment_image;
    }

    /**
     * 初始化数据
     */
    @Override
    protected void initData() {

    }
}
