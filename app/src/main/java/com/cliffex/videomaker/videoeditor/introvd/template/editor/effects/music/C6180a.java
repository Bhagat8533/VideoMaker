package com.introvd.template.editor.effects.music;

import com.introvd.template.common.model.Range;
import com.introvd.template.common.utils.RangeUtils;
import com.introvd.template.editor.effects.C5896a;
import com.introvd.template.editor.p245b.C5655b;
import com.introvd.template.editor.player.p267a.C6483a;
import com.introvd.template.sdk.editor.cache.C8441b;
import com.introvd.template.sdk.model.VeRange;
import com.introvd.template.sdk.utils.p394b.C8530i;
import com.introvd.template.sdk.utils.p394b.C8540q;
import java.util.ArrayList;
import java.util.Iterator;
import xiaoying.engine.clip.QEffect;

/* renamed from: com.introvd.template.editor.effects.music.a */
public abstract class C6180a extends C5896a {
    public volatile boolean cML = false;
    public volatile int cMM = -1;
    public volatile int currentVolume = 0;

    /* renamed from: a */
    private boolean m17698a(Range range, C8441b bVar) {
        if (!(range == null || bVar == null)) {
            VeRange aIb = bVar.aIb();
            if (aIb != null && aIb.getmTimeLength() < range.getmTimeLength()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public final C8441b mo28989a(String str, int i, int i2, int i3, int i4, int i5) {
        C8441b bVar = new C8441b();
        bVar.mo34265a(new VeRange(i3, i4));
        bVar.mo34273b(new VeRange(i, i2));
        bVar.mo34279nG(str);
        bVar.eef = i5;
        bVar.groupId = getGroupId();
        C8441b a = mo28454a(bVar);
        if (a == null) {
            return null;
        }
        int j = C8540q.m24957j(adO().getDataClip(), getGroupId());
        if (j > 0) {
            QEffect d = C8540q.m24947d(adO().getDataClip(), getGroupId(), j - 1);
            if (this.cyg != null) {
                this.cyg.mo29678a(new C6483a().mo29719ok(0).mo29718c(d));
            }
        }
        return a;
    }

    /* renamed from: a */
    public final void mo27848a(C5655b bVar) {
        super.mo27848a(bVar);
        Iterator it = aiz().iterator();
        while (it.hasNext()) {
            C8441b bVar2 = (C8441b) it.next();
            if (bVar2 != null && bVar2.aIc().getmTimeLength() == -1) {
                bVar2.aIc().setmTimeLength(adO().getDuration());
            }
        }
    }

    public final C8441b akY() {
        return mo28483mg(this.cMM);
    }

    /* access modifiers changed from: protected */
    public void akZ() {
    }

    /* access modifiers changed from: protected */
    public abstract int akh();

    public abstract void aki();

    public final boolean ala() {
        QEffect d = C8540q.m24947d(adO().getDataClip(), getGroupId(), this.cMM);
        if (this.cyg != null) {
            this.cyg.mo29678a(new C6483a().mo29719ok(2).mo29718c(d));
        }
        return mo28481me(this.cMM);
    }

    /* renamed from: f */
    public final boolean mo28993f(int i, Range range) {
        if (!mo28460a(i, range, m17698a(range, mo28483mg(i)))) {
            return false;
        }
        QEffect d = C8540q.m24947d(adO().getDataClip(), getGroupId(), i);
        if (!(this.cyg == null || d == null)) {
            this.cyg.mo29678a(new C6483a().mo29719ok(1).mo29718c(d));
        }
        return true;
    }

    /* renamed from: fD */
    public void mo28994fD(boolean z) {
        if (this.cyg != null) {
            this.cyg.mo29651fD(z);
        }
    }

    /* renamed from: nb */
    public boolean mo28995nb(int i) {
        Iterator it = aiz().iterator();
        while (it.hasNext()) {
            if (((C8441b) it.next()).aIc().getmPosition() == i) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: nc */
    public final void mo28996nc(int i) {
        if (this.cMM >= 0) {
            mo28476ct(this.cMM, i);
            this.currentVolume = i;
        }
    }

    /* renamed from: nd */
    public final boolean mo28997nd(int i) {
        if (i != this.cMM) {
            this.cMM = i;
            this.cML = true;
            this.currentVolume = akh();
            akZ();
        }
        return this.cMM >= 0;
    }

    /* renamed from: ne */
    public final int mo28998ne(int i) {
        ArrayList t = C8530i.m24764t(aiz());
        ArrayList arrayList = new ArrayList();
        if (t != null) {
            Iterator it = t.iterator();
            while (it.hasNext()) {
                VeRange veRange = (VeRange) it.next();
                if (veRange != null) {
                    arrayList.add(new Range(veRange.getmPosition(), veRange.getmTimeLength()));
                }
            }
        }
        return RangeUtils.getAvailableLen(arrayList, i, adO().getDuration());
    }

    /* renamed from: nf */
    public final boolean mo28999nf(int i) {
        if (this.cyg == null) {
            return false;
        }
        this.cyg.mo29678a(new C6483a().mo29719ok(2).mo29718c(C8540q.m24947d(adO().getDataClip(), getGroupId(), i)));
        return mo28481me(i);
    }

    public void setTouchDownPausable(boolean z) {
        if (this.cyg != null) {
            this.cyg.setTouchDownPausable(z);
        }
    }
}
