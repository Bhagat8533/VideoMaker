package com.introvd.template.router.iaphuawei;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import com.aiii.android.arouter.facade.template.C1949c;

public interface IHuaweiIAPService extends C1949c {
    Object getHuaWeiPayClient(String str);

    void handleResult(int i, int i2, Intent intent);

    void initHuaWeiSdk(Application application);

    void initHuaweiIAPListener(Activity activity);

    void unInit();
}
