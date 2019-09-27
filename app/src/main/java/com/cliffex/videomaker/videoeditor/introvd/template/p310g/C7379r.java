package com.introvd.template.p310g;

import android.databinding.C0170e;
import android.databinding.p009a.C0165a;
import android.support.constraint.ConstraintLayout;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import com.introvd.template.C4672d;
import com.introvd.template.R;
import com.introvd.template.app.school.api.model.TemplateInfo;
import com.introvd.template.app.school.testa.C4246b;
import com.introvd.template.p322l.p323a.C7557a;
import com.introvd.template.p322l.p323a.C7557a.C7558a;
import java.util.List;

/* renamed from: com.introvd.template.g.r */
public class C7379r extends C7378q implements C7558a {
    private static final C0156b bpZ = null;
    private static final SparseIntArray bqa = new SparseIntArray();
    private long bqb;
    private final ConstraintLayout cpq;
    private final OnClickListener cqm;
    private final OnClickListener cqn;
    private final OnClickListener cqo;
    private final OnClickListener cqp;

    static {
        bqa.put(R.id.btnMore, 26);
        bqa.put(R.id.viewDivider, 27);
    }

    public C7379r(C0170e eVar, View view) {
        this(eVar, view, mapBindings(eVar, view, 28, bpZ, bqa));
    }

    private C7379r(C0170e eVar, View view, Object[] objArr) {
        super(eVar, view, 0, objArr[26], objArr[2], objArr[3], objArr[8], objArr[9], objArr[14], objArr[15], objArr[16], objArr[17], objArr[6], objArr[7], objArr[12], objArr[13], objArr[4], objArr[5], objArr[10], objArr[11], objArr[1], objArr[19], objArr[21], objArr[23], objArr[25], objArr[27], objArr[18], objArr[20], objArr[22], objArr[24]);
        this.bqb = -1;
        this.cpM.setTag(null);
        this.cpN.setTag(null);
        this.cpO.setTag(null);
        this.cpP.setTag(null);
        this.cpq = objArr[0];
        this.cpq.setTag(null);
        this.cpQ.setTag(null);
        this.cpR.setTag(null);
        this.cpS.setTag(null);
        this.cpT.setTag(null);
        this.cpU.setTag(null);
        this.cpV.setTag(null);
        this.cpW.setTag(null);
        this.cpX.setTag(null);
        this.cpY.setTag(null);
        this.cpZ.setTag(null);
        this.cqa.setTag(null);
        this.cqb.setTag(null);
        this.bAk.setTag(null);
        this.cqc.setTag(null);
        this.cqd.setTag(null);
        this.cqe.setTag(null);
        this.cqf.setTag(null);
        this.cqg.setTag(null);
        this.cqh.setTag(null);
        this.cqi.setTag(null);
        this.cqj.setTag(null);
        setRootTag(view);
        this.cqm = new C7557a(this, 2);
        this.cqn = new C7557a(this, 1);
        this.cqo = new C7557a(this, 4);
        this.cqp = new C7557a(this, 3);
        invalidateAll();
    }

    public final void _internalCallbackOnClick(int i, View view) {
        boolean z = false;
        boolean z2 = true;
        switch (i) {
            case 1:
                List list = this.cql;
                C4246b bVar = this.cqk;
                if (bVar == null) {
                    z2 = false;
                }
                if (z2) {
                    bVar.mo24239a(view, list, 0);
                    return;
                }
                return;
            case 2:
                List list2 = this.cql;
                C4246b bVar2 = this.cqk;
                if (bVar2 != null) {
                    z = true;
                }
                if (z) {
                    bVar2.mo24239a(view, list2, 1);
                    return;
                }
                return;
            case 3:
                List list3 = this.cql;
                C4246b bVar3 = this.cqk;
                if (bVar3 != null) {
                    z = true;
                }
                if (z) {
                    bVar3.mo24239a(view, list3, 2);
                    return;
                }
                return;
            case 4:
                List list4 = this.cql;
                C4246b bVar4 = this.cqk;
                if (bVar4 != null) {
                    z = true;
                }
                if (z) {
                    bVar4.mo24239a(view, list4, 3);
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    public void mo32009a(C4246b bVar) {
        this.cqk = bVar;
        synchronized (this) {
            this.bqb |= 2;
        }
        notifyPropertyChanged(C4672d.handler);
        super.requestRebind();
    }

    /* renamed from: aF */
    public void mo32010aF(List<TemplateInfo> list) {
        this.cql = list;
        synchronized (this) {
            this.bqb |= 1;
        }
        notifyPropertyChanged(C4672d.infoList);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        int i;
        CharSequence charSequence;
        CharSequence charSequence2;
        CharSequence charSequence3;
        CharSequence charSequence4;
        CharSequence charSequence5;
        CharSequence charSequence6;
        CharSequence charSequence7;
        int i2;
        CharSequence charSequence8;
        String str;
        String str2;
        String str3;
        String str4;
        CharSequence charSequence9;
        String str5;
        CharSequence charSequence10;
        CharSequence charSequence11;
        String str6;
        CharSequence charSequence12;
        boolean z;
        CharSequence charSequence13;
        String str7;
        synchronized (this) {
            j = this.bqb;
            this.bqb = 0;
        }
        List list = this.cql;
        C4246b bVar = this.cqk;
        String str8 = this.mTitle;
        String str9 = null;
        int i3 = ((j & 11) > 0 ? 1 : ((j & 11) == 0 ? 0 : -1));
        if (i3 != 0) {
            if (bVar != null) {
                charSequence7 = bVar.mo24243g(list, 0);
                z = bVar.mo24242f(list, 0);
                charSequence12 = bVar.mo24241e(list, 3);
                str6 = bVar.mo24240d(list, 0);
                charSequence11 = bVar.mo24241e(list, 0);
                charSequence10 = bVar.mo24243g(list, 3);
                str5 = bVar.mo24240d(list, 2);
                charSequence8 = bVar.mo24243g(list, 1);
                charSequence9 = bVar.mo24241e(list, 2);
                str4 = bVar.mo24240d(list, 1);
                charSequence13 = bVar.mo24241e(list, 1);
                charSequence6 = bVar.mo24243g(list, 2);
                str7 = bVar.mo24240d(list, 3);
            } else {
                str7 = null;
                charSequence13 = null;
                charSequence8 = null;
                charSequence7 = null;
                charSequence6 = null;
                charSequence12 = null;
                str6 = null;
                charSequence11 = null;
                charSequence10 = null;
                str5 = null;
                charSequence9 = null;
                str4 = null;
                z = false;
            }
            if (i3 != 0) {
                j = z ? j | 32 | 128 : j | 16 | 64;
            }
            i2 = z ? 8 : 0;
            int i4 = z ? 0 : 8;
            charSequence3 = charSequence13;
            charSequence = charSequence12;
            str9 = str6;
            charSequence4 = charSequence11;
            charSequence5 = charSequence10;
            i = i4;
            str2 = str5;
            charSequence2 = charSequence9;
            str = str7;
            str3 = str4;
        } else {
            str3 = null;
            str2 = null;
            str = null;
            charSequence8 = null;
            charSequence7 = null;
            charSequence6 = null;
            charSequence5 = null;
            charSequence4 = null;
            charSequence3 = null;
            charSequence2 = null;
            charSequence = null;
            i2 = 0;
            i = 0;
        }
        int i5 = ((j & 12) > 0 ? 1 : ((j & 12) == 0 ? 0 : -1));
        if ((j & 8) != 0) {
            this.cpM.setOnClickListener(this.cqn);
            this.cpN.setOnClickListener(this.cqm);
            this.cpO.setOnClickListener(this.cqp);
            this.cpP.setOnClickListener(this.cqo);
        }
        if ((j & 11) != 0) {
            C7387z.m21770b(this.cpM, str9);
            C7387z.m21770b(this.cpN, str3);
            C7387z.m21770b(this.cpO, str2);
            C7387z.m21770b(this.cpP, str);
            this.cpQ.setVisibility(i2);
            this.cpR.setVisibility(i2);
            this.cpS.setVisibility(i2);
            this.cpT.setVisibility(i2);
            C0165a.m348a(this.cpU, charSequence7);
            C0165a.m348a(this.cpV, charSequence8);
            C0165a.m348a(this.cpW, charSequence6);
            C0165a.m348a(this.cpX, charSequence5);
            C0165a.m348a(this.cpY, charSequence4);
            C0165a.m348a(this.cpZ, charSequence3);
            C0165a.m348a(this.cqa, charSequence2);
            C0165a.m348a(this.cqb, charSequence);
            int i6 = i;
            this.cqc.setVisibility(i6);
            this.cqd.setVisibility(i6);
            this.cqe.setVisibility(i6);
            this.cqf.setVisibility(i6);
            this.cqg.setVisibility(i6);
            this.cqh.setVisibility(i6);
            this.cqi.setVisibility(i6);
            this.cqj.setVisibility(i6);
        }
        if (i5 != 0) {
            C0165a.m348a(this.bAk, (CharSequence) str8);
        }
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

    public void setTitle(String str) {
        this.mTitle = str;
        synchronized (this) {
            this.bqb |= 4;
        }
        notifyPropertyChanged(C4672d.title);
        super.requestRebind();
    }

    public boolean setVariable(int i, Object obj) {
        if (C4672d.infoList == i) {
            mo32010aF((List) obj);
        } else if (C4672d.handler == i) {
            mo32009a((C4246b) obj);
        } else if (C4672d.title != i) {
            return false;
        } else {
            setTitle((String) obj);
        }
        return true;
    }
}
