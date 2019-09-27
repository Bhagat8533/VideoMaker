package com.introvd.template.app.p184h.p185a;

import android.content.Intent;
import com.vivavideo.mobile.h5api.api.C9345j;
import com.vivavideo.mobile.h5core.p447ui.H5Activity.PageListener;

/* renamed from: com.introvd.template.app.h.a.b */
class C3890b implements PageListener {
    private final C3888a bsL;
    private final C9345j bsM;

    public C3890b(C3888a aVar, C9345j jVar) {
        this.bsL = aVar;
        this.bsM = jVar;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        this.bsL.m9575b(this.bsM, i, i2, intent);
    }
}
