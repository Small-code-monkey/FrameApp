package com.example.frameapp.mvp.model;

import android.util.Log;

import com.example.frameapp.bean.MvpTestDataBean;
import com.example.frameapp.inter.OnRetrofits;
import com.example.frameapp.mvp.contract.MvpContract;
import com.example.frameapp.protocol.BaseProtocol;

import java.util.Collections;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * MvpActivity M层
 * 2020-02-15
 *
 * @author
 */
public class MvpModel implements MvpContract.Model {

    private MvpContract.Presenter presenter;

    public MvpModel(MvpContract.Presenter presenter) {
        this.presenter = presenter;
    }

    /**
     * 实体请求数据
     *
     * @param pageSize
     * @param pageNum
     * @param onRetrofits
     */
    @Override
    public void getData(int pageSize, int pageNum, OnRetrofits onRetrofits) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BaseProtocol.DATA_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        BaseProtocol baseProtocol = retrofit.create(BaseProtocol.class);
        Call<MvpTestDataBean> call = baseProtocol.getWallPaperData(pageSize, pageNum);
        call.enqueue(new Callback<MvpTestDataBean>() {
            @Override
            public void onResponse(Call<MvpTestDataBean> call, Response<MvpTestDataBean> response) {
                Log.d("TAG", "----->" + "请求：" + response.raw());
                if (null != response.body()) {
                    Log.d("TAG", "----->" + "数据：" + response.body());
                    presenter.getReturnData(Collections.singletonList(response.body()));
                    onRetrofits.onSuccess();
                } else {
                    onRetrofits.onFailure();
                }
            }

            @Override
            public void onFailure(Call<MvpTestDataBean> call, Throwable t) {
                Log.d("TAG", "----->" + t);
                onRetrofits.onFailure();
            }
        });
    }
}
