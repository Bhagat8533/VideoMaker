package com.introvd.template.common.other;

import android.os.Handler;
import java.lang.ref.WeakReference;

public abstract class WeakHandler<T> extends Handler {
    private WeakReference<T> cfg;

    public WeakHandler(T t) {
        this.cfg = new WeakReference<>(t);
    }

    public T getOwner() {
        return this.cfg.get();
    }
}
