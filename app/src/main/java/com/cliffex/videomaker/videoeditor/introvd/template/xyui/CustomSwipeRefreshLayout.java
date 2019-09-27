package com.introvd.template.xyui;

import android.content.Context;
import android.support.p021v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;

public class CustomSwipeRefreshLayout extends VpSwipeRefreshLayout {
    private View eCe;

    public CustomSwipeRefreshLayout(Context context) {
        super(context);
    }

    public CustomSwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean canChildScrollUp() {
        return this.eCe != null ? ViewCompat.canScrollVertically(this.eCe, -1) : super.canChildScrollUp();
    }

    public void setScrollUpChild(View view) {
        this.eCe = view;
    }
}
