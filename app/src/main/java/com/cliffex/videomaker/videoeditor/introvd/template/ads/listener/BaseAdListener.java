package com.introvd.template.ads.listener;

import com.introvd.template.ads.entity.AdPositionInfoParam;

public interface BaseAdListener {
    void onAdLoaded(AdPositionInfoParam adPositionInfoParam, boolean z, String str);
}
