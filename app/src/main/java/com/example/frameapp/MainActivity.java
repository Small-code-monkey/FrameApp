package com.example.frameapp;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.frameapp.adapter.rv.RvMainAdapter;
import com.example.frameapp.base.BaseActivity;
import com.example.frameapp.util.AppUtil;
import com.example.frameapp.view.activity.CarouselActivity;
import com.example.frameapp.view.activity.GuideMapActivity;
import com.example.frameapp.view.activity.HxRegisteredActivity;
import com.example.frameapp.view.activity.MvpActivity;
import com.example.frameapp.view.activity.TabActivity;
import com.hjq.bar.TitleBar;
import com.hjq.toast.ToastUtils;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.BindView;

/**
 * 首页Activity
 * 2020-02-12
 *
 * @author
 */
public class MainActivity extends BaseActivity implements BaseQuickAdapter.OnItemChildClickListener {

    @BindView(R.id.titleBar)
    TitleBar titleBar;
    @BindView(R.id.rv_main)
    RecyclerView rvMain;

    /**
     * 获取布局
     *
     * @return
     */
    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    /**
     * 初始化数据
     */
    @Override
    protected void initData() {
        RvMainAdapter adapter = new RvMainAdapter(R.layout.item_rv_main,
                new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.rv_main))));
        rvMain.setAdapter(adapter);
        adapter.setOnItemChildClickListener(this);
    }

    /**
     * callback method to be invoked when an item in this view has been
     * click and held
     *
     * @param adapter
     * @param view     The view whihin the ItemView that was clicked
     * @param position The position of the view int the adapter
     */
    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        switch (position) {
            case 0:
                //引导图
                startActivity(GuideMapActivity.class);
                finish();
                break;
            case 1:
                //轮播图
                startActivity(CarouselActivity.class);
                break;
            case 2:
                //Tab
                startActivity(TabActivity.class);
                break;
            case 3:
                //Mvp
                if (!AppUtil.iConnected(context)) {
                    ToastUtils.show("检查网络连接");
                } else {
                    startActivity(MvpActivity.class);
                }
                break;
            case 4:
                //环信Im
                if (!AppUtil.iConnected(context)) {
                    ToastUtils.show("检查网络连接");
                } else {
                    startActivity(HxRegisteredActivity.class);
                }
                break;
            default:
                break;
        }
    }
}
