package com.introvd.template.template.widget.p412a;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.support.p024v7.widget.LinearLayoutManager;
import android.support.p024v7.widget.RecyclerView;
import android.support.p024v7.widget.RecyclerView.C1022l;
import android.text.TextUtils;
import com.bignerdranch.expandablerecyclerview.C2133b.C2135a;
import com.introvd.template.common.Constants;
import com.introvd.template.crash.C5523b;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p203b.C4600l;
import com.introvd.template.sdk.model.template.TemplateInfo;
import com.introvd.template.template.p407e.C8735f;
import com.introvd.template.template.p409g.C8759b;
import com.introvd.template.template.widget.p412a.p413a.C8918a;
import com.introvd.template.template.widget.p412a.p413a.C8924d;
import com.introvd.template.template.widget.p412a.p413a.C8925e;
import com.introvd.template.template.widget.p412a.p413a.C8926f;
import com.introvd.template.template.widget.p412a.p413a.C8927g;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.introvd.template.template.widget.a.b */
public class C8928b implements C2135a {
    /* access modifiers changed from: private */

    /* renamed from: Vu */
    public RecyclerView f3616Vu;
    /* access modifiers changed from: private */
    public C8759b bOt;
    /* access modifiers changed from: private */
    public Context context;
    /* access modifiers changed from: private */
    public C8918a euA;
    /* access modifiers changed from: private */
    public boolean euB;
    /* access modifiers changed from: private */
    public int euC;
    private int euD = -1;
    /* access modifiers changed from: private */
    public int euE = -1;
    /* access modifiers changed from: private */
    public int euF = -1;
    /* access modifiers changed from: private */
    public C8926f euG;
    /* access modifiers changed from: private */
    public C8926f euH;
    /* access modifiers changed from: private */
    public C8925e euI;
    /* access modifiers changed from: private */
    public C8925e euJ;
    private List<C8927g> euK;
    /* access modifiers changed from: private */
    public C8935a euL;
    private C8927g euM;
    private C8917a euN;
    private Map<String, Integer> euO = new LinkedHashMap();
    private int euP = -1;
    /* access modifiers changed from: private */
    public LinearLayoutManager euz;
    private Handler handler = new Handler(Looper.getMainLooper());

    /* renamed from: com.introvd.template.template.widget.a.b$a */
    public interface C8935a {
        /* renamed from: Xs */
        void mo25960Xs();

        /* renamed from: a */
        void mo25961a(C8925e eVar);

        /* renamed from: a */
        void mo25962a(C8926f fVar);

        /* renamed from: b */
        void mo25963b(C8926f fVar);

        /* renamed from: c */
        void mo25964c(C8926f fVar);

        /* renamed from: jy */
        void mo25965jy(int i);
    }

    /* renamed from: com.introvd.template.template.widget.a.b$b */
    private class C8936b extends C1022l {
        private C8936b() {
        }

        /* renamed from: d */
        public void mo8096d(RecyclerView recyclerView, int i) {
            super.mo8096d(recyclerView, i);
            if (C8928b.this.euB && i == 0) {
                C8928b.this.euB = false;
                int i2 = C8928b.this.euC - C8928b.this.euz.findFirstVisibleItemPosition();
                if (i2 >= 0 && i2 < C8928b.this.f3616Vu.getChildCount()) {
                    if (C4580b.m11666qi()) {
                        C8928b.this.f3616Vu.smoothScrollBy(C8928b.this.f3616Vu.getChildAt(i2).getRight() - Constants.getScreenSize().width, 0);
                        return;
                    }
                    C8928b.this.f3616Vu.smoothScrollBy(C8928b.this.f3616Vu.getChildAt(i2).getLeft(), 0);
                }
            }
        }
    }

    public C8928b(Context context2) {
        this.context = context2;
    }

    /* access modifiers changed from: private */
    public boolean aMy() {
        for (C8927g aMU : this.euK) {
            if (aMU.aMU() == C8938d.STORE) {
                return true;
            }
        }
        return false;
    }

    private void adp() {
        if (!(this.euD == -1 || this.euA == null)) {
            this.euA.mo11790dJ(this.euD);
            ((C8927g) this.euA.mo11796tp().get(this.euD)).setExpanded(false);
        }
        this.euD = -1;
        this.euE = -1;
        this.euF = -1;
        this.euG = null;
        this.euI = null;
        this.euH = null;
    }

    /* renamed from: qK */
    private int m26232qK(String str) {
        if (this.euK != null && this.euK.size() > 0) {
            for (int i = 0; i < this.euK.size(); i++) {
                if (str.equals(((C8927g) this.euK.get(i)).aMR())) {
                    return i;
                }
            }
        }
        return 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: vo */
    public void m26233vo(int i) {
        this.euA.mo11797tq();
        if (this.euH != null) {
            this.euH.aMP().setExpanded(false);
            this.euA.mo11793dM(this.euH.getPosition());
        }
        this.euH = null;
        if (this.euE == -1) {
            return;
        }
        if (this.euF != -1) {
            int size = this.euA.mo11796tp().size();
            if (this.euE >= 0 && this.euE < size) {
                C8927g gVar = (C8927g) this.euA.mo11796tp().get(this.euE);
                if (gVar != null && gVar.getChildList() != null) {
                    int size2 = gVar.getChildList().size();
                    if (this.euF >= 0 && this.euF < size2) {
                        C8924d dVar = (C8924d) gVar.getChildList().get(this.euF);
                        if (dVar != null) {
                            dVar.setSelected(false);
                        }
                    }
                }
            }
        } else if (this.euE != i) {
            this.euG.aMP().setSelected(false);
            this.euA.mo11793dM(this.euE);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: vp */
    public void m26234vp(int i) {
        int findFirstVisibleItemPosition = this.euz.findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = this.euz.findLastVisibleItemPosition();
        if (i <= findFirstVisibleItemPosition) {
            this.f3616Vu.smoothScrollToPosition(i);
        } else if (i > findLastVisibleItemPosition) {
            this.f3616Vu.smoothScrollToPosition(i);
            this.euC = i;
            this.euB = true;
        } else if (C4580b.m11666qi()) {
            this.f3616Vu.smoothScrollBy(this.f3616Vu.getChildAt(i - findFirstVisibleItemPosition).getRight() - Constants.getScreenSize().width, 0);
        } else {
            this.f3616Vu.smoothScrollBy(this.f3616Vu.getChildAt(i - findFirstVisibleItemPosition).getLeft(), 0);
        }
    }

    /* renamed from: S */
    public void mo35551S(String str, int i) {
        if (str != null) {
            TemplateInfo qp = C8735f.aMf().mo35155qp(str);
            if (qp != null && this.euA != null) {
                int qK = m26232qK(str);
                ((C8927g) this.euA.mo11796tp().get(qK)).mo35550vz(i);
                if (this.f3616Vu != null && this.f3616Vu.getScrollState() == 0) {
                    this.euA.mo11793dM(qK);
                }
                this.euO.put(str, Integer.valueOf(i));
                if (i == -1) {
                    ((C8927g) this.euA.mo11796tp().get(qK)).mo35548vB(2);
                    if (this.euL != null) {
                        this.euL.mo25965jy(qK);
                    }
                    qp.nState = 6;
                    C8735f.aMf().mo35153qn(str);
                    this.euO.remove(str);
                } else if (i == -2) {
                    ((C8927g) this.euA.mo11796tp().get(qK)).mo35550vz(0);
                    ((C8927g) this.euA.mo11796tp().get(qK)).mo35548vB(0);
                    this.euA.mo11793dM(qK);
                    qp.nState = 1;
                    C8735f.aMf().mo35153qn(str);
                    this.euO.remove(str);
                }
            }
        }
    }

    /* renamed from: a */
    public void mo35552a(RecyclerView recyclerView, List<C8927g> list, C8759b bVar) {
        this.f3616Vu = recyclerView;
        this.euK = list;
        this.bOt = bVar;
        this.f3616Vu.mo7737a((C1022l) new C8936b());
        this.euz = new LinearLayoutManager(this.context, 0, false);
        this.f3616Vu.setLayoutManager(this.euz);
        this.euA = new C8918a(this.context, list);
        this.euA.mo11778a((C2135a) this);
        this.f3616Vu.setAdapter(this.euA);
        if (aMy()) {
            this.euE = 1;
            this.euG = new C8926f(1, (C8927g) list.get(1));
        } else {
            this.euE = 0;
            this.euG = new C8926f(0, (C8927g) list.get(0));
        }
        C8918a aVar = this.euA;
        C89291 r3 = new C8917a() {
            /* renamed from: Xs */
            public void mo35492Xs() {
                if (C8928b.this.euL != null) {
                    C8928b.this.euL.mo25960Xs();
                }
            }

            /* renamed from: a */
            public void mo35493a(C8925e eVar) {
                if (!C4580b.m11632Sf()) {
                    if (C8928b.this.euJ != null && C8928b.this.euJ.aMN().isSelected()) {
                        C8928b.this.euJ.aMO().aME();
                    }
                    C8928b.this.euJ = eVar;
                    C8928b.this.euJ.aMO().aMF();
                    if (C8928b.this.euL != null) {
                        C8928b.this.euL.mo25961a(eVar);
                    }
                }
            }

            /* renamed from: a */
            public void mo35494a(C8926f fVar) {
                if (C8928b.this.euA != null) {
                    C8928b.this.m26233vo(fVar.getPosition());
                    C8928b.this.euG = fVar;
                    C8928b.this.euI = null;
                    C8928b.this.euE = fVar.getPosition();
                    C8928b.this.euF = -1;
                    if (C8928b.this.euL != null) {
                        C8928b.this.euL.mo25962a(fVar);
                    }
                }
            }

            /* renamed from: b */
            public void mo35495b(C8926f fVar) {
                if (C8928b.this.euL != null) {
                    C8928b.this.euL.mo25963b(fVar);
                }
            }

            /* renamed from: bL */
            public Bitmap mo35496bL(long j) {
                return C8928b.this.bOt.mo35206bz(j);
            }

            /* renamed from: c */
            public void mo35497c(C8926f fVar) {
                if (C4600l.m11739k(C8928b.this.context, true) && C8928b.this.euL != null) {
                    C8928b.this.euL.mo25964c(fVar);
                }
            }

            /* renamed from: e */
            public void mo35498e(C8926f fVar) {
                if (C8928b.this.euH != null) {
                    C8928b.this.euH.aMP().setExpanded(false);
                    C8928b.this.euA.mo11793dM(C8928b.this.euH.getPosition());
                }
                fVar.aMP().setExpanded(true);
                int position = fVar.getPosition();
                if (position >= 0) {
                    C8928b.this.euA.mo11793dM(position);
                }
                C8928b.this.euH = fVar;
            }
        };
        this.euN = r3;
        aVar.mo35501a(r3);
    }

    /* renamed from: a */
    public void mo35553a(C8935a aVar) {
        this.euL = aVar;
    }

    public void aMw() {
        if (this.euK != null) {
            for (int i = 0; i < this.euK.size(); i++) {
                C8927g gVar = (C8927g) this.euK.get(i);
                if (!(gVar == null || gVar.aMR() == null)) {
                    gVar.mo35547vA(C8937c.m26266cO(this.context, gVar.aMR()));
                    if (this.euA != null) {
                        this.euA.mo11793dM(i);
                    }
                }
            }
        }
    }

    public void aMx() {
        if (!aMy() && this.euK != null && this.euK.size() > 0) {
            try {
                ((C8927g) this.euK.get(0)).setSelected(false);
                if (this.euI != null) {
                    if (this.euE != 1) {
                        ((C8927g) this.euK.get(this.euI.aML())).setExpanded(false);
                    }
                    if (this.euF != 0) {
                        ((C8924d) ((C8927g) this.euK.get(this.euI.aML())).getChildList().get(this.euI.aMM())).setSelected(false);
                    }
                }
                ((C8924d) ((C8927g) this.euK.get(1)).getChildList().get(0)).setSelected(true);
                this.euI = new C8925e(1, 0, (C8924d) ((C8927g) this.euK.get(1)).getChildList().get(0), null);
                this.euE = 1;
                this.euF = 0;
                this.euG = null;
                this.euM = (C8927g) this.euK.get(1);
                this.euH = new C8926f(1, (C8927g) this.euK.get(1));
                this.euA.mo11781a(this.euK, true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void aMz() {
        if (this.euE != -1 && this.euM != null) {
            if (this.euM.isExpanded()) {
                this.handler.postDelayed(new Runnable() {
                    public void run() {
                        if (!C8928b.this.aMy() || C8928b.this.euE > 1) {
                            C8928b.this.m26234vp(C8928b.this.euE);
                        } else {
                            C8928b.this.m26234vp(0);
                        }
                    }
                }, 500);
                return;
            }
            this.euA.mo11789dI(this.euE);
            ((C8927g) this.euA.mo11796tp().get(this.euE)).setExpanded(true);
            this.euA.mo11793dM(this.euE);
            this.handler.postDelayed(new Runnable() {
                public void run() {
                    C8928b.this.mo11800dO(C8928b.this.euE);
                }
            }, 300);
        }
    }

    /* renamed from: b */
    public void mo35557b(C8759b bVar) {
        this.bOt = bVar;
    }

    /* renamed from: bM */
    public void mo35558bM(long j) {
        for (int i = 0; i < this.euK.size(); i++) {
            if (this.euK.get(i) != null) {
                List childList = ((C8927g) this.euK.get(i)).getChildList();
                if (childList != null) {
                    int i2 = 0;
                    while (i2 < childList.size()) {
                        if (childList.get(i2) == null || ((C8924d) childList.get(i2)).aMI() != j) {
                            i2++;
                        } else {
                            mo35564vs(i);
                            return;
                        }
                    }
                    continue;
                } else {
                    continue;
                }
            }
        }
    }

    /* renamed from: dO */
    public void mo11800dO(final int i) {
        this.handler.postDelayed(new Runnable() {
            public void run() {
                if (!C8928b.this.aMy() || !(i == 0 || i == 1)) {
                    C8928b.this.m26234vp(i);
                } else {
                    C8928b.this.m26234vp(0);
                }
            }
        }, 500);
        if (i != this.euD) {
            if (!(this.euD == -1 || this.euA == null)) {
                this.euA.mo11790dJ(this.euD);
                ((C8927g) this.euA.mo11796tp().get(this.euD)).setExpanded(false);
            }
            this.euD = i;
        }
    }

    /* renamed from: dP */
    public void mo11801dP(int i) {
        ((C8927g) this.euA.mo11796tp().get(i)).setExpanded(false);
    }

    /* renamed from: e */
    public void mo35559e(List<C8927g> list, boolean z) {
        if (z) {
            adp();
        }
        this.euK = list;
        if (aMy()) {
            this.euE = 1;
            this.euG = new C8926f(1, (C8927g) list.get(1));
        } else {
            this.euE = 0;
            this.euG = new C8926f(0, (C8927g) list.get(0));
        }
        if (this.euA != null) {
            this.euA.mo11781a(list, !z);
        }
    }

    /* renamed from: qJ */
    public void mo35560qJ(String str) {
        if (str != null) {
            int qK = m26232qK(str);
            ((C8927g) this.euA.mo11796tp().get(qK)).mo35547vA(2);
            this.euA.mo11793dM(qK);
        }
    }

    /* renamed from: qL */
    public void mo35561qL(String str) {
        if (!TextUtils.isEmpty(str)) {
            int i = 0;
            while (true) {
                if (i >= this.euK.size()) {
                    break;
                } else if (str.equals(((C8927g) this.euK.get(i)).aMR())) {
                    mo35564vs(i);
                    break;
                } else {
                    i++;
                }
            }
        }
    }

    /* renamed from: vq */
    public void mo35562vq(int i) {
        if (i == 0) {
            if (this.euK != null && this.euK.size() > 0) {
                Iterator it = this.euK.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    C8927g gVar = (C8927g) it.next();
                    if (gVar.aMU() == C8938d.SINGLE) {
                        if (this.euG != null) {
                            int position = this.euG.getPosition();
                            if (position >= 0) {
                                ((C8927g) this.euK.get(position)).setSelected(false);
                            }
                        }
                        if (this.euI != null && this.euE >= 0) {
                            C8927g gVar2 = (C8927g) this.euK.get(this.euE);
                            gVar2.setExpanded(false);
                            List childList = gVar2.getChildList();
                            if (childList != null && this.euF >= 0 && this.euF < childList.size()) {
                                ((C8924d) childList.get(this.euF)).setSelected(false);
                            }
                        }
                        if (this.euH != null) {
                            int position2 = this.euH.getPosition();
                            if (position2 >= 0) {
                                ((C8927g) this.euK.get(position2)).setExpanded(false);
                            }
                        }
                        if (aMy()) {
                            ((C8927g) this.euK.get(1)).setSelected(true);
                            this.euG = new C8926f(1, gVar);
                            this.euE = 1;
                        } else {
                            ((C8927g) this.euK.get(0)).setSelected(true);
                            this.euG = new C8926f(0, gVar);
                            this.euE = 0;
                        }
                        this.euA.mo11797tq();
                        this.euF = -1;
                        this.euI = null;
                        this.euM = gVar;
                        this.euA.mo11781a(this.euK, true);
                    }
                }
            }
            return;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= this.euK.size()) {
                break;
            }
            C8927g gVar3 = (C8927g) this.euK.get(i2);
            List childList2 = gVar3.getChildList();
            int i3 = 0;
            while (i3 < childList2.size()) {
                C8924d dVar = (C8924d) childList2.get(i3);
                if (dVar == null || this.bOt == null || dVar.aMI() != this.bOt.mo35215vi(i)) {
                    i3++;
                } else {
                    if (aMy()) {
                        ((C8927g) this.euK.get(1)).setSelected(false);
                    } else {
                        ((C8927g) this.euK.get(0)).setSelected(false);
                    }
                    if (this.euI != null) {
                        int aML = this.euI.aML();
                        int aMM = this.euI.aMM();
                        if (aML >= 0 && aMM >= 0) {
                            C8927g gVar4 = (C8927g) this.euK.get(aML);
                            if (gVar4 != null) {
                                C8924d dVar2 = (gVar4.getChildList() == null || aMM >= gVar4.getChildList().size()) ? null : (C8924d) gVar4.getChildList().get(aMM);
                                if (this.euE != i2) {
                                    gVar4.setExpanded(false);
                                    if (dVar2 != null) {
                                        dVar2.setSelected(false);
                                    }
                                } else if (!(this.euF == i3 || dVar2 == null)) {
                                    dVar2.setSelected(false);
                                }
                            }
                        }
                    }
                    dVar.setSelected(true);
                    this.euI = new C8925e(i2, i3, dVar, null);
                    this.euE = i2;
                    this.euF = i3;
                    this.euG = null;
                    this.euM = gVar3;
                    this.euH = new C8926f(i2, gVar3);
                    this.euA.mo11781a(this.euK, true);
                }
            }
            i2++;
        }
    }

    /* renamed from: vr */
    public void mo35563vr(final int i) {
        if (this.euO.size() <= 1) {
            this.euA.mo11789dI(i);
            ((C8927g) this.euA.mo11796tp().get(i)).setExpanded(true);
            this.euA.mo11793dM(i);
            this.handler.postDelayed(new Runnable() {
                public void run() {
                    try {
                        C8928b.this.mo11800dO(i);
                    } catch (Exception e) {
                        C5523b.logException(e);
                    }
                }
            }, 300);
        }
    }

    /* renamed from: vs */
    public void mo35564vs(final int i) {
        this.euA.mo11789dI(i);
        ((C8927g) this.euA.mo11796tp().get(i)).setExpanded(true);
        this.euA.mo11793dM(i);
        this.handler.postDelayed(new Runnable() {
            public void run() {
                try {
                    C8928b.this.mo11800dO(i);
                } catch (Exception e) {
                    C5523b.logException(e);
                }
            }
        }, 300);
    }
}
