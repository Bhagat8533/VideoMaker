package com.introvd.template.p310g;

import android.databinding.C0170e;
import android.databinding.C0175i;
import android.databinding.C0177j;
import android.databinding.ViewDataBinding;
import android.databinding.p009a.C0165a;
import android.support.constraint.ConstraintLayout;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.introvd.template.C4672d;
import com.introvd.template.app.school.api.model.VideoLabelInfo;

/* renamed from: com.introvd.template.g.v */
public class C7383v extends C7382u {
    private static final C0156b bpZ = null;
    private static final SparseIntArray bqa = null;
    private long bqb;
    private final ConstraintLayout cpq;

    public C7383v(C0170e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 3, bpZ, bqa));
    }

    private C7383v(C0170e eVar, View view, Object[] objArr) {
        super(eVar, view, 2, (ImageView) objArr[2], (TextView) objArr[1]);
        this.bqb = -1;
        this.cqt.setTag(null);
        this.cpq = objArr[0];
        this.cpq.setTag(null);
        this.cpp.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    /* renamed from: c */
    private boolean m21760c(C0177j<Boolean> jVar, int i) {
        if (i != C4672d._all) {
            return false;
        }
        synchronized (this) {
            this.bqb |= 1;
        }
        return true;
    }

    /* renamed from: d */
    private boolean m21761d(C0177j<Boolean> jVar, int i) {
        if (i != C4672d._all) {
            return false;
        }
        synchronized (this) {
            this.bqb |= 2;
        }
        return true;
    }

    /* renamed from: a */
    public void mo32014a(VideoLabelInfo videoLabelInfo) {
        this.cqu = videoLabelInfo;
        synchronized (this) {
            this.bqb |= 4;
        }
        notifyPropertyChanged(C4672d.info);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        String str;
        boolean z;
        String str2;
        int i;
        synchronized (this) {
            j = this.bqb;
            this.bqb = 0;
        }
        VideoLabelInfo videoLabelInfo = this.cqu;
        if ((15 & j) != 0) {
            str2 = ((j & 12) == 0 || videoLabelInfo == null) ? null : videoLabelInfo.getName();
            int i2 = ((j & 13) > 0 ? 1 : ((j & 13) == 0 ? 0 : -1));
            if (i2 != 0) {
                C0177j isSelectedField = videoLabelInfo != null ? videoLabelInfo.isSelectedField() : null;
                updateRegistration(0, (C0175i) isSelectedField);
                boolean safeUnbox = ViewDataBinding.safeUnbox(isSelectedField != null ? (Boolean) isSelectedField.get() : null);
                if (i2 != 0) {
                    j = safeUnbox ? j | 128 : j | 64;
                }
                str = safeUnbox ? TtmlNode.BOLD : "normal";
            } else {
                str = null;
            }
            int i3 = ((j & 14) > 0 ? 1 : ((j & 14) == 0 ? 0 : -1));
            if (i3 != 0) {
                C0177j isSelectedField2 = videoLabelInfo != null ? videoLabelInfo.isSelectedField() : null;
                updateRegistration(1, (C0175i) isSelectedField2);
                z = ViewDataBinding.safeUnbox(isSelectedField2 != null ? (Boolean) isSelectedField2.get() : null);
                if (i3 != 0) {
                    j = z ? j | 32 : j | 16;
                }
                i = z ? 0 : 4;
            } else {
                i = 0;
                z = false;
            }
        } else {
            i = 0;
            str2 = null;
            z = false;
            str = null;
        }
        if ((14 & j) != 0) {
            this.cqt.setVisibility(i);
            C7387z.m21771k(this.cpp, z);
        }
        if ((j & 12) != 0) {
            C0165a.m348a(this.cpp, (CharSequence) str2);
        }
        if ((j & 13) != 0) {
            C7387z.m21769b(this.cpp, str);
        }
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.bqb != 0;
        }
    }

    public void invalidateAll() {
        synchronized (this) {
            this.bqb = 8;
        }
        requestRebind();
    }

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return m21760c((C0177j) obj, i2);
            case 1:
                return m21761d((C0177j) obj, i2);
            default:
                return false;
        }
    }

    public boolean setVariable(int i, Object obj) {
        if (C4672d.info != i) {
            return false;
        }
        mo32014a((VideoLabelInfo) obj);
        return true;
    }
}
