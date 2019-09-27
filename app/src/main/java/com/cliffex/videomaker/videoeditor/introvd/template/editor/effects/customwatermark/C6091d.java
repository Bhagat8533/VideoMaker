package com.introvd.template.editor.effects.customwatermark;

import com.introvd.template.module.iap.C8049f;
import com.introvd.template.module.iap.C8072q;
import com.introvd.template.module.iap.business.p349a.C7825a;

/* renamed from: com.introvd.template.editor.effects.customwatermark.d */
public class C6091d {
    private static volatile C6091d cJI;
    private C6096h cJG;

    private C6091d() {
    }

    public static C6091d ajW() {
        if (cJI == null) {
            synchronized (C6091d.class) {
                if (cJI == null) {
                    cJI = new C6091d();
                }
            }
        }
        return cJI;
    }

    /* renamed from: a */
    public void mo28829a(C6096h hVar) {
        this.cJG = hVar;
    }

    public C6096h ajX() {
        if (!C8049f.aBf().aBr() || C8072q.aBx().mo33072ku(C7825a.USER_WATER_MARK.getId())) {
            return this.cJG;
        }
        return null;
    }

    public boolean ajY() {
        return this.cJG != null;
    }
}
