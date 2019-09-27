package com.introvd.template.app.homepage.pop;

import android.app.Activity;
import android.arch.lifecycle.C0061e.C0062a;
import android.arch.lifecycle.C0068f;
import android.arch.lifecycle.C0069g;
import android.arch.lifecycle.C0078n;
import com.introvd.template.app.ads.C3722f;
import com.introvd.template.app.youngermode.C4560d;
import com.p131c.p132a.C2561a;
import com.quvideo.priority.p217a.C4892c;

public class HomeInterstitialPopF extends C4892c {
    private HomeInterstitialLifeCycleObserver bsy = new HomeInterstitialLifeCycleObserver();

    private class HomeInterstitialLifeCycleObserver implements C0068f {
        private C0069g bqs;
        private boolean bqt;

        private HomeInterstitialLifeCycleObserver() {
            this.bqt = true;
        }

        /* access modifiers changed from: private */
        /* renamed from: j */
        public void m9849j(C0069g gVar) {
            this.bqs = gVar;
        }

        @C0078n(mo161n = C0062a.ON_PAUSE)
        public void onPause() {
            this.bqt = false;
        }

        @C0078n(mo161n = C0062a.ON_RESUME)
        public void onResume() {
            if (!this.bqt) {
                if (this.bqs != null) {
                    this.bqs.getLifecycle().mo153b(this);
                }
                HomeInterstitialPopF.this.mo25344EW();
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: p */
    public boolean mo23396p(Activity activity) {
        if (C2561a.aON() || !(activity instanceof C0069g) || C4560d.m11516RN().isYoungerMode()) {
            return false;
        }
        boolean C = C3722f.m9036C(activity);
        C0069g gVar = (C0069g) activity;
        this.bsy.m9849j(gVar);
        gVar.getLifecycle().mo152a(this.bsy);
        if (!C) {
            gVar.getLifecycle().mo153b(this.bsy);
        }
        return C;
    }

    /* renamed from: sb */
    public int mo23397sb() {
        return 94;
    }
}
