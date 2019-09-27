package com.introvd.template.p203b.p204a.p205a;

import android.animation.AnimatorSet;
import android.view.View;

/* renamed from: com.introvd.template.b.a.a.a */
public abstract class C4567a {

    /* renamed from: Dy */
    public long f3414Dy = 700;

    /* renamed from: zV */
    private AnimatorSet f3415zV = new AnimatorSet();

    /* renamed from: SQ */
    public AnimatorSet mo24835SQ() {
        return this.f3415zV;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ab */
    public abstract long mo24836ab(long j);

    /* renamed from: ac */
    public C4567a mo24837ac(long j) {
        this.f3414Dy = j;
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: cf */
    public abstract void mo24838cf(View view);

    /* access modifiers changed from: protected */
    /* renamed from: cg */
    public abstract void mo24839cg(View view);

    /* renamed from: ch */
    public void mo24840ch(View view) {
        mo24842cj(view);
        mo24838cf(view);
        this.f3415zV.start();
    }

    /* renamed from: ci */
    public void mo24841ci(View view) {
        mo24842cj(view);
        mo24839cg(view);
        this.f3415zV.start();
    }

    /* renamed from: cj */
    public void mo24842cj(View view) {
        view.setPivotX(((float) view.getWidth()) / 2.0f);
        view.setPivotY(((float) view.getWidth()) / 2.0f);
    }

    public long getDuration() {
        return mo24836ab(this.f3414Dy);
    }
}
