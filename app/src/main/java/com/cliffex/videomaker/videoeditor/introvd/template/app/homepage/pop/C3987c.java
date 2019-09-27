package com.introvd.template.app.homepage.pop;

import android.app.Activity;
import com.introvd.template.app.manager.C4059d.C4063a;
import com.introvd.template.app.youngermode.C4560d;
import com.introvd.template.module.iap.C8048e;
import com.p131c.p132a.C2561a;
import com.quvideo.priority.p217a.C4892c;
import java.util.HashMap;

/* renamed from: com.introvd.template.app.homepage.pop.c */
public class C3987c extends C4892c {
    private boolean bqq = false;

    /* renamed from: KW */
    private void m9868KW() {
        HashMap hashMap = new HashMap(1);
        hashMap.put("name", "首页活动弹窗");
        C8048e.aBe().mo23653g("viva_home_popup_record", hashMap);
    }

    /* access modifiers changed from: protected */
    /* renamed from: p */
    public boolean mo23396p(Activity activity) {
        if (C2561a.aON() || C4560d.m11516RN().isYoungerMode() || this.bqq) {
            return false;
        }
        this.bqq = true;
        boolean a = C3983b.m9859a(activity, (C4063a) new C4063a() {
            public void onCancel() {
            }

            public void onClick() {
            }

            public void onClose() {
                C3987c.this.mo25344EW();
            }
        });
        if (a) {
            m9868KW();
        }
        return a;
    }

    /* renamed from: sb */
    public int mo23397sb() {
        return 97;
    }
}
