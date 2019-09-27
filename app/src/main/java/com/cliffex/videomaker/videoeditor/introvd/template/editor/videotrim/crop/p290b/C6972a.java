package com.introvd.template.editor.videotrim.crop.p290b;

import android.graphics.RectF;
import com.introvd.template.editor.videotrim.crop.p289a.C6969a;

/* renamed from: com.introvd.template.editor.videotrim.crop.b.a */
class C6972a extends C6975d {
    C6972a() {
        super(null, null);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo30666a(float f, float f2, float f3, RectF rectF, float f4) {
        mo30667a(f, f2, rectF, f4);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo30667a(float f, float f2, RectF rectF, float f3) {
        float atF = C6969a.LEFT.atF();
        float atF2 = C6969a.TOP.atF();
        float atF3 = f - ((atF + C6969a.RIGHT.atF()) / 2.0f);
        float atF4 = f2 - ((atF2 + C6969a.BOTTOM.atF()) / 2.0f);
        C6969a.LEFT.mo30659ax(atF3);
        C6969a.TOP.mo30659ax(atF4);
        C6969a.RIGHT.mo30659ax(atF3);
        C6969a.BOTTOM.mo30659ax(atF4);
        if (C6969a.LEFT.mo30661b(rectF, f3)) {
            C6969a.RIGHT.mo30659ax(C6969a.LEFT.mo30662i(rectF));
        } else if (C6969a.RIGHT.mo30661b(rectF, f3)) {
            C6969a.LEFT.mo30659ax(C6969a.RIGHT.mo30662i(rectF));
        }
        if (C6969a.TOP.mo30661b(rectF, f3)) {
            C6969a.BOTTOM.mo30659ax(C6969a.TOP.mo30662i(rectF));
        } else if (C6969a.BOTTOM.mo30661b(rectF, f3)) {
            C6969a.TOP.mo30659ax(C6969a.BOTTOM.mo30662i(rectF));
        }
    }
}
