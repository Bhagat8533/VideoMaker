package com.introvd.template.apicore;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import com.introvd.template.p399t.C8611b;
import com.introvd.template.p399t.C8611b.C8613a;

/* renamed from: com.introvd.template.apicore.v */
public class C3644v {
    private static ActivityLifecycleCallbacks bhH = new ActivityLifecycleCallbacks() {
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
            C3638o.m8916GY().mo22983x(activity);
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }
    };

    /* renamed from: a */
    public static void m8927a(C3630h hVar) {
        C3627e.m8892GQ().mo22967a(hVar);
    }

    /* renamed from: a */
    public static void m8928a(C8613a aVar) {
        C8611b.m25144b(aVar);
    }

    /* renamed from: b */
    public static void m8929b(C3641s sVar) {
        C3642t.m8923GZ().mo22987a(sVar);
    }

    /* renamed from: k */
    public static void m8930k(Application application) {
        application.registerActivityLifecycleCallbacks(bhH);
    }
}
