package com.introvd.template.ads.entity;

import android.os.Bundle;

public class AdPlacementInfo {
    public Bundle extraInfo;
    public String placementId;

    public AdPlacementInfo(String str) {
        this(str, null);
    }

    public AdPlacementInfo(String str, Bundle bundle) {
        this.placementId = str;
        this.extraInfo = bundle;
    }
}
