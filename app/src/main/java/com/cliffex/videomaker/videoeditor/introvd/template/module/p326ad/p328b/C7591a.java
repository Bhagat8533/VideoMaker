package com.introvd.template.module.p326ad.p328b;

import android.text.TextUtils;
import com.introvd.template.common.Utils;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.datacenter.SocialServiceDef;
import com.introvd.template.module.p326ad.C7678j;
import com.introvd.template.module.p326ad.p334h.C7662c;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.p131c.p132a.p135c.C2575a;
import java.util.HashMap;
import java.util.Locale;

/* renamed from: com.introvd.template.module.ad.b.a */
public class C7591a {
    /* renamed from: W */
    public static String m22370W(Object obj) {
        int i = -1;
        if (obj instanceof Integer) {
            i = ((Integer) obj).intValue();
        } else if (obj instanceof String) {
            i = C2575a.parseInt((String) obj, -1);
        }
        switch (i) {
            case 1:
                return "XYFAC";
            case 2:
                return "XYADM";
            case 3:
                return "XYMOB";
            case 4:
                return "XYPIN";
            case 5:
                return "XYALT";
            case 10:
                return "XYBAI";
            case 11:
                return "XYUCZ";
            case 12:
                return "XYWEB";
            case 14:
                return "XYBAT";
            case 17:
                return "XYBAY";
            case 20:
                return "XYMOP";
            case 21:
                return "XYPAN";
            default:
                return "Unknown";
        }
    }

    private static String aAg() {
        return C7662c.aAA().getString("key_pref_interstitial_ad_position", "unknown");
    }

    /* renamed from: au */
    public static void m22371au(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("templateId", str);
        hashMap.put(SocialServiceDef.EXTRAS_UPGRADE_FROM, C7593c.m22384c(C7594d.dMB, new String[0]));
        hashMap.put(SocialConstDef.TEMPLATELOCKINFO_ITEM_LOCK, str2);
        C7678j.aAd().mo23653g("Ad_Template_Click", hashMap);
    }

    /* renamed from: d */
    public static void m22372d(int i, int i2, String str) {
        String str2;
        HashMap hashMap = new HashMap();
        switch (i) {
            case 0:
                str2 = "Ad_request";
                break;
            case 1:
                str2 = "Ad_request_result";
                hashMap.put("result", String.valueOf(0));
                break;
            case 2:
                str2 = "Ad_request_result";
                hashMap.put("result", String.valueOf(1));
                break;
            case 3:
                str2 = "Ad_request_ignore_cache";
                break;
            default:
                str2 = null;
                break;
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("platform", m22370W(Integer.valueOf(C2575a.parseInt(str))));
            hashMap.put("language", Locale.getDefault().getLanguage());
            if (C7678j.aAd().isInChina()) {
                hashMap.put(IronSourceConstants.EVENTS_PLACEMENT_NAME, String.valueOf(i2));
                if (44 == i2) {
                    if (i != 0) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(str2);
                        sb.append("_");
                        sb.append(i2);
                        str2 = sb.toString();
                    }
                    if (2 == i || 1 == i) {
                        hashMap.remove(IronSourceConstants.EVENTS_PLACEMENT_NAME);
                    }
                }
            } else if (2 == i || 1 == i) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str2);
                sb2.append("_");
                sb2.append(i2);
                str2 = sb2.toString();
            } else {
                hashMap.put(IronSourceConstants.EVENTS_PLACEMENT_NAME, String.valueOf(i2));
            }
            if (30 == i2 && i == 0) {
                hashMap.put("position", aAg());
                C7678j aAd = C7678j.aAd();
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str2);
                sb3.append("_");
                sb3.append(30);
                aAd.mo23653g(sb3.toString(), hashMap);
            }
            C7678j.aAd().mo23653g(str2, hashMap);
        }
    }

    /* renamed from: d */
    public static void m22373d(String str, String str2, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put(SocialServiceDef.EXTRAS_UPGRADE_FROM, C7593c.m22384c(C7594d.dMB, new String[0]));
        hashMap.put("type", str2);
        hashMap.put("result", z ? "VideoAd" : "noads");
        hashMap.put(SocialConstDef.TEMPLATE_ID, str);
        C7678j.aAd().mo23653g("Ad_Video_Unlock_Click", hashMap);
        m22371au(str, "ad");
    }

    /* renamed from: kd */
    public static void m22374kd(String str) {
        C7662c.aAA().setString("encourage_ad_from_prefix", str);
    }

    /* renamed from: ke */
    public static void m22375ke(String str) {
        C7662c.aAA().setString("encourage_ad_event_from", str);
    }

    /* renamed from: kf */
    public static String m22376kf(String str) {
        return "Ad_Exit_Show".equals(str) ? "exit" : "Ad_Home_Recomm_Show".equals(str) ? "home" : "Ad_Export_Result_Show".equals(str) ? "result" : "Ad_Studio_List_Show".equals(str) ? "draft_list" : "Ad_Studio_Grid_Show".equals(str) ? "draft_grid" : "Ad_Interstitial_Show".equals(str) ? "interstitial_home" : "Ad_Gallery_Banner_Show".equals(str) ? "gallery_banner" : "Ad_New_Explore_Show".equals(str) ? "new_explore" : "Ad_Shuffle_Native_Show".equals(str) ? "shuffle" : "Ad_Savedraft_Show".equals(str) ? "draft_dialog" : "Ad_New_Theme_Show".equals(str) ? "new_theme" : "Ad_FX_Show".equals(str) ? "new_fx" : "Ad_Explore_Show".equals(str) ? "explore" : "Ad_Splash_Show".equals(str) ? "splash" : "Unknown";
    }

    /* renamed from: kg */
    public static void m22377kg(String str) {
        C7662c.aAA().setString("key_pref_interstitial_ad_position", str);
    }

    /* renamed from: kh */
    public static void m22378kh(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("channel", Utils.getMetaDataValue(C7678j.aAd().getContext(), "UMENG_CHANNEL", "googleplay"));
        String string = C7662c.aAA().getString("encourage_ad_from_prefix", "top");
        String string2 = C7662c.aAA().getString("encourage_ad_event_from", "Theme");
        String str2 = SocialServiceDef.EXTRAS_UPGRADE_FROM;
        StringBuilder sb = new StringBuilder();
        sb.append(string);
        sb.append("_");
        sb.append(string2);
        hashMap.put(str2, sb.toString());
        C7678j.aAd().mo23653g(str, hashMap);
    }
}
