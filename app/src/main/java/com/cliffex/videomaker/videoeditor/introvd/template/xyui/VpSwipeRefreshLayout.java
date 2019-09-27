package com.introvd.template.xyui;

import android.content.Context;
import android.support.p021v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

public class VpSwipeRefreshLayout extends SwipeRefreshLayout {
    private boolean eCG;
    private final int mTouchSlop;

    /* renamed from: qZ */
    private float f3677qZ;

    /* renamed from: ra */
    private float f3678ra;

    public VpSwipeRefreshLayout(Context context) {
        super(context);
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public VpSwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.f3678ra = motionEvent.getY();
                this.f3677qZ = motionEvent.getX();
                this.eCG = false;
                break;
            case 1:
            case 3:
                this.eCG = false;
                break;
            case 2:
                if (this.eCG) {
                    return false;
                }
                float y = motionEvent.getY();
                float abs = Math.abs(motionEvent.getX() - this.f3677qZ);
                float abs2 = Math.abs(y - this.f3678ra);
                if (abs > ((float) this.mTouchSlop) && abs > abs2) {
                    this.eCG = true;
                    return false;
                }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }
}
