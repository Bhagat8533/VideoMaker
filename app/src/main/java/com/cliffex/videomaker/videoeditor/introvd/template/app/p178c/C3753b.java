package com.introvd.template.app.p178c;

import android.databinding.C0170e;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import videoeditor.videomaker.slowmotions.starsleap.R;

/* renamed from: com.introvd.template.app.c.b */
public class C3753b extends C3752a {
    private static final C0156b bpZ = null;
    private static final SparseIntArray bqa = new SparseIntArray();
    private long bqb;

    static {
        bqa.put(R.id.tv_description, 1);
    }

    public C3753b(C0170e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 2, bpZ, bqa));
    }

    private C3753b(C0170e eVar, View view, Object[] objArr) {
        super(eVar, view, 0, (LinearLayout) objArr[0], (TextView) objArr[1]);
        this.bqb = -1;
        this.llBgFunction.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        synchronized (this) {
            long j = this.bqb;
            this.bqb = 0;
        }
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.bqb != 0;
        }
    }

    public void invalidateAll() {
        synchronized (this) {
            this.bqb = 1;
        }
        requestRebind();
    }

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }
}
