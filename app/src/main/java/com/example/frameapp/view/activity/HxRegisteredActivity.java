package com.example.frameapp.view.activity;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;

import com.example.frameapp.R;
import com.example.frameapp.base.BaseActivity;
import com.example.frameapp.util.AppUtil;
import com.example.frameapp.util.views.ClearEditText;
import com.hjq.bar.TitleBar;
import com.hjq.toast.ToastUtils;
import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;
import com.hyphenate.exceptions.HyphenateException;
import com.tencent.mmkv.MMKV;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 环信功能-注册
 * 2020-02-17
 *
 * @author
 */
public class HxRegisteredActivity extends BaseActivity {

    @BindView(R.id.et_rd_user)
    ClearEditText etRdUser;
    @BindView(R.id.et_rd_pwd)
    ClearEditText etRdPwd;
    @BindView(R.id.tv_hx_rd)
    AppCompatTextView tvHxRd;
    @BindView(R.id.bu_hx_rd)
    AppCompatButton buHxRd;
    @BindView(R.id.bu_hx_rd_auto)
    AppCompatButton buHxRdAuto;
    @BindView(R.id.titleBar7)
    TitleBar titleBar7;
    @BindView(R.id.bu_hx_rd_login)
    AppCompatButton buHxRdLogin;

    /**
     * 获取布局
     *
     * @return
     */
    @Override
    protected int getLayout() {
        return R.layout.activity_hx_registered;
    }

    /**
     * 初始化数据
     */
    @Override
    protected void initData() {
        if (!AppUtil.iConnected(context)) {
            ToastUtils.show("检查网络连接");
        }
    }

    @OnClick({R.id.tv_hx_rd, R.id.bu_hx_rd, R.id.bu_hx_rd_login, R.id.bu_hx_rd_auto})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_hx_rd:
                //忘记密码
                break;
            case R.id.bu_hx_rd:
                //注册
                new Thread(() -> {
                    try {
                        String name = etRdUser.getText().toString().trim();
                        String password = etRdPwd.getText().toString().trim();

                        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(password)) {
                            ToastUtils.show("账号密码不能为空");
                            return;
                        }
                        showLoading();
                        EMClient.getInstance().createAccount(name, password);
                        ToastUtils.show("注册成功");
                    } catch (HyphenateException e) {
                        e.printStackTrace();
                        if (e.getErrorCode() == 203) {
                            ToastUtils.show("用户已存在");
                        }
                        showComplete();
                    }
                }).start();
                break;
            case R.id.bu_hx_rd_login:
                //登录
                String nameLogin = etRdUser.getText().toString().trim();
                String passwordLogin = etRdPwd.getText().toString().trim();
                if (TextUtils.isEmpty(nameLogin) || TextUtils.isEmpty(passwordLogin)) {
                    ToastUtils.show("账号密码不能为空");
                    return;
                }
                EMClient.getInstance().login(nameLogin, passwordLogin, new EMCallBack() {
                    @Override
                    public void onSuccess() {
                        //获取群组消息
                        EMClient.getInstance().groupManager().loadAllGroups();
                        //获取好友消息
                        EMClient.getInstance().chatManager().loadAllConversations();
                        //登录成功
                        ToastUtils.show("登录成功");

                        //本地存储账号
                        MMKV mmkv = MMKV.defaultMMKV();
                        mmkv.encode("name", nameLogin);
                        mmkv.encode("pwd", passwordLogin);

                        //进入聊天页面
                        startActivity(HxImActivity.class);
                    }

                    @Override
                    public void onError(int i, String s) {
                        //登录失败
                        ToastUtils.show("登陆失败" + s);
                    }

                    @Override
                    public void onProgress(int i, String s) {

                    }
                });
                break;
            case R.id.bu_hx_rd_auto:
                //自动登录
                MMKV mmkv = MMKV.defaultMMKV();
                String name = mmkv.decodeString("name");
                String password = mmkv.decodeString("pwd");
                if (TextUtils.isEmpty(name) || TextUtils.isEmpty(password)) {
                    ToastUtils.show("未查询到账户");
                    return;
                }
                EMClient.getInstance().login(name, password, new EMCallBack() {
                    @Override
                    public void onSuccess() {
                        //登录成功
                        ToastUtils.show("登录成功");
                        //进入聊天页面
                        startActivity(HxImActivity.class);
                    }

                    @Override
                    public void onError(int i, String s) {
                        //登录失败
                        ToastUtils.show("登陆失败" + s);
                        Log.d("TAG", "----->" + "失败：" + s);
                    }

                    @Override
                    public void onProgress(int i, String s) {

                    }
                });
                break;
            default:
                break;
        }
    }
}
