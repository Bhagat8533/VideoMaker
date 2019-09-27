package com.aiii.android.arouter.routes;

import com.aiii.android.arouter.facade.model.RouteMeta;
import com.aiii.android.arouter.facade.p096c.C1945a;
import com.aiii.android.arouter.facade.template.C1950d;
import com.introvd.template.module.iap.IapServiceImplForModules;
import com.introvd.template.router.iap.IapRouter;
import java.util.Map;

public class ARouter$$Providers$$vivamidiap implements C1950d {
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("com.introvd.template.router.iap.IIapService", RouteMeta.build(C1945a.PROVIDER, IapServiceImplForModules.class, IapRouter.MID_IAP_SERVICE, "mid_iap", null, -1, Integer.MIN_VALUE));
    }
}
