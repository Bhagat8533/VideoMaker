package com.introvd.template.starvlogs;

import android.content.Context;
import android.support.p021v4.view.ViewPager;
import android.support.p021v4.view.ViewPager.PageTransformer;
import android.view.View;

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
        float offsetRate = (((float) (((view.getLeft() - this.viewPager.getScrollX()) + (view.getMeasuredWidth() / 2)) - (this.viewPager.getMeasuredWidth() / 2))) * 0.38f) / ((float) this.viewPager.getMeasuredWidth());
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
