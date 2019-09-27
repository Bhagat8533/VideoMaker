package com.cliffex.videomaker.videoeditor.aiii.android.arouter.p091c;

import android.app.Application;
import android.content.Context;

import com.aiii.android.arouter.facade.p095b.C1944b;
import com.aiii.android.arouter.facade.template.C1948b;
import com.aiii.android.arouter.p090b.C1917b;

/* renamed from: com.aiii.android.arouter.c.a */
public final class C1919a {
    private static volatile C1919a atA;
    private static volatile boolean atB;
    public static C1948b atC;

    private C1919a() {
    }

    /* renamed from: a */
    public static void m5528a(Application application) {
        if (!atB) {
            atC = com.aiii.android.arouter.p091c.C1920b.atC;
            com.aiii.android.arouter.p091c.C1920b.atC.mo10378h("ARouter::", "ARouter init start.");
            atB = C1920b.m5539b(application);
            if (atB) {
                C1920b.m5544sh();
            }
            C1920b.atC.mo10378h("ARouter::", "ARouter init over.");
        }
    }

    /* renamed from: sc */
    public static C1919a m5529sc() {
        if (atB) {
            if (atA == null) {
                synchronized (C1919a.class) {
                    if (atA == null) {
                        atA = new C1919a();
                    }
                }
            }
            return atA;
        }
        throw new C1917b("ARouter::Init::Invoke init(context) first!");
    }

    /* renamed from: sd */
    public static synchronized void m5530sd() {
        synchronized (C1919a.class) {
            C1920b.m5540sd();
        }
    }

    /* renamed from: se */
    public static boolean m5531se() {
        return C1920b.m5541se();
    }

    /* renamed from: sf */
    public static synchronized void m5532sf() {
        synchronized (C1919a.class) {
            C1920b.m5542sf();
        }
    }

    /* renamed from: a */
    public Object mo10354a(Context context, C1941a aVar, int i, C1944b bVar) {
        return C1920b.m5543sg().mo10358a(context, aVar, i, bVar);
    }

    /* renamed from: al */
    public C1941a mo10355al(String str) {
        return C1920b.m5543sg().mo10359al(str);
    }

    /* renamed from: i */
    public <T> T mo10356i(Class<? extends T> cls) {
        return C1920b.m5543sg().mo10360i(cls);
    }

    public void inject(Object obj) {
        C1920b.inject(obj);
    }
}
