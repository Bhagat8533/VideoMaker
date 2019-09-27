package com.introvd.template.app.utils;

import com.google.gson.JsonObject;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.utils.PeriodDetectUtil;
import com.introvd.template.origin.device.api.C8124b;
import p037b.p050b.C1850u;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p076j.C1820a;

/* renamed from: com.introvd.template.app.utils.d */
public class C4400d {
    /* renamed from: QN */
    public static void m11109QN() {
        PeriodDetectUtil.isInPeriod("pref_key_day_active_user_api_call_time", 0);
    }

    /* renamed from: bT */
    public static void m11110bT(boolean z) {
        if (z || !PeriodDetectUtil.isInPeriod("pref_key_day_active_user_api_call_time", 3600000)) {
            StringBuilder sb = new StringBuilder();
            sb.append("callDAUApi run bForce=");
            sb.append(z);
            LogUtilsV2.m14230i(sb.toString());
            try {
                C8124b.m23528sR(VivaBaseApplication.m8749FZ().isForeground ^ true ? 1 : 0).mo10196g(C1820a.aVi()).mo10194f(C1820a.aVi()).mo10188a((C1850u<? super T>) new C1850u<JsonObject>() {
                    /* renamed from: a */
                    public void mo9883a(C1495b bVar) {
                        LogUtilsV2.m14230i("onSubscribe run");
                    }

                    /* renamed from: a */
                    public void onSuccess(JsonObject jsonObject) {
                        LogUtilsV2.m14230i("onSuccess run");
                    }

                    public void onError(Throwable th) {
                        LogUtilsV2.m14230i("onError run");
                        PeriodDetectUtil.clear("pref_key_day_active_user_api_call_time");
                    }
                });
            } catch (Exception unused) {
                PeriodDetectUtil.clear("pref_key_day_active_user_api_call_time");
            }
        }
    }
}
