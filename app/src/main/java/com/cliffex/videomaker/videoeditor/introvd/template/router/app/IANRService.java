package com.introvd.template.router.app;

import com.aiii.android.arouter.facade.template.C1949c;

public interface IANRService extends C1949c {
    public static final String SERVICE_NAME = "/IAppServiceRouter/ANR";

    public enum MethodType {
        Enter,
        Exit
    }

    void offerLifeCycleQueue(String str);

    void operate(String str, String str2, MethodType methodType);
}
