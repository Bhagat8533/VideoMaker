package com.introvd.template.app.splash;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import com.introvd.template.C3569a;
import com.introvd.template.R;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.app.ApplicationBase;
import com.introvd.template.app.C3740b;
import com.introvd.template.app.C4037m;
import com.introvd.template.app.utils.C4395c;
import com.introvd.template.app.welcomepage.WelcomeV6Activity;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.MagicCode;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.common.Utils;
import com.introvd.template.crash.C5523b;
import com.introvd.template.crash.C5526d;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.router.shell.IYYBProService.AuthListener;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import p037b.p050b.C1834l;
import p037b.p050b.C1842q;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p055c.C1505b;
import p037b.p050b.p057e.C1517e;
import p037b.p050b.p057e.C1518f;
import p037b.p050b.p076j.C1820a;

/* renamed from: com.introvd.template.app.splash.e */
public class C4370e {
    public boolean bEG = false;

    /* renamed from: com.introvd.template.app.splash.e$a */
    public interface C4377a {
        /* renamed from: bP */
        void mo24405bP(boolean z);
    }

    /* renamed from: com.introvd.template.app.splash.e$b */
    static abstract class C4378b implements AuthListener {
        C4378b() {
        }

        /* renamed from: PO */
        public abstract void mo24401PO();

        public void onAuthFailed(int i) {
            StringBuilder sb = new StringBuilder();
            String str = "o s YaeaeBtl=nAuCkAFolctdidef  hhChuY";
            sb.append("YYB Auth Check onAuthFailed failCode=");
            sb.append(i);
            LogUtilsV2.m14227d(sb.toString());
        }
    }

    /* renamed from: QA */
    public static boolean m10999QA() {
        return C4368d.m10988Qu().bEC;
    }

    /* renamed from: QB */
    public static boolean m11000QB() {
        String str = "aosYeWRitkfiintAacvieXg";
        Object magicParam = MagicCode.getMagicParam(0, "XiaoYingActivityWeakRef", null);
        if (magicParam != null) {
            try {
                if (((Activity) ((WeakReference) magicParam).get()) != null) {
                    return true;
                }
            } catch (ClassCastException e) {
                e.printStackTrace();
            }
        }
        WeakReference Hf = C3740b.m9101He().mo23111Hf();
        if (Hf != null && (Hf.get() instanceof WelcomeV6Activity)) {
            return true;
        }
        return false;
    }

    /* renamed from: QC */
    private static boolean m11001QC() {
        if (!C4580b.m11631B(VivaBaseApplication.m8749FZ(), "com.diii.vending")) {
            if (!C4580b.m11631B(VivaBaseApplication.m8749FZ(), "com.google.market")) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: Qz */
    public static void m11002Qz() {
        C1834l.m5257ah(Boolean.valueOf(true)).mo10157d(C1820a.aVi()).mo10152c(C1820a.aVj()).mo10161e((C1517e<? super T>) new C1517e<Boolean>() {
            /* renamed from: d */
            public void accept(Boolean bool) {
                C4368d.m10988Qu().mo24424Qv();
            }
        }).aTR();
    }

    /* renamed from: a */
    public static void m11003a(Activity activity, C4378b bVar) {
        bVar.onAuthSuceed();
    }

    /* renamed from: a */
    public static void m11004a(final C4377a aVar) {
        C1834l.m5257ah(Boolean.valueOf(true)).mo10157d(C1820a.aVi()).mo10152c(C1820a.aVi()).mo10167f((C1518f<? super T, ? extends R>) new C1518f<Boolean, Boolean>() {
            /* renamed from: c */
            public Boolean apply(Boolean bool) throws Exception {
                String str = " Iset oechinCkn";
                LogUtilsV2.m14227d("Check Init Done");
                Thread.sleep(50);
                if (ApplicationBase.bir && C4368d.m10988Qu().bEA && C4368d.m10988Qu().bEB) {
                    return Boolean.valueOf(true);
                }
                throw C1505b.m4703z(new C5526d());
            }
        }).mo10150bT(2400).mo10152c(C1487a.aUa()).mo10149b((C1842q<? super T>) new C1842q<Boolean>() {
            /* renamed from: a */
            public void mo9877a(C1495b bVar) {
            }

            /* renamed from: b */
            public void mo9886K(Boolean bool) {
                StringBuilder sb = new StringBuilder();
                String str = " Csteonnk hix =tNcI ";
                sb.append("Check Init onNext = ");
                sb.append(bool);
                LogUtilsV2.m14227d(sb.toString());
                if (aVar != null) {
                    aVar.mo24405bP(true);
                }
            }

            public void onComplete() {
            }

            public void onError(Throwable th) {
                LogUtilsV2.m14227d("Check Init onError = ");
                C5523b.logException(new C5526d("ServiceInit cost more than 120s!"));
                if (aVar != null) {
                    aVar.mo24405bP(false);
                }
            }
        });
    }

    /* renamed from: a */
    public static void m11005a(final C4379f fVar) {
        C1834l.m5257ah(Boolean.valueOf(true)).mo10157d(C1820a.aVi()).mo10152c(C1820a.aVi()).mo10164f(80, TimeUnit.MILLISECONDS).mo10152c(C1487a.aUa()).mo10149b((C1842q<? super T>) new C1842q<Boolean>() {
            /* renamed from: a */
            public void mo9877a(C1495b bVar) {
            }

            /* renamed from: b */
            public void mo9886K(Boolean bool) {
                if (fVar != null) {
                    fVar.mo24436QD();
                }
            }

            public void onComplete() {
            }

            public void onError(Throwable th) {
            }
        });
    }

    /* renamed from: cT */
    private void m11006cT(final Context context) {
        C1834l.m5257ah(Boolean.valueOf(true)).mo10157d(C1820a.aVi()).mo10152c(C1820a.aVi()).mo10167f((C1518f<? super T, ? extends R>) new C1518f<Boolean, Boolean>() {
            /* renamed from: c */
            public Boolean apply(Boolean bool) throws Exception {
                return Boolean.valueOf(Utils.isOfficalVersion(context) && !C4395c.m11100dg(context) && !C4580b.m11647dB(context));
            }
        }).mo10152c(C1487a.aUa()).mo10149b((C1842q<? super T>) new C1842q<Boolean>() {
            /* renamed from: a */
            public void mo9877a(C1495b bVar) {
            }

            /* renamed from: b */
            public void mo9886K(Boolean bool) {
                if (bool.booleanValue()) {
                    ToastUtils.show(context, R.string.xiaoying_str_ve_illegal_version_prompt, 1);
                }
            }

            public void onComplete() {
            }

            public void onError(Throwable th) {
            }
        });
    }

    /* renamed from: b */
    public boolean mo24428b(SplashActivity splashActivity, Intent intent) {
        m11006cT(splashActivity.getApplicationContext());
        this.bEG = intent.getBooleanExtra("splash_show_mode", false);
        if (!this.bEG) {
            String str = "aeemead_iety_tnbu_tnynlt_dp";
            int intExtra = intent.getIntExtra("intent_bundle_data_type_key", -1);
            if (intExtra >= 0) {
                if (intExtra == 1 || intExtra == 2) {
                    Intent intent2 = new Intent();
                    String str2 = "eri.oGmradee.ulVhvoqMLoiuy.yan_coglcax_";
                    intent2.setAction("com.introvd.template.Gallery_MV_Laucher");
                    intent2.putExtra("CaptureMode", intExtra == 1 ? 408 : 201);
                    String str3 = "cLeiib.F.totndoaAyrE.gUnentTadr";
                    intent2.addCategory("android.intent.category.DEFAULT");
                    intent2.setFlags(603996160);
                    try {
                        splashActivity.startActivity(intent2);
                    } catch (ActivityNotFoundException e) {
                        C5523b.logException(e);
                    }
                }
                return true;
            } else if (m11000QB()) {
                C4037m.m10025a(splashActivity, intent);
                return true;
            }
        } else {
            C3569a.m8775FN();
        }
        return false;
    }
}
