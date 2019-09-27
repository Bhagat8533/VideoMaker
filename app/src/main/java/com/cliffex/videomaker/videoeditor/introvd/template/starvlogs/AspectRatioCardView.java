package com.introvd.template.starvlogs;

import android.content.Context;
import android.support.p024v7.widget.CardView;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;

public class AspectRatioCardView extends CardView {
    private float ratio;

    public AspectRatioCardView(Context context) {
        this(context, null);
    }

    public AspectRatioCardView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AspectRatioCardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.ratio = 1.2f;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (this.ratio > 0.0f) {
            int ratioHeight = (int) (((float) getMeasuredWidth()) * this.ratio);
            setMeasuredDimension(getMeasuredWidth(), ratioHeight);
            LayoutParams lp = getLayoutParams();
            lp.height = ratioHeight;
            setLayoutParams(lp);
            setCardBackgroundColor(0);
        }
    }
}
