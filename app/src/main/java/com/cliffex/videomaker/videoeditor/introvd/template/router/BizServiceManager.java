package com.introvd.template.router;

import android.text.TextUtils;
import com.aiii.android.arouter.facade.template.C1949c;
import com.aiii.android.arouter.p091c.C1919a;
import com.introvd.template.router.lifecycle.BaseApplicationLifeCycle;
import java.util.LinkedHashMap;

public class BizServiceManager {
    private static volatile BizServiceManager instance;
    private LinkedHashMap<String, C1949c> serviceCacheMap;

    private BizServiceManager() {
    }

    private C1949c generateService(String str, Class<? extends C1949c> cls) {
        return TextUtils.isEmpty(str) ? (C1949c) C1919a.m5529sc().mo10356i(cls) : (C1949c) C1919a.m5529sc().mo10355al(str).mo10412rX();
    }

    private <T extends C1949c> T getBizService(Class<T> cls) {
        return getBizService(null, cls);
    }

    private <T extends C1949c> T getBizService(String str, Class<T> cls) {
        if (cls == null) {
            return null;
        }
        if (BaseApplicationLifeCycle.getApplication() != null) {
            C1919a.m5528a(BaseApplicationLifeCycle.getApplication());
        }
        if (this.serviceCacheMap == null) {
            this.serviceCacheMap = new LinkedHashMap<>();
        }
        T t = (C1949c) this.serviceCacheMap.get(cls.getName());
        if (t != null && cls.isAssignableFrom(t.getClass())) {
            return t;
        }
        T generateService = generateService(str, cls);
        if (generateService == null || !cls.isAssignableFrom(generateService.getClass())) {
            return null;
        }
        this.serviceCacheMap.put(cls.getName(), generateService);
        return generateService;
    }

    public static BizServiceManager getInstance() {
        if (instance == null) {
            synchronized (BizServiceManager.class) {
                if (instance == null) {
                    instance = new BizServiceManager();
                }
            }
        }
        return instance;
    }

    public static <T extends C1949c> T getService(Class<T> cls) {
        return getInstance().getBizService(cls);
    }

    public static <T extends C1949c> T getService(String str, Class<T> cls) {
        return getInstance().getBizService(str, cls);
    }
}
