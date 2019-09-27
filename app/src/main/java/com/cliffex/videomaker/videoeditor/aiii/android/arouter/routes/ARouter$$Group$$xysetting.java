package com.aiii.android.arouter.routes;

import com.aiii.android.arouter.facade.model.RouteMeta;
import com.aiii.android.arouter.facade.p096c.C1945a;
import com.aiii.android.arouter.facade.template.C1951e;
import com.introvd.template.app.setting.ISettingRouterImpl;
import com.introvd.template.app.setting.SettingActivityV6;
import com.introvd.template.app.setting.SettingLocaleConfigActivity;
import com.introvd.template.app.setting.locale.ChooseLanguageActivity;
import com.introvd.template.router.setting.ISettingRouter;
import com.introvd.template.router.setting.VivaSettingRouter.SettingLocalLocaleParams;
import com.introvd.template.router.setting.VivaSettingRouter.SettingLocaleParams;
import com.introvd.template.router.setting.VivaSettingRouter.SettingPrams;
import java.util.Map;

public class ARouter$$Group$$xysetting implements C1951e {
    public void loadInto(Map<String, RouteMeta> map) {
        map.put(ISettingRouter.URL, RouteMeta.build(C1945a.PROVIDER, ISettingRouterImpl.class, "/xysetting/isettingrouter", "xysetting", null, -1, Integer.MIN_VALUE));
        map.put(SettingLocaleParams.LOCALE_4CNT_INDIA_SETTING_URL, RouteMeta.build(C1945a.ACTIVITY, ChooseLanguageActivity.class, "/xysetting/indiacntlocaleset/entry", "xysetting", null, -1, Integer.MIN_VALUE));
        map.put(SettingLocalLocaleParams.LOCALE_LOCAL_SETTING_URL, RouteMeta.build(C1945a.ACTIVITY, SettingLocaleConfigActivity.class, "/xysetting/locallocaleset/entry", "xysetting", null, -1, Integer.MIN_VALUE));
        map.put(SettingPrams.URL, RouteMeta.build(C1945a.ACTIVITY, SettingActivityV6.class, "/xysetting/settingactivityv6/entry", "xysetting", null, -1, Integer.MIN_VALUE));
    }
}
