package com.example.frameapp.mvp.presenter;

import com.example.frameapp.mvp.contract.MvpContract;
import com.example.frameapp.mvp.model.MvpModel;

import java.util.List;

/**
 * MvpActivity P层
 * 2020-02-15
 *
 * @author
 */
public class MvpPresenter implements MvpContract.Presenter {

    private MvpContract.View view;
    private MvpContract.Model model;

    public MvpPresenter(MvpContract.View view) {
        this.view = view;
        model = new MvpModel(this);
    }

    /**
     * 方法获取数据
     */
    @Override
    public void methodData() {
        view.startLoading();
        model.getData(view.setPageSize(), view.setPageNum(), this);
    }

    /**
     * 传递返回数据
     *
     * @param dataBeans
     */
    @Override
    public void getReturnData(List dataBeans) {
        view.getData(dataBeans);
    }

    /**
     * 成功
     */
    @Override
    public void onSuccess() {
        view.endLoading();
    }

    /**
     * 失败
     */
    @Override
    public void onFailure() {
        view.endLoading();
    }
}
