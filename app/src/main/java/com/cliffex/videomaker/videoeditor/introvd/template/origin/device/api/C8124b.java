package com.introvd.template.origin.device.api;

import android.text.TextUtils;
import com.google.gson.JsonObject;
import com.introvd.template.apicore.C3625c;
import com.introvd.template.apicore.C3633j;
import com.introvd.template.apicore.C3634k;
import com.introvd.template.apicore.C3636m;
import com.introvd.template.editor.p252e.C5878a;
import com.introvd.template.explorer.extract.C7234b;
import java.util.HashMap;
import java.util.Map;
import okhttp3.C9943t;
import p037b.p050b.C1834l;
import p037b.p050b.C1848s;
import p037b.p050b.C1852w;
import p037b.p050b.p057e.C1518f;
import p469f.C9769n;

/* renamed from: com.introvd.template.origin.device.api.b */
public class C8124b {
    private static C1848s<C8123a> aEZ() {
        String GK = C3625c.m8880GI().mo22957GK();
        return TextUtils.isEmpty(GK) ? C1848s.m5331x(new Throwable(C3636m.bhq)) : C3636m.m8914dd(GK).mo10199i(new C1518f<C9769n, C8123a>() {
            /* renamed from: l */
            public C8123a apply(C9769n nVar) {
                return (C8123a) nVar.mo37510S(C8123a.class);
            }
        });
    }

    public static C1848s<JsonObject> aFa() {
        return aEZ().mo10198h(new C1518f<C8123a, C1852w<JsonObject>>() {
            /* renamed from: a */
            public C1852w<JsonObject> apply(C8123a aVar) {
                StringBuilder sb = new StringBuilder();
                sb.append(C3625c.m8880GI().mo22957GK());
                sb.append("deleteDeviceForAndroid");
                String sb2 = sb.toString();
                return aVar.mo33176v(C3633j.m8904a(C9943t.m28421ti(sb2), (Object) new HashMap()));
            }
        });
    }

    /* renamed from: aH */
    public static C1834l<RegisterDeviceResult> m23525aH(final String str, final String str2) {
        return (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) ? aEZ().mo10198h(new C1518f<C8123a, C1852w<RegisterDeviceResult>>() {
            /* renamed from: a */
            public C1852w<RegisterDeviceResult> apply(C8123a aVar) {
                HashMap hashMap = new HashMap();
                hashMap.put(C5878a.TAG, str);
                if (!TextUtils.isEmpty(str2)) {
                    hashMap.put("c", str2);
                }
                StringBuilder sb = new StringBuilder();
                sb.append(C3625c.m8880GI().mo22957GK());
                sb.append("dd");
                return aVar.mo33172r(new C3634k(C9943t.m28421ti(sb.toString()), (Object) hashMap).mo22977GW());
            }
        }).aTS() : C1834l.m5263w(new Throwable("devUID and devUIDV2 are null"));
    }

    public static C1848s<JsonObject> getFreezeReason(final String str) {
        return aEZ().mo10198h(new C1518f<C8123a, C1852w<JsonObject>>() {
            /* renamed from: a */
            public C1852w<JsonObject> apply(C8123a aVar) {
                HashMap hashMap = new HashMap();
                hashMap.put("duiddigest", str);
                return aVar.mo33171M(hashMap);
            }
        });
    }

    /* renamed from: mh */
    public static C1848s<JsonObject> m23526mh(final String str) {
        return aEZ().mo10198h(new C1518f<C8123a, C1852w<JsonObject>>() {
            /* renamed from: a */
            public C1852w<JsonObject> apply(C8123a aVar) {
                HashMap hashMap = new HashMap();
                hashMap.put(C5878a.TAG, str);
                StringBuilder sb = new StringBuilder();
                sb.append(C3625c.m8880GI().mo22957GK());
                sb.append("di");
                return aVar.mo33174t(C3633j.m8904a(C9943t.m28421ti(sb.toString()), (Object) hashMap));
            }
        });
    }

    /* renamed from: n */
    public static C1834l<LoginDeviceResult> m23527n(final String str, final String str2, final String str3, final String str4) {
        return (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) ? aEZ().mo10198h(new C1518f<C8123a, C1852w<LoginDeviceResult>>() {
            /* renamed from: a */
            public C1852w<LoginDeviceResult> apply(C8123a aVar) {
                HashMap hashMap = new HashMap();
                hashMap.put(C5878a.TAG, str2);
                hashMap.put(C7234b.TAG, str4);
                if (!TextUtils.isEmpty(str3)) {
                    hashMap.put("d", str3);
                }
                StringBuilder sb = new StringBuilder();
                sb.append(C3625c.m8880GI().mo22957GK());
                sb.append("dg");
                return aVar.mo33173s(new C3634k(C9943t.m28421ti(sb.toString()), (Object) hashMap).mo22979dc(str).mo22977GW());
            }
        }).aTS() : C1834l.m5263w(new Throwable("devUID and devUIDV2 are null"));
    }

    /* renamed from: sR */
    public static C1848s<JsonObject> m23528sR(final int i) {
        return aEZ().mo10198h(new C1518f<C8123a, C1852w<JsonObject>>() {
            /* renamed from: a */
            public C1852w<JsonObject> apply(C8123a aVar) {
                StringBuilder sb = new StringBuilder();
                sb.append(C3625c.m8880GI().mo22957GK());
                sb.append("loginStatistic");
                String sb2 = sb.toString();
                HashMap hashMap = new HashMap();
                hashMap.put("reserved", Integer.valueOf(i));
                return aVar.mo33175u(C3633j.m8905a(C9943t.m28421ti(sb2), (Map<String, Object>) hashMap));
            }
        });
    }
}
