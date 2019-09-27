package com.introvd.template.apicore;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.introvd.template.apicore.a */
public class C3618a {
    private static Map<Class<?>, Object> bhe = new HashMap();

    /* renamed from: GB */
    public static synchronized void m8852GB() {
        synchronized (C3618a.class) {
            bhe.clear();
        }
    }

    /* renamed from: b */
    public static synchronized <T> T m8853b(Class<T> cls, String str) {
        T t;
        synchronized (C3618a.class) {
            if (bhe.get(cls) == null) {
                bhe.put(cls, C3646w.m8938de(str).mo37510S(cls));
            }
            t = bhe.get(cls);
        }
        return t;
    }
}
