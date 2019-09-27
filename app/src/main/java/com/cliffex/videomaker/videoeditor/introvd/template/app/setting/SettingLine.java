package com.introvd.template.app.setting;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.introvd.template.R;
import com.introvd.template.common.LogUtils;

public class SettingLine extends View implements OnGlobalLayoutListener {
    private int bCH;
    private View bCI;

    public SettingLine(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SettingLine);
        this.bCH = obtainStyledAttributes.getResourceId(R.styleable.SettingLine_line_target, -1);
        obtainStyledAttributes.recycle();
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
        sb.append(this.bCI);
        sb.append("  ");
        sb.append(this.bCI.getVisibility());
        sb.append("  ");
        LogUtils.m14222e("onLayoutChange", sb.toString());
        setVisibility(this.bCI.getVisibility());
    }
}
