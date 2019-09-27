package com.introvd.template.p203b.p204a.p205a;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;

/* renamed from: com.introvd.template.b.a.a.d */
public class C4570d extends C4567a {
    /* access modifiers changed from: protected */
    /* renamed from: ab */
    public long mo24836ab(long j) {
        return j;
    }

    /* access modifiers changed from: protected */
    /* renamed from: cf */
    public void mo24838cf(View view) {
        mo24835SQ().playTogether(new Animator[]{ObjectAnimator.ofFloat(view, "translationY", new float[]{(float) (-view.getHeight()), 0.0f}).setDuration(this.f3414Dy)});
    }

    /* access modifiers changed from: protected */
    /* renamed from: cg */
    public void mo24839cg(View view) {
        mo24835SQ().playTogether(new Animator[]{ObjectAnimator.ofFloat(view, "translationY", new float[]{0.0f, (float) (-view.getHeight())}).setDuration(this.f3414Dy)});
    }
}
