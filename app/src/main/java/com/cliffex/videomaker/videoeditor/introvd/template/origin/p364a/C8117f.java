package com.introvd.template.origin.p364a;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.app.C3740b;
import com.introvd.template.app.p177b.C3742b;
import com.introvd.template.channel.C5206b;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.router.app.config.AppConfigObserver;
import com.introvd.template.router.app.device.DeviceUserProxy;
import com.introvd.template.router.user.UserServiceProxy;
import p037b.p050b.C1850u;
import p037b.p050b.p054b.C1495b;

/* renamed from: com.introvd.template.origin.a.f */
class C8117f {
    private static volatile C8117f dWC;
    /* access modifiers changed from: private */
    public C8114c dWA = new C8114c();
    /* access modifiers changed from: private */
    public boolean dWB = false;
    /* access modifiers changed from: private */
    public C8112a dWy = new C8112a();
    private C8116e dWz = new C8116e();

    private C8117f() {
    }

    public static C8117f aEU() {
        if (dWC == null) {
            synchronized (C8117f.class) {
                if (dWC == null) {
                    dWC = new C8117f();
                }
            }
        }
        return dWC;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo33155a(AppConfigObserver appConfigObserver) {
        if (appConfigObserver != null) {
            appConfigObserver.onChange(1, aES());
            this.dWA.mo33152b(appConfigObserver);
        }
    }

    /* access modifiers changed from: 0000 */
    public String aES() {
        return this.dWy.aES();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: iO */
    public void mo33157iO(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("AppConfig: refreshAppConfig isWorking = ");
        sb.append(this.dWB);
        LogUtilsV2.m14230i(sb.toString());
        if (!this.dWB) {
            VivaBaseApplication FZ = VivaBaseApplication.m8749FZ();
            String userId = UserServiceProxy.getUserId();
            String duid = DeviceUserProxy.getDuid();
            final String countryCode = AppStateModel.getInstance().getCountryCode();
            String zoneCode = AppStateModel.getInstance().getZoneCode();
            final String Si = C4580b.m11635Si();
            final String d = C8112a.m23495d(userId, duid, zoneCode, Si, countryCode);
            if (z || this.dWy.mo33150md(d)) {
                this.dWz.mo33154a(C5206b.m14212dV(FZ), userId, duid, countryCode, Si, C3740b.m9101He().mo23111Hf() == null).mo10188a((C1850u<? super T>) new C1850u<JsonObject>() {
                    /* renamed from: a */
                    public void mo9883a(C1495b bVar) {
                        C8117f.this.dWB = true;
                    }

                    /* renamed from: a */
                    public void onSuccess(JsonObject jsonObject) {
                        boolean z;
                        String json = new Gson().toJson((JsonElement) jsonObject);
                        if (!TextUtils.isEmpty(json)) {
                            z = true;
                            StringBuilder sb = new StringBuilder();
                            sb.append("AppConfig: result : ");
                            sb.append(json);
                            LogUtilsV2.m14230i(sb.toString());
                            if (C8117f.this.dWy != null) {
                                C8117f.this.dWy.mo33149mc(json);
                                C8117f.this.dWy.mo33151me(d);
                                C8117f.this.dWy.mo33148aQ(System.currentTimeMillis());
                            }
                            C3742b.m9111II().mo23180K(VivaBaseApplication.m8749FZ(), json);
                            if (C8117f.this.dWA != null) {
                                C8117f.this.dWA.mo33153w(2, json);
                            }
                        } else {
                            z = false;
                        }
                        C8117f.this.dWB = false;
                        C8115d.m23505a(z, jsonObject);
                    }

                    /* JADX WARNING: Removed duplicated region for block: B:11:0x0018  */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public void onError(java.lang.Throwable r6) {
                        /*
                            r5 = this;
                            r6.printStackTrace()
                            r0 = 0
                            com.introvd.template.apicore.XYErrorResponse r1 = com.introvd.template.apicore.C3643u.m8926k(r6)     // Catch:{ Exception -> 0x0015 }
                            if (r1 == 0) goto L_0x0015
                            r2 = 1
                            int r1 = r1.errorCode     // Catch:{ Exception -> 0x0016 }
                            java.lang.String r3 = r9     // Catch:{ Exception -> 0x0016 }
                            java.lang.String r4 = r8     // Catch:{ Exception -> 0x0016 }
                            com.introvd.template.origin.p364a.C8115d.m23508l(r1, r3, r4)     // Catch:{ Exception -> 0x0016 }
                            goto L_0x0016
                        L_0x0015:
                            r2 = 0
                        L_0x0016:
                            if (r2 != 0) goto L_0x0044
                            java.lang.StringBuilder r1 = new java.lang.StringBuilder
                            r1.<init>()
                            java.lang.Class r2 = r6.getClass()
                            java.lang.String r2 = r2.getSimpleName()
                            r1.append(r2)
                            java.lang.String r2 = "("
                            r1.append(r2)
                            java.lang.String r6 = r6.getMessage()
                            r1.append(r6)
                            java.lang.String r6 = ")"
                            r1.append(r6)
                            java.lang.String r6 = r1.toString()
                            java.lang.String r1 = r9
                            java.lang.String r2 = r8
                            com.introvd.template.origin.p364a.C8115d.m23509s(r1, r2, r6)
                        L_0x0044:
                            com.introvd.template.origin.a.f r6 = com.introvd.template.origin.p364a.C8117f.this
                            r6.dWB = r0
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.origin.p364a.C8117f.C81181.onError(java.lang.Throwable):void");
                    }
                });
            }
        }
    }
}
