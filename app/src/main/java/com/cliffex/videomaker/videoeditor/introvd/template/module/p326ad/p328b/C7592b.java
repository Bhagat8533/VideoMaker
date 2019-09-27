package com.introvd.template.module.p326ad.p328b;

import android.content.Context;
import android.os.Bundle;
import com.introvd.template.datacenter.SocialServiceDef;
import com.introvd.template.module.p326ad.C7678j;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.HashMap;
import java.util.Locale;

/* renamed from: com.introvd.template.module.ad.b.b */
public class C7592b {
    /* renamed from: F */
    public static void m22379F(Context context, String str, String str2) {
        if (context != null) {
            if (!C7678j.aAd().isInChina()) {
                str = C7591a.m22376kf(str);
            }
            HashMap hashMap = new HashMap();
            hashMap.put("platform", str2);
            hashMap.put(IronSourceConstants.EVENTS_PLACEMENT_NAME, str);
            C7678j.aAd().mo23653g("Ad_Total_Impression", hashMap);
            Bundle bundle = new Bundle();
            bundle.putString("platform", str2);
            bundle.putString(IronSourceConstants.EVENTS_PLACEMENT_NAME, str);
            C7678j.aAd().mo23652f("Ad_Total_Impression", bundle);
        }
    }

    /* renamed from: G */
    public static void m22380G(Context context, String str, String str2) {
        if (context != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("platform", str2);
            hashMap.put(IronSourceConstants.EVENTS_PLACEMENT_NAME, str);
            C7678j.aAd().mo23653g("Ad_Total_Click", hashMap);
            Bundle bundle = new Bundle();
            bundle.putString("platform", str2);
            bundle.putString(IronSourceConstants.EVENTS_PLACEMENT_NAME, str);
            if ("XYFAC".equals(str2)) {
                C7678j.aAd().mo23646dC("xyfac_ad_click");
            } else if ("XYMOP".equals(str2)) {
                C7678j.aAd().mo23646dC("xymop_ad_click");
            } else if ("XYADM".equals(str2)) {
                C7678j.aAd().mo23646dC("xyadm_ad_click");
            }
            C7678j.aAd().mo23652f("Ad_Total_Click", bundle);
        }
    }

    public static void aAh() {
        HashMap hashMap = new HashMap();
        hashMap.put("language", Locale.getDefault().getLanguage());
        C7678j.aAd().mo23653g("Ad_show_43", hashMap);
    }

    /* renamed from: ki */
    public static void m22381ki(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(SocialServiceDef.EXTRAS_UPGRADE_FROM, str);
        C7678j.aAd().mo23653g("Ad_Dia_Close_Show", hashMap);
    }

    /* renamed from: kj */
    public static void m22382kj(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", str);
        C7678j.aAd().mo23653g("Ad_Dia_Close_Click", hashMap);
    }
}
