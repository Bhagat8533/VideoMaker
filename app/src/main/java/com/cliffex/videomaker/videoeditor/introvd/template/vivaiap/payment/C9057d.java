package com.introvd.template.vivaiap.payment;

import android.content.Context;
import com.introvd.template.vivaiap.base.C9022a;

/* renamed from: com.introvd.template.vivaiap.payment.d */
public abstract class C9057d {
    private static C9062f eBj;

    /* renamed from: com.introvd.template.vivaiap.payment.d$a */
    public static class C9058a {
        private C9022a eAY;
        private C9062f eBj;
        private C9056c eBk;

        public C9058a(C9056c cVar) {
            this.eBk = cVar;
        }

        public C9057d aND() {
            C9059e eVar = new C9059e();
            eVar.mo35898a(this.eAY);
            eVar.mo35899a(this.eBk);
            eVar.mo35900a(this.eBj);
            return eVar;
        }

        /* renamed from: b */
        public C9058a mo35903b(C9022a aVar) {
            this.eAY = aVar;
            return this;
        }

        /* renamed from: b */
        public C9058a mo35904b(C9062f fVar) {
            this.eBj = fVar;
            return this;
        }
    }

    static C9062f aNC() {
        return eBj;
    }

    /* renamed from: a */
    public abstract void mo35897a(Context context, PayParam payParam, C9054a aVar);

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public abstract void mo35898a(C9022a aVar);

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public abstract void mo35899a(C9056c cVar);

    /* renamed from: a */
    public void mo35900a(C9062f fVar) {
        eBj = fVar;
    }

    /* renamed from: qZ */
    public abstract boolean mo35901qZ(String str);
}
