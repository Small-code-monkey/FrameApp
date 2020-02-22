package com.example.frameapp.view.activity;

import android.text.TextUtils;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.recyclerview.widget.RecyclerView;

import com.example.frameapp.R;
import com.example.frameapp.adapter.rv.RvDialogueAdapter;
import com.example.frameapp.base.BaseActivity;
import com.example.frameapp.bean.HxBuddyBean;
import com.example.frameapp.bean.HxDialogueBean;
import com.hjq.toast.ToastUtils;
import com.hyphenate.EMMessageListener;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMMessage;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 环信功能-对话
 * 2020-02-18
 *
 * @author
 */
public class HxDialogueActivity extends BaseActivity {

    @BindView(R.id.rv_hx_dialogue)
    RecyclerView rvHxDialogue;
    @BindView(R.id.et_text_hx_dialogue)
    AppCompatEditText etTextHxDialogue;
    @BindView(R.id.bu_send_hx_dialogue)
    AppCompatButton buSendHxDialogue;

    private RvDialogueAdapter dialogueAdapter;
    private List<HxDialogueBean> dialogueBeans;
    private EMMessageListener msgListener;

    /**
     * 用户Id
     */
    private String friend;

    /**
     * 获取布局
     *
     * @return
     */
    @Override
    protected int getLayout() {
        return R.layout.activity_hx_dialogue;
    }

    /**
     * 初始化数据
     */
    @Override
    protected void initData() {
        //获取传递对象
        HxBuddyBean buddyBean = getIntent().getParcelableExtra("buddyBean");
        assert buddyBean != null;
        friend = buddyBean.getUserId();
        //设置顶部标题
        setTitle(buddyBean.getName());

        //模拟一条消息
        HxDialogueBean hxDialogueBean = new HxDialogueBean(HxDialogueBean.TYPE_RECEIVED, buddyBean.getNews());
        dialogueBeans = new ArrayList<>();
        dialogueBeans.add(hxDialogueBean);
        dialogueAdapter = new RvDialogueAdapter(R.layout.item_rv_hx_dialogue, dialogueBeans);
        rvHxDialogue.setAdapter(dialogueAdapter);
        dialogueAdapter.notifyDataSetChanged();

        //环信消息监听器
        msgListener = new EMMessageListener() {
            @Override
            public void onMessageReceived(List<EMMessage> list) {
                //收到消息
                String result = list.get(0).getBody().toString();
                String msgReceived = result.substring(5, result.length() - 1);

                HxDialogueBean dialogueBean = new HxDialogueBean(HxDialogueBean.TYPE_RECEIVED, msgReceived);
                runOnUiThread(() -> {
                    dialogueBeans.add(dialogueBean);
                    dialogueAdapter.notifyDataSetChanged();
                    rvHxDialogue.scrollToPosition(dialogueBeans.size() - 1);
                });
            }

            @Override
            public void onCmdMessageReceived(List<EMMessage> list) {
                //收到透传消息
            }

            @Override
            public void onMessageRead(List<EMMessage> list) {
                //收到已读回执
            }

            @Override
            public void onMessageDelivered(List<EMMessage> list) {
                //收到已送达回执
            }

            @Override
            public void onMessageRecalled(List<EMMessage> list) {
                //消息被撤回
            }

            @Override
            public void onMessageChanged(EMMessage emMessage, Object o) {
                //消息状态变动
            }
        };
        EMClient.getInstance().chatManager().addMessageListener(msgListener);
    }

    /**
     * 发送消息
     */
    @OnClick(R.id.bu_send_hx_dialogue)
    public void onViewClicked() {
        String content = etTextHxDialogue.getText().toString().trim();
        if (TextUtils.isEmpty(content)) {
            ToastUtils.show("发送内容不能为空");
            return;
        }
        //创建一条文本消息，content为消息文字内容，toChatUsername为对方用户或者群聊的id，后文皆是如此
        EMMessage message = EMMessage.createTxtSendMessage(content, friend);
        //发送消息
        EMClient.getInstance().chatManager().sendMessage(message);

        HxDialogueBean dialogueBean = new HxDialogueBean(HxDialogueBean.TYPE_SEND, content);
        dialogueBeans.add(dialogueBean);
        dialogueAdapter.notifyItemInserted(dialogueBeans.size() - 1);
        rvHxDialogue.scrollToPosition(dialogueBeans.size() - 1);
        etTextHxDialogue.setText("");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EMClient.getInstance().chatManager().removeMessageListener(msgListener);
    }
}
