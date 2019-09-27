package com.introvd.template.router.lbs;

import android.content.Context;
import com.introvd.template.router.BizServiceManager;

public class LbsManagerProxy {
    public static LocationInfo getCurrentLocation() {
        ILbsService iLbsService = (ILbsService) BizServiceManager.getService(ILbsService.class);
        if (iLbsService != null) {
            return iLbsService.getCurrentLocation();
        }
        return null;
    }

    public static void init(Context context, boolean z) {
        ILbsService iLbsService = (ILbsService) BizServiceManager.getService(ILbsService.class);
        if (iLbsService != null) {
            iLbsService.init(context, z);
        }
    }

    public static void queryPlace(Context context, String str, int i, int i2, PlaceListener placeListener) {
        ILbsService iLbsService = (ILbsService) BizServiceManager.getService(ILbsService.class);
        if (iLbsService != null) {
            iLbsService.queryPlace(context, str, i, i2, placeListener);
        }
    }

    public static void recordLocation(boolean z, boolean z2) {
        ILbsService iLbsService = (ILbsService) BizServiceManager.getService(ILbsService.class);
        if (iLbsService != null) {
            iLbsService.recordLocation(z, z2);
        }
    }

    public static void resetLocation() {
        ILbsService iLbsService = (ILbsService) BizServiceManager.getService(ILbsService.class);
        if (iLbsService != null) {
            iLbsService.resetLocation();
        }
    }

    public static void setAutoStop(boolean z) {
        ILbsService iLbsService = (ILbsService) BizServiceManager.getService(ILbsService.class);
        if (iLbsService != null) {
            iLbsService.setAutoStop(z);
        }
    }

    public static void unInit() {
        ILbsService iLbsService = (ILbsService) BizServiceManager.getService(ILbsService.class);
        if (iLbsService != null) {
            iLbsService.unInit();
        }
    }

    public static void updateLocationCache() {
        ILbsService iLbsService = (ILbsService) BizServiceManager.getService(ILbsService.class);
        if (iLbsService != null) {
            iLbsService.updateLocationCache();
        }
    }
}
