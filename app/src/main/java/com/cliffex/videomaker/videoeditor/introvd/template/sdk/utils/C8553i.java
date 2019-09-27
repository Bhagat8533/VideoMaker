package com.introvd.template.sdk.utils;

import android.content.Context;

/* renamed from: com.introvd.template.sdk.utils.i */
public class C8553i {
    private static final String TAG = "i";
    private static Context mContext;

    public static void setContext(Context context) {
        if (context != null) {
            mContext = context.getApplicationContext();
        }
    }

    /* renamed from: ut */
    public static boolean m25005ut(int i) {
        boolean z = false;
        boolean z2 = (65536 & i) != 0;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            C8567u.setContext(mContext);
            C8567u.m25055uu(i);
            long currentTimeMillis2 = System.currentTimeMillis();
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("PreInstall nLoadMode:");
            sb.append(i);
            C8554j.m25007e(str, sb.toString());
            String str2 = TAG;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("PreInstall cost:");
            sb2.append(currentTimeMillis2 - currentTimeMillis);
            C8554j.m25007e(str2, sb2.toString());
        } catch (Exception e) {
            String str3 = TAG;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("exception:");
            sb3.append(e.getMessage());
            C8554j.m25007e(str3, sb3.toString());
        } catch (Throwable th) {
            C8554j.m25007e(TAG, th.getMessage());
        }
        if ((i & 1) == 1) {
            C8567u.m25053os("libcesplatform.so");
            C8567u.m25053os("libx264.so");
            C8567u.m25053os("libffmpeg.so");
            C8567u.m25053os("libpostprocess.so");
            C8567u.m25053os("libcesplatformutils.so");
            C8567u.m25053os("libcescommon.so");
        }
        if ((i & 4) == 4) {
            C8567u.m25053os("libcesrenderengine.so");
            C8567u.m25053os("libasp.so");
            C8567u.m25053os("libcesmediabase.so");
        }
        if ((i & 23) == 23) {
            C8567u.m25053os("libArcSoftSpotlight.so");
            C8567u.m25053os("libdtdetector.so");
            C8567u.m25053os("libcesliveeditor.so");
        }
        if ((i & 55) == 55) {
            C8567u.m25053os("libcescamengine.so");
        }
        if (!z2) {
            C8567u.aJk();
        }
        z = true;
        long currentTimeMillis3 = System.currentTimeMillis();
        String str4 = TAG;
        StringBuilder sb4 = new StringBuilder();
        sb4.append("cost:");
        sb4.append(currentTimeMillis3 - currentTimeMillis);
        C8554j.m25007e(str4, sb4.toString());
        return z;
    }
}
