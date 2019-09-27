package com.introvd.template.module.p326ad.p331e;

import com.introvd.template.ads.PlacementIdProvider;
import com.introvd.template.ads.entity.AdPlacementInfo;

/* renamed from: com.introvd.template.module.ad.e.o */
public class C7622o implements PlacementIdProvider {
    public AdPlacementInfo getPlacementInfo(int i, int i2) {
        String str = 46 == i ? C7609b.m22414kl("XYSPA_VIDEO_EXPORT_MEDIUM") : 21 == i ? C7609b.m22414kl("XYSPA_GALLERY_BANNER") : 32 == i ? C7609b.m22414kl("XYSPA_HOME_STUDIO") : null;
        return new AdPlacementInfo(str);
    }
}
