package com.example.frameapp.view.activity;

import android.os.Bundle;

import androidx.recyclerview.widget.RecyclerView;

import com.example.frameapp.R;
import com.example.frameapp.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 环信功能-对话
 * 2020-02-18
 *
 * @author
 */
public class HxDialogueActivity extends BaseActivity {

    @BindView(R.id.rv_hx_dialogue)
    RecyclerView rvHxDialogue;

    /**
     * 获取布局
     *
     * @return
     */
    @Override
    protected int getLayout() {
        return R.layout.activity_hx_dialogue;
    }

    /**
     * 初始化数据
     */
    @Override
    protected void initData() {

    }
}
