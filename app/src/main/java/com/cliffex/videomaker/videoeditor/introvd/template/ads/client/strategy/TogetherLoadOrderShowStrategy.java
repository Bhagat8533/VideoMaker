package com.introvd.template.ads.client.strategy;

import com.PinkiePie;
import com.introvd.template.ads.AdParamMgr;
import com.introvd.template.ads.ads.BaseAds;
import com.introvd.template.ads.entity.AdPositionInfoParam;
import com.introvd.template.ads.listener.BaseAdListener;
import com.introvd.template.ads.utils.VivaAdLog;

public class TogetherLoadOrderShowStrategy<T extends BaseAds<U>, U extends BaseAdListener> extends AdLoadStrategy<T, U> {
    public void handleAdsLoad(int i, AdStrategyResultListener adStrategyResultListener) {
        this.isOverArray.put(i, false);
        for (Integer intValue : AdParamMgr.getProviderList(i)) {
            BaseAds provideAds = this.adsCreator.provideAds(i, intValue.intValue());
            if (provideAds != null) {
                PinkiePie.DianePie();
                StringBuilder sb = new StringBuilder();
                sb.append(i);
                sb.append("/");
                sb.append(provideAds.getAdFlag());
                VivaAdLog.m8847e("====load", sb.toString());
                int i2 = provideAds.isAdAvailable() ? 3 : 0;
                if (adStrategyResultListener != null) {
                    adStrategyResultListener.onStrategyHandle(i2, provideAds.getAdFlag());
                }
            }
        }
    }

    public void onAdLoaded(AdPositionInfoParam adPositionInfoParam, boolean z, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(adPositionInfoParam.toString());
        sb.append(z);
        sb.append(str);
        VivaAdLog.m8847e("====result", sb.toString());
        if (!this.isOverArray.get(adPositionInfoParam.position, true)) {
            this.isOverArray.put(adPositionInfoParam.position, true);
            BaseAdListener provideAppListener = this.adsCreator.provideAppListener();
            if (provideAppListener != null) {
                provideAppListener.onAdLoaded(adPositionInfoParam, z, str);
            }
        }
    }
}
