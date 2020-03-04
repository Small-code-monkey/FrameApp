package com.example.frameapp.action;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;

import com.hjq.bar.OnTitleBarListener;
import com.hjq.bar.TitleBar;

/**
 * 标题栏意图
 * 2020-02-12
 *
 * @author
 */
public interface TitleBarAction extends OnTitleBarListener {

    @Nullable
    TitleBar getTitleBar();

    /**
     * 左项被点击
     *
     * @param v 被点击的左项View
     */
    @Override
    default void onLeftClick(View v) {
    }

    /**
     * 标题被点击
     *
     * @param v 被点击的标题View
     */
    @Override
    default void onTitleClick(View v) {
    }

    /**
     * 右项被点击
     *
     * @param v 被点击的右项View
     */
    @Override
    default void onRightClick(View v) {
    }

    /**
     * 设置标题栏的标题
     *
     * @param id
     */
    default void setTitle(@StringRes int id) {
        if (getTitleBar() != null) {
            setTitle(getTitleBar().getResources().getString(id));
        }
    }

    /**
     * 设置标题栏的标题
     */
    default void setTitle(CharSequence title) {
        if (getTitleBar() != null) {
            getTitleBar().setTitle(title);
        }
    }

    /**
     * 获取标题栏左标题
     *
     * @return
     */
    default CharSequence getLeftTitle() {
        if (getTitleBar() != null) {
            return getTitleBar().getLeftTitle();
        }
        return "";
    }

    /**
     * 设置标题栏的左标题
     *
     * @param id
     */
    default void setLeftTitle(int id) {
        if (getTitleBar() != null) {
            getTitleBar().setLeftTitle(id);
        }
    }

    /**
     * 设置标题栏左标题
     *
     * @param text
     */
    default void setLeftTitle(CharSequence text) {
        if (getTitleBar() != null) {
            getTitleBar().setLeftTitle(text);
        }
    }

    /**
     * 获取标题栏右标题
     *
     * @return
     */
    default CharSequence getRightTitle() {
        if (getTitleBar() != null) {
            return getTitleBar().getRightTitle();
        }
        return "";
    }

    /**
     * 设置标题栏右标题
     *
     * @param id
     */
    default void setRightTitle(int id) {
        if (getTitleBar() != null) {
            getTitleBar().setRightTitle(id);
        }
    }

    /**
     * 设置标题栏右标题
     *
     * @param text
     */
    default void setRightTitle(CharSequence text) {
        if (getTitleBar() != null) {
            getTitleBar().setRightTitle(text);
        }
    }

    @Nullable
    default Drawable getLeftIcon() {
        if (getTitleBar() != null) {
            return getTitleBar().getLeftIcon();
        }
        return null;
    }

    /**
     * 设置标题栏的左图标
     *
     * @param id
     */
    default void setLeftIcon(int id) {
        if (getTitleBar() != null) {
            getTitleBar().setLeftIcon(id);
        }
    }

    default void setLeftIcon(Drawable drawable) {
        if (getTitleBar() != null) {
            getTitleBar().setLeftIcon(drawable);
        }
    }

    /**
     * 获取标题栏右图标
     *
     * @return
     */
    @Nullable
    default Drawable getRightIcon() {
        if (getTitleBar() != null) {
            return getTitleBar().getRightIcon();
        }
        return null;
    }

    /**
     * 设置标题栏的右图标
     *
     * @param id
     */
    default void setRightIcon(int id) {
        if (getTitleBar() != null) {
            getTitleBar().setRightIcon(id);
        }
    }

    /**
     * 设置标题栏的右图标
     *
     * @param drawable
     */
    default void setRightIcon(Drawable drawable) {
        if (getTitleBar() != null) {
            getTitleBar().setRightIcon(drawable);
        }
    }

    /**
     * 递归获取 ViewGroup 中的 TitleBar 对象
     *
     * @param group
     * @return
     */
    default TitleBar findTitleBar(ViewGroup group) {
        for (int i = 0; i < group.getChildCount(); i++) {
            View view = group.getChildAt(i);
            if ((view instanceof TitleBar)) {
                return (TitleBar) view;
            } else if (view instanceof ViewGroup) {
                TitleBar titleBar = findTitleBar((ViewGroup) view);
                if (titleBar != null) {
                    return titleBar;
                }
            }
        }
        return null;
    }
}