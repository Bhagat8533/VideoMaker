package com.introvd.template.vivaiap.dispatcher;

import android.content.Context;
import com.introvd.template.vivaiap.base.C9022a;
import com.introvd.template.vivaiap.base.p417a.C9023a;
import com.introvd.template.vivaiap.coffer.C9029a;
import com.introvd.template.vivaiap.coffer.C9029a.C9030a;
import com.introvd.template.vivaiap.payment.C9054a;
import com.introvd.template.vivaiap.payment.C9057d;
import com.introvd.template.vivaiap.payment.C9057d.C9058a;
import com.introvd.template.vivaiap.payment.PayParam;
import com.introvd.template.vivaiap.warehouse.C9068b;
import com.introvd.template.vivaiap.warehouse.C9070d;
import com.introvd.template.vivaiap.warehouse.C9072f;
import com.introvd.template.vivaiap.warehouse.C9072f.C9073a;

/* renamed from: com.introvd.template.vivaiap.dispatcher.a */
public abstract class C9043a<T extends C9023a, R extends C9023a> {
    private C9044b<T, R> eBa;
    private C9029a<T, R> eBb;
    private C9072f<T, R> eBc;
    private C9057d eBd;

    protected C9043a() {
        init();
    }

    private void init() {
        this.eBa = aEw();
        if (this.eBa != null) {
            if (this.eBc == null) {
                this.eBc = new C9073a(this.eBa.aEz()).mo35923b(this.eBa.aEA()).aNN();
            }
            if (this.eBb == null) {
                this.eBb = new C9030a().mo35839c(this.eBa.aEB()).mo35841d(this.eBa.aEC()).mo35840d(this.eBc.aNK()).mo35838c(this.eBc.aNJ()).mo35837b(this.eBa.aEF()).aNv();
            }
            if (this.eBd == null) {
                this.eBd = new C9058a(this.eBa.aED()).mo35903b(this.eBb.aNu()).mo35904b(this.eBa.aEE()).aND();
                return;
            }
            return;
        }
        throw new IllegalStateException("IapProvider can't be null");
    }

    /* renamed from: a */
    public final void mo35846a(Context context, PayParam payParam, C9054a aVar) {
        this.eBd.mo35897a(context, payParam, aVar);
    }

    /* access modifiers changed from: protected */
    public abstract C9044b<T, R> aEw();

    public final C9022a aNu() {
        return this.eBb.aNu();
    }

    public final C9070d<T> aNw() {
        return this.eBc.aNH();
    }

    public final C9070d<R> aNx() {
        return this.eBc.aNI();
    }

    public final C9068b aNy() {
        return this.eBc.aNL();
    }

    /* renamed from: qZ */
    public final boolean mo35851qZ(String str) {
        return this.eBd.mo35901qZ(str);
    }
}
