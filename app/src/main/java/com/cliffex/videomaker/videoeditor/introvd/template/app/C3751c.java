package com.introvd.template.app;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import com.introvd.template.C4681i;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.XiaoYingActivity;
import com.introvd.template.app.splash.SplashActivity;
import com.introvd.template.app.utils.C4400d;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.common.utils.DataRefreshValidateUtil;
import com.introvd.template.module.p326ad.p330d.C7602b;
import com.introvd.template.p153p.C3209a;

/* renamed from: com.introvd.template.app.c */
public class C3751c implements ActivityLifecycleCallbacks {
    private int bhU = 0;

    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (activity != null) {
            C4681i.bgr = activity.getClass().getSimpleName();
            StringBuilder sb = new StringBuilder();
            sb.append(C4681i.bgr);
            sb.append("=======onActivityCreated");
            LogUtilsV2.m14227d(sb.toString());
        }
        if (!(activity instanceof SplashActivity)) {
            XiaoYingActivity.bfV = true;
            DataRefreshValidateUtil.recordDataRefreshTime("splash_show_mode");
        }
        C3740b.m9101He().mo23115z(activity);
    }

    public void onActivityDestroyed(Activity activity) {
        C3740b.m9101He().mo23110A(activity);
    }

    public void onActivityPaused(Activity activity) {
        if (activity.isFinishing()) {
            C3740b.m9101He().mo23114br(false);
            C3740b.m9101He().mo23110A(activity);
        } else {
            C3740b.m9101He().mo23114br(true);
        }
        C3209a.aJZ().aKa();
        if (!(activity instanceof SplashActivity)) {
            C7602b.aAs().mo32485aE(activity);
        }
    }

    public void onActivityResumed(Activity activity) {
        if (activity != null) {
            C4681i.bgr = activity.getClass().getSimpleName();
        }
        C3740b.m9101He().mo23114br(false);
        C3209a.aJZ().aKb();
        boolean z = activity instanceof SplashActivity;
        if (!z) {
            C7602b.aAs().mo32484aD(activity);
        }
        if (!VivaBaseApplication.m8749FZ().isForeground && !z) {
            C4400d.m11110bT(false);
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
        if (activity != null) {
            C4681i.bgr = activity.getClass().getSimpleName();
        }
        int i = this.bhU;
        this.bhU = i + 1;
        if (i == 0) {
            LogUtilsV2.m14230i("switch to foreground...");
            VivaBaseApplication.m8749FZ().isForeground = true;
            UserBehaviorLog.isForeground = true;
        }
    }

    public void onActivityStopped(Activity activity) {
        int i = this.bhU - 1;
        this.bhU = i;
        if (i == 0) {
            LogUtilsV2.m14230i("switch to background...");
            VivaBaseApplication.m8749FZ().isForeground = false;
            UserBehaviorLog.isForeground = false;
        }
    }
}
