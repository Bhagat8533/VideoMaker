package com.introvd.template.gallery.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.introvd.template.common.p236ui.XYViewPager;

public class ExtendedViewPager extends XYViewPager {
    public ExtendedViewPager(Context context) {
        super(context);
    }

    public ExtendedViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public boolean canScroll(View view, boolean z, int i, int i2, int i3) {
        return view instanceof TouchImageView ? ((TouchImageView) view).mo32250rI(-i) : super.canScroll(view, z, i, i2, i3);
    }
}
