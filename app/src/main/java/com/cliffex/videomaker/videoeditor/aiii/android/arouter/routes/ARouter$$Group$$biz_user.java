package com.aiii.android.arouter.routes;

import com.aiii.android.arouter.facade.model.RouteMeta;
import com.aiii.android.arouter.facade.p096c.C1945a;
import com.aiii.android.arouter.facade.template.C1951e;
import com.introvd.template.biz.user.SnsAuthServiceImpl;
import com.introvd.template.router.user.UserRouter;
import java.util.Map;

public class ARouter$$Group$$biz_user implements C1951e {
    public void loadInto(Map<String, RouteMeta> map) {
        map.put(UserRouter.BIZ_SNS_AUTH_SERVICE, RouteMeta.build(C1945a.PROVIDER, SnsAuthServiceImpl.class, UserRouter.BIZ_SNS_AUTH_SERVICE, "biz_user", null, -1, Integer.MIN_VALUE));
    }
}
