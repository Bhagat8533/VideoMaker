package com.introvd.template.module.p326ad.exit;

import android.arch.lifecycle.C0061e.C0062a;
import android.arch.lifecycle.C0068f;
import android.arch.lifecycle.C0078n;
import android.support.p021v4.app.FragmentActivity;
import java.util.concurrent.TimeUnit;
import p037b.p050b.C1848s;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p057e.C1517e;

/* renamed from: com.introvd.template.module.ad.exit.PanInterstitialLifecycle */
abstract class PanInterstitialLifecycle implements C0068f {
    private C1495b cTc;
    FragmentActivity dMQ;
    /* access modifiers changed from: private */
    public boolean dMR;
    /* access modifiers changed from: private */
    public boolean dMS;
    private boolean dMT;

    private void aAr() {
        if (this.dMT || !this.dMR) {
            if (this.cTc != null && !this.cTc.aAy()) {
                this.cTc.dispose();
            }
            this.cTc = C1848s.m5330j(150, TimeUnit.MILLISECONDS).mo10194f(C1487a.aUa()).mo10195g((C1517e<? super T>) new C1517e<Long>() {
                /* renamed from: i */
                public void accept(Long l) throws Exception {
                    if (PanInterstitialLifecycle.this.dMR && PanInterstitialLifecycle.this.dMS) {
                        PanInterstitialLifecycle.this.aAo();
                    }
                }
            });
            return;
        }
        aAo();
    }

    /* access modifiers changed from: 0000 */
    public abstract void aAo();

    /* access modifiers changed from: 0000 */
    @C0078n(mo161n = C0062a.ON_DESTROY)
    public void onDestroy() {
        this.dMQ.getLifecycle().mo153b(this);
    }

    /* access modifiers changed from: 0000 */
    @C0078n(mo161n = C0062a.ON_PAUSE)
    public void onPause() {
        this.dMS = false;
    }

    /* access modifiers changed from: 0000 */
    @C0078n(mo161n = C0062a.ON_RESUME)
    public void onResume() {
        this.dMS = true;
        aAr();
    }
}
