package com.introvd.template.router.iap;

import android.content.Context;
import com.introvd.template.router.BizServiceManager;
import com.introvd.template.router.iap.IapRouter.IapPayResult;
import java.util.HashMap;
import java.util.Map;

public class IapServiceProxy {
    public static final String ALL_TEMPLATE = "ALL_TEMPLATE";
    public static final String REQUEST_CODE_FOR_IAP = "REQUEST_CODE_FOR_IAP";
    public static final String addReward = "addReward";
    private static Map<String, Object> defaultValueMap = new HashMap();
    public static final String exchangeVipForCode = "exchangeVipForCode";
    public static final String getGoodsId = "getGoodsId";
    public static final String getTemplateId = "getTemplateId";
    public static final String handleVipActivity = "handleVipActivity";
    public static final String isEncourageAllTemplate = "isEncourageAllTemplate";
    public static final String isPurchasedAd = "isPurchasedAd";
    public static final String isSupportPay = "isSupportPay";
    public static final String isVip = "isVip";
    public static final String restoreGoodsAndPurchaseInfo = "restoreGoodsAndPurchaseInfo";

    static {
        defaultValueMap.put(isVip, Boolean.valueOf(false));
        defaultValueMap.put(isSupportPay, Boolean.valueOf(false));
        defaultValueMap.put(isPurchasedAd, Boolean.valueOf(false));
        defaultValueMap.put(isEncourageAllTemplate, Boolean.valueOf(false));
        defaultValueMap.put(getTemplateId, Integer.valueOf(0));
        defaultValueMap.put(ALL_TEMPLATE, Integer.valueOf(0));
        defaultValueMap.put(REQUEST_CODE_FOR_IAP, Integer.valueOf(0));
    }

    public static Object execute(String str, Object... objArr) {
        IIapService iIapService = (IIapService) BizServiceManager.getService(IIapService.class);
        return iIapService != null ? iIapService.execute(str, objArr) : defaultValueMap.get(str);
    }

    public static void launchVipHome(Context context, int i, String str, int i2) {
        IIapService iIapService = (IIapService) BizServiceManager.getService(IIapService.class);
        if (iIapService != null) {
            iIapService.launchVipHome(context, i, str, i2);
        }
    }

    public static void payForH5(IapPayResult iapPayResult) {
        IIapService iIapService = (IIapService) BizServiceManager.getService(IIapService.class);
        if (iIapService != null) {
            iIapService.payForH5(iapPayResult);
        }
    }
}
