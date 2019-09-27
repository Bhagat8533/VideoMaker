package com.introvd.template.module.iap.business;

import android.content.Context;
import android.text.TextUtils;
import com.introvd.template.module.iap.C8048e;
import com.introvd.template.module.iap.R;
import com.introvd.template.module.iap.business.home.C7958a;
import com.introvd.template.module.iap.business.home.C7958a.C7959a;
import com.introvd.template.module.iap.business.home.C7958a.C7960b;
import com.introvd.template.module.iap.business.p349a.C7832c;
import com.introvd.template.module.iap.p341b.C7738c;
import com.introvd.template.module.p338b.C7686a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.introvd.template.module.iap.business.e */
class C7894e {
    private Map<String, C7896b> dPU;
    private List<C7896b> dPV;

    /* renamed from: com.introvd.template.module.iap.business.e$a */
    private class C7895a extends C7896b {
        /* access modifiers changed from: private */
        public boolean[] dPW = new boolean[2];
        /* access modifiers changed from: private */
        public boolean dPX;
        /* access modifiers changed from: private */
        public boolean dPY;
        /* access modifiers changed from: private */
        public String labelName;

        C7895a(String str, String str2, String str3) {
            super(str, str2, str3);
            mo32849C(true, true);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: C */
        public void mo32849C(boolean z, boolean z2) {
            this.dPW = new boolean[]{z, z2};
        }
    }

    /* renamed from: com.introvd.template.module.iap.business.e$b */
    static class C7896b implements Comparable<C7896b> {
        String dQa;
        String dQb;

        /* renamed from: id */
        String f3560id;
        String label;
        int order;
        String title;

        C7896b(String str, String str2, String str3) {
            this.f3560id = str;
            this.title = str2;
            this.dQa = str3;
        }

        /* renamed from: a */
        public int compareTo(C7896b bVar) {
            return this.order - bVar.order;
        }
    }

    C7894e() {
    }

    /* renamed from: a */
    private void m22994a(C7896b bVar, int i) {
        Context context = C8048e.aBe().getContext();
        if (bVar != null) {
            ((C7895a) bVar).labelName = context.getString(i);
        }
    }

    private int aBR() {
        if (!mo32840kR(C7959a.dTk)) {
            return 0;
        }
        int kS = m22997kS(C7959a.dTk);
        if (kS > 2 || kS < 0) {
            kS = 0;
        }
        return kS;
    }

    /* renamed from: cf */
    private void m22995cf(List<C7896b> list) {
        int i = 0;
        while (list != null && i < list.size()) {
            if (list.get(i) != null) {
                String str = null;
                C7896b bVar = (C7896b) list.get(i);
                String str2 = bVar.f3560id;
                if (C7960b.dTk.equals(str2)) {
                    str = C7959a.dTk;
                    m22994a(bVar, R.string.xiaoying_str_vip_domestic_subscription_goods);
                } else if (C7960b.dTl.equals(str2)) {
                    ((C7895a) bVar).mo32849C(true, C7686a.aAN());
                    str = C7959a.dTl;
                    m22994a(bVar, R.string.xiaoying_str_vip_domestic_subscription_quarter_goods);
                } else if (C7960b.dTm.equals(str2)) {
                    ((C7895a) bVar).mo32849C(true, C7686a.aAN());
                    str = C7959a.dTm;
                    m22994a(bVar, R.string.xiaoying_str_vip_domestic_subscription_yearly_goods);
                }
                if (this.dPU == null) {
                    this.dPU = new HashMap();
                }
                if (str != null) {
                    this.dPU.put(str, list.get(i));
                }
            }
            i++;
        }
    }

    /* renamed from: cg */
    private List<C7896b> m22996cg(List<C7832c> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null || list.isEmpty()) {
            return arrayList;
        }
        for (C7832c cVar : list) {
            if (cVar != null) {
                C7895a aVar = new C7895a(cVar.getId(), cVar.getName(), cVar.mo32756sp());
                aVar.order = cVar.getOrder();
                aVar.label = cVar.getLabel();
                if (cVar.aCE() < cVar.aCA() && cVar.aCA() > 0) {
                    aVar.dQb = cVar.aCB();
                }
                if (C7958a.m23118lx(aVar.f3560id)) {
                    aVar.dPX = true;
                }
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    /* renamed from: kS */
    private int m22997kS(String str) {
        if (str == null) {
            return 0;
        }
        int i = 0;
        while (this.dPV != null && i < this.dPV.size()) {
            if (str.equals(((C7896b) this.dPV.get(i)).f3560id)) {
                return i;
            }
            i++;
        }
        return 0;
    }

    /* access modifiers changed from: 0000 */
    public int getSize() {
        if (this.dPV == null) {
            return 3;
        }
        return this.dPV.size();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: k */
    public String mo32833k(Context context, String str, boolean z) {
        if (z) {
            return context.getString(R.string.xiaoying_str_continuous_subscribe_notice);
        }
        C7896b kP = mo32838kP(str);
        if (kP == null) {
            return null;
        }
        C7832c cVar = (C7832c) C7738c.aEv().aNw().mo35913ri(kP.f3560id);
        C7832c cVar2 = (C7832c) C7738c.aEv().aNw().mo35913ri(str);
        if (cVar == null || cVar2 == null) {
            return null;
        }
        long aCE = (cVar2.aCE() - cVar.aCE()) / 100;
        if (aCE <= 0) {
            return context.getString(R.string.xiaoying_str_iap_subs_tip_offer, new Object[]{kP.title});
        }
        return context.getString(R.string.xiaoying_str_iap_subs_tip_normal, new Object[]{kP.title, String.valueOf(aCE)});
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: kL */
    public String mo32834kL(String str) {
        C7896b bVar = (C7896b) this.dPU.get(str);
        if (bVar == null) {
            bVar = mo32835kM(str);
        }
        return bVar != null ? ((C7895a) bVar).labelName : C8048e.aBe().getContext().getString(R.string.xiaoying_str_vip_domestic_subscription_goods);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: kM */
    public C7896b mo32835kM(String str) {
        if (this.dPV != null) {
            return (C7896b) this.dPV.get(m22997kS(str));
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: kN */
    public C7896b mo32836kN(String str) {
        C7896b kM = mo32835kM(str);
        if (kM == null || !((C7895a) kM).dPX) {
            return kM;
        }
        C7896b kP = mo32838kP(kM.f3560id);
        return kP == null ? kM : kP;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: kO */
    public String mo32837kO(String str) {
        C7896b kN = mo32836kN(str);
        return kN != null ? kN.f3560id : str;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: kP */
    public C7896b mo32838kP(String str) {
        return (C7896b) this.dPU.get(str);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: kQ */
    public boolean mo32839kQ(String str) {
        C7896b kM = mo32835kM(str);
        if (kM != null) {
            return ((C7895a) kM).dPX;
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: kR */
    public boolean mo32840kR(String str) {
        return mo32838kP(str) != null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: kT */
    public int mo32841kT(String str) {
        int i;
        if (TextUtils.isEmpty(str)) {
            return aBR();
        }
        C7896b bVar = null;
        if (this.dPU != null) {
            Iterator it = this.dPU.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String str2 = (String) it.next();
                C7896b bVar2 = (C7896b) this.dPU.get(str2);
                if (bVar2 != null && bVar2.f3560id.equals(str)) {
                    bVar = mo32835kM(str2);
                    break;
                }
            }
        }
        if (bVar != null) {
            ((C7895a) bVar).dPX = true;
            i = m22997kS(bVar.f3560id);
        } else {
            int kS = m22997kS(str);
            C7895a aVar = (C7895a) mo32835kM(str);
            if (aVar != null) {
                aVar.dPX = false;
            }
            i = kS;
        }
        if (i > 2 || i < 0) {
            i = aBR();
        }
        return i;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: kU */
    public boolean mo32842kU(String str) {
        C7895a aVar = (C7895a) mo32835kM(str);
        if (aVar != null) {
            return aVar.dPY;
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: kV */
    public boolean[] mo32843kV(String str) {
        C7896b kN = mo32836kN(str);
        if (kN != null) {
            return ((C7895a) kN).dPW;
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: r */
    public void mo32844r(String str, boolean z) {
        C7895a aVar = (C7895a) mo32835kM(str);
        if (aVar != null) {
            aVar.dPX = z;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: s */
    public void mo32845s(String str, boolean z) {
        C7895a aVar = (C7895a) mo32835kM(str);
        if (aVar != null) {
            aVar.dPY = z;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: sl */
    public C7896b mo32846sl(int i) {
        if (this.dPV != null && i < this.dPV.size()) {
            return (C7896b) this.dPV.get(i);
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: sm */
    public String mo32847sm(int i) {
        C7896b sl = mo32846sl(i);
        if (sl != null) {
            return sl.f3560id;
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    public void update() {
        this.dPV = m22996cg(C7738c.aEv().aNw().mo35914wS());
        Collections.sort(this.dPV);
        m22995cf(this.dPV);
    }
}
