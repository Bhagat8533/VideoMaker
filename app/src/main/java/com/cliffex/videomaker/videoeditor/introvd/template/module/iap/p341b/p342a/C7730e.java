package com.introvd.template.module.iap.p341b.p342a;

import android.content.Context;
import com.introvd.template.common.ResultListener;
import com.introvd.template.module.iap.C8048e;
import com.introvd.template.module.iap.p341b.C7795h;

/* renamed from: com.introvd.template.module.iap.b.a.e */
public class C7730e extends C7795h {
    /* access modifiers changed from: private */
    public int dVu = 0;

    /* renamed from: cc */
    public boolean mo32596cc(Context context, String str) {
        if (!C8048e.aBe().isYoungerMode()) {
            return false;
        }
        C8048e.aBe().mo23638a(context, (ResultListener) new ResultListener() {
            public void onError(Throwable th) {
                C8048e.aBe().mo23614MF();
            }

            public void onSuccess(Object obj) {
                C8048e.aBe().mo23614MF();
                if (C7730e.this.dVu = C7730e.this.dVu + 1 >= 2) {
                    C7730e.this.dVu = 0;
                } else {
                    C7730e.this.aEH();
                }
            }
        });
        return true;
    }

    public String getId() {
        return "YoungerInterceptor";
    }
}
