package com.introvd.template.ads.client.strategy;

import com.introvd.template.ads.ads.BaseAds;
import com.introvd.template.ads.listener.BaseAdListener;

public interface AdsCreator<T extends BaseAds<U>, U extends BaseAdListener> {
    T provideAds(int i, int i2);

    U provideAppListener();

    U provideClientListener();

    Class<U> provideClientListenerType();
}
