package com.example.frameapp.view.activity;

import android.view.MenuItem;

import androidx.annotation.NonNull;

import com.example.frameapp.R;
import com.example.frameapp.adapter.BaseFragmentAdapter;
import com.example.frameapp.base.BaseActivity;
import com.example.frameapp.base.BaseFragment;
import com.example.frameapp.util.views.BaseViewPagerView;
import com.example.frameapp.view.fragment.HomeFragment;
import com.example.frameapp.view.fragment.ImageFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import butterknife.BindView;

/**
 * Tab框架
 * 2020-02-13
 *
 * @author
 */
public class TabActivity extends BaseActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.bv_pv_tab)
    BaseViewPagerView bvPvTab;
    @BindView(R.id.bn_view_tab)
    BottomNavigationView bnViewTab;

    private BaseFragmentAdapter<BaseFragment> adapter;

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
        //ViewPager
        adapter = new BaseFragmentAdapter<>(this);
        adapter.addFragment(HomeFragment.newInstance());
        adapter.addFragment(ImageFragment.newInstance());
        bvPvTab.setAdapter(adapter);

        //NavigationView
        bnViewTab.setOnNavigationItemSelectedListener(this);
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
            case R.id.menu_home:
                adapter.setCurrentItem(HomeFragment.class);
                return true;
            case R.id.menu_image:
                adapter.setCurrentItem(ImageFragment.class);
                return true;
            default:
                break;
        }
        return false;
    }
}
