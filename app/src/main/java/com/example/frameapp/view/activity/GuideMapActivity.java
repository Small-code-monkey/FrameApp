package com.example.frameapp.view.activity;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewpager.widget.ViewPager;

import com.example.frameapp.R;
import com.example.frameapp.adapter.GuidePagerAdapter;
import com.example.frameapp.bean.BaseActivity;
import com.rd.PageIndicatorView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

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
    private List<String> urls;

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
        //图片路径
        urls = new ArrayList<>();
//        urls.add("https://raw.githubusercontent.com/WuJian1421/FrameApp/master/image/guide/bg_guide_1.webp");
//        urls.add("https://raw.githubusercontent.com/WuJian1421/FrameApp/master/image/guide/bg_guide_2.webp");
//        urls.add("https://raw.githubusercontent.com/WuJian1421/FrameApp/master/image/guide/bg_guide_3.webp");

        guidePagerAdapter = new GuidePagerAdapter(urls);
    }

    @OnClick(R.id.iv_guide_complete)
    public void onViewClicked() {

    }
}
