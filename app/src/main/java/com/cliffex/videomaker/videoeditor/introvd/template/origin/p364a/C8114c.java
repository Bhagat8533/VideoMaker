package com.introvd.template.origin.p364a;

import com.introvd.template.router.app.config.AppConfigObserver;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.introvd.template.origin.a.c */
class C8114c {
    private CopyOnWriteArrayList<AppConfigObserver> dWx = new CopyOnWriteArrayList<>();

    C8114c() {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo33152b(AppConfigObserver appConfigObserver) {
        if (appConfigObserver == null) {
            throw new NullPointerException();
        } else if (!this.dWx.contains(appConfigObserver)) {
            this.dWx.add(appConfigObserver);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: w */
    public void mo33153w(int i, String str) {
        Iterator it = this.dWx.iterator();
        while (it.hasNext()) {
            ((AppConfigObserver) it.next()).onChange(i, str);
        }
    }
}
