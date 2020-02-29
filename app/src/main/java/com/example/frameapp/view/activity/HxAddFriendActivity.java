package com.example.frameapp.view.activity;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.recyclerview.widget.RecyclerView;

import com.example.frameapp.R;
import com.example.frameapp.base.BaseActivity;
import com.example.frameapp.view.dialog.MessageDialog;
import com.hjq.toast.ToastUtils;
import com.hyphenate.EMContactListener;
import com.hyphenate.chat.EMClient;
import com.hyphenate.exceptions.HyphenateException;

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
                new MessageDialog.Builder(context)
                        .setMessage(reason)
                        .setCancel("拒绝")
                        .setDetermine("接受")
                        .setListener(new MessageDialog.OnViewListener() {
                            @Override
                            public void onCancel() {
                                try {
                                    //拒绝好友请求
                                    EMClient.getInstance().contactManager().declineInvitation(username);
                                } catch (HyphenateException e) {
                                    e.printStackTrace();
                                }
                            }

                            /**
                             * 确定按钮
                             *
                             * @param et 添加理由
                             */
                            @Override
                            public void onDetermine(String et) {
                                try {
                                    //同意好友请求
                                    EMClient.getInstance().contactManager().acceptInvitation(username);
                                } catch (HyphenateException e) {
                                    e.printStackTrace();
                                }
                            }
                        })
                        .create().show();
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
//        String userName = etHxAddFriend.getText().toString().trim();
//        if (TextUtils.isEmpty(userName)) {
//            ToastUtils.show("搜索框不能为空");
//        }
//        new MessageDialog.Builder(context)
////                .setIsEt(false)
//                .setListener(new MessageDialog.OnViewListener() {
//                    @Override
//                    public void onCancel() {
//                    }
//
//                    /**
//                     * 确定按钮
//                     *
//                     * @param et 添加理由
//                     */
//                    @Override
//                    public void onDetermine(String et) {
//                        //（SDK 不提供好友查找的服务，如需要查找好友，需要调用开发者自己服务器的用户查询接口）
//                        etHxAddFriend.post(() -> {
//                            //自己验证好友名称是否正确
//                            try {
//                                //参数为要添加的好友的username和添加理由
//                                EMClient.getInstance().contactManager().addContact(userName, et);
//                            } catch (HyphenateException e) {
//                                e.printStackTrace();
//                            }
//                        });
//                    }
//                })
//                .create().show();

        new MessageDialog.Builder(context)
                .setTitle("标题")
                .setMessage("这是内容")
                .setListener(new MessageDialog.OnViewListener() {
                    @Override
                    public void onCancel() {
                        ToastUtils.show("取消");
                    }

                    /**
                     * 确定按钮
                     *
                     * @param et 添加理由
                     */
                    @Override
                    public void onDetermine(String et) {
                        ToastUtils.show("确定");
                    }
                })
                .create().show();
    }
}
