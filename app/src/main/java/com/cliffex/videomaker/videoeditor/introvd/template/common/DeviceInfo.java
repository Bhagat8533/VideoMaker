package com.introvd.template.common;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.support.p021v4.app.ActivityCompat;
import android.text.TextUtils;
import android.view.WindowManager;
import com.ironsource.environment.ConnectivityService;
import java.util.UUID;

public class DeviceInfo {
    private static float bKM = -1.0f;
    private static MSize bLT;
    private static String cck;
    private static String ccl;
    private static String ccm;

    /* renamed from: ea */
    private static String m14218ea(Context context) {
        String str = "";
        try {
            ActivityCompat.checkSelfPermission(context, "android.permission.READ_PHONE_STATE");
        } catch (Exception unused) {
        }
        if (str.trim().length() > 1) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("XYI");
        sb.append(UUID.randomUUID().toString());
        return sb.toString();
    }

    /* renamed from: eb */
    private static String m14219eb(Context context) {
        String str = "";
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService(ConnectivityService.NETWORK_TYPE_WIFI);
            WifiInfo wifiInfo = null;
            if (wifiManager != null) {
                wifiInfo = wifiManager.getConnectionInfo();
            }
            if (wifiInfo != null) {
                str = wifiInfo.getMacAddress();
            }
        } catch (Exception unused) {
        }
        if (str != null && str.trim().length() > 1) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("XYM");
        sb.append(UUID.randomUUID().toString());
        return sb.toString();
    }

    public static String getAndroidId(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(Secure.getString(context.getContentResolver(), "android_id"));
        return sb.toString();
    }

    public static String getLocalMacAddress(Context context) {
        if (ccl == null) {
            try {
                AppPreferencesSetting.getInstance().init(context);
                ccl = AppPreferencesSetting.getInstance().getAppSettingStr("pref_devinfo_mac", "");
                if (!TextUtils.isEmpty(ccl)) {
                    return ccl;
                }
                ccl = m14219eb(context);
                AppPreferencesSetting.getInstance().setAppSettingStr("pref_devinfo_mac", ccl);
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("exception:");
                sb.append(e.getMessage());
                LogUtilsV2.m14230i(sb.toString());
            }
        }
        return ccl;
    }

    public static String getModule() {
        return Build.MODEL;
    }

    public static String getOpenUDID(Context context) {
        if (ccm == null) {
            String localMacAddress = getLocalMacAddress(context);
            long hashCode = (long) getAndroidId(context).hashCode();
            long hashCode2 = ((long) localMacAddress.hashCode()) << 32;
            ccm = new UUID(hashCode, ((long) getPhoneIMEI(context).hashCode()) | hashCode2).toString();
        }
        return ccm;
    }

    public static String getPhoneIMEI(Context context) {
        if (cck == null) {
            AppPreferencesSetting.getInstance().init(context);
            cck = AppPreferencesSetting.getInstance().getAppSettingStr("pref_devinfo_imei", "");
            if (!TextUtils.isEmpty(cck)) {
                return cck;
            }
            cck = m14218ea(context);
            AppPreferencesSetting.getInstance().setAppSettingStr("pref_devinfo_imei", cck);
        }
        return cck;
    }

    public static String getSDK() {
        return String.valueOf(VERSION.SDK_INT);
    }

    public static String getSDKVersion() {
        return VERSION.RELEASE;
    }

    public static synchronized MSize getScreenSize(Context context) {
        MSize mSize;
        synchronized (DeviceInfo.class) {
            if (bLT == null) {
                bLT = new MSize();
                WindowManager windowManager = (WindowManager) context.getSystemService("window");
                bLT.width = windowManager.getDefaultDisplay().getWidth();
                bLT.height = windowManager.getDefaultDisplay().getHeight();
            }
            mSize = bLT;
        }
        return mSize;
    }
}
