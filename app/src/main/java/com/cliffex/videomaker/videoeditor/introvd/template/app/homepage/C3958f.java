package com.introvd.template.app.homepage;

import android.content.Context;
import android.text.TextUtils;
import com.google.gson.JsonObject;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.utils.PeriodDetectUtil;
import com.introvd.template.crash.C5523b;
import com.introvd.template.origin.device.api.C8124b;
import p037b.p050b.C1848s;
import p037b.p050b.C1850u;
import p037b.p050b.C1852w;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p057e.C1518f;
import p037b.p050b.p076j.C1820a;

/* renamed from: com.introvd.template.app.homepage.f */
public class C3958f {
    /* renamed from: cn */
    public static void m9764cn(final Context context) {
        C1848s.m5326ai(Boolean.valueOf(true)).mo10196g(C1820a.aVi()).mo10194f(C1820a.aVi()).mo10198h(new C1518f<Boolean, C1852w<JsonObject>>() {
            /* renamed from: f */
            public C1852w<JsonObject> apply(Boolean bool) {
                LogUtilsV2.m14230i("collectDeviceInfo enter");
                if (PeriodDetectUtil.isInPeriod("pref_key_collect_time", 43200000)) {
                    return C1848s.m5331x(new Exception("ignore"));
                }
                LogUtilsV2.m14230i("collectDeviceInfo enter actual!");
                try {
                    String ck = C3942c.m9715ck(context.getApplicationContext());
                    if (!TextUtils.isEmpty(ck)) {
                        return C8124b.m23526mh(ck);
                    }
                } catch (Exception e) {
                    C5523b.logException(e);
                }
                return C1848s.m5331x(new Exception("ignore"));
            }
        }).mo10188a((C1850u<? super T>) new C1850u<JsonObject>() {
            /* renamed from: a */
            public void mo9883a(C1495b bVar) {
            }

            /* renamed from: a */
            public void onSuccess(JsonObject jsonObject) {
            }

            public void onError(Throwable th) {
                th.printStackTrace();
            }
        });
    }
}
