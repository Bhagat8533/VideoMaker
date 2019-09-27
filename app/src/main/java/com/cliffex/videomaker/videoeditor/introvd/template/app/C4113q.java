package com.introvd.template.app;

import android.content.ContentResolver;
import android.content.Context;
import android.text.TextUtils;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.common.LogUtils;
import com.introvd.template.datacenter.SocialServiceDef;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p317h.C7513a;
import com.introvd.template.p317h.C7514b;
import com.ironsource.sdk.constants.Constants.RequestParameters;
import java.util.UUID;

/* renamed from: com.introvd.template.app.q */
public class C4113q {
    /* renamed from: HC */
    private static String m10216HC() {
        return C7514b.m22231b(VivaBaseApplication.m8749FZ().getContentResolver(), null, "-1");
    }

    /* renamed from: bE */
    public static void m10217bE(Context context) {
        synchronized (C4388u.class) {
            m10218bF(context);
        }
    }

    /* renamed from: bF */
    private static boolean m10218bF(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        String b = C7514b.m22231b(contentResolver, C7513a.m22229l(contentResolver, SocialServiceDef.XIAOYING_CURRENT_ACCOUNT), null);
        if (TextUtils.isEmpty(b)) {
            b = C4580b.m11638W(UUID.randomUUID().getLeastSignificantBits() + UUID.randomUUID().getMostSignificantBits());
            C7514b.m22230a(contentResolver, -1, b, "", b);
            C7513a.m22227a(contentResolver, SocialServiceDef.XIAOYING_CURRENT_ACCOUNT, b);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("init studioName[");
        sb.append(b);
        sb.append(RequestParameters.RIGHT_BRACKETS);
        LogUtils.m14222e("XiaoYing", sb.toString());
        return false;
    }

    /* renamed from: dk */
    private static String m10219dk(String str) {
        if (!TextUtils.isEmpty(str)) {
            return C7514b.m22231b(VivaBaseApplication.m8749FZ().getContentResolver(), str, null);
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x005f, code lost:
        if (com.introvd.template.common.FileUtils.isDirectoryExisted(r6.toString()) == false) goto L_0x0061;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x003d, code lost:
        if (com.introvd.template.common.FileUtils.isDirectoryExisted(r6.toString()) == false) goto L_0x003f;
     */
    /* renamed from: h */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized boolean m10220h(int r10, java.lang.String r11, java.lang.String r12) {
        /*
            java.lang.Class<com.introvd.template.app.q> r0 = com.introvd.template.app.C4113q.class
            monitor-enter(r0)
            com.introvd.template.VivaBaseApplication r1 = com.introvd.template.VivaBaseApplication.m8749FZ()     // Catch:{ all -> 0x00c7 }
            r2 = 1
            com.introvd.template.app.C4388u.closeDatabase(r1, r2)     // Catch:{ all -> 0x00c7 }
            com.introvd.template.VivaBaseApplication r1 = com.introvd.template.VivaBaseApplication.m8749FZ()     // Catch:{ all -> 0x00c7 }
            android.content.ContentResolver r1 = r1.getContentResolver()     // Catch:{ all -> 0x00c7 }
            java.lang.String r3 = "AppCurAccount"
            java.lang.String r3 = com.introvd.template.p317h.C7513a.m22229l(r1, r3)     // Catch:{ all -> 0x00c7 }
            java.lang.String r3 = m10219dk(r3)     // Catch:{ all -> 0x00c7 }
            java.lang.String r4 = m10219dk(r11)     // Catch:{ all -> 0x00c7 }
            r5 = 0
            boolean r6 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x00c7 }
            if (r6 != 0) goto L_0x003f
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c7 }
            r6.<init>()     // Catch:{ all -> 0x00c7 }
            java.lang.String r7 = com.introvd.template.common.CommonConfigure.APP_DATA_PATH     // Catch:{ all -> 0x00c7 }
            r6.append(r7)     // Catch:{ all -> 0x00c7 }
            r6.append(r4)     // Catch:{ all -> 0x00c7 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x00c7 }
            boolean r6 = com.introvd.template.common.FileUtils.isDirectoryExisted(r6)     // Catch:{ all -> 0x00c7 }
            if (r6 != 0) goto L_0x0044
        L_0x003f:
            java.lang.String r4 = m10216HC()     // Catch:{ all -> 0x00c7 }
            r5 = r4
        L_0x0044:
            boolean r6 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x00c7 }
            if (r6 != 0) goto L_0x0061
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c7 }
            r6.<init>()     // Catch:{ all -> 0x00c7 }
            java.lang.String r7 = com.introvd.template.common.CommonConfigure.APP_DATA_PATH     // Catch:{ all -> 0x00c7 }
            r6.append(r7)     // Catch:{ all -> 0x00c7 }
            r6.append(r4)     // Catch:{ all -> 0x00c7 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x00c7 }
            boolean r6 = com.introvd.template.common.FileUtils.isDirectoryExisted(r6)     // Catch:{ all -> 0x00c7 }
            if (r6 != 0) goto L_0x009f
        L_0x0061:
            java.util.UUID r4 = java.util.UUID.randomUUID()     // Catch:{ all -> 0x00c7 }
            long r6 = r4.getLeastSignificantBits()     // Catch:{ all -> 0x00c7 }
            java.util.UUID r4 = java.util.UUID.randomUUID()     // Catch:{ all -> 0x00c7 }
            long r8 = r4.getMostSignificantBits()     // Catch:{ all -> 0x00c7 }
            r4 = 0
            long r6 = r6 + r8
            java.lang.String r4 = com.introvd.template.p203b.C4580b.m11638W(r6)     // Catch:{ all -> 0x00c7 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c7 }
            r6.<init>()     // Catch:{ all -> 0x00c7 }
            java.lang.String r7 = com.introvd.template.common.CommonConfigure.APP_DATA_PATH     // Catch:{ all -> 0x00c7 }
            r6.append(r7)     // Catch:{ all -> 0x00c7 }
            r6.append(r4)     // Catch:{ all -> 0x00c7 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x00c7 }
            com.introvd.template.common.FileUtils.createMultilevelDirectory(r6)     // Catch:{ all -> 0x00c7 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c7 }
            r6.<init>()     // Catch:{ all -> 0x00c7 }
            java.lang.String r7 = com.introvd.template.common.CommonConfigure.APP_DATA_PATH     // Catch:{ all -> 0x00c7 }
            r6.append(r7)     // Catch:{ all -> 0x00c7 }
            r6.append(r4)     // Catch:{ all -> 0x00c7 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x00c7 }
            com.introvd.template.C4677g.m12179cT(r6)     // Catch:{ all -> 0x00c7 }
        L_0x009f:
            android.net.Uri r10 = com.introvd.template.p317h.C7514b.m22230a(r1, r10, r11, r12, r4)     // Catch:{ all -> 0x00c7 }
            if (r10 == 0) goto L_0x00b5
            boolean r10 = android.text.TextUtils.equals(r4, r5)     // Catch:{ all -> 0x00c7 }
            if (r10 == 0) goto L_0x00b0
            java.lang.String r10 = "-1"
            com.introvd.template.p317h.C7514b.m22233n(r1, r10)     // Catch:{ all -> 0x00c7 }
        L_0x00b0:
            java.lang.String r10 = "AppCurAccount"
            com.introvd.template.p317h.C7513a.m22227a(r1, r10, r11)     // Catch:{ all -> 0x00c7 }
        L_0x00b5:
            com.introvd.template.VivaBaseApplication r10 = com.introvd.template.VivaBaseApplication.m8749FZ()     // Catch:{ all -> 0x00c7 }
            android.content.Context r10 = r10.getApplicationContext()     // Catch:{ all -> 0x00c7 }
            m10217bE(r10)     // Catch:{ all -> 0x00c7 }
            boolean r10 = android.text.TextUtils.equals(r4, r3)     // Catch:{ all -> 0x00c7 }
            r10 = r10 ^ r2
            monitor-exit(r0)
            return r10
        L_0x00c7:
            r10 = move-exception
            monitor-exit(r0)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.app.C4113q.m10220h(int, java.lang.String, java.lang.String):boolean");
    }
}
