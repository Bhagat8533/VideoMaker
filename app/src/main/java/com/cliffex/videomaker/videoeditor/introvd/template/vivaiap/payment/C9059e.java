package com.introvd.template.vivaiap.payment;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.p021v4.content.LocalBroadcastManager;
import com.introvd.template.vivaiap.base.C9022a;
import java.util.LinkedList;
import java.util.Queue;

/* renamed from: com.introvd.template.vivaiap.payment.e */
class C9059e extends C9057d {
    /* access modifiers changed from: private */
    public static C9022a eAY;
    private static C9056c eBl;
    /* access modifiers changed from: private */
    public static C9054a eBm = new C9054a() {
        /* renamed from: a */
        public void mo32328a(PayResult payResult) {
            C9062f aNC = C9057d.aNC();
            if (aNC != null) {
                aNC.mo32625b(payResult);
            }
            if (C9059e.eAY != null && payResult != null && payResult.isSuccess() && payResult.aNA()) {
                C9059e.eAY.aNs();
            }
        }
    };
    private static Queue<C9054a> eBn = new LinkedList();

    /* renamed from: com.introvd.template.vivaiap.payment.e$a */
    private static class C9061a extends BroadcastReceiver {
        private C9054a eBm;

        public C9061a(C9054a aVar) {
            this.eBm = aVar;
        }

        public void onReceive(Context context, Intent intent) {
            LocalBroadcastManager.getInstance(context).unregisterReceiver(this);
            if (intent != null) {
                PayResult payResult = (PayResult) intent.getParcelableExtra("payment_pay_result");
                C9059e.eBm.mo32328a(payResult);
                if (this.eBm != null) {
                    this.eBm.mo32328a(payResult);
                }
            }
        }
    }

    C9059e() {
    }

    /* renamed from: a */
    private void m26483a(Context context, PayParam payParam) {
        if (eBl != null) {
            if (payParam == null) {
                throw new IllegalArgumentException("PayParam can't be null.");
            } else if (eBl.mo32652lI(payParam.aEO()) != null) {
                Intent intent = new Intent(context, ProxyPayActivity.class);
                if (!(context instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                intent.putExtra("payment_buy_intent", payParam);
                context.startActivity(intent);
            }
        }
    }

    /* renamed from: a */
    static void m26484a(Context context, PayResult payResult) {
        m26486hu(context);
        Intent intent = new Intent("com.introvd.template.vivaiap.payment.result.filter");
        intent.putExtra("payment_pay_result", payResult);
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
        LocalBroadcastManager.getInstance(context).sendBroadcast(new Intent("com.introvd.template.vivaiap.payment.finish.filter"));
    }

    /* renamed from: a */
    static void m26485a(Context context, boolean z, int i, String str, PayParam payParam) {
        PayResult payResult = new PayResult(z, i, payParam != null ? payParam.aAB() : "", str);
        payResult.mo35877jN(payParam == null || payParam.aNA());
        m26484a(context, payResult);
    }

    /* renamed from: hu */
    private static void m26486hu(Context context) {
        LocalBroadcastManager.getInstance(context).registerReceiver(new C9061a((C9054a) eBn.poll()), new IntentFilter("com.introvd.template.vivaiap.payment.result.filter"));
    }

    /* renamed from: rg */
    static C9055b m26487rg(String str) {
        if (eBl == null) {
            return null;
        }
        return eBl.mo32652lI(str);
    }

    /* renamed from: a */
    public void mo35897a(Context context, PayParam payParam, C9054a aVar) {
        eBn.add(aVar);
        m26483a(context, payParam);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo35898a(C9022a aVar) {
        eAY = aVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo35899a(C9056c cVar) {
        eBl = cVar;
    }

    /* renamed from: qZ */
    public boolean mo35901qZ(String str) {
        return eBl != null && eBl.mo35896qZ(str);
    }
}
