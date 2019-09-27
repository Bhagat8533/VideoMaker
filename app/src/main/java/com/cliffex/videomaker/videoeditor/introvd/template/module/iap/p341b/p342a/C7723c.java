package com.introvd.template.module.iap.p341b.p342a;

import android.content.Context;
import com.introvd.template.module.iap.C8048e;
import com.introvd.template.module.iap.business.p349a.C7827b;
import com.introvd.template.module.iap.business.p349a.C7832c;
import com.introvd.template.module.iap.p341b.C7738c;
import com.introvd.template.module.iap.p341b.C7792f;
import com.introvd.template.module.iap.p341b.p344c.C7745a;
import com.introvd.template.module.iap.p341b.p344c.C7747c;
import com.introvd.template.module.iap.p341b.p344c.C7751d;
import com.introvd.template.module.iap.p341b.p344c.C7753e;
import com.introvd.template.module.iap.p341b.p345d.C7769c;
import com.introvd.template.module.iap.p341b.p345d.C7775d;
import com.introvd.template.module.iap.p341b.p345d.C7784g;
import com.introvd.template.module.iap.p341b.p345d.C7786h;
import com.introvd.template.module.iap.p341b.p345d.p347b.C7766a;
import com.introvd.template.module.iap.p341b.p345d.p347b.C7767b;
import com.introvd.template.module.iap.p341b.p345d.p348c.C7770a;
import com.introvd.template.module.iap.p341b.p345d.p348c.C7771b;
import com.introvd.template.module.iap.p341b.p345d.p348c.C7774c;
import com.introvd.template.router.iaplitehw.LiteIAPHWServiceProxy;
import com.introvd.template.vivaiap.coffer.C9036d;
import com.introvd.template.vivaiap.coffer.C9037e;
import com.introvd.template.vivaiap.payment.C9054a;
import com.quvideo.plugin.payclient.google.C4867c;
import com.quvideo.plugin.payclient.google.C4867c.C4869a;
import com.quvideo.plugin.payclient.google.C4867c.C4871c;

/* renamed from: com.introvd.template.module.iap.b.a.c */
public class C7723c {
    private final int bmj;
    private C7792f dVp;
    private C9037e<C7832c> dVq;
    private C9037e<C7827b> dVr;
    private boolean dVs = true;

    public C7723c(int i) {
        this.bmj = i;
        if (i == 1) {
            C4867c.m12480EP().mo25336a(C8048e.aBe().getContext(), new C7745a(), new C4869a() {
            });
            C4867c.m12480EP().mo25339a((C4871c) new C4871c() {
            });
        } else if (i == 4) {
            LiteIAPHWServiceProxy.initHWLiteIap();
        }
    }

    /* renamed from: EO */
    public boolean mo32598EO() {
        switch (this.bmj) {
            case 0:
                return false;
            case 1:
                return C7738c.aEv().mo35851qZ("google");
            default:
                return !C7738c.aEv().aNw().isEmpty();
        }
    }

    public C7792f aEI() {
        C7792f fVar;
        if (this.dVp != null) {
            return this.dVp;
        }
        switch (this.bmj) {
            case 0:
                fVar = new C7792f() {
                    /* renamed from: b */
                    public void mo32602b(Context context, String str, String str2, C9054a aVar) {
                    }
                };
                break;
            case 1:
                fVar = new C7747c();
                break;
            case 2:
                fVar = new C7766a();
                break;
            case 4:
                fVar = new C7767b();
                break;
            case 5:
                fVar = new C7774c();
                break;
            case 6:
                fVar = new C7770a();
                break;
            default:
                fVar = new C7771b();
                break;
        }
        this.dVp = fVar;
        return fVar;
    }

    public C9037e<C7832c> aEJ() {
        C9037e<C7832c> eVar;
        if (this.dVq != null) {
            return this.dVq;
        }
        int i = this.bmj;
        if (i != 4) {
            switch (i) {
                case 0:
                    eVar = new C9037e<C7832c>() {
                        /* renamed from: a */
                        public void mo32603a(C9036d<C7832c> dVar) {
                        }
                    };
                    break;
                case 1:
                    eVar = new C7751d<>();
                    break;
                default:
                    eVar = new C7784g<>();
                    break;
            }
        } else {
            Object createGoodsRequest = LiteIAPHWServiceProxy.createGoodsRequest();
            eVar = createGoodsRequest instanceof C9037e ? (C9037e) createGoodsRequest : new C7775d<>();
        }
        this.dVq = eVar;
        return eVar;
    }

    public C9037e<C7827b> aEK() {
        C9037e<C7827b> eVar;
        if (this.dVr != null) {
            return this.dVr;
        }
        int i = this.bmj;
        if (i != 4) {
            switch (i) {
                case 0:
                    eVar = new C9037e<C7827b>() {
                        /* renamed from: a */
                        public void mo32603a(C9036d<C7827b> dVar) {
                        }
                    };
                    break;
                case 1:
                    eVar = new C7753e<>();
                    break;
                default:
                    eVar = new C7786h<>();
                    break;
            }
        } else {
            Object createPurchaseRequest = LiteIAPHWServiceProxy.createPurchaseRequest();
            eVar = createPurchaseRequest instanceof C9037e ? (C9037e) createPurchaseRequest : new C7769c<>();
        }
        this.dVr = eVar;
        return eVar;
    }
}
