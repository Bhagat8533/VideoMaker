package com.introvd.template.app.manager;

import android.content.Context;
import com.introvd.template.AppMiscListener;
import com.introvd.template.C4681i;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.app.ApplicationBase;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.DftRootApiResultListenerImpl;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.crash.C5523b;
import com.introvd.template.crash.C5526d;

/* renamed from: com.introvd.template.app.manager.e */
public class C4065e {
    /* renamed from: Ng */
    public static void m10112Ng() {
        boolean appSettingBoolean = AppPreferencesSetting.getInstance().getAppSettingBoolean("pref_root_config_key", false);
        Context applicationContext = VivaBaseApplication.m8749FZ().getApplicationContext();
        AppMiscListener Gr = C4681i.m12184Gp().mo25016Gr();
        if (Gr == null || applicationContext == null) {
            if (!appSettingBoolean) {
                C5523b.logException(new C5526d(" rootconfig firstrun state not work！"));
            }
            return;
        }
        AppPreferencesSetting.getInstance().setAppSettingBoolean("pref_root_config_key", true);
        ApplicationBase.biq = !appSettingBoolean;
        final Long valueOf = Long.valueOf(System.currentTimeMillis());
        Gr.onRouterClientConfigure(applicationContext, ApplicationBase.biq, null, null, new DftRootApiResultListenerImpl() {
            public void onError(Throwable th) {
                LogUtilsV2.m14227d("routeConfigListener onError");
            }

            public void onSuccess(Boolean bool, Object obj) {
                StringBuilder sb = new StringBuilder();
                sb.append("routeConfigListener onSuccess time consume:");
                sb.append(System.currentTimeMillis() - valueOf.longValue());
                LogUtilsV2.m14227d(sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("routeConfigListener onSuccess isEnterMainView:");
                sb2.append(ApplicationBase.bin);
                LogUtilsV2.m14227d(sb2.toString());
                ApplicationBase.bio = true;
                if (!ApplicationBase.bin) {
                    ApplicationBase.bip = bool.booleanValue();
                }
            }
        });
    }
}
