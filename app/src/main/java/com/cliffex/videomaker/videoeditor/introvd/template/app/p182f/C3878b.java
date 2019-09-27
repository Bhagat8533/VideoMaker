package com.introvd.template.app.p182f;

import java.util.HashMap;

/* renamed from: com.introvd.template.app.f.b */
public class C3878b {
    private static volatile C3878b bqz;
    private HashMap<String, String> bqA = new HashMap<>();

    private C3878b() {
    }

    /* renamed from: La */
    public static C3878b m9550La() {
        if (bqz == null) {
            synchronized (C3878b.class) {
                if (bqz == null) {
                    bqz = new C3878b();
                }
            }
        }
        return bqz;
    }

    public boolean containsKey(String str) {
        return this.bqA != null && this.bqA.containsKey(str);
    }

    public void put(String str, String str2) {
        if (this.bqA != null) {
            this.bqA.put(str, str2);
        }
    }

    public void remove(String str) {
        if (this.bqA != null && this.bqA.containsKey(str)) {
            this.bqA.remove(str);
        }
    }
}
