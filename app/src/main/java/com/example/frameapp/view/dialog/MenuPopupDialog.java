package com.example.frameapp.view.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.frameapp.R;
import com.example.frameapp.inter.OnListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 弹出菜单Dialog
 * 2020-02-20
 *
 * @author
 */
public class MenuPopupDialog extends AppCompatDialog {

    public MenuPopupDialog(@NonNull Context context) {
        super(context);
    }

    public static class Builder implements BaseQuickAdapter.OnItemChildClickListener {
        private Context context;
        private List<String> mData = new ArrayList<>();
        private OnListener mOnListener;
        private MenuPopupDialog popupDialog;

        public Builder(Context context) {
            this.context = context;
        }

        /**
         * 支持id
         *
         * @param ids
         * @return
         */
        public Builder setList(int... ids) {
            List<String> data = new ArrayList<>(ids.length);
            for (int id : ids) {
                data.add(context.getString(id));
            }
            return setList(data);
        }

        /**
         * 支持String
         *
         * @param data
         * @return
         */
        public Builder setList(String... data) {
            return setList(Arrays.asList(data));
        }

        /**
         * 支持List
         *
         * @param data
         * @return
         */
        @SuppressWarnings("all")
        public Builder setList(List data) {
            mData.addAll(data);
            return this;
        }

        public Builder setListener(OnListener listener) {
            mOnListener = listener;
            return this;
        }

        public MenuPopupDialog create() {
            popupDialog = new MenuPopupDialog(context);
            View view = LayoutInflater.from(context).inflate(R.layout.dialog_menu_popup, null);
            RecyclerView recyclerView = view.findViewById(R.id.item_rv_dialog_popup);
            MenuPopupAdapter adapter = new MenuPopupAdapter(R.layout.item_dialog_menu_rv, mData);
            recyclerView.setAdapter(adapter);
            adapter.setOnItemChildClickListener(this);
            return popupDialog;
        }

        /**
         * callback method to be invoked when an item in this view has been
         * click and held
         *
         * @param adapter
         * @param view     The view whihin the ItemView that was clicked
         * @param position The position of the view int the adapter
         */
        @Override
        public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
            popupDialog.dismiss();
            //监听器得到点击位置
            mOnListener.mOnClickOnListener(position);
        }
    }

    static class MenuPopupAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
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
            helper.setText(R.id.item_tv_dialog_popup, item);
        }
    }
}
