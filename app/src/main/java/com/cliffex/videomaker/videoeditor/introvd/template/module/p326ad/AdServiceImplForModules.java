package com.introvd.template.module.p326ad;

import android.content.Context;
import com.aiii.android.arouter.facade.p094a.C1942a;
import com.introvd.template.module.p326ad.p328b.C7591a;
import com.introvd.template.module.p326ad.p334h.C7654a;
import com.introvd.template.module.p326ad.p337i.C7670c;
import com.introvd.template.router.p377ad.AdServiceProxy;
import com.introvd.template.router.p377ad.IAdService;

@C1942a(mo10417rZ = "/mid_ad/mid_ad_service")
/* renamed from: com.introvd.template.module.ad.AdServiceImplForModules */
public class AdServiceImplForModules implements IAdService {
    public Object execute(String str, Object... objArr) {
        if (str == null) {
            return null;
        }
        char c = 65535;
        switch (str.hashCode()) {
            case -2109278024:
                if (str.equals(AdServiceProxy.flagInterstitial)) {
                    c = 2;
                    break;
                }
                break;
            case -2045704118:
                if (str.equals(AdServiceProxy.setEncourageAdFromPrefix)) {
                    c = 4;
                    break;
                }
                break;
            case -1616564656:
                if (str.equals(AdServiceProxy.releasePosition)) {
                    c = 8;
                    break;
                }
                break;
            case -1097520215:
                if (str.equals(AdServiceProxy.loadAd)) {
                    c = 12;
                    break;
                }
                break;
            case -822070692:
                if (str.equals(AdServiceProxy.isAdAvailable)) {
                    c = 11;
                    break;
                }
                break;
            case -399044286:
                if (str.equals(AdServiceProxy.getEncourageAdDialog)) {
                    c = 3;
                    break;
                }
                break;
            case -351574023:
                if (str.equals(AdServiceProxy.setAdListener)) {
                    c = 0;
                    break;
                }
                break;
            case -313607458:
                if (str.equals(AdServiceProxy.observableShowUnlockTemplate)) {
                    c = 13;
                    break;
                }
                break;
            case -93718214:
                if (str.equals(AdServiceProxy.recordAdTemplateClick)) {
                    c = 5;
                    break;
                }
                break;
            case 273093726:
                if (str.equals(AdServiceProxy.getAdView)) {
                    c = 1;
                    break;
                }
                break;
            case 772283115:
                if (str.equals(AdServiceProxy.recordUnlockDialogClick)) {
                    c = 6;
                    break;
                }
                break;
            case 835607338:
                if (str.equals(AdServiceProxy.getAdProvider)) {
                    c = 7;
                    break;
                }
                break;
            case 840941633:
                if (str.equals(AdServiceProxy.showVideoAd)) {
                    c = 10;
                    break;
                }
                break;
            case 997737162:
                if (str.equals(AdServiceProxy.getAdPositionRewardVideo)) {
                    c = 9;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                C7680l.aAe().mo32531h(objArr[0].intValue(), objArr[1]);
                break;
            case 1:
                return C7680l.aAe().getAdView(objArr[0], objArr[1].intValue());
            case 2:
                C7680l.aAf().mo32495iu(objArr[0].booleanValue());
                break;
            case 3:
                return new C7670c(objArr[0], objArr[1].intValue(), objArr[2]);
            case 4:
                C7591a.m22374kd(objArr[0]);
                break;
            case 5:
                C7591a.m22371au(objArr[0], objArr[1]);
                break;
            case 6:
                C7591a.m22373d(objArr[0], objArr[1], objArr[2].booleanValue());
                break;
            case 7:
                return C7591a.m22370W(objArr[0]);
            case 8:
                C7680l.aAe().releasePosition(objArr[0].intValue(), false);
                break;
            case 9:
                return Integer.valueOf(19);
            case 10:
                C7680l.aAf().mo32521a(objArr[0], objArr[1].intValue(), objArr[2]);
                break;
            case 11:
                return Boolean.valueOf(C7680l.aAf().isAdAvailable(objArr[0], objArr[1].intValue()));
            case 12:
                C7680l.aAf().mo32526aj(objArr[0], objArr[1].intValue());
                break;
            case 13:
                return C7654a.m22475b(objArr[0], objArr[1], objArr[2].booleanValue());
        }
        return null;
    }

    public void init(Context context) {
    }
}
