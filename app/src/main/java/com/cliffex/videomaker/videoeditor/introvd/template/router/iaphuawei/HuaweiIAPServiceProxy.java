package com.introvd.template.router.iaphuawei;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import com.introvd.template.router.BizServiceManager;

public class HuaweiIAPServiceProxy {
    public static Object getHuaWeiPayClient(String str) {
        IHuaweiIAPService iHuaweiIAPService = (IHuaweiIAPService) BizServiceManager.getService(IHuaweiIAPService.class);
        if (iHuaweiIAPService != null) {
            return iHuaweiIAPService.getHuaWeiPayClient(str);
        }
        return null;
    }

    public static void handleResult(int i, int i2, Intent intent) {
        IHuaweiIAPService iHuaweiIAPService = (IHuaweiIAPService) BizServiceManager.getService(IHuaweiIAPService.class);
        if (iHuaweiIAPService != null) {
            iHuaweiIAPService.handleResult(i, i2, intent);
        }
    }

    public static void initHuaWeiSdk(Application application) {
        IHuaweiIAPService iHuaweiIAPService = (IHuaweiIAPService) BizServiceManager.getService(IHuaweiIAPService.class);
        if (iHuaweiIAPService != null) {
            iHuaweiIAPService.initHuaWeiSdk(application);
        }
    }

    public static void initHuaweiIAPListener(Activity activity) {
        IHuaweiIAPService iHuaweiIAPService = (IHuaweiIAPService) BizServiceManager.getService(IHuaweiIAPService.class);
        if (iHuaweiIAPService != null) {
            iHuaweiIAPService.initHuaweiIAPListener(activity);
        }
    }

    public static void unInit() {
        IHuaweiIAPService iHuaweiIAPService = (IHuaweiIAPService) BizServiceManager.getService(IHuaweiIAPService.class);
        if (iHuaweiIAPService != null) {
            iHuaweiIAPService.unInit();
        }
    }
}
