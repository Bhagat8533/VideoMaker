package com.introvd.template.origin.device;

import android.text.TextUtils;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.p203b.C4600l;
import java.util.HashMap;

/* renamed from: com.introvd.template.origin.device.e */
public class C8137e {
    static void aEV() {
        LogUtilsV2.m14227d("DeviceLogin:DEV_EVENT_DEV_LOGIN_NET_WORK success=");
        HashMap hashMap = new HashMap();
        hashMap.put("result", "success");
        UserBehaviorLog.onAliEvent("dev_event_dev_login_net_work", hashMap);
    }

    /* renamed from: aG */
    static void m23547aG(String str, String str2) {
        boolean k = C4600l.m11739k(VivaBaseApplication.m8749FZ(), false);
        StringBuilder sb = new StringBuilder();
        sb.append("DeviceLogin:DEV_EVENT_DEV_LOGIN_CLIENT_WORK zoneCode = ");
        sb.append(str);
        sb.append(",networkConnect=");
        sb.append(k);
        sb.append(",msg=");
        sb.append(str2);
        LogUtilsV2.m14227d(sb.toString());
        HashMap hashMap = new HashMap();
        hashMap.put("result", String.valueOf(-1111));
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("zoneCode", str);
        }
        hashMap.put("netWork", String.valueOf(k));
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("msg", str2);
        }
        UserBehaviorLog.onAliEvent("dev_event_dev_login_client_work", hashMap);
    }

    /* renamed from: m */
    public static void m23548m(boolean z, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("DeviceLogin:DEV_EVENT_DEV_LOGIN needCheck=");
        sb.append(z);
        sb.append(",reason=");
        sb.append(str);
        LogUtilsV2.m14227d(sb.toString());
        HashMap hashMap = new HashMap();
        hashMap.put("needCheck", String.valueOf(z));
        hashMap.put("reason", str);
        UserBehaviorLog.onAliEvent("dev_event_dev_login", hashMap);
    }

    /* renamed from: x */
    static void m23549x(int i, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("DeviceLogin:DEV_EVENT_DEV_LOGIN_NET_WORK errorCode=");
        sb.append(i);
        sb.append(",zoneCode=");
        sb.append(str);
        LogUtilsV2.m14227d(sb.toString());
        HashMap hashMap = new HashMap();
        hashMap.put("result", String.valueOf(i));
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("zoneCode", str);
        }
        UserBehaviorLog.onAliEvent("dev_event_dev_login_net_work", hashMap);
    }
}
