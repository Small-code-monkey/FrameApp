package com.example.frameapp.adapter;

import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.example.frameapp.R;

import java.util.List;

/**
 * 引导图-适配器
 * 2020-02-12
 *
 * @author
 */
public class GuidePagerAdapter extends PagerAdapter {

    private List<String> urls;
    private int[] urlInt = {R.mipmap.bg_guide_1, R.mipmap.bg_guide_2, R.mipmap.bg_guide_3};

    public GuidePagerAdapter(List<String> urls) {
        this.urls = urls;
    }

    /**
     * Return the number of views available.
     */
    @Override
    public int getCount() {
        return urls.size();
    }

    /**
     * Determines whether a page View is associated with a specific key object
     * as returned by {@link #instantiateItem(ViewGroup, int)}. This method is
     * required for a PagerAdapter to function properly.
     *
     * @param view   Page View to check for association with <code>object</code>
     * @param object Object to check for association with <code>view</code>
     * @return true if <code>view</code> is associated with the key object <code>object</code>
     */
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    /**
     * Create the page for the given position.  The adapter is responsible
     * for adding the view to the container given here, although it only
     * must ensure this is done by the time it returns from
     * {@link #finishUpdate(ViewGroup)}.
     *
     * @param container The containing View in which the page will be shown.
     * @param position  The page position to be instantiated.
     * @return Returns an Object representing the new page.  This does not
     * need to be a View, but can be some other container of the page.
     */
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        AppCompatImageView imageView = new AppCompatImageView(container.getContext());
        imageView.setPaddingRelative(0, 0, 0,
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                        50, container.getContext().getResources().getDisplayMetrics()));
        //使用网络
        Glide.with(container.getContext()).load(urls.get(position)).into(imageView);
        //使用本地
//        imageView.setImageResource(urlInt[position]);
        container.addView(imageView);
        return imageView;
    }
}
