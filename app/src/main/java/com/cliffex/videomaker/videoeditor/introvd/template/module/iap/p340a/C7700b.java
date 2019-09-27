package com.introvd.template.module.iap.p340a;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.introvd.template.apicore.C3625c;
import com.introvd.template.apicore.C3626d;
import com.introvd.template.apicore.C3634k;
import com.introvd.template.apicore.C3635l;
import com.introvd.template.apicore.C3636m;
import com.introvd.template.apicore.C3646w;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.module.iap.C8048e;
import com.introvd.template.module.iap.business.C7824a;
import com.introvd.template.module.iap.business.p349a.p350a.C7826a;
import com.introvd.template.module.iap.business.p349a.p351b.C7828a;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.C9804ad;
import okhttp3.C9943t;
import org.json.JSONException;
import org.json.JSONObject;
import p037b.p050b.C1834l;
import p037b.p050b.C1838m;
import p037b.p050b.C1839n;
import p037b.p050b.C1840o;
import p037b.p050b.C1848s;
import p037b.p050b.C1852w;
import p037b.p050b.C1853x;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p057e.C1517e;
import p037b.p050b.p057e.C1518f;
import p037b.p050b.p076j.C1820a;
import p469f.C9769n;

/* renamed from: com.introvd.template.module.iap.a.b */
public class C7700b extends C3626d {

    /* renamed from: com.introvd.template.module.iap.a.b$a */
    class C7710a {
        public List<C7826a> dPf;
    }

    /* renamed from: L */
    private static C1834l<C9804ad> m22605L(final Map<String, String> map) {
        return aBy().aTS().mo10162e((C1518f<? super T, ? extends C1840o<? extends R>>) new C1518f<C7699a, C1840o<C9804ad>>() {
            /* renamed from: a */
            public C1840o<C9804ad> apply(C7699a aVar) throws Exception {
                return aVar.mo32580L(C3646w.m8942o(map));
            }
        });
    }

    private static C1848s<C7699a> aBy() {
        String GL = C3625c.m8880GI().mo22958GL();
        return TextUtils.isEmpty(GL) ? C1848s.m5331x(new Throwable(C3636m.bhq)) : C3636m.m8914dd(GL).mo10199i(new C1518f<C9769n, C7699a>() {
            /* renamed from: i */
            public C7699a apply(C9769n nVar) throws Exception {
                return (C7699a) nVar.mo37510S(C7699a.class);
            }
        });
    }

    private static <T> C1853x<T, T> aBz() {
        return new C1853x<T, T>() {
            /* renamed from: b */
            public C1852w<T> mo10202b(C1848s<T> sVar) {
                return sVar.mo10196g(C1820a.aVi()).mo10194f(C1487a.aUa());
            }
        };
    }

    @SuppressLint({"CheckResult"})
    /* renamed from: c */
    public static void m22606c(final C3635l<List<C7828a>> lVar) {
        m22605L(C8048e.aBe().mo23658hc(IronSourceConstants.INTERSTITIAL_DAILY_CAPPED)).mo10157d(C1820a.aVi()).mo10162e((C1518f<? super T, ? extends C1840o<? extends R>>) new C1518f<C9804ad, C1840o<List<C7828a>>>() {
            /* renamed from: e */
            public C1840o<List<C7828a>> apply(final C9804ad adVar) throws Exception {
                return C1834l.m5254a((C1839n<T>) new C1839n<List<C7828a>>() {
                    /* renamed from: a */
                    public void mo10177a(C1838m<List<C7828a>> mVar) throws Exception {
                        JsonElement parse = new JsonParser().parse(adVar.string());
                        if (parse instanceof JsonArray) {
                            JsonObject jsonObject = new JsonObject();
                            jsonObject.add("250", parse);
                            parse = jsonObject;
                        }
                        mVar.mo9791K(C7700b.m22607h(parse.getAsJsonObject()));
                    }
                }).mo10157d(C1820a.aVi());
            }
        }).mo10152c(C1487a.aUa()).mo10128a((C1517e<? super T>) new C1517e<List<C7828a>>() {
            /* renamed from: V */
            public void accept(List<C7828a> list) throws Exception {
                lVar.onSuccess(list);
            }
        }, (C1517e<? super Throwable>) new C1517e<Throwable>() {
            /* renamed from: m */
            public void accept(Throwable th) throws Exception {
                th.printStackTrace();
                lVar.onError(th.getMessage());
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public static List<C7828a> m22607h(JsonObject jsonObject) {
        ArrayList arrayList = new ArrayList();
        JsonArray asJsonArray = jsonObject.getAsJsonArray("250");
        if (asJsonArray == null) {
            return new ArrayList();
        }
        for (int i = 0; i < asJsonArray.size(); i++) {
            C7828a aVar = new C7828a();
            JsonElement jsonElement = asJsonArray.get(i);
            if (jsonElement != null) {
                JsonObject asJsonObject = jsonElement.getAsJsonObject();
                if (asJsonObject.has("desc")) {
                    aVar.setDescription(asJsonObject.get("desc").getAsString());
                }
                if (asJsonObject.has("title")) {
                    aVar.setTitle(asJsonObject.get("title").getAsString());
                }
                if (asJsonObject.has("type")) {
                    aVar.mo32718lo(C7824a.m22802si(asJsonObject.get("type").getAsInt()));
                }
                if (asJsonObject.has("orderNo")) {
                    aVar.setOrder(asJsonObject.get("orderNo").getAsInt());
                }
                if (asJsonObject.has("id")) {
                    aVar.mo32717ln(asJsonObject.get("id").getAsString());
                }
                String str = "";
                if (asJsonObject.has("extend")) {
                    str = asJsonObject.get("extend").getAsString();
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    aVar.mo32723sv(jSONObject.optInt("pPrice"));
                    aVar.mo32724sw(jSONObject.optInt("oPrice"));
                    aVar.mo32722su(jSONObject.optInt("effectiveTime"));
                    aVar.mo32716lj(jSONObject.optString(SocialConstDef.MESSAGE_LABEL));
                    arrayList.add(aVar);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return arrayList;
    }

    /* renamed from: iC */
    public static C1848s<List<C7826a>> m22609iC(final boolean z) {
        return aBy().mo10198h(new C1518f<C7699a, C1852w<? extends List<C7826a>>>() {
            /* renamed from: b */
            public C1852w<? extends List<C7826a>> apply(C7699a aVar) throws Exception {
                StringBuilder sb = new StringBuilder();
                sb.append(C3625c.m8880GI().mo22958GL());
                sb.append("commodityForeignList");
                String sb2 = sb.toString();
                HashMap hashMap = new HashMap(1);
                hashMap.put("promoChannel", Integer.valueOf(z ? 3 : 2));
                return aVar.mo32581m(new C3634k(C9943t.m28421ti(sb2), (Map<String, Object>) hashMap).mo22977GW()).mo10199i(new C1518f<C7710a, List<C7826a>>() {
                    /* renamed from: a */
                    public List<C7826a> apply(C7710a aVar) throws Exception {
                        return aVar.dPf;
                    }
                });
            }
        }).mo10187a(aBz());
    }
}
