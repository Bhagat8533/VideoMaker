package com.introvd.template.module.iap.p341b.p342a;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.introvd.template.module.iap.business.p356e.C7897a;
import com.introvd.template.module.iap.business.p356e.C7898b;
import com.introvd.template.router.app.device.DeviceUserProxy;

/* renamed from: com.introvd.template.module.iap.b.a.a */
public final class C7719a {

    /* renamed from: com.introvd.template.module.iap.b.a.a$a */
    private static class C7721a {
        @SerializedName("Todo_Code")
        String dVo;
        @SerializedName("DUID")
        String duid;
        @SerializedName("From")
        String from;
        @SerializedName("Template_ID")
        String templateId;

        private C7721a(String str, String str2, String str3, String str4) {
            this.duid = str;
            this.dVo = str2;
            this.from = str3;
            this.templateId = str4;
        }
    }

    /* renamed from: lJ */
    public static String m22632lJ(String str) {
        C7721a aVar = new C7721a(DeviceUserProxy.getDuid(), C7897a.m23023c("Iap_Domestic_Todo_Code", null, new String[0]), C7897a.m23023c(C7898b.dSW, null, new String[0]), str);
        return new Gson().toJson((Object) aVar);
    }
}
