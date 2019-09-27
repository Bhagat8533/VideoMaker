package com.introvd.template.module.iap.business;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import com.introvd.template.module.iap.R;

public class RatioFrameLayout extends FrameLayout {
    private float dPj;
    private float dPk;
    private int offset;

    public RatioFrameLayout(Context context) {
        this(context, null);
    }

    public RatioFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RatioView);
        this.dPk = obtainStyledAttributes.getFloat(R.styleable.RatioView_ratio, -1.0f);
        this.dPj = obtainStyledAttributes.getFloat(R.styleable.RatioView_percentHorizontal, -1.0f);
        this.offset = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.RatioView_offset, 0);
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (this.dPk == -1.0f && this.dPj == -1.0f) {
            super.onMeasure(i, i2);
            return;
        }
        int defaultSize = (int) (((float) getDefaultSize(getSuggestedMinimumWidth(), i)) * (this.dPj < 0.0f ? 1.0f : this.dPj));
        if (this.dPk != -1.0f) {
            super.onMeasure(MeasureSpec.makeMeasureSpec(defaultSize - this.offset, 1073741824), MeasureSpec.makeMeasureSpec(((int) (((float) defaultSize) * this.dPk)) - this.offset, 1073741824));
        } else {
            super.onMeasure(MeasureSpec.makeMeasureSpec(defaultSize - this.offset, 1073741824), i2);
        }
    }
}
