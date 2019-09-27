package com.introvd.template.module.p326ad.p330d;

import com.introvd.template.module.p326ad.p334h.C7662c;
import com.p131c.p132a.p135c.C2575a;
import java.util.Calendar;

/* renamed from: com.introvd.template.module.ad.d.c */
class C7605c extends C7606d {
    C7605c() {
    }

    private String aAu() {
        Calendar instance = Calendar.getInstance();
        int i = instance.get(1);
        int i2 = instance.get(2) + 1;
        int i3 = instance.get(5);
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(i));
        sb.append(String.valueOf(i2));
        sb.append(String.valueOf(i3));
        return sb.toString();
    }

    /* renamed from: kk */
    private int m22401kk(String str) {
        String[] split = str.split("_");
        if (split.length > 0) {
            return C2575a.parseInt(split[1]);
        }
        return 0;
    }

    /* renamed from: rV */
    private String m22402rV(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(aAu());
        sb.append("_");
        sb.append(i);
        return sb.toString();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: rU */
    public void mo32482rU(int i) {
        String string = C7662c.aAA().getString("key_current_max_show_times", m22402rV(i));
        if (!string.contains(aAu())) {
            string = m22402rV(i);
            C7662c.aAA().setString("key_current_max_show_times", string);
        }
        this.dNe = m22401kk(string);
    }
}
