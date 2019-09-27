package com.introvd.template.router.setting;

import android.content.Context;
import com.aiii.android.arouter.facade.template.C1949c;

public interface ISettingRouter extends C1949c {
    public static final String URL = "/xysetting/ISettingRouter";

    LocaleModel getAppSettedLocaleModel(Context context);
}
