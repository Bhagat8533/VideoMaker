package com.introvd.template.module.iap.business;

import com.aiii.android.arouter.facade.p094a.C1942a;
import com.introvd.template.module.iap.C8048e;
import com.introvd.template.module.iap.business.coupon.C7858e;
import com.introvd.template.module.iap.business.coupon.C7858e.C7864a;
import com.introvd.template.module.iap.business.coupon.C7868i;
import com.introvd.template.module.iap.business.exchange.C7916c;
import com.introvd.template.module.iap.business.exchange.C7916c.C7920a;
import com.introvd.template.module.iap.p341b.C7738c;
import com.introvd.template.module.iap.p341b.p343b.C7735c;
import com.introvd.template.module.iap.p341b.p345d.C7786h;
import com.introvd.template.router.user.BaseUserLifeCycle;
import org.greenrobot.eventbus.C10021c;
import org.greenrobot.eventbus.C10031j;

@C1942a(mo10417rZ = "/mid_iap/user_lifecycle")
public class IapUserLifeCycleImpl extends BaseUserLifeCycle {
    public void onLoginSuccess(boolean z) {
        super.onLoginSuccess(z);
        if (C7738c.aEv().aNw().isEmpty()) {
            C7738c.aEv().aNu().aNr();
        }
        if (!C10021c.aZH().mo38495ay(this)) {
            C10021c.aZH().mo38494ax(this);
        }
        C7738c.aEv().aNu().aNs();
        C7916c.aCW().mo32876a((C7920a) null);
        C7858e.m22915a(null);
    }

    public void onLogoutSuccess() {
        super.onLogoutSuccess();
        C7738c.aEv().aNx().clear();
        C7858e.clear();
        C7916c.aCW().unInit();
    }

    @C10031j
    public void onPurchaseReload(C7735c cVar) {
        if (C10021c.aZH().mo38495ay(this)) {
            C10021c.aZH().mo38496az(this);
        }
        if (!C7858e.aCk().isEmpty()) {
            C7868i.m22933gp(C8048e.aBe().getContext());
        } else {
            C7858e.m22915a(new C7864a() {
                /* renamed from: iD */
                public void mo32659iD(boolean z) {
                    if (z) {
                        C7868i.m22933gp(C8048e.aBe().getContext());
                    }
                }
            });
        }
    }

    public void onTokenRefreshSuccess() {
        super.onTokenRefreshSuccess();
        C7786h.aEP();
    }
}
