package com.aiii.android.arouter.routes;

import com.aiii.android.arouter.facade.model.RouteMeta;
import com.aiii.android.arouter.facade.p096c.C1945a;
import com.aiii.android.arouter.facade.template.C1951e;
import com.introvd.template.module.iap.IapServiceImplForModules;
import com.introvd.template.module.iap.business.IapUserLifeCycleImpl;
import com.introvd.template.router.iap.IapRouter;
import java.util.Map;

public class ARouter$$Group$$mid_iap implements C1951e {
    public void loadInto(Map<String, RouteMeta> map) {
        map.put(IapRouter.MID_IAP_SERVICE, RouteMeta.build(C1945a.PROVIDER, IapServiceImplForModules.class, IapRouter.MID_IAP_SERVICE, "mid_iap", null, -1, Integer.MIN_VALUE));
        map.put(IapRouter.PROXY_USER_LIFECYCLE, RouteMeta.build(C1945a.PROVIDER, IapUserLifeCycleImpl.class, IapRouter.PROXY_USER_LIFECYCLE, "mid_iap", null, -1, Integer.MIN_VALUE));
    }
}
