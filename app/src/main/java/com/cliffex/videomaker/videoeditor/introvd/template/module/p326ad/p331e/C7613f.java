package com.introvd.template.module.p326ad.p331e;

import com.introvd.template.ads.PlacementIdProvider;
import com.introvd.template.ads.entity.AdPlacementInfo;

/* renamed from: com.introvd.template.module.ad.e.f */
public class C7613f implements PlacementIdProvider {
    public AdPlacementInfo getPlacementInfo(int i, int i2) {
        String str = 21 == i ? C7609b.m22414kl("XYADM_GALLERY_BANNER") : 30 == i ? C7609b.m22414kl("XYADM_BACK_HOME") : 9 == i ? C7609b.m22414kl("XYADM_CREATION_SHUFFLE") : 12 == i ? C7609b.m22414kl("XYADM_RESULT_PAGE") : 17 == i ? i2 == 2 ? C7609b.m22414kl("XYADM_SAVE_DRAFT_INTERSTITIAL") : C7609b.m22414kl("XYADM_DRAFT_DIALOG") : 3 == i ? C7609b.m22414kl("XYADM_DRAFT_GRID") : 2 == i ? C7609b.m22414kl("XYADM_DRAFT_LIST") : 16 == i ? i2 == 0 ? C7609b.m22414kl("XYADM_EXIT_DIALOG") : C7609b.m22414kl("XYADM_HOME_EXIT_INSERSTIITIAL") : 4 == i ? C7609b.m22414kl("XYADM_TEMPLATE_THEME") : 13 == i ? C7609b.m22414kl("XYADM_HOME_RECOMMEND") : 32 == i ? C7609b.m22414kl("XYADM_HOME_STUDIO") : 27 == i ? C7609b.m22414kl("XYADM_SPLASH") : 19 == i ? C7609b.m22414kl("XYADM_REWARD_VIDEO") : 48 == i ? C7609b.m22414kl("XYADM_HOME_INSERSTIITIAL") : 42 == i ? C7609b.m22414kl("XYADM_ENCOURAGE_REMOVE_AD") : 49 == i ? C7609b.m22414kl("XYADM_EDIT_BACK_VIDEO_REMOVE_AD") : 46 == i ? C7609b.m22414kl("XYADM_VIDEO_EXPORT_MEDIUM") : null;
        return new AdPlacementInfo(str);
    }
}
