package com.introvd.template.wxapi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.introvd.template.XiaoYingActivity;
import com.introvd.template.app.C3740b;
import com.introvd.template.app.C4027k;
import com.introvd.template.app.manager.C4041a;
import com.introvd.template.app.splash.SplashActivity;
import com.introvd.template.common.ActivityStateCheckListener;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.MagicCode;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.crash.C5526d;
import com.introvd.template.origin.device.api.C8124b;
import com.introvd.template.origin.device.api.RegisterDeviceResult;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p203b.C4585f;
import com.introvd.template.router.BizServiceManager;
import com.introvd.template.router.app.device.DeviceUserProxy;
import com.introvd.template.router.user.IAccountAPI;
import com.introvd.template.router.user.UserServiceProxy;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import p037b.p050b.C1834l;
import p037b.p050b.C1840o;
import p037b.p050b.C1842q;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p057e.C1518f;
import p037b.p050b.p076j.C1820a;

/* renamed from: com.introvd.template.wxapi.a */
public class C9083a {
    private static boolean eBA;

    /* renamed from: a */
    public static void m26520a(final Context context, Bundle bundle) {
        if (bundle != null) {
            final String string = bundle.getString("bundle_key_open_id");
            if (!TextUtils.isEmpty(string)) {
                C1834l.m5257ah(Boolean.valueOf(true)).mo10157d(C1820a.aVi()).mo10152c(C1820a.aVi()).mo10162e((C1518f<? super T, ? extends C1840o<? extends R>>) new C1518f<Boolean, C1840o<String>>() {
                    /* renamed from: h */
                    public C1840o<String> apply(Boolean bool) {
                        String dz = C4580b.m11653dz(context);
                        return !TextUtils.isEmpty(dz) ? C1834l.m5257ah(dz) : C8124b.m23525aH(C4585f.m11690dI(context.getApplicationContext()), C4585f.m11688dG(context.getApplicationContext())).mo10167f((C1518f<? super T, ? extends R>) new C1518f<RegisterDeviceResult, String>() {
                            /* renamed from: c */
                            public String apply(RegisterDeviceResult registerDeviceResult) {
                                try {
                                    String userId = UserServiceProxy.getUserId();
                                    long duidLong = DeviceUserProxy.getDuidLong();
                                    if (duidLong > 0) {
                                        UserBehaviorLog.updateAccount(userId, duidLong);
                                        C4041a.m10039MV();
                                        StringBuilder sb = new StringBuilder();
                                        sb.append("updateAccount userId=");
                                        sb.append(userId);
                                        sb.append(",duidLong=");
                                        sb.append(duidLong);
                                        LogUtilsV2.m14227d(sb.toString());
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                return registerDeviceResult.duid;
                            }
                        });
                    }
                }).mo10162e((C1518f<? super T, ? extends C1840o<? extends R>>) new C1518f<String, C1840o<JsonObject>>() {
                    /* renamed from: iM */
                    public C1840o<JsonObject> apply(String str) throws Exception {
                        IAccountAPI iAccountAPI = (IAccountAPI) BizServiceManager.getService(IAccountAPI.class);
                        if (iAccountAPI != null) {
                            return iAccountAPI.bindOpenID(UserServiceProxy.getUserId(), str, string);
                        }
                        throw new C5526d("No IAccountAPI Service");
                    }
                }).mo10149b((C1842q<? super T>) new C1842q<JsonObject>() {
                    /* renamed from: a */
                    public void mo9877a(C1495b bVar) {
                    }

                    /* renamed from: j */
                    public void mo9886K(JsonObject jsonObject) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("bindOpenID done : ");
                        sb.append(new Gson().toJson((JsonElement) jsonObject));
                        LogUtilsV2.m14230i(sb.toString());
                    }

                    public void onComplete() {
                    }

                    public void onError(Throwable th) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("bindOpenID error : ");
                        sb.append(th.getMessage());
                        LogUtilsV2.m14230i(sb.toString());
                    }
                });
            }
        }
    }

    /* renamed from: cP */
    public static void m26521cP(Context context, String str) {
        if (eBA) {
            eBA = false;
            HashMap hashMap = new HashMap();
            hashMap.put("FirstPage", str);
            UserBehaviorLog.onKVEvent(context, "Open_From_MiniProgram", hashMap);
        }
    }

    /* renamed from: i */
    public static void m26522i(Activity activity, String str) {
        Object magicParam = MagicCode.getMagicParam(0, "XiaoYingActivityWeakRef", null);
        if (magicParam != null) {
            try {
                if (C3740b.m9101He().mo23113Hi()) {
                    activity.startActivity(activity.getPackageManager().getLaunchIntentForPackage(activity.getPackageName()));
                }
                Activity activity2 = (Activity) ((WeakReference) magicParam).get();
                if (activity2 != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("execute notification : ");
                    sb.append(activity2);
                    LogUtilsV2.m14230i(sb.toString());
                    WeakReference Hf = C3740b.m9101He().mo23111Hf();
                    if (Hf != null) {
                        Activity activity3 = (Activity) Hf.get();
                        if (activity3 != null) {
                            if ((!(activity3 instanceof ActivityStateCheckListener) || ((ActivityStateCheckListener) activity3).isResponseTodoProcess()) && !activity3.getClass().getName().contains("com.vivavideo.mobile.liveplayer")) {
                                m26524r(new Intent());
                            } else {
                                return;
                            }
                        }
                    }
                    Bundle bundle = new Bundle();
                    bundle.putString("bundle_key_open_id", str);
                    m26520a(activity, bundle);
                } else {
                    m26523j(activity, str);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        } else {
            m26523j(activity, str);
        }
    }

    /* renamed from: j */
    private static void m26523j(Activity activity, String str) {
        Intent intent = new Intent(activity, SplashActivity.class);
        intent.setFlags(805306368);
        intent.setAction("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        Bundle bundle = new Bundle();
        bundle.putString("bundle_key_open_id", str);
        intent.putExtra("extras_weixin_request_params", bundle);
        activity.startActivity(intent);
        eBA = true;
    }

    /* renamed from: r */
    private static void m26524r(Intent intent) {
        List Hh = C3740b.m9101He().mo23112Hh();
        Activity activity = null;
        boolean z = false;
        for (int i = 0; i < Hh.size(); i++) {
            WeakReference weakReference = (WeakReference) Hh.get(i);
            if (weakReference != null) {
                Activity activity2 = (Activity) weakReference.get();
                if (activity2 != null) {
                    if (activity2 instanceof XiaoYingActivity) {
                        activity = activity2;
                    } else {
                        activity2.finish();
                    }
                    if (activity != null && !z) {
                        C4027k.m9994a(activity, intent.getExtras(), C4027k.m9995dj(intent.getStringExtra("event")));
                        z = true;
                    }
                }
            }
        }
    }
}
