package com.introvd.template.app;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.introvd.template.app.p180d.C3856a;
import com.introvd.template.app.p180d.C3857b;
import com.introvd.template.app.p180d.C3859c;
import com.introvd.template.app.splash.SplashActivity;
import com.introvd.template.common.behavior.UserBehaviorUtilsV5;
import com.introvd.template.crash.C5523b;
import com.introvd.template.editor.p252e.C5878a;
import com.introvd.template.explorer.extract.C7234b;
import com.introvd.template.module.iap.business.p356e.C7900d;
import com.introvd.template.module.iap.business.p356e.C7900d.C7903a;
import com.introvd.template.router.todoCode.TODOParamModel;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.introvd.template.app.m */
public final class C4037m {
    private static final String TAG = "m";
    public static String biD;
    /* access modifiers changed from: private */
    public static C3856a biE = new C3856a() {
        /* renamed from: a */
        public void mo23388a(Activity activity, boolean z) {
            if (activity != null) {
                C4037m.m10023a(activity, activity.getIntent(), z);
            }
        }

        /* renamed from: c */
        public void mo23389c(Activity activity, TODOParamModel tODOParamModel, boolean z) {
            C4037m.m10024a(activity, tODOParamModel, z);
            UserBehaviorUtilsV5.onEventDeeplinkAction(activity.getApplicationContext(), "facebook_action", tODOParamModel.mTODOCode);
        }
    };

    /* renamed from: Hw */
    public static void m10020Hw() {
        C7900d.m23029a((C7903a) null);
    }

    /* renamed from: a */
    private static String m10022a(TODOParamModel tODOParamModel) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(C5878a.TAG, tODOParamModel.mTODOCode);
            jSONObject.put(C7234b.TAG, tODOParamModel.mJsonParam);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: a */
    public static void m10023a(Activity activity, Intent intent, boolean z) {
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static void m10024a(Activity activity, TODOParamModel tODOParamModel, boolean z) {
        if (z) {
            try {
                C4027k.m9994a(activity, null, tODOParamModel);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            biD = m10022a(tODOParamModel);
        }
    }

    /* renamed from: a */
    public static void m10025a(SplashActivity splashActivity, Intent intent) {
        m10027a(splashActivity, true);
    }

    /* renamed from: a */
    public static void m10026a(SplashActivity splashActivity, Intent intent, boolean z) {
    }

    /* renamed from: a */
    public static void m10027a(SplashActivity splashActivity, boolean z) {
        C3859c.m9504a(splashActivity, z, new C3856a() {
            /* renamed from: a */
            public void mo23388a(Activity activity, boolean z) {
                C3857b.m9502a(activity, z, C4037m.biE);
            }

            /* renamed from: c */
            public void mo23389c(Activity activity, TODOParamModel tODOParamModel, boolean z) {
                C4037m.m10024a(activity, tODOParamModel, z);
                UserBehaviorUtilsV5.onEventDeeplinkAction(activity.getApplicationContext(), "firebase_action", tODOParamModel.mTODOCode);
            }
        });
    }

    /* renamed from: g */
    public static void m10029g(String str, String str2, String str3, String str4) {
        String str5 = "country";
        try {
            String language = Locale.getDefault().getLanguage();
            String str6 = "lang";
            String str7 = "duid";
            String str8 = "auid";
            String str9 = "gpu";
            if (!TextUtils.isEmpty(str3)) {
                String str10 = str3;
            }
        } catch (Exception e) {
            C5523b.logException(e);
        }
    }
}
