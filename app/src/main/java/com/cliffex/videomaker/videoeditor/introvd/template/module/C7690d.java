package com.introvd.template.module;

import com.introvd.template.module.iap.C8048e;
import com.introvd.template.module.p338b.C7687b;
import com.introvd.template.router.BizServiceManager;
import com.introvd.template.router.app.IAppService;

/* renamed from: com.introvd.template.module.d */
public class C7690d {
    /* renamed from: a */
    public static void m22600a(C7691e eVar) {
        C8048e.m23272a(eVar);
        ((IAppService) BizServiceManager.getService(IAppService.class)).registerAppConfigObserver(C7687b.aAW());
    }
}
