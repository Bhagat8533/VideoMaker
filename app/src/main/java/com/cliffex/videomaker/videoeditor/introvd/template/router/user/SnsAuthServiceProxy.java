package com.introvd.template.router.user;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.introvd.template.router.BizServiceManager;
import com.introvd.template.router.user.model.SnsAuthTransData.Builder;

public class SnsAuthServiceProxy {
    public static void auth(Activity activity, Builder builder) {
        ISnsAuthService iSnsAuthService = (ISnsAuthService) BizServiceManager.getService(ISnsAuthService.class);
        if (iSnsAuthService != null) {
            iSnsAuthService.auth(activity, builder);
        }
    }

    public static void authorizeCallBack(Activity activity, int i, int i2, int i3, Intent intent) {
        ISnsAuthService iSnsAuthService = (ISnsAuthService) BizServiceManager.getService(ISnsAuthService.class);
        if (iSnsAuthService != null) {
            iSnsAuthService.authorizeCallBack(activity, i, i2, i3, intent);
        }
    }

    public static String getScreenNameBySnsType(int i) {
        ISnsAuthService iSnsAuthService = (ISnsAuthService) BizServiceManager.getService(ISnsAuthService.class);
        return iSnsAuthService == null ? "" : iSnsAuthService.getScreenNameBySnsType(i);
    }

    public static boolean isAuthed(int i) {
        ISnsAuthService iSnsAuthService = (ISnsAuthService) BizServiceManager.getService(ISnsAuthService.class);
        if (iSnsAuthService == null) {
            return false;
        }
        return iSnsAuthService.isAuthed(i);
    }

    public static void unAuth(Context context, int i) {
        ISnsAuthService iSnsAuthService = (ISnsAuthService) BizServiceManager.getService(ISnsAuthService.class);
        if (iSnsAuthService != null) {
            iSnsAuthService.unAuth(context, i);
        }
    }

    public static void unregisterAuthListener() {
        ISnsAuthService iSnsAuthService = (ISnsAuthService) BizServiceManager.getService(ISnsAuthService.class);
        if (iSnsAuthService != null) {
            iSnsAuthService.unregisterAuthListener();
        }
    }
}
