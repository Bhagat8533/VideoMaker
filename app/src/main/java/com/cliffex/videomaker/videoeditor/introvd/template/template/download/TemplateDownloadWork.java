package com.introvd.template.template.download;

import androidx.work.Worker;
import androidx.work.Worker.C1208a;
import com.introvd.template.sdk.model.editor.EffectInfoModel;
import com.introvd.template.template.p409g.C8762d;

public class TemplateDownloadWork extends Worker {
    EffectInfoModel[] elS;
    private C8708f elT;

    /* renamed from: a */
    private void m25297a(EffectInfoModel[] effectInfoModelArr) {
        C8703d dVar = new C8703d(getApplicationContext(), this.elT);
        for (EffectInfoModel effectInfoModel : effectInfoModelArr) {
            if (C8762d.aMt().mo35228bE(effectInfoModel.mTemplateId)) {
                dVar.mo35077a(effectInfoModel, effectInfoModel.mType);
            }
        }
    }

    /* renamed from: oy */
    public C1208a mo9162oy() {
        EffectInfoModel[] effectInfoModelArr = new EffectInfoModel[this.elS.length];
        for (int i = 0; i < this.elS.length; i++) {
            effectInfoModelArr[i] = this.elS[i];
        }
        m25297a(effectInfoModelArr);
        return C1208a.SUCCESS;
    }
}
