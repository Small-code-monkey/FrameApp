package com.example.frameapp.view.activity;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewpager.widget.ViewPager;

import com.example.frameapp.R;
import com.example.frameapp.adapter.GuidePagerAdapter;
import com.example.frameapp.bean.BaseActivity;
import com.rd.PageIndicatorView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 引导图
 * 2020-02-12
 *
 * @author
 */
public class GuideMapActivity extends BaseActivity {

    @BindView(R.id.vp_guide_pager)
    ViewPager vpGuidePager;
    @BindView(R.id.pv_guide_indicator)
    PageIndicatorView pvGuideIndicator;
    @BindView(R.id.iv_guide_complete)
    AppCompatImageView ivGuideComplete;

    private GuidePagerAdapter guidePagerAdapter;

    /**
     * 获取布局
     *
     * @return
     */
    @Override
    protected int setLayout() {
        return R.layout.activity_guide_map;
    }

    /**
     * 初始化数据
     */
    @Override
    protected void initData() {

    }
}
