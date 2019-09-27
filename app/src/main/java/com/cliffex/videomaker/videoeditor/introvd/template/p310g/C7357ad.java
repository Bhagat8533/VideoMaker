package com.introvd.template.p310g;

import android.databinding.C0170e;
import android.databinding.C0177j;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import com.introvd.template.C4672d;
import com.introvd.template.R;
import com.introvd.template.app.homepage.hometab.HomeTabLayoutModel;

/* renamed from: com.introvd.template.g.ad */
public class C7357ad extends C7356ac {
    private static final C0156b bpZ = null;
    private static final SparseIntArray bqa = new SparseIntArray();
    private long bqb;
    private final RelativeLayout coO;

    static {
        bqa.put(R.id.tab_menu, 7);
        bqa.put(R.id.layout_fragment_creation, 8);
        bqa.put(R.id.img_creation, 9);
        bqa.put(R.id.text_creation, 10);
        bqa.put(R.id.layout_fragment_find, 11);
        bqa.put(R.id.img_find, 12);
        bqa.put(R.id.layout_fragment_message, 13);
        bqa.put(R.id.img_message, 14);
        bqa.put(R.id.text_message, 15);
        bqa.put(R.id.layout_fragment_studio, 16);
        bqa.put(R.id.img_studio, 17);
        bqa.put(R.id.text_studio, 18);
        bqa.put(R.id.imageview_content_focus_frame, 19);
    }

    public C7357ad(C0170e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 20, bpZ, bqa));
    }

    private C7357ad(C0170e eVar, View view, Object[] objArr) {
        super(eVar, view, 6, objArr[19], objArr[3], objArr[5], objArr[1], objArr[9], objArr[12], objArr[14], objArr[17], objArr[8], objArr[11], objArr[13], objArr[16], objArr[7], objArr[10], objArr[2], objArr[15], objArr[18], objArr[4], objArr[6]);
        this.bqb = -1;
        this.cqB.setTag(null);
        this.cqC.setTag(null);
        this.cqD.setTag(null);
        this.coO = objArr[0];
        this.coO.setTag(null);
        this.cqQ.setTag(null);
        this.cqU.setTag(null);
        this.cqW.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    /* renamed from: e */
    private boolean m21713e(C0177j<Integer> jVar, int i) {
        if (i != C4672d._all) {
            return false;
        }
        synchronized (this) {
            this.bqb |= 1;
        }
        return true;
    }

    /* renamed from: f */
    private boolean m21714f(C0177j<String> jVar, int i) {
        if (i != C4672d._all) {
            return false;
        }
        synchronized (this) {
            this.bqb |= 2;
        }
        return true;
    }

    /* renamed from: g */
    private boolean m21715g(C0177j<String> jVar, int i) {
        if (i != C4672d._all) {
            return false;
        }
        synchronized (this) {
            this.bqb |= 16;
        }
        return true;
    }

    /* renamed from: h */
    private boolean m21716h(C0177j<Boolean> jVar, int i) {
        if (i != C4672d._all) {
            return false;
        }
        synchronized (this) {
            this.bqb |= 32;
        }
        return true;
    }

    /* renamed from: i */
    private boolean m21717i(C0177j<Boolean> jVar, int i) {
        if (i != C4672d._all) {
            return false;
        }
        synchronized (this) {
            this.bqb |= 4;
        }
        return true;
    }

    /* renamed from: j */
    private boolean m21718j(C0177j<Integer> jVar, int i) {
        if (i != C4672d._all) {
            return false;
        }
        synchronized (this) {
            this.bqb |= 8;
        }
        return true;
    }

    /* renamed from: b */
    public void mo31992b(HomeTabLayoutModel homeTabLayoutModel) {
        this.cqV = homeTabLayoutModel;
        synchronized (this) {
            this.bqb |= 64;
        }
        notifyPropertyChanged(C4672d.tabLayoutModel);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0169  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0188  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x01a5  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x01d1  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x01f3  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x01fa  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x0205  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x0210  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x021f  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x022b  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x023c  */
    /* JADX WARNING: Removed duplicated region for block: B:172:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0110  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0151  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r35 = this;
            r1 = r35
            monitor-enter(r35)
            long r2 = r1.bqb     // Catch:{ all -> 0x0247 }
            r4 = 0
            r1.bqb = r4     // Catch:{ all -> 0x0247 }
            monitor-exit(r35)     // Catch:{ all -> 0x0247 }
            com.introvd.template.app.homepage.hometab.HomeTabLayoutModel r0 = r1.cqV
            r6 = 255(0xff, double:1.26E-321)
            long r6 = r6 & r2
            r8 = 193(0xc1, double:9.54E-322)
            r12 = 200(0xc8, double:9.9E-322)
            r16 = 32768(0x8000, double:1.61895E-319)
            r18 = 194(0xc2, double:9.6E-322)
            r20 = 8
            r21 = 225(0xe1, double:1.11E-321)
            r23 = 204(0xcc, double:1.01E-321)
            r25 = 0
            r10 = 0
            int r6 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x0157
            long r6 = r2 & r18
            r11 = 1
            int r6 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x0041
            if (r0 == 0) goto L_0x0033
            android.databinding.j r6 = r0.getBgUrlField()
            goto L_0x0035
        L_0x0033:
            r6 = r25
        L_0x0035:
            r1.updateRegistration(r11, r6)
            if (r6 == 0) goto L_0x0041
            java.lang.Object r6 = r6.get()
            java.lang.String r6 = (java.lang.String) r6
            goto L_0x0043
        L_0x0041:
            r6 = r25
        L_0x0043:
            long r28 = r2 & r23
            int r7 = (r28 > r4 ? 1 : (r28 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x00ae
            if (r0 == 0) goto L_0x0050
            com.introvd.template.app.homepage.hometab.HomeTabModel r7 = r0.getMsgTabModel()
            goto L_0x0052
        L_0x0050:
            r7 = r25
        L_0x0052:
            if (r7 == 0) goto L_0x005b
            android.databinding.j r28 = r7.getNewCountField()
            r11 = r28
            goto L_0x005d
        L_0x005b:
            r11 = r25
        L_0x005d:
            r14 = 3
            r1.updateRegistration(r14, r11)
            if (r11 == 0) goto L_0x006a
            java.lang.Object r11 = r11.get()
            java.lang.Integer r11 = (java.lang.Integer) r11
            goto L_0x006c
        L_0x006a:
            r11 = r25
        L_0x006c:
            int r11 = android.databinding.ViewDataBinding.safeUnbox(r11)
            long r14 = r2 & r12
            int r14 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r14 == 0) goto L_0x0096
            java.lang.String r15 = com.introvd.template.app.community.p179a.C3756a.m9206gu(r11)
            if (r11 <= 0) goto L_0x007f
            r28 = 1
            goto L_0x0081
        L_0x007f:
            r28 = 0
        L_0x0081:
            if (r14 == 0) goto L_0x0090
            if (r28 == 0) goto L_0x008b
            r33 = 524288(0x80000, double:2.590327E-318)
            long r2 = r2 | r33
            goto L_0x0090
        L_0x008b:
            r33 = 262144(0x40000, double:1.295163E-318)
            long r2 = r2 | r33
        L_0x0090:
            if (r28 == 0) goto L_0x0093
            goto L_0x0098
        L_0x0093:
            r14 = 8
            goto L_0x0099
        L_0x0096:
            r15 = r25
        L_0x0098:
            r14 = 0
        L_0x0099:
            if (r11 > 0) goto L_0x009d
            r11 = 1
            goto L_0x009e
        L_0x009d:
            r11 = 0
        L_0x009e:
            long r28 = r2 & r23
            int r28 = (r28 > r4 ? 1 : (r28 == r4 ? 0 : -1))
            if (r28 == 0) goto L_0x00b3
            if (r11 == 0) goto L_0x00a9
            long r2 = r2 | r16
            goto L_0x00b3
        L_0x00a9:
            r28 = 16384(0x4000, double:8.0948E-320)
            long r2 = r2 | r28
            goto L_0x00b3
        L_0x00ae:
            r7 = r25
            r15 = r7
            r11 = 0
            r14 = 0
        L_0x00b3:
            r28 = 241(0xf1, double:1.19E-321)
            long r28 = r2 & r28
            int r28 = (r28 > r4 ? 1 : (r28 == r4 ? 0 : -1))
            if (r28 == 0) goto L_0x0151
            if (r0 == 0) goto L_0x00c2
            com.introvd.template.app.homepage.hometab.HomeTabModel r0 = r0.getVideoTabModel()
            goto L_0x00c4
        L_0x00c2:
            r0 = r25
        L_0x00c4:
            long r28 = r2 & r21
            int r28 = (r28 > r4 ? 1 : (r28 == r4 ? 0 : -1))
            if (r28 == 0) goto L_0x0129
            if (r0 == 0) goto L_0x00d3
            android.databinding.j r28 = r0.getNewCountField()
            r12 = r28
            goto L_0x00d5
        L_0x00d3:
            r12 = r25
        L_0x00d5:
            r1.updateRegistration(r10, r12)
            if (r12 == 0) goto L_0x00e1
            java.lang.Object r12 = r12.get()
            java.lang.Integer r12 = (java.lang.Integer) r12
            goto L_0x00e3
        L_0x00e1:
            r12 = r25
        L_0x00e3:
            int r12 = android.databinding.ViewDataBinding.safeUnbox(r12)
            long r28 = r2 & r8
            int r13 = (r28 > r4 ? 1 : (r28 == r4 ? 0 : -1))
            if (r13 == 0) goto L_0x010b
            java.lang.String r28 = com.introvd.template.app.community.p179a.C3756a.m9206gu(r12)
            if (r12 <= 0) goto L_0x00f6
            r29 = 1
            goto L_0x00f8
        L_0x00f6:
            r29 = 0
        L_0x00f8:
            if (r13 == 0) goto L_0x0105
            if (r29 == 0) goto L_0x0101
            r33 = 8192(0x2000, double:4.0474E-320)
            long r2 = r2 | r33
            goto L_0x0105
        L_0x0101:
            r33 = 4096(0x1000, double:2.0237E-320)
            long r2 = r2 | r33
        L_0x0105:
            if (r29 == 0) goto L_0x0108
            goto L_0x010d
        L_0x0108:
            r13 = 8
            goto L_0x010e
        L_0x010b:
            r28 = r25
        L_0x010d:
            r13 = 0
        L_0x010e:
            if (r12 > 0) goto L_0x0113
            r30 = 1
            goto L_0x0115
        L_0x0113:
            r30 = 0
        L_0x0115:
            long r33 = r2 & r21
            int r12 = (r33 > r4 ? 1 : (r33 == r4 ? 0 : -1))
            if (r12 == 0) goto L_0x0126
            if (r30 == 0) goto L_0x0122
            r31 = 2048(0x800, double:1.0118E-320)
            long r2 = r2 | r31
            goto L_0x0126
        L_0x0122:
            r33 = 1024(0x400, double:5.06E-321)
            long r2 = r2 | r33
        L_0x0126:
            r26 = 208(0xd0, double:1.03E-321)
            goto L_0x0130
        L_0x0129:
            r28 = r25
            r13 = 0
            r26 = 208(0xd0, double:1.03E-321)
            r30 = 0
        L_0x0130:
            long r33 = r2 & r26
            int r12 = (r33 > r4 ? 1 : (r33 == r4 ? 0 : -1))
            if (r12 == 0) goto L_0x014c
            if (r0 == 0) goto L_0x013d
            android.databinding.j r12 = r0.getNameField()
            goto L_0x013f
        L_0x013d:
            r12 = r25
        L_0x013f:
            r10 = 4
            r1.updateRegistration(r10, r12)
            if (r12 == 0) goto L_0x014c
            java.lang.Object r10 = r12.get()
            java.lang.String r10 = (java.lang.String) r10
            goto L_0x014e
        L_0x014c:
            r10 = r25
        L_0x014e:
            r12 = r28
            goto L_0x0163
        L_0x0151:
            r0 = r25
            r10 = r0
            r12 = r10
            r13 = 0
            goto L_0x0161
        L_0x0157:
            r0 = r25
            r6 = r0
            r7 = r6
            r10 = r7
            r12 = r10
            r15 = r12
            r11 = 0
            r13 = 0
            r14 = 0
        L_0x0161:
            r30 = 0
        L_0x0163:
            long r16 = r2 & r16
            int r16 = (r16 > r4 ? 1 : (r16 == r4 ? 0 : -1))
            if (r16 == 0) goto L_0x017f
            if (r7 == 0) goto L_0x0170
            android.databinding.j r7 = r7.isNewField()
            goto L_0x0172
        L_0x0170:
            r7 = r25
        L_0x0172:
            r8 = 2
            r1.updateRegistration(r8, r7)
            if (r7 == 0) goto L_0x017f
            java.lang.Object r7 = r7.get()
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            goto L_0x0181
        L_0x017f:
            r7 = r25
        L_0x0181:
            r8 = 2048(0x800, double:1.0118E-320)
            long r8 = r8 & r2
            int r8 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r8 == 0) goto L_0x019f
            if (r0 == 0) goto L_0x018f
            android.databinding.j r0 = r0.isNewField()
            goto L_0x0191
        L_0x018f:
            r0 = r25
        L_0x0191:
            r8 = 5
            r1.updateRegistration(r8, r0)
            if (r0 == 0) goto L_0x019f
            java.lang.Object r0 = r0.get()
            r25 = r0
            java.lang.Boolean r25 = (java.lang.Boolean) r25
        L_0x019f:
            long r8 = r2 & r21
            int r0 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x01ca
            if (r30 == 0) goto L_0x01ac
            boolean r8 = r25.booleanValue()
            goto L_0x01ad
        L_0x01ac:
            r8 = 0
        L_0x01ad:
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)
            boolean r8 = android.databinding.ViewDataBinding.safeUnbox(r8)
            if (r0 == 0) goto L_0x01c4
            if (r8 == 0) goto L_0x01bf
            r16 = 131072(0x20000, double:6.47582E-319)
            long r2 = r2 | r16
            goto L_0x01c4
        L_0x01bf:
            r16 = 65536(0x10000, double:3.2379E-319)
            long r2 = r2 | r16
        L_0x01c4:
            if (r8 == 0) goto L_0x01c7
            goto L_0x01ca
        L_0x01c7:
            r0 = 8
            goto L_0x01cb
        L_0x01ca:
            r0 = 0
        L_0x01cb:
            long r8 = r2 & r23
            int r8 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r8 == 0) goto L_0x01f3
            if (r11 == 0) goto L_0x01d8
            boolean r7 = r7.booleanValue()
            goto L_0x01d9
        L_0x01d8:
            r7 = 0
        L_0x01d9:
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)
            boolean r7 = android.databinding.ViewDataBinding.safeUnbox(r7)
            if (r8 == 0) goto L_0x01ec
            if (r7 == 0) goto L_0x01e9
            r8 = 512(0x200, double:2.53E-321)
            long r2 = r2 | r8
            goto L_0x01ec
        L_0x01e9:
            r8 = 256(0x100, double:1.265E-321)
            long r2 = r2 | r8
        L_0x01ec:
            if (r7 == 0) goto L_0x01f0
            r20 = 0
        L_0x01f0:
            r7 = r20
            goto L_0x01f4
        L_0x01f3:
            r7 = 0
        L_0x01f4:
            long r8 = r2 & r21
            int r8 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r8 == 0) goto L_0x01ff
            android.widget.ImageView r8 = r1.cqB
            r8.setVisibility(r0)
        L_0x01ff:
            long r8 = r2 & r23
            int r0 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x020a
            android.widget.ImageView r0 = r1.cqC
            r0.setVisibility(r7)
        L_0x020a:
            long r7 = r2 & r18
            int r0 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0218
            com.quvideo.mobile.component.imageview.DynamicLoadingImageView r0 = r1.cqD
            r7 = 17170443(0x106000b, float:2.4611944E-38)
            com.introvd.template.p310g.C7387z.m21768a(r0, r6, r7)
        L_0x0218:
            r6 = 208(0xd0, double:1.03E-321)
            long r6 = r6 & r2
            int r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0224
            android.widget.TextView r0 = r1.cqQ
            android.databinding.p009a.C0165a.m348a(r0, r10)
        L_0x0224:
            r6 = 193(0xc1, double:9.54E-322)
            long r6 = r6 & r2
            int r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0235
            com.introvd.template.xyui.RoundedTextView r0 = r1.cqU
            android.databinding.p009a.C0165a.m348a(r0, r12)
            com.introvd.template.xyui.RoundedTextView r0 = r1.cqU
            r0.setVisibility(r13)
        L_0x0235:
            r6 = 200(0xc8, double:9.9E-322)
            long r2 = r2 & r6
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0246
            com.introvd.template.xyui.RoundedTextView r0 = r1.cqW
            android.databinding.p009a.C0165a.m348a(r0, r15)
            com.introvd.template.xyui.RoundedTextView r0 = r1.cqW
            r0.setVisibility(r14)
        L_0x0246:
            return
        L_0x0247:
            r0 = move-exception
            monitor-exit(r35)     // Catch:{ all -> 0x0247 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.p310g.C7357ad.executeBindings():void");
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.bqb != 0;
        }
    }

    public void invalidateAll() {
        synchronized (this) {
            this.bqb = 128;
        }
        requestRebind();
    }

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return m21713e((C0177j) obj, i2);
            case 1:
                return m21714f((C0177j) obj, i2);
            case 2:
                return m21717i((C0177j) obj, i2);
            case 3:
                return m21718j((C0177j) obj, i2);
            case 4:
                return m21715g((C0177j) obj, i2);
            case 5:
                return m21716h((C0177j) obj, i2);
            default:
                return false;
        }
    }

    public boolean setVariable(int i, Object obj) {
        if (C4672d.tabLayoutModel != i) {
            return false;
        }
        mo31992b((HomeTabLayoutModel) obj);
        return true;
    }
}
