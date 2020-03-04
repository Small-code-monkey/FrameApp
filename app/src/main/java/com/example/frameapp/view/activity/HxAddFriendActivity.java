package com.example.frameapp.view.activity;

import android.text.TextUtils;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.recyclerview.widget.RecyclerView;

import com.example.frameapp.R;
import com.example.frameapp.base.BaseActivity;
import com.example.frameapp.view.dialog.MessageDialog;
import com.hjq.toast.ToastUtils;
import com.hyphenate.EMContactListener;
import com.hyphenate.chat.EMClient;

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
        EMClient.getInstance().contactManager().setContactListener(new EMContactListener() {

            @Override
            public void onContactInvited(String username, String reason) {
                //收到好友邀请
//                new MessageDialog.Builder(context)
//                        .setMessage(reason)
//                        .setCancel("拒绝")
//                        .setDetermine("接受")
//                        .setListener(new MessageDialog.OnViewListener() {
//                            @Override
//                            public void onCancel() {
//                                try {
//                                    //拒绝好友请求
//                                    EMClient.getInstance().contactManager().declineInvitation(username);
//                                } catch (HyphenateException e) {
//                                    e.printStackTrace();
//                                }
//                            }
//
//                            /**
//                             * 确定按钮
//                             *
//                             * @param et 添加理由
//                             */
//                            @Override
//                            public void onDetermine(String et) {
//                                try {
//                                    //同意好友请求
//                                    EMClient.getInstance().contactManager().acceptInvitation(username);
//                                } catch (HyphenateException e) {
//                                    e.printStackTrace();
//                                }
//                            }
//                        })
//                        .create().show();
            }

            @Override
            public void onFriendRequestAccepted(String s) {
                //好友请求被同意
            }

            @Override
            public void onFriendRequestDeclined(String s) {
                //好友请求被拒绝
            }

            @Override
            public void onContactDeleted(String username) {
                //被删除时回调此方法
            }

            @Override
            public void onContactAdded(String username) {
                //增加了联系人时回调此方法
            }
        });
    }

    @OnClick(R.id.bu_search_hx_add_friend)
    public void onViewClicked() {
        String userName = etHxAddFriend.getText().toString().trim();
        if (TextUtils.isEmpty(userName)) {
            ToastUtils.show("搜索框不能为空");
        } else {
            MessageDialog messageDialog = MessageDialog.newInstance();
            messageDialog.setTitles("添加好友").setEt(false)
                    .setMessageOnViewListener(new MessageDialog.MessageOnViewListener() {
                        @Override
                        public void onCancel() {
                            //取消添加
                            messageDialog.getDialog().dismiss();
                        }

                        @Override
                        public void onDetermine(String et) {
                            //确定添加
                            messageDialog.getDialog().dismiss();
                            ToastUtils.show(et);
                        }
                    });
            messageDialog.show(getSupportFragmentManager(), "MessageDialog");
        }
    }
}
