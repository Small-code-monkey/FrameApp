package com.example.frameapp.util.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;

import com.example.frameapp.R;

import java.util.Objects;

/**
 * 自定义EditText
 * 2020-02-17
 *
 * @author
 */
public class BaseClearEditText extends AppCompatEditText implements
        View.OnTouchListener, View.OnFocusChangeListener, TextWatcher {

    private Drawable drawable;
    private OnTouchListener monTouchListener;
    private OnFocusChangeListener monFocusChangeListener;

    public BaseClearEditText(Context context) {
        this(context, null);
    }

    public BaseClearEditText(Context context, AttributeSet attrs) {
        this(context, attrs, android.R.attr.editTextStyle);
    }

    @SuppressLint("ClickableViewAccessibility")
    public BaseClearEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        drawable = DrawableCompat.wrap(Objects.requireNonNull(ContextCompat.getDrawable(context, R.mipmap.ic_input_delete)));
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        setDrawableVisible(false);
        super.setOnTouchListener(this);
        super.setOnFocusChangeListener(this);
        super.addTextChangedListener(this);
    }

    private void setDrawableVisible(final boolean visible) {
        if (drawable.isVisible() == visible) {
            return;
        }

        drawable.setVisible(visible, false);
        final Drawable[] drawables = getCompoundDrawables();
        setCompoundDrawables(
                drawables[0], drawables[1],
                visible ? drawable : null,
                drawables[3]);
    }

    @Override
    public void setOnFocusChangeListener(final OnFocusChangeListener onFocusChangeListener) {
        monFocusChangeListener = onFocusChangeListener;
    }

    @Override
    public void setOnTouchListener(final OnTouchListener onTouchListener) {
        monTouchListener = onTouchListener;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        if (isFocused()) {
            setDrawableVisible(charSequence.length() > 0);
        }
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

    @Override
    public void onFocusChange(View view, boolean b) {
        if (b && getText() != null) {
            setDrawableVisible(getText().length() > 0);
        } else {
            setDrawableVisible(false);
        }
        if (monFocusChangeListener != null) {
            monFocusChangeListener.onFocusChange(view, b);
        }
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        final int x = (int) motionEvent.getX();
        if (drawable.isVisible() && x > getWidth() - getPaddingRight() - drawable.getIntrinsicWidth()) {
            if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                setText("");
            }
            return true;
        }
        return monTouchListener != null && monTouchListener.onTouch(view, motionEvent);
    }
}
