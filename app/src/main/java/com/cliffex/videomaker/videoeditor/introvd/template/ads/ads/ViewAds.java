package com.introvd.template.ads.ads;

import android.view.View;
import com.introvd.template.ads.listener.ViewAdsListener;

public interface ViewAds extends BaseAds<ViewAdsListener> {
    View getAdView();
}
