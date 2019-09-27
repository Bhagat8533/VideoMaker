package com.introvd.template.template.download;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;

/* renamed from: com.introvd.template.template.download.a */
public abstract class C8691a {
    private static final String TAG = "a";
    protected Context bbr;
    protected Handler mHandler = null;

    public C8691a(Context context, Handler handler) {
        this.mHandler = handler;
        if (context == null) {
            return;
        }
        if (context instanceof Activity) {
            this.bbr = context.getApplicationContext();
        } else {
            this.bbr = context;
        }
    }
}
