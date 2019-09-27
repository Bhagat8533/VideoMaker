package com.aiii.android.arouter.routes;

import com.aiii.android.arouter.facade.model.RouteMeta;
import com.aiii.android.arouter.facade.p096c.C1945a;
import com.aiii.android.arouter.facade.template.C1950d;
import com.introvd.template.app.AppListener;
import com.introvd.template.app.CommonFuncRouterImp;
import com.introvd.template.app.banner.BannerServiceImpl;
import com.introvd.template.app.community.CommunityRouterImp;
import com.introvd.template.app.crash.CrashFlavor;
import com.introvd.template.app.service.IANRServiceImpl;
import com.introvd.template.app.service.IAppServiceImpl;
import com.introvd.template.app.service.IDeviceUserServiceImpl;
import com.introvd.template.app.service.IFreezeServiceImpl;
import com.introvd.template.app.setting.ISettingRouterImpl;
import com.introvd.template.community.ICommunityFuncRouter;
import com.introvd.template.crash.ICrashFlavour;
import com.introvd.template.router.AppRouter;
import com.introvd.template.router.app.IANRService;
import com.introvd.template.router.app.IAppService;
import com.introvd.template.router.app.IFreezeService;
import com.introvd.template.router.app.device.IDeviceUserService;
import com.introvd.template.router.common.ICommonFuncRouter;
import com.introvd.template.router.setting.ISettingRouter;
import java.util.Map;
import p504io.fabric.sdk.android.services.settings.SettingsJsonConstants;

public class ARouter$$Providers$$vivabizapp implements C1950d {
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("com.introvd.template.AppMiscListener", RouteMeta.build(C1945a.PROVIDER, AppListener.class, AppRouter.APP_LISTENER, SettingsJsonConstants.APP_KEY, null, -1, Integer.MIN_VALUE));
        map.put("com.introvd.template.router.banner.IBannerService", RouteMeta.build(C1945a.PROVIDER, BannerServiceImpl.class, AppRouter.BIZAPP_BANNER, SettingsJsonConstants.APP_KEY, null, -1, Integer.MIN_VALUE));
        map.put("com.introvd.template.router.common.ICommonFuncRouter", RouteMeta.build(C1945a.PROVIDER, CommonFuncRouterImp.class, ICommonFuncRouter.VIVA_COMMON_ROUTER_FUNC, "VivaCommonRouter", null, -1, Integer.MIN_VALUE));
        map.put("com.introvd.template.community.ICommunityFuncRouter", RouteMeta.build(C1945a.PROVIDER, CommunityRouterImp.class, ICommunityFuncRouter.VIVA_ROUTER_COMMUNITY_FUNC, "VivaRouter", null, -1, Integer.MIN_VALUE));
        map.put("com.introvd.template.router.app.IANRService", RouteMeta.build(C1945a.PROVIDER, IANRServiceImpl.class, IANRService.SERVICE_NAME, "IAppServiceRouter", null, -1, Integer.MIN_VALUE));
        map.put("com.introvd.template.router.app.IAppService", RouteMeta.build(C1945a.PROVIDER, IAppServiceImpl.class, IAppService.VIVA_ROUTER_APP_SERVICE, "IAppServiceRouter", null, -1, Integer.MIN_VALUE));
        map.put("com.introvd.template.router.app.device.IDeviceUserService", RouteMeta.build(C1945a.PROVIDER, IDeviceUserServiceImpl.class, IDeviceUserService.SERVICE_NAME, "IAppServiceRouter", null, -1, Integer.MIN_VALUE));
        map.put("com.introvd.template.router.app.IFreezeService", RouteMeta.build(C1945a.PROVIDER, IFreezeServiceImpl.class, IFreezeService.SERVICE_NAME, "IAppServiceRouter", null, -1, Integer.MIN_VALUE));
        map.put("com.introvd.template.crash.ICrashFlavour", RouteMeta.build(C1945a.PROVIDER, CrashFlavor.class, ICrashFlavour.VIVA_ROUTER_CRASH, "VivaBaseRouter", null, -1, Integer.MIN_VALUE));
        map.put("com.introvd.template.router.setting.ISettingRouter", RouteMeta.build(C1945a.PROVIDER, ISettingRouterImpl.class, ISettingRouter.URL, "xysetting", null, -1, Integer.MIN_VALUE));
    }
}
