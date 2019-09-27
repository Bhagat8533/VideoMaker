package com.introvd.template.template.data.api;

import android.text.TextUtils;
import com.introvd.template.C4677g;
import com.introvd.template.apicore.C3625c;
import com.introvd.template.apicore.C3636m;
import com.introvd.template.apicore.C3646w;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.editor.p252e.C5878a;
import com.introvd.template.explorer.extract.C7234b;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.template.data.api.model.TemplateAudioCategoryList;
import com.introvd.template.template.data.api.model.TemplateAudioInfoList;
import com.introvd.template.template.data.api.model.TemplateCategoryInfo;
import com.introvd.template.template.data.api.model.TemplateDownloadInfo;
import com.introvd.template.template.data.api.model.TemplatePackageInfoList;
import com.introvd.template.template.data.api.model.TemplateResponseInfo;
import com.introvd.template.template.data.api.model.TemplateResponseList;
import com.introvd.template.template.data.api.model.TemplateResponseRoll;
import java.util.HashMap;
import java.util.List;
import p037b.p050b.C1848s;
import p037b.p050b.C1852w;
import p037b.p050b.p057e.C1518f;
import p469f.C9768m;
import p469f.C9769n;

/* renamed from: com.introvd.template.template.data.api.b */
public class C8659b {
    /* renamed from: HN */
    private static C1848s<C8658a> m25226HN() {
        String GO = C3625c.m8880GI().mo22961GO();
        return TextUtils.isEmpty(GO) ? C1848s.m5331x(new Throwable(C3636m.bhq)) : C3636m.m8914dd(GO).mo10199i(new C1518f<C9769n, C8658a>() {
            /* renamed from: n */
            public C8658a apply(C9769n nVar) {
                return (C8658a) nVar.mo37510S(C8658a.class);
            }
        });
    }

    /* renamed from: a */
    public static C1848s<List<TemplateResponseInfo>> m25227a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        C1848s HN = m25226HN();
        final String str10 = str;
        final String str11 = str2;
        final String str12 = str3;
        final String str13 = str4;
        final String str14 = str5;
        final String str15 = str6;
        final String str16 = str7;
        final String str17 = str8;
        final String str18 = str9;
        C86688 r1 = new C1518f<C8658a, C1852w<List<TemplateResponseInfo>>>() {
            /* renamed from: a */
            public C1852w<List<TemplateResponseInfo>> apply(C8658a aVar) {
                HashMap hashMap = new HashMap();
                hashMap.put(C5878a.TAG, C4580b.m11635Si());
                hashMap.put(C7234b.TAG, str10);
                hashMap.put("c", str11);
                hashMap.put("d", str12);
                hashMap.put("f", str13);
                hashMap.put(C4677g.TAG, str14);
                if (!TextUtils.isEmpty(str15)) {
                    hashMap.put("h", str15);
                }
                if (!TextUtils.isEmpty(str16)) {
                    hashMap.put(SocialConstDef.TEMPLATE_CARD_SUBTCID, str16);
                }
                if (!TextUtils.isEmpty(str17)) {
                    hashMap.put("templateImgLength", str17);
                }
                if (!TextUtils.isEmpty(str18)) {
                    hashMap.put("templateTextLength", str18);
                }
                return aVar.mo34959P(C3646w.m8942o(hashMap));
            }
        };
        return HN.mo10198h(r1);
    }

    public static C1848s<C9768m<List<TemplateCategoryInfo>>> aKp() {
        return m25226HN().mo10198h(new C1518f<C8658a, C1852w<C9768m<List<TemplateCategoryInfo>>>>() {
            /* renamed from: a */
            public C1852w<C9768m<List<TemplateCategoryInfo>>> apply(C8658a aVar) {
                HashMap hashMap = new HashMap();
                hashMap.put(C5878a.TAG, C4580b.m11635Si());
                return aVar.mo34958O(C3646w.m8942o(hashMap));
            }
        });
    }

    /* renamed from: bc */
    public static C1848s<TemplateDownloadInfo> m25228bc(final String str, final String str2) {
        return m25226HN().mo10198h(new C1518f<C8658a, C1852w<TemplateDownloadInfo>>() {
            /* renamed from: a */
            public C1852w<TemplateDownloadInfo> apply(C8658a aVar) {
                HashMap hashMap = new HashMap();
                hashMap.put(C5878a.TAG, str);
                hashMap.put(C7234b.TAG, str2);
                hashMap.put("c", C4580b.m11635Si());
                return aVar.mo34960Q(C3646w.m8942o(hashMap));
            }
        });
    }

    /* renamed from: bd */
    public static C1848s<C9768m<TemplatePackageInfoList>> m25229bd(final String str, final String str2) {
        return m25226HN().mo10198h(new C1518f<C8658a, C1852w<C9768m<TemplatePackageInfoList>>>() {
            /* renamed from: a */
            public C1852w<C9768m<TemplatePackageInfoList>> apply(C8658a aVar) {
                HashMap hashMap = new HashMap();
                hashMap.put(C5878a.TAG, str);
                hashMap.put(C7234b.TAG, C4580b.m11635Si());
                hashMap.put("c", str2);
                return aVar.mo34962S(C3646w.m8942o(hashMap));
            }
        });
    }

    /* renamed from: e */
    public static C1848s<C9768m<TemplateAudioInfoList>> m25230e(final String str, final int i, final int i2, final int i3) {
        return m25226HN().mo10198h(new C1518f<C8658a, C1852w<C9768m<TemplateAudioInfoList>>>() {
            /* renamed from: a */
            public C1852w<C9768m<TemplateAudioInfoList>> apply(C8658a aVar) {
                HashMap hashMap = new HashMap();
                hashMap.put(C5878a.TAG, C4580b.m11635Si());
                hashMap.put(C7234b.TAG, str);
                hashMap.put("c", String.valueOf(i));
                hashMap.put("d", String.valueOf(i2));
                hashMap.put("audioClassType", String.valueOf(i3));
                return aVar.mo34966W(C3646w.m8942o(hashMap));
            }
        });
    }

    /* renamed from: e */
    public static C1848s<List<TemplateResponseRoll>> m25231e(String str, String str2, String str3, String str4, String str5) {
        C1848s HN = m25226HN();
        final String str6 = str;
        final String str7 = str2;
        final String str8 = str3;
        final String str9 = str4;
        final String str10 = str5;
        C86644 r1 = new C1518f<C8658a, C1852w<List<TemplateResponseRoll>>>() {
            /* renamed from: a */
            public C1852w<List<TemplateResponseRoll>> apply(C8658a aVar) {
                HashMap hashMap = new HashMap();
                hashMap.put(C5878a.TAG, C4580b.m11635Si());
                hashMap.put(C7234b.TAG, str6);
                hashMap.put("c", str7);
                hashMap.put("d", str8);
                hashMap.put("f", str9);
                if (!TextUtils.isEmpty(str10)) {
                    hashMap.put("h", str10);
                }
                return aVar.mo34964U(C3646w.m8942o(hashMap));
            }
        };
        return HN.mo10198h(r1);
    }

    /* renamed from: o */
    public static C1848s<C9768m<TemplateResponseList>> m25232o(final String str, final String str2, final String str3, final String str4) {
        return m25226HN().mo10198h(new C1518f<C8658a, C1852w<C9768m<TemplateResponseList>>>() {
            /* renamed from: a */
            public C1852w<C9768m<TemplateResponseList>> apply(C8658a aVar) {
                HashMap hashMap = new HashMap();
                hashMap.put(C5878a.TAG, str);
                hashMap.put(C7234b.TAG, C4580b.m11635Si());
                hashMap.put("c", str2);
                if (!TextUtils.isEmpty(str3)) {
                    hashMap.put("pageIndex", str3);
                }
                if (!TextUtils.isEmpty(str4)) {
                    hashMap.put("pageSize", str4);
                }
                return aVar.mo34963T(C3646w.m8942o(hashMap));
            }
        });
    }

    /* renamed from: uE */
    public static C1848s<C9768m<TemplateAudioCategoryList>> m25233uE(final int i) {
        return m25226HN().mo10198h(new C1518f<C8658a, C1852w<C9768m<TemplateAudioCategoryList>>>() {
            /* renamed from: a */
            public C1852w<C9768m<TemplateAudioCategoryList>> apply(C8658a aVar) {
                HashMap hashMap = new HashMap();
                hashMap.put(C5878a.TAG, C4580b.m11635Si());
                hashMap.put("audioClassType", String.valueOf(i));
                return aVar.mo34965V(C3646w.m8942o(hashMap));
            }
        });
    }

    /* renamed from: x */
    public static C1848s<C9768m<TemplateResponseInfo>> m25234x(final String str, final String str2, final String str3) {
        return m25226HN().mo10198h(new C1518f<C8658a, C1852w<C9768m<TemplateResponseInfo>>>() {
            /* renamed from: a */
            public C1852w<C9768m<TemplateResponseInfo>> apply(C8658a aVar) {
                HashMap hashMap = new HashMap();
                hashMap.put(C5878a.TAG, C4580b.m11635Si());
                hashMap.put(C7234b.TAG, str);
                hashMap.put("c", str2);
                hashMap.put("d", str3);
                return aVar.mo34961R(C3646w.m8942o(hashMap));
            }
        });
    }
}
