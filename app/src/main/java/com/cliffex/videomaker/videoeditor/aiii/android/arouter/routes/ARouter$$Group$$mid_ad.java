package com.aiii.android.arouter.routes;

import com.aiii.android.arouter.facade.model.RouteMeta;
import com.aiii.android.arouter.facade.p096c.C1945a;
import com.aiii.android.arouter.facade.template.C1951e;
import com.introvd.template.module.p326ad.AdServiceImplForModules;
import com.introvd.template.router.p377ad.AdRouter;
import java.util.Map;

public class ARouter$$Group$$mid_ad implements C1951e {
    public void loadInto(Map<String, RouteMeta> map) {
        map.put(AdRouter.MID_AD_SERVICE, RouteMeta.build(C1945a.PROVIDER, AdServiceImplForModules.class, AdRouter.MID_AD_SERVICE, "mid_ad", null, -1, Integer.MIN_VALUE));
    }
}
