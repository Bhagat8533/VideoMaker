package com.introvd.template.p310g;

import android.arch.lifecycle.C0069g;
import android.databinding.C0170e;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.introvd.template.C4672d;
import com.introvd.template.R;
import com.introvd.template.app.school.view.CreationEditorSubToolLayout;
import com.introvd.template.common.p236ui.banner.LoopViewPager;

/* renamed from: com.introvd.template.g.h */
public class C7369h extends C7368g {
    private static final C0156b bpZ = new C0156b(8);
    private static final SparseIntArray bqa = new SparseIntArray();
    private long bqb;
    private final LinearLayout cpk;
    private final LinearLayout cpl;

    static {
        bpZ.mo403a(1, new String[]{"app_include_creation_editor_main_item", "app_include_creation_editor_main_item"}, new int[]{2, 3}, new int[]{R.layout.app_include_creation_editor_main_item, R.layout.app_include_creation_editor_main_item});
        bqa.put(R.id.layoutBanner, 4);
        bqa.put(R.id.viewBanner, 5);
        bqa.put(R.id.layoutPagerDot, 6);
        bqa.put(R.id.layoutSubTool, 7);
    }

    public C7369h(C0170e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 8, bpZ, bqa));
    }

    private C7369h(C0170e eVar, View view, Object[] objArr) {
        super(eVar, view, 2, (FrameLayout) objArr[4], (C7370i) objArr[2], (C7370i) objArr[3], (LinearLayout) objArr[6], (CreationEditorSubToolLayout) objArr[7], (LoopViewPager) objArr[5]);
        this.bqb = -1;
        this.cpk = objArr[0];
        this.cpk.setTag(null);
        this.cpl = objArr[1];
        this.cpl.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    /* renamed from: a */
    private boolean m21727a(C7370i iVar, int i) {
        if (i != C4672d._all) {
            return false;
        }
        synchronized (this) {
            this.bqb |= 1;
        }
        return true;
    }

    /* renamed from: b */
    private boolean m21728b(C7370i iVar, int i) {
        if (i != C4672d._all) {
            return false;
        }
        synchronized (this) {
            this.bqb |= 2;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        synchronized (this) {
            long j = this.bqb;
            this.bqb = 0;
        }
        executeBindingsOn(this.cpf);
        executeBindingsOn(this.cpg);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
        if (r5.cpg.hasPendingBindings() == false) goto L_0x001f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0020, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r5.cpf.hasPendingBindings() == false) goto L_0x0016;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean hasPendingBindings() {
        /*
            r5 = this;
            monitor-enter(r5)
            long r0 = r5.bqb     // Catch:{ all -> 0x0021 }
            r2 = 0
            r4 = 1
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto L_0x000c
            monitor-exit(r5)     // Catch:{ all -> 0x0021 }
            return r4
        L_0x000c:
            monitor-exit(r5)     // Catch:{ all -> 0x0021 }
            com.introvd.template.g.i r0 = r5.cpf
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x0016
            return r4
        L_0x0016:
            com.introvd.template.g.i r0 = r5.cpg
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x001f
            return r4
        L_0x001f:
            r0 = 0
            return r0
        L_0x0021:
            r0 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x0021 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.p310g.C7369h.hasPendingBindings():boolean");
    }

    public void invalidateAll() {
        synchronized (this) {
            this.bqb = 4;
        }
        this.cpf.invalidateAll();
        this.cpg.invalidateAll();
        requestRebind();
    }

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return m21727a((C7370i) obj, i2);
            case 1:
                return m21728b((C7370i) obj, i2);
            default:
                return false;
        }
    }

    public void setLifecycleOwner(C0069g gVar) {
        super.setLifecycleOwner(gVar);
        this.cpf.setLifecycleOwner(gVar);
        this.cpg.setLifecycleOwner(gVar);
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }
}
