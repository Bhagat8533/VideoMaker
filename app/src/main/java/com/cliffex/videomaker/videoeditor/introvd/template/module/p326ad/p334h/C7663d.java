package com.introvd.template.module.p326ad.p334h;

import com.introvd.template.common.LogUtils;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import org.json.JSONObject;

/* renamed from: com.introvd.template.module.ad.h.d */
public class C7663d {
    /* renamed from: C */
    public static void m22484C(String str, int i) {
        C7662c aAA = C7662c.aAA();
        StringBuilder sb = new StringBuilder();
        sb.append("{\"");
        sb.append(m22485Ig());
        sb.append("\":");
        sb.append(i);
        sb.append("}");
        aAA.setString(str, sb.toString());
    }

    /* renamed from: Ig */
    private static String m22485Ig() {
        return new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(Calendar.getInstance().getTime());
    }

    /* renamed from: km */
    public static int m22486km(String str) {
        try {
            String string = C7662c.aAA().getString(str, "{}");
            LogUtils.m14222e("dayTimesJson", string);
            return new JSONObject(string).optInt(m22485Ig(), 0);
        } catch (Exception e) {
            C7662c.aAA().setString(str, null);
            e.printStackTrace();
            return 0;
        }
    }
}
