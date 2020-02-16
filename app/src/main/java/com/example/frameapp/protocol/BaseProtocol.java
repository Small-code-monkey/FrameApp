package com.example.frameapp.protocol;

import com.example.frameapp.bean.MvpTestDataBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Retrofit2发送请求
 * 2019-11-14
 *
 * @author
 */
public interface BaseProtocol {
    String DATA_URL = "https://bing.open.apith.cn/";

    /**
     * 获取全部壁纸
     * https://bing.open.apith.cn/all?pageSize=10&pageNum=1
     *
     * @param pageSize 壁纸数目
     * @param pageNum  分页
     * @return
     */
    @GET("all?")
    Call<MvpTestDataBean> getWallPaperData(@Query("pageSize") int pageSize,
                                           @Query("pageNum") int pageNum);
}
