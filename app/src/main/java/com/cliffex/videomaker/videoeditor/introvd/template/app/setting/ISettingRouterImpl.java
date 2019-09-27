package com.introvd.template.app.setting;

import android.content.Context;
import com.aiii.android.arouter.facade.p094a.C1942a;
import com.introvd.template.router.setting.ISettingRouter;
import com.introvd.template.router.setting.LocaleModel;

@C1942a(mo10417rZ = "/xysetting/ISettingRouter")
public class ISettingRouterImpl implements ISettingRouter {
    public LocaleModel getAppSettedLocaleModel(Context context) {
        return SettingLocaleConfigActivity.m10828cI(context);
    }

    public void init(Context context) {
    }
}
