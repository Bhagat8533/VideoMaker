package com.introvd.template.app.ads;

import android.app.Activity;
import android.content.Context;
import com.introvd.template.ads.AdParamMgr;
import com.introvd.template.ads.entity.AdPositionInfoParam;
import com.introvd.template.ads.listener.InterstitialAdsListener;
import com.introvd.template.app.p177b.C3742b;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.component.videofetcher.utils.C5489g;
import com.introvd.template.module.iap.C8049f;
import com.introvd.template.module.p326ad.C7680l;
import com.introvd.template.module.p326ad.p334h.C7662c;
import com.p131c.p132a.p135c.C2575a;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import org.json.JSONObject;

/* renamed from: com.introvd.template.app.ads.f */
public class C3722f {
    /* access modifiers changed from: private */
    public static boolean bjv;

    /* renamed from: C */
    public static boolean m9036C(Activity activity) {
        if (C8049f.aBf().aBo() || !m9038Id() || activity == null || activity.isFinishing() || !m9039Ie()) {
            return false;
        }
        if (!(C7680l.aAe().isAdAvailable(activity, 48) || bjv)) {
            return false;
        }
        m9037D(activity);
        return true;
    }

    /* renamed from: D */
    private static void m9037D(Activity activity) {
        m9043go(m9040If() + 1);
        C7680l.aAe().mo32527ak(activity, 48);
    }

    /* renamed from: Id */
    private static boolean m9038Id() {
        return C3742b.m9111II().mo23144JL() && !AppStateModel.getInstance().isInChina();
    }

    /* renamed from: Ie */
    private static boolean m9039Ie() {
        int If = m9040If();
        int parseInt = C2575a.parseInt(String.valueOf(AdParamMgr.getExtraInfoByKey(48, "show")).trim().replaceAll("\\D", "0"), 0);
        StringBuilder sb = new StringBuilder();
        sb.append("------- showHomeInterstitialAd ===");
        sb.append(If);
        sb.append("   ");
        sb.append(parseInt);
        C5489g.m14903e("HomeInterstitialHelper", sb.toString());
        return If < parseInt;
    }

    /* renamed from: If */
    private static int m9040If() {
        try {
            String string = C7662c.aAA().getString("show_times", "{}");
            C5489g.m14903e("dayTimesJson", string);
            return new JSONObject(string).optInt(m9041Ig(), 0);
        } catch (Exception e) {
            C7662c.aAA().setString("show_times", null);
            e.printStackTrace();
            return 0;
        }
    }

    /* renamed from: Ig */
    private static String m9041Ig() {
        return new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(Calendar.getInstance().getTime());
    }

    /* renamed from: bQ */
    public static void m9042bQ(final Context context) {
        if (!C8049f.aBf().aBo() && m9038Id()) {
            C3712c.m9010HP().mo23064HQ();
            if (m9039Ie()) {
                C5489g.m14903e("HomeInterstitialHelper", " loadAd  loadAd  loadAd  loadAd  loadAd ===");
                C7680l.aAe().mo32531h(48, new InterstitialAdsListener() {
                    public void onAdLoaded(AdPositionInfoParam adPositionInfoParam, boolean z, String str) {
                        C3722f.bjv = z;
                    }
                });
                C7680l.aAe().mo32526aj(context, 48);
            }
        }
    }

    /* renamed from: go */
    private static void m9043go(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("{\"");
        sb.append(m9041Ig());
        sb.append("\":");
        sb.append(i);
        sb.append("}");
        C7662c.aAA().setString("show_times", sb.toString());
    }
}
