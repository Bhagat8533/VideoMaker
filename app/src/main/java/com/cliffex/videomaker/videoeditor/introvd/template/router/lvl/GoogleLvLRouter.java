package com.introvd.template.router.lvl;

import android.app.Activity;
import com.introvd.template.router.BizServiceManager;

public class GoogleLvLRouter {
    private static final String PRO_LVL_GROUP = "/pro_lvl/";
    public static final String PRO_LVL_SERVICE = "/pro_lvl/lvl_service";

    public static void doCheck(Activity activity, GoogleLicenseErrorListener googleLicenseErrorListener, GoogleLicenseErrorListener googleLicenseErrorListener2) {
        GoogleLicenseService googleLicenseService = (GoogleLicenseService) BizServiceManager.getService(GoogleLicenseService.class);
        if (googleLicenseService != null) {
            googleLicenseService.checkLicense(activity, googleLicenseErrorListener, googleLicenseErrorListener2);
        }
    }

    public static void doFollowLastLicensingUrl(Activity activity) {
        GoogleLicenseService googleLicenseService = (GoogleLicenseService) BizServiceManager.getService(GoogleLicenseService.class);
        if (googleLicenseService != null) {
            googleLicenseService.followLastLicensingUrl(activity);
        }
    }

    public static void doRelease() {
        GoogleLicenseService googleLicenseService = (GoogleLicenseService) BizServiceManager.getService(GoogleLicenseService.class);
        if (googleLicenseService != null) {
            googleLicenseService.release();
        }
    }
}
