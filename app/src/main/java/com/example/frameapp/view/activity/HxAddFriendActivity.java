package com.example.frameapp.view.activity;

import android.text.TextUtils;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.recyclerview.widget.RecyclerView;

import com.example.frameapp.R;
import com.example.frameapp.base.BaseActivity;
import com.hjq.toast.ToastUtils;
import com.tencent.bugly.crashreport.CrashReport;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 环信功能-添加好友
 * 2020-02-18
 *
 * @author
 */
public class HxAddFriendActivity extends BaseActivity {

    @BindView(R.id.et_hx_add_friend)
    AppCompatEditText etHxAddFriend;
    @BindView(R.id.bu_search_hx_add_friend)
    AppCompatButton buSearchHxAddFriend;
    @BindView(R.id.rv_hx_add_friend)
    RecyclerView rvHxAddFriend;

    /**
     * 获取布局
     *
     * @return
     */
    @Override
    protected int getLayout() {
        return R.layout.activity_hx_add_friend;
    }

    /**
     * 初始化数据
     */
    @Override
    protected void initData() {

    }

    @OnClick(R.id.bu_search_hx_add_friend)
    public void onViewClicked() {
        String content = etHxAddFriend.getText().toString().trim();
        if (TextUtils.isEmpty(content)) {
            ToastUtils.show("搜索框不能为空");
        }
    }
}
