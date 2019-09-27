package com.introvd.template.camera.p229b;

import com.introvd.template.sdk.utils.p394b.C8501a;
import com.introvd.template.template.p409g.C8759b;
import com.mediarecorder.engine.QFilterParam;
import xiaoying.engine.base.QStyle;
import xiaoying.engine.base.QStyle.QEffectPropertyInfo;

/* renamed from: com.introvd.template.camera.b.d */
public class C4994d {
    private static int bPn = 100;
    private static int bPo;
    private static int[] bPp = new int[21];
    private static int bPq = 0;
    private C4996f bOJ;
    private int bPr = 11;

    public C4994d(C4996f fVar) {
        this.bOJ = fVar;
        m12786Vh();
    }

    /* renamed from: Vh */
    private void m12786Vh() {
        int i = 0;
        while (i < bPp.length) {
            try {
                bPp[0] = 0;
                i++;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        QEffectPropertyInfo[] iEPropertyInfo = QStyle.getIEPropertyInfo(C8501a.aJs().aJv(), 4899916394580672513L);
        if (iEPropertyInfo != null && iEPropertyInfo.length > 0) {
            bPn = iEPropertyInfo[0].max_value;
            bPo = iEPropertyInfo[0].min_value;
            bPq = iEPropertyInfo[0].f3719id;
            int i2 = (bPn - 0) / 20;
            bPp[0] = 0;
            bPp[20] = bPn;
            for (int i3 = 1; i3 < 20; i3++) {
                bPp[i3] = (i3 * i2) + 0;
            }
        }
    }

    /* renamed from: Vi */
    public void mo25477Vi() {
        this.bOJ.mo25552eV(C8759b.m25586by(4899916394580672513L));
        mo25480iT(this.bPr);
    }

    /* renamed from: Vj */
    public void mo25478Vj() {
        this.bOJ.mo25552eV(C8759b.m25586by(4899916394580672513L));
    }

    /* renamed from: Vk */
    public void mo25479Vk() {
        this.bOJ.mo25551eU(null);
        C5008i.m12937VU().mo25659jn(11);
        this.bPr = 11;
    }

    /* renamed from: iT */
    public void mo25480iT(int i) {
        this.bPr = i;
        if (this.bPr > 21) {
            this.bPr = 21;
        } else if (this.bPr < 1) {
            this.bPr = 1;
        }
        QFilterParam qFilterParam = new QFilterParam();
        qFilterParam.f3421id = bPq;
        int i2 = 0;
        if (this.bPr - 1 >= 0 && this.bPr - 1 < bPp.length) {
            i2 = bPp[this.bPr - 1];
        }
        m12786Vh();
        qFilterParam.value = i2;
        this.bOJ.mo25527a(qFilterParam);
        C5008i.m12937VU().mo25659jn(this.bPr);
    }
}
