package com.introvd.template.p310g;

import android.databinding.C0170e;
import android.support.constraint.ConstraintLayout;
import android.support.p024v7.widget.RecyclerView;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import com.introvd.template.R;

/* renamed from: com.introvd.template.g.n */
public class C7375n extends C7374m {
    private static final C0156b bpZ = null;
    private static final SparseIntArray bqa = new SparseIntArray();
    private long bqb;
    private final ConstraintLayout cpq;

    static {
        bqa.put(R.id.tvTitle, 1);
        bqa.put(R.id.btnMore, 2);
        bqa.put(R.id.recyclerview, 3);
        bqa.put(R.id.viewDivider, 4);
    }

    public C7375n(C0170e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 5, bpZ, bqa));
    }

    private C7375n(C0170e eVar, View view, Object[] objArr) {
        super(eVar, view, 0, (TextView) objArr[2], (RecyclerView) objArr[3], (TextView) objArr[1], (View) objArr[4]);
        this.bqb = -1;
        this.cpq = objArr[0];
        this.cpq.setTag(null);
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
