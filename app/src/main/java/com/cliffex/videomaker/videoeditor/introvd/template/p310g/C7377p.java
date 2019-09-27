package com.introvd.template.p310g;

import android.databinding.C0170e;
import android.support.constraint.ConstraintLayout;
import android.util.SparseIntArray;
import android.view.View;
import com.introvd.template.C4672d;
import com.introvd.template.R;
import com.introvd.template.app.school.api.model.TemplateInfo;

/* renamed from: com.introvd.template.g.p */
public class C7377p extends C7376o {
    private static final C0156b bpZ = null;
    private static final SparseIntArray bqa = new SparseIntArray();
    private long bqb;
    private final ConstraintLayout cpq;

    static {
        bqa.put(R.id.viewContent, 11);
        bqa.put(R.id.layoutVideo, 12);
        bqa.put(R.id.btnPlay, 13);
        bqa.put(R.id.spaceTop, 14);
    }

    public C7377p(C0170e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 15, bpZ, bqa));
    }

    private C7377p(C0170e eVar, View view, Object[] objArr) {
        super(eVar, view, 0, objArr[8], objArr[13], objArr[1], objArr[5], objArr[9], objArr[3], objArr[12], objArr[14], objArr[7], objArr[4], objArr[10], objArr[2], objArr[6], objArr[11]);
        this.bqb = -1;
        this.cpz.setTag(null);
        this.cpA.setTag(null);
        this.cpr.setTag(null);
        this.cpB.setTag(null);
        this.cpC.setTag(null);
        this.cpq = objArr[0];
        this.cpq.setTag(null);
        this.cpu.setTag(null);
        this.cpF.setTag(null);
        this.cpG.setTag(null);
        this.cpp.setTag(null);
        this.bAk.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    /* renamed from: dK */
    public void mo32005dK(boolean z) {
        this.cpI = z;
    }

    /* renamed from: dL */
    public void mo32006dL(boolean z) {
        this.cpK = z;
        synchronized (this) {
            this.bqb |= 2;
        }
        notifyPropertyChanged(C4672d.showHint);
        super.requestRebind();
    }

    /* renamed from: dM */
    public void mo32007dM(boolean z) {
        this.cpL = z;
        synchronized (this) {
            this.bqb |= 1;
        }
        notifyPropertyChanged(C4672d.showNextArrow);
        super.requestRebind();
    }

    /* renamed from: e */
    public void mo32008e(TemplateInfo templateInfo) {
        this.cpJ = templateInfo;
        synchronized (this) {
            this.bqb |= 4;
        }
        notifyPropertyChanged(C4672d.info);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0126  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0132  */
    /* JADX WARNING: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r27 = this;
            r1 = r27
            monitor-enter(r27)
            long r2 = r1.bqb     // Catch:{ all -> 0x0138 }
            r4 = 0
            r1.bqb = r4     // Catch:{ all -> 0x0138 }
            monitor-exit(r27)     // Catch:{ all -> 0x0138 }
            boolean r0 = r1.cpL
            boolean r6 = r1.cpK
            com.introvd.template.app.school.api.model.TemplateInfo r7 = r1.cpJ
            r8 = 17
            long r10 = r2 & r8
            r12 = 8
            r13 = 0
            int r10 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r10 == 0) goto L_0x002c
            if (r10 == 0) goto L_0x0026
            if (r0 == 0) goto L_0x0023
            r10 = 256(0x100, double:1.265E-321)
            long r2 = r2 | r10
            goto L_0x0026
        L_0x0023:
            r10 = 128(0x80, double:6.32E-322)
            long r2 = r2 | r10
        L_0x0026:
            if (r0 == 0) goto L_0x0029
            goto L_0x002c
        L_0x0029:
            r0 = 8
            goto L_0x002d
        L_0x002c:
            r0 = 0
        L_0x002d:
            r10 = 18
            long r14 = r2 & r10
            int r14 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r14 == 0) goto L_0x0046
            if (r14 == 0) goto L_0x0040
            if (r6 == 0) goto L_0x003d
            r14 = 64
            long r2 = r2 | r14
            goto L_0x0040
        L_0x003d:
            r14 = 32
            long r2 = r2 | r14
        L_0x0040:
            if (r6 == 0) goto L_0x0043
            goto L_0x0046
        L_0x0043:
            r6 = 8
            goto L_0x0047
        L_0x0046:
            r6 = 0
        L_0x0047:
            r14 = 20
            long r16 = r2 & r14
            r18 = 0
            int r16 = (r16 > r4 ? 1 : (r16 == r4 ? 0 : -1))
            if (r16 == 0) goto L_0x00d4
            if (r7 == 0) goto L_0x006c
            com.introvd.template.app.school.api.model.CommodityInfo r17 = r7.getCommodityInfo()
            com.introvd.template.app.school.api.model.UserInfo r19 = r7.getUserInfo()
            java.lang.String r20 = r7.getCoverUrl()
            boolean r21 = r7.isVip()
            java.lang.String r22 = r7.getDescription()
            java.lang.String r7 = r7.getTitle()
            goto L_0x0078
        L_0x006c:
            r7 = r18
            r17 = r7
            r19 = r17
            r20 = r19
            r22 = r20
            r21 = 0
        L_0x0078:
            if (r16 == 0) goto L_0x0085
            if (r21 == 0) goto L_0x0081
            r23 = 1024(0x400, double:5.06E-321)
            long r2 = r2 | r23
            goto L_0x0085
        L_0x0081:
            r23 = 512(0x200, double:2.53E-321)
            long r2 = r2 | r23
        L_0x0085:
            if (r17 == 0) goto L_0x0090
            boolean r16 = r17.isCommodity()
            java.lang.String r17 = r17.formatAmountStr()
            goto L_0x0094
        L_0x0090:
            r17 = r18
            r16 = 0
        L_0x0094:
            long r23 = r2 & r14
            int r23 = (r23 > r4 ? 1 : (r23 == r4 ? 0 : -1))
            if (r23 == 0) goto L_0x00a5
            if (r16 == 0) goto L_0x00a1
            r23 = 4096(0x1000, double:2.0237E-320)
            long r2 = r2 | r23
            goto L_0x00a5
        L_0x00a1:
            r23 = 2048(0x800, double:1.0118E-320)
            long r2 = r2 | r23
        L_0x00a5:
            if (r19 == 0) goto L_0x00b6
            java.lang.String r18 = r19.getNickName()
            java.lang.String r19 = r19.getLogo()
            r26 = r19
            r19 = r18
            r18 = r26
            goto L_0x00b8
        L_0x00b6:
            r19 = r18
        L_0x00b8:
            if (r21 == 0) goto L_0x00bd
            r21 = 0
            goto L_0x00bf
        L_0x00bd:
            r21 = 8
        L_0x00bf:
            if (r16 == 0) goto L_0x00c2
            goto L_0x00c4
        L_0x00c2:
            r13 = 8
        L_0x00c4:
            r25 = r7
            r8 = r13
            r11 = r17
            r7 = r18
            r9 = r19
            r12 = r20
            r13 = r21
            r10 = r22
            goto L_0x00dd
        L_0x00d4:
            r7 = r18
            r9 = r7
            r10 = r9
            r11 = r10
            r12 = r11
            r25 = r12
            r8 = 0
        L_0x00dd:
            r16 = 16
            long r16 = r2 & r16
            int r16 = (r16 > r4 ? 1 : (r16 == r4 ? 0 : -1))
            if (r16 == 0) goto L_0x00eb
            android.widget.TextView r4 = r1.cpz
            r5 = 1
            com.introvd.template.p310g.C7387z.m21772l(r4, r5)
        L_0x00eb:
            long r4 = r2 & r14
            r14 = 0
            int r4 = (r4 > r14 ? 1 : (r4 == r14 ? 0 : -1))
            if (r4 == 0) goto L_0x011d
            com.quvideo.mobile.component.imageview.DynamicLoadingImageView r4 = r1.cpA
            com.introvd.template.p310g.C7387z.m21770b(r4, r7)
            com.quvideo.mobile.component.imageview.DynamicLoadingImageView r4 = r1.cpr
            com.introvd.template.p310g.C7387z.m21770b(r4, r12)
            android.widget.ImageView r4 = r1.cpC
            r4.setVisibility(r13)
            android.widget.TextView r4 = r1.cpu
            android.databinding.p009a.C0165a.m348a(r4, r10)
            com.introvd.template.xyui.RoundedTextView r4 = r1.cpF
            android.databinding.p009a.C0165a.m348a(r4, r11)
            com.introvd.template.xyui.RoundedTextView r4 = r1.cpF
            r4.setVisibility(r8)
            android.widget.TextView r4 = r1.cpp
            android.databinding.p009a.C0165a.m348a(r4, r9)
            android.widget.TextView r4 = r1.bAk
            r7 = r25
            android.databinding.p009a.C0165a.m348a(r4, r7)
        L_0x011d:
            r4 = 17
            long r4 = r4 & r2
            r7 = 0
            int r4 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r4 == 0) goto L_0x012b
            android.widget.ImageView r4 = r1.cpB
            r4.setVisibility(r0)
        L_0x012b:
            r4 = 18
            long r2 = r2 & r4
            int r0 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r0 == 0) goto L_0x0137
            android.widget.TextView r0 = r1.cpG
            r0.setVisibility(r6)
        L_0x0137:
            return
        L_0x0138:
            r0 = move-exception
            monitor-exit(r27)     // Catch:{ all -> 0x0138 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.p310g.C7377p.executeBindings():void");
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.bqb != 0;
        }
    }

    public void invalidateAll() {
        synchronized (this) {
            this.bqb = 16;
        }
        requestRebind();
    }

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, Object obj) {
        if (C4672d.showNextArrow == i) {
            mo32007dM(((Boolean) obj).booleanValue());
        } else if (C4672d.showHint == i) {
            mo32006dL(((Boolean) obj).booleanValue());
        } else if (C4672d.info == i) {
            mo32008e((TemplateInfo) obj);
        } else if (C4672d.isHor != i) {
            return false;
        } else {
            mo32005dK(((Boolean) obj).booleanValue());
        }
        return true;
    }
}
