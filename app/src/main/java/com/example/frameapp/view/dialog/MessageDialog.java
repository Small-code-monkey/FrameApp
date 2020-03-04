package com.example.frameapp.view.dialog;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.DialogFragment;

import com.example.frameapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 消息Dialog
 * 2020/3/1
 *
 * @author
 */
public class MessageDialog extends DialogFragment {

    @BindView(R.id.dialog_title_tv)
    AppCompatTextView dialogTitleTv;
    @BindView(R.id.dialog_message_tv)
    AppCompatTextView dialogMessageTv;
    @BindView(R.id.dialog_message_et)
    AppCompatEditText dialogMessageEt;
    @BindView(R.id.dialog_tv_me_cancel)
    AppCompatTextView dialogTvMeCancel;
    @BindView(R.id.dialog_tv_me_determine)
    AppCompatTextView dialogTvMeDetermine;

    private boolean isEt;
    private MessageOnViewListener messageOnViewListener;
    private String titles;
    private String messages;
    private String etContent;

    public static MessageDialog newInstance() {
        Bundle args = new Bundle();
        MessageDialog fragment = new MessageDialog();
        fragment.setArguments(args);
        return fragment;
    }

    public MessageDialog setEt(boolean et) {
        isEt = et;
        return this;
    }

    public MessageDialog setTitles(String titles) {
        this.titles = titles;
        return this;
    }

    public MessageDialog setMessages(String messages) {
        this.messages = messages;
        return this;
    }

    public void setMessageOnViewListener(MessageOnViewListener messageOnViewListener) {
        this.messageOnViewListener = messageOnViewListener;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_message, container, false);
        ButterKnife.bind(this, view);
        dialogTitleTv.setText(titles);
        if (!isEt) {
            dialogMessageEt.setVisibility(View.VISIBLE);
            dialogMessageTv.setVisibility(View.GONE);
            etContent = dialogMessageEt.getText().toString().trim();
        } else {
            dialogMessageTv.setText(messages);
        }
//        AppUtil.setWindow(getDialog().getWindow());

        Window window = getDialog().getWindow();
        window.setBackgroundDrawableResource(android.R.color.transparent);
        return view;
    }

    @OnClick({R.id.dialog_tv_me_cancel, R.id.dialog_tv_me_determine})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.dialog_tv_me_cancel:
                messageOnViewListener.onCancel();
                break;
            case R.id.dialog_tv_me_determine:
                messageOnViewListener.onDetermine(!TextUtils.isEmpty(etContent) ? etContent : "");
                break;
            default:
                break;
        }
    }

    /**
     * MessageDialog 按钮监听接口
     */
    public interface MessageOnViewListener {

        /**
         * MessageDialog 取消按钮
         */
        void onCancel();

        /**
         * MessageDialog 确定按钮
         *
         * @param et 添加理由
         */
        void onDetermine(String et);
    }
}
