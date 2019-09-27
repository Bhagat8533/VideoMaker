package com.introvd.template.datacenter;

public class SocialServiceUserNotify extends BaseSocialNotify {
    private static SocialServiceUserNotify INSTANCE;
    private static long m_lTokenExpiredTime;
    private static int m_nUserLoginState;
    private static String m_strXYToken;

    public static synchronized SocialServiceUserNotify getInstance() {
        SocialServiceUserNotify socialServiceUserNotify;
        synchronized (SocialServiceUserNotify.class) {
            if (INSTANCE == null) {
                INSTANCE = new SocialServiceUserNotify();
            }
            socialServiceUserNotify = INSTANCE;
        }
        return socialServiceUserNotify;
    }

    public static int getUserLoginState() {
        if (1 != m_nUserLoginState || !isTokenExpired()) {
            return m_nUserLoginState;
        }
        return 0;
    }

    public static String getXYAccessToken() {
        return m_strXYToken;
    }

    public static boolean isTokenExpired() {
        return System.currentTimeMillis() >= m_lTokenExpiredTime;
    }

    public static void setUserLoginState(int i) {
        m_nUserLoginState = i;
    }

    public static void setXYAccessToken(String str) {
        m_strXYToken = str;
    }

    public static void setXYAccessTokenExpiredTime(long j) {
        m_lTokenExpiredTime = j;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0038, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void onHandleIntentFailed(android.content.Context r4, android.content.Intent r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            if (r5 != 0) goto L_0x0005
            monitor-exit(r3)
            return
        L_0x0005:
            java.lang.String r0 = "social_method"
            java.lang.String r0 = r5.getStringExtra(r0)     // Catch:{ all -> 0x0039 }
            if (r0 != 0) goto L_0x000f
            monitor-exit(r3)
            return
        L_0x000f:
            java.lang.String r1 = "retry_count"
            r2 = 0
            int r1 = r5.getIntExtra(r1, r2)     // Catch:{ all -> 0x0039 }
            if (r1 <= 0) goto L_0x001a
            monitor-exit(r3)
            return
        L_0x001a:
            java.lang.String r2 = "device.loca"
            boolean r2 = r0.equals(r2)     // Catch:{ all -> 0x0039 }
            if (r2 != 0) goto L_0x002a
            java.lang.String r2 = "account.login"
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0039 }
            if (r0 == 0) goto L_0x0037
        L_0x002a:
            int r1 = r1 + 1
            java.lang.String r0 = "retry_count"
            r5.putExtra(r0, r1)     // Catch:{ all -> 0x0039 }
            r0 = 120000(0x1d4c0, float:1.68156E-40)
            scheduleIntent(r4, r5, r0)     // Catch:{ all -> 0x0039 }
        L_0x0037:
            monitor-exit(r3)
            return
        L_0x0039:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.datacenter.SocialServiceUserNotify.onHandleIntentFailed(android.content.Context, android.content.Intent):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x005d, code lost:
        if (r10 == 131072) goto L_0x005f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00d6 A[Catch:{ all -> 0x011e }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00ea A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00fa A[Catch:{ all -> 0x00f4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0137  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onNotify(android.content.Context r19, java.lang.String r20, java.lang.Object r21, int r22, int r23, android.content.Intent r24, com.introvd.template.p243e.C5542a r25) {
        /*
            r18 = this;
            r8 = r19
            r9 = r20
            r0 = r21
            r10 = r22
            r11 = r23
            r12 = r24
            if (r9 != 0) goto L_0x000f
            return
        L_0x000f:
            if (r10 != 0) goto L_0x0012
            return
        L_0x0012:
            r13 = 0
            if (r12 == 0) goto L_0x001a
            android.os.Bundle r1 = r24.getExtras()
            goto L_0x001b
        L_0x001a:
            r1 = r13
        L_0x001b:
            if (r1 != 0) goto L_0x0022
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
        L_0x0022:
            r14 = r1
            java.lang.String r1 = "social_method"
            r14.putString(r1, r9)
            r4 = 0
            r6 = 0
            r1 = r14
            r2 = r20
            r3 = r23
            fillFeedbackParam(r1, r2, r3, r4, r6)
            r15 = 65536(0x10000, float:9.18355E-41)
            r16 = 0
            r17 = 1
            if (r15 != r10) goto L_0x0053
            if (r11 == 0) goto L_0x0053
            java.lang.String r1 = "socialservice.action.USER"
            boolean r1 = com.introvd.template.datacenter.SocialExceptionHandler.handleErrCode(r8, r1, r9, r11, r13)     // Catch:{ all -> 0x0124 }
            if (r1 == 0) goto L_0x0053
            r4 = 0
            r6 = 0
            r1 = r19
            r2 = r20
            r3 = r23
            reportNetworkError(r1, r2, r3, r4, r6)     // Catch:{ all -> 0x0124 }
        L_0x0053:
            java.lang.String r1 = "device.reg"
            boolean r1 = r9.equals(r1)     // Catch:{ all -> 0x0124 }
            r2 = 131072(0x20000, float:1.83671E-40)
            if (r1 == 0) goto L_0x0061
            if (r10 != r2) goto L_0x00bf
        L_0x005f:
            r1 = 1
            goto L_0x00c0
        L_0x0061:
            java.lang.String r1 = "device.login"
            boolean r1 = r9.equals(r1)     // Catch:{ all -> 0x0124 }
            if (r1 == 0) goto L_0x007a
            if (r10 != r2) goto L_0x00bf
            android.content.Intent r0 = new android.content.Intent     // Catch:{ all -> 0x0124 }
            java.lang.String r1 = "device.login"
            r0.<init>(r1)     // Catch:{ all -> 0x0124 }
            android.support.v4.content.LocalBroadcastManager r1 = android.support.p021v4.content.LocalBroadcastManager.getInstance(r19)     // Catch:{ all -> 0x0124 }
            r1.sendBroadcast(r0)     // Catch:{ all -> 0x0124 }
            goto L_0x005f
        L_0x007a:
            java.lang.String r1 = "account.reg"
            boolean r1 = r9.equals(r1)     // Catch:{ all -> 0x0124 }
            if (r1 == 0) goto L_0x008f
            if (r10 != r2) goto L_0x00bf
            android.os.Bundle r0 = (android.os.Bundle) r0     // Catch:{ all -> 0x0124 }
            r14.putAll(r0)     // Catch:{ all -> 0x0124 }
            java.lang.String r0 = "account.login"
            com.introvd.template.datacenter.BaseSocialNotify.removePendingIntent(r8, r0)     // Catch:{ all -> 0x0124 }
            goto L_0x005f
        L_0x008f:
            java.lang.String r1 = "account.login"
            boolean r1 = r9.equals(r1)     // Catch:{ all -> 0x0124 }
            if (r1 == 0) goto L_0x00ae
            if (r10 == r2) goto L_0x009d
            r0 = -1
            m_nUserLoginState = r0     // Catch:{ all -> 0x0124 }
            goto L_0x00bf
        L_0x009d:
            m_nUserLoginState = r17     // Catch:{ all -> 0x0124 }
            android.content.Intent r0 = new android.content.Intent     // Catch:{ all -> 0x0124 }
            java.lang.String r1 = "account.login"
            r0.<init>(r1)     // Catch:{ all -> 0x0124 }
            android.support.v4.content.LocalBroadcastManager r1 = android.support.p021v4.content.LocalBroadcastManager.getInstance(r19)     // Catch:{ all -> 0x0124 }
            r1.sendBroadcast(r0)     // Catch:{ all -> 0x0124 }
            goto L_0x005f
        L_0x00ae:
            boolean r1 = r0 instanceof com.xiaoying.p448a.C9567f     // Catch:{ all -> 0x0124 }
            if (r1 == 0) goto L_0x00bf
            java.lang.String r1 = "XiaoYingServerResponse"
            com.xiaoying.a.f r0 = (com.xiaoying.p448a.C9567f) r0     // Catch:{ all -> 0x0124 }
            java.lang.Object r0 = r0.eRH     // Catch:{ all -> 0x0124 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0124 }
            r14.putString(r1, r0)     // Catch:{ all -> 0x0124 }
        L_0x00bf:
            r1 = 0
        L_0x00c0:
            java.lang.String r0 = "account.login"
            boolean r0 = r9.equals(r0)     // Catch:{ all -> 0x011e }
            if (r0 != 0) goto L_0x00d0
            java.lang.String r0 = "account.reg"
            boolean r0 = r9.equals(r0)     // Catch:{ all -> 0x011e }
            if (r0 == 0) goto L_0x00d4
        L_0x00d0:
            if (r12 != 0) goto L_0x00d4
            r17 = 0
        L_0x00d4:
            if (r10 != r2) goto L_0x00ea
            java.lang.String r0 = "device.loca"
            boolean r0 = r9.equals(r0)     // Catch:{ all -> 0x011e }
            if (r0 != 0) goto L_0x00e6
            java.lang.String r0 = "account.login"
            boolean r0 = r9.equals(r0)     // Catch:{ all -> 0x011e }
            if (r0 == 0) goto L_0x00f6
        L_0x00e6:
            removePendingIntent(r19, r20)     // Catch:{ all -> 0x011e }
            goto L_0x00f6
        L_0x00ea:
            if (r10 != r15) goto L_0x00f6
            if (r17 == 0) goto L_0x00f6
            r7 = r18
            r7.onHandleIntentFailed(r8, r12)     // Catch:{ all -> 0x00f4 }
            goto L_0x00f8
        L_0x00f4:
            r0 = move-exception
            goto L_0x0121
        L_0x00f6:
            r7 = r18
        L_0x00f8:
            if (r10 == r2) goto L_0x00ff
            java.lang.String r0 = "ServiceErrorCode"
            r14.putInt(r0, r11)     // Catch:{ all -> 0x00f4 }
        L_0x00ff:
            if (r1 == 0) goto L_0x010d
            java.lang.String r2 = "socialservice.action.USER"
            r4 = 0
            r5 = 0
            r1 = r19
            r3 = r20
            com.introvd.template.datacenter.SocialExceptionHandler.setServerAccessAvailable(r1, r2, r3, r4, r5)
        L_0x010d:
            if (r17 == 0) goto L_0x011d
            r1 = r18
            r2 = r19
            r3 = r20
            r4 = r22
            r5 = r14
            r6 = r25
            r1.notifyAllListener(r2, r3, r4, r5, r6)
        L_0x011d:
            return
        L_0x011e:
            r0 = move-exception
            r7 = r18
        L_0x0121:
            r16 = r1
            goto L_0x0127
        L_0x0124:
            r0 = move-exception
            r7 = r18
        L_0x0127:
            if (r16 == 0) goto L_0x0135
            java.lang.String r2 = "socialservice.action.USER"
            r4 = 0
            r5 = 0
            r1 = r19
            r3 = r20
            com.introvd.template.datacenter.SocialExceptionHandler.setServerAccessAvailable(r1, r2, r3, r4, r5)
        L_0x0135:
            if (r17 == 0) goto L_0x0145
            r1 = r18
            r2 = r19
            r3 = r20
            r4 = r22
            r5 = r14
            r6 = r25
            r1.notifyAllListener(r2, r3, r4, r5, r6)
        L_0x0145:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.datacenter.SocialServiceUserNotify.onNotify(android.content.Context, java.lang.String, java.lang.Object, int, int, android.content.Intent, com.introvd.template.e.a):void");
    }
}
