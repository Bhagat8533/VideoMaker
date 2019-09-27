package com.aiii.android.arouter.routes;

import com.aiii.android.arouter.facade.model.RouteMeta;
import com.aiii.android.arouter.facade.p096c.C1945a;
import com.aiii.android.arouter.facade.template.C1951e;
import com.introvd.template.mid.lbs.LbsServiceImpl;
import com.introvd.template.mid.lbs.google.GoogleGeocoderService;
import com.introvd.template.mid.lbs.google.GoogleLbsManager;
import com.introvd.template.router.lbs.LbsRouter;
import java.util.Map;

public class ARouter$$Group$$lbs implements C1951e {
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("/lbs/google_lbs_mgr", RouteMeta.build(C1945a.PROVIDER, GoogleLbsManager.class, "/lbs/google_lbs_mgr", "lbs", null, -1, Integer.MIN_VALUE));
        map.put("/lbs/google_place", RouteMeta.build(C1945a.PROVIDER, GoogleGeocoderService.class, "/lbs/google_place", "lbs", null, -1, Integer.MIN_VALUE));
        map.put(LbsRouter.ROUTER_SERVICE, RouteMeta.build(C1945a.PROVIDER, LbsServiceImpl.class, LbsRouter.ROUTER_SERVICE, "lbs", null, -1, Integer.MIN_VALUE));
    }
}
