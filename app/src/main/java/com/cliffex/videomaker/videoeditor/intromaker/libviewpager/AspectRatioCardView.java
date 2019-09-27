package com.cliffex.videomaker.videoeditor.intromaker.libviewpager;

import android.content.Context;
import android.util.AttributeSet;
import androidx.cardview.widget.CardView;

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
    }
}
