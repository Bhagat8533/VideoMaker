package com.introvd.template.module.p326ad;

import android.app.Activity;
import android.view.View;

/* renamed from: com.introvd.template.module.ad.j */
public class C7678j extends C7643g implements C7600d {
    private static C7600d dMj = new C7653h();
    private static C7678j dMk = null;

    public C7678j(C7597c cVar) {
        super(cVar);
    }

    /* renamed from: a */
    public static void m22512a(C7600d dVar) {
        dMj = dVar;
        dMk = new C7678j(dVar);
    }

    public static C7678j aAd() {
        if (dMk == null) {
            dMk = new C7678j(dMj);
        }
        return dMk;
    }

    /* renamed from: J */
    public boolean mo23607J(Activity activity) {
        return dMj.mo23607J(activity);
    }

    /* renamed from: Mh */
    public View mo23617Mh() {
        return dMj.mo23617Mh();
    }

    public boolean isYoungerMode() {
        return dMj.isYoungerMode();
    }
}
