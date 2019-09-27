package com.introvd.template.xyui;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.ScrollView;

public class BounceScrollView extends ScrollView {
    private View eBY;
    private Rect eBZ = new Rect();
    private boolean eCa = false;

    /* renamed from: y */
    private float f3675y;

    public BounceScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* renamed from: U */
    public void mo36038U(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 1:
                if (aNS()) {
                    aNR();
                    this.eCa = false;
                    return;
                }
                return;
            case 2:
                float f = this.f3675y;
                float y = motionEvent.getY();
                int i = (int) (f - y);
                if (!this.eCa) {
                    i = 0;
                }
                this.f3675y = y;
                if (aNT()) {
                    if (this.eBZ.isEmpty()) {
                        this.eBZ.set(this.eBY.getLeft(), this.eBY.getTop(), this.eBY.getRight(), this.eBY.getBottom());
                    }
                    int i2 = i / 2;
                    this.eBY.layout(this.eBY.getLeft(), this.eBY.getTop() - i2, this.eBY.getRight(), this.eBY.getBottom() - i2);
                }
                this.eCa = true;
                return;
            default:
                return;
        }
    }

    public void aNR() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, (float) this.eBY.getTop(), (float) this.eBZ.top);
        translateAnimation.setDuration(200);
        this.eBY.startAnimation(translateAnimation);
        this.eBY.layout(this.eBZ.left, this.eBZ.top, this.eBZ.right, this.eBZ.bottom);
        this.eBZ.setEmpty();
    }

    public boolean aNS() {
        return !this.eBZ.isEmpty();
    }

    public boolean aNT() {
        int measuredHeight = this.eBY.getMeasuredHeight() - getHeight();
        int scrollY = getScrollY();
        return scrollY == 0 || scrollY == measuredHeight;
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() > 0) {
            this.eBY = getChildAt(0);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.eBY != null) {
            mo36038U(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }
}
