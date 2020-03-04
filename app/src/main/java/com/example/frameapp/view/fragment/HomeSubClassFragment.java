package com.example.frameapp.view.fragment;

import android.os.Bundle;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.frameapp.R;
import com.example.frameapp.adapter.rv.RvHomeSubClassAdapter;
import com.example.frameapp.base.BaseFragment;
import com.example.frameapp.view.activity.TabActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * HomeFragment 子类Fragment
 * 2020/3/2
 *
 * @author
 */
public class HomeSubClassFragment extends BaseFragment<TabActivity> {

    @BindView(R.id.rv_home_subclass)
    RecyclerView rvHomeSubclass;

    public static HomeSubClassFragment newInstance(int index) {
        Bundle args = new Bundle();
        HomeSubClassFragment fragment = new HomeSubClassFragment();
        args.putInt("index", index);
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
        return R.layout.fragment_home_sub_class;
    }

    /**
     * 初始化数据
     */
    @Override
    protected void initData() {
        //模拟数据
        List<String> lists = new ArrayList<>();
        int forSize = 100;
        for (int i = 0; i <= forSize; i++) {
            lists.add(i + "");
        }

        RecyclerView.LayoutManager layoutManager = null;
        assert getArguments() != null;
        switch (getArguments().getInt("index")) {
            case 0:
                layoutManager = new LinearLayoutManager(context);
                break;
            case 1:
                layoutManager = new GridLayoutManager(context, 2);
                break;
            default:
                break;
        }

        rvHomeSubclass.setLayoutManager(layoutManager);
        rvHomeSubclass.setAdapter(new RvHomeSubClassAdapter(R.layout.item_dialog_menu_rv, lists));
    }
}
