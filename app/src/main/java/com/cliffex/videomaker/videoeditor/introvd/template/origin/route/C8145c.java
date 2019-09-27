package com.introvd.template.origin.route;

import android.content.Context;
import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics.Event;
import com.introvd.template.C4677g;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.apicore.C3624b;
import com.introvd.template.apicore.C3625c;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.DftRootApiResultListenerImpl;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.RootApiResultListener;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.crash.C5523b;
import com.introvd.template.crash.C5526d;
import com.introvd.template.editor.p252e.C5878a;
import com.introvd.template.p203b.C4599k;
import com.p131c.p132a.C2561a;
import com.xiaoying.p448a.C9537b;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import p037b.p050b.C1843r;
import p037b.p050b.p076j.C1820a;

/* renamed from: com.introvd.template.origin.route.c */
public class C8145c {
    private static volatile C8145c dXf;
    /* access modifiers changed from: private */
    public C8150d dXa = new C8150d();
    private Map<String, String> dXb = new HashMap();
    private Map<String, C8149b> dXc = new HashMap();
    public String dXd;
    public String dXe;

    /* renamed from: com.introvd.template.origin.route.c$a */
    public static class C8148a {
        int dXj;
    }

    /* renamed from: com.introvd.template.origin.route.c$b */
    public static class C8149b {
        public Map<String, String> dXk = new HashMap();
        public Map<String, C8148a> dXl = new HashMap();
    }

    private C8145c() {
        this.dXb.put("d", "d");
        this.dXb.put(C5878a.TAG, C5878a.TAG);
        this.dXb.put("u", "u");
        this.dXb.put("v", "v");
        this.dXb.put("s", "s");
        this.dXb.put("r", "r");
        this.dXb.put("m", "m");
        this.dXb.put("t", "t");
        this.dXb.put("y", "y");
        this.dXb.put(TtmlNode.TAG_P, TtmlNode.TAG_P);
        this.dXb.put(C4677g.TAG, C4677g.TAG);
        this.dXb.put(Event.SEARCH, Event.SEARCH);
        this.dXb.put("h", "h");
        this.dXb.put("ad", "ad");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m23564a(Context context, boolean z, int i, RootApiResultListener rootApiResultListener) {
        if (i >= 1) {
            if (rootApiResultListener != null) {
                rootApiResultListener.onError(new C5526d("getRouteConfigure retry attain max count"));
            }
            return;
        }
        C1843r aVj = C1820a.aVj();
        final boolean z2 = z;
        final Context context2 = context;
        final int i2 = i;
        final RootApiResultListener rootApiResultListener2 = rootApiResultListener;
        C81461 r1 = new Runnable() {
            public void run() {
                if (z2 && C4599k.m11735dN(context2)) {
                    if (i2 > 0) {
                        try {
                            Thread.sleep(1000);
                        } catch (Exception unused) {
                        }
                    }
                    C8145c.this.dXa.mo33233a(context2, C8145c.this.dXa.aFh(), new DftRootApiResultListenerImpl() {
                        public void onError(Throwable th) {
                            C8145c.this.m23564a(context2, z2, i2 + 1, rootApiResultListener2);
                        }

                        public void onSuccess(Boolean bool, Object obj) {
                            C8145c.this.m23568g((JSONObject) obj);
                            if (rootApiResultListener2 != null) {
                                rootApiResultListener2.onSuccess(bool, obj);
                            }
                        }
                    });
                }
            }
        };
        aVj.mo10058o(r1);
    }

    public static C8145c aFd() {
        if (dXf == null) {
            synchronized (C8145c.class) {
                if (dXf == null) {
                    dXf = new C8145c();
                }
            }
        }
        return dXf;
    }

    /* renamed from: cg */
    private static void m23567cg(Context context, String str) {
        C8150d.m23575M(context, "App_Route_Cache_Current", str);
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m23568g(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.dXe = jSONObject.optString("zone", null);
            this.dXd = jSONObject.optString("country", null);
            if (this.dXd == null) {
                HashMap hashMap = new HashMap();
                hashMap.put("reason", "parseConfigure");
                hashMap.put("country", AppStateModel.getInstance().getCountryCode());
                hashMap.put("zone", AppStateModel.getInstance().getZoneCode());
                try {
                    JSONObject jSONObject2 = new JSONObject(jSONObject.toString());
                    jSONObject2.put("zones", "replace datas");
                    hashMap.put("jsondata", jSONObject2.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                UserBehaviorLog.onKVEvent(VivaBaseApplication.m8749FZ(), " Dev_Event_Country_Null_Event_result", hashMap);
                this.dXd = AppStateModel.getInstance().getCountryCode();
            }
            if (this.dXe == null) {
                this.dXe = AppStateModel.getInstance().getZoneCode();
            }
            StringBuilder sb = new StringBuilder();
            sb.append("mStrZoneViaIP=");
            sb.append(this.dXe);
            LogUtilsV2.m14228e(sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("mStrCountryViaIP=");
            sb2.append(this.dXd);
            LogUtilsV2.m14228e(sb2.toString());
            Object opt = jSONObject.opt("zones");
            if (opt instanceof JSONArray) {
                JSONArray jSONArray = (JSONArray) opt;
                HashMap hashMap2 = new HashMap();
                for (int i = 0; i < jSONArray.length(); i++) {
                    try {
                        JSONObject jSONObject3 = jSONArray.getJSONObject(i);
                        String optString = jSONObject3.optString("zone");
                        JSONArray jSONArray2 = jSONObject3.getJSONArray("domainlist");
                        HashMap hashMap3 = new HashMap();
                        for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                            JSONObject jSONObject4 = jSONArray2.getJSONObject(i2);
                            String optString2 = jSONObject4.optString("domain");
                            String optString3 = jSONObject4.optString("url");
                            String str = (String) this.dXb.get(optString2);
                            if (str != null) {
                                optString2 = str;
                            }
                            hashMap3.put(optString2, optString3);
                        }
                        HashMap hashMap4 = new HashMap();
                        JSONArray jSONArray3 = jSONObject3.getJSONArray("countrylist");
                        int appSettingInt = AppPreferencesSetting.getInstance().getAppSettingInt("pref_snsflag", 0);
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("settingSNSFlag : ");
                        sb3.append(appSettingInt);
                        LogUtilsV2.m14228e(sb3.toString());
                        for (int i3 = 0; i3 < jSONArray3.length(); i3++) {
                            JSONObject jSONObject5 = jSONArray3.getJSONObject(i3);
                            String optString4 = jSONObject5.optString("code");
                            int optInt = jSONObject5.optInt("sns");
                            C8148a aVar = new C8148a();
                            aVar.dXj = optInt;
                            if (appSettingInt > 0) {
                                aVar.dXj = appSettingInt;
                            }
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append("strCode=");
                            sb4.append(optString4);
                            sb4.append(";nSNS=");
                            sb4.append(aVar.dXj);
                            LogUtilsV2.m14228e(sb4.toString());
                            hashMap4.put(optString4, aVar);
                        }
                        C8149b bVar = new C8149b();
                        bVar.dXk = hashMap3;
                        bVar.dXl = hashMap4;
                        hashMap2.put(optString, bVar);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                int optInt2 = jSONObject.optInt("groupId", -1);
                if (optInt2 != -1) {
                    AppStateModel.getInstance().updateGroupId(String.valueOf(optInt2));
                }
                synchronized (C8145c.class) {
                    this.dXc = new HashMap(hashMap2);
                }
            }
        }
    }

    /* renamed from: gy */
    public static String m23569gy(Context context) {
        return C8150d.m23576N(context, "App_Route_Cache_Current", null);
    }

    /* renamed from: gz */
    public static String[] m23570gz(Context context) {
        return new String[]{C8150d.m23576N(context, "App_Route_Cache_CurrentUser_Zone", null), C8150d.m23576N(context, "App_Route_Cache_CurrentUser_Country", null)};
    }

    public static void setUserZoneInfo(Context context, String str, String str2) {
        C8150d.m23575M(context, "App_Route_Cache_CurrentUser_Zone", str);
        C8150d.m23575M(context, "App_Route_Cache_CurrentUser_Country", str2);
    }

    /* renamed from: a */
    public void mo33224a(Context context, boolean z, RootApiResultListener rootApiResultListener) {
        JSONObject gA = this.dXa.mo33235gA(context);
        if (gA != null) {
            m23568g(gA);
            if (rootApiResultListener != null) {
                rootApiResultListener.onSuccess(Boolean.valueOf(false), gA);
            }
        } else if (rootApiResultListener != null) {
            rootApiResultListener.onError(new C5526d("getRouteConfigure retry attain max count"));
        }
        m23564a(context, z, 0, rootApiResultListener);
    }

    public C8149b aFe() {
        C8149b bVar;
        synchronized (C8145c.class) {
            bVar = (C8149b) this.dXc.get(this.dXe);
        }
        return bVar;
    }

    public String aFf() {
        return this.dXe;
    }

    public String aFg() {
        return this.dXd;
    }

    /* renamed from: aI */
    public void mo33228aI(String str, String str2) {
        boolean z;
        boolean z2;
        boolean z3;
        if (this.dXc != null) {
            String aFf = aFf();
            if (TextUtils.isEmpty(str)) {
                str = aFf;
            }
            C8149b bVar = (C8149b) this.dXc.get(str);
            if (bVar != null) {
                C8148a aVar = (C8148a) bVar.dXl.get(str2);
                if (aVar != null) {
                    z3 = (aVar.dXj & 1) != 0;
                    z2 = (aVar.dXj & 2) != 0;
                    z = (z3 && !z2) || (aVar.dXj & 4) != 0;
                    AppStateModel.getInstance().updateCommRouteConfig(!VivaBaseApplication.m8749FZ().mo22829Gb() && (aVar.dXj & 16) != 0, (aVar.dXj & 8) != 0, (aVar.dXj & 32) != 0, (aVar.dXj & 64) != 0);
                } else {
                    z3 = false;
                    z2 = false;
                    z = false;
                }
                AppStateModel.getInstance().updateCommunityState(z3, z2, z);
                AppStateModel.getInstance().updateCountryCodeAndZone(str2, str);
            }
        }
        if (C2561a.aOR() != 1) {
            AppStateModel.getInstance().updateCommunityState(false, false, false);
        }
        String countryCode = AppStateModel.getInstance().getCountryCode();
        C9537b.setParameter("CountryCode", countryCode);
        C3624b.m8865GC().countryCode = countryCode;
        LogUtilsV2.m14228e("AppStateModel isCommunityFeatureEnable reset");
    }

    /* renamed from: aJ */
    public void mo33229aJ(String str, String str2) {
        this.dXe = str;
        this.dXd = str2;
        if (this.dXd == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("reason", "updateViaIPZoneAndCountry set");
            UserBehaviorLog.onKVEvent(VivaBaseApplication.m8749FZ(), " Dev_Event_Country_Null_Event_result", hashMap);
        }
    }

    /* renamed from: cf */
    public void mo33230cf(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            str = this.dXe;
        }
        C8149b bVar = (C8149b) this.dXc.get(str);
        if (bVar != null) {
            Map<String, String> map = bVar.dXk;
            if (map != null) {
                if (!map.containsKey("push")) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("mDomainMap not contain push;");
                    sb.append(map.size());
                    C5523b.logException(new C5526d(sb.toString()));
                    map.put("push", "http://push.api.xiaoying.co/api/rest/push");
                }
                C9537b.setParameter("SocialURLMap", map);
                C3625c.m8880GI().mo22965n(map);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Apply router zone[");
                sb2.append(str);
                sb2.append("], url:");
                sb2.append(map);
                LogUtilsV2.m14230i(sb2.toString());
            }
            m23567cg(context, str);
        }
        if (this.dXd == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("reason", "route apply");
            UserBehaviorLog.onKVEvent(VivaBaseApplication.m8749FZ(), " Dev_Event_Country_Null_Event_result", hashMap);
        }
        mo33228aI(str, this.dXd);
    }
}
