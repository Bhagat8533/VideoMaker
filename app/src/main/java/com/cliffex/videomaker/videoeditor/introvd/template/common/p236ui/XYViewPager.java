package com.introvd.template.common.p236ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.introvd.template.crash.C5523b;

/* renamed from: com.introvd.template.common.ui.XYViewPager */
public class XYViewPager extends RtlViewPager {
    private boolean cgn = true;

    public XYViewPager(Context context) {
        super(context);
    }

    public XYViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.cgn) {
            try {
                return super.onInterceptTouchEvent(motionEvent);
            } catch (Exception e) {
                C5523b.logException(e);
            }
        }
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.cgn) {
            try {
                return super.onTouchEvent(motionEvent);
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public void setCanScroll(boolean z) {
        this.cgn = z;
    }
}
