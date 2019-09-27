package com.introvd.template.router.lifecycle;

import android.app.Application;
import android.util.Log;
import java.util.List;

public class BizAppLifeCycleManager {
    public static final String TAG = "ProxyApp";
    private List<BaseApplicationLifeCycle> applicationList = LifeCycleConstant.getApplicationObserveList();

    public BizAppLifeCycleManager(Application application) {
        BaseApplicationLifeCycle.application = application;
    }

    public void performOnCreate() {
        for (BaseApplicationLifeCycle baseApplicationLifeCycle : this.applicationList) {
            if (baseApplicationLifeCycle != null) {
                long currentTimeMillis = System.currentTimeMillis();
                baseApplicationLifeCycle.onCreate();
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                String str = TAG;
                StringBuilder sb = new StringBuilder();
                sb.append(baseApplicationLifeCycle.getClass().getSimpleName());
                sb.append(" onCreate cost = ");
                sb.append(currentTimeMillis2);
                sb.append("ms");
                Log.d(str, sb.toString());
            }
        }
    }

    public void performOnCreateFinished() {
        for (BaseApplicationLifeCycle baseApplicationLifeCycle : this.applicationList) {
            if (baseApplicationLifeCycle != null) {
                baseApplicationLifeCycle.onCreateFinished();
            }
        }
    }

    public void performOnRouteConfigUpdated(boolean z) {
        for (BaseApplicationLifeCycle baseApplicationLifeCycle : this.applicationList) {
            if (baseApplicationLifeCycle != null) {
                baseApplicationLifeCycle.onRouteConfigUpdated(z);
            }
        }
    }
}
