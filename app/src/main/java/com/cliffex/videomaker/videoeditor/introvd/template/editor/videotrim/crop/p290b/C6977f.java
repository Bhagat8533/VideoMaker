package com.introvd.template.editor.videotrim.crop.p290b;

import android.graphics.RectF;
import com.introvd.template.editor.videotrim.crop.p289a.C6969a;
import com.introvd.template.editor.videotrim.crop.p291c.C6978a;

/* renamed from: com.introvd.template.editor.videotrim.crop.b.f */
class C6977f extends C6975d {
    private C6969a dmQ;

    C6977f(C6969a aVar) {
        super(null, aVar);
        this.dmQ = aVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo30666a(float f, float f2, float f3, RectF rectF, float f4) {
        this.dmQ.mo30655a(f, f2, rectF, f4, f3);
        float atF = C6969a.TOP.atF();
        float H = (C6978a.m20403H(C6969a.getWidth(), f3) - C6969a.getHeight()) / 2.0f;
        float atF2 = C6969a.BOTTOM.atF() + H;
        C6969a.TOP.mo30658aw(atF - H);
        C6969a.BOTTOM.mo30658aw(atF2);
        if (C6969a.TOP.mo30661b(rectF, f4) && !this.dmQ.mo30656a(C6969a.TOP, rectF, f3)) {
            C6969a.BOTTOM.mo30659ax(-C6969a.TOP.mo30662i(rectF));
            this.dmQ.mo30660ay(f3);
        }
        if (C6969a.BOTTOM.mo30661b(rectF, f4) && !this.dmQ.mo30656a(C6969a.BOTTOM, rectF, f3)) {
            C6969a.TOP.mo30659ax(-C6969a.BOTTOM.mo30662i(rectF));
            this.dmQ.mo30660ay(f3);
        }
    }
}
