package com.introvd.template.common;

import android.app.Activity;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.common.utils.NotchUtil;
import com.introvd.template.common.utils.UtilsDevice;
import java.util.Locale;

public class Constants {
    public static boolean TEMPLATE_GET_MORE_ENABLE = true;
    private static MSize cci;

    public static MSize getActivityScreenSize(Activity activity) {
        if (activity == null) {
            return null;
        }
        if (VERSION.SDK_INT < 17) {
            return getScreenSize();
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
        int i = displayMetrics.heightPixels;
        if (NotchUtil.isNotchDevice()) {
            i -= UtilsDevice.getStatusBarHeight(activity.getApplication());
        }
        return new MSize(displayMetrics.widthPixels, i);
    }

    public static float getDeviceDensity() {
        VivaBaseApplication FZ = VivaBaseApplication.m8749FZ();
        if (FZ == null) {
            return 1.0f;
        }
        return FZ.getResources().getDisplayMetrics().density;
    }

    public static Locale getLocale() {
        VivaBaseApplication FZ = VivaBaseApplication.m8749FZ();
        return (FZ == null || FZ.getResources() == null || FZ.getResources().getConfiguration() == null) ? Locale.CHINESE : FZ.getResources().getConfiguration().locale;
    }

    public static MSize getScreenSize() {
        if (cci != null) {
            return cci;
        }
        VivaBaseApplication FZ = VivaBaseApplication.m8749FZ();
        if (FZ == null) {
            LogUtilsV2.m14227d("ctx = null ScreenSize : (0,0)");
            return new MSize(0, 0);
        }
        DisplayMetrics displayMetrics = FZ.getResources().getDisplayMetrics();
        int i = displayMetrics.heightPixels;
        if (NotchUtil.isNotchDevice()) {
            i -= UtilsDevice.getStatusBarHeight(FZ);
        }
        cci = new MSize(displayMetrics.widthPixels, i);
        StringBuilder sb = new StringBuilder();
        sb.append("ScreenSize Init : ");
        sb.append(cci);
        LogUtilsV2.m14227d(sb.toString());
        return cci;
    }
}
