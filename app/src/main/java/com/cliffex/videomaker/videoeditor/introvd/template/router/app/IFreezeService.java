package com.introvd.template.router.app;

import android.content.Context;
import com.aiii.android.arouter.facade.template.C1949c;

public interface IFreezeService extends C1949c {
    public static final int FREEZE_NOT = -1;
    public static final int FREEZE_TYPE_ACCOUNT = 105;
    public static final int FREEZE_TYPE_DEVICE = 203;
    public static final String SERVICE_NAME = "/IAppServiceRouter/IFreezeService";

    int getFreezeCode();

    void showFreezeDialog(Context context, String str, int i);
}
