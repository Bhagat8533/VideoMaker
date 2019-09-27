package com.introvd.template.p310g;

import android.databinding.C0170e;
import android.support.constraint.ConstraintLayout;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.introvd.template.C4672d;
import com.introvd.template.R;
import com.introvd.template.app.school.api.model.TemplateInfo;
import com.introvd.template.xyui.RoundedTextView;
import com.quvideo.mobile.component.imageview.DynamicLoadingImageView;

/* renamed from: com.introvd.template.g.t */
public class C7381t extends C7380s {
    private static final C0156b bpZ = null;
    private static final SparseIntArray bqa = new SparseIntArray();
    private long bqb;
    private final ConstraintLayout cpq;

    static {
        bqa.put(R.id.btnApply, 6);
    }

    public C7381t(C0170e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 7, bpZ, bqa));
    }

    private C7381t(C0170e eVar, View view, Object[] objArr) {
        super(eVar, view, 0, (RoundedTextView) objArr[6], (DynamicLoadingImageView) objArr[1], (ImageView) objArr[4], (TextView) objArr[3], (RoundedTextView) objArr[5], (TextView) objArr[2]);
        this.bqb = -1;
        this.cpr.setTag(null);
        this.cpC.setTag(null);
        this.cpq = objArr[0];
        this.cpq.setTag(null);
        this.cqr.setTag(null);
        this.cqs.setTag(null);
        this.bAk.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    /* renamed from: e */
    public void mo32013e(TemplateInfo templateInfo) {
        this.cpJ = templateInfo;
        synchronized (this) {
            this.bqb |= 1;
        }
        notifyPropertyChanged(C4672d.info);
        super.requestRebind();
    }

    /* JADX WARNING: type inference failed for: r9v0 */
    /* JADX WARNING: type inference failed for: r11v0 */
    /* JADX WARNING: type inference failed for: r11v1 */
    /* JADX WARNING: type inference failed for: r11v2, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r11v3 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r15 = this;
            monitor-enter(r15)
            long r0 = r15.bqb     // Catch:{ all -> 0x0084 }
            r2 = 0
            r15.bqb = r2     // Catch:{ all -> 0x0084 }
            monitor-exit(r15)     // Catch:{ all -> 0x0084 }
            com.introvd.template.app.school.api.model.TemplateInfo r4 = r15.cpJ
            r5 = 3
            long r7 = r0 & r5
            r9 = 0
            r10 = 0
            int r7 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r7 == 0) goto L_0x0062
            if (r4 == 0) goto L_0x002b
            com.introvd.template.app.school.api.model.CommodityInfo r9 = r4.getCommodityInfo()
            java.lang.String r8 = r4.formatUseCount()
            java.lang.String r11 = r4.getCoverUrl()
            boolean r12 = r4.isVip()
            java.lang.String r4 = r4.getTitle()
            goto L_0x002f
        L_0x002b:
            r4 = r9
            r8 = r4
            r11 = r8
            r12 = 0
        L_0x002f:
            if (r7 == 0) goto L_0x003a
            if (r12 == 0) goto L_0x0037
            r13 = 8
            long r0 = r0 | r13
            goto L_0x003a
        L_0x0037:
            r13 = 4
            long r0 = r0 | r13
        L_0x003a:
            if (r9 == 0) goto L_0x0041
            boolean r7 = r9.isCommodity()
            goto L_0x0042
        L_0x0041:
            r7 = 0
        L_0x0042:
            long r13 = r0 & r5
            int r9 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
            if (r9 == 0) goto L_0x0051
            if (r7 == 0) goto L_0x004e
            r13 = 32
            long r0 = r0 | r13
            goto L_0x0051
        L_0x004e:
            r13 = 16
            long r0 = r0 | r13
        L_0x0051:
            if (r12 == 0) goto L_0x0055
            r9 = 0
            goto L_0x0056
        L_0x0055:
            r9 = 4
        L_0x0056:
            if (r7 == 0) goto L_0x0059
            goto L_0x005d
        L_0x0059:
            r7 = 8
            r10 = 8
        L_0x005d:
            r7 = r4
            r4 = r10
            r10 = r9
            r9 = r11
            goto L_0x0065
        L_0x0062:
            r7 = r9
            r8 = r7
            r4 = 0
        L_0x0065:
            long r0 = r0 & r5
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto L_0x0083
            com.quvideo.mobile.component.imageview.DynamicLoadingImageView r0 = r15.cpr
            com.introvd.template.p310g.C7387z.m21770b(r0, r9)
            android.widget.ImageView r0 = r15.cpC
            r0.setVisibility(r10)
            android.widget.TextView r0 = r15.cqr
            android.databinding.p009a.C0165a.m348a(r0, r8)
            com.introvd.template.xyui.RoundedTextView r0 = r15.cqs
            r0.setVisibility(r4)
            android.widget.TextView r0 = r15.bAk
            android.databinding.p009a.C0165a.m348a(r0, r7)
        L_0x0083:
            return
        L_0x0084:
            r0 = move-exception
            monitor-exit(r15)     // Catch:{ all -> 0x0084 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.p310g.C7381t.executeBindings():void");
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.bqb != 0;
        }
    }

    public void invalidateAll() {
        synchronized (this) {
            this.bqb = 2;
        }
        requestRebind();
    }

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, Object obj) {
        if (C4672d.info != i) {
            return false;
        }
        mo32013e((TemplateInfo) obj);
        return true;
    }
}
