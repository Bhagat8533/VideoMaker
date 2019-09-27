package com.introvd.template.origin.device;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.origin.device.api.C8124b;
import com.introvd.template.origin.device.api.LoginDeviceResult;
import com.introvd.template.origin.device.api.RegisterDeviceResult;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.router.app.device.DeviceUserInfo;
import p037b.p050b.C1834l;
import p037b.p050b.C1840o;
import p037b.p050b.p057e.C1518f;
import p037b.p050b.p076j.C1820a;

/* renamed from: com.introvd.template.origin.device.c */
class C8133c {
    C8133c() {
    }

    /* access modifiers changed from: private */
    /* renamed from: mf */
    public static long m23540mf(String str) {
        long j = 0;
        if (str == null || str.length() == 0) {
            return 0;
        }
        String lowerCase = C4580b.bKF.toLowerCase();
        String lowerCase2 = str.toLowerCase();
        int length = lowerCase2.length();
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            int i3 = (length - 1) - i;
            j += ((long) Math.pow((double) lowerCase.length(), (double) i3)) * ((long) lowerCase.indexOf(lowerCase2.substring(i, i2)));
            i = i2;
        }
        return j;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C1834l<DeviceUserInfo> mo33187a(String str, String str2, String str3, C8136d dVar) {
        final DeviceUserInfo deviceUserInfo = new DeviceUserInfo();
        LogUtilsV2.m14227d("DeviceLogin:deviceLogin = ");
        C1834l c = C8124b.m23525aH(str, str2).mo10150bT(3).mo10157d(C1820a.aVi()).mo10152c(C1820a.aVi());
        final DeviceUserInfo deviceUserInfo2 = deviceUserInfo;
        final String str4 = str;
        final String str5 = str2;
        final String str6 = str3;
        C81352 r0 = new C1518f<RegisterDeviceResult, C1840o<LoginDeviceResult>>() {
            /* renamed from: b */
            public C1840o<LoginDeviceResult> apply(RegisterDeviceResult registerDeviceResult) throws Exception {
                String str = registerDeviceResult.duid;
                deviceUserInfo2.deviceId = str;
                if (!TextUtils.isEmpty(str)) {
                    String substring = str.substring(2, str.length());
                    deviceUserInfo2.duid = C8133c.m23540mf(substring);
                }
                return C8124b.m23527n(str, str4, str5, str6).mo10150bT(3);
            }
        };
        return c.mo10162e((C1518f<? super T, ? extends C1840o<? extends R>>) r0).mo10167f((C1518f<? super T, ? extends R>) new C1518f<LoginDeviceResult, DeviceUserInfo>() {
            /* renamed from: a */
            public DeviceUserInfo apply(LoginDeviceResult loginDeviceResult) throws Exception {
                deviceUserInfo.validTime = loginDeviceResult.getA().aFc() * 1000;
                deviceUserInfo.expired = (loginDeviceResult.getA().aFc() * 1000) + System.currentTimeMillis();
                deviceUserInfo.token = loginDeviceResult.getA().aFb();
                StringBuilder sb = new StringBuilder();
                sb.append("DeviceLogin:DeviceUserInfo onNext = ");
                sb.append(new Gson().toJson((Object) deviceUserInfo));
                LogUtilsV2.m14227d(sb.toString());
                return deviceUserInfo;
            }
        });
    }
}
