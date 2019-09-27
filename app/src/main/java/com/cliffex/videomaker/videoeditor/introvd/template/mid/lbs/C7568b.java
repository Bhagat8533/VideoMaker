package com.introvd.template.mid.lbs;

import android.content.Context;
import com.introvd.template.router.lbs.PlaceListener;

/* renamed from: com.introvd.template.mid.lbs.b */
public class C7568b {
    private static C7568b dLR;
    private AbsPlaceService dLS = null;
    private String dLT = null;

    private C7568b() {
    }

    public static synchronized C7568b azV() {
        C7568b bVar;
        synchronized (C7568b.class) {
            if (dLR == null) {
                dLR = new C7568b();
            }
            bVar = dLR;
        }
        return bVar;
    }

    /* renamed from: a */
    public void mo32465a(Context context, String str, int i, int i2, PlaceListener placeListener) {
        if (this.dLS != null) {
            this.dLS.query(context, this.dLT, str, i < 0 ? 0 : i, i2 <= 0 ? 10 : i2, placeListener);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x006c, code lost:
        return r1;
     */
    /* renamed from: ah */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean mo32466ah(android.content.Context r4, int r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            com.introvd.template.mid.lbs.AbsPlaceService r0 = r3.dLS     // Catch:{ all -> 0x006d }
            r1 = 1
            if (r0 == 0) goto L_0x0008
            monitor-exit(r3)
            return r1
        L_0x0008:
            if (r5 == 0) goto L_0x001b
            java.lang.String r0 = "/lbs/google_place"
            java.lang.Class<com.introvd.template.mid.lbs.AbsPlaceService> r2 = com.introvd.template.mid.lbs.AbsPlaceService.class
            com.aiii.android.arouter.facade.template.c r0 = com.introvd.template.router.BizServiceManager.getService(r0, r2)     // Catch:{ all -> 0x006d }
            com.introvd.template.mid.lbs.AbsPlaceService r0 = (com.introvd.template.mid.lbs.AbsPlaceService) r0     // Catch:{ all -> 0x006d }
            r3.dLS = r0     // Catch:{ all -> 0x006d }
            java.lang.String r0 = "school"
            r3.dLT = r0     // Catch:{ all -> 0x006d }
            goto L_0x002b
        L_0x001b:
            java.lang.String r0 = "/lbs/baidu_place"
            java.lang.Class<com.introvd.template.mid.lbs.AbsPlaceService> r2 = com.introvd.template.mid.lbs.AbsPlaceService.class
            com.aiii.android.arouter.facade.template.c r0 = com.introvd.template.router.BizServiceManager.getService(r0, r2)     // Catch:{ all -> 0x006d }
            com.introvd.template.mid.lbs.AbsPlaceService r0 = (com.introvd.template.mid.lbs.AbsPlaceService) r0     // Catch:{ all -> 0x006d }
            r3.dLS = r0     // Catch:{ all -> 0x006d }
            java.lang.String r0 = "学校$小区"
            r3.dLT = r0     // Catch:{ all -> 0x006d }
        L_0x002b:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x006d }
            r0.<init>()     // Catch:{ all -> 0x006d }
            java.lang.String r2 = "LBSLBSLBS->nServiceType = "
            r0.append(r2)     // Catch:{ all -> 0x006d }
            if (r5 != r1) goto L_0x003a
            java.lang.String r5 = "Google"
            goto L_0x003c
        L_0x003a:
            java.lang.String r5 = "Baidu"
        L_0x003c:
            r0.append(r5)     // Catch:{ all -> 0x006d }
            java.lang.String r5 = r0.toString()     // Catch:{ all -> 0x006d }
            com.introvd.template.common.LogUtilsV2.m14227d(r5)     // Catch:{ all -> 0x006d }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x006d }
            r5.<init>()     // Catch:{ all -> 0x006d }
            java.lang.String r0 = "LBSLBSLBS->mPlaceService = "
            r5.append(r0)     // Catch:{ all -> 0x006d }
            com.introvd.template.mid.lbs.AbsPlaceService r0 = r3.dLS     // Catch:{ all -> 0x006d }
            r5.append(r0)     // Catch:{ all -> 0x006d }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x006d }
            com.introvd.template.common.LogUtilsV2.m14227d(r5)     // Catch:{ all -> 0x006d }
            com.introvd.template.mid.lbs.AbsPlaceService r5 = r3.dLS     // Catch:{ all -> 0x006d }
            if (r5 == 0) goto L_0x0065
            com.introvd.template.mid.lbs.AbsPlaceService r5 = r3.dLS     // Catch:{ all -> 0x006d }
            r5.init(r4)     // Catch:{ all -> 0x006d }
        L_0x0065:
            com.introvd.template.mid.lbs.AbsPlaceService r4 = r3.dLS     // Catch:{ all -> 0x006d }
            if (r4 == 0) goto L_0x006a
            goto L_0x006b
        L_0x006a:
            r1 = 0
        L_0x006b:
            monitor-exit(r3)
            return r1
        L_0x006d:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.mid.lbs.C7568b.mo32466ah(android.content.Context, int):boolean");
    }

    public synchronized void uninit() {
        if (this.dLS != null) {
            this.dLS.unInit();
            this.dLS = null;
        }
    }
}
