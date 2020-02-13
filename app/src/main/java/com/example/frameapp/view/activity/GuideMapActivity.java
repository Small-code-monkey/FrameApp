package com.example.frameapp.view.activity;

import android.view.View;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewpager.widget.ViewPager;

import com.example.frameapp.MainActivity;
import com.example.frameapp.R;
import com.example.frameapp.adapter.GuidePagerAdapter;
import com.example.frameapp.base.BaseActivity;
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
public class GuideMapActivity extends BaseActivity implements ViewPager.OnPageChangeListener {

    @BindView(R.id.vp_guide)
    ViewPager vpGuide;
    @BindView(R.id.iv_guide)
    AppCompatImageView ivGuide;
    @BindView(R.id.pv_guide)
    PageIndicatorView pvGuide;

    private GuidePagerAdapter guidePagerAdapter;

    /**
     * 获取布局
     *
     * @return
     */
    @Override
    protected int getLayout() {
        return R.layout.activity_guide_map;
    }

    /**
     * 初始化数据
     */
    @Override
    protected void initData() {
        //指示器绑定
        pvGuide.setViewPager(vpGuide);

        //图片路径
        List<String> urls = new ArrayList<>();
        urls.add("http://img.nicebing.com/OHR.Lanternfestival2020_ZH-CN9333703076_1920x1080.jpg");
        urls.add("http://img.nicebing.com/OHR.LionRock_ZH-CN1466577021_1920x1080.jpg");
        urls.add("http://img.nicebing.com/OHR.BrightonJetty_ZH-CN1526526038_1920x1080.jpg");
        guidePagerAdapter = new GuidePagerAdapter(urls);

        //ViewPager
        vpGuide.setAdapter(guidePagerAdapter);
        vpGuide.setOnPageChangeListener(this);
    }

    @OnClick(R.id.iv_guide)
    public void onViewClicked() {
        startActivity(MainActivity.class);
        finish();
    }

    /**
     * This method will be invoked when the current page is scrolled, either as part
     * of a programmatically initiated smooth scroll or a user initiated touch scroll.
     *
     * @param position             Position index of the first page currently being displayed.
     *                             Page position+1 will be visible if positionOffset is nonzero.
     * @param positionOffset       Value from [0, 1) indicating the offset from the page at position.
     * @param positionOffsetPixels Value in pixels indicating the offset from position.
     */
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        if (vpGuide.getCurrentItem() == guidePagerAdapter.getCount() - 1 && positionOffsetPixels > 0) {
            ivGuide.setVisibility(View.INVISIBLE);
        }
    }

    /**
     * This method will be invoked when a new page becomes selected. Animation is not
     * necessarily complete.
     *
     * @param position Position index of the new selected page.
     */
    @Override
    public void onPageSelected(int position) {

    }

    /**
     * Called when the scroll state changes. Useful for discovering when the user
     * begins dragging, when the pager is automatically settling to the current page,
     * or when it is fully stopped/idle.
     *
     * @param state The new scroll state.
     * @see ViewPager#SCROLL_STATE_IDLE
     * @see ViewPager#SCROLL_STATE_DRAGGING
     * @see ViewPager#SCROLL_STATE_SETTLING
     */
    @Override
    public void onPageScrollStateChanged(int state) {
        if (state == ViewPager.SCROLL_STATE_IDLE) {
            ivGuide.setVisibility(vpGuide.getCurrentItem() == guidePagerAdapter.getCount() - 1 ?
                    View.VISIBLE : View.INVISIBLE);
        }
    }
}
