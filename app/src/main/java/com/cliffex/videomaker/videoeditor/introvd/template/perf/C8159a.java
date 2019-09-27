package com.introvd.template.perf;

import android.app.Activity;
import android.app.Application;
import com.introvd.template.router.VivaRouter;
import com.introvd.template.router.performance.PerformanceServiceProxy;
import com.vivavideo.monitor.C9528a;

/* renamed from: com.introvd.template.perf.a */
public class C8159a {
    /* renamed from: aR */
    public static void m23592aR(Activity activity) {
        VivaRouter.getRouterBuilder("/VivaMonitor/Setting").mo10382H(activity);
    }

    /* renamed from: p */
    public static void m23593p(Application application) {
        C9528a.m27456a(application);
        PerformanceServiceProxy.initAopPerfManager();
        PerformanceServiceProxy.initTXMatrixManager(application);
    }
}
