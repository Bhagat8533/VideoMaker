package com.introvd.template.router.iaplitehw;

import com.introvd.template.router.BizServiceManager;

public class LiteIAPHWServiceProxy {
    public static Object createGoodsRequest() {
        ILiteIAPHWService iLiteIAPHWService = (ILiteIAPHWService) BizServiceManager.getService(ILiteIAPHWService.class);
        if (iLiteIAPHWService != null) {
            return iLiteIAPHWService.createGoodsRequest();
        }
        return null;
    }

    public static Object createPurchaseRequest() {
        ILiteIAPHWService iLiteIAPHWService = (ILiteIAPHWService) BizServiceManager.getService(ILiteIAPHWService.class);
        if (iLiteIAPHWService != null) {
            return iLiteIAPHWService.createPurchaseRequest();
        }
        return null;
    }

    public static void initHWLiteIap() {
        ILiteIAPHWService iLiteIAPHWService = (ILiteIAPHWService) BizServiceManager.getService(ILiteIAPHWService.class);
        if (iLiteIAPHWService != null) {
            iLiteIAPHWService.initHWLiteIap();
        }
    }
}
