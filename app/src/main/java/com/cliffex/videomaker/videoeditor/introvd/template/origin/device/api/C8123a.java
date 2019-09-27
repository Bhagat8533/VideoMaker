package com.introvd.template.origin.device.api;

import com.google.gson.JsonObject;
import java.util.Map;
import okhttp3.C9798ab;
import p037b.p050b.C1848s;
import p469f.p474c.C9705a;
import p469f.p474c.C9710f;
import p469f.p474c.C9719o;
import p469f.p474c.C9725u;

/* renamed from: com.introvd.template.origin.device.api.a */
interface C8123a {
    @C9710f("freezeReason")
    /* renamed from: M */
    C1848s<JsonObject> mo33171M(@C9725u(baS = true) Map<String, String> map);

    @C9719o("dd")
    /* renamed from: r */
    C1848s<RegisterDeviceResult> mo33172r(@C9705a C9798ab abVar);

    @C9719o("dg")
    /* renamed from: s */
    C1848s<LoginDeviceResult> mo33173s(@C9705a C9798ab abVar);

    @C9719o("di")
    /* renamed from: t */
    C1848s<JsonObject> mo33174t(@C9705a C9798ab abVar);

    @C9719o("loginStatistic")
    /* renamed from: u */
    C1848s<JsonObject> mo33175u(@C9705a C9798ab abVar);

    @C9719o("deleteDeviceForAndroid")
    /* renamed from: v */
    C1848s<JsonObject> mo33176v(@C9705a C9798ab abVar);
}
