package com.introvd.template.app.homepage;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.apicore.C3635l;
import com.introvd.template.app.api.C3727b;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.behavior.UserBehaviorUtilsV5;
import com.introvd.template.common.filecache.FileCache;
import com.introvd.template.common.filecache.FileCache.Builder;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.datacenter.SocialServiceDef;
import com.introvd.template.editor.p252e.C5878a;
import com.introvd.template.explorer.extract.C7234b;
import com.introvd.template.module.iap.business.p349a.p351b.C7830c;
import com.introvd.template.module.iap.business.p349a.p351b.C7831d;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.router.editor.EditorRouter;
import com.introvd.template.router.iap.IapServiceProxy;
import com.introvd.template.router.user.UserServiceProxy;
import com.ironsource.sdk.constants.Constants.ParametersKeys;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p037b.p050b.C1850u;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p057e.C1518f;
import p037b.p050b.p076j.C1820a;

/* renamed from: com.introvd.template.app.homepage.b */
public class C3935b {
    private static volatile C3935b bqB;
    private HashMap<String, List<AppModelConfigInfo>> bqC = new HashMap<>();
    private FileCache<JsonObject> bqD;

    /* renamed from: com.introvd.template.app.homepage.b$a */
    public interface C3941a {
        /* renamed from: bu */
        void mo23296bu(boolean z);
    }

    private C3935b() {
    }

    /* renamed from: Lb */
    public static C3935b m9679Lb() {
        if (bqB == null) {
            synchronized (C3935b.class) {
                if (bqB == null) {
                    bqB = new C3935b();
                }
            }
        }
        return bqB;
    }

    /* renamed from: a */
    private JsonElement m9680a(JsonObject jsonObject, String str) {
        if (jsonObject == null) {
            return null;
        }
        return jsonObject.get(str);
    }

    /* renamed from: a */
    private List<AppModelConfigInfo> m9682a(JsonArray jsonArray) {
        ArrayList arrayList = new ArrayList();
        if (jsonArray != null && jsonArray.size() > 0) {
            for (int i = 0; i < jsonArray.size(); i++) {
                AppModelConfigInfo appModelConfigInfo = (AppModelConfigInfo) new Gson().fromJson(jsonArray.get(i), AppModelConfigInfo.class);
                if (!TextUtils.isEmpty(appModelConfigInfo.extend) && !"None".equals(appModelConfigInfo.extend)) {
                    appModelConfigInfo.extendInfo = (C3928a) new Gson().fromJson(appModelConfigInfo.extend, C3928a.class);
                }
                arrayList.add(appModelConfigInfo);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public SparseArray<List<C7831d>> m9684b(JsonObject jsonObject) {
        JsonArray asJsonArray = jsonObject.getAsJsonArray(String.valueOf(310));
        if (asJsonArray == null) {
            return new SparseArray<>();
        }
        SparseArray<List<C7831d>> sparseArray = new SparseArray<>();
        for (int i = 0; i < asJsonArray.size(); i++) {
            JsonElement jsonElement = asJsonArray.get(i);
            if (jsonElement != null) {
                JsonObject asJsonObject = jsonElement.getAsJsonObject();
                JsonElement a = m9680a(asJsonObject, "title");
                String asString = a != null ? a.getAsString() : "";
                JsonElement a2 = m9680a(asJsonObject, "orderNo");
                int i2 = -1;
                int asInt = a2 != null ? a2.getAsInt() : -1;
                JsonElement a3 = m9680a(asJsonObject, "type");
                if (a3 != null) {
                    i2 = a3.getAsInt();
                }
                C7831d dVar = new C7831d(i2, asInt, asString);
                List list = (List) sparseArray.get(dVar.dSi);
                if (list == null) {
                    list = new ArrayList();
                    sparseArray.put(dVar.dSi, list);
                }
                list.add(dVar);
            }
        }
        return sparseArray;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public List<C7830c> m9686c(JsonObject jsonObject) {
        ArrayList arrayList = new ArrayList();
        if (jsonObject == null) {
            return arrayList;
        }
        JsonArray asJsonArray = jsonObject.getAsJsonArray(String.valueOf(320));
        if (asJsonArray == null) {
            return arrayList;
        }
        int i = 0;
        while (i < asJsonArray.size()) {
            try {
                JsonElement jsonElement = asJsonArray.get(i);
                if (jsonElement != null) {
                    JsonObject asJsonObject = jsonElement.getAsJsonObject();
                    JsonElement a = m9680a(asJsonObject, "title");
                    String asString = a != null ? a.getAsString() : "";
                    JsonElement a2 = m9680a(asJsonObject, "content");
                    String asString2 = a2 != null ? a2.getAsString() : "";
                    JsonElement a3 = m9680a(asJsonObject, "extend");
                    JsonObject jsonObject2 = (JsonObject) new Gson().fromJson(a3 != null ? a3.getAsString() : "", JsonObject.class);
                    String str = "";
                    if (jsonObject2 != null) {
                        JsonElement a4 = m9680a(jsonObject2, "disabledImg");
                        str = a4 != null ? a4.getAsString() : "";
                    }
                    JsonElement a5 = m9680a(asJsonObject, SocialConstDef.MESSAGE_LIST_NEW_EVENT_TYPE);
                    int asInt = a5 != null ? a5.getAsInt() : 0;
                    JsonElement a6 = m9680a(asJsonObject, SocialConstDef.MESSAGE_LIST_NEW_EVENT_CONTENT);
                    String asString3 = a6 != null ? a6.getAsString() : "";
                    C7830c cVar = new C7830c(asString2, str, asString);
                    cVar.todoCode = asInt;
                    cVar.dSh = asString3;
                    arrayList.add(cVar);
                }
                i++;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: ch */
    public FileCache<JsonObject> m9688ch(Context context) {
        if (this.bqD == null) {
            this.bqD = new Builder(context, JsonObject.class).setRelativeDir("config/appmodel").setCacheKey("AppModelConfig").build();
        }
        return this.bqD;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m9689d(JsonObject jsonObject) {
        String[] split;
        if (jsonObject != null) {
            for (String str : "114,115,113,117,116,119,121,118,106,2,230,124,380".split(EditorRouter.KEY_TOOL_LIST_ORDER_SPLIT_OP)) {
                JsonArray asJsonArray = jsonObject.getAsJsonArray(str);
                if (asJsonArray != null) {
                    List a = m9682a(asJsonArray);
                    if (!a.isEmpty()) {
                        this.bqC.put(str, a);
                    }
                }
            }
        }
    }

    /* renamed from: Lc */
    public List<AppModelConfigInfo> mo23473Lc() {
        return (List) this.bqC.get("114");
    }

    /* renamed from: Ld */
    public List<AppModelConfigInfo> mo23474Ld() {
        return (List) this.bqC.get("115");
    }

    /* renamed from: Le */
    public AppModelConfigInfo mo23475Le() {
        List list = (List) this.bqC.get("113");
        if (list == null || list.size() <= 0) {
            return null;
        }
        return (AppModelConfigInfo) list.get(0);
    }

    /* renamed from: Lf */
    public AppModelConfigInfo mo23476Lf() {
        List list = (List) this.bqC.get("117");
        if (list == null || list.size() <= 0) {
            return null;
        }
        return (AppModelConfigInfo) list.get(0);
    }

    /* renamed from: Lg */
    public AppModelConfigInfo mo23477Lg() {
        List list = (List) this.bqC.get("116");
        if (list == null || list.size() <= 0) {
            return null;
        }
        return (AppModelConfigInfo) list.get(0);
    }

    /* renamed from: Lh */
    public List<AppModelConfigInfo> mo23478Lh() {
        return (List) this.bqC.get("124");
    }

    /* renamed from: Li */
    public AppModelConfigInfo mo23479Li() {
        List list = (List) this.bqC.get("119");
        if (list == null || list.size() <= 0) {
            return null;
        }
        return (AppModelConfigInfo) list.get(0);
    }

    /* renamed from: Lj */
    public AppModelConfigInfo mo23480Lj() {
        List list = (List) this.bqC.get("106");
        if (list == null || list.size() <= 0) {
            return null;
        }
        return (AppModelConfigInfo) list.get(0);
    }

    /* renamed from: Lk */
    public void mo23481Lk() {
        if (!AppStateModel.getInstance().isInChina()) {
            C3727b.m9087y(mo23487f(350, null)).mo10196g(C1820a.aVi()).mo10194f(C1487a.aUa()).mo10188a((C1850u<? super T>) new C1850u<JsonObject>() {
                /* renamed from: a */
                public void mo9883a(C1495b bVar) {
                }

                /* renamed from: a */
                public void onSuccess(JsonObject jsonObject) {
                    IapServiceProxy.execute(IapServiceProxy.handleVipActivity, jsonObject);
                }

                public void onError(Throwable th) {
                    th.printStackTrace();
                }
            });
        }
    }

    /* renamed from: a */
    public void mo23482a(final Context context, final C3941a aVar) {
        HashMap hashMap = new HashMap();
        hashMap.put(C5878a.TAG, "0");
        hashMap.put(C7234b.TAG, C4580b.m11635Si());
        hashMap.put("c", AppStateModel.getInstance().getCountryCode());
        hashMap.put("d", "114,115,113,117,116,119,121,118,106,2,230,124,380");
        String dz = C4580b.m11653dz(context);
        if (!TextUtils.isEmpty(dz)) {
            hashMap.put("duid", dz);
        }
        String userId = UserServiceProxy.getUserId();
        if (!TextUtils.isEmpty(userId)) {
            hashMap.put("auid", userId);
        }
        C3727b.m9087y(hashMap).mo10196g(C1820a.aVi()).mo10194f(C1820a.aVi()).mo10199i(new C1518f<JsonObject, Boolean>() {
            /* renamed from: e */
            public Boolean apply(JsonObject jsonObject) {
                C3935b.this.m9688ch(context).saveCache(jsonObject);
                C3935b.this.m9689d(jsonObject);
                return Boolean.TRUE;
            }
        }).mo10194f(C1487a.aUa()).mo10188a((C1850u<? super T>) new C1850u<Boolean>() {
            /* renamed from: a */
            public void mo9883a(C1495b bVar) {
            }

            /* renamed from: e */
            public void onSuccess(Boolean bool) {
                if (aVar != null) {
                    aVar.mo23296bu(true);
                }
                UserBehaviorUtilsV5.onEventHomeRefreshOperation(context, "success");
            }

            public void onError(Throwable th) {
                if (aVar != null) {
                    aVar.mo23296bu(false);
                }
                UserBehaviorUtilsV5.onEventHomeRefreshOperation(context, ParametersKeys.FAILED);
            }
        });
    }

    /* renamed from: a */
    public void mo23483a(final C3635l<SparseArray<List<C7831d>>> lVar) {
        C3727b.m9087y(mo23487f(310, null)).mo10196g(C1820a.aVi()).mo10194f(C1487a.aUa()).mo10188a((C1850u<? super T>) new C1850u<JsonObject>() {
            /* renamed from: a */
            public void mo9883a(C1495b bVar) {
            }

            /* renamed from: a */
            public void onSuccess(JsonObject jsonObject) {
                if (lVar != null) {
                    lVar.onSuccess(C3935b.this.m9684b(jsonObject));
                }
            }

            public void onError(Throwable th) {
                lVar.onError(th.getMessage());
            }
        });
    }

    /* renamed from: b */
    public void mo23484b(final C3635l<List<C7830c>> lVar) {
        C3727b.m9087y(mo23487f(320, null)).mo10196g(C1820a.aVi()).mo10194f(C1487a.aUa()).mo10188a((C1850u<? super T>) new C1850u<JsonObject>() {
            /* renamed from: a */
            public void mo9883a(C1495b bVar) {
            }

            /* renamed from: a */
            public void onSuccess(JsonObject jsonObject) {
                if (jsonObject != null) {
                    AppPreferencesSetting.getInstance().setAppSettingStr(SocialServiceDef.PREF_KEY_VIP_PRIVILEGE_INFO, jsonObject.toString());
                }
                if (lVar != null) {
                    lVar.onSuccess(C3935b.this.m9686c(jsonObject));
                }
            }

            public void onError(Throwable th) {
                lVar.onError(th.getMessage());
            }
        });
    }

    /* renamed from: ci */
    public void mo23485ci(Context context) {
        m9688ch(context).clearCache();
    }

    /* renamed from: cj */
    public void mo23486cj(Context context) {
        m9689d((JsonObject) m9688ch(context).getCacheSync());
    }

    /* renamed from: f */
    public Map<String, String> mo23487f(int i, String str) {
        VivaBaseApplication FZ = VivaBaseApplication.m8749FZ();
        HashMap hashMap = new HashMap();
        hashMap.put(C5878a.TAG, "0");
        hashMap.put(C7234b.TAG, C4580b.m11635Si());
        hashMap.put("c", AppStateModel.getInstance().getCountryCode());
        hashMap.put("d", String.valueOf(i));
        String dz = C4580b.m11653dz(FZ);
        if (!TextUtils.isEmpty(dz)) {
            hashMap.put("duid", dz);
        }
        String userId = UserServiceProxy.getUserId();
        if (!TextUtils.isEmpty(userId)) {
            hashMap.put("auid", userId);
        }
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("extend", str);
        }
        return hashMap;
    }
}
