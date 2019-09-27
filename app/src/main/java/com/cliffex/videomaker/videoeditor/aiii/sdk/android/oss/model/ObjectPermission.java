package com.aiii.sdk.android.oss.model;

import com.introvd.template.router.setting.VivaSettingRouter.SettingLocalLocaleParams;
import p503cz.msebera.android.httpclient.client.cache.HeaderConstants;

public enum ObjectPermission {
    Private(HeaderConstants.PRIVATE),
    PublicRead("public-read"),
    PublicReadWrite("public-read-write"),
    Default(SettingLocalLocaleParams.LOCALE_DEFAULT_VALUE),
    Unknown("");
    
    private String permissionString;

    private ObjectPermission(String str) {
        this.permissionString = str;
    }

    public static ObjectPermission parsePermission(String str) {
        ObjectPermission[] objectPermissionArr;
        for (ObjectPermission objectPermission : new ObjectPermission[]{Private, PublicRead, PublicReadWrite, Default}) {
            if (objectPermission.permissionString.equals(str)) {
                return objectPermission;
            }
        }
        return Unknown;
    }

    public String toString() {
        return this.permissionString;
    }
}
