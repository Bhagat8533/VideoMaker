package com.introvd.template.app.push;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.introvd.template.R;
import com.introvd.template.app.notification.C4074c;
import com.introvd.template.app.notification.C4074c.C4080a;
import com.introvd.template.app.push.api.C4099b;
import com.introvd.template.app.push.api.model.CommonResponseResult;
import com.introvd.template.app.push.api.model.PushRegIDRequestParam;
import com.introvd.template.app.push.api.model.TagRequestParam;
import com.introvd.template.app.push.api.model.TagSystemParam;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.module.iap.C8045d;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.router.app.device.DeviceUserProxy;
import com.introvd.template.router.user.UserServiceProxy;
import com.quvideo.mobile.component.push.C4780a;
import com.quvideo.mobile.component.push.C4793c;
import com.quvideo.mobile.component.push.C4794d;
import com.quvideo.mobile.component.push.C4795e.C4797a;
import com.quvideo.mobile.component.push.C4795e.C4798b;
import com.quvideo.mobile.component.push.C4795e.C4799c;
import com.quvideo.mobile.component.push.C4800f;
import com.quvideo.mobile.component.push.C4805h;
import com.quvideo.mobile.component.push.C4806i;
import com.quvideo.mobile.component.push.C4814m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import p037b.p050b.C1842q;
import p037b.p050b.C1850u;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p076j.C1820a;

/* renamed from: com.introvd.template.app.push.b */
public class C4103b {
    public static volatile boolean bce;
    private static C4110c bvJ = new C4110c();
    /* access modifiers changed from: private */
    public static volatile boolean bvK = false;
    /* access modifiers changed from: private */
    public static volatile boolean bvL = false;

    /* renamed from: L */
    public static void m10181L(Activity activity) {
        if (!bce) {
            initPushClient(activity);
        }
        C4780a.m12326a(activity, new C4797a().mo25272Ew());
    }

    /* access modifiers changed from: private */
    /* renamed from: O */
    public static LinkedHashSet<String> m10183O(Context context, String str) {
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("Android");
        linkedHashSet.add(C4580b.m11644b(Locale.getDefault()));
        String countryCode = AppStateModel.getInstance().getCountryCode();
        String language = Locale.getDefault().getLanguage();
        if (!TextUtils.isEmpty(countryCode)) {
            linkedHashSet.add(countryCode);
            StringBuilder sb = new StringBuilder();
            sb.append(language);
            sb.append("_");
            sb.append(countryCode);
            linkedHashSet.add(sb.toString());
        }
        linkedHashSet.add(str);
        if (AppStateModel.getInstance().isCommunitySupport()) {
            linkedHashSet.add("COMMUNITY");
            if (!TextUtils.isEmpty(AppStateModel.getInstance().getGroupId())) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("COMMUNITY");
                sb2.append(AppStateModel.getInstance().getGroupId());
                linkedHashSet.add(sb2.toString());
            }
        } else {
            linkedHashSet.add("TOOL");
        }
        linkedHashSet.add("LIVESHOW");
        if (!TextUtils.isEmpty(str) && str.length() == 8) {
            String substring = str.substring(6);
            StringBuilder sb3 = new StringBuilder();
            sb3.append("CHANNEL_");
            sb3.append(substring);
            linkedHashSet.add(sb3.toString());
            linkedHashSet.add(str.substring(0, 6));
        }
        if (!AppStateModel.getInstance().isInChina()) {
            linkedHashSet.addAll(C8045d.aAZ().aBc());
        }
        return linkedHashSet;
    }

    /* renamed from: a */
    public static void m10185a(Context context, int i, String str, String str2, String str3, String str4, String str5) {
        C4080a aVar = new C4080a();
        aVar.bvf = str3;
        aVar.bvg = str4;
        aVar.bvc = str2;
        aVar.bvh = str5;
        C4074c.m10124a(context, i, str, aVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static void m10186a(final Context context, final String str, final String str2, boolean z) {
        if (!z) {
            m10190f(context, str, str2);
        } else {
            C4780a.m12331aY(context.getApplicationContext()).mo10157d(C1820a.aVj()).mo10152c(C1820a.aVj()).mo10149b((C1842q<? super T>) new C1842q<List<C4805h>>() {
                /* renamed from: R */
                public void mo9886K(List<C4805h> list) {
                    TagRequestParam tagRequestParam = new TagRequestParam();
                    tagRequestParam.land = C4580b.m11635Si();
                    if (list != null) {
                        for (C4805h hVar : list) {
                            if (hVar.bcC == 6) {
                                tagRequestParam.gcmId = hVar.registerId;
                            } else if (hVar.bcC == 1) {
                                tagRequestParam.jpushId = hVar.registerId;
                            } else if (hVar.bcC == 2) {
                                tagRequestParam.getuiId = hVar.registerId;
                            } else if (hVar.bcC == 4) {
                                tagRequestParam.mipushId = hVar.registerId;
                            }
                        }
                    }
                    tagRequestParam.produceId = AppStateModel.getInstance().getAppProductId();
                    TagSystemParam tagSystemParam = new TagSystemParam();
                    tagSystemParam.appkey = C4580b.m11651dx(context);
                    tagSystemParam.duiddigest = str;
                    tagSystemParam.auiddigest = str2;
                    tagSystemParam.method = "commontag";
                    C4099b.m10176a(tagRequestParam, tagSystemParam).mo10196g(C1820a.aVi()).mo10194f(C1820a.aVi()).mo10188a((C1850u<? super T>) new C1850u<CommonResponseResult<String>>() {
                        /* renamed from: a */
                        public void mo9883a(C1495b bVar) {
                        }

                        /* renamed from: a */
                        public void onSuccess(CommonResponseResult<String> commonResponseResult) {
                            ContentResolver contentResolver = context.getContentResolver();
                            Uri tableUri = SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_PUSH_TAG);
                            contentResolver.delete(tableUri, null, null);
                            try {
                                JsonObject jsonObject = (JsonObject) new Gson().fromJson((String) commonResponseResult.data, JsonObject.class);
                                String asString = jsonObject.get("dynamictag").getAsString();
                                String asString2 = jsonObject.get("staticcountrytag").getAsString();
                                ContentValues contentValues = new ContentValues();
                                contentValues.put(SocialConstDef.PUSH_TAG_DYNAMIC, asString);
                                contentValues.put(SocialConstDef.PUSH_TAG_STATIC, asString2);
                                contentResolver.insert(tableUri, contentValues);
                                StringBuilder sb = new StringBuilder();
                                sb.append("get dynamicTags : ");
                                sb.append(asString);
                                LogUtilsV2.m14230i(sb.toString());
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("get staticTags : ");
                                sb2.append(asString2);
                                LogUtilsV2.m14230i(sb2.toString());
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            C4103b.m10190f(context, str, str2);
                        }

                        public void onError(Throwable th) {
                            th.printStackTrace();
                        }
                    });
                }

                /* renamed from: a */
                public void mo9877a(C1495b bVar) {
                }

                public void onComplete() {
                }

                public void onError(Throwable th) {
                }
            });
        }
    }

    /* renamed from: cu */
    public static void m10188cu(Context context) {
        final Context applicationContext = context.getApplicationContext();
        final String dx = C4580b.m11651dx(context);
        final String dz = C4580b.m11653dz(context);
        if (TextUtils.isEmpty(dx) || TextUtils.isEmpty(dz)) {
            HashMap hashMap = new HashMap();
            hashMap.put("error", "no device");
            UserBehaviorLog.onKVEvent(context, "DEV_save_push_registerId_error", hashMap);
            return;
        }
        C4780a.m12331aY(applicationContext).mo10157d(C1820a.aVj()).mo10152c(C1820a.aVj()).mo10149b((C1842q<? super T>) new C1842q<List<C4805h>>() {
            /* renamed from: R */
            public void mo9886K(List<C4805h> list) {
                ArrayList arrayList = new ArrayList();
                if (list != null) {
                    for (C4805h hVar : list) {
                        PushRegIDRequestParam pushRegIDRequestParam = new PushRegIDRequestParam();
                        pushRegIDRequestParam.registerId = hVar.registerId;
                        if (!TextUtils.isEmpty(pushRegIDRequestParam.registerId)) {
                            if (hVar.bcC == 6) {
                                pushRegIDRequestParam.registerType = 2;
                                arrayList.add(pushRegIDRequestParam);
                            } else if (hVar.bcC == 1) {
                                pushRegIDRequestParam.registerType = 1;
                                arrayList.add(pushRegIDRequestParam);
                            } else if (hVar.bcC == 2) {
                                pushRegIDRequestParam.registerType = 4;
                                arrayList.add(pushRegIDRequestParam);
                            } else if (hVar.bcC == 7) {
                                pushRegIDRequestParam.registerType = 7;
                                arrayList.add(pushRegIDRequestParam);
                            }
                        }
                    }
                }
                if (arrayList.isEmpty()) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("error", "no reg id");
                    UserBehaviorLog.onKVEvent(applicationContext, "DEV_save_push_registerId_error", hashMap);
                    return;
                }
                C4099b.m10177a(arrayList, dx, dz, UserServiceProxy.getUserId()).mo10196g(C1820a.aVi()).mo10188a((C1850u<? super T>) new C1850u<JsonObject>() {
                    /* renamed from: a */
                    public void mo9883a(C1495b bVar) {
                    }

                    /* renamed from: a */
                    public void onSuccess(JsonObject jsonObject) {
                        LogUtilsV2.m14230i("saveRegisterIds success.");
                    }

                    public void onError(Throwable th) {
                        th.printStackTrace();
                    }
                });
            }

            /* renamed from: a */
            public void mo9877a(C1495b bVar) {
            }

            public void onComplete() {
            }

            public void onError(Throwable th) {
            }
        });
    }

    /* renamed from: e */
    private static C4814m m10189e(Context context, String str, String str2) {
        String str3 = str;
        C4814m mVar = new C4814m(AppStateModel.getInstance().getAppProductId(), str3, AppStateModel.getInstance().getCountryCode(), Locale.getDefault().getLanguage(), str2, m10183O(context, str));
        mVar.auid = UserServiceProxy.getUserId();
        return mVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public static void m10190f(Context context, String str, String str2) {
        Cursor query = context.getContentResolver().query(SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_PUSH_TAG), null, null, null, null);
        String str3 = "";
        String str4 = "";
        if (query != null) {
            if (query.moveToFirst()) {
                str3 = query.getString(query.getColumnIndex(SocialConstDef.PUSH_TAG_STATIC));
                str4 = query.getString(query.getColumnIndex(SocialConstDef.PUSH_TAG_DYNAMIC));
            }
            query.close();
        }
        String dx = C4580b.m11651dx(context);
        LinkedHashSet O = m10183O(context, dx);
        try {
            JSONArray jSONArray = new JSONArray(str3);
            for (int i = 0; i < jSONArray.length(); i++) {
                O.add(jSONArray.optString(i));
            }
            JSONArray jSONArray2 = new JSONArray(str4);
            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                O.add(jSONArray2.optString(i2));
            }
        } catch (Exception unused) {
            LogUtilsV2.m14228e("setServerPushTags ERROR");
        }
        bvK = true;
        C4780a.m12329a(context, dx, str, str2, O);
    }

    public static void initPushClient(Context context) {
        if (!bce) {
            final Context applicationContext = context.getApplicationContext();
            C4797a aVar = new C4797a();
            C4798b bVar = new C4798b(R.mipmap.ic_launcher, R.layout.customer_notitfication_layout, R.id.icon, R.id.title, R.id.text);
            C4780a.m12327a(applicationContext, aVar.mo25275a(bVar).mo25276a(new C4799c(21, 0, 8, 30)).mo25273a((C4793c) bvJ).mo25278a((C4806i) new C4806i() {
                /* renamed from: fL */
                public void mo23785fL(int i) {
                    if (i == 7 || C4103b.bvL || C4103b.bvK) {
                        String duid = DeviceUserProxy.getDuid();
                        if (!TextUtils.isEmpty(duid)) {
                            String userId = UserServiceProxy.getUserId();
                            String dx = C4580b.m11651dx(applicationContext);
                            if (!C4103b.bvK) {
                                C4780a.m12329a(applicationContext, dx, duid, userId, C4103b.m10183O(applicationContext, dx));
                            }
                            C4103b.m10186a(applicationContext, duid, userId, true);
                        }
                    }
                }
            }).mo25274a((C4794d) new C4794d() {
                /* renamed from: a */
                public void mo23784a(String str, HashMap hashMap) {
                    UserBehaviorLog.onKVEvent(applicationContext, str, hashMap);
                }
            }).mo25277a((C4800f) new C4112d(bvJ)).mo25272Ew());
            bce = true;
        }
    }

    public static void setPushTag(Context context, boolean z) {
        try {
            String duid = DeviceUserProxy.getDuid();
            if (!TextUtils.isEmpty(duid)) {
                String dx = C4580b.m11651dx(context);
                C4780a.m12328a(context, m10189e(context, dx, duid));
                C4780a.m12329a(context, dx, duid, UserServiceProxy.getUserId(), m10183O(context, dx));
                m10186a(context, duid, UserServiceProxy.getUserId(), z);
                bvL = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
