package com.introvd.template.router.lifecycle;

import android.app.Application;
import android.content.Context;
import com.aiii.android.arouter.facade.template.C1949c;

public abstract class BaseApplicationLifeCycle implements C1949c {
    public static Application application;

    public static Application getApplication() {
        return application;
    }

    public final void init(Context context) {
    }

    public void onCreate() {
    }

    public void onCreateFinished() {
    }

    public void onRouteConfigUpdated(boolean z) {
    }
}
