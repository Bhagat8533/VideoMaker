package com.introvd.template.module.p326ad;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.introvd.template.ads.listener.VideoRewardListener;
import com.introvd.template.ads.listener.ViewAdsListener;

/* renamed from: com.introvd.template.module.ad.f */
public interface C7640f {
    /* renamed from: a */
    void mo32521a(Activity activity, int i, VideoRewardListener videoRewardListener);

    /* renamed from: a */
    void mo32522a(ViewAdsListener viewAdsListener);

    int aAa();

    void aAb();

    boolean aAc();

    /* renamed from: aj */
    void mo32526aj(Context context, int i);

    /* renamed from: ak */
    void mo32527ak(Context context, int i);

    View getAdView(Context context, int i);

    /* renamed from: gl */
    void mo32529gl(Context context);

    /* renamed from: gm */
    View mo32530gm(Context context);

    /* renamed from: h */
    void mo32531h(int i, Object obj);

    boolean isAdAvailable(Context context, int i);

    /* renamed from: rS */
    void mo32533rS(int i);

    void releasePosition(int i);

    void releasePosition(int i, boolean z);
}
