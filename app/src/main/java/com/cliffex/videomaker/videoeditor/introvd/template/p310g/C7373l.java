package com.introvd.template.p310g;

import android.databinding.C0170e;
import android.databinding.C0177j;
import android.support.constraint.ConstraintLayout;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.introvd.template.C4672d;
import com.introvd.template.R;
import com.introvd.template.app.school.api.model.SchoolCourseInfo;
import com.introvd.template.xyui.RoundedRelativeLayout;
import com.quvideo.mobile.component.imageview.DynamicLoadingImageView;

/* renamed from: com.introvd.template.g.l */
public class C7373l extends C7372k {
    private static final C0156b bpZ = null;
    private static final SparseIntArray bqa = new SparseIntArray();
    private long bqb;
    private final ConstraintLayout cpq;

    static {
        bqa.put(R.id.viewBg, 6);
        bqa.put(R.id.imgOverlay, 7);
    }

    public C7373l(C0170e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 8, bpZ, bqa));
    }

    private C7373l(C0170e eVar, View view, Object[] objArr) {
        super(eVar, view, 2, (DynamicLoadingImageView) objArr[3], (ImageView) objArr[7], (DynamicLoadingImageView) objArr[4], (TextView) objArr[2], (TextView) objArr[5], (TextView) objArr[1], (RoundedRelativeLayout) objArr[6]);
        this.bqb = -1;
        this.cpr.setTag(null);
        this.cpt.setTag(null);
        this.cpq = objArr[0];
        this.cpq.setTag(null);
        this.cpu.setTag(null);
        this.cpp.setTag(null);
        this.bAk.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    /* renamed from: a */
    private boolean m21732a(C0177j<String> jVar, int i) {
        if (i != C4672d._all) {
            return false;
        }
        synchronized (this) {
            this.bqb |= 1;
        }
        return true;
    }

    /* renamed from: b */
    private boolean m21733b(C0177j<String> jVar, int i) {
        if (i != C4672d._all) {
            return false;
        }
        synchronized (this) {
            this.bqb |= 2;
        }
        return true;
    }

    /* renamed from: c */
    public void mo32003c(SchoolCourseInfo schoolCourseInfo) {
        this.cpw = schoolCourseInfo;
        synchronized (this) {
            this.bqb |= 4;
        }
        notifyPropertyChanged(C4672d.info);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0054  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r19 = this;
            r1 = r19
            monitor-enter(r19)
            long r2 = r1.bqb     // Catch:{ all -> 0x009f }
            r4 = 0
            r1.bqb = r4     // Catch:{ all -> 0x009f }
            monitor-exit(r19)     // Catch:{ all -> 0x009f }
            com.introvd.template.app.school.api.model.SchoolCourseInfo r0 = r1.cpw
            r6 = 15
            long r6 = r6 & r2
            r8 = 14
            r10 = 12
            r12 = 13
            int r6 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x0070
            long r6 = r2 & r12
            int r6 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x0034
            if (r0 == 0) goto L_0x0026
            android.databinding.j r6 = r0.getAvatarUrlField()
            goto L_0x0027
        L_0x0026:
            r6 = 0
        L_0x0027:
            r7 = 0
            r1.updateRegistration(r7, r6)
            if (r6 == 0) goto L_0x0034
            java.lang.Object r6 = r6.get()
            java.lang.String r6 = (java.lang.String) r6
            goto L_0x0035
        L_0x0034:
            r6 = 0
        L_0x0035:
            long r15 = r2 & r10
            int r7 = (r15 > r4 ? 1 : (r15 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x004a
            if (r0 == 0) goto L_0x004a
            java.lang.String r7 = r0.getDesc()
            java.lang.String r15 = r0.getCoverUrl()
            java.lang.String r16 = r0.getTitle()
            goto L_0x004e
        L_0x004a:
            r7 = 0
            r15 = 0
            r16 = 0
        L_0x004e:
            long r17 = r2 & r8
            int r17 = (r17 > r4 ? 1 : (r17 == r4 ? 0 : -1))
            if (r17 == 0) goto L_0x006c
            if (r0 == 0) goto L_0x005b
            android.databinding.j r0 = r0.getNameField()
            goto L_0x005c
        L_0x005b:
            r0 = 0
        L_0x005c:
            r14 = 1
            r1.updateRegistration(r14, r0)
            if (r0 == 0) goto L_0x006c
            java.lang.Object r0 = r0.get()
            r14 = r0
            java.lang.String r14 = (java.lang.String) r14
            r0 = r16
            goto L_0x0075
        L_0x006c:
            r0 = r16
            r14 = 0
            goto L_0x0075
        L_0x0070:
            r0 = 0
            r6 = 0
            r7 = 0
            r14 = 0
            r15 = 0
        L_0x0075:
            long r10 = r10 & r2
            int r10 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r10 == 0) goto L_0x0089
            com.quvideo.mobile.component.imageview.DynamicLoadingImageView r10 = r1.cpr
            com.introvd.template.p310g.C7387z.m21770b(r10, r15)
            android.widget.TextView r10 = r1.cpu
            android.databinding.p009a.C0165a.m348a(r10, r7)
            android.widget.TextView r7 = r1.bAk
            android.databinding.p009a.C0165a.m348a(r7, r0)
        L_0x0089:
            long r10 = r2 & r12
            int r0 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0094
            com.quvideo.mobile.component.imageview.DynamicLoadingImageView r0 = r1.cpt
            com.introvd.template.p310g.C7387z.m21770b(r0, r6)
        L_0x0094:
            long r2 = r2 & r8
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x009e
            android.widget.TextView r0 = r1.cpp
            android.databinding.p009a.C0165a.m348a(r0, r14)
        L_0x009e:
            return
        L_0x009f:
            r0 = move-exception
            monitor-exit(r19)     // Catch:{ all -> 0x009f }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.p310g.C7373l.executeBindings():void");
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
                return m21732a((C0177j) obj, i2);
            case 1:
                return m21733b((C0177j) obj, i2);
            default:
                return false;
        }
    }

    public boolean setVariable(int i, Object obj) {
        if (C4672d.info != i) {
            return false;
        }
        mo32003c((SchoolCourseInfo) obj);
        return true;
    }
}
