package com.aiii.sdk.android.oss.common.utils;

import android.os.Build;
import android.os.Build.VERSION;
import com.aiii.sdk.android.oss.common.OSSLog;

public class VersionInfoUtils {
    private static String userAgent;

    private static String getSystemInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append(System.getProperty("os.name"));
        StringBuilder sb2 = new StringBuilder();
        sb2.append("/Android ");
        sb2.append(VERSION.RELEASE);
        sb.append(sb2.toString());
        sb.append("/");
        StringBuilder sb3 = new StringBuilder();
        sb3.append(HttpUtil.urlEncode(Build.MODEL, "utf-8"));
        sb3.append(";");
        sb3.append(HttpUtil.urlEncode(Build.ID, "utf-8"));
        sb.append(sb3.toString());
        sb.append(")");
        String sb4 = sb.toString();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("user agent : ");
        sb5.append(sb4);
        OSSLog.logDebug(sb5.toString());
        return OSSUtils.isEmptyString(sb4) ? System.getProperty("http.agent").replaceAll("[^\\p{ASCII}]", "?") : sb4;
    }

    public static String getUserAgent(String str) {
        if (OSSUtils.isEmptyString(userAgent)) {
            StringBuilder sb = new StringBuilder();
            sb.append("aliyun-sdk-android/");
            sb.append(getVersion());
            sb.append(getSystemInfo());
            userAgent = sb.toString();
        }
        if (OSSUtils.isEmptyString(str)) {
            return userAgent;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(userAgent);
        sb2.append("/");
        sb2.append(str);
        return sb2.toString();
    }

    public static String getVersion() {
        return "2.9.2";
    }
}
