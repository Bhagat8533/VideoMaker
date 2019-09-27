package com.introvd.template.ads.ads;

import com.introvd.template.ads.listener.BaseAdListener;

public interface BaseAds<T extends BaseAdListener> {
    String getAdFlag();

    boolean isAdAvailable();

    void loadAd();

    void release();

    void setAdListener(T t);
}
