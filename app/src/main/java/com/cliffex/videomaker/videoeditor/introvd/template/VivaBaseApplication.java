package com.introvd.template;

import android.app.Application;
import android.content.Context;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.p173a.p174a.C3571a;

public class VivaBaseApplication extends Application {
    private static VivaBaseApplication bfN = null;
    public static String bfO = "";
    private static volatile boolean bfQ;
    public String bfP = "";
    public boolean isForeground = false;

    /* renamed from: FZ */
    public static VivaBaseApplication m8749FZ() {
        return bfN;
    }

    /* renamed from: Ga */
    public void mo22828Ga() {
        bfQ = true;
    }

    /* renamed from: Gb */
    public boolean mo22829Gb() {
        return bfQ;
    }

    /* renamed from: Gc */
    public void mo22830Gc() {
        bfQ = false;
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        C4676f.init(context);
    }

    public void onCreate() {
        C3571a.m8785ex("BeforeSuperAppCreateInit");
        super.onCreate();
        bfN = this;
        if (C4676f.m12172FY()) {
            AppPreferencesSetting.getInstance().init(getApplicationContext());
            C4681i.m12184Gp().mo25020a(this);
        }
    }
}
