package com.introvd.template.app.push.api;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.introvd.template.apicore.C3625c;
import com.introvd.template.apicore.C3636m;
import com.introvd.template.app.push.api.model.CommonResponseResult;
import com.introvd.template.app.push.api.model.PushRegIDRequestParam;
import com.introvd.template.app.push.api.model.TagRequestParam;
import com.introvd.template.app.push.api.model.TagSystemParam;
import com.introvd.template.datacenter.SocialConstDef;
import java.util.HashMap;
import java.util.List;
import p037b.p050b.C1848s;
import p037b.p050b.C1852w;
import p037b.p050b.p057e.C1518f;
import p469f.C9769n;

/* renamed from: com.introvd.template.app.push.api.b */
public class C4099b {
    /* renamed from: HN */
    private static C1848s<C4098a> m10175HN() {
        String GP = C3625c.m8880GI().mo22962GP();
        return TextUtils.isEmpty(GP) ? C1848s.m5331x(new Throwable(C3636m.bhq)) : C3636m.m8914dd(GP).mo10199i(new C1518f<C9769n, C4098a>() {
            /* renamed from: c */
            public C4098a apply(C9769n nVar) {
                return (C4098a) nVar.mo37510S(C4098a.class);
            }
        });
    }

    /* renamed from: a */
    public static C1848s<CommonResponseResult<String>> m10176a(final TagRequestParam tagRequestParam, final TagSystemParam tagSystemParam) {
        return m10175HN().mo10198h(new C1518f<C4098a, C1852w<CommonResponseResult<String>>>() {
            /* renamed from: a */
            public C1852w<CommonResponseResult<String>> apply(C4098a aVar) {
                HashMap hashMap = new HashMap();
                hashMap.put("requestParam", new Gson().toJson((Object) tagRequestParam));
                hashMap.put("systemParam", new Gson().toJson((Object) tagSystemParam));
                return aVar.mo23779D(hashMap);
            }
        });
    }

    /* renamed from: a */
    public static C1848s<JsonObject> m10177a(final List<PushRegIDRequestParam> list, final String str, final String str2, final String str3) {
        return m10175HN().mo10198h(new C1518f<C4098a, C1852w<JsonObject>>() {
            /* renamed from: a */
            public C1852w<JsonObject> apply(C4098a aVar) {
                HashMap hashMap = new HashMap();
                hashMap.put("requestParam", new Gson().toJson((Object) list));
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("appkey", str);
                jsonObject.addProperty("duiddigest", str2);
                if (!TextUtils.isEmpty(str3)) {
                    jsonObject.addProperty(SocialConstDef.FOLLOW_REQUEST_LIST_AUID, str3);
                }
                jsonObject.addProperty("method", "saveRegisterIds");
                hashMap.put("systemParam", new Gson().toJson((JsonElement) jsonObject));
                return aVar.mo23780E(hashMap);
            }
        });
    }
}
