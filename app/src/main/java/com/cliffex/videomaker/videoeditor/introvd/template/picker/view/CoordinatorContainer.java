package com.introvd.template.picker.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.OverScroller;
import com.introvd.template.common.LogUtils;
import com.introvd.template.picker.C8171a;
import com.introvd.template.picker.p366b.C8188a;
import com.introvd.template.picker.p369d.C8218b;
import p503cz.msebera.android.httpclient.HttpStatus;

public class CoordinatorContainer extends LinearLayout implements C8188a {
    private Context context;
    private float dZA;
    private boolean dZB;
    private C8246a dZC;
    private int dZv;
    private int dZw;
    private int dZx;
    private int dZy;
    private int dZz;
    private int state;

    /* renamed from: wH */
    private OverScroller f3569wH;

    /* renamed from: com.introvd.template.picker.view.CoordinatorContainer$a */
    public interface C8246a {
        /* renamed from: dv */
        void mo33257dv(int i, int i2);

        void onStateChanged(int i);
    }

    public CoordinatorContainer(Context context2) {
        this(context2, null);
    }

    public CoordinatorContainer(Context context2, AttributeSet attributeSet) {
        this(context2, attributeSet, 0);
    }

    public CoordinatorContainer(Context context2, AttributeSet attributeSet, int i) {
        super(context2, attributeSet, i);
        this.state = 0;
        this.context = context2;
        init();
    }

    private int getScrollRange() {
        return this.dZz;
    }

    private void init() {
        this.f3569wH = new OverScroller(this.context);
    }

    /* renamed from: a */
    public boolean mo33302a(int i, int i2, int i3, int i4, boolean z) {
        if (i2 < this.dZw && this.state == 0 && getScrollY() < getScrollRange()) {
            this.dZB = true;
            setScrollY(this.dZw - i2);
            return true;
        } else if (!z || this.state != 1 || i4 >= 0) {
            return false;
        } else {
            this.dZB = true;
            setScrollY(this.dZz + i4);
            return true;
        }
    }

    public boolean aFA() {
        return this.dZB;
    }

    public void aFB() {
        if (this.state == 0) {
            if (getScrollY() >= this.dZx) {
                aFX();
            } else {
                aFW();
            }
        } else if (this.state != 1) {
        } else {
            if (getScrollY() <= this.dZy) {
                aFW();
            } else {
                aFX();
            }
        }
    }

    public void aFW() {
        if (!this.f3569wH.isFinished()) {
            this.f3569wH.abortAnimation();
        }
        this.f3569wH.startScroll(0, getScrollY(), 0, -getScrollY(), HttpStatus.SC_INTERNAL_SERVER_ERROR);
        postInvalidate();
        this.state = 0;
        this.dZB = false;
        if (this.dZC != null) {
            this.dZC.onStateChanged(0);
        }
    }

    public void aFX() {
        if (!this.f3569wH.isFinished()) {
            this.f3569wH.abortAnimation();
        }
        this.f3569wH.startScroll(0, getScrollY(), 0, getScrollRange() - getScrollY(), HttpStatus.SC_INTERNAL_SERVER_ERROR);
        postInvalidate();
        this.state = 1;
        this.dZB = false;
        if (this.dZC != null) {
            this.dZC.onStateChanged(1);
        }
    }

    public void computeScroll() {
        if (this.f3569wH.computeScrollOffset()) {
            setScrollY(this.f3569wH.getCurrY());
            postInvalidate();
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            int rawY = (int) motionEvent.getRawY();
            if (this.state == 0 && rawY < this.dZv + C8218b.m23733gH(getContext()).widthPixels) {
                return false;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public int getState() {
        return this.state;
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        StringBuilder sb = new StringBuilder();
        sb.append("onScrollChanged--->>>Y:");
        sb.append(i2);
        sb.append(",oldY:");
        sb.append(i4);
        LogUtils.m14223i("Coordinator", sb.toString());
        if (this.dZC != null) {
            this.dZC.mo33257dv(i2, i4);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int rawY = (int) motionEvent.getRawY();
        switch (action) {
            case 0:
                this.dZA = (float) rawY;
                break;
            case 1:
            case 3:
                if (this.dZB) {
                    aFB();
                    return true;
                }
                break;
            case 2:
                int i = (int) (this.dZA - ((float) rawY));
                if (this.state == 1 && i < 0) {
                    this.dZB = true;
                    setScrollY(this.dZz + i);
                    break;
                }
        }
        return true;
    }

    public void setCoordinatorStateListener(C8246a aVar) {
        this.dZC = aVar;
    }

    public void setTopViewParam(int i, int i2) {
        this.dZw = i;
        this.dZv = i2;
        this.dZz = (i - i2) - C8171a.dXK;
        this.dZx = i / 4;
        this.dZy = this.dZz - this.dZx;
    }
}
