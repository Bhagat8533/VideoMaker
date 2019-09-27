package com.introvd.template.module.iap;

import android.content.Context;
import com.aiii.android.arouter.facade.p094a.C1942a;
import com.introvd.template.module.iap.business.exchange.C7916c;
import com.introvd.template.module.iap.business.exchange.C7916c.C7920a;
import com.introvd.template.module.iap.business.exchange.C7922d;
import com.introvd.template.module.iap.business.p349a.C7825a;
import com.introvd.template.module.iap.business.p356e.C7897a;
import com.introvd.template.module.iap.business.p356e.C7898b;
import com.introvd.template.module.iap.business.vip.VipActivityDialogActivity;
import com.introvd.template.router.AdRouter;
import com.introvd.template.router.iap.IIapService;
import com.introvd.template.router.iap.IapRTConstants;
import com.introvd.template.router.iap.IapRouter.IapPayResult;
import com.introvd.template.router.iap.IapServiceProxy;
import com.introvd.template.router.iap.InfoMessenger;

@C1942a(mo10417rZ = "/mid_iap/mid_iap_service")
public class IapServiceImplForModules implements IIapService {
    private static final String CODE_SUCCESS = "0";

    private String convertFlag2Id(int i) {
        if (i == 8) {
            return C7825a.ANIM_TITLE.getId();
        }
        if (i == 11) {
            return C7825a.MAGIC_SOUND.getId();
        }
        switch (i) {
            case 1:
                return C7825a.WATER_MARK.getId();
            case 2:
                return C7825a.DURATION_LIMIT.getId();
            case 3:
                return C7825a.AD.getId();
            case 4:
                return C7825a.HD.getId();
            default:
                switch (i) {
                    case 16:
                        return C7825a.KEY_FRAME.getId();
                    case 17:
                        return C7825a.AUDIO_EXTRA.getId();
                    default:
                        return null;
                }
        }
    }

    private void exchangeVipForCode(String str, final InfoMessenger<Boolean> infoMessenger) {
        C7916c.aCW().mo32877a(str, (C7920a) new C7920a() {
            /* renamed from: a */
            public void mo32574a(C7922d dVar) {
                if (infoMessenger != null) {
                    infoMessenger.onMessage(Boolean.valueOf("0".equals(dVar.code)));
                }
            }
        });
    }

    private boolean isVip() {
        return C8072q.aBx().isVip();
    }

    private void restoreGoodsAndPurchaseInfo() {
        C8049f.aBf().restoreGoodsAndPurchaseInfo();
    }

    public Object execute(String str, Object... objArr) {
        if (str == null) {
            return null;
        }
        char c = 65535;
        boolean z = true;
        switch (str.hashCode()) {
            case -2009856736:
                if (str.equals(IapServiceProxy.REQUEST_CODE_FOR_IAP)) {
                    c = 10;
                    break;
                }
                break;
            case -1882562052:
                if (str.equals(IapServiceProxy.exchangeVipForCode)) {
                    c = 1;
                    break;
                }
                break;
            case -1827434120:
                if (str.equals(IapServiceProxy.ALL_TEMPLATE)) {
                    c = 11;
                    break;
                }
                break;
            case -776770692:
                if (str.equals(IapServiceProxy.isPurchasedAd)) {
                    c = 5;
                    break;
                }
                break;
            case -41486544:
                if (str.equals(IapServiceProxy.addReward)) {
                    c = 6;
                    break;
                }
                break;
            case 9909822:
                if (str.equals(IapServiceProxy.restoreGoodsAndPurchaseInfo)) {
                    c = 3;
                    break;
                }
                break;
            case 100481683:
                if (str.equals(IapServiceProxy.isVip)) {
                    c = 2;
                    break;
                }
                break;
            case 1006262059:
                if (str.equals(IapServiceProxy.getTemplateId)) {
                    c = 9;
                    break;
                }
                break;
            case 1243897563:
                if (str.equals(IapServiceProxy.getGoodsId)) {
                    c = 8;
                    break;
                }
                break;
            case 1557360419:
                if (str.equals(IapServiceProxy.isSupportPay)) {
                    c = 4;
                    break;
                }
                break;
            case 1890479032:
                if (str.equals(IapServiceProxy.isEncourageAllTemplate)) {
                    c = 7;
                    break;
                }
                break;
            case 1922630404:
                if (str.equals(IapServiceProxy.handleVipActivity)) {
                    c = 0;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                if (objArr.length > 0) {
                    VipActivityDialogActivity.m23185X(objArr[0]);
                    break;
                }
                break;
            case 1:
                if (objArr.length > 1) {
                    exchangeVipForCode(objArr[0], objArr[1]);
                    break;
                }
                break;
            case 2:
                return Boolean.valueOf(isVip());
            case 3:
                restoreGoodsAndPurchaseInfo();
                break;
            case 4:
                return Boolean.valueOf(C8049f.aBf().mo33077EO());
            case 5:
                return Boolean.valueOf(C8072q.aBx().mo33072ku(C7825a.AD.getId()));
            case 6:
                C8045d.aAZ().mo33075ky(objArr[0]);
                break;
            case 7:
                if (!objArr[0].contains("iap.template.") && !C7825a.ALL_TEMPLATE.getId().equals(objArr[0])) {
                    z = false;
                }
                return Boolean.valueOf(z);
            case 8:
                return C7717b.m22629ks(objArr[0]);
            case 9:
                return C7717b.m22630kt(objArr[0]);
            case 10:
                return Integer.valueOf(IapRTConstants.REQUEST_CODE_FOR_VIP);
            case 11:
                return C7825a.ALL_TEMPLATE.getId();
        }
        return null;
    }

    public void init(Context context) {
    }

    public void launchVipHome(Context context, int i, String str, int i2) {
        C8049f.aBf().mo33097b(context, C8070o.aBw(), convertFlag2Id(i), str, i2);
    }

    public void payForH5(IapPayResult iapPayResult) {
        C7897a.m23022b("变脸", "Iap_Domestic_Todo_Code", new String[0]);
        C7897a.m23022b("todoCode", C7898b.dSW, new String[0]);
        AdRouter.launchVipRenewForResult(C8048e.aBe().getContext(), iapPayResult);
    }
}
