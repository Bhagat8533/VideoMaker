package com.introvd.template.module.iap.guide;

import android.app.Activity;
import android.arch.lifecycle.C0069g;
import com.introvd.template.module.iap.C8048e;
import com.introvd.template.module.iap.business.p356e.C7897a;
import com.p131c.p132a.C2561a;
import com.quvideo.priority.p217a.C4892c;
import com.quvideo.priority.p217a.C4892c.C4893a;
import java.util.HashMap;

/* renamed from: com.introvd.template.module.iap.guide.b */
public class C8056b extends C4892c {
    private C8055a dUS = new C8055a() {
        public void onDismiss() {
            C8056b.this.mo25344EW();
            VipGuideStrategy.aEh();
        }
    };

    public C8056b(C4893a aVar) {
        super(aVar);
    }

    /* renamed from: KW */
    private void m23386KW() {
        if ("1".equals(C7897a.m23024c("Iap_default_init_home_tab_id", new String[0]))) {
            HashMap hashMap = new HashMap(1);
            hashMap.put("name", "VIP引导");
            C8048e.aBe().mo23653g("viva_home_popup_record", hashMap);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: p */
    public boolean mo23396p(Activity activity) {
        if (C8048e.aBe().isYoungerMode() || C2561a.aOR() == 4 || !(activity instanceof C0069g)) {
            return false;
        }
        VipGuideStrategy.m23376a(this.dUS);
        boolean aP = VipGuideStrategy.m23377aP(activity);
        if (aP) {
            m23386KW();
        }
        return aP;
    }
}
