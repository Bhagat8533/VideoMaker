package com.introvd.template.app.api;

import android.text.TextUtils;
import com.google.gson.JsonObject;
import com.introvd.template.C4677g;
import com.introvd.template.apicore.C3625c;
import com.introvd.template.apicore.C3636m;
import com.introvd.template.apicore.C3646w;
import com.introvd.template.app.api.model.AppPopupInfoResult;
import com.introvd.template.app.api.model.AppVersionInfo;
import com.introvd.template.app.api.model.FeatureRequestResult;
import com.introvd.template.app.api.model.SnsConfigResult;
import com.introvd.template.app.api.model.SplashRequestResult;
import com.introvd.template.editor.p252e.C5878a;
import com.introvd.template.explorer.extract.C7234b;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p037b.p050b.C1848s;
import p037b.p050b.C1850u;
import p037b.p050b.C1852w;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p057e.C1518f;
import p037b.p050b.p076j.C1820a;
import p469f.C9769n;

/* renamed from: com.introvd.template.app.api.b */
public class C3727b {
    /* renamed from: A */
    public static void m9077A(final Map<String, String> map) {
        m9078HN().mo10196g(C1820a.aVi()).mo10194f(C1820a.aVi()).mo10198h(new C1518f<C3726a, C1852w<JsonObject>>() {
            /* renamed from: a */
            public C1852w<JsonObject> apply(C3726a aVar) {
                return aVar.mo23097z(C3646w.m8942o(map));
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

    /* renamed from: HN */
    private static C1848s<C3726a> m9078HN() {
        String GL = C3625c.m8880GI().mo22958GL();
        return TextUtils.isEmpty(GL) ? C1848s.m5331x(new Throwable(C3636m.bhq)) : C3636m.m8914dd(GL).mo10199i(new C1518f<C9769n, C3726a>() {
            /* renamed from: b */
            public C3726a apply(C9769n nVar) {
                return (C3726a) nVar.mo37510S(C3726a.class);
            }
        });
    }

    /* renamed from: I */
    public static C1848s<JsonObject> m9079I(final String str, final String str2) {
        return m9078HN().mo10198h(new C1518f<C3726a, C1852w<JsonObject>>() {
            /* renamed from: a */
            public C1852w<JsonObject> apply(C3726a aVar) {
                HashMap hashMap = new HashMap();
                hashMap.put(C5878a.TAG, str);
                hashMap.put(C7234b.TAG, str2);
                return aVar.mo23093v(C3646w.m8942o(hashMap));
            }
        });
    }

    /* renamed from: J */
    public static C1848s<List<SnsConfigResult>> m9080J(final String str, final String str2) {
        return m9078HN().mo10198h(new C1518f<C3726a, C1852w<List<SnsConfigResult>>>() {
            /* renamed from: a */
            public C1852w<List<SnsConfigResult>> apply(C3726a aVar) {
                HashMap hashMap = new HashMap();
                hashMap.put(C5878a.TAG, str);
                hashMap.put(C7234b.TAG, str2);
                return aVar.mo23094w(C3646w.m8942o(hashMap));
            }
        });
    }

    /* renamed from: a */
    public static C1848s<JsonObject> m9081a(final int i, final String str, final int i2) {
        return m9078HN().mo10198h(new C1518f<C3726a, C1852w<JsonObject>>() {
            /* renamed from: a */
            public C1852w<JsonObject> apply(C3726a aVar) {
                HashMap hashMap = new HashMap();
                String str = C5878a.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append(i);
                sb.append("");
                hashMap.put(str, sb.toString());
                if (!TextUtils.isEmpty(str)) {
                    hashMap.put(C7234b.TAG, str);
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append(i2);
                sb2.append("");
                hashMap.put("c", sb2.toString());
                return aVar.mo23089r(C3646w.m8942o(hashMap));
            }
        });
    }

    /* renamed from: a */
    public static C1848s<AppVersionInfo> m9082a(int i, String str, String str2, String str3, String str4) {
        C1848s HN = m9078HN();
        final String str5 = str;
        final String str6 = str2;
        final String str7 = str3;
        final int i2 = i;
        final String str8 = str4;
        C37366 r1 = new C1518f<C3726a, C1852w<AppVersionInfo>>() {
            /* renamed from: a */
            public C1852w<AppVersionInfo> apply(C3726a aVar) {
                HashMap hashMap = new HashMap();
                hashMap.put(C5878a.TAG, "0");
                hashMap.put(C7234b.TAG, str5);
                hashMap.put("c", str6);
                hashMap.put("e", str7);
                StringBuilder sb = new StringBuilder();
                sb.append(i2);
                sb.append("");
                hashMap.put("f", sb.toString());
                hashMap.put(C4677g.TAG, str8);
                return aVar.mo23088q(C3646w.m8942o(hashMap));
            }
        };
        return HN.mo10198h(r1);
    }

    /* renamed from: a */
    public static C1848s<JsonObject> m9083a(String str, int i, int i2, String str2, String str3) {
        C1848s HN = m9078HN();
        final String str4 = str;
        final int i3 = i2;
        final int i4 = i;
        final String str5 = str2;
        final String str6 = str3;
        C37399 r1 = new C1518f<C3726a, C1852w<JsonObject>>() {
            /* renamed from: a */
            public C1852w<JsonObject> apply(C3726a aVar) {
                HashMap hashMap = new HashMap();
                hashMap.put(C5878a.TAG, str4);
                String str = C7234b.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append(i3);
                sb.append("");
                hashMap.put(str, sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append(i4);
                sb2.append("");
                hashMap.put("c", sb2.toString());
                hashMap.put("d", str5);
                hashMap.put("e", str6);
                return aVar.mo23091t(C3646w.m8942o(hashMap));
            }
        };
        return HN.mo10198h(r1);
    }

    /* renamed from: c */
    public static C1848s<FeatureRequestResult> m9084c(String str, String str2, String str3, String str4, String str5) {
        C1848s HN = m9078HN();
        final String str6 = str;
        final String str7 = str2;
        final String str8 = str3;
        final String str9 = str4;
        final String str10 = str5;
        C37355 r1 = new C1518f<C3726a, C1852w<FeatureRequestResult>>() {
            /* renamed from: a */
            public C1852w<FeatureRequestResult> apply(C3726a aVar) {
                HashMap hashMap = new HashMap();
                hashMap.put(C5878a.TAG, str6);
                hashMap.put(C7234b.TAG, str7);
                hashMap.put("c", str8);
                if (!TextUtils.isEmpty(str9)) {
                    hashMap.put("duid", str9);
                }
                if (!TextUtils.isEmpty(str10)) {
                    hashMap.put("auid", str10);
                }
                return aVar.mo23092u(C3646w.m8942o(hashMap));
            }
        };
        return HN.mo10198h(r1);
    }

    /* renamed from: h */
    public static C1848s<List<SplashRequestResult>> m9085h(final String str, final String str2, final String str3, final String str4) {
        return m9078HN().mo10198h(new C1518f<C3726a, C1852w<List<SplashRequestResult>>>() {
            /* renamed from: a */
            public C1852w<List<SplashRequestResult>> apply(C3726a aVar) {
                HashMap hashMap = new HashMap();
                hashMap.put(C5878a.TAG, str);
                hashMap.put(C7234b.TAG, str2);
                if (!TextUtils.isEmpty(str3)) {
                    hashMap.put("duid", str3);
                }
                if (!TextUtils.isEmpty(str4)) {
                    hashMap.put("auid", str4);
                }
                return aVar.mo23090s(C3646w.m8942o(hashMap));
            }
        });
    }

    /* renamed from: i */
    public static C1848s<List<AppPopupInfoResult>> m9086i(final String str, final String str2, final String str3, final String str4) {
        return m9078HN().mo10198h(new C1518f<C3726a, C1852w<List<AppPopupInfoResult>>>() {
            /* renamed from: a */
            public C1852w<List<AppPopupInfoResult>> apply(C3726a aVar) {
                HashMap hashMap = new HashMap();
                hashMap.put(C7234b.TAG, str);
                hashMap.put("c", str2);
                if (!TextUtils.isEmpty(str3)) {
                    hashMap.put("duid", str3);
                }
                if (!TextUtils.isEmpty(str4)) {
                    hashMap.put("auid", str4);
                }
                return aVar.mo23095x(C3646w.m8942o(hashMap));
            }
        });
    }

    /* renamed from: y */
    public static C1848s<JsonObject> m9087y(final Map<String, String> map) {
        return m9078HN().mo10198h(new C1518f<C3726a, C1852w<JsonObject>>() {
            /* renamed from: a */
            public C1852w<JsonObject> apply(C3726a aVar) {
                return aVar.mo23096y(C3646w.m8942o(map));
            }
        });
    }
}
