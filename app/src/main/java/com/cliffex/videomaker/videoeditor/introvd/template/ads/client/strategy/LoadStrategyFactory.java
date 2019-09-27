package com.introvd.template.ads.client.strategy;

import android.util.SparseArray;
import com.introvd.template.ads.AdParamMgr;
import com.introvd.template.ads.ads.BaseAds;
import com.introvd.template.ads.listener.BaseAdListener;
import java.lang.ref.SoftReference;

public class LoadStrategyFactory {
    private static SparseArray<SoftReference<AdLoadStrategy>> bgP = new SparseArray<>();

    public static <T extends BaseAds<U>, U extends BaseAdListener> AdLoadStrategy<T, U> provideLoadStrategy(int i) {
        SoftReference softReference = (SoftReference) bgP.get(i);
        if (softReference != null && softReference.get() != null) {
            return (AdLoadStrategy) softReference.get();
        }
        int loadStrategy = AdParamMgr.getLoadStrategy(i);
        AdLoadStrategy<T, U> adLoadStrategy = loadStrategy != 0 ? loadStrategy != 2 ? new OrderLoadStrategy<>() : new TogetherLoadWaitShowStrategy<>() : new TogetherLoadOrderShowStrategy<>();
        bgP.put(i, new SoftReference(adLoadStrategy));
        return adLoadStrategy;
    }

    public static void removeAdLoadStrategy(int i) {
        SoftReference softReference = (SoftReference) bgP.get(i);
        if (!(softReference == null || softReference.get() == null)) {
            softReference.clear();
        }
        bgP.remove(i);
    }
}
