package com.introvd.template.module.p326ad.p331e;

import com.introvd.template.ads.PlacementIdProvider;
import com.introvd.template.ads.entity.AdPlacementInfo;

/* renamed from: com.introvd.template.module.ad.e.i */
public class C7616i implements PlacementIdProvider {
    public AdPlacementInfo getPlacementInfo(int i, int i2) {
        String str;
        switch (i) {
            case 2:
                str = C7609b.m22414kl("XYBAT_DRAFT_LIST");
                break;
            case 3:
                str = C7609b.m22414kl("XYBAT_DRAFT_GRID");
                break;
            case 4:
                str = C7609b.m22414kl("XYBAT_TEMPLATE_THEME");
                break;
            case 9:
                str = C7609b.m22414kl("XYBAT_CREATION_SHUFFLE");
                break;
            case 10:
                str = C7609b.m22414kl("XYBAT_TEMPLATE_FX");
                break;
            case 12:
                str = C7609b.m22414kl("XYBAT_RESULT_PAGE");
                break;
            case 13:
                str = C7609b.m22414kl("XYBAT_HOME_RECOMMEND");
                break;
            case 16:
                str = C7609b.m22414kl("XYBAT_EXIT_DIALOG");
                break;
            case 17:
                if (i2 != 2) {
                    str = C7609b.m22414kl("XYBAT_DRAFT_DIALOG");
                    break;
                } else {
                    str = C7609b.m22414kl("XYBAT_SAVE_DRAFT_INTERSTITIAL");
                    break;
                }
            case 21:
                str = C7609b.m22414kl("XYBAT_GALLERY_BANNER");
                break;
            case 27:
                str = C7609b.m22414kl("XYBAT_SPLASH");
                break;
            case 30:
                str = C7609b.m22414kl("XYBAT_BACK_HOME");
                break;
            case 32:
                str = C7609b.m22414kl("XYBAT_HOME_STUDIO");
                break;
            case 35:
                str = C7609b.m22414kl("XYBAT_SPLASH_B");
                break;
            case 47:
                str = C7609b.m22414kl("XYBAT_SPLASH_C");
                break;
            default:
                str = null;
                break;
        }
        return new AdPlacementInfo(str);
    }
}
