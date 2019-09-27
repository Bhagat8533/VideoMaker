package com.introvd.template.apicore;

import android.app.Activity;
import android.util.Log;
import android.util.SparseArray;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import p037b.p050b.p078l.C1836a;

/* renamed from: com.introvd.template.apicore.o */
public class C3638o {
    private static volatile C3638o bhB;
    private final SparseArray<CopyOnWriteArrayList<C1836a>> bhC = new SparseArray<>();

    /* renamed from: GY */
    public static C3638o m8916GY() {
        if (bhB == null) {
            synchronized (C3638o.class) {
                if (bhB == null) {
                    bhB = new C3638o();
                }
            }
        }
        return bhB;
    }

    /* renamed from: y */
    public static Integer m8917y(Activity activity) {
        return Integer.valueOf(activity.hashCode());
    }

    /* renamed from: w */
    public List<C1836a> mo22982w(Activity activity) {
        CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) this.bhC.get(m8917y(activity).intValue());
        return copyOnWriteArrayList == null ? new CopyOnWriteArrayList() : copyOnWriteArrayList;
    }

    /* renamed from: x */
    public synchronized void mo22983x(Activity activity) {
        List<C1836a> w = m8916GY().mo22982w(activity);
        StringBuilder sb = new StringBuilder();
        sb.append("onActivityDestroyed: subscriberList= ");
        sb.append(w);
        Log.d("SubscribersManager", sb.toString());
        for (C1836a aVar : w) {
            if (!aVar.aAy()) {
                aVar.dispose();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("onActivityDestroyed: unsubscribe -> ");
                sb2.append(aVar);
                Log.d("SubscribersManager", sb2.toString());
            }
        }
        this.bhC.remove(m8917y(activity).intValue());
    }
}
