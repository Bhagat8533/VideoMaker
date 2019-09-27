package com.introvd.template.editor.p252e;

import android.content.Context;
import com.introvd.template.common.LogUtilsV2;

/* renamed from: com.introvd.template.editor.e.b */
public class C5879b {
    private static Thread cUO;
    private static Thread cUP;
    private static Thread cUQ;

    /* renamed from: a */
    private static void m16419a(Thread thread) {
        if (thread != null) {
            try {
                thread.interrupt();
                thread.join(100);
            } catch (Exception unused) {
            }
        }
    }

    public static void ani() {
        m16419a(cUP);
        cUP = null;
        m16419a(cUO);
        cUO = null;
        m16419a(cUQ);
        cUQ = null;
    }

    /* renamed from: fc */
    public static void m16420fc(Context context) {
        cUO = new C5881d(context);
        cUO.start();
    }

    /* renamed from: fd */
    public static void m16421fd(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        sb.append("ShareSocialMgr, cost:");
        sb.append(System.currentTimeMillis() - currentTimeMillis);
        LogUtilsV2.m14227d(sb.toString());
        cUQ = new C5880c();
        cUQ.start();
    }

    /* renamed from: fe */
    public static void m16422fe(Context context) {
        cUP = new C5878a(context);
        cUP.start();
    }
}
