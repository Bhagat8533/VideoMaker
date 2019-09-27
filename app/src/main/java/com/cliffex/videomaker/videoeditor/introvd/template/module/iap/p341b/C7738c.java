package com.introvd.template.module.iap.p341b;

import android.content.Context;
import android.util.SparseArray;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.module.iap.C8048e;
import com.introvd.template.module.iap.business.coupon.C7858e;
import com.introvd.template.module.iap.business.p349a.C7825a;
import com.introvd.template.module.iap.business.p349a.C7827b;
import com.introvd.template.module.iap.business.p349a.C7832c;
import com.introvd.template.module.iap.business.p352b.C7835b;
import com.introvd.template.module.iap.business.p356e.C7899c;
import com.introvd.template.module.iap.business.vip.C8009a;
import com.introvd.template.module.iap.p341b.p342a.C7723c;
import com.introvd.template.module.iap.p341b.p343b.C7733a;
import com.introvd.template.module.iap.p341b.p343b.C7735c;
import com.introvd.template.module.iap.p341b.p343b.C7736d;
import com.introvd.template.module.iap.p341b.p345d.C7765b;
import com.introvd.template.router.kiwi.LDPProtect;
import com.introvd.template.vivaiap.base.p417a.C9023a;
import com.introvd.template.vivaiap.coffer.C9035c;
import com.introvd.template.vivaiap.coffer.C9037e;
import com.introvd.template.vivaiap.coffer.C9038f;
import com.introvd.template.vivaiap.dispatcher.C9043a;
import com.introvd.template.vivaiap.dispatcher.C9044b;
import com.introvd.template.vivaiap.payment.C9054a;
import com.introvd.template.vivaiap.payment.C9056c;
import com.introvd.template.vivaiap.payment.C9062f;
import com.introvd.template.vivaiap.payment.PayResult;
import com.introvd.template.vivaiap.warehouse.C9067a;
import com.introvd.template.vivaiap.warehouse.C9070d;
import com.introvd.template.vivaiap.warehouse.C9082h;
import com.quvideo.plugin.payclient.common.C4852b;
import com.quvideo.plugin.payclient.common.C4859c;
import java.util.Iterator;
import java.util.List;
import org.greenrobot.eventbus.C10021c;

@LDPProtect
/* renamed from: com.introvd.template.module.iap.b.c */
public class C7738c extends C9043a<C7832c, C7827b> {
    private SparseArray<C7723c> dVd;
    private C7723c dVe;

    /* renamed from: com.introvd.template.module.iap.b.c$a */
    private static class C7744a {
        static final C7738c dVh = new C7738c();
    }

    private C7738c() {
        this.dVd = new SparseArray<>();
        if (C8048e.aBe().isInChina()) {
            C4852b.m12465a(C7718a.class.getSimpleName(), (C4859c) new C7718a());
        }
    }

    public static C7738c aEv() {
        return C7744a.dVh;
    }

    /* access modifiers changed from: private */
    public int aEx() {
        List wS = aEv().aNx().mo35914wS();
        int i = 0;
        if (wS == null || wS.isEmpty()) {
            return 0;
        }
        Iterator it = wS.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            C7827b bVar = (C7827b) it.next();
            if (bVar != null && bVar.isValid()) {
                i = 1;
                break;
            }
        }
        return i;
    }

    /* access modifiers changed from: private */
    public C7723c aEy() {
        if (this.dVe == null) {
            refresh();
        }
        return this.dVe;
    }

    /* renamed from: sM */
    private C7723c m22654sM(int i) {
        C7723c cVar = (C7723c) this.dVd.get(i);
        if (cVar != null) {
            return cVar;
        }
        C7723c cVar2 = new C7723c(i);
        this.dVd.put(i, cVar2);
        return cVar2;
    }

    /* renamed from: EO */
    public final boolean mo32610EO() {
        return aEy().mo32598EO();
    }

    /* renamed from: a */
    public final void mo32611a(Context context, String str, String str2, int i, C9054a aVar) {
        m22654sM(i).aEI().mo32653a(context, str, str2, aVar);
    }

    /* renamed from: a */
    public final void mo32612a(Context context, String str, String str2, C9054a aVar) {
        aEy().aEI().mo32653a(context, str, str2, aVar);
    }

    /* access modifiers changed from: protected */
    public C9044b<C7832c, C7827b> aEw() {
        return new C9044b<C7832c, C7827b>() {
            /* access modifiers changed from: protected */
            public C9082h aEA() {
                return new C9082h() {
                    /* renamed from: a */
                    public void mo32622a(int i, C9023a aVar) {
                    }

                    public void aDC() {
                        C10021c.aZH().mo38492aA(new C7733a());
                    }

                    public void aEG() {
                        C7735c cVar = new C7735c();
                        cVar.mo32608sN(C7738c.this.aEx());
                        C10021c.aZH().mo38492aA(cVar);
                        C8009a.m23201du(1, 1);
                        C8009a.m23200cb(C8048e.aBe().getContext(), null);
                        C7899c.aDg().setBoolean("vip_key_can_remove_ad", C7738c.this.aNy().mo35906rh(C7825a.AD.getId()));
                        C7835b.aCS();
                    }
                };
            }

            /* access modifiers changed from: protected */
            public C9037e<C7832c> aEB() {
                return C7738c.this.aEy().aEJ();
            }

            /* access modifiers changed from: protected */
            public C9037e<C7827b> aEC() {
                return C7738c.this.aEy().aEK();
            }

            /* access modifiers changed from: protected */
            public C9056c aED() {
                return new C7791e();
            }

            /* access modifiers changed from: protected */
            public C9062f aEE() {
                return new C9062f() {
                    /* renamed from: b */
                    public void mo32625b(PayResult payResult) {
                        if (payResult != null) {
                            int sq = C7858e.m22927sq(payResult.getCode());
                            if (!payResult.isSuccess() && sq > 0) {
                                ToastUtils.show(C8048e.aBe().getContext(), sq, 0);
                            }
                            C10021c.aZH().mo38492aA(C7765b.m22705d(payResult));
                        }
                    }
                };
            }

            /* access modifiers changed from: protected */
            public C9035c<C7832c, C7827b> aEF() {
                return new C9035c<C7832c, C7827b>() {
                    /* renamed from: a */
                    public void mo32626a(C9038f fVar, List<C7832c> list) {
                    }

                    /* renamed from: b */
                    public void mo32627b(C9038f fVar, List<C7827b> list) {
                        C10021c.aZH().mo38492aA(new C7736d(fVar));
                    }
                };
            }

            /* access modifiers changed from: protected */
            public C9067a<C7827b> aEz() {
                return C8048e.aBe().mo23632Mx() ? new C9067a<C7827b>() {
                    /* renamed from: a */
                    public boolean mo32604a(C9070d<C7827b> dVar, String str) {
                        return true;
                    }
                } : new C7760d();
            }
        };
    }

    public final void refresh() {
        int i = 1;
        if (C8048e.aBe().mo23629Mu()) {
            i = 4;
        } else if (C8048e.aBe().mo23628Mt()) {
            i = 2;
        } else if (!C8048e.aBe().mo23630Mv() && C8048e.aBe().isInChina()) {
            i = 3;
        }
        this.dVe = new C7723c(i);
    }
}
