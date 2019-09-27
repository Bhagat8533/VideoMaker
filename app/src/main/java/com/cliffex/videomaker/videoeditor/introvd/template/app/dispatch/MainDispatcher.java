package com.introvd.template.app.dispatch;

import android.arch.lifecycle.C0061e.C0062a;
import android.arch.lifecycle.C0068f;
import android.arch.lifecycle.C0078n;
import android.support.p021v4.app.FragmentActivity;
import com.introvd.template.app.dispatch.dispatcher.C3866a;
import com.introvd.template.app.dispatch.dispatcher.C3867b;
import com.introvd.template.app.dispatch.dispatcher.MediaSourceDispatcher;
import com.introvd.template.common.LogUtilsV2;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import p037b.p050b.p051a.p053b.C1487a;

public class MainDispatcher implements C0068f {
    private LinkedList<C3863a> bqm = new LinkedList<>();
    private FragmentActivity mActivity;

    public MainDispatcher(FragmentActivity fragmentActivity) {
        this.mActivity = fragmentActivity;
        LogUtilsV2.m14227d(">>> MainDispatcher()");
        register();
    }

    /* access modifiers changed from: private */
    public void dispatch() {
        Iterator it = this.bqm.iterator();
        while (it.hasNext()) {
            C3863a aVar = (C3863a) it.next();
            if (aVar.mo23395e(this.mActivity)) {
                StringBuilder sb = new StringBuilder();
                sb.append(">>>dispatchIntercept by ");
                sb.append(aVar.getClass().getSimpleName());
                LogUtilsV2.m14227d(sb.toString());
                return;
            }
        }
        LogUtilsV2.m14227d(">>>dispatch end No Dispatcher");
    }

    private void register() {
        this.bqm.add(new MediaSourceDispatcher());
        this.bqm.add(new C3866a());
        this.bqm.add(new C3867b());
    }

    /* renamed from: KV */
    public void mo23391KV() {
    }

    /* access modifiers changed from: protected */
    @C0078n(mo161n = C0062a.ON_CREATE)
    public void onActivityCreate() {
        LogUtilsV2.m14227d(">>> onActivityCreate...");
        C1487a.aUa().mo9777a(new Runnable() {
            public void run() {
                MainDispatcher.this.dispatch();
            }
        }, 100, TimeUnit.MILLISECONDS);
    }

    /* access modifiers changed from: protected */
    @C0078n(mo161n = C0062a.ON_RESUME)
    public void onActivityResume() {
        LogUtilsV2.m14227d(">>> onActivityResume...");
    }
}
