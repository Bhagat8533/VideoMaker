package com.introvd.template.p363o;

import android.text.TextUtils;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.common.UserBehaviorLog;
import java.util.HashMap;

/* renamed from: com.introvd.template.o.f */
public class C8106f {
    /* renamed from: ak */
    public static void m23492ak(int i, boolean z) {
        HashMap hashMap = new HashMap();
        if (z) {
            hashMap.put("result", "allow");
        } else {
            hashMap.put("result", "deny");
        }
        String str = null;
        switch (i) {
            case 0:
                str = "Permission_Request_Storage";
                break;
            case 1:
                str = "Permission_Request_Location";
                break;
            case 3:
                str = "Permission_Request_Camera";
                break;
            case 4:
            case 5:
                str = "Permission_Request_Mic";
                break;
            case 6:
                str = "Permission_Request_Phone";
                break;
        }
        if (!TextUtils.isEmpty(str)) {
            UserBehaviorLog.onKVEvent(VivaBaseApplication.m8749FZ(), str, hashMap);
        }
    }

    /* renamed from: iP */
    public static void m23493iP(boolean z) {
        HashMap hashMap = new HashMap();
        if (z) {
            hashMap.put("status", "on");
        } else {
            hashMap.put("status", "off");
        }
        UserBehaviorLog.onKVEvent(VivaBaseApplication.m8749FZ(), "Location_Status", hashMap);
    }
}
