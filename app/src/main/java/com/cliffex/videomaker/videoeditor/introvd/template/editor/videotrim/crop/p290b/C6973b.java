package com.introvd.template.editor.videotrim.crop.p290b;

import android.graphics.RectF;
import com.introvd.template.editor.videotrim.crop.p289a.C6969a;
import com.introvd.template.editor.videotrim.crop.p289a.C6971b;

/* renamed from: com.introvd.template.editor.videotrim.crop.b.b */
class C6973b extends C6975d {
    C6973b(C6969a aVar, C6969a aVar2) {
        super(aVar, aVar2);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo30666a(float f, float f2, float f3, RectF rectF, float f4) {
        C6971b n = mo30671n(f, f2, f3);
        C6969a aVar = n.dmA;
        C6969a aVar2 = n.dmB;
        aVar.mo30655a(f, f2, rectF, f4, f3);
        aVar2.mo30660ay(f3);
        if (aVar2.mo30661b(rectF, f4)) {
            aVar2.mo30662i(rectF);
            aVar.mo30660ay(f3);
        }
    }
}
