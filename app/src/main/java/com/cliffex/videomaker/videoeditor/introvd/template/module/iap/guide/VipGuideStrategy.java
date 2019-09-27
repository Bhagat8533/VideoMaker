package com.introvd.template.module.iap.guide;

import android.app.Activity;
import android.arch.lifecycle.C0061e.C0062a;
import android.arch.lifecycle.C0068f;
import android.arch.lifecycle.C0069g;
import android.arch.lifecycle.C0078n;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.introvd.template.module.iap.C8048e;
import com.introvd.template.module.iap.C8049f;
import com.introvd.template.module.iap.C8070o;
import com.introvd.template.module.iap.C8072q;
import com.introvd.template.module.iap.business.home.C7971c;
import com.introvd.template.module.iap.business.p349a.C7825a;
import com.introvd.template.module.iap.business.p352b.C7835b;
import com.introvd.template.module.iap.business.p356e.C7899c;
import com.introvd.template.module.iap.business.vip.C8009a;
import com.introvd.template.module.iap.p341b.C7738c;
import java.util.Calendar;

public final class VipGuideStrategy {
    private static VipGuideLifeCycleObserver dUU = new VipGuideLifeCycleObserver();
    /* access modifiers changed from: private */
    public static C8055a dUV;
    private static String dUW = "key_first_guide_show";
    private static int dUX = C7899c.aDg().getInt("guide_shown_index", -1);
    private static C8054a[] dUY = {new C8054a(0, 3, 7), new C8054a(1, 7, 15), new C8054a(2, 15, 30), new C8054a(3, 30, 60), new C8054a(4, 60, Integer.MAX_VALUE)};
    private static int periodIndex = 2;

    private static class VipGuideLifeCycleObserver implements C0068f {
        private C0069g bqs;
        private boolean bqt;

        private VipGuideLifeCycleObserver() {
            this.bqt = true;
        }

        /* access modifiers changed from: private */
        /* renamed from: j */
        public void m23383j(C0069g gVar) {
            this.bqs = gVar;
        }

        @C0078n(mo161n = C0062a.ON_PAUSE)
        public void onPause() {
            this.bqt = false;
        }

        @C0078n(mo161n = C0062a.ON_RESUME)
        public void onResume() {
            if (!this.bqt) {
                if (this.bqs != null) {
                    this.bqs.getLifecycle().mo153b(this);
                }
                if (VipGuideStrategy.dUV != null) {
                    VipGuideStrategy.dUV.onDismiss();
                }
            }
        }
    }

    /* renamed from: com.introvd.template.module.iap.guide.VipGuideStrategy$a */
    private static class C8054a {
        private int dUZ;
        private int dVa;
        /* access modifiers changed from: private */
        public int index;

        C8054a(int i, int i2, int i3) {
            this.index = i;
            this.dUZ = i2;
            this.dVa = i3;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: sL */
        public boolean mo33111sL(int i) {
            return i >= this.dUZ && i < this.dVa;
        }
    }

    /* renamed from: a */
    static void m23376a(C8055a aVar) {
        dUV = aVar;
    }

    public static boolean aBo() {
        boolean z = false;
        if (aEl() || isVip()) {
            return false;
        }
        if (C8048e.aBe().mo23611MC()) {
            return true;
        }
        int lF = m23380lF("guide_init_shown_timestamp");
        if (m23380lF("guide_last_shown_timestamp") < 7 && (!aEr() || lF < 3)) {
            return false;
        }
        C8054a[] aVarArr = dUY;
        int length = aVarArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            C8054a aVar = aVarArr[i];
            if (aVar != null && aVar.mo33111sL(lF) && aEq() < aVar.index) {
                z = true;
                break;
            }
            i++;
        }
        return z;
    }

    static void aEh() {
        dUV = null;
    }

    public static void aEk() {
        C7899c.aDg().setBoolean(dUW, true);
    }

    private static boolean aEl() {
        return C8048e.aBe().mo23610MB();
    }

    private static boolean aEm() {
        return C8072q.aBx().mo33072ku(C7825a.GOLD_MONTHLY.getId()) || C8072q.aBx().mo33072ku(C7825a.GOLD_YEARLY.getId());
    }

    private static void aEn() {
        C7899c.aDg().setLong("guide_init_shown_timestamp", System.currentTimeMillis());
        aEo();
    }

    private static void aEo() {
        C7899c.aDg().setLong("guide_last_shown_timestamp", System.currentTimeMillis());
    }

    private static boolean aEp() {
        int lF = m23380lF("guide_init_shown_timestamp");
        boolean z = false;
        if (m23380lF("guide_last_shown_timestamp") < 7 && (!aEr() || lF < 3)) {
            return false;
        }
        C8054a[] aVarArr = dUY;
        int length = aVarArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            C8054a aVar = aVarArr[i];
            if (aVar != null && aVar.mo33111sL(lF) && aEq() < aVar.index) {
                aEo();
                m23381sK(aVar.index);
                periodIndex = aVar.index + 2;
                z = true;
                break;
            }
            i++;
        }
        return z;
    }

    private static int aEq() {
        return dUX;
    }

    private static boolean aEr() {
        return dUX < 0;
    }

    /* renamed from: aP */
    static boolean m23377aP(Activity activity) {
        if (aEl() || isVip()) {
            return false;
        }
        boolean z = C7899c.aDg().getBoolean(dUW, false);
        boolean MC = C8048e.aBe().mo23611MC();
        if (!z && MC && !aEm()) {
            C7971c cVar = new C7971c(activity);
            cVar.setOnDismissListener(new OnDismissListener() {
                public void onDismiss(DialogInterface dialogInterface) {
                    if (VipGuideStrategy.dUV != null) {
                        VipGuideStrategy.dUV.onDismiss();
                    }
                }
            });
            cVar.show();
            C7971c.m23158iK(false);
            C7899c.aDg().setBoolean(dUW, true);
            C7835b.m22869v(1, "newTip");
            aEn();
            return true;
        } else if (C7738c.aEv().aNw().isEmpty() || !aEp() || C8048e.aBe().getContext() == null) {
            return false;
        } else {
            if (m23378aQ(activity)) {
                C7835b.m22869v(periodIndex, "upgrade");
                return true;
            }
            boolean h = m23379h(activity, "Autotrigger");
            if (h) {
                C7835b.m22869v(periodIndex, "vipBuy");
            }
            return h;
        }
    }

    /* renamed from: aQ */
    private static boolean m23378aQ(Activity activity) {
        if (!(activity instanceof C0069g)) {
            return false;
        }
        C0069g gVar = (C0069g) activity;
        dUU.m23383j(gVar);
        gVar.getLifecycle().mo152a(dUU);
        boolean gs = C8009a.m23202gs(activity);
        if (!gs) {
            gVar.getLifecycle().mo153b(dUU);
        }
        return gs;
    }

    /* renamed from: h */
    private static boolean m23379h(Activity activity, String str) {
        if (!(activity instanceof C0069g)) {
            return false;
        }
        C0069g gVar = (C0069g) activity;
        dUU.m23383j(gVar);
        gVar.getLifecycle().mo152a(dUU);
        C8049f.aBf().mo33097b(activity, C8070o.aBw(), null, str, -1);
        return true;
    }

    private static boolean isVip() {
        return C8072q.aBx().mo33072ku(C7825a.PLATINUM_MONTHLY.getId()) || C8072q.aBx().mo33072ku(C7825a.PLATINUM_YEARLY.getId());
    }

    /* renamed from: lF */
    private static int m23380lF(String str) {
        long j = C7899c.aDg().getLong(str, System.currentTimeMillis());
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        int i = instance.get(1);
        int i2 = instance.get(6);
        Calendar instance2 = Calendar.getInstance();
        instance2.setTimeInMillis(System.currentTimeMillis());
        return Math.max(0, ((((instance2.get(1) - i) * 365) + instance2.get(6)) - i2) + 1);
    }

    /* renamed from: sK */
    private static void m23381sK(int i) {
        C7899c.aDg().setInt("guide_shown_index", i);
        dUX = i;
    }
}
