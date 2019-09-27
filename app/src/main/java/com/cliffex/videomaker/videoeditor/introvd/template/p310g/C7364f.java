package com.introvd.template.p310g;

import android.databinding.C0170e;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.introvd.template.C4672d;
import com.introvd.template.R;
import com.introvd.template.app.community.freeze.FreezeReasonPage.C3760a;
import com.introvd.template.xyui.RoundedTextView;

/* renamed from: com.introvd.template.g.f */
public class C7364f extends C7363e {
    private static final C0156b bpZ = null;
    private static final SparseIntArray bqa = new SparseIntArray();
    private long bqb;
    private final RelativeLayout coO;
    private final TextView coZ;
    private C7365a cpa;
    private C7366b cpb;
    private C7367c cpc;

    /* renamed from: com.introvd.template.g.f$a */
    public static class C7365a implements OnClickListener {
        private C3760a cpd;

        /* renamed from: b */
        public C7365a mo31997b(C3760a aVar) {
            this.cpd = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        public void onClick(View view) {
            this.cpd.mo23230bA(view);
        }
    }

    /* renamed from: com.introvd.template.g.f$b */
    public static class C7366b implements OnClickListener {
        private C3760a cpd;

        /* renamed from: c */
        public C7366b mo31999c(C3760a aVar) {
            this.cpd = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        public void onClick(View view) {
            this.cpd.mo23232bC(view);
        }
    }

    /* renamed from: com.introvd.template.g.f$c */
    public static class C7367c implements OnClickListener {
        private C3760a cpd;

        /* renamed from: d */
        public C7367c mo32001d(C3760a aVar) {
            this.cpd = aVar;
            if (aVar == null) {
                return null;
            }
            return this;
        }

        public void onClick(View view) {
            this.cpd.mo23231bB(view);
        }
    }

    static {
        bqa.put(R.id.layout_title, 5);
        bqa.put(R.id.img_freeze_reason, 6);
        bqa.put(R.id.tv_reason_title, 7);
        bqa.put(R.id.tv_reason_content, 8);
    }

    public C7364f(C0170e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 9, bpZ, bqa));
    }

    private C7364f(C0170e eVar, View view, Object[] objArr) {
        super(eVar, view, 0, (ImageView) objArr[1], (RoundedTextView) objArr[3], (ImageView) objArr[6], (RelativeLayout) objArr[5], (TextView) objArr[2], (TextView) objArr[8], (TextView) objArr[7]);
        this.bqb = -1;
        this.btnBack.setTag(null);
        this.coR.setTag(null);
        this.coO = objArr[0];
        this.coO.setTag(null);
        this.coZ = objArr[4];
        this.coZ.setTag(null);
        this.coU.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    /* renamed from: a */
    public void mo31993a(C3760a aVar) {
        this.coX = aVar;
        synchronized (this) {
            this.bqb |= 1;
        }
        notifyPropertyChanged(C4672d.clickHandler);
        super.requestRebind();
    }

    /* renamed from: dJ */
    public void mo31994dJ(boolean z) {
        this.coY = z;
        synchronized (this) {
            this.bqb |= 2;
        }
        notifyPropertyChanged(C4672d.isChina);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r20 = this;
            r1 = r20
            monitor-enter(r20)
            long r2 = r1.bqb     // Catch:{ all -> 0x00e4 }
            r4 = 0
            r1.bqb = r4     // Catch:{ all -> 0x00e4 }
            monitor-exit(r20)     // Catch:{ all -> 0x00e4 }
            com.introvd.template.app.community.freeze.FreezeReasonPage$a r0 = r1.coX
            boolean r6 = r1.coY
            java.lang.String r7 = r1.bDa
            r8 = 9
            long r10 = r2 & r8
            r12 = 0
            int r10 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r10 == 0) goto L_0x0052
            if (r0 == 0) goto L_0x0052
            com.introvd.template.g.f$a r10 = r1.cpa
            if (r10 != 0) goto L_0x0027
            com.introvd.template.g.f$a r10 = new com.introvd.template.g.f$a
            r10.<init>()
            r1.cpa = r10
            goto L_0x0029
        L_0x0027:
            com.introvd.template.g.f$a r10 = r1.cpa
        L_0x0029:
            com.introvd.template.g.f$a r10 = r10.mo31997b(r0)
            com.introvd.template.g.f$b r11 = r1.cpb
            if (r11 != 0) goto L_0x0039
            com.introvd.template.g.f$b r11 = new com.introvd.template.g.f$b
            r11.<init>()
            r1.cpb = r11
            goto L_0x003b
        L_0x0039:
            com.introvd.template.g.f$b r11 = r1.cpb
        L_0x003b:
            com.introvd.template.g.f$b r11 = r11.mo31999c(r0)
            com.introvd.template.g.f$c r13 = r1.cpc
            if (r13 != 0) goto L_0x004b
            com.introvd.template.g.f$c r13 = new com.introvd.template.g.f$c
            r13.<init>()
            r1.cpc = r13
            goto L_0x004d
        L_0x004b:
            com.introvd.template.g.f$c r13 = r1.cpc
        L_0x004d:
            com.introvd.template.g.f$c r0 = r13.mo32001d(r0)
            goto L_0x0055
        L_0x0052:
            r0 = r12
            r10 = r0
            r11 = r10
        L_0x0055:
            r13 = 10
            long r15 = r2 & r13
            r17 = 0
            int r15 = (r15 > r4 ? 1 : (r15 == r4 ? 0 : -1))
            if (r15 == 0) goto L_0x0070
            if (r15 == 0) goto L_0x006a
            if (r6 == 0) goto L_0x0067
            r15 = 512(0x200, double:2.53E-321)
            long r2 = r2 | r15
            goto L_0x006a
        L_0x0067:
            r15 = 256(0x100, double:1.265E-321)
            long r2 = r2 | r15
        L_0x006a:
            if (r6 == 0) goto L_0x006d
            goto L_0x0070
        L_0x006d:
            r6 = 8
            goto L_0x0071
        L_0x0070:
            r6 = 0
        L_0x0071:
            r15 = 12
            long r18 = r2 & r15
            int r18 = (r18 > r4 ? 1 : (r18 == r4 ? 0 : -1))
            if (r18 == 0) goto L_0x00b2
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r18 == 0) goto L_0x0092
            if (r7 == 0) goto L_0x008a
            r18 = 32
            long r2 = r2 | r18
            r18 = 128(0x80, double:6.32E-322)
            long r2 = r2 | r18
            goto L_0x0092
        L_0x008a:
            r18 = 16
            long r2 = r2 | r18
            r18 = 64
            long r2 = r2 | r18
        L_0x0092:
            if (r7 == 0) goto L_0x00a1
            android.widget.TextView r12 = r1.coU
            android.content.res.Resources r12 = r12.getResources()
            int r13 = com.introvd.template.R.string.xiaoying_str_community_freeze_device_notrans
        L_0x009c:
            java.lang.String r12 = r12.getString(r13)
            goto L_0x00aa
        L_0x00a1:
            android.widget.TextView r12 = r1.coU
            android.content.res.Resources r12 = r12.getResources()
            int r13 = com.introvd.template.R.string.xiaoying_str_community_freeze_account_notrans
            goto L_0x009c
        L_0x00aa:
            if (r7 == 0) goto L_0x00af
            r7 = 4
            r17 = 4
        L_0x00af:
            r7 = r17
            goto L_0x00b3
        L_0x00b2:
            r7 = 0
        L_0x00b3:
            long r8 = r8 & r2
            int r8 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r8 == 0) goto L_0x00c7
            android.widget.ImageView r8 = r1.btnBack
            r8.setOnClickListener(r0)
            com.introvd.template.xyui.RoundedTextView r0 = r1.coR
            r0.setOnClickListener(r10)
            android.widget.TextView r0 = r1.coZ
            r0.setOnClickListener(r11)
        L_0x00c7:
            long r8 = r2 & r15
            int r0 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00d7
            android.widget.ImageView r0 = r1.btnBack
            r0.setVisibility(r7)
            android.widget.TextView r0 = r1.coU
            android.databinding.p009a.C0165a.m348a(r0, r12)
        L_0x00d7:
            r7 = 10
            long r2 = r2 & r7
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00e3
            android.widget.TextView r0 = r1.coZ
            r0.setVisibility(r6)
        L_0x00e3:
            return
        L_0x00e4:
            r0 = move-exception
            monitor-exit(r20)     // Catch:{ all -> 0x00e4 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.p310g.C7364f.executeBindings():void");
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
        return false;
    }

    public void setAuid(String str) {
        this.bDa = str;
        synchronized (this) {
            this.bqb |= 4;
        }
        notifyPropertyChanged(C4672d.auid);
        super.requestRebind();
    }

    public boolean setVariable(int i, Object obj) {
        if (C4672d.clickHandler == i) {
            mo31993a((C3760a) obj);
        } else if (C4672d.isChina == i) {
            mo31994dJ(((Boolean) obj).booleanValue());
        } else if (C4672d.auid != i) {
            return false;
        } else {
            setAuid((String) obj);
        }
        return true;
    }
}
