package com.example.frameapp.adapter.rv;

import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.frameapp.R;
import com.example.frameapp.bean.MvpTestDataBean;

import java.util.List;

/**
 * MvpActivity RecyclerView 适配器
 * 2020-02-15
 *
 * @author
 */
public class RvMvpAdapter extends BaseQuickAdapter<MvpTestDataBean.DataBean.ItemBean, BaseViewHolder> {

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param layoutResId The layout resource id of each item.
     * @param data        A new list is created out of this one to avoid mutable list
     */
    public RvMvpAdapter(int layoutResId, @Nullable List<MvpTestDataBean.DataBean.ItemBean> data) {
        super(layoutResId, data);
    }

    /**
     * Implement this method and use the helper to adapt the view to the given item.
     *
     * @param helper A fully initialized helper.
     * @param item   The item that needs to be displayed.
     */
    @Override
    protected void convert(BaseViewHolder helper, MvpTestDataBean.DataBean.ItemBean item) {
        Glide.with(helper.getConvertView()).load("http:" + item.getUrl())
                .into((AppCompatImageView) helper.getView(R.id.item_im_mvp));
        helper.setText(R.id.item_tv_mvp, item.getCopyright());
    }
}
