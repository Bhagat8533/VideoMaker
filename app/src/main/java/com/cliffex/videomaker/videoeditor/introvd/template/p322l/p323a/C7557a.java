package com.introvd.template.p322l.p323a;

import android.view.View;
import android.view.View.OnClickListener;

/* renamed from: com.introvd.template.l.a.a */
public final class C7557a implements OnClickListener {
    final C7558a dLg;
    final int dLh;

    /* renamed from: com.introvd.template.l.a.a$a */
    public interface C7558a {
        void _internalCallbackOnClick(int i, View view);
    }

    public C7557a(C7558a aVar, int i) {
        this.dLg = aVar;
        this.dLh = i;
    }

    public void onClick(View view) {
        this.dLg._internalCallbackOnClick(this.dLh, view);
    }
}
