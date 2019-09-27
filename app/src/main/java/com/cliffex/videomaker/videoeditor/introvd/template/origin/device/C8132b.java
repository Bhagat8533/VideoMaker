package com.introvd.template.origin.device;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.origin.p364a.C8113b;
import com.introvd.template.router.app.device.DeviceUserInfo;
import com.vivavideo.mobile.component.sharedpref.C9324b;
import com.vivavideo.mobile.component.sharedpref.C9327e;
import com.vivavideo.mobile.h5core.refresh.H5PullHeader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* renamed from: com.introvd.template.origin.device.b */
class C8132b {
    private DeviceUserInfo dWG = null;
    private C9324b dWw;

    C8132b() {
    }

    /* renamed from: EC */
    private C9324b m23536EC() {
        if (this.dWw == null) {
            this.dWw = C9327e.m27034cR(VivaBaseApplication.m8749FZ(), "viva_device_user");
        }
        return this.dWw;
    }

    /* renamed from: at */
    private static String m23537at(long j) {
        return new SimpleDateFormat(H5PullHeader.TIME_FORMAT, Locale.US).format(new Date(j));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo33184a(DeviceUserInfo deviceUserInfo) {
        if (deviceUserInfo != null && !TextUtils.isEmpty(deviceUserInfo.deviceId) && !TextUtils.isEmpty(deviceUserInfo.token)) {
            synchronized (C8113b.class) {
                this.dWG = deviceUserInfo;
                m23536EC().mo36535bj("info", new Gson().toJson((Object) deviceUserInfo));
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public DeviceUserInfo getDeviceUserInfo() {
        if (this.dWG != null) {
            return this.dWG;
        }
        String bk = m23536EC().mo36536bk("info", null);
        if (TextUtils.isEmpty(bk)) {
            return null;
        }
        synchronized (C8113b.class) {
            this.dWG = (DeviceUserInfo) new Gson().fromJson(bk, DeviceUserInfo.class);
        }
        return this.dWG;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: md */
    public boolean mo33186md(String str) {
        DeviceUserInfo deviceUserInfo = getDeviceUserInfo();
        boolean z = true;
        if (deviceUserInfo == null || TextUtils.isEmpty(deviceUserInfo.deviceId) || deviceUserInfo.validTime <= 0) {
            LogUtilsV2.m14227d("DeviceLogin:needCheck No DeviceInfo or exceed the time limit");
            C8137e.m23548m(true, "No DeviceInfo Info");
            return true;
        }
        boolean z2 = TextUtils.isEmpty(deviceUserInfo.zoneCode) || !deviceUserInfo.zoneCode.equals(str);
        StringBuilder sb = new StringBuilder();
        sb.append("DeviceLogin:device.zone = ");
        sb.append(deviceUserInfo.zoneCode);
        sb.append(",currentZone = ");
        sb.append(str);
        sb.append(",needSwitchZone = ");
        sb.append(z2);
        LogUtilsV2.m14227d(sb.toString());
        if (z2) {
            C8137e.m23548m(true, "SwitchZone");
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("DeviceLogin:Valid Time = ");
        sb2.append(deviceUserInfo.validTime / 86400000);
        LogUtilsV2.m14227d(sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append("DeviceLogin:EXPIRED Time = ");
        sb3.append(m23537at(deviceUserInfo.expired));
        LogUtilsV2.m14227d(sb3.toString());
        if (currentTimeMillis + (deviceUserInfo.validTime / 2) < deviceUserInfo.expired) {
            z = false;
        }
        C8137e.m23548m(z, z ? "expired" : "hitCache");
        return z;
    }
}
