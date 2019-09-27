package com.introvd.template.sdk.utils.p394b;

import android.text.TextUtils;
import com.introvd.template.sdk.C8382b;
import com.introvd.template.sdk.C8410e;
import com.introvd.template.sdk.model.editor.ErrorInfoModel;
import com.introvd.template.sdk.utils.C8554j;
import xiaoying.engine.base.IQTemplateAdapter;

/* renamed from: com.introvd.template.sdk.utils.b.f */
public class C8521f implements IQTemplateAdapter {
    public static ErrorInfoModel ehR;

    /* renamed from: bq */
    private boolean m24661bq(long j) {
        return j == 504403158265495562L || j == 504403158265495554L || j == 504403158265495555L || j == 504403158265495556L || j == 504403158265495558L || j == 504403158265495561L;
    }

    public String getTemplateExternalFile(long j, int i, int i2) {
        return C8532k.getTemplateExternalFile(j, i, i2);
    }

    public String getTemplateFile(long j) {
        if (m24661bq(j)) {
            j = C8501a.ehF.longValue();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getTemplateFile id=");
        sb.append(j);
        C8554j.m25007e("MyQTemplateAdapter", sb.toString());
        C8382b aHa = C8410e.aGX().aHa();
        if (aHa != null) {
            Long r = aHa.mo29497r(Long.valueOf(j));
            String q = aHa.mo29496q(r);
            if (!TextUtils.isEmpty(q) && !aHa.mo29498s(r)) {
                return q;
            }
        }
        return null;
    }

    public long getTemplateID(String str) {
        long longValue = C8532k.m24768ig(str).longValue();
        if (longValue == -1 && str.endsWith("0x4A00000000000083.xyt")) {
            longValue = 5332261958806667395L;
        }
        if (!C8532k.m24770s(Long.valueOf(longValue))) {
            return longValue;
        }
        if (ehR == null) {
            ehR = new ErrorInfoModel();
        }
        ehR.setmTemplatePath(str);
        ehR.setbNeedDownload(true);
        return -1;
    }
}
