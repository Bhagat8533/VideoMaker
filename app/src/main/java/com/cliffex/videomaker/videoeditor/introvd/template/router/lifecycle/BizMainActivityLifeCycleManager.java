package com.introvd.template.router.lifecycle;

import android.support.p021v4.app.FragmentActivity;

public class BizMainActivityLifeCycleManager {
    public static void init(FragmentActivity fragmentActivity) {
        if (fragmentActivity != null) {
            for (BaseMainActivityLifeCycle baseMainActivityLifeCycle : LifeCycleConstant.getMainActivityObserveList()) {
                baseMainActivityLifeCycle.init(fragmentActivity);
                fragmentActivity.getLifecycle().mo152a(baseMainActivityLifeCycle);
            }
        }
    }
}
