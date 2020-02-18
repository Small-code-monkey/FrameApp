package com.example.frameapp.adapter.rv;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.frameapp.R;
import com.example.frameapp.bean.HxBuddyBean;

import java.util.List;

/**
 * HxBuddyFragment 环信功能-展示好友适配器
 * 2020-02-18
 *
 * @author
 */
public class RvHxBuddyAdapter extends BaseQuickAdapter<HxBuddyBean, BaseViewHolder> {
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param layoutResId The layout resource id of each item.
     * @param data        A new list is created out of this one to avoid mutable list
     */
    public RvHxBuddyAdapter(int layoutResId, @Nullable List<HxBuddyBean> data) {
        super(layoutResId, data);
    }

    /**
     * Implement this method and use the helper to adapt the view to the given item.
     *
     * @param helper A fully initialized helper.
     * @param item   The item that needs to be displayed.
     */
    @Override
    protected void convert(BaseViewHolder helper, HxBuddyBean item) {
        helper.setText(R.id.item_hx_buddy_name, item.getName())
                .setText(R.id.item_hx_buddy_news, item.getNews())
                .setText(R.id.item_hx_buddy_time, item.getTime())
                .addOnClickListener(R.id.ll_hx_buddy);
    }
}
