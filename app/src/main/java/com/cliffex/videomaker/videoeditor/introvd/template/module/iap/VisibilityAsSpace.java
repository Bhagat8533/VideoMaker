package com.introvd.template.module.iap;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.introvd.template.common.LogUtils;

public class VisibilityAsSpace extends View implements OnGlobalLayoutListener {
    private int bCH;
    private View bCI;

    public VisibilityAsSpace(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SettingLine);
        this.bCH = obtainStyledAttributes.getResourceId(R.styleable.SettingLine_line_target, -1);
        obtainStyledAttributes.recycle();
    }

    private static int getDefaultSize2(int i, int i2) {
        int mode = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i2);
        return mode != Integer.MIN_VALUE ? (mode == 0 || mode != 1073741824) ? i : size : Math.min(i, size);
    }

    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.bCI != null) {
            setVisibility(this.bCI.getVisibility());
            this.bCI.getViewTreeObserver().addOnGlobalLayoutListener(this);
            return;
        }
        this.bCI = ((ViewGroup) getParent()).findViewById(this.bCH);
        if (this.bCI != null) {
            setVisibility(this.bCI.getVisibility());
            this.bCI.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.bCI != null) {
            this.bCI.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    public void onGlobalLayout() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.bCI.getVisibility());
        sb.append("  ");
        LogUtils.m14222e("onLayoutChange", sb.toString());
        setVisibility(this.bCI.getVisibility());
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(getDefaultSize2(getSuggestedMinimumWidth(), i), getDefaultSize2(getSuggestedMinimumHeight(), i2));
    }
}
