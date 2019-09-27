package com.introvd.template.router;

import android.app.Application;
import com.aiii.android.arouter.facade.C1941a;
import com.aiii.android.arouter.p091c.C1919a;

public class BaseRouter {
    public static final String SCHEMA = "xiaoying://";

    public static C1941a getRouterBuilder(Application application, String str) {
        if (application != null) {
            C1919a.m5528a(application);
        }
        return C1919a.m5529sc().mo10355al(str);
    }
}
