package com.introvd.template.origin.device;

import android.content.Context;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p203b.C4585f;
import com.introvd.template.router.app.device.DeviceLoginCallback;
import com.introvd.template.router.app.device.DeviceLoginObserver;
import com.introvd.template.router.app.device.DeviceUserInfo;
import p037b.p050b.C1842q;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p057e.C1517e;

/* renamed from: com.introvd.template.origin.device.f */
public class C8138f {
    private static volatile C8138f dWP;
    /* access modifiers changed from: private */
    public C8132b dWL = new C8132b();
    private C8133c dWM = new C8133c();
    /* access modifiers changed from: private */
    public C8136d dWN = new C8136d();
    /* access modifiers changed from: private */
    public boolean dWO = false;

    private C8138f() {
    }

    public static C8138f aEW() {
        if (dWP == null) {
            synchronized (C8138f.class) {
                if (dWP == null) {
                    dWP = new C8138f();
                }
            }
        }
        return dWP;
    }

    /* access modifiers changed from: 0000 */
    public void aEX() {
        if (this.dWL.mo33186md(AppStateModel.getInstance().getZoneCode())) {
            deviceLogin(null);
        }
    }

    /* access modifiers changed from: 0000 */
    public DeviceUserInfo aEY() {
        return this.dWL.getDeviceUserInfo();
    }

    /* access modifiers changed from: 0000 */
    public void deviceLogin(final DeviceLoginCallback deviceLoginCallback) {
        if (this.dWO) {
            LogUtilsV2.m14227d("DeviceLogin:isWorking");
            return;
        }
        this.dWO = true;
        VivaBaseApplication FZ = VivaBaseApplication.m8749FZ();
        String dI = C4585f.m11690dI(FZ);
        String dG = C4585f.m11688dG(FZ);
        String Si = C4580b.m11635Si();
        final String zoneCode = AppStateModel.getInstance().getZoneCode();
        this.dWM.mo33187a(dI, dG, Si, this.dWN).mo10161e((C1517e<? super T>) new C1517e<DeviceUserInfo>() {
            /* renamed from: c */
            public void accept(DeviceUserInfo deviceUserInfo) throws Exception {
                deviceUserInfo.zoneCode = zoneCode;
                C8138f.this.dWL.mo33184a(deviceUserInfo);
                C8138f.this.dWN.mo33191sQ(2);
            }
        }).mo10149b((C1842q<? super T>) new C1842q<DeviceUserInfo>() {
            /* renamed from: a */
            public void mo9877a(C1495b bVar) {
            }

            /* renamed from: b */
            public void mo9886K(DeviceUserInfo deviceUserInfo) {
                C8138f.this.dWO = false;
                C8137e.aEV();
                if (deviceLoginCallback != null) {
                    deviceLoginCallback.onResult();
                }
            }

            public void onComplete() {
            }

            /* JADX WARNING: Removed duplicated region for block: B:11:0x0016  */
            /* JADX WARNING: Removed duplicated region for block: B:14:0x0049  */
            /* JADX WARNING: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onError(java.lang.Throwable r5) {
                /*
                    r4 = this;
                    r5.printStackTrace()
                    r0 = 0
                    com.introvd.template.apicore.XYErrorResponse r1 = com.introvd.template.apicore.C3643u.m8926k(r5)     // Catch:{ Exception -> 0x0013 }
                    if (r1 == 0) goto L_0x0013
                    r2 = 1
                    int r1 = r1.errorCode     // Catch:{ Exception -> 0x0014 }
                    java.lang.String r3 = r3     // Catch:{ Exception -> 0x0014 }
                    com.introvd.template.origin.device.C8137e.m23549x(r1, r3)     // Catch:{ Exception -> 0x0014 }
                    goto L_0x0014
                L_0x0013:
                    r2 = 0
                L_0x0014:
                    if (r2 != 0) goto L_0x0040
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    r1.<init>()
                    java.lang.Class r2 = r5.getClass()
                    java.lang.String r2 = r2.getSimpleName()
                    r1.append(r2)
                    java.lang.String r2 = "("
                    r1.append(r2)
                    java.lang.String r5 = r5.getMessage()
                    r1.append(r5)
                    java.lang.String r5 = ")"
                    r1.append(r5)
                    java.lang.String r5 = r1.toString()
                    java.lang.String r1 = r3
                    com.introvd.template.origin.device.C8137e.m23547aG(r1, r5)
                L_0x0040:
                    com.introvd.template.origin.device.f r5 = com.introvd.template.origin.device.C8138f.this
                    r5.dWO = r0
                    com.introvd.template.router.app.device.DeviceLoginCallback r5 = r7
                    if (r5 == 0) goto L_0x004e
                    com.introvd.template.router.app.device.DeviceLoginCallback r5 = r7
                    r5.onResult()
                L_0x004e:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.origin.device.C8138f.C81391.onError(java.lang.Throwable):void");
            }
        });
    }

    /* access modifiers changed from: 0000 */
    public void init(Context context) {
        LogUtilsV2.m14227d("DeviceLogin:init()");
        if (!this.dWL.mo33186md(AppStateModel.getInstance().getZoneCode())) {
            this.dWN.mo33191sQ(1);
        } else {
            deviceLogin(null);
        }
        DeviceBroadcastReceiver.m23518cw(context);
    }

    /* access modifiers changed from: 0000 */
    public void registerObserver(DeviceLoginObserver deviceLoginObserver) {
        if (deviceLoginObserver != null) {
            this.dWN.mo33190a(deviceLoginObserver);
        }
    }
}
