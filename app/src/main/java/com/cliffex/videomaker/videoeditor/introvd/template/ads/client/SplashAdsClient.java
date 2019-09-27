package com.introvd.template.ads.client;

import android.content.Context;
import com.introvd.template.ads.AbsAdGlobalMgr.AdSdk;
import com.introvd.template.ads.ads.AbsBannerAds;

public final class SplashAdsClient extends ViewAdsClient {

    /* renamed from: com.introvd.template.ads.client.SplashAdsClient$a */
    private static class C3605a {
        static final SplashAdsClient bgK = new SplashAdsClient();
    }

    private SplashAdsClient() {
        super(5);
    }

    public static SplashAdsClient getInstance() {
        return C3605a.bgK;
    }

    /* access modifiers changed from: protected */
    public AbsBannerAds getAds(Context context, AdSdk adSdk, int i) {
        return adSdk.getSplashAds(context, i);
    }
}
