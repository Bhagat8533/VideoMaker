package com.aiii.android.arouter.routes;

import com.aiii.android.arouter.facade.model.RouteMeta;
import com.aiii.android.arouter.facade.p096c.C1945a;
import com.aiii.android.arouter.facade.template.C1950d;
import com.introvd.template.router.lvl.GoogleLvLRouter;
import java.util.Map;
import videoeditor.videomaker.slowmotions.starsleap.lvl.GoogleLicenseServiceImpl;

public class ARouter$$Providers$$vivaapppro implements C1950d {
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("com.introvd.template.router.lvl.GoogleLicenseService", RouteMeta.build(C1945a.PROVIDER, GoogleLicenseServiceImpl.class, GoogleLvLRouter.PRO_LVL_SERVICE, "pro_lvl", null, -1, Integer.MIN_VALUE));
    }
}
