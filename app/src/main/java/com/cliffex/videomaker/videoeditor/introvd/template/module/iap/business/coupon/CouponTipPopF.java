package com.introvd.template.module.iap.business.coupon;

import android.app.Activity;
import android.arch.lifecycle.C0061e.C0062a;
import android.arch.lifecycle.C0068f;
import android.arch.lifecycle.C0069g;
import android.arch.lifecycle.C0078n;
import com.introvd.template.module.iap.C8048e;
import com.quvideo.priority.p217a.C4892c;

public class CouponTipPopF extends C4892c {
    private CouponTipLifeCycleObserver dQR = new CouponTipLifeCycleObserver();

    private class CouponTipLifeCycleObserver implements C0068f {
        private C0069g bqs;
        private boolean bqt;

        private CouponTipLifeCycleObserver() {
            this.bqt = true;
        }

        /* access modifiers changed from: private */
        /* renamed from: j */
        public void m22885j(C0069g gVar) {
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
                CouponTipPopF.this.mo25344EW();
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: p */
    public boolean mo23396p(Activity activity) {
        if (!(activity instanceof C0069g) || C8048e.aBe().isYoungerMode()) {
            return false;
        }
        C0069g gVar = (C0069g) activity;
        this.dQR.m22885j(gVar);
        gVar.getLifecycle().mo152a(this.dQR);
        boolean gp = C7868i.m22933gp(activity);
        if (!gp) {
            gVar.getLifecycle().mo153b(this.dQR);
        }
        return gp;
    }
}
