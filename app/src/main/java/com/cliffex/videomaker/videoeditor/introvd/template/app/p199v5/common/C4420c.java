package com.introvd.template.app.p199v5.common;

import android.os.Handler;
import android.os.Message;

/* renamed from: com.introvd.template.app.v5.common.c */
public class C4420c extends Handler {
    private C4421a bFr;

    /* renamed from: com.introvd.template.app.v5.common.c$a */
    public interface C4421a {
        void handleMessage(Message message);
    }

    /* renamed from: a */
    public void mo24501a(C4421a aVar) {
        this.bFr = aVar;
    }

    public void handleMessage(Message message) {
        if (this.bFr != null) {
            this.bFr.handleMessage(message);
        }
    }
}
