package com.introvd.template.editor.effects.p257fx;

import android.graphics.Point;
import android.graphics.Rect;
import com.introvd.template.common.FileUtils;
import com.introvd.template.common.model.Range;
import com.introvd.template.common.utils.RangeUtils;
import com.introvd.template.editor.effects.C5896a;
import com.introvd.template.editor.p245b.C5655b;
import com.introvd.template.sdk.editor.cache.C8441b;
import com.introvd.template.sdk.model.VeRange;
import com.introvd.template.sdk.model.editor.EffectInfoModel;
import com.introvd.template.sdk.p391g.C8450a;
import com.introvd.template.sdk.utils.VeMSize;
import com.introvd.template.sdk.utils.p394b.C8530i;
import com.introvd.template.template.p409g.C8759b;
import java.util.ArrayList;
import java.util.Iterator;
import xiaoying.engine.base.QStyle.QAnimatedFrameTemplateInfo;

/* renamed from: com.introvd.template.editor.effects.fx.f */
public class C6148f extends C5896a {
    private ArrayList<Range> cLH;
    private int startPos = 0;

    /* renamed from: d */
    private void m17552d(int i, Range range) {
        if (i >= 0 && i <= this.cLH.size()) {
            this.cLH.add(i, range);
        }
    }

    /* renamed from: e */
    private C8441b m17553e(C6151i iVar) {
        if (iVar == null) {
            return null;
        }
        EffectInfoModel akN = iVar.akN();
        if (akN == null) {
            return null;
        }
        long j = akN.mTemplateId;
        if (j < 0) {
            return null;
        }
        String by = C8759b.m25586by(j);
        if (!FileUtils.isFileExisted(by)) {
            return null;
        }
        QAnimatedFrameTemplateInfo a = C8450a.m24461a(by, getStreamSize() != null ? new VeMSize(getStreamSize().width, getStreamSize().height) : null);
        int availableLen = RangeUtils.getAvailableLen(this.cLH, adZ(), adO().getDuration());
        if (a == null) {
            return null;
        }
        int i = a.duration;
        if (availableLen <= i) {
            i = availableLen;
        }
        C8441b bVar = new C8441b();
        bVar.eeh = new Rect(a.defaultRegion.left, a.defaultRegion.top, a.defaultRegion.right, a.defaultRegion.bottom);
        bVar.groupId = 6;
        bVar.mo34273b(new VeRange(this.startPos, i));
        bVar.mo34279nG(by);
        return bVar;
    }

    /* renamed from: e */
    private void m17554e(int i, Range range) {
        if (i >= 0 && i < this.cLH.size()) {
            this.cLH.remove(i);
            this.cLH.add(i, range);
        }
    }

    /* renamed from: mP */
    private void m17555mP(int i) {
        if (i >= 0 && i < this.cLH.size()) {
            this.cLH.remove(i);
        }
    }

    /* renamed from: a */
    public void mo27848a(C5655b bVar) {
        super.mo27848a(bVar);
        ArrayList t = C8530i.m24764t(aiz());
        ArrayList<Range> arrayList = new ArrayList<>();
        if (t != null) {
            Iterator it = t.iterator();
            while (it.hasNext()) {
                VeRange veRange = (VeRange) it.next();
                if (veRange != null) {
                    arrayList.add(new Range(veRange.getmPosition(), veRange.getmTimeLength()));
                }
            }
        }
        this.cLH = arrayList;
    }

    public int akB() {
        if (adO() == null) {
            return 0;
        }
        return adO().getDuration();
    }

    /* access modifiers changed from: 0000 */
    public void akC() {
        int akD = akD();
        if (akD >= 0) {
            mo28481me(akD);
            m17555mP(akD);
        }
    }

    /* access modifiers changed from: 0000 */
    public int akD() {
        return mo28452a((Point) null, adZ());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public Range mo28936c(C6151i iVar) {
        C8441b e = m17553e(iVar);
        Range range = null;
        if (e == null) {
            return null;
        }
        mo28454a(e);
        VeRange aIc = e.aIc();
        if (aIc != null) {
            range = new Range(aIc.getmPosition(), aIc.getmTimeLength());
        }
        this.cLH.add(range);
        return range;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo28937c(int i, Range range) {
        mo28473b(i, range);
        m17554e(i, range);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public Range mo28938d(C6151i iVar) {
        int akD = akD();
        Range range = null;
        if (akD < 0 || aiz() == null || aiz().size() <= akD) {
            return null;
        }
        m17555mP(akD);
        C8441b e = m17553e(iVar);
        if (e == null) {
            return null;
        }
        mo28461a(akD, e);
        VeRange aIc = e.aIc();
        if (aIc != null) {
            range = new Range(aIc.getmPosition(), aIc.getmTimeLength());
        }
        m17552d(akD, range);
        return range;
    }

    public int getGroupId() {
        return 6;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: mO */
    public void mo28939mO(int i) {
        mo28476ct(akD(), i);
    }

    /* renamed from: mQ */
    public void mo28940mQ(int i) {
        this.startPos = i;
    }
}
