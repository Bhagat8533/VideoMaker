package com.introvd.template.router.app;

import com.introvd.template.router.BizServiceManager;

public class ANRServiceProxy {
    public static void offerLifeCycleQueue(String str) {
        IANRService iANRService = (IANRService) BizServiceManager.getService(IANRService.class);
        if (iANRService != null) {
            iANRService.offerLifeCycleQueue(str);
        }
    }
}
