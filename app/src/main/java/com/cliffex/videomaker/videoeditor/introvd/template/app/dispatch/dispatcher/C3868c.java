package com.introvd.template.app.dispatch.dispatcher;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.introvd.template.app.dispatch.dispatcher.MediaSourceDispatcher.C3865a;

/* renamed from: com.introvd.template.app.dispatch.dispatcher.c */
class C3868c implements OnDismissListener {
    private final C3865a bqp;

    public C3868c(C3865a aVar) {
        this.bqp = aVar;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        this.bqp.m9519a(dialogInterface);
    }
}
