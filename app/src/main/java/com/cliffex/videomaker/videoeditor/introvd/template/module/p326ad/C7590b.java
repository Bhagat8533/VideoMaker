package com.introvd.template.module.p326ad;

import android.content.Context;
import com.introvd.template.ads.AdParamMgr;
import com.introvd.template.module.p326ad.p334h.C7662c;
import com.introvd.template.router.iap.IapServiceProxy;
import com.p131c.p132a.p135c.C2575a;

/* renamed from: com.introvd.template.module.ad.b */
public class C7590b {
    private static long azY() {
        Integer V = C7588a.m22357V(AdParamMgr.getExtraInfoByKey(42, "availabletime"));
        if (V == null || V.intValue() <= 0) {
            V = Integer.valueOf(1);
        }
        return ((long) (V.intValue() * 24 * 60 * 60)) * 1000;
    }

    /* renamed from: gh */
    public static void m22365gh(Context context) {
        AdHelperActivity.m22355ai(context, 101);
    }

    /* renamed from: gi */
    public static void m22366gi(Context context) {
        IapServiceProxy.launchVipHome(context, 3, "Ad remove", -1);
    }

    /* renamed from: gj */
    public static boolean m22367gj(Context context) {
        int adType = AdParamMgr.getAdType(42);
        if (adType == 3) {
            if (C7680l.aAe().getAdView(context, 42) == null || !C7678j.aAd().mo23619Mk()) {
                return false;
            }
        } else if (adType != 1) {
            return false;
        } else {
            if (!C7680l.aAe().isAdAvailable(context, 42) && !C7678j.aAd().mo23619Mk()) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: rQ */
    public static boolean m22368rQ(int i) {
        C7662c aAA = C7662c.aAA();
        StringBuilder sb = new StringBuilder();
        sb.append("key_pref_removed_ad");
        sb.append(i);
        try {
            return System.currentTimeMillis() - C2575a.parseLong(aAA.getString(sb.toString(), "0")) < azY();
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    /* renamed from: t */
    public static void m22369t(int... iArr) {
        if (iArr != null && iArr.length != 0) {
            String valueOf = String.valueOf(System.currentTimeMillis());
            for (int i : iArr) {
                C7662c aAA = C7662c.aAA();
                StringBuilder sb = new StringBuilder();
                sb.append("key_pref_removed_ad");
                sb.append(i);
                aAA.setString(sb.toString(), valueOf);
            }
        }
    }
}
