package com.introvd.template.ads.ads;

import android.app.Activity;
import com.introvd.template.ads.entity.AdConfigParam;
import com.introvd.template.ads.entity.AdPositionInfoParam;
import com.introvd.template.ads.listener.VideoAdsListener;
import com.introvd.template.ads.listener.VideoRewardListener;

public abstract class AbsVideoAds implements VideoAds {
    protected final AdConfigParam param;
    protected VideoAdsListener videoAdsListener;
    protected VideoRewardListener videoRewardListener;

    /* renamed from: com.introvd.template.ads.ads.AbsVideoAds$a */
    private static class C3588a implements VideoRewardListener {
        private VideoRewardListener bgz;

        private C3588a() {
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public void m8821b(VideoRewardListener videoRewardListener) {
            this.bgz = videoRewardListener;
        }
    }

    /* renamed from: a */
    private void m8819a(VideoRewardListener videoRewardListener2) {
        if (this.videoRewardListener instanceof C3588a) {
            ((C3588a) this.videoRewardListener).m8821b(videoRewardListener2);
        }
    }

    /* access modifiers changed from: protected */
    public abstract void doLoadVideoAdAction();

    /* access modifiers changed from: protected */
    public abstract void doShowVideoAdAction(Activity activity);

    public boolean showVideoAd(Activity activity, VideoRewardListener videoRewardListener2) {
        if (activity.isFinishing()) {
            return false;
        }
        boolean isAdAvailable = isAdAvailable();
        if (this.videoAdsListener != null) {
            this.videoAdsListener.onShowVideoAd(AdPositionInfoParam.convertParam(this.param), isAdAvailable);
        }
        if (isAdAvailable) {
            m8819a(videoRewardListener2);
            doShowVideoAdAction(activity);
        } else {
            doLoadVideoAdAction();
        }
        return isAdAvailable;
    }
}
