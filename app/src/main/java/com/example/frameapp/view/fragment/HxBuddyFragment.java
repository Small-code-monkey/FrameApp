package com.example.frameapp.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.frameapp.R;
import com.example.frameapp.adapter.rv.RvHxBuddyAdapter;
import com.example.frameapp.base.BaseFragment;
import com.example.frameapp.bean.HxBuddyBean;
import com.example.frameapp.view.activity.HxAddFriendActivity;
import com.example.frameapp.view.activity.HxDialogueActivity;
import com.example.frameapp.view.activity.HxImActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

/**
 * 环信功能-好友
 * 2020-02-17
 *
 * @author
 */
public class HxBuddyFragment extends BaseFragment<HxImActivity> implements BaseQuickAdapter.OnItemChildClickListener {

    @BindView(R.id.rv_hx_buddy)
    RecyclerView rvHxBuddy;
    @BindView(R.id.tv_lv_hx_buddy)
    AppCompatTextView tvLvHxBuddy;

    private List<HxBuddyBean> buddyBeans;

    public static HxBuddyFragment newInstance() {
        Bundle args = new Bundle();
        HxBuddyFragment fragment = new HxBuddyFragment();
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
        return R.layout.fragment_hx_buddy;
    }

    /**
     * 初始化数据
     */
    @Override
    protected void initData() {
        buddyBeans = new ArrayList<>();
        //默认图灵
        HxBuddyBean buddyBean = new HxBuddyBean();
        buddyBean.setName("图灵");
        buddyBean.setUserId("tuling");
        buddyBean.setTime("11:00");
        buddyBean.setNews("你好");
        buddyBeans.add(buddyBean);

        RvHxBuddyAdapter buddyAdapter = new RvHxBuddyAdapter(R.layout.item_rv_hx_buddy, buddyBeans);
        rvHxBuddy.setAdapter(buddyAdapter);
        buddyAdapter.setOnItemChildClickListener(this);

        //设置Lv

    }

    /**
     * Title右图标点击
     *
     * @param v 被点击的右项View
     */
    @Override
    public void onRightClick(View v) {
        startActivity(HxAddFriendActivity.class);
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
        Intent intent = new Intent(getAttachActivity(), HxDialogueActivity.class);
        intent.putExtra("buddyBean", buddyBeans.get(position));
        startActivity(intent);
    }
}
