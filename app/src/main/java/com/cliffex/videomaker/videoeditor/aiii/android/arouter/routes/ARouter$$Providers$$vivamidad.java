package com.aiii.android.arouter.routes;

import com.aiii.android.arouter.facade.model.RouteMeta;
import com.aiii.android.arouter.facade.p096c.C1945a;
import com.aiii.android.arouter.facade.template.C1950d;
import com.introvd.template.module.p326ad.AdServiceImplForModules;
import com.introvd.template.router.p377ad.AdRouter;
import java.util.Map;

public class ARouter$$Providers$$vivamidad implements C1950d {
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("com.introvd.template.router.ad.IAdService", RouteMeta.build(C1945a.PROVIDER, AdServiceImplForModules.class, AdRouter.MID_AD_SERVICE, "mid_ad", null, -1, Integer.MIN_VALUE));
    }
}
