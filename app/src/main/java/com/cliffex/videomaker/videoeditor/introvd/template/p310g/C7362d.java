package com.introvd.template.p310g;

import android.databinding.C0170e;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import com.introvd.template.R;

/* renamed from: com.introvd.template.g.d */
public class C7362d extends C7361c {
    private static final C0156b bpZ = null;
    private static final SparseIntArray bqa = new SparseIntArray();
    private long bqb;
    private final FrameLayout coQ;

    static {
        bqa.put(R.id.recyclerview, 1);
    }

    public C7362d(C0170e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 2, bpZ, bqa));
    }

    private C7362d(C0170e eVar, View view, Object[] objArr) {
        super(eVar, view, 0, objArr[1]);
        this.bqb = -1;
        this.coQ = objArr[0];
        this.coQ.setTag(null);
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
