package com.introvd.template.ads.listener;

import com.introvd.template.ads.entity.AdPositionInfoParam;

public interface VideoAdsListener extends BaseAdListener {
    void onShowVideoAd(AdPositionInfoParam adPositionInfoParam, boolean z);
}
