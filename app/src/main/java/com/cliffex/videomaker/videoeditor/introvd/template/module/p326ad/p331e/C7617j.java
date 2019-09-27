package com.introvd.template.module.p326ad.p331e;

import com.introvd.template.ads.PlacementIdProvider;
import com.introvd.template.ads.entity.AdPlacementInfo;

/* renamed from: com.introvd.template.module.ad.e.j */
public class C7617j implements PlacementIdProvider {
    public AdPlacementInfo getPlacementInfo(int i, int i2) {
        String str;
        switch (i) {
            case 2:
                if (i2 != 7) {
                    str = C7609b.m22414kl("XYFAC_DRAFT_LIST");
                    break;
                } else {
                    str = C7609b.m22414kl("XYFAC_DRAFT_LIST_NATIVE_BANNER");
                    break;
                }
            case 3:
                str = C7609b.m22414kl("XYFAC_DRAFT_GRID");
                break;
            case 4:
                str = C7609b.m22414kl("XYFAC_TEMPLATE_THEME");
                break;
            case 5:
                str = C7609b.m22414kl("XYFAC_TEMPLATE_FILTER");
                break;
            case 6:
                str = C7609b.m22414kl("XYFAC_TEMPLATE_TRANSITION");
                break;
            case 9:
                str = C7609b.m22414kl("XYFAC_CREATION_SHUFFLE");
                break;
            case 10:
                str = C7609b.m22414kl("XYFAC_TEMPLATE_FX");
                break;
            case 12:
                str = C7609b.m22414kl("XYFAC_RESULT_PAGE");
                break;
            case 13:
                str = C7609b.m22414kl("XYFAC_HOME_RECOMMEND");
                break;
            case 15:
                str = C7609b.m22414kl("XYFAC_COMMUNITY_EXPLORER");
                break;
            case 16:
                if (i2 != 0) {
                    str = C7609b.m22414kl("XYFAC_HOME_EXIT_INSERSTIITIAL");
                    break;
                } else {
                    str = C7609b.m22414kl("XYFAC_EXIT_DIALOG");
                    break;
                }
            case 17:
                if (i2 != 2) {
                    str = C7609b.m22414kl("XYFAC_DRAFT_DIALOG");
                    break;
                } else {
                    str = C7609b.m22414kl("XYFAC_SAVE_DRAFT_INTERSTITIAL");
                    break;
                }
            case 19:
                str = C7609b.m22414kl("XYFAC_REWARD_VIDEO");
                break;
            case 20:
                str = C7609b.m22414kl("XYFAC_NEW_FIND");
                break;
            case 21:
                str = C7609b.m22414kl("XYFAC_GALLERY_BANNER");
                break;
            case 25:
                str = C7609b.m22414kl("XYFAC_FOLLOW_FALL");
                break;
            case 26:
                str = C7609b.m22414kl("XYFAC_ACTIVITY_FALL");
                break;
            case 27:
                str = C7609b.m22414kl("XYFAC_SPLASH");
                break;
            case 29:
                str = C7609b.m22414kl("XYFAC_HOT_FALL");
                break;
            case 30:
                str = C7609b.m22414kl("XYFAC_BACK_HOME");
                break;
            case 32:
                str = C7609b.m22414kl("XYFAC_HOME_STUDIO");
                break;
            case 35:
                str = C7609b.m22414kl("XYFAC_SPLASH_B");
                break;
            case 47:
                str = C7609b.m22414kl("XYFAC_SPLASH_C");
                break;
            case 48:
                str = C7609b.m22414kl("XYFAC_HOME_INSERSTIITIAL");
                break;
            default:
                str = null;
                break;
        }
        return new AdPlacementInfo(str);
    }
}
