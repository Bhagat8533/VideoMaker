package com.aiii.android.arouter.routes;

import com.aiii.android.arouter.facade.model.RouteMeta;
import com.aiii.android.arouter.facade.p096c.C1945a;
import com.aiii.android.arouter.facade.template.C1951e;
import com.introvd.template.app.service.IANRServiceImpl;
import com.introvd.template.app.service.IAppServiceImpl;
import com.introvd.template.app.service.IDeviceUserServiceImpl;
import com.introvd.template.app.service.IFreezeServiceImpl;
import com.introvd.template.router.app.IANRService;
import com.introvd.template.router.app.IAppService;
import com.introvd.template.router.app.IFreezeService;
import com.introvd.template.router.app.device.IDeviceUserService;
import java.util.Map;

public class ARouter$$Group$$IAppServiceRouter implements C1951e {
    public void loadInto(Map<String, RouteMeta> map) {
        map.put(IANRService.SERVICE_NAME, RouteMeta.build(C1945a.PROVIDER, IANRServiceImpl.class, "/iappservicerouter/anr", "iappservicerouter", null, -1, Integer.MIN_VALUE));
        map.put(IAppService.VIVA_ROUTER_APP_SERVICE, RouteMeta.build(C1945a.PROVIDER, IAppServiceImpl.class, "/iappservicerouter/appservicerouter", "iappservicerouter", null, -1, Integer.MIN_VALUE));
        map.put(IDeviceUserService.SERVICE_NAME, RouteMeta.build(C1945a.PROVIDER, IDeviceUserServiceImpl.class, "/iappservicerouter/ideviceuserservice", "iappservicerouter", null, -1, Integer.MIN_VALUE));
        map.put(IFreezeService.SERVICE_NAME, RouteMeta.build(C1945a.PROVIDER, IFreezeServiceImpl.class, "/iappservicerouter/ifreezeservice", "iappservicerouter", null, -1, Integer.MIN_VALUE));
    }
}
