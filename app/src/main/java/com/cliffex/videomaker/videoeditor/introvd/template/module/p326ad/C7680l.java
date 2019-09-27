package com.introvd.template.module.p326ad;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.introvd.template.ads.AdParamMgr;
import com.introvd.template.ads.entity.AdPositionInfoParam;
import com.introvd.template.ads.listener.InterstitialAdsListener;
import com.introvd.template.ads.listener.VideoRewardListener;
import com.introvd.template.ads.listener.ViewAdsListener;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.datacenter.SocialServiceDef;
import com.introvd.template.module.p326ad.exit.C7624a;
import com.introvd.template.module.p326ad.p328b.C7591a;
import com.introvd.template.module.p326ad.p328b.C7592b;
import com.introvd.template.module.p326ad.p330d.C7602b;
import com.introvd.template.module.p326ad.p334h.C7662c;
import com.introvd.template.module.p326ad.p337i.C7665a;
import com.introvd.template.router.editor.EditorRouter;
import java.util.HashMap;

/* renamed from: com.introvd.template.module.ad.l */
public class C7680l implements C7607e {
    private static final C7680l dMl = new C7680l();
    private static int dMm = 2;

    public static C7640f aAe() {
        return dMl;
    }

    public static C7607e aAf() {
        return dMl;
    }

    /* renamed from: ay */
    private void m22515ay(final Activity activity) {
        mo32531h(17, new InterstitialAdsListener() {
            public void onAdLoaded(AdPositionInfoParam adPositionInfoParam, boolean z, String str) {
                if (C7680l.this.mo32497rR(17)) {
                    C7680l.this.mo32527ak(activity, 17);
                }
            }
        });
        if (!mo32497rR(17)) {
            mo32527ak(activity, 17);
        } else {
            mo32527ak(activity, 17);
        }
    }

    /* renamed from: az */
    private void m22516az(Activity activity) {
        C7678j aAd = C7678j.aAd();
        View adView = getAdView(activity, 17);
        if (adView != null) {
            try {
                C7665a aVar = new C7665a(activity, 17);
                aVar.mo32558d((OnClickListener) null);
                aVar.show();
            } catch (Exception e) {
                aAd.logException(e);
            }
            HashMap hashMap = new HashMap();
            hashMap.put("frequency", String.valueOf(2 - dMm));
            hashMap.put(SocialServiceDef.EXTRAS_UPGRADE_FROM, C7662c.aAA().getString("key_preferences_draft_dialog_source", EditorRouter.ENTRANCE_EDIT));
            String W = C7591a.m22370W(adView.getTag());
            hashMap.put("platform", W);
            aAd.mo23653g("Ad_Savedraft_Show", hashMap);
            C7592b.m22379F(aAd.getContext(), "Ad_Savedraft_Show", W);
            dMm--;
        }
    }

    /* renamed from: a */
    public void mo32521a(Activity activity, int i, VideoRewardListener videoRewardListener) {
        C7682m.m22534a(activity, i, videoRewardListener);
    }

    /* renamed from: a */
    public void mo32522a(ViewAdsListener viewAdsListener) {
        C7682m.m22535a(viewAdsListener);
    }

    /* renamed from: a */
    public boolean mo32489a(Activity activity, Runnable runnable) {
        return C7624a.m22421a(activity, runnable);
    }

    public int aAa() {
        return C7682m.aAa();
    }

    public void aAb() {
        C7682m.aAb();
    }

    public boolean aAc() {
        return C7682m.aAc();
    }

    /* renamed from: aj */
    public void mo32526aj(Context context, int i) {
        C7682m.m22536aj(context, i);
    }

    /* renamed from: ak */
    public void mo32527ak(Context context, int i) {
        C7682m.m22537ak(context, i);
    }

    /* renamed from: aw */
    public void mo32490aw(Activity activity) {
        if (AppPreferencesSetting.getInstance().getAppSettingBoolean("key_preferences_studio_ad_draft_dialog", false) && dMm > 0) {
            int adType = AdParamMgr.getAdType(17);
            if (2 == adType) {
                m22515ay(activity);
            } else if (adType == 0) {
                m22516az(activity);
            }
            mo32494it(false);
        }
    }

    /* renamed from: ax */
    public boolean mo32491ax(Activity activity) {
        return C7624a.m22425ax(activity);
    }

    public boolean azZ() {
        return dMm > 0;
    }

    public View getAdView(Context context, int i) {
        return C7682m.getAdView(context, i);
    }

    /* renamed from: gk */
    public void mo32493gk(Context context) {
        C7624a.m22429gk(context);
    }

    /* renamed from: gl */
    public void mo32529gl(Context context) {
        C7682m.m22538gl(context);
    }

    /* renamed from: gm */
    public View mo32530gm(Context context) {
        return C7682m.m22539gm(context);
    }

    /* renamed from: h */
    public void mo32531h(int i, Object obj) {
        C7682m.m22540h(i, obj);
    }

    public boolean isAdAvailable(Context context, int i) {
        return C7682m.isAdAvailable(context, i);
    }

    /* renamed from: it */
    public void mo32494it(boolean z) {
        AppPreferencesSetting.getInstance().setAppSettingBoolean("key_preferences_studio_ad_draft_dialog", z);
    }

    /* renamed from: iu */
    public void mo32495iu(boolean z) {
        C7602b.aAs().mo32487iy(z);
    }

    /* renamed from: kc */
    public void mo32496kc(String str) {
        C7662c.aAA().setString("key_preferences_draft_dialog_source", str);
    }

    /* renamed from: rR */
    public boolean mo32497rR(int i) {
        return C7678j.aAd().isInChina();
    }

    /* renamed from: rS */
    public void mo32533rS(int i) {
        C7682m.m22541rS(i);
    }

    public void releasePosition(int i) {
        C7682m.releasePosition(i);
    }

    public void releasePosition(int i, boolean z) {
        C7682m.releasePosition(i, z);
    }
}
