package com.introvd.template.common.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import xiaoying.engine.base.QUtils;

public class UtilsDevice {
    private static int ciQ = m14570ZF();
    private static int ciR = m14569ZE();
    private static int ciS = -2;

    /* renamed from: ZE */
    private static int m14569ZE() {
        if (VERSION.SDK_INT >= 16) {
            return QUtils.VIDEO_RES_720P_WIDTH;
        }
        return 0;
    }

    @TargetApi(16)
    /* renamed from: ZF */
    private static int m14570ZF() {
        return 1284;
    }

    public static int getStatusBarHeight(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }
}
