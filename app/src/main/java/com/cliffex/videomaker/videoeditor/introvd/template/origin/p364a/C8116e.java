package com.introvd.template.origin.p364a;

import android.text.TextUtils;
import com.google.gson.JsonObject;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.apicore.C3625c;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.origin.route.C8142b;
import java.util.HashMap;
import p037b.p050b.C1848s;
import p037b.p050b.p076j.C1820a;

/* renamed from: com.introvd.template.origin.a.e */
class C8116e {
    C8116e() {
    }

    private static String aET() {
        String str = VivaBaseApplication.m8749FZ().bfP;
        if (TextUtils.isEmpty(str)) {
            String cZ = C3625c.m8880GI().mo22964cZ("rt");
            if (TextUtils.isEmpty(cZ)) {
                return "http://s.api.xiaoying.co/api/rest/rt/appconfig";
            }
            StringBuilder sb = new StringBuilder();
            sb.append(cZ);
            sb.append("appconfig");
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(">>>>>> getAppCfgUrl route path=");
            sb3.append(sb2);
            LogUtilsV2.m14227d(sb3.toString());
            return sb2;
        } else if (str.endsWith("/")) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(str);
            sb4.append("appconfig");
            return sb4.toString();
        } else {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str);
            sb5.append("/appconfig");
            return sb5.toString();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C1848s<JsonObject> mo33154a(String str, String str2, String str3, String str4, String str5, boolean z) {
        if (TextUtils.isEmpty(str3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("AppConfig requestAppConfig DeviceId = ");
            sb.append(str3);
            LogUtilsV2.m14228e(sb.toString());
            return C1848s.m5331x(new Throwable("DeviceId is null"));
        }
        String aET = aET();
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("appkey", str);
        }
        hashMap.put("duid", str3);
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("auid", str2);
        }
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put("country", str4);
        }
        hashMap.put("reserved", z ? "1" : "0");
        hashMap.put("lang", str5);
        hashMap.put("productId", AppStateModel.getInstance().getAppProductId());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[XY-SDK] === url = ");
        sb2.append(aET);
        sb2.append(", appkey = ");
        sb2.append((String) hashMap.get("appkey"));
        sb2.append(", country = ");
        sb2.append((String) hashMap.get("country"));
        sb2.append(", lang = ");
        sb2.append((String) hashMap.get("lang"));
        sb2.append(", duid = ");
        sb2.append((String) hashMap.get("duid"));
        sb2.append(", auid = ");
        sb2.append((String) hashMap.get("auid"));
        LogUtilsV2.m14227d(sb2.toString());
        return C8142b.m23560b(aET, hashMap).mo10196g(C1820a.aVi()).mo10194f(C1820a.aVi()).mo10192bU(3);
    }
}
