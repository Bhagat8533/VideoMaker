package com.aiii.android.arouter.routes;

import com.aiii.android.arouter.facade.model.RouteMeta;
import com.aiii.android.arouter.facade.p096c.C1945a;
import com.aiii.android.arouter.facade.template.C1951e;
import com.introvd.template.router.lvl.GoogleLvLRouter;
import java.util.Map;
import videoeditor.videomaker.slowmotions.starsleap.lvl.GoogleLicenseServiceImpl;

public class ARouter$$Group$$pro_lvl implements C1951e {
    public void loadInto(Map<String, RouteMeta> map) {
        map.put(GoogleLvLRouter.PRO_LVL_SERVICE, RouteMeta.build(C1945a.PROVIDER, GoogleLicenseServiceImpl.class, GoogleLvLRouter.PRO_LVL_SERVICE, "pro_lvl", null, -1, Integer.MIN_VALUE));
    }
}
