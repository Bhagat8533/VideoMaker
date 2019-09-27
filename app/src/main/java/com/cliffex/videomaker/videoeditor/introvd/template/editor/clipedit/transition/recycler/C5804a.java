package com.introvd.template.editor.clipedit.transition.recycler;

import android.content.Context;
import android.text.TextUtils;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.editor.clipedit.transition.TransitionInfo;
import com.introvd.template.editor.p266h.C6375c;
import com.introvd.template.sdk.model.TemplateConditionModel;
import com.introvd.template.sdk.model.editor.EffectInfoModel;
import com.introvd.template.sdk.model.template.TemplateInfo;
import com.introvd.template.sdk.p383c.C8399c;
import com.introvd.template.sdk.p391g.C8450a;
import com.introvd.template.template.p407e.C8735f;
import com.introvd.template.template.p409g.C8759b;
import com.p131c.p132a.p135c.C2575a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.introvd.template.editor.clipedit.transition.recycler.a */
public class C5804a {
    private C8759b bOt;
    private ArrayList<TransitionInfo> cCX = new ArrayList<>();
    private ArrayList<TransitionInfo> cCY = new ArrayList<>();
    private TemplateConditionModel cCZ;
    private boolean cDa;
    private String cDb;
    private int cDc;
    private Context context;
    private long cyT;

    public C5804a(Context context2, long j, TemplateConditionModel templateConditionModel, String str) {
        this.context = context2.getApplicationContext();
        this.cyT = j;
        this.cCZ = templateConditionModel;
        this.cDb = str;
        if (this.cDb == null) {
            this.cDb = "";
        }
        afZ();
    }

    private void afZ() {
        this.bOt = new C8759b(3);
        List<TemplateInfo> asK = C6375c.asF().asK();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (TemplateInfo templateInfo : asK) {
            arrayList2.add(Long.valueOf(C2575a.m7391rq(templateInfo.ttid)));
        }
        this.bOt.mo35198a(this.context, this.cyT, this.cCZ, AppStateModel.getInstance().isInChina());
        this.cDa = C8735f.aMf().mo35143aq(this.context, C8399c.ecZ);
        if (C8735f.aMf().mo35151qk(C8399c.ecZ).size() == 0) {
            C8735f.aMf().mo35147cz(this.context, C8399c.ecZ);
        }
        if (this.bOt.getCount() > 0) {
            for (int i = 0; i < this.bOt.getCount(); i++) {
                EffectInfoModel vh = this.bOt.mo35214vh(i);
                if (TextUtils.isEmpty(vh.mThumbUrl)) {
                    TemplateInfo be = C8735f.aMf().mo35144be(C8399c.ecZ, C8450a.m24469bn(this.bOt.mo35215vi(i)));
                    if (be != null) {
                        vh.mThumbUrl = be.strIcon;
                    }
                }
                if (arrayList2.isEmpty() || (vh != null && !arrayList2.contains(Long.valueOf(vh.mTemplateId)))) {
                    arrayList.add(vh);
                }
            }
        }
        this.cCX.clear();
        if (!arrayList.isEmpty()) {
            this.cCX.add(m16162d((EffectInfoModel) arrayList.get(0)));
        }
        for (TemplateInfo j : asK) {
            this.cCX.add(m16163j(j));
        }
        for (int i2 = 1; i2 < arrayList.size(); i2++) {
            this.cCX.add(m16162d((EffectInfoModel) arrayList.get(i2)));
        }
        aga();
        agb();
    }

    private void aga() {
        this.cCY.clear();
        Iterator it = this.cCX.iterator();
        while (it.hasNext()) {
            TransitionInfo transitionInfo = (TransitionInfo) it.next();
            if (transitionInfo.state == 1) {
                this.cCY.add(transitionInfo);
            }
        }
    }

    private void agb() {
        if (!TextUtils.isEmpty(this.cDb)) {
            this.cDc = 0;
            Iterator it = this.cCX.iterator();
            while (it.hasNext() && !((TransitionInfo) it.next()).path.equals(this.cDb)) {
                this.cDc++;
            }
        }
    }

    /* renamed from: d */
    private TransitionInfo m16162d(EffectInfoModel effectInfoModel) {
        TransitionInfo transitionInfo = new TransitionInfo();
        transitionInfo.cCN = effectInfoModel.mTemplateId;
        transitionInfo.name = effectInfoModel.mName;
        transitionInfo.path = effectInfoModel.mPath != null ? effectInfoModel.mPath : "";
        transitionInfo.url = effectInfoModel.getmUrl();
        transitionInfo.thumbUrl = effectInfoModel.mThumbUrl;
        if (effectInfoModel.isDownloading()) {
            transitionInfo.state = 2;
        } else if (effectInfoModel.isbNeedDownload()) {
            transitionInfo.state = 0;
        } else {
            transitionInfo.state = 1;
        }
        transitionInfo.cCO = effectInfoModel.getmConfigureCount();
        return transitionInfo;
    }

    /* renamed from: j */
    private TransitionInfo m16163j(TemplateInfo templateInfo) {
        TransitionInfo transitionInfo;
        Long valueOf = Long.valueOf(C2575a.m7391rq(templateInfo.ttid));
        EffectInfoModel bw = this.bOt.mo35204bw(valueOf.longValue());
        if (bw != null) {
            transitionInfo = m16162d(bw);
        } else {
            TransitionInfo transitionInfo2 = new TransitionInfo();
            transitionInfo2.cCN = valueOf.longValue();
            transitionInfo2.name = templateInfo.strTitle;
            transitionInfo2.url = templateInfo.strUrl;
            transitionInfo2.state = 0;
            transitionInfo = transitionInfo2;
        }
        transitionInfo.thumbUrl = templateInfo.strIcon;
        return transitionInfo;
    }

    public void afY() {
        afZ();
    }

    public String agc() {
        return this.cDb;
    }

    public boolean agd() {
        return this.cDa;
    }

    /* renamed from: aw */
    public int mo28097aw(long j) {
        Iterator it = this.cCX.iterator();
        int i = 0;
        while (it.hasNext()) {
            TransitionInfo transitionInfo = (TransitionInfo) it.next();
            if (transitionInfo.cCN == j) {
                transitionInfo.state = 2;
                transitionInfo.progress = 0;
                return i;
            }
            i++;
        }
        return -1;
    }

    /* renamed from: c */
    public int mo28098c(long j, String str) {
        Iterator it = this.cCX.iterator();
        int i = 0;
        while (it.hasNext()) {
            TransitionInfo transitionInfo = (TransitionInfo) it.next();
            if (transitionInfo.cCN == j) {
                transitionInfo.path = str;
                transitionInfo.state = 1;
                return i;
            }
            i++;
        }
        return -1;
    }

    /* renamed from: f */
    public int mo28099f(long j, int i) {
        Iterator it = this.cCX.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            TransitionInfo transitionInfo = (TransitionInfo) it.next();
            if (transitionInfo.cCN == j) {
                if (i >= 0) {
                    transitionInfo.progress = i;
                } else {
                    transitionInfo.progress = 0;
                    transitionInfo.state = 0;
                }
                return i2;
            }
            i2++;
        }
        return -1;
    }

    /* renamed from: gO */
    public TransitionInfo mo28100gO(String str) {
        Iterator it = this.cCX.iterator();
        while (it.hasNext()) {
            TransitionInfo transitionInfo = (TransitionInfo) it.next();
            if (TextUtils.equals(transitionInfo.path, str)) {
                return transitionInfo;
            }
        }
        return null;
    }

    /* renamed from: gP */
    public int mo28101gP(String str) {
        if (str == null) {
            str = "";
        }
        this.cDc = 0;
        if (this.cCX.isEmpty() || TextUtils.isEmpty(str)) {
            return this.cDc;
        }
        for (int i = 0; i < this.cCX.size(); i++) {
            if (((TransitionInfo) this.cCX.get(i)).path.equals(str)) {
                this.cDb = str;
                this.cDc = i;
                return this.cDc;
            }
        }
        return this.cDc;
    }

    public int getCount() {
        return this.cCX.size();
    }

    public int getFocusIndex() {
        return this.cDc;
    }

    /* renamed from: lv */
    public TransitionInfo mo28104lv(int i) {
        if (i <= this.cCX.size()) {
            return (TransitionInfo) this.cCX.get(i);
        }
        return null;
    }
}
