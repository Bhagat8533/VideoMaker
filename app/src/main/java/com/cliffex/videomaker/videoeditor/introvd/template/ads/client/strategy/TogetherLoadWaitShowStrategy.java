package com.introvd.template.ads.client.strategy;

import android.util.SparseArray;
import com.PinkiePie;
import com.introvd.template.ads.AdParamMgr;
import com.introvd.template.ads.ads.BaseAds;
import com.introvd.template.ads.client.strategy.NativeLoadStrategyHelper.AdLoadedMessageInfo;
import com.introvd.template.ads.entity.AdPositionInfoParam;
import com.introvd.template.ads.listener.BaseAdListener;
import com.introvd.template.ads.utils.VivaAdLog;

public class TogetherLoadWaitShowStrategy<T extends BaseAds<U>, U extends BaseAdListener> extends AdLoadStrategy<T, U> {
    private final SparseArray<NativeLoadStrategyHelper> bhb = new SparseArray<>();

    /* renamed from: gi */
    private NativeLoadStrategyHelper m8844gi(int i) {
        NativeLoadStrategyHelper nativeLoadStrategyHelper = (NativeLoadStrategyHelper) this.bhb.get(i);
        if (nativeLoadStrategyHelper == null) {
            NativeLoadStrategyHelper nativeLoadStrategyHelper2 = new NativeLoadStrategyHelper(i, this.adsCreator.provideAppListener());
            this.bhb.put(i, nativeLoadStrategyHelper2);
            return nativeLoadStrategyHelper2;
        }
        nativeLoadStrategyHelper.setViewAdsListener(this.adsCreator.provideAppListener());
        return nativeLoadStrategyHelper;
    }

    public void handleAdsLoad(int i, AdStrategyResultListener adStrategyResultListener) {
        m8844gi(i).initNewRequest();
        for (Integer intValue : AdParamMgr.getProviderList(i)) {
            BaseAds provideAds = this.adsCreator.provideAds(i, intValue.intValue());
            if (provideAds != null) {
                int i2 = 0;
                PinkiePie.DianePie();
                StringBuilder sb = new StringBuilder();
                sb.append(i);
                sb.append("/");
                sb.append(provideAds.getAdFlag());
                VivaAdLog.m8847e("====load", sb.toString());
                if (provideAds.isAdAvailable()) {
                    i2 = 3;
                }
                if (adStrategyResultListener != null) {
                    adStrategyResultListener.onStrategyHandle(i2, provideAds.getAdFlag());
                }
            }
        }
    }

    public void onAdLoaded(AdPositionInfoParam adPositionInfoParam, boolean z, String str) {
        super.onAdLoaded(adPositionInfoParam, z, str);
        StringBuilder sb = new StringBuilder();
        sb.append(adPositionInfoParam.toString());
        sb.append(z);
        sb.append(str);
        VivaAdLog.m8847e("====result", sb.toString());
        NativeLoadStrategyHelper gi = m8844gi(adPositionInfoParam.position);
        if (gi != null && !gi.isFinishedRequest()) {
            gi.informLoadedRequest(new AdLoadedMessageInfo(adPositionInfoParam, z, str));
        }
    }
}
