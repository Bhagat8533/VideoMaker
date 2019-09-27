package com.introvd.template.p310g;

import android.databinding.C0170e;
import android.databinding.C0177j;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import com.introvd.template.C4672d;
import com.introvd.template.R;
import com.introvd.template.app.homepage.hometab.HomeTabLayoutModel;

/* renamed from: com.introvd.template.g.ab */
public class C7355ab extends C7354aa {
    private static final C0156b bpZ = null;
    private static final SparseIntArray bqa = new SparseIntArray();
    private long bqb;
    private final RelativeLayout coO;

    static {
        bqa.put(R.id.tab_menu, 5);
        bqa.put(R.id.layout_fragment_find, 6);
        bqa.put(R.id.img_find, 7);
        bqa.put(R.id.layout_fragment_school, 8);
        bqa.put(R.id.img_school, 9);
        bqa.put(R.id.text_school, 10);
        bqa.put(R.id.layout_fragment_creation, 11);
        bqa.put(R.id.img_creation, 12);
        bqa.put(R.id.text_creation, 13);
        bqa.put(R.id.layout_fragment_message, 14);
        bqa.put(R.id.img_message, 15);
        bqa.put(R.id.text_message, 16);
        bqa.put(R.id.imageview_new_flag_message, 17);
        bqa.put(R.id.layout_fragment_studio, 18);
        bqa.put(R.id.img_studio, 19);
        bqa.put(R.id.text_studio, 20);
        bqa.put(R.id.imageview_content_focus_frame, 21);
    }

    public C7355ab(C0170e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 22, bpZ, bqa));
    }

    private C7355ab(C0170e eVar, View view, Object[] objArr) {
        super(eVar, view, 4, objArr[21], objArr[3], objArr[17], objArr[1], objArr[12], objArr[7], objArr[15], objArr[9], objArr[19], objArr[11], objArr[6], objArr[14], objArr[8], objArr[18], objArr[5], objArr[13], objArr[2], objArr[16], objArr[10], objArr[20], objArr[4]);
        this.bqb = -1;
        this.cqB.setTag(null);
        this.cqD.setTag(null);
        this.coO = objArr[0];
        this.coO.setTag(null);
        this.cqQ.setTag(null);
        this.cqU.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    /* renamed from: e */
    private boolean m21707e(C0177j<Integer> jVar, int i) {
        if (i != C4672d._all) {
            return false;
        }
        synchronized (this) {
            this.bqb |= 1;
        }
        return true;
    }

    /* renamed from: f */
    private boolean m21708f(C0177j<String> jVar, int i) {
        if (i != C4672d._all) {
            return false;
        }
        synchronized (this) {
            this.bqb |= 2;
        }
        return true;
    }

    /* renamed from: g */
    private boolean m21709g(C0177j<String> jVar, int i) {
        if (i != C4672d._all) {
            return false;
        }
        synchronized (this) {
            this.bqb |= 4;
        }
        return true;
    }

    /* renamed from: h */
    private boolean m21710h(C0177j<Boolean> jVar, int i) {
        if (i != C4672d._all) {
            return false;
        }
        synchronized (this) {
            this.bqb |= 8;
        }
        return true;
    }

    /* renamed from: b */
    public void mo31991b(HomeTabLayoutModel homeTabLayoutModel) {
        this.cqV = homeTabLayoutModel;
        synchronized (this) {
            this.bqb |= 16;
        }
        notifyPropertyChanged(C4672d.tabLayoutModel);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:108:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0133  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x013f  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x014d  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0159  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r25 = this;
            r1 = r25
            monitor-enter(r25)
            long r2 = r1.bqb     // Catch:{ all -> 0x0164 }
            r4 = 0
            r1.bqb = r4     // Catch:{ all -> 0x0164 }
            monitor-exit(r25)     // Catch:{ all -> 0x0164 }
            com.introvd.template.app.homepage.hometab.HomeTabLayoutModel r0 = r1.cqV
            r6 = 63
            long r6 = r6 & r2
            r9 = 49
            r11 = 52
            r13 = 128(0x80, double:6.32E-322)
            r15 = 50
            r17 = 57
            r8 = 0
            r20 = 0
            int r6 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x00de
            long r6 = r2 & r15
            r15 = 1
            int r6 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x003c
            if (r0 == 0) goto L_0x002e
            android.databinding.j r6 = r0.getBgUrlField()
            goto L_0x0030
        L_0x002e:
            r6 = r20
        L_0x0030:
            r1.updateRegistration(r15, r6)
            if (r6 == 0) goto L_0x003c
            java.lang.Object r6 = r6.get()
            java.lang.String r6 = (java.lang.String) r6
            goto L_0x003e
        L_0x003c:
            r6 = r20
        L_0x003e:
            r21 = 61
            long r21 = r2 & r21
            int r7 = (r21 > r4 ? 1 : (r21 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x00d8
            if (r0 == 0) goto L_0x004d
            com.introvd.template.app.homepage.hometab.HomeTabModel r0 = r0.getVideoTabModel()
            goto L_0x004f
        L_0x004d:
            r0 = r20
        L_0x004f:
            long r21 = r2 & r17
            int r7 = (r21 > r4 ? 1 : (r21 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x00ab
            if (r0 == 0) goto L_0x005c
            android.databinding.j r7 = r0.getNewCountField()
            goto L_0x005e
        L_0x005c:
            r7 = r20
        L_0x005e:
            r1.updateRegistration(r8, r7)
            if (r7 == 0) goto L_0x006a
            java.lang.Object r7 = r7.get()
            java.lang.Integer r7 = (java.lang.Integer) r7
            goto L_0x006c
        L_0x006a:
            r7 = r20
        L_0x006c:
            int r7 = android.databinding.ViewDataBinding.safeUnbox(r7)
            long r21 = r2 & r9
            int r16 = (r21 > r4 ? 1 : (r21 == r4 ? 0 : -1))
            if (r16 == 0) goto L_0x0094
            java.lang.String r21 = com.introvd.template.app.community.p179a.C3756a.m9206gu(r7)
            if (r7 <= 0) goto L_0x007f
            r22 = 1
            goto L_0x0081
        L_0x007f:
            r22 = 0
        L_0x0081:
            if (r16 == 0) goto L_0x008e
            if (r22 == 0) goto L_0x008a
            r23 = 512(0x200, double:2.53E-321)
            long r2 = r2 | r23
            goto L_0x008e
        L_0x008a:
            r23 = 256(0x100, double:1.265E-321)
            long r2 = r2 | r23
        L_0x008e:
            if (r22 == 0) goto L_0x0091
            goto L_0x0096
        L_0x0091:
            r16 = 8
            goto L_0x0098
        L_0x0094:
            r21 = r20
        L_0x0096:
            r16 = 0
        L_0x0098:
            if (r7 > 0) goto L_0x009b
            goto L_0x009c
        L_0x009b:
            r15 = 0
        L_0x009c:
            long r22 = r2 & r17
            int r7 = (r22 > r4 ? 1 : (r22 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x00b0
            if (r15 == 0) goto L_0x00a6
            long r2 = r2 | r13
            goto L_0x00b0
        L_0x00a6:
            r22 = 64
            long r2 = r2 | r22
            goto L_0x00b0
        L_0x00ab:
            r21 = r20
            r15 = 0
            r16 = 0
        L_0x00b0:
            long r22 = r2 & r11
            int r7 = (r22 > r4 ? 1 : (r22 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x00d0
            if (r0 == 0) goto L_0x00bd
            android.databinding.j r7 = r0.getNameField()
            goto L_0x00bf
        L_0x00bd:
            r7 = r20
        L_0x00bf:
            r8 = 2
            r1.updateRegistration(r8, r7)
            if (r7 == 0) goto L_0x00d0
            java.lang.Object r7 = r7.get()
            java.lang.String r7 = (java.lang.String) r7
            r9 = r7
            r8 = r16
            r7 = r6
            goto L_0x00d5
        L_0x00d0:
            r7 = r6
            r8 = r16
            r9 = r20
        L_0x00d5:
            r6 = r21
            goto L_0x00e5
        L_0x00d8:
            r7 = r6
            r0 = r20
            r6 = r0
            r9 = r6
            goto L_0x00e3
        L_0x00de:
            r0 = r20
            r6 = r0
            r7 = r6
            r9 = r7
        L_0x00e3:
            r8 = 0
            r15 = 0
        L_0x00e5:
            long r13 = r13 & r2
            int r10 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r10 == 0) goto L_0x0101
            if (r0 == 0) goto L_0x00f1
            android.databinding.j r0 = r0.isNewField()
            goto L_0x00f3
        L_0x00f1:
            r0 = r20
        L_0x00f3:
            r10 = 3
            r1.updateRegistration(r10, r0)
            if (r0 == 0) goto L_0x0101
            java.lang.Object r0 = r0.get()
            r20 = r0
            java.lang.Boolean r20 = (java.lang.Boolean) r20
        L_0x0101:
            long r13 = r2 & r17
            int r0 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x012c
            if (r15 == 0) goto L_0x010e
            boolean r10 = r20.booleanValue()
            goto L_0x010f
        L_0x010e:
            r10 = 0
        L_0x010f:
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r10)
            boolean r10 = android.databinding.ViewDataBinding.safeUnbox(r10)
            if (r0 == 0) goto L_0x0122
            if (r10 == 0) goto L_0x011f
            r13 = 2048(0x800, double:1.0118E-320)
            long r2 = r2 | r13
            goto L_0x0122
        L_0x011f:
            r13 = 1024(0x400, double:5.06E-321)
            long r2 = r2 | r13
        L_0x0122:
            if (r10 == 0) goto L_0x0127
            r19 = 0
            goto L_0x0129
        L_0x0127:
            r19 = 8
        L_0x0129:
            r0 = r19
            goto L_0x012d
        L_0x012c:
            r0 = 0
        L_0x012d:
            long r13 = r2 & r17
            int r10 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r10 == 0) goto L_0x0138
            android.widget.ImageView r10 = r1.cqB
            r10.setVisibility(r0)
        L_0x0138:
            r13 = 50
            long r13 = r13 & r2
            int r0 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0147
            com.quvideo.mobile.component.imageview.DynamicLoadingImageView r0 = r1.cqD
            r10 = 17170443(0x106000b, float:2.4611944E-38)
            com.introvd.template.p310g.C7387z.m21768a(r0, r7, r10)
        L_0x0147:
            long r10 = r2 & r11
            int r0 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0152
            android.widget.TextView r0 = r1.cqQ
            android.databinding.p009a.C0165a.m348a(r0, r9)
        L_0x0152:
            r9 = 49
            long r2 = r2 & r9
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0163
            com.introvd.template.xyui.RoundedTextView r0 = r1.cqU
            android.databinding.p009a.C0165a.m348a(r0, r6)
            com.introvd.template.xyui.RoundedTextView r0 = r1.cqU
            r0.setVisibility(r8)
        L_0x0163:
            return
        L_0x0164:
            r0 = move-exception
            monitor-exit(r25)     // Catch:{ all -> 0x0164 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.p310g.C7355ab.executeBindings():void");
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.bqb != 0;
        }
    }

    public void invalidateAll() {
        synchronized (this) {
            this.bqb = 32;
        }
        requestRebind();
    }

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return m21707e((C0177j) obj, i2);
            case 1:
                return m21708f((C0177j) obj, i2);
            case 2:
                return m21709g((C0177j) obj, i2);
            case 3:
                return m21710h((C0177j) obj, i2);
            default:
                return false;
        }
    }

    public boolean setVariable(int i, Object obj) {
        if (C4672d.tabLayoutModel != i) {
            return false;
        }
        mo31991b((HomeTabLayoutModel) obj);
        return true;
    }
}
