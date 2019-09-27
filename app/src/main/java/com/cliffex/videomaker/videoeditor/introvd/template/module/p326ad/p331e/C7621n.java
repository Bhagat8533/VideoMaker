package com.introvd.template.module.p326ad.p331e;

import com.introvd.template.ads.PlacementIdProvider;
import com.introvd.template.ads.entity.AdPlacementInfo;

/* renamed from: com.introvd.template.module.ad.e.n */
public class C7621n implements PlacementIdProvider {
    public AdPlacementInfo getPlacementInfo(int i, int i2) {
        String str = 32 == i ? C7609b.m22414kl("XYPIN_HOME_STUDIO") : 13 == i ? C7609b.m22414kl("XYPIN_HOME_RECOMMEND") : 2 == i ? C7609b.m22414kl("XYPIN_DRAFT_LIST") : 3 == i ? C7609b.m22414kl("XYPIN_DRAFT_GRID") : 17 == i ? i2 == 2 ? C7609b.m22414kl("XYPIN_SAVE_DRAFT_INTERSTITIAL") : C7609b.m22414kl("XYPIN_DRAFT_DIALOG") : 16 == i ? C7609b.m22414kl("XYPIN_EXIT_DIALOG") : 12 == i ? C7609b.m22414kl("XYPIN_RESULT_PAGE") : 27 == i ? C7609b.m22414kl("XYPIN_SPLASH") : 9 == i ? C7609b.m22414kl("XYPIN_CREATION_SHUFFLE") : 30 == i ? C7609b.m22414kl("XYPIN_BACK_HOME") : 21 == i ? C7609b.m22414kl("XYPIN_GALLERY_BANNER") : 48 == i ? C7609b.m22414kl("XYPIN_HOME_INSERSTIITIAL") : null;
        return new AdPlacementInfo(str);
    }
}
