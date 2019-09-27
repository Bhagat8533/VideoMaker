package com.introvd.template.vivaiap.payment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

/* renamed from: com.introvd.template.vivaiap.payment.b */
public abstract class C9055b {
    private final String eBe;
    private PayParam eBf;

    protected C9055b(String str) {
        this.eBe = str;
        init();
    }

    /* renamed from: EO */
    public boolean mo25335EO() {
        return true;
    }

    /* renamed from: a */
    public PayResult mo35889a(int i, Intent intent) {
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo25318a(Activity activity, PayParam payParam);

    /* renamed from: a */
    public final void mo35890a(Context context, int i, int i2, Intent intent) {
        if (aNz() != i) {
            mo35894b(context, i, i2, intent);
            return;
        }
        PayResult a = mo35889a(i2, intent);
        boolean z = false;
        if (a != null) {
            if (this.eBf == null || this.eBf.aNA()) {
                z = true;
            }
            a.mo35877jN(z);
            C9059e.m26484a(context, a);
            return;
        }
        C9059e.m26485a(context, false, -1, "No pay result.", this.eBf);
    }

    /* renamed from: a */
    public final void mo35891a(Context context, boolean z, int i, String str) {
        C9059e.m26485a(context, z, i, str, this.eBf);
    }

    /* access modifiers changed from: protected */
    public int aNz() {
        return 2147483646;
    }

    /* renamed from: b */
    public final void mo35893b(Activity activity, PayParam payParam) {
        this.eBf = payParam;
        mo25318a(activity, payParam);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo35894b(Context context, int i, int i2, Intent intent) {
    }

    /* access modifiers changed from: protected */
    public void init() {
    }
}
