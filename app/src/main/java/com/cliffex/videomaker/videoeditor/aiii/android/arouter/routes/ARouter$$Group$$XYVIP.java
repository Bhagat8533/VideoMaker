package com.aiii.android.arouter.routes;

import com.aiii.android.arouter.facade.model.RouteMeta;
import com.aiii.android.arouter.facade.p096c.C1945a;
import com.aiii.android.arouter.facade.template.C1951e;
import com.introvd.template.module.iap.business.VipRenewActivity;
import com.introvd.template.module.iap.business.exchange.VipExchangeActivity;
import com.introvd.template.module.iap.business.home.VipHomeNewActivity;
import com.introvd.template.router.AdRouter;
import com.introvd.template.router.AdRouter.VipHomeParams;
import java.util.Map;

public class ARouter$$Group$$XYVIP implements C1951e {
    public void loadInto(Map<String, RouteMeta> map) {
        map.put(AdRouter.VIP_EXCHANGE_URL, RouteMeta.build(C1945a.ACTIVITY, VipExchangeActivity.class, "/xyvip/vipexchange/entry", "xyvip", null, -1, Integer.MIN_VALUE));
        map.put(VipHomeParams.URL, RouteMeta.build(C1945a.ACTIVITY, VipHomeNewActivity.class, "/xyvip/viphomenewactivity/entry", "xyvip", null, -1, Integer.MIN_VALUE));
        map.put(AdRouter.VIP_RENEW_URL, RouteMeta.build(C1945a.ACTIVITY, VipRenewActivity.class, "/xyvip/viprenew/entry", "xyvip", null, -1, Integer.MIN_VALUE));
    }
}
