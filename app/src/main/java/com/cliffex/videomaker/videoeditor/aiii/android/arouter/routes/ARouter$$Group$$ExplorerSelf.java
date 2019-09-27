package com.aiii.android.arouter.routes;

import com.aiii.android.arouter.facade.model.RouteMeta;
import com.aiii.android.arouter.facade.p096c.C1945a;
import com.aiii.android.arouter.facade.template.C1951e;
import com.introvd.template.explorer.ExplorerAppLiftCycleImpl;
import com.introvd.template.router.explorer.ExplorerRouter;
import java.util.Map;

public class ARouter$$Group$$ExplorerSelf implements C1951e {
    public void loadInto(Map<String, RouteMeta> map) {
        map.put(ExplorerRouter.PROXY_APPLICATION, RouteMeta.build(C1945a.PROVIDER, ExplorerAppLiftCycleImpl.class, "/explorerself/applifecycle", "explorerself", null, -1, Integer.MIN_VALUE));
    }
}
