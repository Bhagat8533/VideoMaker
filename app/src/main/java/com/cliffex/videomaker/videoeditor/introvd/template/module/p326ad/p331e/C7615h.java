package com.introvd.template.module.p326ad.p331e;

import com.introvd.template.ads.PlacementIdProvider;
import com.introvd.template.ads.entity.AdPlacementInfo;
import com.introvd.template.router.iap.IapServiceProxy;

/* renamed from: com.introvd.template.module.ad.e.h */
public class C7615h implements PlacementIdProvider {
    public AdPlacementInfo getPlacementInfo(int i, int i2) {
        String str;
        switch (i) {
            case 2:
                str = C7609b.m22414kl("XYBAI_DRAFT_LIST");
                break;
            case 3:
                str = C7609b.m22414kl("XYBAI_DRAFT_GRID");
                break;
            case 4:
                str = C7609b.m22414kl("XYBAI_TEMPLATE_THEME");
                break;
            case 9:
                str = C7609b.m22414kl("XYBAI_CREATION_SHUFFLE");
                break;
            case 10:
                str = C7609b.m22414kl("XYBAI_TEMPLATE_FX");
                break;
            case 12:
                str = C7609b.m22414kl("XYBAI_RESULT_PAGE");
                break;
            case 13:
                str = C7609b.m22414kl("XYBAI_HOME_RECOMMEND");
                break;
            case 15:
                str = C7609b.m22414kl("XYBAI_COMMUNITY_EXPLORER");
                break;
            case 16:
                str = C7609b.m22414kl("XYBAI_EXIT_DIALOG");
                break;
            case 17:
                str = C7609b.m22414kl("XYBAI_DRAFT_DIALOG");
                break;
            case 18:
                if (!((Boolean) IapServiceProxy.execute(IapServiceProxy.isSupportPay, new Object[0])).booleanValue()) {
                    str = C7609b.m22414kl("XYBAI_ENCOURAGE_WATERMARK_NOT_IAP");
                    break;
                } else {
                    str = C7609b.m22414kl("XYBAI_ENCOURAGE_WATERMARK_IAP");
                    break;
                }
            case 20:
                str = C7609b.m22414kl("XYBAI_NEW_FIND");
                break;
            case 25:
                str = C7609b.m22414kl("XYBAI_FOLLOW_FALL");
                break;
            case 26:
                str = C7609b.m22414kl("XYBAI_ACTIVITY_FALL");
                break;
            case 29:
                str = C7609b.m22414kl("XYBAI_HOT_FALL");
                break;
            case 32:
                str = C7609b.m22414kl("XYBAI_HOME_STUDIO");
                break;
            case 34:
                str = C7609b.m22414kl("XYBAI_TEMPLATE_CENTER_TOP");
                break;
            case 36:
                str = C7609b.m22414kl("XYBAI_ENCOURAGE_TEMPLATE_THEME");
                break;
            case 37:
                str = C7609b.m22414kl("XYBAI_ENCOURAGE_TEMPLATE_OTHER");
                break;
            case 42:
                str = C7609b.m22414kl("XYBAI_ENCOURAGE_REMOVE_AD");
                break;
            default:
                str = null;
                break;
        }
        return new AdPlacementInfo(str);
    }
}
