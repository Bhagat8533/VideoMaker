package com.introvd.template.module.iap.business.coupon;

import android.content.Context;
import android.text.SpannableString;
import com.introvd.template.module.iap.C8048e;

/* renamed from: com.introvd.template.module.iap.business.coupon.h */
public abstract class C7867h implements C7852b {
    protected final Context context = C8048e.aBe().getContext();
    protected final C7846a dQE;

    public C7867h(C7846a aVar) {
        this.dQE = aVar;
    }

    public SpannableString aCe() {
        return this.dQE.mo32774sp(30);
    }

    public String aCf() {
        return this.dQE.name;
    }
}
