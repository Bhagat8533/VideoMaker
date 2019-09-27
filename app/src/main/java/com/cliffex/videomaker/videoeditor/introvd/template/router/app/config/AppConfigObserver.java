package com.introvd.template.router.app.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public abstract class AppConfigObserver {
    public static final int TYPE_CACHE = 1;
    public static final int TYPE_HTTP = 2;

    @Target({ElementType.FIELD, ElementType.PARAMETER})
    @Retention(RetentionPolicy.SOURCE)
    public @interface AppConfigType {
    }

    public void onChange(int i, String str) {
    }
}
