package com.introvd.template.module.iap.utils.animation;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.os.Build.VERSION;
import android.text.TextPaint;
import android.text.style.SuperscriptSpan;
import android.view.View;
import android.widget.TextView;
import java.lang.ref.WeakReference;

class JumpForTextSpan extends SuperscriptSpan {
    private AnimatorUpdateListener cCb = new AnimatorUpdateListener() {
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            View view = (View) JumpForTextSpan.this.dWl.get();
            if (view != null) {
                JumpForTextSpan.this.m23432a(valueAnimator, view);
            } else {
                JumpForTextSpan.this.aEQ();
            }
        }
    };
    private long dWi;
    private float dWj;
    /* access modifiers changed from: private */
    public WeakReference<TextView> dWl;
    private ValueAnimator dWm;
    private int dWn = 0;
    private long duration;

    /* renamed from: com.introvd.template.module.iap.utils.animation.JumpForTextSpan$a */
    static class C8075a implements TimeInterpolator {
        private final float dWj;

        C8075a(float f) {
            this.dWj = Math.abs(f);
        }

        public float getInterpolation(float f) {
            if (f > this.dWj) {
                return 0.0f;
            }
            return (float) Math.sin(((double) (f / this.dWj)) * 3.141592653589793d);
        }
    }

    JumpForTextSpan(TextView textView, long j, long j2, float f) {
        this.dWl = new WeakReference<>(textView);
        this.duration = j;
        this.dWi = j2;
        this.dWj = f;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m23432a(ValueAnimator valueAnimator, View view) {
        if (m23435dl(view)) {
            this.dWn = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            view.invalidate();
        }
    }

    /* renamed from: aP */
    private void m23434aP(float f) {
        if (this.dWm == null) {
            this.dWm = ValueAnimator.ofInt(new int[]{0, (int) (f / 2.0f)});
            this.dWm.setDuration(this.duration).setStartDelay(this.dWi);
            this.dWm.setInterpolator(new C8075a(this.dWj));
            this.dWm.setRepeatCount(-1);
            this.dWm.setRepeatMode(1);
            this.dWm.addUpdateListener(this.cCb);
            this.dWm.start();
        }
    }

    /* renamed from: dl */
    private boolean m23435dl(View view) {
        if (VERSION.SDK_INT >= 19) {
            return view.isAttachedToWindow();
        }
        return view.getParent() != null;
    }

    /* access modifiers changed from: 0000 */
    public void aEQ() {
        if (this.dWm != null) {
            this.dWm.cancel();
            this.dWm.removeAllUpdateListeners();
        }
        if (this.dWl.get() != null) {
            this.dWl.clear();
        }
    }

    public void updateDrawState(TextPaint textPaint) {
        m23434aP(textPaint.ascent());
        textPaint.baselineShift = this.dWn;
    }

    public void updateMeasureState(TextPaint textPaint) {
        m23434aP(textPaint.ascent());
        textPaint.baselineShift = this.dWn;
    }
}
