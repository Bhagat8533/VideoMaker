package com.introvd.template.module.iap;

import com.introvd.template.module.iap.business.home.C7969b;
import com.introvd.template.module.iap.business.home.C7984f;
import com.introvd.template.module.iap.business.home.C7989i;
import com.introvd.template.module.iap.business.home.C7990j;

/* renamed from: com.introvd.template.module.iap.a */
public class C7698a {
    /* renamed from: kr */
    public static C7984f m22602kr(String str) {
        return C8048e.aBe().mo23630Mv() ? new C7990j(str) : C8048e.aBe().mo23629Mu() ? new C7989i(str) : C8048e.aBe().isInChina() ? new C7969b(str) : new C7990j(str);
    }
}
