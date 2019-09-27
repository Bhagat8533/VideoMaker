package com.introvd.template.app.splash;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.afollestad.materialdialogs.C1890f;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.p363o.C8092b;
import com.introvd.template.p363o.C8093c;
import com.introvd.template.p363o.C8099d;
import com.introvd.template.p363o.C8106f;
import com.p131c.p132a.C2561a;
import com.vivavideo.component.permission.C9295b;
import com.vivavideo.component.permission.C9296c;
import java.util.List;

/* renamed from: com.introvd.template.app.splash.f */
class C4379f {
    /* access modifiers changed from: private */
    public Activity activity;
    /* access modifiers changed from: private */
    public boolean bEK = false;
    private C8099d bEL;
    private C1890f bEM;
    private C1890f bEN;

    public C4379f(Activity activity2, C8099d dVar) {
        this.activity = activity2;
        this.bEL = dVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: PP */
    public void m11022PP() {
        if (this.bEL != null) {
            this.bEL.mo24403PP();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: PQ */
    public void m11023PQ() {
        if (this.bEL != null) {
            this.bEL.mo24404PQ();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: QE */
    public void m11024QE() {
        if (this.activity != null) {
            this.bEN = C8093c.m23475a(0, this.activity, new OnClickListener() {
                public void onClick(View view) {
                    C9295b.m26987g(C4379f.this.activity, 2049);
                }
            }, new OnClickListener() {
                public void onClick(View view) {
                    C4379f.this.m11023PQ();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: QF */
    public boolean m11025QF() {
        return C9295b.m26985b(this.activity, C8092b.dXu);
    }

    /* renamed from: QG */
    private boolean m11026QG() {
        return C9295b.m26985b(this.activity, C8092b.dXt);
    }

    /* access modifiers changed from: private */
    /* renamed from: QH */
    public void m11027QH() {
        C8106f.m23492ak(0, m11025QF());
        C8106f.m23492ak(6, m11026QG());
    }

    /* access modifiers changed from: private */
    /* renamed from: bS */
    public void m11031bS(boolean z) {
        this.bEK = true;
        C43834 r1 = new C9296c() {
            /* renamed from: QI */
            public void mo24442QI() {
                String str = "sesVaPowAneDeii nridyanvsmlis";
                LogUtilsV2.m14227d("VivaPermission onAlwaysDenied");
                C4379f.this.m11024QE();
            }

            /* renamed from: ao */
            public void mo24443ao(List<String> list) {
                C4379f.this.bEK = false;
                LogUtilsV2.m14227d("VivaPermission onPermissionGrant ");
                for (String str : list) {
                    StringBuilder sb = new StringBuilder();
                    String str2 = "iimmevs Von=t ssnGisPnernimoiaoarP";
                    sb.append("VivaPermission onPermissionGrant =");
                    sb.append(str);
                    LogUtilsV2.m14227d(sb.toString());
                }
                C4379f.this.m11022PP();
                C4379f.this.m11027QH();
            }

            /* renamed from: ap */
            public void mo24444ap(List<String> list) {
                C4379f.this.bEK = false;
                LogUtilsV2.m14227d("VivaPermission onPermissionDenied ");
                for (String str : list) {
                    StringBuilder sb = new StringBuilder();
                    String str2 = "sD=more ineVios aviomPsdseinneronii";
                    sb.append("VivaPermission onPermissionDenied =");
                    sb.append(str);
                    LogUtilsV2.m14227d(sb.toString());
                }
                if (C4379f.this.m11025QF()) {
                    C4379f.this.m11022PP();
                } else {
                    C4379f.this.m11023PQ();
                }
                C4379f.this.m11027QH();
            }
        };
        if (z) {
            C9295b.m26986bb(this.activity).mo36519m(C8092b.dXu).mo36515a((C9296c) r1).aPq();
        } else {
            C9295b.m26986bb(this.activity).mo36516a(C8092b.dXu, C8092b.dXt).mo36515a((C9296c) r1).aPq();
        }
    }

    /* renamed from: QD */
    public void mo24436QD() {
        if (this.activity != null) {
            if (!this.activity.isFinishing()) {
                if (m11025QF()) {
                    m11022PP();
                } else {
                    this.bEM = C8093c.m23477a(0, this.activity, true, new OnClickListener() {
                        public void onClick(View view) {
                            C4379f.this.m11031bS(C2561a.aOQ());
                        }
                    }, new OnClickListener() {
                        public void onClick(View view) {
                            C4379f.this.m11023PQ();
                        }
                    }, new OnCancelListener() {
                        public void onCancel(DialogInterface dialogInterface) {
                            C4379f.this.m11031bS(C2561a.aOQ());
                        }
                    });
                }
            }
        }
    }

    public boolean isShowing() {
        if (this.bEN == null || !this.bEN.isShowing()) {
            return this.bEM != null && this.bEM.isShowing();
        }
        return true;
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (i != 2049) {
            return false;
        }
        if (!m11025QF()) {
            m11023PQ();
        } else {
            m11022PP();
        }
        return true;
    }
}
