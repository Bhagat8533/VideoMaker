package com.introvd.template.module.iap.business.home;

import android.text.TextUtils;
import com.introvd.template.module.iap.C7698a;
import com.introvd.template.module.iap.C8045d;
import com.introvd.template.module.iap.C8048e;
import com.introvd.template.module.iap.C8072q;
import com.introvd.template.module.iap.business.p349a.C7832c;
import com.introvd.template.module.iap.business.p356e.C7900d;
import com.p131c.p132a.p135c.C2575a;
import java.text.DecimalFormat;

/* renamed from: com.introvd.template.module.iap.business.home.g */
class C7985g {
    private final C7984f dTG;
    private final C7900d dTH = new C7900d(this.dTG.aDj());

    C7985g(String str) {
        this.dTG = C7698a.m22602kr(str);
    }

    /* renamed from: aE */
    private String m23166aE(String str, String str2) {
        C7832c lz = m23169lz(str);
        if (lz == null) {
            return null;
        }
        if (!C8048e.aBe().isInChina() && C8072q.aBx().mo33072ku(lz.getId())) {
            return null;
        }
        if (!C8048e.aBe().isInChina()) {
            float lB = m23168lB(str2);
            if (lB < 1.0f && lB > 0.0f) {
                long aCE = (long) (((float) lz.aCE()) / lB);
                lz.mo32738aM(aCE);
                float f = ((float) aCE) / 1000000.0f;
                lz.mo32748li(lz.mo32756sp().replaceAll("\\d+([,|.]*\\d*)*", new DecimalFormat("0.00").format((double) f)));
            }
        }
        if (lz.aCA() <= 0 || lz.aCA() <= lz.aCE()) {
            return null;
        }
        return lz.aCB();
    }

    /* renamed from: lA */
    private String m23167lA(String str) {
        return this.dTH.mo32861lw(str);
    }

    /* renamed from: lB */
    private float m23168lB(String str) {
        if (TextUtils.isEmpty(str)) {
            return 1.0f;
        }
        String lw = this.dTH.mo32861lw(str);
        if (TextUtils.isEmpty(lw)) {
            return 1.0f;
        }
        float d = C2575a.m7388d(lw, 1.0f);
        if (d <= 0.0f || d > 1.0f) {
            d = 1.0f;
        }
        return d;
    }

    /* renamed from: lz */
    private C7832c m23169lz(String str) {
        return C8045d.aAZ().mo33074kw(m23167lA(str));
    }

    /* access modifiers changed from: 0000 */
    public String aDt() {
        C7832c lz = m23169lz(this.dTG.aDk());
        if (lz == null) {
            return null;
        }
        return lz.mo32756sp();
    }

    /* access modifiers changed from: 0000 */
    public String aDu() {
        C7832c lz = m23169lz(this.dTG.aDl());
        if (lz == null) {
            return null;
        }
        double aCE = (((double) m23169lz(this.dTG.aDl()).aCE()) / 12.0d) / 1000000.0d;
        return lz.mo32756sp().replaceAll("\\d+([,|.]*\\d*)*", new DecimalFormat("0.00").format(aCE));
    }

    /* access modifiers changed from: 0000 */
    public String aDv() {
        return m23166aE(this.dTG.aDk(), this.dTG.aDr());
    }

    /* access modifiers changed from: 0000 */
    public String aDw() {
        return m23166aE(this.dTG.aDl(), this.dTG.aDs());
    }

    /* access modifiers changed from: 0000 */
    public String aDx() {
        return m23167lA(this.dTG.aDk());
    }

    /* access modifiers changed from: 0000 */
    public String aDy() {
        return m23167lA(this.dTG.aDl());
    }
}
