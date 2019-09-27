package com.introvd.template.ads.client;

import android.content.Context;
import com.introvd.template.ads.AbsAdGlobalMgr.AdSdk;
import com.introvd.template.ads.ads.ViewAds;

public final class NativeBannerAdsClient extends ViewAdsClient {

    /* renamed from: com.introvd.template.ads.client.NativeBannerAdsClient$a */
    private static class C3603a {
        static final NativeBannerAdsClient bgJ = new NativeBannerAdsClient();
    }

    private NativeBannerAdsClient() {
        super(7);
    }

    public static NativeBannerAdsClient getInstance() {
        return C3603a.bgJ;
    }

    /* access modifiers changed from: protected */
    public ViewAds getAds(Context context, AdSdk adSdk, int i) {
        return adSdk.getNativeBannerAds(context, i);
    }
}
