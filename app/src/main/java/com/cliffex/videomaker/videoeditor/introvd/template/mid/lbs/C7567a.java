package com.introvd.template.mid.lbs;

import android.text.TextUtils;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.router.lbs.LocationInfo;
import com.p131c.p132a.p135c.C2575a;

/* renamed from: com.introvd.template.mid.lbs.a */
public class C7567a {
    private static C7567a dLP;
    private AbsLbsManager dLQ = null;

    C7567a() {
    }

    static synchronized C7567a azU() {
        C7567a aVar;
        synchronized (C7567a.class) {
            if (dLP == null) {
                dLP = new C7567a();
            }
            aVar = dLP;
        }
        return aVar;
    }

    private boolean isEnable() {
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x006f, code lost:
        return r1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004e  */
    /* renamed from: Q */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean mo32458Q(android.content.Context r5, boolean r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            boolean r0 = r4.isEnable()     // Catch:{ all -> 0x0070 }
            r1 = 0
            if (r0 != 0) goto L_0x000a
            monitor-exit(r4)
            return r1
        L_0x000a:
            com.introvd.template.mid.lbs.AbsLbsManager r0 = r4.dLQ     // Catch:{ all -> 0x0070 }
            r2 = 1
            if (r0 == 0) goto L_0x0011
            monitor-exit(r4)
            return r2
        L_0x0011:
            if (r6 == 0) goto L_0x0032
            java.lang.String r6 = "/lbs/baidu_lbs_mgr"
            java.lang.Class<com.introvd.template.mid.lbs.AbsLbsManager> r0 = com.introvd.template.mid.lbs.AbsLbsManager.class
            com.aiii.android.arouter.facade.template.c r6 = com.introvd.template.router.BizServiceManager.getService(r6, r0)     // Catch:{ all -> 0x0070 }
            com.introvd.template.mid.lbs.AbsLbsManager r6 = (com.introvd.template.mid.lbs.AbsLbsManager) r6     // Catch:{ all -> 0x0070 }
            r4.dLQ = r6     // Catch:{ all -> 0x0070 }
            com.introvd.template.mid.lbs.AbsLbsManager r6 = r4.dLQ     // Catch:{ all -> 0x0070 }
            if (r6 != 0) goto L_0x0030
            java.lang.String r6 = "/lbs/google_lbs_mgr"
            java.lang.Class<com.introvd.template.mid.lbs.AbsLbsManager> r0 = com.introvd.template.mid.lbs.AbsLbsManager.class
            com.aiii.android.arouter.facade.template.c r6 = com.introvd.template.router.BizServiceManager.getService(r6, r0)     // Catch:{ all -> 0x0070 }
            com.introvd.template.mid.lbs.AbsLbsManager r6 = (com.introvd.template.mid.lbs.AbsLbsManager) r6     // Catch:{ all -> 0x0070 }
            r4.dLQ = r6     // Catch:{ all -> 0x0070 }
            goto L_0x003e
        L_0x0030:
            r6 = 0
            goto L_0x003f
        L_0x0032:
            java.lang.String r6 = "/lbs/google_lbs_mgr"
            java.lang.Class<com.introvd.template.mid.lbs.AbsLbsManager> r0 = com.introvd.template.mid.lbs.AbsLbsManager.class
            com.aiii.android.arouter.facade.template.c r6 = com.introvd.template.router.BizServiceManager.getService(r6, r0)     // Catch:{ all -> 0x0070 }
            com.introvd.template.mid.lbs.AbsLbsManager r6 = (com.introvd.template.mid.lbs.AbsLbsManager) r6     // Catch:{ all -> 0x0070 }
            r4.dLQ = r6     // Catch:{ all -> 0x0070 }
        L_0x003e:
            r6 = 1
        L_0x003f:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0070 }
            r0.<init>()     // Catch:{ all -> 0x0070 }
            java.lang.String r3 = "LBSLBSLBS->nServiceType = "
            r0.append(r3)     // Catch:{ all -> 0x0070 }
            if (r6 != r2) goto L_0x004e
            java.lang.String r3 = "Google"
            goto L_0x0050
        L_0x004e:
            java.lang.String r3 = "Baidu"
        L_0x0050:
            r0.append(r3)     // Catch:{ all -> 0x0070 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0070 }
            com.introvd.template.common.LogUtilsV2.m14227d(r0)     // Catch:{ all -> 0x0070 }
            com.introvd.template.mid.lbs.b r0 = com.introvd.template.mid.lbs.C7568b.azV()     // Catch:{ all -> 0x0070 }
            r0.mo32466ah(r5, r6)     // Catch:{ all -> 0x0070 }
            com.introvd.template.mid.lbs.AbsLbsManager r6 = r4.dLQ     // Catch:{ all -> 0x0070 }
            if (r6 == 0) goto L_0x006e
            com.introvd.template.mid.lbs.AbsLbsManager r6 = r4.dLQ     // Catch:{ all -> 0x0070 }
            boolean r5 = r6.initLbs(r5)     // Catch:{ all -> 0x0070 }
            if (r5 == 0) goto L_0x006e
            r1 = 1
        L_0x006e:
            monitor-exit(r4)
            return r1
        L_0x0070:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.mid.lbs.C7567a.mo32458Q(android.content.Context, boolean):boolean");
    }

    /* access modifiers changed from: 0000 */
    public synchronized LocationInfo getCurrentLocation() {
        LocationInfo locationInfo = new LocationInfo(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, "", "", 0, 0);
        if (!isEnable()) {
            return locationInfo;
        }
        if (this.dLQ == null) {
            return locationInfo;
        }
        return this.dLQ.getCurrentLocation();
    }

    /* access modifiers changed from: 0000 */
    public synchronized boolean recordLocation(boolean z, boolean z2) {
        if (!isEnable()) {
            return false;
        }
        if (this.dLQ == null) {
            return false;
        }
        return this.dLQ.recordLocation(z, z2);
    }

    /* access modifiers changed from: 0000 */
    public synchronized void resetLocation() {
        if (this.dLQ != null) {
            this.dLQ.resetLocation();
        }
    }

    /* access modifiers changed from: 0000 */
    public synchronized void setAutoStop(boolean z) {
        if (isEnable()) {
            if (this.dLQ != null) {
                this.dLQ.setAutoStop(z);
            }
        }
    }

    public synchronized void uninit() {
        if (isEnable()) {
            if (this.dLQ != null) {
                this.dLQ.recordLocation(false, false);
                this.dLQ = null;
                C7568b.azV().uninit();
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public synchronized void updateLocationCache() {
        azU().setAutoStop(true);
        String appSettingStr = AppPreferencesSetting.getInstance().getAppSettingStr("key_last_location_cache_update_time", "");
        if (TextUtils.isEmpty(appSettingStr)) {
            azU().recordLocation(false, false);
            azU().resetLocation();
            azU().recordLocation(true, false);
            AppPreferencesSetting.getInstance().setAppSettingStr("key_last_location_cache_update_time", String.valueOf(System.currentTimeMillis()));
        } else {
            try {
                if (Math.abs(System.currentTimeMillis() - C2575a.parseLong(appSettingStr)) > 43200000) {
                    azU().recordLocation(false, false);
                    azU().resetLocation();
                    azU().recordLocation(true, false);
                    AppPreferencesSetting.getInstance().setAppSettingStr("key_last_location_cache_update_time", String.valueOf(System.currentTimeMillis()));
                }
            } catch (Exception unused) {
            }
        }
    }
}
