package com.introvd.template.gallery;

import android.content.Context;
import com.introvd.template.common.FileUtils;
import com.introvd.template.common.MSize;
import com.introvd.template.common.UserBehaviorLog;
import java.util.HashMap;
import p504io.fabric.sdk.android.services.settings.AppSettingsData;

/* renamed from: com.introvd.template.gallery.a */
public class C7389a {
    /* renamed from: E */
    public static void m21779E(Context context, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("how", str);
        hashMap.put("mode", str2);
        UserBehaviorLog.onKVEvent(context, "Gallery_Enter", hashMap);
    }

    /* renamed from: P */
    public static void m21780P(Context context, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("de_coder", z ? "yes" : "no");
        UserBehaviorLog.onKVEvent(context, "Gallery_Thumbnail_Trim_Icon_Click", hashMap);
    }

    /* renamed from: a */
    public static void m21781a(Context context, int i, int i2, int i3, int i4, boolean z) {
        HashMap hashMap = new HashMap();
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append("");
        hashMap.put("amount", sb.toString());
        hashMap.put("video_amount", i2 > 10 ? ">10" : String.valueOf(i2));
        hashMap.put("pic_amount", i3 > 10 ? ">10" : String.valueOf(i3));
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i4);
        sb2.append("");
        hashMap.put("duration", sb2.toString());
        hashMap.put("gallery_version", z ? AppSettingsData.STATUS_NEW : "old");
        UserBehaviorLog.onKVEvent(context, "Gallery_Next", hashMap);
    }

    /* renamed from: a */
    public static void m21782a(Context context, boolean z, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("which", z ? "forced_tip" : "Not_forced_tip");
        hashMap.put("pic_amount", String.valueOf(i));
        UserBehaviorLog.onKVEvent(context, "Gallery_Next_Tip_Show", hashMap);
    }

    /* renamed from: b */
    public static void m21783b(Context context, int i, int i2, int i3, int i4, boolean z) {
        HashMap hashMap = new HashMap();
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append("");
        hashMap.put("amount", sb.toString());
        hashMap.put("video_amount", i2 > 10 ? ">10" : String.valueOf(i2));
        hashMap.put("pic_amount", i3 > 10 ? ">10" : String.valueOf(i3));
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i4);
        sb2.append("");
        hashMap.put("duration", sb2.toString());
        hashMap.put("gallery_version", z ? AppSettingsData.STATUS_NEW : "old");
        UserBehaviorLog.onKVEvent(context, "Gallery_Next_Create", hashMap);
    }

    /* renamed from: b */
    public static void m21784b(Context context, MSize mSize) {
        if (mSize != null) {
            HashMap hashMap = new HashMap();
            if (mSize.width > mSize.height) {
                hashMap.put("ratio", "横");
            } else if (mSize.width < mSize.height) {
                hashMap.put("ratio", "竖");
            } else {
                hashMap.put("ratio", "方");
            }
            UserBehaviorLog.onKVEvent(context, "Gallery_Add_Video", hashMap);
        }
    }

    /* renamed from: c */
    public static void m21785c(Context context, int i, int i2, int i3, int i4, boolean z) {
        HashMap hashMap = new HashMap();
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append("");
        hashMap.put("amount", sb.toString());
        hashMap.put("video_amount", i2 > 10 ? ">10" : String.valueOf(i2));
        hashMap.put("pic_amount", i3 > 10 ? ">10" : String.valueOf(i3));
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i4);
        sb2.append("");
        hashMap.put("duration", sb2.toString());
        hashMap.put("gallery_version", z ? AppSettingsData.STATUS_NEW : "old");
        UserBehaviorLog.onKVEvent(context, "Gallery_Next_Add_More", hashMap);
    }

    /* renamed from: c */
    public static void m21786c(Context context, MSize mSize) {
        if (mSize != null) {
            HashMap hashMap = new HashMap();
            if (mSize.width > mSize.height) {
                hashMap.put("ratio", "横");
            } else if (mSize.width < mSize.height) {
                hashMap.put("ratio", "竖");
            } else {
                hashMap.put("ratio", "方");
            }
            UserBehaviorLog.onKVEvent(context, "Gallery_Add_Pic", hashMap);
        }
    }

    /* renamed from: fZ */
    public static void m21787fZ(Context context) {
        UserBehaviorLog.onKVEvent(context, "Gallery_Filter_Tab_New_Click", new HashMap());
    }

    /* renamed from: ga */
    public static void m21788ga(Context context) {
        UserBehaviorLog.onKVEvent(context, "Gallery_Capture_Click", new HashMap());
    }

    /* renamed from: gb */
    public static void m21789gb(Context context) {
        UserBehaviorLog.onKVEvent(context, "Gallery_Capture_Done", new HashMap());
    }

    /* renamed from: jy */
    public static void m21790jy(String str) {
        try {
            String formatFileSize = FileUtils.formatFileSize(FileUtils.fileSize(str));
            HashMap hashMap = new HashMap();
            hashMap.put("fileSize", formatFileSize);
            hashMap.put("filepath", str);
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("fexist:");
            sb.append(FileUtils.isFileExisted(str));
            sb.append(";filesize:");
            sb.append(formatFileSize);
            hashMap.put("detailinfo", sb.toString());
            UserBehaviorLog.onAliEvent("Dev_Event_Video_File_AddFail", hashMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: k */
    public static void m21791k(Context context, String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("which", str);
        hashMap.put("how", str2);
        hashMap.put("mode", str3);
        UserBehaviorLog.onKVEvent(context, "Gallery_Exit", hashMap);
    }
}
