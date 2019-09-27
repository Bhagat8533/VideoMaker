package com.introvd.template.apicore;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.introvd.template.apicore.c */
public class C3625c {
    private static volatile C3625c bhn;
    private Map<String, String> bho = new HashMap();
    private String bhp;

    private C3625c() {
    }

    /* renamed from: GI */
    public static C3625c m8880GI() {
        if (bhn == null) {
            synchronized (C3625c.class) {
                if (bhn == null) {
                    bhn = new C3625c();
                }
            }
        }
        return bhn;
    }

    /* renamed from: da */
    private static String m8881da(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.endsWith("/")) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("/");
            str = sb.toString();
        }
        return str;
    }

    /* renamed from: GJ */
    public String mo22956GJ() {
        return this.bhp;
    }

    /* renamed from: GK */
    public String mo22957GK() {
        return mo22964cZ("d");
    }

    /* renamed from: GL */
    public String mo22958GL() {
        return mo22964cZ("s");
    }

    /* renamed from: GM */
    public String mo22959GM() {
        return mo22964cZ("u");
    }

    /* renamed from: GN */
    public String mo22960GN() {
        return mo22964cZ("v");
    }

    /* renamed from: GO */
    public String mo22961GO() {
        return mo22964cZ("t");
    }

    /* renamed from: GP */
    public String mo22962GP() {
        return mo22964cZ("push");
    }

    /* renamed from: cY */
    public void mo22963cY(String str) {
        this.bhp = str;
    }

    /* renamed from: cZ */
    public String mo22964cZ(String str) {
        return this.bho.containsKey(str) ? m8881da((String) this.bho.get(str)) : "";
    }

    /* renamed from: n */
    public void mo22965n(Map<String, String> map) {
        this.bho = map;
    }
}
