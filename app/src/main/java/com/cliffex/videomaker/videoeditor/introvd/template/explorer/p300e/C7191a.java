package com.introvd.template.explorer.p300e;

import android.content.Context;
import android.text.TextUtils;
import com.introvd.template.explorer.model.DataItemModel;
import com.introvd.template.explorer.model.MusicEffectInfoModel;
import com.introvd.template.explorer.p298c.C7156d;
import com.introvd.template.template.p409g.C8762d;
import java.util.ArrayList;

/* renamed from: com.introvd.template.explorer.e.a */
public class C7191a {
    private ArrayList<DataItemModel> dEq = new ArrayList<>();
    C7156d dEr = new C7156d(7);

    public C7191a(Context context) {
        this.dEr.mo31625a(context, -1, 0);
        axX();
    }

    private void axX() {
        int count = this.dEr.getCount();
        if (count > 0) {
            for (int i = 0; i < count; i++) {
                DataItemModel dataItemModel = new DataItemModel();
                String qG = this.dEr.mo31629qG(i);
                dataItemModel.mName = this.dEr.mo31630qH(i);
                dataItemModel.setmDuration(100000);
                String str = "";
                long jf = C7156d.m21167jf(qG);
                if (jf > 0) {
                    str = C8762d.aMt().getTemplateExternalFile(jf, 0, 1000);
                }
                dataItemModel.mPath = str;
                MusicEffectInfoModel qF = this.dEr.mo31628qF(i);
                if (qF != null) {
                    dataItemModel.setDownloaded(qF.isDownloaded());
                    dataItemModel.setlTemplateId(qF.mTemplateId);
                }
                this.dEq.add(dataItemModel);
            }
        }
    }

    /* renamed from: jr */
    public String mo31671jr(String str) {
        if (this.dEq != null && this.dEq.size() > 0) {
            for (int i = 0; i < this.dEq.size(); i++) {
                DataItemModel dataItemModel = (DataItemModel) this.dEq.get(i);
                if (TextUtils.equals(str, dataItemModel.mPath)) {
                    return dataItemModel.mName;
                }
            }
        }
        return "";
    }

    public void release() {
        if (this.dEq != null) {
            this.dEq.clear();
            this.dEq = null;
        }
        if (this.dEr != null) {
            this.dEr.unInit(true);
        }
    }
}
