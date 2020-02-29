package com.example.frameapp.view.dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.DialogFragment;

import com.example.frameapp.R;
import com.example.frameapp.util.AppUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 加载Dialog
 * 2020/2/28
 *
 * @author
 */
public class WaitDialog extends DialogFragment {

    @BindView(R.id.tv_wait_message)
    AppCompatTextView tvWaitMessage;

    public static WaitDialog newInstance(String content) {
        Bundle args = new Bundle();
        WaitDialog fragment = new WaitDialog();
        args.putString("text", content);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_wait, container, false);
        ButterKnife.bind(this, view);
        assert getArguments() != null;
        tvWaitMessage.setText(getArguments().getString("text"));
        AppUtil.setWindow(getDialog().getWindow());
        return view;
    }
}
