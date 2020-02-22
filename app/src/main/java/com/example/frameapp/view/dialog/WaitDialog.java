package com.example.frameapp.view.dialog;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.widget.AppCompatTextView;

import com.example.frameapp.R;

/**
 * 加载对话框
 * 2020-02-15
 *
 * @author
 */
public class WaitDialog extends AppCompatDialog {

    private WaitDialog(Context context) {
        super(context);
    }

    public static class Builder {
        private Context context;
        private String text;

        public Builder(Context context) {
            this.context = context;
        }

        /**
         * 支持id
         *
         * @param text
         * @return
         */
        public Builder setMessage(@StringRes int text) {
            return setMessage(context.getString(text));
        }

        public Builder setMessage(String text) {
            this.text = text;
            return this;
        }

        @SuppressLint("ResourceAsColor")
        public WaitDialog create() {
            WaitDialog waitDialog = new WaitDialog(context);
            View view = LayoutInflater.from(context).inflate(R.layout.dialog_wait, null);
            AppCompatTextView textView = view.findViewById(R.id.tv_wait_message);
            textView.setText(text);
            textView.setVisibility(text == null ? View.GONE : View.VISIBLE);
            waitDialog.setContentView(view);
            //android.support.design.R.id.design_bottom_sheet

            // 设置参数
            Window window = waitDialog.getWindow();
            if (window != null) {
                WindowManager.LayoutParams params = window.getAttributes();
                params.width = ViewGroup.LayoutParams.WRAP_CONTENT;
                params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
                params.gravity = Gravity.CENTER;
                params.windowAnimations = 0;
                window.setAttributes(params);
                window.setWindowAnimations(android.R.style.Animation_Toast);
                window.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
            }

            return waitDialog;
        }
    }

}