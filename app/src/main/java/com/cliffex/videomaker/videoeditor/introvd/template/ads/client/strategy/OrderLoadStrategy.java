package com.introvd.template.ads.client.strategy;

import android.util.SparseIntArray;
import com.PinkiePie;
import com.introvd.template.ads.AdParamMgr;
import com.introvd.template.ads.ads.BaseAds;
import com.introvd.template.ads.entity.AdPositionInfoParam;
import com.introvd.template.ads.listener.BaseAdListener;
import com.introvd.template.ads.utils.VivaAdLog;
import java.util.LinkedList;
import java.util.Queue;

public class OrderLoadStrategy<T extends BaseAds<U>, U extends BaseAdListener> extends AdLoadStrategy<T, U> {
    private Queue<Integer> bgY;
    private SparseIntArray bgZ = new SparseIntArray();
    private AdStrategyResultListener bha;

    /* renamed from: gg */
    private void m8842gg(int i) {
        BaseAds baseAds = null;
        while (!this.bgY.isEmpty()) {
            Integer num = (Integer) this.bgY.poll();
            if (num != null) {
                baseAds = this.adsCreator.provideAds(i, num.intValue());
                if (baseAds != null) {
                    break;
                }
            }
        }
        if (baseAds == null) {
            m8843gh(i);
            return;
        }
        int i2 = 0;
        PinkiePie.DianePie();
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append("/");
        sb.append(baseAds.getAdFlag());
        VivaAdLog.m8847e("====load", sb.toString());
        if (baseAds.isAdAvailable()) {
            i2 = 3;
        }
        if (this.bha != null) {
            this.bha.onStrategyHandle(i2, baseAds.getAdFlag());
        }
    }

    /* renamed from: gh */
    private void m8843gh(int i) {
        if (this.bgZ.get(i) > 0) {
            this.bgZ.delete(i);
            VivaAdLog.m8847e("====result", "No ads is available.");
            BaseAdListener provideAppListener = this.adsCreator.provideAppListener();
            if (provideAppListener != null) {
                provideAppListener.onAdLoaded(new AdPositionInfoParam(-1, i), false, "No ads is available.");
            }
        }
    }

    public void handleAdsLoad(int i, AdStrategyResultListener adStrategyResultListener) {
        this.bgY = new LinkedList(AdParamMgr.getProviderList(i));
        this.bha = adStrategyResultListener;
        int i2 = this.bgZ.get(i);
        if (i2 > 0) {
            this.bgZ.put(i, i2 - 1);
            return;
        }
        this.bgZ.put(i, 2);
        m8842gg(i);
    }

    public void onAdLoaded(AdPositionInfoParam adPositionInfoParam, boolean z, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(adPositionInfoParam.toString());
        sb.append(z);
        sb.append(str);
        VivaAdLog.m8847e("====result", sb.toString());
        if (z || this.bgY.isEmpty()) {
            BaseAdListener provideAppListener = this.adsCreator.provideAppListener();
            if (provideAppListener != null) {
                provideAppListener.onAdLoaded(adPositionInfoParam, z, str);
            }
            this.bgZ.delete(adPositionInfoParam.position);
        }
        if (!z) {
            m8842gg(adPositionInfoParam.position);
        }
    }
}
