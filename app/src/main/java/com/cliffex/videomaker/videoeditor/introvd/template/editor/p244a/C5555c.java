package com.introvd.template.editor.p244a;

import android.content.Context;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.sdk.model.editor.VideoExportParamsModel;
import java.util.ArrayList;
import java.util.HashMap;
import lib.C12177i;

/* renamed from: com.introvd.template.editor.a.c */
public class C5555c {
    public static final ArrayList<String> cyN = new ArrayList<>();

    static {
        cyN.add("480X480");
        cyN.add("640X480");
        cyN.add("720X1280");
        cyN.add("1280X720");
        cyN.add("1080X1920");
        cyN.add("480X640");
        cyN.add("1920X1080");
        cyN.add("640X360");
        cyN.add("320X240");
        cyN.add("640X640");
        cyN.add("640X368");
        cyN.add("176X144");
        cyN.add("0X0");
    }

    /* renamed from: a */
    public static void m15037a(Context context, VideoExportParamsModel videoExportParamsModel, String str) {
        String str2;
        if (videoExportParamsModel != null && videoExportParamsModel.gifParam != null) {
            HashMap hashMap = new HashMap();
            if (videoExportParamsModel.gifParam.mExpVeRange != null) {
                int i = videoExportParamsModel.gifParam.mExpVeRange.getmTimeLength();
                if (i <= 0 || i > 10000) {
                    str2 = "> 10s";
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("");
                    sb.append(i);
                    str2 = sb.toString();
                }
                hashMap.put("duration", str2);
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("");
            sb2.append(videoExportParamsModel.gifParam.expFps);
            hashMap.put("FPS", sb2.toString());
            if (videoExportParamsModel.gifParam.expSize != null) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("");
                sb3.append(videoExportParamsModel.gifParam.expSize.width);
                hashMap.put("resolution", sb3.toString());
            }
            UserBehaviorLog.onKVEvent(context, str, hashMap);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x007d A[Catch:{ Exception -> 0x00d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0083 A[Catch:{ Exception -> 0x00d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00a9 A[Catch:{ Exception -> 0x00d0 }] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m15038a(android.content.Context r17, xiaoying.engine.QEngine r18, java.lang.String r19, long r20) {
        /*
            if (r19 == 0) goto L_0x00d4
            if (r18 == 0) goto L_0x00d4
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ Exception -> 0x00d0 }
            r2.<init>()     // Catch:{ Exception -> 0x00d0 }
            int r3 = com.introvd.template.sdk.utils.C8572y.m25085d(r18, r19)     // Catch:{ Exception -> 0x00d0 }
            com.introvd.template.sdk.utils.VeMSize r4 = com.introvd.template.sdk.utils.p394b.C8541r.m24980f(r18, r19)     // Catch:{ Exception -> 0x00d0 }
            long r5 = (long) r3     // Catch:{ Exception -> 0x00d0 }
            java.lang.String r5 = m15041an(r5)     // Catch:{ Exception -> 0x00d0 }
            int r6 = r4.width     // Catch:{ Exception -> 0x00d0 }
            java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch:{ Exception -> 0x00d0 }
            int r4 = r4.height     // Catch:{ Exception -> 0x00d0 }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ Exception -> 0x00d0 }
            int r7 = com.introvd.template.sdk.utils.C8572y.m25082c(r18, r19)     // Catch:{ Exception -> 0x00d0 }
            r8 = 2
            if (r7 != r8) goto L_0x002c
            java.lang.String r9 = "mp4"
            goto L_0x002e
        L_0x002c:
            java.lang.String r9 = "h264"
        L_0x002e:
            boolean r10 = com.introvd.template.common.FileUtils.isFileExisted(r19)     // Catch:{ Exception -> 0x00d0 }
            r11 = 0
            r12 = 0
            if (r10 == 0) goto L_0x0055
            long r14 = com.introvd.template.common.FileUtils.fileSize(r19)     // Catch:{ Exception -> 0x00d0 }
            xiaoying.engine.base.QVideoInfo r0 = xiaoying.engine.base.QUtils.getVideoInfo(r18, r19)     // Catch:{ Exception -> 0x00d0 }
            if (r0 == 0) goto L_0x0051
            r1 = 9
            int r1 = r0.get(r1)     // Catch:{ Exception -> 0x00d0 }
            r10 = 10
            int r0 = r0.get(r10)     // Catch:{ Exception -> 0x00d0 }
            r16 = r9
            long r8 = (long) r0     // Catch:{ Exception -> 0x00d0 }
            goto L_0x005a
        L_0x0051:
            r16 = r9
            r8 = r12
            goto L_0x0059
        L_0x0055:
            r16 = r9
            r8 = r12
            r14 = r8
        L_0x0059:
            r1 = 0
        L_0x005a:
            int r3 = r3 / 1000
            int r0 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r0 > 0) goto L_0x006c
            if (r3 <= 0) goto L_0x006c
            int r0 = (r14 > r12 ? 1 : (r14 == r12 ? 0 : -1))
            if (r0 <= 0) goto L_0x006c
            r8 = 8
            long r8 = r8 * r14
            long r12 = (long) r3     // Catch:{ Exception -> 0x00d0 }
            long r8 = r8 / r12
        L_0x006c:
            java.lang.String r0 = "duration"
            r2.put(r0, r5)     // Catch:{ Exception -> 0x00d0 }
            java.lang.String r0 = com.introvd.template.common.behavior.UserBehaviorUtils.getResolutionStr(r6, r4)     // Catch:{ Exception -> 0x00d0 }
            java.util.ArrayList<java.lang.String> r4 = cyN     // Catch:{ Exception -> 0x00d0 }
            boolean r4 = r4.contains(r0)     // Catch:{ Exception -> 0x00d0 }
            if (r4 == 0) goto L_0x0083
            java.lang.String r4 = "resolution"
            r2.put(r4, r0)     // Catch:{ Exception -> 0x00d0 }
            goto L_0x008a
        L_0x0083:
            java.lang.String r0 = "resolution"
            java.lang.String r4 = "other"
            r2.put(r0, r4)     // Catch:{ Exception -> 0x00d0 }
        L_0x008a:
            java.lang.String r0 = "size"
            java.lang.String r4 = m15042av(r14)     // Catch:{ Exception -> 0x00d0 }
            r2.put(r0, r4)     // Catch:{ Exception -> 0x00d0 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00d0 }
            r0.<init>()     // Catch:{ Exception -> 0x00d0 }
            r4 = r16
            r0.append(r4)     // Catch:{ Exception -> 0x00d0 }
            java.lang.String r5 = "_bitrate"
            r0.append(r5)     // Catch:{ Exception -> 0x00d0 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x00d0 }
            r5 = 2
            if (r7 != r5) goto L_0x00aa
            r11 = 1
        L_0x00aa:
            java.lang.String r5 = m15043b(r8, r11)     // Catch:{ Exception -> 0x00d0 }
            r2.put(r0, r5)     // Catch:{ Exception -> 0x00d0 }
            java.lang.String r0 = "fps"
            int r1 = r1 / 1000
            java.lang.String r1 = m15045lc(r1)     // Catch:{ Exception -> 0x00d0 }
            r2.put(r0, r1)     // Catch:{ Exception -> 0x00d0 }
            java.lang.String r0 = "codec"
            r2.put(r0, r4)     // Catch:{ Exception -> 0x00d0 }
            java.lang.String r0 = "time ratio"
            r4 = 1000(0x3e8, double:4.94E-321)
            long r4 = r20 / r4
            long r6 = (long) r3     // Catch:{ Exception -> 0x00d0 }
            java.lang.String r1 = m15044f(r4, r6)     // Catch:{ Exception -> 0x00d0 }
            r2.put(r0, r1)     // Catch:{ Exception -> 0x00d0 }
            goto L_0x00d4
        L_0x00d0:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00d4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.editor.p244a.C5555c.m15038a(android.content.Context, xiaoying.engine.QEngine, java.lang.String, long):void");
    }

    /* renamed from: aI */
    public static void m15039aI(Context context, String str) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("type_ID", str);
            UserBehaviorLog.onKVEvent(context, "Share_Export_Template", hashMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: aJ */
    public static void m15040aJ(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("BGM_name", str);
        UserBehaviorLog.onKVEvent(context, "Share_Export_Template_BGM", hashMap);
    }

    /* renamed from: an */
    public static String m15041an(long j) {
        return j <= 10000 ? "<10s" : j <= 30000 ? "10s-30s" : j <= DefaultLoadErrorHandlingPolicy.DEFAULT_TRACK_BLACKLIST_MS ? "30s-1m" : j <= 120000 ? "1m-2m" : j <= 180000 ? "2m-3m" : j <= 240000 ? "3m-4m" : j <= 300000 ? "4m-5m" : j <= 360000 ? "5m-6m" : j <= 420000 ? "6m-7m" : j <= 480000 ? "7m-8m" : j <= 540000 ? "8m-9m" : j <= C12177i.f6154j ? "9m-10m" : ">10m";
    }

    /* renamed from: av */
    public static String m15042av(long j) {
        if (j <= 0) {
            return "0";
        }
        long j2 = j / 1000000;
        int i = (j2 > 1 ? 1 : (j2 == 1 ? 0 : -1));
        String str = i < 0 ? "<1M" : (i < 0 || j2 >= 5) ? (j2 < 5 || j2 >= 10) ? (j2 < 10 || j2 >= 50) ? (j2 < 50 || j2 >= 100) ? (j2 < 100 || j2 >= 500) ? (j2 < 500 || j2 >= 1000) ? (j2 < 1000 || j2 >= 1500) ? (j2 < 1500 || j2 >= AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS) ? ">2000M" : "1500M-2000M" : "1000M-1500M" : "500M-1000M" : "100M-500M" : "50M-100M" : "10M-50M" : "5M-10M" : "1-5M";
        return str;
    }

    /* renamed from: b */
    public static String m15043b(long j, boolean z) {
        String str;
        if (j <= 0) {
            return "0";
        }
        if (z) {
            long j2 = j / 1000;
            int i = (j2 > 1000 ? 1 : (j2 == 1000 ? 0 : -1));
            str = i < 0 ? "<1m" : (i < 0 || j2 >= AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS) ? (j2 < AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS || j2 >= 3000) ? (j2 < 3000 || j2 > 4000) ? ">4.0m" : "3m-4m" : "2m-3m" : "1m-2m";
        } else {
            long j3 = j / 1000;
            int i2 = (j3 > 500 ? 1 : (j3 == 500 ? 0 : -1));
            str = i2 < 0 ? "<0.5m" : (i2 < 0 || j3 >= 1000) ? (j3 < 1000 || j3 >= 1500) ? (j3 < 1500 || j3 > AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS) ? ">2.0m" : "1.5m-2.0m" : "1m-1.5m" : "0.5m-1m";
        }
        return str;
    }

    /* renamed from: f */
    public static String m15044f(long j, long j2) {
        if (j2 <= 0) {
            return "0";
        }
        float f = ((float) j) / ((float) j2);
        return f < 0.5f ? "<0.5" : (f < 0.5f || f >= 1.0f) ? (f < 1.0f || f >= 1.5f) ? (f < 1.5f || f > 2.0f) ? ">2" : "1.5-2" : "1-1.5" : "0.5-1";
    }

    /* renamed from: lc */
    public static String m15045lc(int i) {
        return i < 15 ? "<15" : (i < 15 || i > 25) ? ">25" : "15-25";
    }
}
