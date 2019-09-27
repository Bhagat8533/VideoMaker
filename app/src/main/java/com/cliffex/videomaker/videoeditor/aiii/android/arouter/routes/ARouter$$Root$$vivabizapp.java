package com.aiii.android.arouter.routes;

import com.aiii.android.arouter.facade.template.C1951e;
import com.aiii.android.arouter.facade.template.C1952f;
import java.util.Map;
import p504io.fabric.sdk.android.services.settings.SettingsJsonConstants;

public class ARouter$$Root$$vivabizapp implements C1952f {
    public void loadInto(Map<String, Class<? extends C1951e>> map) {
        map.put("IAppServiceRouter", ARouter$$Group$$IAppServiceRouter.class);
        map.put("VivaBaseRouter", ARouter$$Group$$VivaBaseRouter.class);
        map.put("VivaCommonRouter", ARouter$$Group$$VivaCommonRouter.class);
        map.put("VivaRouter", ARouter$$Group$$VivaRouter.class);
        map.put(SettingsJsonConstants.APP_KEY, ARouter$$Group$$app.class);
        map.put("appcore", ARouter$$Group$$appcore.class);
        map.put("xysetting", ARouter$$Group$$xysetting.class);
    }
}
