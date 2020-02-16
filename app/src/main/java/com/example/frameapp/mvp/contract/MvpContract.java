package com.example.frameapp.mvp.contract;

import com.example.frameapp.inter.OnRetrofits;

import java.util.List;

/**
 * Mvp
 * As安装Mvp Helper插件，创建Contract，使用插件一键生成
 * 2020-02-15
 *
 * @author
 */
public interface MvpContract {

    interface Model {
        /**
         * 实体请求数据
         *
         * @param pageSize
         * @param pageNum
         * @param onRetrofits
         */
        void getData(int pageSize, int pageNum, OnRetrofits onRetrofits);
    }

    interface View<T> {
        /**
         * 设置页面壁纸数量
         *
         * @return
         */
        int setPageSize();

        /**
         * 设置页面页数
         *
         * @return
         */
        int setPageNum();

        /**
         * 获取结果数据
         *
         * @param dataBeans
         */
        void getData(List<T> dataBeans);

        /**
         * 运行加载ing...
         */
        void startLoading();

        /**
         * 结束加载ing...
         */
        void endLoading();
    }

    interface Presenter<T> extends OnRetrofits {
        /**
         * 方法获取数据
         */
        void methodData();

        /**
         * 传递返回数据
         *
         * @param dataBeans
         */
        void getReturnData(List<T> dataBeans);
    }
}
