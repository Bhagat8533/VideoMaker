package com.introvd.template.p203b;

import android.app.Activity;
import android.view.Window;
import java.util.LinkedHashMap;
import java.util.Map;

/* renamed from: com.introvd.template.b.i */
public class C4597i {
    private static Map<Integer, Integer> bKZ = new LinkedHashMap();

    /* renamed from: Y */
    public static synchronized void m11727Y(Activity activity) {
        synchronized (C4597i.class) {
            if (activity != null) {
                Window window = activity.getWindow();
                if (window != null) {
                    try {
                        bKZ.remove(Integer.valueOf(activity.hashCode()));
                        window.clearFlags(128);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        return;
    }

    @Deprecated
    /* renamed from: a */
    public static synchronized void m11728a(boolean z, Activity activity) {
        synchronized (C4597i.class) {
            m11729b(z, activity);
        }
    }

    /* renamed from: b */
    public static synchronized void m11729b(boolean z, Activity activity) {
        synchronized (C4597i.class) {
            if (activity != null) {
                Window window = activity.getWindow();
                if (window != null) {
                    try {
                        int hashCode = activity.hashCode();
                        Integer num = (Integer) bKZ.get(Integer.valueOf(hashCode));
                        if (num == null) {
                            num = Integer.valueOf(0);
                        }
                        Integer valueOf = z ? Integer.valueOf(num.intValue() + 1) : Integer.valueOf(num.intValue() - 1);
                        if (valueOf.intValue() > 0) {
                            window.addFlags(128);
                            bKZ.put(Integer.valueOf(hashCode), valueOf);
                        } else {
                            window.clearFlags(128);
                            bKZ.remove(Integer.valueOf(hashCode));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        return;
    }
}
