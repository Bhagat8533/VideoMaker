package com.introvd.template.p173a.p174a;

import android.os.Looper;
import android.util.Log;
import java.util.HashMap;

/* renamed from: com.introvd.template.a.a.a */
public class C3571a {
    private static HashMap<String, Long> bKp = new HashMap<>();
    public static long bKq = 0;
    private static HashMap<String, String> bKr = new HashMap<>();
    private static long bKs = 0;
    private static long bKt = 0;

    /* renamed from: RW */
    public static HashMap<String, String> m8782RW() {
        return new HashMap<>(bKr);
    }

    /* renamed from: ev */
    public static void m8783ev(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        bKs = currentTimeMillis;
        bKp.put(str, Long.valueOf(currentTimeMillis));
    }

    /* renamed from: ew */
    public static long m8784ew(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        Long l = (Long) bKp.get(str);
        if (l == null) {
            return -1;
        }
        bKp.remove(str);
        return currentTimeMillis - l.longValue();
    }

    /* renamed from: ex */
    public static void m8785ex(String str) {
        if (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId()) {
            long currentTimeMillis = System.currentTimeMillis();
            long j = currentTimeMillis - bKs;
            StringBuilder sb = new StringBuilder();
            sb.append(bKt);
            sb.append("_");
            sb.append(str);
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append("JaminTime key=");
            sb3.append(sb2);
            sb3.append(",cost = ");
            sb3.append(j);
            Log.d("Per_Launch_Time", sb3.toString());
            bKr.put(sb2, String.valueOf(j));
            bKt++;
            bKs = currentTimeMillis;
        }
    }
}
