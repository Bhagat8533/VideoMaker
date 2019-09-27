package com.cliffex.videomaker.videoeditor.intromaker.libviewpager;

import android.content.Context;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.PageTransformer;

public class CustPagerTransformer implements PageTransformer {
    private int maxTranslateOffsetX;
    private ViewPager viewPager;

    public CustPagerTransformer(Context context) {
        this.maxTranslateOffsetX = dp2px(context, 180.0f);
    }

    public void transformPage(View view, float position) {
        if (this.viewPager == null) {
            this.viewPager = (ViewPager) view.getParent();
        }
        float offsetRate = (((float) (((view.getMeasuredWidth() / 2) + (view.getLeft() - this.viewPager.getScrollX())) - (this.viewPager.getMeasuredWidth() / 2))) * 0.38f) / ((float) this.viewPager.getMeasuredWidth());
        float scaleFactor = 1.0f - Math.abs(offsetRate);
        if (scaleFactor > 0.0f) {
            view.setScaleX(scaleFactor);
            view.setScaleY(scaleFactor);
            view.setTranslationX(((float) (-this.maxTranslateOffsetX)) * offsetRate);
        }
    }

    private int dp2px(Context context, float dipValue) {
        return (int) ((dipValue * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
