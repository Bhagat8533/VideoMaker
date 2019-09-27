package com.introvd.template.explorer.model;

import com.introvd.template.explorer.p297b.C7139a;

public class NotifyItem {

    /* renamed from: cb */
    public final C7139a f3541cb;
    public final int lParam;
    public final int nStatus;
    public final Object obj;
    public final int wParam;
    public final int what;

    public NotifyItem(int i, int i2, int i3, int i4, Object obj2) {
        this(i, i2, i3, i4, obj2, null);
    }

    public NotifyItem(int i, int i2, int i3, int i4, Object obj2, C7139a aVar) {
        this.what = i;
        this.lParam = i2;
        this.wParam = i3;
        this.nStatus = i4;
        this.obj = obj2;
        this.f3541cb = aVar;
    }
}
