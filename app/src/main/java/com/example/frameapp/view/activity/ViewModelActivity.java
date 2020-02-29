package com.example.frameapp.view.activity;

import android.widget.Button;

import com.example.frameapp.R;
import com.example.frameapp.base.BaseActivity;
import com.example.frameapp.view.dialog.MessageDialog;
import com.hjq.toast.ToastUtils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * MVVM 模式
 * 2020/2/26
 *
 * @author
 */
public class ViewModelActivity extends BaseActivity {

    @BindView(R.id.bu_view_model)
    Button buViewModel;

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

    @OnClick(R.id.bu_view_model)
    public void onViewClicked() {
        new MessageDialog.Builder(getApplicationContext())
                .setTitle("测试标题")
                .setMessage("这是内容")
                .setDetermine("确定文字")
                .setCancel("取消文字")
                .setListener(new MessageDialog.OnViewListener() {
                    @Override
                    public void onCancel() {
                        ToastUtils.show("取消了");
                    }

                    @Override
                    public void onDetermine(String et) {
                        ToastUtils.show("确定了");
                    }
                }).create().show();
    }
}
