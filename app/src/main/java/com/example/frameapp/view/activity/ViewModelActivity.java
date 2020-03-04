package com.example.frameapp.view.activity;

import androidx.recyclerview.widget.RecyclerView;

import com.example.frameapp.R;
import com.example.frameapp.base.BaseActivity;

import butterknife.BindView;

/**
 * MVVM 模式
 * 2020/2/26
 *
 * @author
 */
public class ViewModelActivity extends BaseActivity {


    @BindView(R.id.rv_view_model)
    RecyclerView rvViewModel;

    /**
     * 获取布局
     *
     * @return
     */
    @Override
    protected int getLayout() {
        return R.layout.activity_view_model;
    }

    /**
     * 初始化数据
     */
    @Override
    protected void initData() {

    }
}
