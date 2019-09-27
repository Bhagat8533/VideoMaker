package com.introvd.template.app;

/* renamed from: com.introvd.template.app.h */
public class C3885h {
    /* JADX WARNING: Removed duplicated region for block: B:29:0x009f A[SYNTHETIC, Splitter:B:29:0x009f] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00ab A[SYNTHETIC, Splitter:B:37:0x00ab] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00be A[Catch:{ Throwable -> 0x00e6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00f4 A[Catch:{ Throwable -> 0x0135 }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x010b A[Catch:{ Throwable -> 0x0135 }] */
    /* renamed from: Hs */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m9561Hs() {
        /*
            java.io.File r0 = new java.io.File
            java.lang.String r1 = com.introvd.template.common.CommonConfigure.APP_DATA_PATH
            java.lang.String r2 = "AppCfg.json"
            r0.<init>(r1, r2)
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            boolean r2 = r0.exists()
            r3 = 0
            if (r2 == 0) goto L_0x00b3
            r2 = 0
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ Throwable -> 0x00a8, all -> 0x009b }
            r4.<init>(r0)     // Catch:{ Throwable -> 0x00a8, all -> 0x009b }
            r0 = 4096(0x1000, float:5.74E-42)
            byte[] r0 = new byte[r0]     // Catch:{ Throwable -> 0x0099, all -> 0x0097 }
            com.xiaoying.a.b.a.b r2 = new com.xiaoying.a.b.a.b     // Catch:{ Throwable -> 0x0099, all -> 0x0097 }
            int r5 = r4.available()     // Catch:{ Throwable -> 0x0099, all -> 0x0097 }
            r2.<init>(r5)     // Catch:{ Throwable -> 0x0099, all -> 0x0097 }
        L_0x0028:
            int r5 = r0.length     // Catch:{ Throwable -> 0x0099, all -> 0x0097 }
            int r5 = r4.read(r0, r3, r5)     // Catch:{ Throwable -> 0x0099, all -> 0x0097 }
            long r5 = (long) r5     // Catch:{ Throwable -> 0x0099, all -> 0x0097 }
            r7 = 0
            int r7 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r7 <= 0) goto L_0x0039
            int r5 = (int) r5     // Catch:{ Throwable -> 0x0099, all -> 0x0097 }
            r2.append(r0, r3, r5)     // Catch:{ Throwable -> 0x0099, all -> 0x0097 }
            goto L_0x0028
        L_0x0039:
            java.lang.String r0 = new java.lang.String     // Catch:{ Throwable -> 0x0099, all -> 0x0097 }
            byte[] r2 = r2.buffer()     // Catch:{ Throwable -> 0x0099, all -> 0x0097 }
            java.lang.String r5 = "UTF-8"
            java.nio.charset.Charset r5 = java.nio.charset.Charset.forName(r5)     // Catch:{ Throwable -> 0x0099, all -> 0x0097 }
            r0.<init>(r2, r5)     // Catch:{ Throwable -> 0x0099, all -> 0x0097 }
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Throwable -> 0x0099, all -> 0x0097 }
            r2.<init>(r0)     // Catch:{ Throwable -> 0x0099, all -> 0x0097 }
            java.util.Iterator r0 = r2.keys()     // Catch:{ Throwable -> 0x0099, all -> 0x0097 }
        L_0x0051:
            boolean r5 = r0.hasNext()     // Catch:{ Throwable -> 0x0099, all -> 0x0097 }
            if (r5 == 0) goto L_0x0093
            java.lang.Object r5 = r0.next()     // Catch:{ Throwable -> 0x0099, all -> 0x0097 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Throwable -> 0x0099, all -> 0x0097 }
            java.lang.Object r6 = r2.get(r5)     // Catch:{ Throwable -> 0x0099, all -> 0x0097 }
            boolean r7 = r6 instanceof org.json.JSONArray     // Catch:{ Throwable -> 0x0099, all -> 0x0097 }
            if (r7 == 0) goto L_0x008f
            org.json.JSONArray r6 = (org.json.JSONArray) r6     // Catch:{ Throwable -> 0x0099, all -> 0x0097 }
            java.util.HashMap r7 = new java.util.HashMap     // Catch:{ Throwable -> 0x0099, all -> 0x0097 }
            r7.<init>()     // Catch:{ Throwable -> 0x0099, all -> 0x0097 }
            r8 = 0
        L_0x006d:
            int r9 = r6.length()     // Catch:{ Throwable -> 0x0099, all -> 0x0097 }
            if (r8 >= r9) goto L_0x008b
            org.json.JSONObject r9 = r6.getJSONObject(r8)     // Catch:{ Throwable -> 0x0099, all -> 0x0097 }
            java.util.Iterator r10 = r9.keys()     // Catch:{ Throwable -> 0x0099, all -> 0x0097 }
            java.lang.Object r10 = r10.next()     // Catch:{ Throwable -> 0x0099, all -> 0x0097 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ Throwable -> 0x0099, all -> 0x0097 }
            java.lang.Object r9 = r9.get(r10)     // Catch:{ Throwable -> 0x0099, all -> 0x0097 }
            r7.put(r10, r9)     // Catch:{ Throwable -> 0x0099, all -> 0x0097 }
            int r8 = r8 + 1
            goto L_0x006d
        L_0x008b:
            r1.put(r5, r7)     // Catch:{ Throwable -> 0x0099, all -> 0x0097 }
            goto L_0x0051
        L_0x008f:
            r1.put(r5, r6)     // Catch:{ Throwable -> 0x0099, all -> 0x0097 }
            goto L_0x0051
        L_0x0093:
            r4.close()     // Catch:{ IOException -> 0x00af }
            goto L_0x00b3
        L_0x0097:
            r0 = move-exception
            goto L_0x009d
        L_0x0099:
            goto L_0x00a9
        L_0x009b:
            r0 = move-exception
            r4 = r2
        L_0x009d:
            if (r4 == 0) goto L_0x00a7
            r4.close()     // Catch:{ IOException -> 0x00a3 }
            goto L_0x00a7
        L_0x00a3:
            r1 = move-exception
            r1.printStackTrace()
        L_0x00a7:
            throw r0
        L_0x00a8:
            r4 = r2
        L_0x00a9:
            if (r4 == 0) goto L_0x00b3
            r4.close()     // Catch:{ IOException -> 0x00af }
            goto L_0x00b3
        L_0x00af:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00b3:
            r0 = 1
            java.lang.String r2 = "debug"
            java.lang.Object r2 = r1.get(r2)     // Catch:{ Throwable -> 0x00e6 }
            java.util.Map r2 = (java.util.Map) r2     // Catch:{ Throwable -> 0x00e6 }
            if (r2 == 0) goto L_0x00ea
            java.lang.String r4 = "debug"
            java.lang.Object r2 = r2.get(r4)     // Catch:{ Throwable -> 0x00e6 }
            java.lang.String r4 = java.lang.String.valueOf(r0)     // Catch:{ Throwable -> 0x00e6 }
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ Throwable -> 0x00e6 }
            boolean r2 = r4.equals(r2)     // Catch:{ Throwable -> 0x00e6 }
            if (r2 == 0) goto L_0x00dc
            java.lang.String r2 = "debug"
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r0)     // Catch:{ Throwable -> 0x00e6 }
            com.xiaoying.p448a.C9537b.setParameter(r2, r3)     // Catch:{ Throwable -> 0x00e6 }
            goto L_0x00ea
        L_0x00dc:
            java.lang.String r2 = "debug"
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)     // Catch:{ Throwable -> 0x00e6 }
            com.xiaoying.p448a.C9537b.setParameter(r2, r3)     // Catch:{ Throwable -> 0x00e6 }
            goto L_0x00ea
        L_0x00e6:
            r2 = move-exception
            r2.printStackTrace()
        L_0x00ea:
            java.lang.String r2 = "httpheaders"
            java.lang.Object r1 = r1.get(r2)     // Catch:{ Throwable -> 0x0135 }
            java.util.Map r1 = (java.util.Map) r1     // Catch:{ Throwable -> 0x0135 }
            if (r1 != 0) goto L_0x00f9
            java.util.HashMap r1 = new java.util.HashMap     // Catch:{ Throwable -> 0x0135 }
            r1.<init>()     // Catch:{ Throwable -> 0x0135 }
        L_0x00f9:
            com.introvd.template.common.AppPreferencesSetting r2 = com.introvd.template.common.AppPreferencesSetting.getInstance()     // Catch:{ Throwable -> 0x0135 }
            java.lang.String r3 = "app_ip_key"
            java.lang.String r4 = ""
            java.lang.String r2 = r2.getAppSettingStr(r3, r4)     // Catch:{ Throwable -> 0x0135 }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Throwable -> 0x0135 }
            if (r3 != 0) goto L_0x0120
            java.lang.String r3 = "X-Forwarded-For"
            r1.put(r3, r2)     // Catch:{ Throwable -> 0x0135 }
            com.introvd.template.apicore.b r3 = com.introvd.template.apicore.C3624b.m8865GC()     // Catch:{ Throwable -> 0x0135 }
            r3.mo22950cU(r2)     // Catch:{ Throwable -> 0x0135 }
            java.lang.String r2 = "debug"
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)     // Catch:{ Throwable -> 0x0135 }
            com.xiaoying.p448a.C9537b.setParameter(r2, r0)     // Catch:{ Throwable -> 0x0135 }
        L_0x0120:
            com.introvd.template.common.AppPreferencesSetting r0 = com.introvd.template.common.AppPreferencesSetting.getInstance()     // Catch:{ Throwable -> 0x0135 }
            java.lang.String r2 = "AppKey"
            java.lang.String r3 = ""
            java.lang.String r0 = r0.getAppSettingStr(r2, r3)     // Catch:{ Throwable -> 0x0135 }
            android.text.TextUtils.isEmpty(r0)     // Catch:{ Throwable -> 0x0135 }
            java.lang.String r0 = "HttpHeaders"
            com.xiaoying.p448a.C9537b.setParameter(r0, r1)     // Catch:{ Throwable -> 0x0135 }
            goto L_0x0139
        L_0x0135:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0139:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.app.C3885h.m9561Hs():void");
    }
}
