package com.introvd.template.p310g;

import android.databinding.C0170e;
import android.support.constraint.ConstraintLayout;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.introvd.template.R;
import com.quvideo.mobile.component.imageview.DynamicLoadingImageView;

/* renamed from: com.introvd.template.g.j */
public class C7371j extends C7370i {
    private static final C0156b bpZ = null;
    private static final SparseIntArray bqa = new SparseIntArray();
    private long bqb;
    private final ConstraintLayout cpq;

    static {
        bqa.put(R.id.imgBg, 1);
        bqa.put(R.id.imgShadow, 2);
        bqa.put(R.id.imgIcon, 3);
        bqa.put(R.id.tvName, 4);
    }

    public C7371j(C0170e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 5, bpZ, bqa));
    }

    private C7371j(C0170e eVar, View view, Object[] objArr) {
        super(eVar, view, 0, (ImageView) objArr[1], (DynamicLoadingImageView) objArr[3], (ImageView) objArr[2], (TextView) objArr[4]);
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
