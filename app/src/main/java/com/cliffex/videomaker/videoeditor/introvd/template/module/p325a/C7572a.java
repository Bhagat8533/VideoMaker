package com.introvd.template.module.p325a;

import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.introvd.template.common.DeviceInfo;
import com.introvd.template.module.iap.C8048e;
import com.introvd.template.router.user.UserServiceProxy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import p037b.p050b.C1850u;
import p037b.p050b.p073g.C1810c;
import p469f.C9768m;

/* renamed from: com.introvd.template.module.a.a */
public class C7572a {
    private static final String TAG = "a";
    /* access modifiers changed from: private */
    public static Map<String, C7575a> dLZ = new HashMap();

    /* renamed from: com.introvd.template.module.a.a$a */
    private static class C7575a {
        /* access modifiers changed from: private */
        public boolean dMb = false;
        /* access modifiers changed from: private */
        public final String dMc;
        /* access modifiers changed from: private */
        public final String dMd;
        /* access modifiers changed from: private */
        public int flag = -1;

        C7575a(String str) {
            this.dMc = C7572a.m22338jU(str);
            this.dMd = C7572a.m22338jU(C7572a.m22340jW(str));
        }
    }

    /* renamed from: a */
    public static void m22333a(final View view, Object obj, String str) {
        if (view != null) {
            final String jV = m22339jV(str);
            if (m22337jT(jV)) {
                C7575a aVar = (C7575a) dLZ.get(jV);
                int hashCode = obj.hashCode();
                if (aVar == null || aVar.flag != hashCode) {
                    C7575a aVar2 = new C7575a(jV);
                    aVar2.flag = hashCode;
                    dLZ.put(jV, aVar2);
                    view.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
                        public boolean onPreDraw() {
                            view.getViewTreeObserver().removeOnPreDrawListener(this);
                            C7575a aVar = (C7575a) C7572a.dLZ.get(jV);
                            if (aVar == null || aVar.dMb) {
                                return true;
                            }
                            C7572a.m22334jQ(jV);
                            aVar.dMb = true;
                            return true;
                        }
                    });
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: jQ */
    public static void m22334jQ(String str) {
        C7575a aVar = (C7575a) dLZ.get(str);
        if (aVar != null && !TextUtils.isEmpty(aVar.dMd)) {
            m22336jS(aVar.dMd);
        }
    }

    /* renamed from: jR */
    public static String m22335jR(String str) {
        C7575a aVar = (C7575a) dLZ.get(str);
        return (aVar != null && !TextUtils.isEmpty(aVar.dMc)) ? aVar.dMc : str;
    }

    /* renamed from: jS */
    private static void m22336jS(String str) {
        C7577c.m22354kb(str).mo10188a((C1850u<? super T>) new C1810c<C9768m<Void>>() {
            /* renamed from: b */
            public void onSuccess(C9768m<Void> mVar) {
            }

            public void onError(Throwable th) {
            }
        });
    }

    /* renamed from: jT */
    private static boolean m22337jT(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return "app.appsflyer.com".equals(Uri.parse(str).getHost());
    }

    /* access modifiers changed from: private */
    /* renamed from: jU */
    public static String m22338jU(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String userId = UserServiceProxy.getUserId();
        if (!TextUtils.isEmpty(userId)) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("&clickid=");
            sb.append(userId);
            str = sb.toString();
        }
        String androidId = DeviceInfo.getAndroidId(C8048e.aBe().getContext());
        if (!TextUtils.isEmpty(androidId)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append("&android_id=");
            sb2.append(androidId);
            str = sb2.toString();
        }
        String phoneIMEI = DeviceInfo.getPhoneIMEI(C8048e.aBe().getContext());
        if (!TextUtils.isEmpty(phoneIMEI)) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str);
            sb3.append("&imei=");
            sb3.append(phoneIMEI);
            str = sb3.toString();
        }
        String Ml = C8048e.aBe().mo23620Ml();
        if (!TextUtils.isEmpty(Ml)) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(str);
            sb4.append("&advertising_id=");
            sb4.append(Ml);
            str = sb4.toString();
        }
        return str;
    }

    /* renamed from: jV */
    private static String m22339jV(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            str2 = jSONObject.optString("url");
            try {
                if (TextUtils.isEmpty(str2)) {
                    str2 = jSONObject.optString("fileurl");
                }
            } catch (Exception e) {
                e = e;
                e.printStackTrace();
                return str2;
            }
        } catch (Exception e2) {
            e = e2;
            str2 = null;
            e.printStackTrace();
            return str2;
        }
        return str2;
    }

    /* access modifiers changed from: private */
    /* renamed from: jW */
    public static String m22340jW(String str) {
        String jX = m22341jX(str);
        if (TextUtils.isEmpty(jX)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("http://=");
        sb.append(jX);
        sb.append("?pid=vivavideo_int");
        return sb.toString();
    }

    /* renamed from: jX */
    private static String m22341jX(String str) {
        String str2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        List pathSegments = Uri.parse(str).getPathSegments();
        if (pathSegments != null && !pathSegments.isEmpty()) {
            str2 = (String) pathSegments.get(0);
        }
        return str2;
    }
}
