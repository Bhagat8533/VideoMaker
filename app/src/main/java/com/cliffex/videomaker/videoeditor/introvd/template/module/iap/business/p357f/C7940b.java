package com.introvd.template.module.iap.business.p357f;

import android.app.Activity;
import com.introvd.template.module.iap.C8072q;
import com.introvd.template.module.p338b.C7686a;
import java.util.List;
import p037b.p050b.C1848s;
import p037b.p050b.C1852w;
import p037b.p050b.p057e.C1518f;

/* renamed from: com.introvd.template.module.iap.business.f.b */
public class C7940b {
    /* renamed from: a */
    public static C1848s<Boolean> m23078a(final Activity activity, final List<Integer> list) {
        return aBr() ? C1848s.m5331x(new Exception("config isGoOriginalVipLogic is true ")) : C8072q.aBx().isVip() ? C1848s.m5331x(new Exception("user is vip")) : (activity == null || activity.isFinishing() || activity.getWindow() == null) ? C1848s.m5331x(new Exception("activity state is not good")) : C1848s.m5326ai(list).mo10198h(new C1518f<List<Integer>, C1852w<Boolean>>() {
            /* renamed from: aN */
            public C1852w<Boolean> apply(List<Integer> list) throws Exception {
                return C7930a.m23069b(activity, list);
            }
        });
    }

    public static boolean aBr() {
        return !C7686a.aAV();
    }
}
