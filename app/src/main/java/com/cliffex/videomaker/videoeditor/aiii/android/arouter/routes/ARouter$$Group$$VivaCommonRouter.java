package com.aiii.android.arouter.routes;

import com.aiii.android.arouter.facade.model.RouteMeta;
import com.aiii.android.arouter.facade.p096c.C1945a;
import com.aiii.android.arouter.facade.template.C1951e;
import com.introvd.template.app.CommonFuncRouterImp;
import com.introvd.template.router.common.ICommonFuncRouter;
import java.util.Map;

public class ARouter$$Group$$VivaCommonRouter implements C1951e {
    public void loadInto(Map<String, RouteMeta> map) {
        map.put(ICommonFuncRouter.VIVA_COMMON_ROUTER_FUNC, RouteMeta.build(C1945a.PROVIDER, CommonFuncRouterImp.class, "/vivacommonrouter/commonfuncrouter", "vivacommonrouter", null, -1, Integer.MIN_VALUE));
    }
}
