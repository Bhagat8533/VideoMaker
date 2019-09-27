package com.introvd.template.editor.videotrim.crop.p290b;

import android.graphics.RectF;
import com.introvd.template.editor.videotrim.crop.p289a.C6969a;

/* renamed from: com.introvd.template.editor.videotrim.crop.b.c */
public enum C6974c {
    TOP_LEFT(new C6973b(C6969a.TOP, C6969a.LEFT)),
    TOP_RIGHT(new C6973b(C6969a.TOP, C6969a.RIGHT)),
    BOTTOM_LEFT(new C6973b(C6969a.BOTTOM, C6969a.LEFT)),
    BOTTOM_RIGHT(new C6973b(C6969a.BOTTOM, C6969a.RIGHT)),
    LEFT(new C6977f(C6969a.LEFT)),
    TOP(new C6976e(C6969a.TOP)),
    RIGHT(new C6977f(C6969a.RIGHT)),
    BOTTOM(new C6976e(C6969a.BOTTOM)),
    CENTER(new C6972a());
    
    private C6975d dmL;

    private C6974c(C6975d dVar) {
        this.dmL = dVar;
    }

    /* renamed from: a */
    public void mo30668a(float f, float f2, float f3, RectF rectF, float f4) {
        this.dmL.mo30666a(f, f2, f3, rectF, f4);
    }

    /* renamed from: a */
    public void mo30669a(float f, float f2, RectF rectF, float f3) {
        this.dmL.mo30667a(f, f2, rectF, f3);
    }
}
