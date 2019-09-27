package com.introvd.template.module.p326ad.p330d;

import android.app.Activity;
import android.content.Context;
import com.PinkiePie;
import com.introvd.template.ads.AdParamMgr;
import com.introvd.template.ads.entity.AdPositionInfoParam;
import com.introvd.template.ads.listener.InterstitialAdsListener;
import com.introvd.template.module.p326ad.C7588a;
import com.introvd.template.module.p326ad.C7678j;
import com.introvd.template.module.p326ad.C7680l;
import com.introvd.template.module.p326ad.p327a.C7589a;
import com.introvd.template.module.p326ad.p334h.C7662c;

/* renamed from: com.introvd.template.module.ad.d.b */
public final class C7602b {
    private boolean bwf;
    private boolean dMY;
    private C7601a dMZ;
    private C7605c dNa;
    private InterstitialAdsListener dNb;

    /* renamed from: com.introvd.template.module.ad.d.b$a */
    private static final class C7604a {
        /* access modifiers changed from: private */
        public static final C7602b dNd = new C7602b();
    }

    private C7602b() {
        this.dMY = false;
        this.bwf = false;
        this.dNb = new InterstitialAdsListener() {
            public void onAdLoaded(AdPositionInfoParam adPositionInfoParam, boolean z, String str) {
                if (C7680l.aAf().mo32497rR(30)) {
                    Context context = C7678j.aAd().getContext();
                    PinkiePie.DianePie();
                }
                if (!z) {
                    C7680l.aAe().releasePosition(30);
                }
            }
        };
        this.dMZ = new C7601a();
        this.dNa = new C7605c();
    }

    public static C7602b aAs() {
        return C7604a.dNd;
    }

    /* renamed from: SS */
    public void mo32483SS() {
        Integer V = C7588a.m22357V(AdParamMgr.getExtraInfoByKey(30, "close"));
        this.dMZ.mo32482rU((V == null || V.intValue() == 0) ? 2 : V.intValue());
        Integer V2 = C7588a.m22357V(AdParamMgr.getExtraInfoByKey(30, "show"));
        this.dNa.mo32482rU(V2 == null ? 0 : V2.intValue());
    }

    /* renamed from: aD */
    public void mo32484aD(Activity activity) {
        if (C7678j.aAd().mo23622Mn() || this.dMZ.aAv() || this.dNa.aAv()) {
            C7662c.aAA().setBoolean("key_back_home_can_show", false);
            C7680l.aAe().releasePosition(30);
            return;
        }
        C7680l.aAe().mo32531h(30, this.dNb);
        if (!this.bwf || !C7678j.aAd().mo23607J(activity)) {
            this.bwf = this.dMY;
            if (!this.bwf) {
                C7662c.aAA().setBoolean("key_back_home_can_show", false);
            } else if (!C7680l.aAf().mo32497rR(30)) {
                C7680l.aAe().mo32526aj(activity, 30);
            }
            return;
        }
        C7662c.aAA().setBoolean("key_back_home_can_show", true);
    }

    /* renamed from: aE */
    public void mo32485aE(Activity activity) {
        if (this.bwf && C7678j.aAd().mo23607J(activity)) {
            this.bwf = false;
        }
    }

    /* renamed from: gn */
    public void mo32486gn(Context context) {
        if (C7662c.aAA().getBoolean("key_back_home_can_show", false)) {
            if (C7680l.aAf().mo32497rR(30)) {
                C7589a.m22360aj(context, 30);
            } else {
                C7662c.aAA().setBoolean("key_back_home_can_show", false);
                PinkiePie.DianePie();
            }
        }
    }

    /* renamed from: iy */
    public void mo32487iy(boolean z) {
        this.dMY = z;
    }
}
