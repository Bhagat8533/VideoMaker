package com.introvd.template.ads.client;

import android.content.Context;
import com.introvd.template.ads.AbsAdGlobalMgr.AdSdk;
import com.introvd.template.ads.ads.ViewAds;

public final class NativeAdsClient extends ViewAdsClient {

    /* renamed from: com.introvd.template.ads.client.NativeAdsClient$a */
    private static class C3601a {
        static final NativeAdsClient bgI = new NativeAdsClient();
    }

    private NativeAdsClient() {
        super(0);
    }

    public static NativeAdsClient getInstance() {
        return C3601a.bgI;
    }

    /* access modifiers changed from: protected */
    public ViewAds getAds(Context context, AdSdk adSdk, int i) {
        return adSdk.getNativeAds(context, i);
    }
}
