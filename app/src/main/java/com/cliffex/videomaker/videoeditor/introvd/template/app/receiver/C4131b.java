package com.introvd.template.app.receiver;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.introvd.template.app.receiver.UpgradeBroadcastReceiver.C4128c;

/* renamed from: com.introvd.template.app.receiver.b */
class C4131b implements OnDismissListener {
    private final C4128c bwu;

    public C4131b(C4128c cVar) {
        this.bwu = cVar;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        this.bwu.m10257a(dialogInterface);
    }
}
