package com.example.frameapp.view.activity;

import android.os.Bundle;

import com.example.frameapp.R;
import com.example.frameapp.base.BaseActivity;
import com.example.frameapp.util.views.BaseViewPagerView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Tab框架
 * 2020-02-13
 *
 * @author
 */
public class TabActivity extends BaseActivity {

    @BindView(R.id.bv_pv_main)
    BaseViewPagerView bvPvMain;
    @BindView(R.id.bn_v_main)
    BottomNavigationView bnVMain;

    /**
     * 获取布局
     *
     * @return
     */
    @Override
    protected int getLayout() {
        return R.layout.activity_tab;
    }

    /**
     * 初始化数据
     */
    @Override
    protected void initData() {

    }
}
