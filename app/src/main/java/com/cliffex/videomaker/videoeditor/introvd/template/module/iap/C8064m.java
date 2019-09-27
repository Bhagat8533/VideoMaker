package com.introvd.template.module.iap;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.router.p377ad.AdServiceProxy;
import p037b.p050b.C1834l;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p057e.C1517e;

/* renamed from: com.introvd.template.module.iap.m */
public class C8064m implements C8063l {
    private static C8063l dOX;
    private C1495b cTc;
    /* access modifiers changed from: private */
    public String ttid;

    private C8064m() {
    }

    public static C8063l aBv() {
        return dOX == null ? new C8063l() {
            /* renamed from: aI */
            public void mo33115aI(Activity activity) {
            }

            /* renamed from: aJ */
            public void mo33116aJ(Activity activity) {
            }

            /* renamed from: b */
            public void mo33117b(View view, String str) {
            }
        } : dOX;
    }

    public static void init() {
        dOX = new C8064m();
    }

    @SuppressLint({"CheckResult"})
    /* renamed from: aI */
    public void mo33115aI(Activity activity) {
        boolean z;
        LogUtilsV2.m14228e("iapBck     ");
        String str = this.ttid;
        this.ttid = null;
        if (str != null) {
            if (C8049f.aBf().isNeedToPurchase(str)) {
                C8071p aBx = C8072q.aBx();
                StringBuilder sb = new StringBuilder();
                sb.append("iap.template.");
                sb.append(str);
                if (!aBx.mo33072ku(sb.toString().toLowerCase())) {
                    z = true;
                    if (!C8072q.aBx().isVip() && z) {
                        if (this.cTc != null && !this.cTc.aAy()) {
                            this.cTc.dispose();
                        }
                        ((C1834l) AdServiceProxy.execute(AdServiceProxy.observableShowUnlockTemplate, activity, str, Boolean.valueOf(false))).mo10128a((C1517e<? super T>) new C1517e<Integer>() {
                            /* renamed from: j */
                            public void accept(Integer num) throws Exception {
                            }
                        }, (C1517e<? super Throwable>) new C1517e<Throwable>() {
                            /* renamed from: m */
                            public void accept(Throwable th) throws Exception {
                            }
                        });
                    }
                }
            }
            z = false;
            this.cTc.dispose();
            ((C1834l) AdServiceProxy.execute(AdServiceProxy.observableShowUnlockTemplate, activity, str, Boolean.valueOf(false))).mo10128a((C1517e<? super T>) new C1517e<Integer>() {
                /* renamed from: j */
                public void accept(Integer num) throws Exception {
                }
            }, (C1517e<? super Throwable>) new C1517e<Throwable>() {
                /* renamed from: m */
                public void accept(Throwable th) throws Exception {
                }
            });
        }
    }

    /* renamed from: aJ */
    public void mo33116aJ(Activity activity) {
        StringBuilder sb = new StringBuilder();
        sb.append("clear   ");
        sb.append(activity.isFinishing());
        LogUtilsV2.m14228e(sb.toString());
        if (activity.isFinishing()) {
            if (this.cTc != null && !this.cTc.aAy()) {
                this.cTc.dispose();
            }
            dOX = null;
        }
    }

    /* renamed from: b */
    public void mo33117b(View view, final String str) {
        view.setAccessibilityDelegate(new AccessibilityDelegate() {
            public void sendAccessibilityEvent(View view, int i) {
                super.sendAccessibilityEvent(view, i);
                if (view != null && 1 == i) {
                    C8064m.this.ttid = str;
                }
            }
        });
    }
}
