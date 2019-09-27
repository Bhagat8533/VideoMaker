package com.introvd.template.module.p326ad.p328b;

import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.datacenter.SocialServiceDef;
import com.introvd.template.module.p326ad.C7678j;
import com.unity3d.ads.metadata.InAppPurchaseMetaData;
import java.util.HashMap;

/* renamed from: com.introvd.template.module.ad.b.e */
public class C7595e {
    /* renamed from: av */
    public static void m22386av(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put(SocialServiceDef.EXTRAS_UPGRADE_FROM, C7593c.m22384c(C7594d.dMB, new String[0]));
        hashMap.put("type", str2);
        hashMap.put(SocialConstDef.TEMPLATE_ID, str);
        C7678j.aAd().mo23653g(" Ad_IAP_Unlock_Click", hashMap);
        C7591a.m22371au(str, InAppPurchaseMetaData.IAP_KEY);
    }
}
