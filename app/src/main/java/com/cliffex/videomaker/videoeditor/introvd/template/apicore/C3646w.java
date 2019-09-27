package com.introvd.template.apicore;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.introvd.template.apicore.p175a.C3621c;
import com.introvd.template.p399t.C8611b;
import com.ironsource.mediationsdk.utils.ServerResponseWrapper;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.C9796aa;
import okhttp3.C9796aa.C9797a;
import okhttp3.C9802ac;
import okhttp3.C9945u;
import okhttp3.C9945u.C9946a;
import okhttp3.C9951x.C9953a;
import okhttp3.p478a.C9792a;
import okhttp3.p478a.C9792a.C9793a;
import p469f.C9703c.C9704a;
import p469f.C9730e.C9731a;
import p469f.C9769n;
import p469f.C9769n.C9771a;
import p469f.p470a.p471a.C9698h;
import p469f.p472b.p473a.C9700a;

/* renamed from: com.introvd.template.apicore.w */
public class C3646w {
    /* renamed from: Hb */
    public static C9953a m8931Hb() {
        C9953a aVar = new C9953a();
        C8611b.m25143a(aVar);
        return aVar;
    }

    /* renamed from: a */
    private static C9769n m8932a(boolean z, String str, int i) {
        C9953a aVar = new C9953a();
        aVar.mo38236l((long) i, TimeUnit.SECONDS);
        C9792a aVar2 = new C9792a();
        aVar2.mo37739a(C9793a.BODY);
        aVar.mo38229a((C9945u) aVar2);
        C3647x xVar = C3647x.bhI;
        C8611b.m25143a(aVar);
        aVar.mo38229a((C9945u) xVar);
        aVar.mo38229a((C9945u) new C3640q());
        C9771a aVar3 = new C9771a();
        aVar3.mo37525a(aVar.mo38232b((C9945u) C3648y.bhJ).aWR());
        if (z) {
            aVar3.mo37523a((C9731a) new C3631i()).mo37523a((C9731a) C9700a.baR());
        } else {
            aVar3.mo37523a((C9731a) new C3621c());
        }
        aVar3.mo37522a((C9704a) C9698h.baQ());
        try {
            aVar3.mo37528ua(str);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            aVar3.mo37528ua("https://s.api.xiaoying.co/api/rest/rt/");
        }
        return aVar3.baM();
    }

    /* renamed from: a */
    public static void m8934a(C9797a aVar, C9796aa aaVar) {
        if (TextUtils.isEmpty(aaVar.aWY().get("X-Xiaoying-Security-AppKey"))) {
            aVar.mo37759bR("Accept", "text/html,application/xhtml+xml,application/xml,application/json,application/octet-stream").mo37759bR("Referer", "http://xiaoying.tv").mo37759bR("User-Agent", "XiaoYing Android");
        }
        if (!TextUtils.isEmpty(C3624b.m8865GC().mo22942GD())) {
            aVar.mo37759bR("X-Forwarded-For", C3624b.m8865GC().mo22942GD());
        }
        if (!TextUtils.isEmpty(C3624b.m8865GC().mo22945GG())) {
            aVar.mo37759bR("X-Xiaoying-Security-longitude", C3624b.m8865GC().mo22945GG());
        }
        if (!TextUtils.isEmpty(C3624b.m8865GC().mo22946GH())) {
            aVar.mo37759bR("X-Xiaoying-Security-latitude", C3624b.m8865GC().mo22946GH());
        }
        C3630h GR = C3627e.m8892GQ().mo22966GR();
        if (GR != null && !TextUtils.isEmpty(GR.mo22972GV())) {
            aVar.mo37759bR("X-Xiaoying-Security-duid", GR.mo22972GV());
        }
        if (GR != null && !TextUtils.isEmpty(GR.mo22971GU())) {
            aVar.mo37759bR("X-Xiaoying-Security-auid", GR.mo22971GU());
        }
        aVar.mo37759bR("X-Xiaoying-Security-productId", C3624b.m8865GC().mo22940EI());
        if (!TextUtils.isEmpty(C3624b.m8865GC().countryCode)) {
            aVar.mo37759bR("X-Xiaoying-Security-countryCode", C3624b.m8865GC().countryCode);
        }
        if (GR != null && !TextUtils.isEmpty(GR.getLanguage())) {
            aVar.mo37759bR("X-Xiaoying-Security-language", GR.getLanguage());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static /* synthetic */ C9802ac m8935b(C9946a aVar) throws IOException {
        C9796aa aVO = aVar.aVO();
        if ("POST".equals(aVO.aTz())) {
            C9797a b = aVar.aVO().aXa().mo37755b(aVO.aTz(), aVO.aWZ());
            m8934a(b, aVO);
            aVO = b.aXf();
        }
        return aVar.mo37939c(aVO);
    }

    /* renamed from: de */
    static C9769n m8938de(String str) {
        return m8932a(true, str, 30);
    }

    /* renamed from: df */
    public static C9769n m8939df(String str) {
        return m8932a(false, str, 30);
    }

    /* renamed from: dg */
    public static Map<String, String> m8940dg(String str) {
        HashMap hashMap = new HashMap();
        try {
            hashMap.put("requestParam", URLEncoder.encode(str, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        hashMap.put("serverVer", "1.0");
        hashMap.put(ServerResponseWrapper.APP_KEY_FIELD, C3624b.m8865GC().mo22941EJ());
        hashMap.put("productId", C3624b.m8865GC().mo22940EI());
        if (!TextUtils.isEmpty(C3624b.m8865GC().countryCode)) {
            hashMap.put("countryCode", C3624b.m8865GC().countryCode);
        }
        return hashMap;
    }

    /* renamed from: n */
    static C9769n m8941n(String str, int i) {
        return m8932a(true, str, i);
    }

    /* renamed from: o */
    public static Map<String, String> m8942o(Map<String, String> map) {
        return m8940dg(new Gson().toJson((Object) map));
    }
}
