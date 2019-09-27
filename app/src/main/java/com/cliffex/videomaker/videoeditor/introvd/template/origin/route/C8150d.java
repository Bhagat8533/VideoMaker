package com.introvd.template.origin.route;

import android.content.Context;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.apicore.C3618a;
import com.introvd.template.apicore.C3624b;
import com.introvd.template.apicore.C3625c;
import com.introvd.template.apicore.C3636m;
import com.introvd.template.channel.C5206b;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.RootApiResultListener;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.common.behavior.UserBehaviorUtils;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.crash.C5523b;
import com.introvd.template.crash.C5526d;
import com.introvd.template.module.iap.business.p356e.C7900d;
import com.introvd.template.module.iap.business.p356e.C7900d.C7903a;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p203b.C4599k;
import com.introvd.template.router.user.UserServiceProxy;
import com.p131c.p132a.p135c.C2575a;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import p037b.p050b.C1848s;
import p037b.p050b.C1850u;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p076j.C1820a;

/* renamed from: com.introvd.template.origin.route.d */
public class C8150d {
    /* access modifiers changed from: private */
    public int retryCount = 0;

    /* renamed from: M */
    static void m23575M(Context context, String str, String str2) {
        AppPreferencesSetting.getInstance().setAppSettingStr(str, str2);
    }

    /* renamed from: N */
    static String m23576N(Context context, String str, String str2) {
        return AppPreferencesSetting.getInstance().getAppSettingStr(str, str2);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m23579a(Context context, String str, long j, Map<String, String> map, RootApiResultListener rootApiResultListener) {
        C1848s f = C8142b.m23559N(map).mo10196g(C1820a.aVi()).mo10194f(C1820a.aVi());
        final long j2 = j;
        final Context context2 = context;
        final RootApiResultListener rootApiResultListener2 = rootApiResultListener;
        final String str2 = str;
        C81522 r0 = new C1850u<JsonObject>() {
            /* renamed from: a */
            public void mo9883a(C1495b bVar) {
            }

            /* renamed from: a */
            public void onSuccess(JsonObject jsonObject) {
                UserBehaviorUtils.recordRouteConfigEvent(context2, true, System.currentTimeMillis() - j2);
                try {
                    new Gson().fromJson((JsonElement) jsonObject, AppZoneResult.class);
                    String jsonObject2 = jsonObject.toString();
                    if ("http://s-qa2.api.xiaoying.co/api/rest/rt".equals(VivaBaseApplication.m8749FZ().bfP)) {
                        jsonObject2 = jsonObject2.replaceAll("-qa.", "-qa2.");
                    }
                    VivaBaseApplication.bfO = jsonObject2;
                    try {
                        JSONObject jSONObject = new JSONObject(jsonObject2);
                        C8150d.m23582ch(context2, jsonObject2);
                        C8150d.m23575M(context2, "App_Route_Cache_Timestamp", String.valueOf(System.currentTimeMillis()));
                        if (rootApiResultListener2 != null) {
                            rootApiResultListener2.onSuccess(Boolean.valueOf(true), jSONObject);
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                        if (rootApiResultListener2 != null) {
                            rootApiResultListener2.onError(new Throwable("json is not correct"));
                        }
                    }
                } catch (Exception unused) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("json is not correct : ");
                    sb.append(jsonObject.toString());
                    C5523b.logException(new C5526d(sb.toString()));
                    if (rootApiResultListener2 != null) {
                        rootApiResultListener2.onError(new Throwable("json is not correct"));
                    }
                }
            }

            public void onError(final Throwable th) {
                UserBehaviorUtils.recordRouteConfigEvent(context2, false, System.currentTimeMillis() - j2);
                if (C8150d.this.retryCount >= 3) {
                    if (rootApiResultListener2 != null) {
                        rootApiResultListener2.onError(th);
                    }
                    return;
                }
                C8150d.this.retryCount = C8150d.this.retryCount + 1;
                C7900d.m23029a((C7903a) new C7903a() {
                    public void onComplete() {
                        String str;
                        C7900d dVar = new C7900d();
                        String lw = dVar.mo32861lw("route_config_is_server_blocked");
                        if (TextUtils.isEmpty(lw) || !Boolean.parseBoolean(lw) || !TextUtils.equals(C8150d.this.aFh(), str2)) {
                            if (rootApiResultListener2 != null) {
                                rootApiResultListener2.onError(th);
                            }
                            return;
                        }
                        String lw2 = dVar.mo32861lw("route_config_switch_url");
                        String str2 = "/api/rest/rt/";
                        String str3 = "";
                        try {
                            str = lw2.substring(0, lw2.indexOf(str2) + str2.length());
                        } catch (Exception e) {
                            e.printStackTrace();
                            str = str3;
                        }
                        if (TextUtils.isEmpty(str)) {
                            str = "https://rt.uwx1.xyz/api/rest/rt/";
                        }
                        C3618a.m8852GB();
                        C3636m.m8911GX();
                        C8150d.this.mo33233a(context2, str, rootApiResultListener2);
                    }
                });
            }
        };
        f.mo10188a((C1850u<? super T>) r0);
    }

    private String aFi() {
        if (TextUtils.isEmpty(VivaBaseApplication.m8749FZ().bfP)) {
            return "{\"country\":\"US\",\"zone\":\"us\",\"groupId\":1,\"zones\":[{\"domainlist\":[{\"domain\":\"a\",\"url\":\"https://viva.v21xy.com/api/rest/a\"},{\"domain\":\"u\",\"url\":\"https://viva.v21xy.com/api/rest/u\"},{\"domain\":\"v\",\"url\":\"https://viva.api.xiaoying.co/api/rest/v\"},{\"domain\":\"s\",\"url\":\"https://medi.rthdo.com/api/rest/s\"},{\"domain\":\"r\",\"url\":\"https://r.api.xiaoying.co/api/rest/r\"},{\"domain\":\"m\",\"url\":\"https://viva.api.xiaoying.co/api/rest/m\"},{\"domain\":\"p\",\"url\":\"https://viva.api.xiaoying.co/api/rest/p\"},{\"domain\":\"g\",\"url\":\"https://viva.api.xiaoying.co/api/rest/g\"},{\"domain\":\"search\",\"url\":\"https://viva.api.xiaoying.co/api/rest/search\"},{\"domain\":\"h\",\"url\":\"https://viva.api.xiaoying.co/api/rest/h\"},{\"domain\":\"ad\",\"url\":\"https://viva.v21xy.com/api/rest/ad\"},{\"domain\":\"t\",\"url\":\"https://medi.rthdo.com/api/rest/t\"},{\"domain\":\"y\",\"url\":\"https://viva.api.xiaoying.co/api/rest/y\"},{\"domain\":\"d\",\"url\":\"https://medi.rthdo.com/api/rest/d\"},{\"domain\":\"push\",\"url\":\"https://medi.rthdo.com/api/rest/push\"},{\"domain\":\"live\",\"url\":\"https://lv-gift.v21xy.com\"},{\"domain\":\"rt\",\"url\":\"https://s.api.xiaoying.co/api/rest/rt\"},{\"domain\":\"medi\",\"url\":\"https://medi.rthdo.com\"},{\"domain\":\"vcm\",\"url\":\"https://vcm-app.gltxy.xyz\"},{\"domain\":\"sc\",\"url\":\"https://viva.api.xiaoying.co/api/rest/sc\"}],\"zone\":\"hz\",\"countrylist\":[{\"code\":\"CN\",\"sns\":71}]},{\"domainlist\":[{\"domain\":\"a\",\"url\":\"https://viva-asia1.vvbrd.com/api/rest/a\"},{\"domain\":\"u\",\"url\":\"https://viva-asia1.vvbrd.com/api/rest/u\"},{\"domain\":\"v\",\"url\":\"https://viva-asia1.vvbrd.com/api/rest/v\"},{\"domain\":\"s\",\"url\":\"https://medi-asia1.intsvs.com/api/rest/s\"},{\"domain\":\"r\",\"url\":\"https://viva-asia1-ak.api.xiaoying.co/api/rest/r\"},{\"domain\":\"m\",\"url\":\"https://viva-asia1.vvbrd.com/api/rest/m\"},{\"domain\":\"p\",\"url\":\"https://viva-asia1.vvbrd.com/api/rest/p\"},{\"domain\":\"g\",\"url\":\"https://viva-asia1.vvbrd.com/api/rest/g\"},{\"domain\":\"search\",\"url\":\"https://viva-asia1.vvbrd.com/api/rest/search\"},{\"domain\":\"h\",\"url\":\"https://viva.api.xiaoying.co/api/rest/h\"},{\"domain\":\"ad\",\"url\":\"https://viva-asia1.vvbrd.com/api/rest/ad\"},{\"domain\":\"t\",\"url\":\"https://medi-asia1.intsvs.com/api/rest/t\"},{\"domain\":\"y\",\"url\":\"https://viva-asia1.vvbrd.com/api/rest/y\"},{\"domain\":\"d\",\"url\":\"https://medi-asia1.intsvs.com/api/rest/d\"},{\"domain\":\"push\",\"url\":\"https://medi-asia1.intsvs.com/api/rest/push\"},{\"domain\":\"rt\",\"url\":\"https://rt.uwx1.xyz/api/rest/rt\"},{\"domain\":\"crawer\",\"url\":\"https://medi-asia1.intsvs.com/api/rest/crawer\"},{\"domain\":\"medi\",\"url\":\"https://medi-asia1.intsvs.com\"},{\"domain\":\"sc\",\"url\":\"https://viva-asia1.vvbrd.com/api/rest/sc\"}],\"zone\":\"asia1\",\"countrylist\":[{\"code\":\"PH\",\"sns\":0},{\"code\":\"MY\",\"sns\":0},{\"code\":\"SG\",\"sns\":7},{\"code\":\"JP\",\"sns\":3},{\"code\":\"TW\",\"sns\":3},{\"code\":\"HK\",\"sns\":7},{\"code\":\"IN\",\"sns\":23}]},{\"domainlist\":[{\"domain\":\"a\",\"url\":\"https://viva-us.vvbrd.com/api/rest/a\"},{\"domain\":\"d\",\"url\":\"https://medi-us.intsvs.com/api/rest/d\"},{\"domain\":\"u\",\"url\":\"https://viva-us.vvbrd.com/api/rest/u\"},{\"domain\":\"v\",\"url\":\"https://viva-us.vvbrd.com/api/rest/v\"},{\"domain\":\"s\",\"url\":\"https://medi-us.intsvs.com/api/rest/s\"},{\"domain\":\"r\",\"url\":\"https://viva-us-ak.api.xiaoying.co/api/rest/r\"},{\"domain\":\"m\",\"url\":\"https://viva-us.vvbrd.com/api/rest/m\"},{\"domain\":\"p\",\"url\":\"https://viva-us.vvbrd.com/api/rest/p\"},{\"domain\":\"g\",\"url\":\"https://viva-us.vvbrd.com/api/rest/g\"},{\"domain\":\"search\",\"url\":\"https://viva-us.vvbrd.com/api/rest/search\"},{\"domain\":\"h\",\"url\":\"https://viva.api.xiaoying.co/api/rest/h\"},{\"domain\":\"ad\",\"url\":\"https://viva-us.vvbrd.com/api/rest/ad\"},{\"domain\":\"t\",\"url\":\"https://medi-us.intsvs.com/api/rest/t\"},{\"domain\":\"y\",\"url\":\"https://viva-us.vvbrd.com/api/rest/y\"},{\"domain\":\"push\",\"url\":\"https://medi-us.intsvs.com/api/rest/push\"},{\"domain\":\"live\",\"url\":\"https://viva-us.api.xiaoying.co\"},{\"domain\":\"rt\",\"url\":\"https://rt.uwx1.xyz/api/rest/rt\"},{\"domain\":\"crawer\",\"url\":\"https://medi-us.intsvs.com/api/rest/crawer\"},{\"domain\":\"medi\",\"url\":\"https://medi-us.intsvs.com\"},{\"domain\":\"sc\",\"url\":\"https://viva-us.vvbrd.com/api/rest/sc\"}],\"zone\":\"us\",\"countrylist\":[{\"code\":\"BR\",\"sns\":3},{\"code\":\"US\",\"sns\":3}]},{\"domainlist\":[{\"domain\":\"a\",\"url\":\"https://viva-flkf.vvbrd.com/api/rest/a\"},{\"domain\":\"u\",\"url\":\"https://viva-flkf.vvbrd.com/api/rest/u\"},{\"domain\":\"v\",\"url\":\"https://viva-flkf.vvbrd.com/api/rest/v\"},{\"domain\":\"s\",\"url\":\"https://medi-flkf.intsvs.com/api/rest/s\"},{\"domain\":\"r\",\"url\":\"https://r.api.xiaoying.co/api/rest/r\"},{\"domain\":\"m\",\"url\":\"https://viva-flkf.vvbrd.com/api/rest/m\"},{\"domain\":\"p\",\"url\":\"https://viva-flkf.vvbrd.com/api/rest/p\"},{\"domain\":\"g\",\"url\":\"https://viva-flkf.vvbrd.com/api/rest/g\"},{\"domain\":\"search\",\"url\":\"https://viva-flkf.vvbrd.com/api/rest/search\"},{\"domain\":\"h\",\"url\":\"https://viva-meast-ak.api.xiaoying.co/api/rest/h\"},{\"domain\":\"ad\",\"url\":\"https://viva-flkf.vvbrd.com/api/rest/ad\"},{\"domain\":\"t\",\"url\":\"https://medi-flkf.intsvs.com/api/rest/t\"},{\"domain\":\"y\",\"url\":\"https://viva-flkf.vvbrd.com/api/rest/y\"},{\"domain\":\"d\",\"url\":\"https://medi-flkf.intsvs.com/api/rest/d\"},{\"domain\":\"rt\",\"url\":\"https://rt.uwx1.xyz/api/rest/rt\"},{\"domain\":\"push\",\"url\":\"https://medi-flkf.intsvs.com/api/rest/push\"},{\"domain\":\"crawer\",\"url\":\"https://medi-flkf.intsvs.com/api/rest/crawer\"},{\"domain\":\"medi\",\"url\":\"https://medi-flkf.intsvs.com\"},{\"domain\":\"sc\",\"url\":\"https://viva-flkf.vvbrd.com/api/rest/sc\"}],\"zone\":\"meast\",\"countrylist\":[{\"code\":\"SA\",\"sns\":23},{\"code\":\"MA\",\"sns\":23},{\"code\":\"DZ\",\"sns\":23},{\"code\":\"EG\",\"sns\":23},{\"code\":\"KW\",\"sns\":23},{\"code\":\"JO\",\"sns\":23},{\"code\":\"TN\",\"sns\":23},{\"code\":\"OM\",\"sns\":23},{\"code\":\"LB\",\"sns\":23},{\"code\":\"QA\",\"sns\":23},{\"code\":\"PS\",\"sns\":23},{\"code\":\"LY\",\"sns\":23},{\"code\":\"YE\",\"sns\":23},{\"code\":\"AE\",\"sns\":23},{\"code\":\"BH\",\"sns\":23},{\"code\":\"IQ\",\"sns\":23},{\"code\":\"SY\",\"sns\":23}]}]}";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(">>>>>>>>>>>>>>>> serverMode = ");
        sb.append(VivaBaseApplication.m8749FZ().bfP);
        LogUtilsV2.m14228e(sb.toString());
        String mi = m23585mi(VivaBaseApplication.m8749FZ().bfP);
        if (TextUtils.isEmpty(mi)) {
            ToastUtils.show(VivaBaseApplication.m8749FZ().getApplicationContext(), "RouteConfig is Empty!!! contact app dev", 1);
        }
        return mi;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0023 A[SYNTHETIC, Splitter:B:17:0x0023] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0029 A[SYNTHETIC, Splitter:B:21:0x0029] */
    /* JADX WARNING: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /* renamed from: ch */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m23582ch(android.content.Context r3, java.lang.String r4) {
        /*
            r0 = 0
            java.lang.String r1 = ".xyroute"
            r2 = 0
            java.io.FileOutputStream r3 = r3.openFileOutput(r1, r2)     // Catch:{ Exception -> 0x001d }
            byte[] r4 = r4.getBytes()     // Catch:{ Exception -> 0x0018, all -> 0x0015 }
            r3.write(r4)     // Catch:{ Exception -> 0x0018, all -> 0x0015 }
            if (r3 == 0) goto L_0x0026
            r3.close()     // Catch:{ Exception -> 0x0026 }
            goto L_0x0026
        L_0x0015:
            r4 = move-exception
            r0 = r3
            goto L_0x0027
        L_0x0018:
            r4 = move-exception
            r0 = r3
            goto L_0x001e
        L_0x001b:
            r4 = move-exception
            goto L_0x0027
        L_0x001d:
            r4 = move-exception
        L_0x001e:
            r4.printStackTrace()     // Catch:{ all -> 0x001b }
            if (r0 == 0) goto L_0x0026
            r0.close()     // Catch:{ Exception -> 0x0026 }
        L_0x0026:
            return
        L_0x0027:
            if (r0 == 0) goto L_0x002c
            r0.close()     // Catch:{ Exception -> 0x002c }
        L_0x002c:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.origin.route.C8150d.m23582ch(android.content.Context, java.lang.String):void");
    }

    /* renamed from: gB */
    private static boolean m23583gB(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(context.getFilesDir().getAbsolutePath());
        sb.append(File.separator);
        sb.append(".xyroute");
        return new File(sb.toString()).exists();
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0029 A[SYNTHETIC, Splitter:B:18:0x0029] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0030 A[SYNTHETIC, Splitter:B:24:0x0030] */
    /* renamed from: gC */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String m23584gC(android.content.Context r4) {
        /*
            r0 = 0
            java.lang.String r1 = ".xyroute"
            java.io.FileInputStream r4 = r4.openFileInput(r1)     // Catch:{ Exception -> 0x0022, all -> 0x001d }
            int r1 = r4.available()     // Catch:{ Exception -> 0x001b }
            byte[] r1 = new byte[r1]     // Catch:{ Exception -> 0x001b }
            r4.read(r1)     // Catch:{ Exception -> 0x001b }
            java.lang.String r2 = new java.lang.String     // Catch:{ Exception -> 0x001b }
            r2.<init>(r1)     // Catch:{ Exception -> 0x001b }
            if (r4 == 0) goto L_0x001a
            r4.close()     // Catch:{ Exception -> 0x001a }
        L_0x001a:
            return r2
        L_0x001b:
            r1 = move-exception
            goto L_0x0024
        L_0x001d:
            r4 = move-exception
            r3 = r0
            r0 = r4
            r4 = r3
            goto L_0x002e
        L_0x0022:
            r1 = move-exception
            r4 = r0
        L_0x0024:
            r1.printStackTrace()     // Catch:{ all -> 0x002d }
            if (r4 == 0) goto L_0x002c
            r4.close()     // Catch:{ Exception -> 0x002c }
        L_0x002c:
            return r0
        L_0x002d:
            r0 = move-exception
        L_0x002e:
            if (r4 == 0) goto L_0x0033
            r4.close()     // Catch:{ Exception -> 0x0033 }
        L_0x0033:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.origin.route.C8150d.m23584gC(android.content.Context):java.lang.String");
    }

    /* renamed from: mi */
    private String m23585mi(String str) {
        return "https://rt.api.xiaoying.co/api/rest/rt/".equals(str) ? "{\"country\":\"US\",\"zone\":\"us\",\"groupId\":1,\"zones\":[{\"domainlist\":[{\"domain\":\"a\",\"url\":\"https://viva.v21xy.com/api/rest/a\"},{\"domain\":\"u\",\"url\":\"https://viva.v21xy.com/api/rest/u\"},{\"domain\":\"v\",\"url\":\"https://viva.api.xiaoying.co/api/rest/v\"},{\"domain\":\"s\",\"url\":\"https://medi.rthdo.com/api/rest/s\"},{\"domain\":\"r\",\"url\":\"https://r.api.xiaoying.co/api/rest/r\"},{\"domain\":\"m\",\"url\":\"https://viva.api.xiaoying.co/api/rest/m\"},{\"domain\":\"p\",\"url\":\"https://viva.api.xiaoying.co/api/rest/p\"},{\"domain\":\"g\",\"url\":\"https://viva.api.xiaoying.co/api/rest/g\"},{\"domain\":\"search\",\"url\":\"https://viva.api.xiaoying.co/api/rest/search\"},{\"domain\":\"h\",\"url\":\"https://viva.api.xiaoying.co/api/rest/h\"},{\"domain\":\"ad\",\"url\":\"https://viva.v21xy.com/api/rest/ad\"},{\"domain\":\"t\",\"url\":\"https://medi.rthdo.com/api/rest/t\"},{\"domain\":\"y\",\"url\":\"https://viva.api.xiaoying.co/api/rest/y\"},{\"domain\":\"d\",\"url\":\"https://medi.rthdo.com/api/rest/d\"},{\"domain\":\"push\",\"url\":\"https://medi.rthdo.com/api/rest/push\"},{\"domain\":\"live\",\"url\":\"https://lv-gift.v21xy.com\"},{\"domain\":\"rt\",\"url\":\"https://s.api.xiaoying.co/api/rest/rt\"},{\"domain\":\"medi\",\"url\":\"https://medi.rthdo.com\"},{\"domain\":\"vcm\",\"url\":\"https://vcm-app.gltxy.xyz\"},{\"domain\":\"sc\",\"url\":\"https://viva.api.xiaoying.co/api/rest/sc\"}],\"zone\":\"hz\",\"countrylist\":[{\"code\":\"CN\",\"sns\":71}]},{\"domainlist\":[{\"domain\":\"a\",\"url\":\"https://viva-asia1.vvbrd.com/api/rest/a\"},{\"domain\":\"u\",\"url\":\"https://viva-asia1.vvbrd.com/api/rest/u\"},{\"domain\":\"v\",\"url\":\"https://viva-asia1.vvbrd.com/api/rest/v\"},{\"domain\":\"s\",\"url\":\"https://medi-asia1.intsvs.com/api/rest/s\"},{\"domain\":\"r\",\"url\":\"https://viva-asia1-ak.api.xiaoying.co/api/rest/r\"},{\"domain\":\"m\",\"url\":\"https://viva-asia1.vvbrd.com/api/rest/m\"},{\"domain\":\"p\",\"url\":\"https://viva-asia1.vvbrd.com/api/rest/p\"},{\"domain\":\"g\",\"url\":\"https://viva-asia1.vvbrd.com/api/rest/g\"},{\"domain\":\"search\",\"url\":\"https://viva-asia1.vvbrd.com/api/rest/search\"},{\"domain\":\"h\",\"url\":\"https://viva.api.xiaoying.co/api/rest/h\"},{\"domain\":\"ad\",\"url\":\"https://viva-asia1.vvbrd.com/api/rest/ad\"},{\"domain\":\"t\",\"url\":\"https://medi-asia1.intsvs.com/api/rest/t\"},{\"domain\":\"y\",\"url\":\"https://viva-asia1.vvbrd.com/api/rest/y\"},{\"domain\":\"d\",\"url\":\"https://medi-asia1.intsvs.com/api/rest/d\"},{\"domain\":\"push\",\"url\":\"https://medi-asia1.intsvs.com/api/rest/push\"},{\"domain\":\"rt\",\"url\":\"https://rt.uwx1.xyz/api/rest/rt\"},{\"domain\":\"crawer\",\"url\":\"https://medi-asia1.intsvs.com/api/rest/crawer\"},{\"domain\":\"medi\",\"url\":\"https://medi-asia1.intsvs.com\"},{\"domain\":\"sc\",\"url\":\"https://viva-asia1.vvbrd.com/api/rest/sc\"}],\"zone\":\"asia1\",\"countrylist\":[{\"code\":\"PH\",\"sns\":0},{\"code\":\"MY\",\"sns\":0},{\"code\":\"SG\",\"sns\":7},{\"code\":\"JP\",\"sns\":3},{\"code\":\"TW\",\"sns\":3},{\"code\":\"HK\",\"sns\":7},{\"code\":\"IN\",\"sns\":23}]},{\"domainlist\":[{\"domain\":\"a\",\"url\":\"https://viva-us.vvbrd.com/api/rest/a\"},{\"domain\":\"d\",\"url\":\"https://medi-us.intsvs.com/api/rest/d\"},{\"domain\":\"u\",\"url\":\"https://viva-us.vvbrd.com/api/rest/u\"},{\"domain\":\"v\",\"url\":\"https://viva-us.vvbrd.com/api/rest/v\"},{\"domain\":\"s\",\"url\":\"https://medi-us.intsvs.com/api/rest/s\"},{\"domain\":\"r\",\"url\":\"https://viva-us-ak.api.xiaoying.co/api/rest/r\"},{\"domain\":\"m\",\"url\":\"https://viva-us.vvbrd.com/api/rest/m\"},{\"domain\":\"p\",\"url\":\"https://viva-us.vvbrd.com/api/rest/p\"},{\"domain\":\"g\",\"url\":\"https://viva-us.vvbrd.com/api/rest/g\"},{\"domain\":\"search\",\"url\":\"https://viva-us.vvbrd.com/api/rest/search\"},{\"domain\":\"h\",\"url\":\"https://viva.api.xiaoying.co/api/rest/h\"},{\"domain\":\"ad\",\"url\":\"https://viva-us.vvbrd.com/api/rest/ad\"},{\"domain\":\"t\",\"url\":\"https://medi-us.intsvs.com/api/rest/t\"},{\"domain\":\"y\",\"url\":\"https://viva-us.vvbrd.com/api/rest/y\"},{\"domain\":\"push\",\"url\":\"https://medi-us.intsvs.com/api/rest/push\"},{\"domain\":\"live\",\"url\":\"https://viva-us.api.xiaoying.co\"},{\"domain\":\"rt\",\"url\":\"https://rt.uwx1.xyz/api/rest/rt\"},{\"domain\":\"crawer\",\"url\":\"https://medi-us.intsvs.com/api/rest/crawer\"},{\"domain\":\"medi\",\"url\":\"https://medi-us.intsvs.com\"},{\"domain\":\"sc\",\"url\":\"https://viva-us.vvbrd.com/api/rest/sc\"}],\"zone\":\"us\",\"countrylist\":[{\"code\":\"BR\",\"sns\":3},{\"code\":\"US\",\"sns\":3}]},{\"domainlist\":[{\"domain\":\"a\",\"url\":\"https://viva-flkf.vvbrd.com/api/rest/a\"},{\"domain\":\"u\",\"url\":\"https://viva-flkf.vvbrd.com/api/rest/u\"},{\"domain\":\"v\",\"url\":\"https://viva-flkf.vvbrd.com/api/rest/v\"},{\"domain\":\"s\",\"url\":\"https://medi-flkf.intsvs.com/api/rest/s\"},{\"domain\":\"r\",\"url\":\"https://r.api.xiaoying.co/api/rest/r\"},{\"domain\":\"m\",\"url\":\"https://viva-flkf.vvbrd.com/api/rest/m\"},{\"domain\":\"p\",\"url\":\"https://viva-flkf.vvbrd.com/api/rest/p\"},{\"domain\":\"g\",\"url\":\"https://viva-flkf.vvbrd.com/api/rest/g\"},{\"domain\":\"search\",\"url\":\"https://viva-flkf.vvbrd.com/api/rest/search\"},{\"domain\":\"h\",\"url\":\"https://viva-meast-ak.api.xiaoying.co/api/rest/h\"},{\"domain\":\"ad\",\"url\":\"https://viva-flkf.vvbrd.com/api/rest/ad\"},{\"domain\":\"t\",\"url\":\"https://medi-flkf.intsvs.com/api/rest/t\"},{\"domain\":\"y\",\"url\":\"https://viva-flkf.vvbrd.com/api/rest/y\"},{\"domain\":\"d\",\"url\":\"https://medi-flkf.intsvs.com/api/rest/d\"},{\"domain\":\"rt\",\"url\":\"https://rt.uwx1.xyz/api/rest/rt\"},{\"domain\":\"push\",\"url\":\"https://medi-flkf.intsvs.com/api/rest/push\"},{\"domain\":\"crawer\",\"url\":\"https://medi-flkf.intsvs.com/api/rest/crawer\"},{\"domain\":\"medi\",\"url\":\"https://medi-flkf.intsvs.com\"},{\"domain\":\"sc\",\"url\":\"https://viva-flkf.vvbrd.com/api/rest/sc\"}],\"zone\":\"meast\",\"countrylist\":[{\"code\":\"SA\",\"sns\":23},{\"code\":\"MA\",\"sns\":23},{\"code\":\"DZ\",\"sns\":23},{\"code\":\"EG\",\"sns\":23},{\"code\":\"KW\",\"sns\":23},{\"code\":\"JO\",\"sns\":23},{\"code\":\"TN\",\"sns\":23},{\"code\":\"OM\",\"sns\":23},{\"code\":\"LB\",\"sns\":23},{\"code\":\"QA\",\"sns\":23},{\"code\":\"PS\",\"sns\":23},{\"code\":\"LY\",\"sns\":23},{\"code\":\"YE\",\"sns\":23},{\"code\":\"AE\",\"sns\":23},{\"code\":\"BH\",\"sns\":23},{\"code\":\"IQ\",\"sns\":23},{\"code\":\"SY\",\"sns\":23}]}]}" : "http://s-qa.api.xiaoying.co/api/rest/rt".equals(str) ? "{\"country\":\"CN\",\"zone\":\"hz\",\"groupId\":1,\"zones\":[{\"domainlist\":[{\"domain\":\"a\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/a\"},{\"domain\":\"u\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/u\"},{\"domain\":\"v\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/v\"},{\"domain\":\"s\",\"url\":\"https://s-qa.api.xiaoying.co/api/rest/s\"},{\"domain\":\"r\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/r\"},{\"domain\":\"m\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/m\"},{\"domain\":\"p\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/p\"},{\"domain\":\"g\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/g\"},{\"domain\":\"search\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/search\"},{\"domain\":\"h\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/h\"},{\"domain\":\"ad\",\"url\":\"https://s-qa.api.xiaoying.co/api/rest/ad\"},{\"domain\":\"t\",\"url\":\"https://t-qa.api.xiaoying.co/api/rest/t\"},{\"domain\":\"y\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/y\"},{\"domain\":\"d\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/d\"},{\"domain\":\"push\",\"url\":\"https://push-qa.api.xiaoying.co/api/rest/push\"},{\"domain\":\"live\",\"url\":\"https://viva-qa.api.xiaoying.co\"},{\"domain\":\"rt\",\"url\":\"https://s-qa.api.xiaoying.co/api/rest/rt\"},{\"domain\":\"parse\",\"url\":\"https://parse-qa.api.xiaoying.co/parse\"},{\"domain\":\"medi\",\"url\":\"https://medi-qa.rthdo.com\"},{\"domain\":\"vcm\",\"url\":\"https://vcm-app-qa.gltxy.xyz\"},{\"domain\":\"sc\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/sc\"}],\"zone\":\"hz\",\"countrylist\":[{\"code\":\"CN\",\"sns\":71}]},{\"domainlist\":[{\"domain\":\"a\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/a\"},{\"domain\":\"u\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/u\"},{\"domain\":\"v\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/v\"},{\"domain\":\"s\",\"url\":\"https://s-qa.api.xiaoying.co/api/rest/s\"},{\"domain\":\"r\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/r\"},{\"domain\":\"m\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/m\"},{\"domain\":\"p\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/p\"},{\"domain\":\"g\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/g\"},{\"domain\":\"search\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/search\"},{\"domain\":\"h\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/h\"},{\"domain\":\"ad\",\"url\":\"https://s-qa.api.xiaoying.co/api/rest/ad\"},{\"domain\":\"t\",\"url\":\"https://t-qa.api.xiaoying.co/api/rest/t\"},{\"domain\":\"y\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/y\"},{\"domain\":\"d\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/d\"},{\"domain\":\"push\",\"url\":\"https://push-qa.api.xiaoying.co/api/rest/push\"},{\"domain\":\"rt\",\"url\":\"https://s-qa.api.xiaoying.co/api/rest/rt\"},{\"domain\":\"pares\",\"url\":\"https://parse-qa.api.xiaoying.co/parse\"},{\"domain\":\"medi\",\"url\":\"https://medi-qa.rthdo.com\"},{\"domain\":\"vcm\",\"url\":\"https://vcm-app-qa.gltxy.xyz\"},{\"domain\":\"sc\",\"url\":\"https://viva-qa.vvbrd.com/api/rest/sc\"}],\"zone\":\"asia1\",\"countrylist\":[{\"code\":\"PH\",\"sns\":0},{\"code\":\"MY\",\"sns\":0},{\"code\":\"SG\",\"sns\":7},{\"code\":\"JP\",\"sns\":7},{\"code\":\"TW\",\"sns\":7},{\"code\":\"HK\",\"sns\":7},{\"code\":\"IN\",\"sns\":23}]},{\"domainlist\":[{\"domain\":\"a\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/a\"},{\"domain\":\"d\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/d\"},{\"domain\":\"u\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/u\"},{\"domain\":\"v\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/v\"},{\"domain\":\"s\",\"url\":\"https://s-qa.api.xiaoying.co/api/rest/s\"},{\"domain\":\"r\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/r\"},{\"domain\":\"m\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/m\"},{\"domain\":\"p\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/p\"},{\"domain\":\"g\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/g\"},{\"domain\":\"search\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/search\"},{\"domain\":\"h\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/h\"},{\"domain\":\"ad\",\"url\":\"https://s-qa.api.xiaoying.co/api/rest/ad\"},{\"domain\":\"t\",\"url\":\"https://t-qa.api.xiaoying.co/api/rest/t\"},{\"domain\":\"y\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/y\"},{\"domain\":\"push\",\"url\":\"https://push-qa.api.xiaoying.co/api/rest/push\"},{\"domain\":\"live\",\"url\":\"https://viva-qa.api.xiaoying.co\"},{\"domain\":\"rt\",\"url\":\"https://s-qa.api.xiaoying.co/api/rest/rt\"},{\"domain\":\"parse\",\"url\":\"https://parse-qa.api.xiaoying.co/parse\"},{\"domain\":\"medi\",\"url\":\"https://medi-qa.rthdo.com\"},{\"domain\":\"vcm\",\"url\":\"https://vcm-app-qa.gltxy.xyz\"},{\"domain\":\"sc\",\"url\":\"https://viva-qa.vvbrd.com/api/rest/sc\"}],\"zone\":\"us\",\"countrylist\":[{\"code\":\"BR\",\"sns\":7},{\"code\":\"US\",\"sns\":7}]},{\"domainlist\":[{\"domain\":\"a\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/a\"},{\"domain\":\"u\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/u\"},{\"domain\":\"v\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/v\"},{\"domain\":\"s\",\"url\":\"https://s-qa.api.xiaoying.co/api/rest/s\"},{\"domain\":\"r\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/r\"},{\"domain\":\"m\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/m\"},{\"domain\":\"p\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/p\"},{\"domain\":\"g\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/g\"},{\"domain\":\"search\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/search\"},{\"domain\":\"h\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/h\"},{\"domain\":\"ad\",\"url\":\"https://s-qa.api.xiaoying.co/api/rest/ad\"},{\"domain\":\"t\",\"url\":\"https://t-qa.api.xiaoying.co/api/rest/t\"},{\"domain\":\"y\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/y\"},{\"domain\":\"d\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/d\"},{\"domain\":\"rt\",\"url\":\"https://s-qa.api.xiaoying.co/api/rest/rt\"},{\"domain\":\"push\",\"url\":\"https://push-qa.api.xiaoying.co/api/rest/push\"},{\"domain\":\"parse\",\"url\":\"https://parse-qa.api.xiaoying.co/parse\"},{\"domain\":\"medi\",\"url\":\"https://medi-qa.rthdo.com\"},{\"domain\":\"vcm\",\"url\":\"https://vcm-app-qa.gltxy.xyz\"},{\"domain\":\"sc\",\"url\":\"https://viva-qa.vvbrd.com/api/rest/sc\"}],\"zone\":\"meast\",\"countrylist\":[{\"code\":\"SA\",\"sns\":23},{\"code\":\"MA\",\"sns\":7},{\"code\":\"DZ\",\"sns\":7},{\"code\":\"EG\",\"sns\":23},{\"code\":\"KW\",\"sns\":23},{\"code\":\"JO\",\"sns\":23},{\"code\":\"TN\",\"sns\":23},{\"code\":\"OM\",\"sns\":23},{\"code\":\"LB\",\"sns\":23},{\"code\":\"QA\",\"sns\":23},{\"code\":\"PS\",\"sns\":23},{\"code\":\"LY\",\"sns\":7},{\"code\":\"YE\",\"sns\":23},{\"code\":\"AE\",\"sns\":23},{\"code\":\"BH\",\"sns\":23},{\"code\":\"IQ\",\"sns\":23},{\"code\":\"SY\",\"sns\":23}]}]}" : "http://s-qa2.api.xiaoying.co/api/rest/rt".equals(str) ? "{\"country\":\"CN\",\"zone\":\"hz\",\"groupId\":1,\"zones\":[{\"domainlist\":[{\"domain\":\"a\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/a\"},{\"domain\":\"u\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/u\"},{\"domain\":\"v\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/v\"},{\"domain\":\"s\",\"url\":\"https://s-qa.api.xiaoying.co/api/rest/s\"},{\"domain\":\"r\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/r\"},{\"domain\":\"m\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/m\"},{\"domain\":\"p\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/p\"},{\"domain\":\"g\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/g\"},{\"domain\":\"search\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/search\"},{\"domain\":\"h\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/h\"},{\"domain\":\"ad\",\"url\":\"https://s-qa.api.xiaoying.co/api/rest/ad\"},{\"domain\":\"t\",\"url\":\"https://t-qa.api.xiaoying.co/api/rest/t\"},{\"domain\":\"y\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/y\"},{\"domain\":\"d\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/d\"},{\"domain\":\"push\",\"url\":\"https://push-qa.api.xiaoying.co/api/rest/push\"},{\"domain\":\"live\",\"url\":\"https://viva-qa.api.xiaoying.co\"},{\"domain\":\"rt\",\"url\":\"https://s-qa.api.xiaoying.co/api/rest/rt\"},{\"domain\":\"parse\",\"url\":\"https://parse-qa.api.xiaoying.co/parse\"},{\"domain\":\"medi\",\"url\":\"https://medi-qa.rthdo.com\"},{\"domain\":\"vcm\",\"url\":\"https://vcm-app-qa.gltxy.xyz\"},{\"domain\":\"sc\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/sc\"}],\"zone\":\"hz\",\"countrylist\":[{\"code\":\"CN\",\"sns\":71}]},{\"domainlist\":[{\"domain\":\"a\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/a\"},{\"domain\":\"u\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/u\"},{\"domain\":\"v\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/v\"},{\"domain\":\"s\",\"url\":\"https://s-qa.api.xiaoying.co/api/rest/s\"},{\"domain\":\"r\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/r\"},{\"domain\":\"m\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/m\"},{\"domain\":\"p\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/p\"},{\"domain\":\"g\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/g\"},{\"domain\":\"search\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/search\"},{\"domain\":\"h\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/h\"},{\"domain\":\"ad\",\"url\":\"https://s-qa.api.xiaoying.co/api/rest/ad\"},{\"domain\":\"t\",\"url\":\"https://t-qa.api.xiaoying.co/api/rest/t\"},{\"domain\":\"y\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/y\"},{\"domain\":\"d\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/d\"},{\"domain\":\"push\",\"url\":\"https://push-qa.api.xiaoying.co/api/rest/push\"},{\"domain\":\"rt\",\"url\":\"https://s-qa.api.xiaoying.co/api/rest/rt\"},{\"domain\":\"pares\",\"url\":\"https://parse-qa.api.xiaoying.co/parse\"},{\"domain\":\"medi\",\"url\":\"https://medi-qa.rthdo.com\"},{\"domain\":\"vcm\",\"url\":\"https://vcm-app-qa.gltxy.xyz\"},{\"domain\":\"sc\",\"url\":\"https://viva-qa.vvbrd.com/api/rest/sc\"}],\"zone\":\"asia1\",\"countrylist\":[{\"code\":\"PH\",\"sns\":0},{\"code\":\"MY\",\"sns\":0},{\"code\":\"SG\",\"sns\":7},{\"code\":\"JP\",\"sns\":7},{\"code\":\"TW\",\"sns\":7},{\"code\":\"HK\",\"sns\":7},{\"code\":\"IN\",\"sns\":23}]},{\"domainlist\":[{\"domain\":\"a\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/a\"},{\"domain\":\"d\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/d\"},{\"domain\":\"u\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/u\"},{\"domain\":\"v\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/v\"},{\"domain\":\"s\",\"url\":\"https://s-qa.api.xiaoying.co/api/rest/s\"},{\"domain\":\"r\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/r\"},{\"domain\":\"m\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/m\"},{\"domain\":\"p\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/p\"},{\"domain\":\"g\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/g\"},{\"domain\":\"search\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/search\"},{\"domain\":\"h\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/h\"},{\"domain\":\"ad\",\"url\":\"https://s-qa.api.xiaoying.co/api/rest/ad\"},{\"domain\":\"t\",\"url\":\"https://t-qa.api.xiaoying.co/api/rest/t\"},{\"domain\":\"y\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/y\"},{\"domain\":\"push\",\"url\":\"https://push-qa.api.xiaoying.co/api/rest/push\"},{\"domain\":\"live\",\"url\":\"https://viva-qa.api.xiaoying.co\"},{\"domain\":\"rt\",\"url\":\"https://s-qa.api.xiaoying.co/api/rest/rt\"},{\"domain\":\"parse\",\"url\":\"https://parse-qa.api.xiaoying.co/parse\"},{\"domain\":\"medi\",\"url\":\"https://medi-qa.rthdo.com\"},{\"domain\":\"vcm\",\"url\":\"https://vcm-app-qa.gltxy.xyz\"},{\"domain\":\"sc\",\"url\":\"https://viva-qa.vvbrd.com/api/rest/sc\"}],\"zone\":\"us\",\"countrylist\":[{\"code\":\"BR\",\"sns\":7},{\"code\":\"US\",\"sns\":7}]},{\"domainlist\":[{\"domain\":\"a\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/a\"},{\"domain\":\"u\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/u\"},{\"domain\":\"v\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/v\"},{\"domain\":\"s\",\"url\":\"https://s-qa.api.xiaoying.co/api/rest/s\"},{\"domain\":\"r\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/r\"},{\"domain\":\"m\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/m\"},{\"domain\":\"p\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/p\"},{\"domain\":\"g\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/g\"},{\"domain\":\"search\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/search\"},{\"domain\":\"h\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/h\"},{\"domain\":\"ad\",\"url\":\"https://s-qa.api.xiaoying.co/api/rest/ad\"},{\"domain\":\"t\",\"url\":\"https://t-qa.api.xiaoying.co/api/rest/t\"},{\"domain\":\"y\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/y\"},{\"domain\":\"d\",\"url\":\"https://viva-qa.api.xiaoying.co/api/rest/d\"},{\"domain\":\"rt\",\"url\":\"https://s-qa.api.xiaoying.co/api/rest/rt\"},{\"domain\":\"push\",\"url\":\"https://push-qa.api.xiaoying.co/api/rest/push\"},{\"domain\":\"parse\",\"url\":\"https://parse-qa.api.xiaoying.co/parse\"},{\"domain\":\"medi\",\"url\":\"https://medi-qa.rthdo.com\"},{\"domain\":\"vcm\",\"url\":\"https://vcm-app-qa.gltxy.xyz\"},{\"domain\":\"sc\",\"url\":\"https://viva-qa.vvbrd.com/api/rest/sc\"}],\"zone\":\"meast\",\"countrylist\":[{\"code\":\"SA\",\"sns\":23},{\"code\":\"MA\",\"sns\":7},{\"code\":\"DZ\",\"sns\":7},{\"code\":\"EG\",\"sns\":23},{\"code\":\"KW\",\"sns\":23},{\"code\":\"JO\",\"sns\":23},{\"code\":\"TN\",\"sns\":23},{\"code\":\"OM\",\"sns\":23},{\"code\":\"LB\",\"sns\":23},{\"code\":\"QA\",\"sns\":23},{\"code\":\"PS\",\"sns\":23},{\"code\":\"LY\",\"sns\":7},{\"code\":\"YE\",\"sns\":23},{\"code\":\"AE\",\"sns\":23},{\"code\":\"BH\",\"sns\":23},{\"code\":\"IQ\",\"sns\":23},{\"code\":\"SY\",\"sns\":23}]}]}" : "http://s-dev.api.xiaoying.co/api/rest/rt".equals(str) ? "{\"country\":\"CN\",\"zone\":\"hz\",\"zones\":[{\"domainlist\":[{\"domain\":\"a\",\"url\":\"http://viva-dev.api.xiaoying.co/api/rest/a\"},{\"domain\":\"u\",\"url\":\"http://viva-dev.api.xiaoying.co/api/rest/u\"},{\"domain\":\"v\",\"url\":\"http://viva-dev.api.xiaoying.co/api/rest/v\"},{\"domain\":\"s\",\"url\":\"http://s-dev.api.xiaoying.co/api/rest/s\"},{\"domain\":\"r\",\"url\":\"http://viva-dev.api.xiaoying.co/api/rest/r\"},{\"domain\":\"m\",\"url\":\"http://viva-dev.api.xiaoying.co/api/rest/m\"},{\"domain\":\"p\",\"url\":\"http://viva-dev.api.xiaoying.co/api/rest/p\"},{\"domain\":\"g\",\"url\":\"http://viva-dev.api.xiaoying.co/api/rest/g\"},{\"domain\":\"search\",\"url\":\"http://viva-dev.api.xiaoying.co/api/rest/search\"},{\"domain\":\"h\",\"url\":\"http://viva-dev.api.xiaoying.co/api/rest/h\"},{\"domain\":\"ad\",\"url\":\"http://s-dev.api.xiaoying.co/api/rest/ad\"},{\"domain\":\"t\",\"url\":\"http://t-dev.api.xiaoying.co/api/rest/t\"},{\"domain\":\"y\",\"url\":\"http://viva-dev.api.xiaoying.co/api/rest/y\"},{\"domain\":\"d\",\"url\":\"http://viva-dev.api.xiaoying.co/api/rest/d\"},{\"domain\":\"push\",\"url\":\"http://push-dev.api.xiaoying.co/api/rest/push\"},{\"domain\":\"live\",\"url\":\"http://vcm-live-dev.api.xiaoying.co\"},{\"domain\":\"rt\",\"url\":\"http://s-dev.api.xiaoying.co/api/rest/rt\"},{\"domain\":\"crawer\",\"url\":\"http://viva-dev.api.xiaoying.co/api/rest/crawer\"}],\"zone\":\"hz\",\"countrylist\":[{\"code\":\"CN\",\"sns\":33}]},{\"domainlist\":[{\"domain\":\"crawer\",\"url\":\"http://viva-asia1.api.xiaoying.co/api/rest/crawer\"},{\"domain\":\"crawer\",\"url\":\"http://viva-asia1.api.xiaoying.co/api/rest/crawer\"}],\"zone\":\"asia1\",\"countrylist\":[{\"code\":\"PH\",\"sns\":7},{\"code\":\"SG\",\"sns\":7},{\"code\":\"MY\",\"sns\":7}]},{\"domainlist\":[{\"domain\":\"crawer\",\"url\":\"http://viva-us.api.xiaoying.co/api/rest/crawer/\"},{\"domain\":\"crawer\",\"url\":\"http://viva-us.api.xiaoying.co/api/rest/crawer\"}],\"zone\":\"us\",\"countrylist\":[{\"code\":\"BR\",\"sns\":7}]},{\"domainlist\":[{\"domain\":\"crawer\",\"url\":\"http://viva-meast-ak.api.xiaoying.co/api/rest/crawer\"},{\"domain\":\"crawer\",\"url\":\"http://viva-meast-ak.api.xiaoying.co/api/rest/crawer\"}],\"zone\":\"meast\",\"countrylist\":[]}]}" : "{\"country\":\"US\",\"zone\":\"us\",\"groupId\":1,\"zones\":[{\"domainlist\":[{\"domain\":\"a\",\"url\":\"https://viva.v21xy.com/api/rest/a\"},{\"domain\":\"u\",\"url\":\"https://viva.v21xy.com/api/rest/u\"},{\"domain\":\"v\",\"url\":\"https://viva.api.xiaoying.co/api/rest/v\"},{\"domain\":\"s\",\"url\":\"https://medi.rthdo.com/api/rest/s\"},{\"domain\":\"r\",\"url\":\"https://r.api.xiaoying.co/api/rest/r\"},{\"domain\":\"m\",\"url\":\"https://viva.api.xiaoying.co/api/rest/m\"},{\"domain\":\"p\",\"url\":\"https://viva.api.xiaoying.co/api/rest/p\"},{\"domain\":\"g\",\"url\":\"https://viva.api.xiaoying.co/api/rest/g\"},{\"domain\":\"search\",\"url\":\"https://viva.api.xiaoying.co/api/rest/search\"},{\"domain\":\"h\",\"url\":\"https://viva.api.xiaoying.co/api/rest/h\"},{\"domain\":\"ad\",\"url\":\"https://viva.v21xy.com/api/rest/ad\"},{\"domain\":\"t\",\"url\":\"https://medi.rthdo.com/api/rest/t\"},{\"domain\":\"y\",\"url\":\"https://viva.api.xiaoying.co/api/rest/y\"},{\"domain\":\"d\",\"url\":\"https://medi.rthdo.com/api/rest/d\"},{\"domain\":\"push\",\"url\":\"https://medi.rthdo.com/api/rest/push\"},{\"domain\":\"live\",\"url\":\"https://lv-gift.v21xy.com\"},{\"domain\":\"rt\",\"url\":\"https://s.api.xiaoying.co/api/rest/rt\"},{\"domain\":\"medi\",\"url\":\"https://medi.rthdo.com\"},{\"domain\":\"vcm\",\"url\":\"https://vcm-app.gltxy.xyz\"},{\"domain\":\"sc\",\"url\":\"https://viva.api.xiaoying.co/api/rest/sc\"}],\"zone\":\"hz\",\"countrylist\":[{\"code\":\"CN\",\"sns\":71}]},{\"domainlist\":[{\"domain\":\"a\",\"url\":\"https://viva-asia1.vvbrd.com/api/rest/a\"},{\"domain\":\"u\",\"url\":\"https://viva-asia1.vvbrd.com/api/rest/u\"},{\"domain\":\"v\",\"url\":\"https://viva-asia1.vvbrd.com/api/rest/v\"},{\"domain\":\"s\",\"url\":\"https://medi-asia1.intsvs.com/api/rest/s\"},{\"domain\":\"r\",\"url\":\"https://viva-asia1-ak.api.xiaoying.co/api/rest/r\"},{\"domain\":\"m\",\"url\":\"https://viva-asia1.vvbrd.com/api/rest/m\"},{\"domain\":\"p\",\"url\":\"https://viva-asia1.vvbrd.com/api/rest/p\"},{\"domain\":\"g\",\"url\":\"https://viva-asia1.vvbrd.com/api/rest/g\"},{\"domain\":\"search\",\"url\":\"https://viva-asia1.vvbrd.com/api/rest/search\"},{\"domain\":\"h\",\"url\":\"https://viva.api.xiaoying.co/api/rest/h\"},{\"domain\":\"ad\",\"url\":\"https://viva-asia1.vvbrd.com/api/rest/ad\"},{\"domain\":\"t\",\"url\":\"https://medi-asia1.intsvs.com/api/rest/t\"},{\"domain\":\"y\",\"url\":\"https://viva-asia1.vvbrd.com/api/rest/y\"},{\"domain\":\"d\",\"url\":\"https://medi-asia1.intsvs.com/api/rest/d\"},{\"domain\":\"push\",\"url\":\"https://medi-asia1.intsvs.com/api/rest/push\"},{\"domain\":\"rt\",\"url\":\"https://rt.uwx1.xyz/api/rest/rt\"},{\"domain\":\"crawer\",\"url\":\"https://medi-asia1.intsvs.com/api/rest/crawer\"},{\"domain\":\"medi\",\"url\":\"https://medi-asia1.intsvs.com\"},{\"domain\":\"sc\",\"url\":\"https://viva-asia1.vvbrd.com/api/rest/sc\"}],\"zone\":\"asia1\",\"countrylist\":[{\"code\":\"PH\",\"sns\":0},{\"code\":\"MY\",\"sns\":0},{\"code\":\"SG\",\"sns\":7},{\"code\":\"JP\",\"sns\":3},{\"code\":\"TW\",\"sns\":3},{\"code\":\"HK\",\"sns\":7},{\"code\":\"IN\",\"sns\":23}]},{\"domainlist\":[{\"domain\":\"a\",\"url\":\"https://viva-us.vvbrd.com/api/rest/a\"},{\"domain\":\"d\",\"url\":\"https://medi-us.intsvs.com/api/rest/d\"},{\"domain\":\"u\",\"url\":\"https://viva-us.vvbrd.com/api/rest/u\"},{\"domain\":\"v\",\"url\":\"https://viva-us.vvbrd.com/api/rest/v\"},{\"domain\":\"s\",\"url\":\"https://medi-us.intsvs.com/api/rest/s\"},{\"domain\":\"r\",\"url\":\"https://viva-us-ak.api.xiaoying.co/api/rest/r\"},{\"domain\":\"m\",\"url\":\"https://viva-us.vvbrd.com/api/rest/m\"},{\"domain\":\"p\",\"url\":\"https://viva-us.vvbrd.com/api/rest/p\"},{\"domain\":\"g\",\"url\":\"https://viva-us.vvbrd.com/api/rest/g\"},{\"domain\":\"search\",\"url\":\"https://viva-us.vvbrd.com/api/rest/search\"},{\"domain\":\"h\",\"url\":\"https://viva.api.xiaoying.co/api/rest/h\"},{\"domain\":\"ad\",\"url\":\"https://viva-us.vvbrd.com/api/rest/ad\"},{\"domain\":\"t\",\"url\":\"https://medi-us.intsvs.com/api/rest/t\"},{\"domain\":\"y\",\"url\":\"https://viva-us.vvbrd.com/api/rest/y\"},{\"domain\":\"push\",\"url\":\"https://medi-us.intsvs.com/api/rest/push\"},{\"domain\":\"live\",\"url\":\"https://viva-us.api.xiaoying.co\"},{\"domain\":\"rt\",\"url\":\"https://rt.uwx1.xyz/api/rest/rt\"},{\"domain\":\"crawer\",\"url\":\"https://medi-us.intsvs.com/api/rest/crawer\"},{\"domain\":\"medi\",\"url\":\"https://medi-us.intsvs.com\"},{\"domain\":\"sc\",\"url\":\"https://viva-us.vvbrd.com/api/rest/sc\"}],\"zone\":\"us\",\"countrylist\":[{\"code\":\"BR\",\"sns\":3},{\"code\":\"US\",\"sns\":3}]},{\"domainlist\":[{\"domain\":\"a\",\"url\":\"https://viva-flkf.vvbrd.com/api/rest/a\"},{\"domain\":\"u\",\"url\":\"https://viva-flkf.vvbrd.com/api/rest/u\"},{\"domain\":\"v\",\"url\":\"https://viva-flkf.vvbrd.com/api/rest/v\"},{\"domain\":\"s\",\"url\":\"https://medi-flkf.intsvs.com/api/rest/s\"},{\"domain\":\"r\",\"url\":\"https://r.api.xiaoying.co/api/rest/r\"},{\"domain\":\"m\",\"url\":\"https://viva-flkf.vvbrd.com/api/rest/m\"},{\"domain\":\"p\",\"url\":\"https://viva-flkf.vvbrd.com/api/rest/p\"},{\"domain\":\"g\",\"url\":\"https://viva-flkf.vvbrd.com/api/rest/g\"},{\"domain\":\"search\",\"url\":\"https://viva-flkf.vvbrd.com/api/rest/search\"},{\"domain\":\"h\",\"url\":\"https://viva-meast-ak.api.xiaoying.co/api/rest/h\"},{\"domain\":\"ad\",\"url\":\"https://viva-flkf.vvbrd.com/api/rest/ad\"},{\"domain\":\"t\",\"url\":\"https://medi-flkf.intsvs.com/api/rest/t\"},{\"domain\":\"y\",\"url\":\"https://viva-flkf.vvbrd.com/api/rest/y\"},{\"domain\":\"d\",\"url\":\"https://medi-flkf.intsvs.com/api/rest/d\"},{\"domain\":\"rt\",\"url\":\"https://rt.uwx1.xyz/api/rest/rt\"},{\"domain\":\"push\",\"url\":\"https://medi-flkf.intsvs.com/api/rest/push\"},{\"domain\":\"crawer\",\"url\":\"https://medi-flkf.intsvs.com/api/rest/crawer\"},{\"domain\":\"medi\",\"url\":\"https://medi-flkf.intsvs.com\"},{\"domain\":\"sc\",\"url\":\"https://viva-flkf.vvbrd.com/api/rest/sc\"}],\"zone\":\"meast\",\"countrylist\":[{\"code\":\"SA\",\"sns\":23},{\"code\":\"MA\",\"sns\":23},{\"code\":\"DZ\",\"sns\":23},{\"code\":\"EG\",\"sns\":23},{\"code\":\"KW\",\"sns\":23},{\"code\":\"JO\",\"sns\":23},{\"code\":\"TN\",\"sns\":23},{\"code\":\"OM\",\"sns\":23},{\"code\":\"LB\",\"sns\":23},{\"code\":\"QA\",\"sns\":23},{\"code\":\"PS\",\"sns\":23},{\"code\":\"LY\",\"sns\":23},{\"code\":\"YE\",\"sns\":23},{\"code\":\"AE\",\"sns\":23},{\"code\":\"BH\",\"sns\":23},{\"code\":\"IQ\",\"sns\":23},{\"code\":\"SY\",\"sns\":23}]}]}";
    }

    /* renamed from: mj */
    private String m23586mj(String str) {
        if (str.endsWith("/")) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("/");
        return sb.toString();
    }

    /* renamed from: R */
    public void mo33232R(Context context, boolean z) {
        if ((!z ? C2575a.parseLong(m23576N(context, "App_Route_Cache_Timestamp", "0")) : 0) + 20000 < System.currentTimeMillis() && C4599k.m11735dN(context)) {
            mo33233a(context, aFh(), null);
        }
    }

    /* renamed from: a */
    public void mo33233a(final Context context, final String str, final RootApiResultListener rootApiResultListener) {
        C1820a.aVj().mo10058o(new Runnable() {
            public void run() {
                long currentTimeMillis = System.currentTimeMillis();
                String userId = UserServiceProxy.getUserId();
                String dz = C4580b.m11653dz(context);
                String dV = C5206b.m14212dV(context);
                String appSettingStr = AppPreferencesSetting.getInstance().getAppSettingStr("app_ip_key", "");
                String str = "";
                if (!TextUtils.isEmpty(appSettingStr)) {
                    C3624b.m8865GC().mo22950cU(appSettingStr);
                } else {
                    str = AppStateModel.getInstance().getSimCountryCode();
                }
                C3625c.m8880GI().mo22963cY(str);
                HashMap hashMap = new HashMap();
                if (!TextUtils.isEmpty(dV)) {
                    hashMap.put("c", dV);
                }
                if (!TextUtils.isEmpty(dz)) {
                    hashMap.put("e", dz);
                }
                if (!TextUtils.isEmpty(userId)) {
                    hashMap.put("f", userId);
                }
                if (!TextUtils.isEmpty(str)) {
                    hashMap.put("country", str);
                }
                StringBuilder sb = new StringBuilder();
                sb.append(">>>>>>> getConfigureFromServer run");
                sb.append(str);
                LogUtilsV2.m14228e(sb.toString());
                C8150d.this.m23579a(context, str, currentTimeMillis, hashMap, rootApiResultListener);
            }
        });
    }

    /* access modifiers changed from: 0000 */
    public String aFh() {
        if (TextUtils.isEmpty(VivaBaseApplication.m8749FZ().bfP)) {
            return "https://rt.api.xiaoying.co/api/rest/rt/";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(">>>>>>>>>>>>>>>> serverMode = ");
        sb.append(VivaBaseApplication.m8749FZ().bfP);
        LogUtilsV2.m14228e(sb.toString());
        return m23586mj(VivaBaseApplication.m8749FZ().bfP);
    }

    /* renamed from: gA */
    public JSONObject mo33235gA(Context context) {
        boolean z = !m23583gB(context);
        JSONObject jSONObject = null;
        String gC = !z ? m23584gC(context) : null;
        if (gC == null) {
            gC = aFi();
        }
        VivaBaseApplication.bfO = gC;
        if (TextUtils.isEmpty(gC)) {
            return null;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(gC);
            if (z) {
                try {
                    jSONObject2.put("country", AppStateModel.getInstance().getCountryCode());
                    jSONObject2.put("zone", AppStateModel.getInstance().getZoneCode());
                } catch (Throwable th) {
                    th = th;
                    jSONObject = jSONObject2;
                }
            }
            return jSONObject2;
        } catch (Throwable th2) {
            th = th2;
            th.printStackTrace();
            return jSONObject;
        }
    }
}
