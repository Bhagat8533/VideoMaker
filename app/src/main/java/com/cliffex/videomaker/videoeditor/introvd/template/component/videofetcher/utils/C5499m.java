package com.introvd.template.component.videofetcher.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import xiaoying.engine.base.QUtils;

/* renamed from: com.introvd.template.component.videofetcher.utils.m */
public class C5499m {
    private static int ciQ = m14922ZF();
    private static int ciR = m14921ZE();
    private static int ciS = -2;

    /* renamed from: ZE */
    private static int m14921ZE() {
        if (VERSION.SDK_INT >= 16) {
            return QUtils.VIDEO_RES_720P_WIDTH;
        }
        return 0;
    }

    @TargetApi(16)
    /* renamed from: ZF */
    private static int m14922ZF() {
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
