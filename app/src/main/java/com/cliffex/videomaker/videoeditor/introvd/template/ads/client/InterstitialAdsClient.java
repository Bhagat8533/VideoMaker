package com.introvd.template.ads.client;

import android.content.Context;
import com.PinkiePie;
import com.introvd.template.ads.AbsAdGlobalMgr.AdSdk;
import com.introvd.template.ads.AdParamMgr;
import com.introvd.template.ads.ads.AbsInterstitialAds;
import com.introvd.template.ads.entity.AdPositionInfoParam;
import com.introvd.template.ads.listener.InterstitialAdsListener;

public final class InterstitialAdsClient extends BaseAdClient<AbsInterstitialAds, InterstitialAdsListener> implements InterstitialAdsListener {

    /* renamed from: com.introvd.template.ads.client.InterstitialAdsClient$a */
    private static class C3597a {
        static final InterstitialAdsClient bgG = new InterstitialAdsClient();
    }

    private InterstitialAdsClient() {
        super(2);
    }

    public static InterstitialAdsClient getInstance() {
        return C3597a.bgG;
    }

    /* access modifiers changed from: protected */
    public AbsInterstitialAds getAds(Context context, AdSdk adSdk, int i) {
        return adSdk.getInterstitialAds(context, i);
    }

    /* access modifiers changed from: protected */
    public AbsInterstitialAds getAdsFromCache(int i, int i2) {
        AbsInterstitialAds absInterstitialAds = (AbsInterstitialAds) super.getAdsFromCache(i, i2);
        if (absInterstitialAds == null || !absInterstitialAds.isValid()) {
            return null;
        }
        return absInterstitialAds;
    }

    /* access modifiers changed from: protected */
    public InterstitialAdsListener getExtendAdListener() {
        return this;
    }

    /* access modifiers changed from: protected */
    public Class<InterstitialAdsListener> getExtendAdListenerType() {
        return InterstitialAdsListener.class;
    }

    public void onAdLoaded(AdPositionInfoParam adPositionInfoParam, boolean z, String str) {
        informAction(z ? 1 : 2, adPositionInfoParam.position, String.valueOf(adPositionInfoParam.providerOrder));
    }

    @Deprecated
    public final void showAd(Context context, int i) {
        for (Integer intValue : AdParamMgr.getProviderList(i)) {
            AbsInterstitialAds adsFromCache = getAdsFromCache(i, intValue.intValue());
            if (adsFromCache != null && adsFromCache.isValid() && PinkiePie.DianePieNull()) {
                return;
            }
        }
    }
}
