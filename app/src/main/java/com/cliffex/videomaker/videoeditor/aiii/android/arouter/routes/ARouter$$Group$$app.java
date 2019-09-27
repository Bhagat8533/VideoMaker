package com.cliffex.videomaker.videoeditor.aiii.android.arouter.routes;


import com.aiii.android.arouter.facade.p096c.C1945a;
import com.aiii.android.arouter.facade.template.C1951e;
import com.cliffex.videomaker.videoeditor.aiii.android.arouter.facade.model.RouteMeta;
import com.introvd.template.app.AppApplicationLifeCycleImpl;
import com.introvd.template.app.AppListener;
import com.introvd.template.app.AppMainActivityLifeCycleImpl;
import com.introvd.template.app.AppTodoInterceptorImpl;
import com.introvd.template.app.banner.BannerServiceImpl;
import com.introvd.template.app.community.freeze.FreezeReasonPage;
import com.introvd.template.app.community.usergrade.UserGradePage;
import com.introvd.template.app.login.AppUserLifeCycleImpl;
import com.introvd.template.app.publish.ResultPageActivity;
import com.introvd.template.app.school.template.TemplateListAct;
import com.introvd.template.app.splash.IntentHomeActivity;
import com.introvd.template.app.youngermode.XYyoungerSettingActivity;
import com.introvd.template.router.AppRouter;
import com.introvd.template.router.AppRouter.ExportResultPageParams;
import com.introvd.template.router.AppRouter.IntentHomeParams;
import com.introvd.template.router.AppRouter.TemplateParams;
import com.introvd.template.router.AppRouter.UserGradePageParam;
import com.introvd.template.router.AppRouter.YoungerModeParams;
import com.introvd.template.router.VivaRouter.FreezeReasonPageParam;
import java.util.Map;
import p504io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import videoeditor.videomaker.slowmotions.starsleap.VivaProFragment;

public class ARouter$$Group$$app implements C1951e {
    public void loadInto(Map<String, RouteMeta> map) {
        map.put(AppRouter.APP_LISTENER, RouteMeta.build(C1945a.PROVIDER, AppListener.class, "/app/applistener", SettingsJsonConstants.APP_KEY, null, -1, Integer.MIN_VALUE));
        map.put(ExportResultPageParams.URL, RouteMeta.build(C1945a.ACTIVITY, ResultPageActivity.class, "/app/exportresultpage", SettingsJsonConstants.APP_KEY, null, -1, Integer.MIN_VALUE));
        map.put(IntentHomeParams.URL, RouteMeta.build(C1945a.ACTIVITY, IntentHomeActivity.class, "/app/intenthome", SettingsJsonConstants.APP_KEY, null, -1, Integer.MIN_VALUE));
        map.put(TemplateParams.URL, RouteMeta.build(C1945a.ACTIVITY, TemplateListAct.class, "/app/templatelistact", SettingsJsonConstants.APP_KEY, null, -1, Integer.MIN_VALUE));
        map.put(UserGradePageParam.URL, RouteMeta.build(C1945a.ACTIVITY, UserGradePage.class, "/app/usergradepage", SettingsJsonConstants.APP_KEY, null, -1, Integer.MIN_VALUE));
        map.put(YoungerModeParams.URL, RouteMeta.build(C1945a.ACTIVITY, XYyoungerSettingActivity.class, "/app/xyyoungersettingactivity", SettingsJsonConstants.APP_KEY, null, -1, Integer.MIN_VALUE));
        map.put(AppRouter.PROXY_APPLICATION, RouteMeta.build(C1945a.PROVIDER, AppApplicationLifeCycleImpl.class, AppRouter.PROXY_APPLICATION, SettingsJsonConstants.APP_KEY, null, -1, Integer.MIN_VALUE));
        map.put(AppRouter.BIZAPP_BANNER, RouteMeta.build(C1945a.PROVIDER, BannerServiceImpl.class, AppRouter.BIZAPP_BANNER, SettingsJsonConstants.APP_KEY, null, -1, Integer.MIN_VALUE));
        map.put(FreezeReasonPageParam.URL, RouteMeta.build(C1945a.ACTIVITY, FreezeReasonPage.class, FreezeReasonPageParam.URL, SettingsJsonConstants.APP_KEY, null, -1, Integer.MIN_VALUE));
        map.put(AppRouter.PROXY_MAIN_ACTIVITY, RouteMeta.build(C1945a.PROVIDER, AppMainActivityLifeCycleImpl.class, AppRouter.PROXY_MAIN_ACTIVITY, SettingsJsonConstants.APP_KEY, null, -1, Integer.MIN_VALUE));
        map.put(AppRouter.BIZ_APP_PRO_MAIN_FRAG, RouteMeta.build(C1945a.FRAGMENT, VivaProFragment.class, AppRouter.BIZ_APP_PRO_MAIN_FRAG, SettingsJsonConstants.APP_KEY, null, -1, Integer.MIN_VALUE));
        map.put(AppRouter.BIZAPP_TODO_INTERCEPTOR, RouteMeta.build(C1945a.PROVIDER, AppTodoInterceptorImpl.class, "/app/todointerceptor", SettingsJsonConstants.APP_KEY, null, -1, Integer.MIN_VALUE));
        map.put(AppRouter.PROXY_USER_LIFECYCLE, RouteMeta.build(C1945a.PROVIDER, AppUserLifeCycleImpl.class, AppRouter.PROXY_USER_LIFECYCLE, SettingsJsonConstants.APP_KEY, null, -1, Integer.MIN_VALUE));
    }
}
