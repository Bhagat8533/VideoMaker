package com.introvd.template.editor.p261g;

import com.introvd.template.common.LogUtils;
import com.introvd.template.editor.common.C5837a;
import com.introvd.template.editor.p261g.p262a.C6307c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import p037b.p050b.C1843r;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1495b;

/* renamed from: com.introvd.template.editor.g.a */
public class C6293a {
    private static final String TAG = "a";
    private static C6293a cUS;
    private LinkedList<C6307c> cUT = new LinkedList<>();
    private LinkedList<C6307c> cUU = new LinkedList<>();
    private C6307c cUV;
    private C1495b cUW;
    private C1495b cUX;
    /* access modifiers changed from: private */
    public List<C6297b> cUY = new ArrayList();
    /* access modifiers changed from: private */
    public List<C6296a> cUZ = new ArrayList();
    private boolean initialized;

    /* renamed from: com.introvd.template.editor.g.a$a */
    public static abstract class C6296a {
        /* renamed from: a */
        public void mo27778a(boolean z, C6307c cVar, C6307c cVar2, boolean z2) {
        }
    }

    /* renamed from: com.introvd.template.editor.g.a$b */
    public static abstract class C6297b {
        /* renamed from: r */
        public void mo27739r(boolean z, boolean z2) {
        }
    }

    private C6293a() {
    }

    public static C6293a anj() {
        if (cUS == null) {
            cUS = new C6293a();
        }
        return cUS;
    }

    private void anq() {
        if (this.cUU.size() > 0) {
            Iterator it = this.cUU.iterator();
            while (it.hasNext()) {
                C6307c cVar = (C6307c) it.next();
                if (cVar.anv() != null) {
                    cVar.anv().release();
                }
            }
            this.cUU.clear();
        }
    }

    private void anr() {
        if (this.cUT.size() > 0) {
            Iterator it = this.cUT.iterator();
            while (it.hasNext()) {
                C6307c cVar = (C6307c) it.next();
                if (cVar.anv() != null) {
                    cVar.anv().release();
                }
            }
            this.cUT.clear();
        }
    }

    /* renamed from: b */
    private void m18010b(boolean z, C6307c cVar, C6307c cVar2, boolean z2) {
        if (this.cUX != null) {
            this.cUX.dispose();
        }
        C1843r aUa = C1487a.aUa();
        final boolean z3 = z;
        final C6307c cVar3 = cVar;
        final C6307c cVar4 = cVar2;
        final boolean z4 = z2;
        C62952 r1 = new Runnable() {
            public void run() {
                for (C6296a a : C6293a.this.cUZ) {
                    a.mo27778a(z3, cVar3, cVar4, z4);
                }
            }
        };
        this.cUX = aUa.mo10058o(r1);
    }

    /* renamed from: bb */
    private void m18011bb(List<C6307c> list) {
        if (list != null && list.size() != 0) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (((C6307c) it.next()).isVirtual()) {
                    it.remove();
                }
            }
        }
    }

    private void onDataChanged() {
        if (this.cUW != null) {
            this.cUW.dispose();
        }
        this.cUW = C1487a.aUa().mo10058o(new Runnable() {
            public void run() {
                for (C6297b r : C6293a.this.cUY) {
                    r.mo27739r(C6293a.this.ano(), C6293a.this.anp());
                }
            }
        });
    }

    /* renamed from: a */
    public void mo29234a(C6296a aVar) {
        this.cUZ.add(aVar);
    }

    /* renamed from: a */
    public void mo29235a(C6297b bVar) {
        this.cUY.add(bVar);
    }

    /* renamed from: a */
    public void mo29236a(C6307c cVar) {
        this.cUV = cVar;
        this.initialized = true;
    }

    /* renamed from: a */
    public void mo29237a(C6307c cVar, boolean z) {
        if (C5837a.agH().abi() && this.initialized) {
            if (!z) {
                try {
                    anq();
                } catch (CloneNotSupportedException e) {
                    LogUtils.m14222e(TAG, "insertPerform error:CloneNotSupportedException");
                    e.printStackTrace();
                }
            }
            C6307c anu = this.cUV.clone();
            if (!anu.isVirtual()) {
                anu.mo29276gc(z);
                this.cUT.push(anu);
            }
            this.cUV = cVar;
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("InsertPerform ,old:");
            sb.append(anu.anw());
            sb.append(",new :");
            sb.append(this.cUV.anw());
            sb.append(",isVirtual:");
            sb.append(z);
            LogUtils.m14222e(str, sb.toString());
            onDataChanged();
        }
    }

    public C6307c ank() {
        return this.cUV;
    }

    public C6307c anl() {
        C6307c cVar = (C6307c) this.cUT.peek();
        if (cVar == null || !cVar.isVirtual()) {
            return null;
        }
        return cVar;
    }

    public void anm() {
        C6307c cVar = (C6307c) this.cUT.peek();
        if (cVar != null && cVar.isVirtual()) {
            if (cVar.anv() != null) {
                cVar.anv().release();
            }
            cVar.mo29275d(this.cUV.anv());
            cVar.mo29276gc(false);
            this.cUV = cVar;
            this.cUT.pop();
            onDataChanged();
        }
    }

    public void ann() {
        C6307c cVar = (C6307c) this.cUT.peek();
        if (cVar != null && cVar.isVirtual()) {
            cVar.mo29276gc(false);
            anq();
            onDataChanged();
        }
    }

    public boolean ano() {
        if (this.cUT.size() > 0) {
            Iterator it = this.cUT.iterator();
            while (it.hasNext()) {
                if (!((C6307c) it.next()).isVirtual()) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean anp() {
        if (this.cUU.size() > 0) {
            Iterator it = this.cUU.iterator();
            while (it.hasNext()) {
                if (!((C6307c) it.next()).isVirtual()) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: b */
    public void mo29244b(C6296a aVar) {
        if (this.cUZ.contains(aVar)) {
            this.cUZ.remove(aVar);
        }
    }

    /* renamed from: b */
    public void mo29245b(C6297b bVar) {
        if (this.cUY.contains(bVar)) {
            this.cUY.remove(bVar);
        }
    }

    /* renamed from: b */
    public void mo29246b(C6307c cVar) {
        mo29237a(cVar, false);
    }

    /* renamed from: fZ */
    public void mo29247fZ(boolean z) {
        m18011bb(this.cUT);
        if (ano()) {
            this.cUU.push(this.cUV);
            this.cUV = (C6307c) this.cUT.pop();
            onDataChanged();
            m18010b(false, (C6307c) this.cUU.peek(), this.cUV, z);
            return;
        }
        onDataChanged();
    }

    /* renamed from: ga */
    public void mo29248ga(boolean z) {
        m18011bb(this.cUU);
        if (anp()) {
            this.cUT.push(this.cUV);
            this.cUV = (C6307c) this.cUU.pop();
            onDataChanged();
            m18010b(true, (C6307c) this.cUT.peek(), this.cUV, z);
            return;
        }
        onDataChanged();
    }

    public void unInit() {
        this.initialized = false;
        if (this.cUW != null) {
            this.cUW.dispose();
            this.cUW = null;
        }
        if (this.cUX != null) {
            this.cUX.dispose();
            this.cUX = null;
        }
        anr();
        anq();
        this.cUV = null;
        this.cUY.clear();
        this.cUZ.clear();
    }
}
