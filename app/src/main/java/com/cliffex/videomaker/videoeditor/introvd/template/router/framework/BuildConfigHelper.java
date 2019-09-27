package com.introvd.template.router.framework;

import java.lang.reflect.Field;

public class BuildConfigHelper {
    private static final String BUILD_CONFIG = "com.yourbase.BuildConfigHelper";

    private static Object getBuildConfigValue(String str) {
        try {
            Field declaredField = Class.forName(BUILD_CONFIG).getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.get(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
