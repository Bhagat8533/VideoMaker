package com.introvd.template.router.app.device;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class DeviceLoginObserver {
    public static final int TYPE_CACHE = 1;
    public static final int TYPE_HTTP_FORCE_LOGIN = 2;

    @Target({ElementType.FIELD, ElementType.PARAMETER})
    @Retention(RetentionPolicy.SOURCE)
    public @interface DeviceLoginType {
    }

    public void onChange(int i) {
    }
}
