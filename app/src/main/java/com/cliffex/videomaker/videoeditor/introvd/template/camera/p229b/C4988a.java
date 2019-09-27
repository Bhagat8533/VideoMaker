package com.introvd.template.camera.p229b;

import android.content.Context;
import com.introvd.template.sdk.model.editor.EffectInfoModel;
import com.introvd.template.sdk.model.template.TemplateInfo;
import com.introvd.template.template.download.C8703d;
import com.introvd.template.template.download.C8708f;
import com.introvd.template.template.p407e.C8735f;
import com.p131c.p132a.p135c.C2575a;

/* renamed from: com.introvd.template.camera.b.a */
public class C4988a {
    private C8703d bOW;
    private Context context;

    public C4988a(Context context2, C8708f fVar) {
        this.context = context2;
        this.bOW = new C8703d(context2, fVar);
    }

    /* renamed from: a */
    public void mo25452a(TemplateInfo templateInfo, String str) {
        if (templateInfo != null) {
            EffectInfoModel effectInfoModel = new EffectInfoModel();
            effectInfoModel.setmUrl(templateInfo.strUrl);
            effectInfoModel.mName = templateInfo.strTitle;
            effectInfoModel.mTemplateId = C2575a.parseLong(templateInfo.ttid);
            this.bOW.mo35077a(effectInfoModel, str);
            C8735f.aMf().mo35136D(templateInfo);
        }
    }

    /* renamed from: c */
    public void mo25453c(TemplateInfo templateInfo) {
        EffectInfoModel effectInfoModel = new EffectInfoModel();
        effectInfoModel.mTemplateId = C2575a.m7391rq(templateInfo.ttid);
        effectInfoModel.setmUrl(templateInfo.strUrl);
        this.bOW.mo35077a(effectInfoModel, "filter");
        C8735f.aMf().mo35136D(templateInfo);
    }

    public void release() {
        this.bOW.mo35076VD();
    }
}
