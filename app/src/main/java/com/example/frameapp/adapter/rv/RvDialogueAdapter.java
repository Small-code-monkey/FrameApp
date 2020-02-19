package com.example.frameapp.adapter.rv;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.frameapp.R;
import com.example.frameapp.bean.HxDialogueBean;

import java.util.List;

/**
 * 环信对话适配器
 * 2020-02-18
 *
 * @author
 */
public class RvDialogueAdapter extends BaseQuickAdapter<HxDialogueBean, BaseViewHolder> {

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param layoutResId The layout resource id of each item.
     * @param data        A new list is created out of this one to avoid mutable list
     */
    public RvDialogueAdapter(int layoutResId, @Nullable List<HxDialogueBean> data) {
        super(layoutResId, data);
    }

    /**
     * Implement this method and use the helper to adapt the view to the given item.
     *
     * @param helper A fully initialized helper.
     * @param item   The item that needs to be displayed.
     */
    @Override
    protected void convert(BaseViewHolder helper, HxDialogueBean item) {
        //根据消息类型显示布局
        switch (item.getType()) {
            //接收消息
            case 0:
                helper.setVisible(R.id.item_ll_receive, true);
                helper.setVisible(R.id.item_ll_send, false);
                helper.setText(R.id.tv_left_content, item.getContent());
                break;
            //发送消息
            case 1:
                helper.setVisible(R.id.item_ll_receive, false);
                helper.setVisible(R.id.item_ll_send, true);
                helper.setText(R.id.tv_right_content, item.getContent());
                break;
            default:
                break;
        }
    }
}
