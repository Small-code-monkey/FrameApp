package com.example.frameapp.view.activity;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.example.frameapp.R;
import com.example.frameapp.adapter.rv.RvMvpAdapter;
import com.example.frameapp.base.BaseActivity;
import com.example.frameapp.bean.MvpTestDataBean;
import com.example.frameapp.mvp.contract.MvpContract;
import com.example.frameapp.mvp.presenter.MvpPresenter;
import com.example.frameapp.util.AppUtil;
import com.example.frameapp.view.dialog.MenuPopupDialog;
import com.hjq.toast.ToastUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;

/**
 * Mvp模式-例子
 * 2020-02-15
 *
 * @author
 */
public class MvpActivity extends BaseActivity implements MvpContract.View<MvpTestDataBean> {

    @BindView(R.id.rv_mvp)
    RecyclerView rvMvp;

    public int pageNum = 1;

    /**
     * 获取布局
     *
     * @return
     */
    @Override
    protected int getLayout() {
        return R.layout.activity_mvp;
    }

    /**
     * 初始化数据
     */
    @Override
    protected void initData() {
        //请求数据
        if (AppUtil.iConnected(context)) {
            MvpContract.Presenter presenter = new MvpPresenter(this);
            presenter.methodData();
        } else {
            ToastUtils.show("检查网络连接");
        }
    }

    /**
     * 设置页面壁纸数量
     *
     * @return
     */
    @Override
    public int setPageSize() {
        return 10;
    }

    /**
     * 设置页面页数
     *
     * @return
     */
    @Override
    public int setPageNum() {
        return pageNum;
    }

    /**
     * 获取结果数据
     *
     * @param dataBeans
     */
    @Override
    public void getData(List<MvpTestDataBean> dataBeans) {
        RvMvpAdapter rvMvpAdapter = new RvMvpAdapter(R.layout.item_rv_mvp, dataBeans.get(0).getData().getItem());
        rvMvp.setAdapter(rvMvpAdapter);
    }

    /**
     * 运行加载ing...
     */
    @Override
    public void startLoading() {
        showLoading();
    }

    /**
     * 结束加载ing...
     */
    @Override
    public void endLoading() {
        showComplete();
    }

    @Override
    public void onRightClick(View v) {
        MenuPopupDialog menuPopupDingDialog = MenuPopupDialog.newInstance
                (new ArrayList<>(Arrays.asList("上一页", "下一页")));
        menuPopupDingDialog.setMenuOnListener(position -> {
            switch (position) {
                case 0:
                    if (1 == pageNum) {
                        ToastUtils.show("当前第一页");
                    } else {
                        pageNum--;
                        initData();
                    }
                    break;
                case 1:
                    pageNum++;
                    initData();
                    break;
                default:
                    break;
            }
            menuPopupDingDialog.getDialog().dismiss();
        });
        menuPopupDingDialog.show(getSupportFragmentManager(), "menuDialog");
    }
}
