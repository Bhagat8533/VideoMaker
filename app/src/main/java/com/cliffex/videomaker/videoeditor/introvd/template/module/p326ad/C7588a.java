package com.introvd.template.module.p326ad;

/* renamed from: com.introvd.template.module.ad.a */
public class C7588a {
    /* renamed from: V */
    public static Integer m22357V(Object obj) {
        if (obj instanceof String) {
            try {
                return Integer.valueOf(((String) obj).trim());
            } catch (Exception e) {
                C7678j.aAd().logException(e);
                return null;
            }
        } else if (obj instanceof Integer) {
            return (Integer) obj;
        } else {
            return null;
        }
    }
}
