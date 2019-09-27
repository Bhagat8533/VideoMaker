package com.introvd.template.crash;

import com.aiii.android.arouter.facade.template.C1949c;

public interface ICrashFlavour extends C1949c {
    public static final String VIVA_ROUTER_CRASH = "/VivaBaseRouter/VivaRouterCrash";

    void log(String str);

    void logException(Throwable th);
}
