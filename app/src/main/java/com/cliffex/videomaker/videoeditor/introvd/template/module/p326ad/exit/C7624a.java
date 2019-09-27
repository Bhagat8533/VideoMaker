package com.introvd.template.module.p326ad.exit;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.support.p021v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnClickListener;
import com.introvd.template.ads.AdParamMgr;
import com.introvd.template.ads.entity.AdPositionInfoParam;
import com.introvd.template.ads.listener.InterstitialAdsListener;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.module.ad.R;
import com.introvd.template.module.p326ad.C7588a;
import com.introvd.template.module.p326ad.C7640f;
import com.introvd.template.module.p326ad.C7678j;
import com.introvd.template.module.p326ad.C7680l;
import com.introvd.template.module.p326ad.p334h.C7663d;
import com.introvd.template.module.p326ad.p337i.C7665a;
import com.introvd.template.router.iap.IapServiceProxy;
import java.util.concurrent.TimeUnit;
import p037b.p050b.C1834l;
import p037b.p050b.C1838m;
import p037b.p050b.C1839n;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p057e.C1517e;
import p037b.p050b.p076j.C1820a;

/* renamed from: com.introvd.template.module.ad.exit.a */
public class C7624a {
    /* access modifiers changed from: private */
    public static boolean dMC = false;
    /* access modifiers changed from: private */
    public static int dMD = 16;
    private static C1495b dME;
    /* access modifiers changed from: private */
    public static C7635b dMF;

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static void m22420a(Activity activity, boolean z, final Runnable runnable) {
        if (activity != null && !activity.isFinishing()) {
            if (!z) {
                dME = null;
            }
            if (dMF == null || !dMF.isShowing()) {
                dMF = new C7635b(activity) {
                    /* access modifiers changed from: 0000 */
                    public void aAp() {
                        runnable.run();
                    }
                };
                dMF.setOnDismissListener(new OnDismissListener() {
                    public void onDismiss(DialogInterface dialogInterface) {
                        C7624a.dMF = null;
                    }
                });
                final View decorView = activity.getWindow().getDecorView();
                decorView.post(new Runnable() {
                    public void run() {
                        if (decorView.getParent() != null && C7624a.dMF != null) {
                            C7624a.dMF.show();
                        }
                    }
                });
            }
            dMF.mo32514ix(z);
        }
    }

    /* renamed from: a */
    public static boolean m22421a(Activity activity, Runnable runnable) {
        if (dMC) {
            return true;
        }
        m22422aA(activity);
        if (m22423aB(activity)) {
            m22426b(activity, runnable);
            return true;
        } else if (!m22424aC(activity)) {
            return false;
        } else {
            m22428c(activity, runnable);
            return true;
        }
    }

    /* renamed from: aA */
    private static void m22422aA(Activity activity) {
        if (activity != null && !activity.isFinishing() && activity.getWindow() != null) {
            final View decorView = activity.getWindow().getDecorView();
            int i = R.id.ad_tag_extra;
            if (!(decorView.getTag(i) instanceof Boolean) || !((Boolean) decorView.getTag(i)).booleanValue()) {
                decorView.setTag(i, Boolean.valueOf(true));
                decorView.addOnAttachStateChangeListener(new OnAttachStateChangeListener() {
                    public void onViewAttachedToWindow(View view) {
                    }

                    public void onViewDetachedFromWindow(View view) {
                        C7624a.aAk();
                        C7680l.aAe().releasePosition(C7624a.dMD, true);
                        decorView.removeOnAttachStateChangeListener(this);
                        if (C7624a.dMF != null) {
                            if (C7624a.dMF.isShowing()) {
                                C7624a.dMF.cancel();
                            }
                            C7624a.dMF = null;
                        }
                        LogUtilsV2.m14228e("releaseDell releaseDell releaseDell");
                    }
                });
            }
        }
    }

    private static boolean aAi() {
        return AdParamMgr.getAdType(dMD) == 2;
    }

    /* access modifiers changed from: private */
    public static void aAj() {
        C1834l.m5254a((C1839n<T>) new C1839n<Object>() {
            /* renamed from: a */
            public void mo10177a(C1838m<Object> mVar) throws Exception {
                C7663d.m22484C("ExitInterstitial", C7663d.m22486km("ExitInterstitial") + 1);
            }
        }).mo10157d(C1820a.aVj()).aTR();
    }

    /* access modifiers changed from: private */
    public static void aAk() {
        if (dME != null && !dME.aAy()) {
            dME.dispose();
        }
    }

    private static boolean aAl() {
        int km = C7663d.m22486km("ExitInterstitial");
        Integer V = C7588a.m22357V(AdParamMgr.getExtraInfoByKey(dMD, "show"));
        return km < Integer.valueOf(V == null ? 0 : V.intValue()).intValue();
    }

    /* renamed from: aB */
    private static boolean m22423aB(Activity activity) {
        return aAi() && C7680l.aAe().isAdAvailable(activity, dMD) && !((Boolean) IapServiceProxy.execute(IapServiceProxy.isPurchasedAd, new Object[0])).booleanValue() && aAl();
    }

    /* renamed from: aC */
    private static boolean m22424aC(Activity activity) {
        C7640f aAe = C7680l.aAe();
        if (!aAi()) {
            return (aAe.isAdAvailable(activity, dMD) || aAe.getAdView(activity, dMD) != null) && !((Boolean) IapServiceProxy.execute(IapServiceProxy.isPurchasedAd, new Object[0])).booleanValue();
        }
        return false;
    }

    /* renamed from: ax */
    public static boolean m22425ax(Activity activity) {
        return m22423aB(activity) || m22424aC(activity);
    }

    /* renamed from: b */
    private static void m22426b(final Activity activity, final Runnable runnable) {
        if (!dMC) {
            dMC = true;
            m22420a(activity, true, runnable);
            aAk();
            dME = C1834l.m5261d(800, TimeUnit.MILLISECONDS).mo10152c(C1487a.aUa()).mo10168g((C1517e<? super T>) new C1517e<Long>() {
                /* renamed from: i */
                public void accept(Long l) throws Exception {
                    final FragmentActivity fragmentActivity = (FragmentActivity) activity;
                    C7680l.aAe().mo32531h(C7624a.dMD, new InterstitialAdsListener() {
                        public void onAdLoaded(AdPositionInfoParam adPositionInfoParam, boolean z, String str) {
                        }
                    });
                    C7680l.aAe().mo32527ak(activity, C7624a.dMD);
                    C7624a.aAj();
                }
            });
        }
    }

    /* renamed from: c */
    private static void m22428c(final Activity activity, final Runnable runnable) {
        LogUtilsV2.m14228e("showExitAd   ------------");
        try {
            if (!dMC) {
                C76327 r0 = new C7665a(activity, dMD) {
                    public boolean onKeyUp(int i, KeyEvent keyEvent) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(keyEvent.toString());
                        sb.append("   ");
                        sb.append(keyEvent.getFlags());
                        LogUtils.m14222e("onKeyUp", sb.toString());
                        KeyEvent keyEvent2 = new KeyEvent(keyEvent.getDownTime(), keyEvent.getEventTime(), keyEvent.getAction(), keyEvent.getKeyCode(), keyEvent.getRepeatCount(), keyEvent.getMetaState(), keyEvent.getDeviceId(), keyEvent.getScanCode(), 584, keyEvent.getSource());
                        return super.onKeyUp(i, keyEvent2);
                    }
                };
                r0.mo32558d((OnClickListener) new OnClickListener() {
                    public void onClick(View view) {
                        if (runnable != null) {
                            runnable.run();
                        }
                    }
                });
                r0.setOnDismissListener(new OnDismissListener() {
                    public void onDismiss(DialogInterface dialogInterface) {
                        C7680l.aAe().mo32526aj(activity, C7624a.dMD);
                        C7624a.dMC = false;
                    }
                });
                r0.show();
                dMC = true;
            }
        } catch (Exception e) {
            C7678j.aAd().logException(e);
        }
    }

    /* renamed from: gk */
    public static void m22429gk(Context context) {
        if (aAi() ? aAl() : true) {
            C7680l.aAe().mo32526aj(context, dMD);
        }
    }
}
