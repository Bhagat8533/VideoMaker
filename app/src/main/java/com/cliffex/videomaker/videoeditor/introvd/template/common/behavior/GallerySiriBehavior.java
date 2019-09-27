package com.introvd.template.common.behavior;

import android.content.Context;
import com.introvd.template.common.UserBehaviorLog;
import java.util.HashMap;

public class GallerySiriBehavior {
    public static void recordGalleryEnterEdit(Context context, String str, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("how", str);
        String str2 = "";
        if (i >= 0 && i <= 10) {
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            sb.append("");
            str2 = sb.toString();
        } else if (i > 100) {
            str2 = ">100";
        } else if (i > 10 && i <= 100) {
            int i2 = i / 10;
            if (i % 10 == 0) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(i2 - 1);
                sb2.append("0-");
                sb2.append(i2);
                sb2.append("0");
                str2 = sb2.toString();
            } else {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(i2);
                sb3.append("0-");
                sb3.append(i2 + 1);
                sb3.append("0");
                str2 = sb3.toString();
            }
        }
        hashMap.put("video_clip_count", str2);
        UserBehaviorLog.onKVEvent(context, "Gallery_Enter_Edit", hashMap);
    }

    public static void recordGalleryEnterMv(Context context, String str, int i) {
        HashMap hashMap = new HashMap();
        String str2 = "";
        if (i >= 0 && i <= 10) {
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            sb.append("");
            str2 = sb.toString();
        } else if (i > 100) {
            str2 = ">100";
        } else if (i > 10 && i <= 100) {
            int i2 = i / 10;
            if (i % 10 == 0) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(i2 - 1);
                sb2.append("0-");
                sb2.append(i2);
                sb2.append("0");
                str2 = sb2.toString();
            } else {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(i2);
                sb3.append("0-");
                sb3.append(i2 + 1);
                sb3.append("0");
                str2 = sb3.toString();
            }
        }
        hashMap.put("how", str);
        hashMap.put("pic_clip_count", str2);
        UserBehaviorLog.onKVEvent(context, "Gallery_Enter_MV", hashMap);
    }

    public static void recordShareExportExit(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("how", str);
        UserBehaviorLog.onKVEvent(context, "Share_Export_Page_Exit", hashMap);
    }
}
