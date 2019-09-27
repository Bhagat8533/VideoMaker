package com.introvd.template.module.p326ad.p331e;

import com.introvd.template.ads.PlacementIdProvider;
import com.introvd.template.ads.entity.AdPlacementInfo;

/* renamed from: com.introvd.template.module.ad.e.g */
public class C7614g implements PlacementIdProvider {
    public AdPlacementInfo getPlacementInfo(int i, int i2) {
        String str;
        switch (i) {
            case 2:
                str = C7609b.m22414kl("XYALT_DRAFT_LIST");
                break;
            case 3:
                str = C7609b.m22414kl("XYALT_DRAFT_GRID");
                break;
            case 4:
                str = C7609b.m22414kl("XYALT_TEMPLATE_THEME");
                break;
            case 9:
                str = C7609b.m22414kl("XYALT_CREATION_SHUFFLE");
                break;
            case 10:
                str = C7609b.m22414kl("XYALT_TEMPLATE_FX");
                break;
            case 12:
                str = C7609b.m22414kl("XYALT_RESULT_PAGE");
                break;
            case 13:
                str = C7609b.m22414kl("XYALT_HOME_RECOMMEND");
                break;
            case 15:
                str = C7609b.m22414kl("XYALT_COMMUNITY_EXPLORER");
                break;
            case 16:
                str = C7609b.m22414kl("XYALT_EXIT_DIALOG");
                break;
            case 17:
                str = C7609b.m22414kl("XYALT_DRAFT_DIALOG");
                break;
            case 20:
                str = C7609b.m22414kl("XYALT_NEW_FIND");
                break;
            case 25:
                str = C7609b.m22414kl("XYALT_FOLLOW_FALL");
                break;
            case 26:
                str = C7609b.m22414kl("XYALT_ACTIVITY_FALL");
                break;
            case 29:
                str = C7609b.m22414kl("XYALT_HOT_FALL");
                break;
            case 32:
                str = C7609b.m22414kl("XYALT_HOME_STUDIO");
                break;
            default:
                str = null;
                break;
        }
        return new AdPlacementInfo(str);
    }
}
