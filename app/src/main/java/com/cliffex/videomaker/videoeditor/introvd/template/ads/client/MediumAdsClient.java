package com.introvd.template.ads.client;

import android.content.Context;
import com.introvd.template.ads.AbsAdGlobalMgr.AdSdk;
import com.introvd.template.ads.ads.ViewAds;

public final class MediumAdsClient extends ViewAdsClient {

    /* renamed from: com.introvd.template.ads.client.MediumAdsClient$a */
    private static class C3599a {
        static final MediumAdsClient bgH = new MediumAdsClient();
    }

    private MediumAdsClient() {
        super(8);
    }

    public static MediumAdsClient getInstance() {
        return C3599a.bgH;
    }

    /* access modifiers changed from: protected */
    public ViewAds getAds(Context context, AdSdk adSdk, int i) {
        return adSdk.getMediumAds(context, i);
    }
}
