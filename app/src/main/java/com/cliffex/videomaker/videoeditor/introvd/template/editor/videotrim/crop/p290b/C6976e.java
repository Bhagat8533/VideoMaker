package com.introvd.template.editor.videotrim.crop.p290b;

import android.graphics.RectF;
import com.introvd.template.editor.videotrim.crop.p289a.C6969a;
import com.introvd.template.editor.videotrim.crop.p291c.C6978a;

/* renamed from: com.introvd.template.editor.videotrim.crop.b.e */
class C6976e extends C6975d {
    private C6969a dmQ;

    C6976e(C6969a aVar) {
        super(aVar, null);
        this.dmQ = aVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo30666a(float f, float f2, float f3, RectF rectF, float f4) {
        this.dmQ.mo30655a(f, f2, rectF, f4, f3);
        float atF = C6969a.LEFT.atF();
        float G = (C6978a.m20402G(C6969a.getHeight(), f3) - C6969a.getWidth()) / 2.0f;
        float atF2 = C6969a.RIGHT.atF() + G;
        C6969a.LEFT.mo30658aw(atF - G);
        C6969a.RIGHT.mo30658aw(atF2);
        if (C6969a.LEFT.mo30661b(rectF, f4) && !this.dmQ.mo30656a(C6969a.LEFT, rectF, f3)) {
            C6969a.RIGHT.mo30659ax(-C6969a.LEFT.mo30662i(rectF));
            this.dmQ.mo30660ay(f3);
        }
        if (C6969a.RIGHT.mo30661b(rectF, f4) && !this.dmQ.mo30656a(C6969a.RIGHT, rectF, f3)) {
            C6969a.LEFT.mo30659ax(-C6969a.RIGHT.mo30662i(rectF));
            this.dmQ.mo30660ay(f3);
        }
    }
}
