package com.example.frameapp.bean;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * 基类Fragment
 * 2020-02-12
 *
 * @author
 */
public abstract class BaseFragment<A extends BasicActivity> extends Fragment {

    /**
     * Activity对象
     */
    private A Activity;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    /**
     * 获取绑定的 Activity
     */
    public A getAttachActivity() {
        return Activity;
    }
}
