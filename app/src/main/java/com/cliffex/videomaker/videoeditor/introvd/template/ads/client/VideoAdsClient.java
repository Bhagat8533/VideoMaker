package com.introvd.template.ads.client;

import android.app.Activity;
import android.content.Context;
import com.introvd.template.ads.AbsAdGlobalMgr.AdSdk;
import com.introvd.template.ads.AdParamMgr;
import com.introvd.template.ads.ads.AbsVideoAds;
import com.introvd.template.ads.entity.AdPositionInfoParam;
import com.introvd.template.ads.listener.VideoAdsListener;
import com.introvd.template.ads.listener.VideoRewardListener;

public final class VideoAdsClient extends BaseAdClient<AbsVideoAds, VideoAdsListener> implements VideoAdsListener {

    /* renamed from: com.introvd.template.ads.client.VideoAdsClient$a */
    private static class C3607a {
        static final VideoAdsClient bgL = new VideoAdsClient();
    }

    private VideoAdsClient() {
        super(1);
    }

    public static VideoAdsClient getInstance() {
        return C3607a.bgL;
    }

    /* access modifiers changed from: protected */
    public AbsVideoAds getAds(Context context, AdSdk adSdk, int i) {
        if (!(context instanceof Activity)) {
            return null;
        }
        return adSdk.getVideoAds((Activity) context, i);
    }

    /* access modifiers changed from: protected */
    public VideoAdsListener getExtendAdListener() {
        return this;
    }

    /* access modifiers changed from: protected */
    public Class<VideoAdsListener> getExtendAdListenerType() {
        return VideoAdsListener.class;
    }

    public void onAdLoaded(AdPositionInfoParam adPositionInfoParam, boolean z, String str) {
        informAction(z ? 1 : 2, adPositionInfoParam.position, String.valueOf(adPositionInfoParam.providerOrder));
    }

    public void onShowVideoAd(AdPositionInfoParam adPositionInfoParam, boolean z) {
        VideoAdsListener videoAdsListener = (VideoAdsListener) getAdListener(adPositionInfoParam);
        if (videoAdsListener != null) {
            videoAdsListener.onShowVideoAd(adPositionInfoParam, z);
        }
    }

    public final void showVideoAds(Activity activity, int i, VideoRewardListener videoRewardListener) {
        for (Integer intValue : AdParamMgr.getProviderList(i)) {
            AbsVideoAds absVideoAds = (AbsVideoAds) getAdsFromCache(i, intValue.intValue());
            if (absVideoAds != null && absVideoAds.showVideoAd(activity, videoRewardListener)) {
                return;
            }
        }
    }
}
