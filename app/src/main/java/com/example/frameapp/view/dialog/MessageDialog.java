package com.example.frameapp.view.dialog;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;

import com.example.frameapp.R;

/**
 * 确定dialog
 * 2020-02-24
 *
 * @author
 */
public class MessageDialog extends AppCompatDialog {

    private MessageDialog(Context context) {
        super(context);
    }

    public static class Builder implements View.OnClickListener {
        private MessageDialog messageDialog;
        private Context context;
        private String title;
        private String message;
        private String cancel;
        private String determine;
        private String etContext;
        private boolean isTvEt;

        private OnViewListener mListener;

        public Builder(Context context) {
            this.context = context;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder setListener(OnViewListener listener) {
            mListener = listener;
            return this;
        }

        public Builder setCancel(String cancel) {
            this.cancel = cancel;
            return this;
        }

        public Builder setDetermine(String determine) {
            this.determine = determine;
            return this;
        }

        /**
         * 默认true不显示输入框 false显示
         *
         * @param isTvEt
         * @return
         */
        public Builder setIsEt(boolean isTvEt) {
            this.isTvEt = isTvEt;
            return this;
        }

        public MessageDialog create() {
            messageDialog = new MessageDialog(context);
            View view = LayoutInflater.from(context).inflate(R.layout.dialog_message, null);
            //设置标题
            AppCompatTextView titleView = view.findViewById(R.id.dialog_message_tv);
            titleView.setText(title);
            //设置内容
            AppCompatTextView messageView = view.findViewById(R.id.dialog_title_tv);
            messageView.setText(message);
            messageView.setVisibility(message == null ? View.GONE : View.VISIBLE);
            //设置输入框
            AppCompatEditText editText = view.findViewById(R.id.dialog_message_et);
            if (!isTvEt) {
                messageView.setVisibility(View.GONE);
                editText.setVisibility(View.VISIBLE);
                etContext = editText.getText().toString().trim();
            }
            //设置左边按钮
            AppCompatTextView dialogTvMeCancel = view.findViewById(R.id.dialog_tv_me_cancel);
            dialogTvMeCancel.setOnClickListener(this);
            dialogTvMeCancel.setText(!TextUtils.isEmpty(cancel) ? cancel : "取消");
            //设置右边按钮
            AppCompatTextView dialogTvMeDetermine = view.findViewById(R.id.dialog_tv_me_determine);
            dialogTvMeDetermine.setOnClickListener(this);
            dialogTvMeCancel.setText(!TextUtils.isEmpty(determine) ? determine : "确定");
            messageDialog.setContentView(view);
            return messageDialog;
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.dialog_tv_me_cancel:
                    //取消　
                    if (mListener != null) {
                        mListener.onCancel();
                    }
                    break;
                case R.id.dialog_tv_me_determine:
                    //确定
                    if (mListener != null) {
                        mListener.onDetermine(etContext);
                    }
                    break;
                default:
                    break;
            }
            messageDialog.dismiss();
        }
    }

    /**
     * 按钮监听接口
     */
    public interface OnViewListener {

        /**
         * 取消按钮
         */
        void onCancel();

        /**
         * 确定按钮
         *
         * @param et 添加理由
         */
        void onDetermine(String et);
    }
}
