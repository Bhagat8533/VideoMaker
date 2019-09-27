package com.introvd.template.module.p326ad.p331e;

import com.introvd.template.ads.PlacementIdProvider;
import com.introvd.template.ads.entity.AdPlacementInfo;

/* renamed from: com.introvd.template.module.ad.e.l */
public class C7619l implements PlacementIdProvider {
    public AdPlacementInfo getPlacementInfo(int i, int i2) {
        String str;
        switch (i) {
            case 2:
                str = C7609b.m22414kl("XYMOB_DRAFT_LIST");
                break;
            case 3:
                str = C7609b.m22414kl("XYMOB_DRAFT_GRID");
                break;
            case 9:
                str = C7609b.m22414kl("XYMOB_CREATION_SHUFFLE");
                break;
            case 12:
                str = C7609b.m22414kl("XYMOB_RESULT_PAGE");
                break;
            case 13:
                str = C7609b.m22414kl("XYMOB_HOME_RECOMMEND");
                break;
            case 16:
                str = C7609b.m22414kl("XYMOB_EXIT_DIALOG");
                break;
            case 17:
                str = C7609b.m22414kl("XYMOB_DRAFT_DIALOG");
                break;
            case 19:
                str = C7609b.m22414kl("XYMOB_REWARD_VIDEO");
                break;
            case 22:
                str = C7609b.m22414kl("XYMOB_REMOVE_DURATION");
                break;
            case 27:
                str = C7609b.m22414kl("XYMOB_SPLASH");
                break;
            case 30:
                str = C7609b.m22414kl("XYMOB_BACK_HOME");
                break;
            case 32:
                str = C7609b.m22414kl("XYMOB_HOME_STUDIO");
                break;
            case 42:
                str = C7609b.m22414kl("XYMOB_ENCOURAGE_REMOVE_AD");
                break;
            case 48:
                str = C7609b.m22414kl("XYMOB_HOME_INSERSTIITIAL");
                break;
            default:
                str = null;
                break;
        }
        return new AdPlacementInfo(str);
    }
}
