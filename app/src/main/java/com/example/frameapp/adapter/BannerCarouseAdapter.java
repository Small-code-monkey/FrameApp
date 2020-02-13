package com.example.frameapp.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.youth.banner.adapter.BannerAdapter;

import java.util.List;

/**
 * Banner适配器
 * 2020-02-12
 *
 * @author
 */
public class BannerCarouseAdapter extends BannerAdapter<String, BannerCarouseAdapter.ImageHolder> {

    public BannerCarouseAdapter(List<String> datas) {
        super(datas);
    }

    /**
     * 创建ViewHolder
     *
     * @param parent
     * @param viewType
     * @return XViewHolder
     */
    @Override
    public ImageHolder onCreateHolder(ViewGroup parent, int viewType) {
        ImageView imageView = new ImageView(parent.getContext());
        imageView.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return new ImageHolder(imageView);
    }

    /**
     * 绑定布局数据
     *
     * @param holder   XViewHolder
     * @param data     数据实体
     * @param position 当前位置
     * @param size     总数
     */
    @Override
    public void onBindView(ImageHolder holder, String data, int position, int size) {
        Glide.with(holder.itemView).load(data).into(holder.imageView);
    }

    class ImageHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        ImageHolder(@NonNull View view) {
            super(view);
            this.imageView = (ImageView) view;
        }
    }
}
