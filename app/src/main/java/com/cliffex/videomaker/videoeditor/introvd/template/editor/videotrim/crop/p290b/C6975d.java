package com.introvd.template.editor.videotrim.crop.p290b;

import android.graphics.RectF;
import com.introvd.template.editor.videotrim.crop.p289a.C6969a;
import com.introvd.template.editor.videotrim.crop.p289a.C6971b;
import com.introvd.template.editor.videotrim.crop.p291c.C6978a;

/* renamed from: com.introvd.template.editor.videotrim.crop.b.d */
abstract class C6975d {
    private C6969a dmN;
    private C6969a dmO;
    private C6971b dmP = new C6971b(this.dmN, this.dmO);

    C6975d(C6969a aVar, C6969a aVar2) {
        this.dmN = aVar;
        this.dmO = aVar2;
    }

    /* renamed from: F */
    private float m20396F(float f, float f2) {
        float atF = this.dmO == C6969a.LEFT ? f : C6969a.LEFT.atF();
        float atF2 = this.dmN == C6969a.TOP ? f2 : C6969a.TOP.atF();
        if (this.dmO != C6969a.RIGHT) {
            f = C6969a.RIGHT.atF();
        }
        if (this.dmN != C6969a.BOTTOM) {
            f2 = C6969a.BOTTOM.atF();
        }
        return C6978a.m20404k(atF, atF2, f, f2);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public abstract void mo30666a(float f, float f2, float f3, RectF rectF, float f4);

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo30667a(float f, float f2, RectF rectF, float f3) {
        C6971b atG = atG();
        C6969a aVar = atG.dmA;
        C6969a aVar2 = atG.dmB;
        if (aVar != null) {
            aVar.mo30655a(f, f2, rectF, f3, 1.0f);
        }
        if (aVar2 != null) {
            aVar2.mo30655a(f, f2, rectF, f3, 1.0f);
        }
    }

    /* access modifiers changed from: 0000 */
    public C6971b atG() {
        return this.dmP;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: n */
    public C6971b mo30671n(float f, float f2, float f3) {
        if (m20396F(f, f2) > f3) {
            this.dmP.dmA = this.dmO;
            this.dmP.dmB = this.dmN;
        } else {
            this.dmP.dmA = this.dmN;
            this.dmP.dmB = this.dmO;
        }
        return this.dmP;
    }
}
