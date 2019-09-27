package com.introvd.template.app.p189i;

import android.graphics.Rect;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.ImageView;
import com.introvd.template.common.LogUtils;
import com.introvd.template.module.iap.business.p352b.C7834a;

/* renamed from: com.introvd.template.app.i.d */
class C4016d {
    /* access modifiers changed from: private */
    public OnScrollChangedListener btA = new OnScrollChangedListener() {
        public void onScrollChanged() {
            if (C4016d.this.m9966MI()) {
                C4016d.this.clearListener();
            }
        }
    };
    /* access modifiers changed from: private */
    public OnAttachStateChangeListener btB = new OnAttachStateChangeListener() {
        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            C4016d.this.clearListener();
        }
    };
    private ImageView btw;
    private String btx;
    private String bty;
    private OnLayoutChangeListener btz;
    private Rect rect = new Rect();

    C4016d(final ImageView imageView, String str, String str2) {
        this.btw = imageView;
        this.bty = str2;
        this.btx = str;
        imageView.addOnAttachStateChangeListener(this.btB);
        imageView.post(new Runnable() {
            public void run() {
                if (C4016d.this.m9966MI()) {
                    imageView.removeOnAttachStateChangeListener(C4016d.this.btB);
                } else if (imageView.getViewTreeObserver().isAlive()) {
                    imageView.getViewTreeObserver().addOnScrollChangedListener(C4016d.this.btA);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: MI */
    public boolean m9966MI() {
        boolean z = false;
        if (this.btw.getDrawable() == null) {
            if (this.btz == null) {
                ImageView imageView = this.btw;
                OnLayoutChangeListener MJ = m9967MJ();
                this.btz = MJ;
                imageView.addOnLayoutChangeListener(MJ);
            }
            return false;
        }
        this.btw.getLocalVisibleRect(this.rect);
        if (this.rect.top == 0 && this.rect.bottom >= (this.btw.getHeight() * 3) / 4 && this.rect.bottom <= this.btw.getHeight()) {
            z = true;
        }
        if (z) {
            LogUtils.m14222e("ShowCompleteReporter", " reportTrigger -----------------------------------");
            C7834a.m22834ay(this.btx, this.bty);
        }
        return z;
    }

    /* renamed from: MJ */
    private OnLayoutChangeListener m9967MJ() {
        return new OnLayoutChangeListener() {
            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                if (C4016d.this.m9966MI()) {
                    C4016d.this.clearListener();
                }
                LogUtils.m14222e("ShowCompleteReporter", "onLayoutChangeListener onLayoutChangeListener");
            }
        };
    }

    /* access modifiers changed from: private */
    public void clearListener() {
        this.btw.removeOnLayoutChangeListener(this.btz);
        this.btw.removeOnAttachStateChangeListener(this.btB);
        this.btw.getViewTreeObserver().removeOnScrollChangedListener(this.btA);
        LogUtils.m14222e("ShowCompleteReporter", "clearListener   clear clear clear");
    }
}
