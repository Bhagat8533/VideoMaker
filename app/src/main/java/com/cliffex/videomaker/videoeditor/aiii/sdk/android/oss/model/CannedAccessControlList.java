package com.aiii.sdk.android.oss.model;

import com.introvd.template.router.setting.VivaSettingRouter.SettingLocalLocaleParams;
import p503cz.msebera.android.httpclient.client.cache.HeaderConstants;

public enum CannedAccessControlList {
    Private(HeaderConstants.PRIVATE),
    PublicRead("public-read"),
    PublicReadWrite("public-read-write"),
    Default(SettingLocalLocaleParams.LOCALE_DEFAULT_VALUE);
    
    private String ACLString;

    private CannedAccessControlList(String str) {
        this.ACLString = str;
    }

    public static CannedAccessControlList parseACL(String str) {
        CannedAccessControlList[] values;
        for (CannedAccessControlList cannedAccessControlList : values()) {
            if (cannedAccessControlList.toString().equals(str)) {
                return cannedAccessControlList;
            }
        }
        return null;
    }

    public String toString() {
        return this.ACLString;
    }
}
