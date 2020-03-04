package com.example.frameapp.view.fragment;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

import com.example.frameapp.MainActivity;
import com.example.frameapp.R;
import com.example.frameapp.adapter.BaseFragmentAdapter;
import com.example.frameapp.base.BaseFragment;
import com.example.frameapp.util.AppUtil;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import butterknife.BindView;

/**
 * Tab 首页 Fragment
 * 2020-02-13
 *
 * @author
 */
public class HomeFragment extends BaseFragment<MainActivity> implements BottomNavigationView.OnNavigationItemSelectedListener, ViewPager.OnPageChangeListener {

    @BindView(R.id.bv_pv_home_fragment)
    ViewPager bvPvHomeFragment;
    @BindView(R.id.bn_view_home_fragment)
    BottomNavigationViewEx bnViewHomeFragment;

    private BaseFragmentAdapter<BaseFragment> adapter;

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
        //使用增强版 BottomNavigationViewEx
        AppUtil.setNoIcon(bnViewHomeFragment).setOnNavigationItemSelectedListener(this);

        //ViewPager
        adapter = new BaseFragmentAdapter<>(this);
        adapter.addFragment(HomeSubClassFragment.newInstance(0));
        adapter.addFragment(HomeSubClassFragment.newInstance(1));
        bvPvHomeFragment.setAdapter(adapter);
        bvPvHomeFragment.setOnPageChangeListener(this);
    }

    /**
     * Called when an item in the bottom navigation menu is selected.
     *
     * @param item The selected item
     * @return true to display the item as the selected item and false if the item should not be
     * selected. Consider setting non-selectable items as disabled preemptively to make them
     * appear non-interactive.
     */
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_home_one_fragment:
                adapter.setCurrentItem(0);
                return true;
            case R.id.menu_home_two_fragment:
                adapter.setCurrentItem(1);
                return true;
            default:
                break;
        }
        return false;
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

    }

    /**
     * This method will be invoked when a new page becomes selected. Animation is not
     * necessarily complete.
     *
     * @param position Position index of the new selected page.
     */
    @Override
    public void onPageSelected(int position) {
        switch (position) {
            case 0:
                bnViewHomeFragment.setSelectedItemId(R.id.menu_home_one_fragment);
                break;
            case 1:
                bnViewHomeFragment.setSelectedItemId(R.id.menu_home_two_fragment);
                break;
            default:
                break;
        }
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

    }
}
