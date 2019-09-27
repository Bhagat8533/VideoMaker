package com.introvd.template.sdk.slide;

import android.text.TextUtils;
import com.introvd.template.sdk.utils.C8548e;
import com.introvd.template.sdk.utils.C8554j;
import com.introvd.template.sdk.utils.p394b.C8533l;
import com.introvd.template.sdk.utils.p396c.C8544b;
import java.util.Date;
import java.util.Locale;
import xiaoying.engine.base.IQTextTransformer;
import xiaoying.engine.base.QTextTransformerParam;

/* renamed from: com.introvd.template.sdk.slide.f */
public class C8479f implements IQTextTransformer {
    private C8533l eeF;

    public C8479f(C8533l lVar) {
        this.eeF = lVar;
        C8554j.m25006d("TxtTransformer", "111");
    }

    public String TransformText(String str, QTextTransformerParam qTextTransformerParam) {
        if (this.eeF == null) {
            return null;
        }
        if (!(qTextTransformerParam == null || qTextTransformerParam.mType != 1 || qTextTransformerParam.mParam == null)) {
            try {
                String str2 = (String) qTextTransformerParam.mParam;
                if (!TextUtils.isEmpty(str2)) {
                    long fileDate = C8548e.getFileDate(str2);
                    Date date = new Date(fileDate);
                    if (fileDate <= 0) {
                        date = new Date();
                    }
                    String format = new C8544b(str.replace("%", "").replace("phototime", "").trim(), Locale.getDefault()).format(date);
                    StringBuilder sb = new StringBuilder();
                    sb.append("TransformText destStr=");
                    sb.append(format);
                    sb.append(";s=");
                    sb.append(str);
                    C8554j.m25008i("TxtTransformer", sb.toString());
                    return format;
                }
            } catch (Exception e) {
                C8554j.m25008i("TxtTransformer", e.getMessage());
            }
        }
        String oN = this.eeF.mo34790oN(str);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("TransformText destStr=");
        sb2.append(oN);
        sb2.append(";s=");
        sb2.append(str);
        C8554j.m25008i("TxtTransformer", sb2.toString());
        return oN;
    }
}
