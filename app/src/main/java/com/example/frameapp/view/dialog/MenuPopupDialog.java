package com.example.frameapp.view.dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.frameapp.R;
import com.example.frameapp.util.AppUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 菜单Dialog
 * 2020/2/29
 *
 * @author
 */
public class MenuPopupDialog extends DialogFragment {

    @BindView(R.id.item_rv_dialog_popup)
    RecyclerView itemRvDialogPopup;

    private MenuOnListener mMenuOnListener;

    public static MenuPopupDialog newInstance(List<String> strings) {
        Bundle args = new Bundle();
        MenuPopupDialog fragment = new MenuPopupDialog();
        args.putStringArrayList("list", (ArrayList<String>) strings);
        fragment.setArguments(args);
        return fragment;
    }

    public void setMenuOnListener(MenuOnListener menuOnListener) {
        mMenuOnListener = menuOnListener;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_menu_popup, container, false);
        ButterKnife.bind(this, view);
        assert getArguments() != null;
        MenuPopupAdapter menuPopupAdapter = new MenuPopupAdapter(R.layout.item_dialog_menu_rv,
                getArguments().getStringArrayList("list"));
        itemRvDialogPopup.setAdapter(menuPopupAdapter);
        menuPopupAdapter.setOnItemChildClickListener((adapter, view1, position) -> {
            mMenuOnListener.mOnClickOnListener(position);
        });
        AppUtil.setWindow(getDialog().getWindow());
        return view;
    }

    public interface MenuOnListener {

        /**
         * 监听点击事件
         *
         * @param position
         */
        void mOnClickOnListener(int position);
    }

    private static class MenuPopupAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
        /**
         * Same as QuickAdapter#QuickAdapter(Context,int) but with
         * some initialization mData.
         *
         * @param layoutResId The layout resource id of each item.
         * @param data        A new list is created out of this one to avoid mutable list
         */
        public MenuPopupAdapter(int layoutResId, @Nullable List<String> data) {
            super(layoutResId, data);
        }

        /**
         * Implement this method and use the helper to adapt the view to the given item.
         *
         * @param helper A fully initialized helper.
         * @param item   The item that needs to be displayed.
         */
        @Override
        protected void convert(BaseViewHolder helper, String item) {
            helper.setText(R.id.item_tv_dialog_popup, item)
                    .addOnClickListener(R.id.item_tv_dialog_popup);
        }
    }
}
