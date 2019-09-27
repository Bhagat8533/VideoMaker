package com.aiii.android.arouter.routes;

import com.aiii.android.arouter.facade.model.RouteMeta;
import com.aiii.android.arouter.facade.p096c.C1945a;
import com.aiii.android.arouter.facade.template.C1951e;
import com.introvd.template.app.community.CommunityRouterImp;
import com.introvd.template.community.ICommunityFuncRouter;
import java.util.Map;

public class ARouter$$Group$$VivaRouter implements C1951e {
    public void loadInto(Map<String, RouteMeta> map) {
        map.put(ICommunityFuncRouter.VIVA_ROUTER_COMMUNITY_FUNC, RouteMeta.build(C1945a.PROVIDER, CommunityRouterImp.class, "/vivarouter/communityfuncrouter", "vivarouter", null, -1, Integer.MIN_VALUE));
    }
}
