package com.example.frameapp.view.activity;

import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;

import androidx.annotation.NonNull;

import com.example.frameapp.R;
import com.example.frameapp.adapter.BaseFragmentAdapter;
import com.example.frameapp.base.BaseActivity;
import com.example.frameapp.base.BaseFragment;
import com.example.frameapp.util.views.BaseViewPagerView;
import com.example.frameapp.view.fragment.HxBuddyFragment;
import com.example.frameapp.view.fragment.HxGroupFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.hyphenate.EMCallBack;
import com.hyphenate.EMConferenceListener;
import com.hyphenate.chat.EMClient;

import butterknife.BindView;

/**
 * 环信Im
 * 2020-02-16
 *
 * @author
 */
public class HxImActivity extends BaseActivity implements
        BottomNavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.bv_pv_hx_im)
    BaseViewPagerView bvPvHxIm;
    @BindView(R.id.bn_view_hx_im)
    BottomNavigationView bnViewHxIm;

    private BaseFragmentAdapter<BaseFragment> adapter;

    /**
     * 获取布局
     *
     * @return
     */
    @Override
    protected int getLayout() {
        return R.layout.activity_hx_im;
    }

    /**
     * 初始化数据
     */
    @Override
    protected void initData() {
        adapter = new BaseFragmentAdapter<>(this);
        adapter.addFragment(HxBuddyFragment.newInstance());
        adapter.addFragment(HxGroupFragment.newInstance());
        bvPvHxIm.setAdapter(adapter);

        bnViewHxIm.setOnNavigationItemSelectedListener(this);
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
            case R.id.menu_buddy:
                adapter.setCurrentItem(0);
                return true;
            case R.id.menu_group:
                adapter.setCurrentItem(1);
                return true;
            default:
                break;
        }
        return false;
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        //退出账号
//        EMClient.getInstance().logout(true);
        EMClient.getInstance().logout(true, new EMCallBack() {
            @Override
            public void onSuccess() {
                Log.d("TAG", "----->" + "退出环信账号成功");
            }

            @Override
            public void onError(int i, String s) {
                Log.d("TAG", "----->" + "退出环信账号失败");
            }

            @Override
            public void onProgress(int i, String s) {

            }
        });
        return super.onKeyUp(keyCode, event);
    }
}
