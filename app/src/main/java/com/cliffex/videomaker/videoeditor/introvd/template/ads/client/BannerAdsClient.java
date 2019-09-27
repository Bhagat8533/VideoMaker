package com.introvd.template.ads.client;

import android.content.Context;
import com.introvd.template.ads.AbsAdGlobalMgr.AdSdk;
import com.introvd.template.ads.AdParamMgr;
import com.introvd.template.ads.ads.ViewAds;
import java.util.List;

public final class BannerAdsClient extends ViewAdsClient {

    /* renamed from: com.introvd.template.ads.client.BannerAdsClient$a */
    private static class C3590a {
        static final BannerAdsClient bgA = new BannerAdsClient();
    }

    private BannerAdsClient() {
        super(4);
    }

    public static BannerAdsClient getInstance() {
        return C3590a.bgA;
    }

    /* access modifiers changed from: protected */
    public ViewAds getAds(Context context, AdSdk adSdk, int i) {
        return adSdk.getBannerAds(context, i);
    }

    public void releaseAds(int i) {
        List<Integer> providerList = AdParamMgr.getProviderList(i);
        if (providerList != null && !providerList.isEmpty()) {
            for (Integer intValue : providerList) {
                ViewAds viewAds = (ViewAds) getAdsFromCache(i, intValue.intValue());
                if (viewAds != null) {
                    viewAds.release();
                }
            }
            removeAdListener(i);
        }
    }
}
