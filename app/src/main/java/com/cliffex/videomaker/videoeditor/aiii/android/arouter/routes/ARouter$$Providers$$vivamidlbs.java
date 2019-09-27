package com.aiii.android.arouter.routes;

import com.aiii.android.arouter.facade.model.RouteMeta;
import com.aiii.android.arouter.facade.p096c.C1945a;
import com.aiii.android.arouter.facade.template.C1950d;
import com.introvd.template.mid.lbs.LbsServiceImpl;
import com.introvd.template.router.lbs.LbsRouter;
import java.util.Map;

public class ARouter$$Providers$$vivamidlbs implements C1950d {
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("com.introvd.template.router.lbs.ILbsService", RouteMeta.build(C1945a.PROVIDER, LbsServiceImpl.class, LbsRouter.ROUTER_SERVICE, "lbs", null, -1, Integer.MIN_VALUE));
    }
}
