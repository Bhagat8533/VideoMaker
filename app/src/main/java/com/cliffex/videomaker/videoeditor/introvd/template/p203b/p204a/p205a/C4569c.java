package com.introvd.template.p203b.p204a.p205a;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;

/* renamed from: com.introvd.template.b.a.a.c */
public class C4569c extends C4567a {
    /* access modifiers changed from: protected */
    /* renamed from: ab */
    public long mo24836ab(long j) {
        return j;
    }

    /* access modifiers changed from: protected */
    /* renamed from: cf */
    public void mo24838cf(View view) {
        mo24835SQ().playTogether(new Animator[]{ObjectAnimator.ofFloat(view, "translationX", new float[]{(float) (-view.getWidth()), -10.0f, -20.0f, -5.0f, -10.0f, 0.0f}).setDuration(this.f3414Dy)});
    }

    /* access modifiers changed from: protected */
    /* renamed from: cg */
    public void mo24839cg(View view) {
        mo24835SQ().playTogether(new Animator[]{ObjectAnimator.ofFloat(view, "translationX", new float[]{0.0f, -10.0f, (float) view.getWidth()}).setDuration(this.f3414Dy)});
    }
}
