package com.introvd.template.p173a;

import com.introvd.template.VivaBaseApplication;
import com.introvd.template.p374q.C8345d;

/* renamed from: com.introvd.template.a.a */
public class C3570a {
    private static int bKo;

    /* renamed from: RU */
    public static synchronized boolean m8779RU() {
        boolean z;
        synchronized (C3570a.class) {
            z = (m8780RV() & 7) == 7;
        }
        return z;
    }

    /* renamed from: RV */
    public static synchronized int m8780RV() {
        int gP;
        synchronized (C3570a.class) {
            gP = C8345d.m24068gP(VivaBaseApplication.m8749FZ()) | bKo;
        }
        return gP;
    }

    /* renamed from: x */
    public static synchronized void m8781x(int i, boolean z) {
        synchronized (C3570a.class) {
            int RV = m8780RV();
            bKo = z ? RV | i : RV & (~i);
            C8345d.m24067e(VivaBaseApplication.m8749FZ(), i, z);
        }
    }
}
