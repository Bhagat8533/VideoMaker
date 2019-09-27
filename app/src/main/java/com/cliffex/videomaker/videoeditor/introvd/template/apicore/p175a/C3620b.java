package com.introvd.template.apicore.p175a;

import android.text.TextUtils;
import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.introvd.template.apicore.C3634k;
import com.introvd.template.apicore.C3646w;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.io.IOException;
import java.util.HashMap;
import okhttp3.C9943t;
import p037b.p050b.C1834l;
import p469f.C9740h;
import p469f.C9768m;
import p469f.C9769n;

/* renamed from: com.introvd.template.apicore.a.b */
public class C3620b {
    private static C9769n bhK;

    /* renamed from: Hc */
    private static C9769n m8856Hc() {
        if (bhK == null) {
            bhK = C3646w.m8939df("http://s.api.xiaoying.co/api/");
        }
        return bhK;
    }

    /* renamed from: f */
    public static C1834l<String> m8857f(String str, String str2, String str3, String str4) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("CommonAPIProxy parameter Null,method = ");
            sb.append(str);
            sb.append(",domain = ");
            sb.append(str2);
            sb.append(", url = ");
            sb.append(str3);
            throw new NullPointerException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str2);
        sb2.append(str3);
        return m8858g(str, sb2.toString(), str4);
    }

    /* renamed from: g */
    public static C1834l<String> m8858g(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("CommonAPIProxy parameter Null,method = ");
            sb.append(str);
            sb.append(",fullUrl = ");
            sb.append(str2);
            throw new NullPointerException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("method = ");
        sb2.append(str);
        sb2.append(",url = ");
        sb2.append(str2);
        Log.d("CommonAPI", sb2.toString());
        C3619a aVar = (C3619a) m8856Hc().mo37510S(C3619a.class);
        return "get".equalsIgnoreCase(str) ? aVar.mo22934d(str2, (HashMap) C3646w.m8940dg(str3)) : aVar.mo22933a(str2, new C3634k(C9943t.m28421ti(str2), str3).mo22977GW());
    }

    /* renamed from: l */
    public static HashMap<String, String> m8859l(Throwable th) {
        if (th == null) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        if (!(th instanceof C9740h)) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty(IronSourceConstants.EVENTS_ERROR_CODE, (Number) Integer.valueOf(-2017));
            jsonObject.addProperty("errorMsg", th.getClass().getSimpleName());
            hashMap.put(IronSourceConstants.EVENTS_ERROR_CODE, String.valueOf(-2017));
            hashMap.put("errorMsg", new Gson().toJson((JsonElement) jsonObject));
            return hashMap;
        }
        C9768m baz = ((C9740h) th).baz();
        hashMap.put(IronSourceConstants.EVENTS_ERROR_CODE, String.valueOf(baz.aTm()));
        try {
            hashMap.put("errorMsg", baz.baJ().string());
        } catch (IOException e) {
            e.printStackTrace();
            hashMap.put("errorMsg", e.getMessage());
        }
        return hashMap;
    }
}
