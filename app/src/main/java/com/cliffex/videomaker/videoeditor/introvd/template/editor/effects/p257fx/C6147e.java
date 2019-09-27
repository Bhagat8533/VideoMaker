package com.introvd.template.editor.effects.p257fx;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.introvd.template.C4561b;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.editor.base.C5686a;
import com.introvd.template.editor.p266h.C6375c;
import com.introvd.template.sdk.model.editor.EffectInfoModel;
import com.introvd.template.sdk.model.template.TemplateInfo;
import com.introvd.template.sdk.p383c.C8399c;
import com.introvd.template.template.p407e.C8735f;
import com.introvd.template.template.p407e.C8738h;
import com.introvd.template.template.p409g.C8759b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.introvd.template.editor.effects.fx.e */
final class C6147e {
    private Map<String, C6146d> cLC = new HashMap();
    private Map<String, TemplateInfo> cLD = new HashMap();
    @SuppressLint({"UseSparseArrays"})
    private Map<Long, C6151i> cLE = new HashMap();
    private Map<String, C6151i> cLF = new HashMap();
    private C8759b cLG = new C8759b(6);

    C6147e() {
    }

    /* renamed from: m */
    private void m17543m(TemplateInfo templateInfo) {
        m17544n(templateInfo).akz();
    }

    /* renamed from: n */
    private C6146d m17544n(TemplateInfo templateInfo) {
        C6146d dVar = (C6146d) this.cLC.get(templateInfo.strSceneCode);
        if (dVar == null) {
            dVar = new C6146d(templateInfo.strSceneCode, templateInfo.strSceneName);
            dVar.mo28926hu(templateInfo.strSceneIcon);
            this.cLC.put(templateInfo.strSceneCode, dVar);
        }
        dVar.mo28923b(m17545o(templateInfo));
        return dVar;
    }

    /* renamed from: o */
    private C6151i m17545o(TemplateInfo templateInfo) {
        C6151i iVar;
        long longValue = Long.decode(templateInfo.ttid).longValue();
        if (this.cLD.containsKey(templateInfo.ttid)) {
            TemplateInfo templateInfo2 = (TemplateInfo) this.cLD.get(templateInfo.ttid);
            EffectInfoModel effectInfoModel = new EffectInfoModel();
            effectInfoModel.mTemplateId = longValue;
            effectInfoModel.mPath = C8759b.m25586by(effectInfoModel.mTemplateId);
            effectInfoModel.setmUrl(templateInfo2.strUrl);
            EffectInfoModel bw = this.cLG.mo35204bw(longValue);
            if (bw == null) {
                effectInfoModel.setbNeedDownload(true);
                effectInfoModel.setDownloaded(false);
            } else {
                effectInfoModel.setDownloaded(bw.isDownloaded());
                effectInfoModel.setbNeedDownload(bw.isbNeedDownload());
            }
            effectInfoModel.setDownloading(false);
            iVar = new C6151i(effectInfoModel);
            iVar.mo28949hC(templateInfo2.strIcon);
            iVar.mo28950hD(templateInfo.strSceneCode);
        } else {
            EffectInfoModel bw2 = this.cLG.mo35204bw(longValue);
            Bitmap bz = this.cLG.mo35206bz(longValue);
            iVar = new C6151i(bw2);
            iVar.setThumbnail(bz);
            iVar.mo28949hC(bw2.mThumbUrl);
            iVar.mo28950hD(templateInfo.strSceneCode);
        }
        this.cLE.put(Long.valueOf(longValue), iVar);
        if (iVar.akN() != null && !TextUtils.isEmpty(iVar.akN().mPath)) {
            this.cLF.put(iVar.akN().mPath, iVar);
        }
        return iVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public List<C6146d> mo28927a(C5686a aVar) {
        this.cLG.mo35198a((Context) VivaBaseApplication.m8749FZ(), -1, aVar.adK().aJK(), AppStateModel.getInstance().isInChina());
        C8738h hVar = new C8738h();
        if (hVar.mo35168hi(VivaBaseApplication.m8749FZ()) > 0) {
            for (TemplateInfo templateInfo : hVar.mo35173hn(VivaBaseApplication.m8749FZ())) {
                if (!(templateInfo == null || this.cLG.mo35204bw(Long.decode(templateInfo.ttid).longValue()) == null)) {
                    templateInfo.strSceneCode = "-1";
                    m17544n(templateInfo);
                }
            }
        }
        for (TemplateInfo templateInfo2 : C6375c.asF().asQ()) {
            if (templateInfo2 != null) {
                this.cLD.put(templateInfo2.ttid, templateInfo2);
                if (TextUtils.isEmpty(templateInfo2.strSceneCode)) {
                    templateInfo2.strSceneCode = "-1";
                }
                m17543m(templateInfo2);
            }
        }
        C8735f.aMf().mo35147cz(VivaBaseApplication.m8749FZ(), C8399c.edd);
        for (TemplateInfo templateInfo3 : C8735f.aMf().mo35151qk(C8399c.edd)) {
            if (!(templateInfo3 == null || this.cLG.mo35204bw(Long.decode(templateInfo3.ttid).longValue()) == null)) {
                if (TextUtils.isEmpty(templateInfo3.strSceneCode)) {
                    templateInfo3.strSceneCode = "-1";
                }
                m17544n(templateInfo3);
            }
        }
        ArrayList arrayList = new ArrayList(this.cLC.values());
        if (!C4561b.m11530bm(VivaBaseApplication.m8749FZ()) || ((C6146d) arrayList.get(0)).akw() != "-1") {
            Collections.sort(arrayList);
        } else {
            C6146d dVar = (C6146d) arrayList.remove(0);
            Collections.sort(arrayList);
            arrayList.add(0, dVar);
        }
        return arrayList;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: az */
    public C6151i mo28928az(long j) {
        return (C6151i) this.cLE.get(Long.valueOf(j));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: hv */
    public C6151i mo28929hv(String str) {
        return (C6151i) this.cLF.get(str);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: hw */
    public C6146d mo28930hw(String str) {
        return (C6146d) this.cLC.get(str);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: hx */
    public String mo28931hx(String str) {
        if (this.cLG == null) {
            return null;
        }
        return this.cLG.mo35211qH(this.cLG.mo35208qC(str));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: hy */
    public long mo28932hy(String str) {
        return C8759b.m25587jf(str);
    }
}
