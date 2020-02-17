package com.example.frameapp.view.activity;

import com.example.frameapp.R;
import com.example.frameapp.adapter.BannerCarouseAdapter;
import com.example.frameapp.base.BaseActivity;
import com.hjq.bar.TitleBar;
import com.youth.banner.Banner;
import com.youth.banner.indicator.CircleIndicator;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 轮播图
 * 2020-02-12
 *
 * @author
 */
public class CarouselActivity extends BaseActivity {

    @BindView(R.id.banner_carouse)
    Banner bannerCarouse;

    /**
     * 获取布局
     *
     * @return
     */
    @Override
    protected int getLayout() {
        return R.layout.activity_carousel;
    }

    /**
     * 初始化数据
     */
    @Override
    protected void initData() {
        //图片路径
        List<String> urls = new ArrayList<>();
        urls.add("http://img.nicebing.com/OHR.Lanternfestival2020_ZH-CN9333703076_1920x1080.jpg");
        urls.add("http://img.nicebing.com/OHR.LionRock_ZH-CN1466577021_1920x1080.jpg");
        urls.add("http://img.nicebing.com/OHR.BrightonJetty_ZH-CN1526526038_1920x1080.jpg");
        bannerCarouse.setAdapter(new BannerCarouseAdapter(urls, context));
        bannerCarouse.setIndicator(new CircleIndicator(this));
        bannerCarouse.setDelayTime(3000);
        bannerCarouse.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        bannerCarouse.stop();
    }
}
