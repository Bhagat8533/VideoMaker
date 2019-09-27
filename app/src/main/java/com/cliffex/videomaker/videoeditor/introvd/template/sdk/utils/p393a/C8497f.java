package com.introvd.template.sdk.utils.p393a;

import android.os.Handler;
import java.lang.ref.WeakReference;

/* renamed from: com.introvd.template.sdk.utils.a.f */
public abstract class C8497f<T> extends Handler {
    private WeakReference<T> cfg;

    public C8497f(T t) {
        this.cfg = new WeakReference<>(t);
    }

    public T getOwner() {
        return this.cfg.get();
    }
}
