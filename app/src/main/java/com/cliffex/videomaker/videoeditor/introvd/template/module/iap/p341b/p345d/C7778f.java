package com.introvd.template.module.iap.p341b.p345d;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager.BadTokenException;
import android.widget.Toast;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.module.iap.C8045d;
import com.introvd.template.module.iap.C8048e;
import com.introvd.template.module.iap.C8072q;
import com.introvd.template.module.iap.R;
import com.introvd.template.module.iap.business.coupon.C7858e;
import com.introvd.template.module.iap.business.dialog.C7889b;
import com.introvd.template.module.iap.business.dialog.C7889b.C7891a;
import com.introvd.template.module.iap.business.p349a.C7827b;
import com.introvd.template.module.iap.business.p349a.C7832c;
import com.introvd.template.module.iap.business.p352b.C7834a;
import com.introvd.template.module.iap.business.p352b.C7835b;
import com.introvd.template.module.iap.business.p356e.C7897a;
import com.introvd.template.module.iap.business.p356e.C7898b;
import com.introvd.template.module.iap.p341b.C7738c;
import com.introvd.template.module.iap.p341b.C7792f;
import com.introvd.template.module.iap.p341b.C7794g;
import com.introvd.template.module.iap.p341b.p342a.C7719a;
import com.introvd.template.module.iap.p341b.p345d.p346a.C7762a;
import com.introvd.template.module.iap.utils.C8079c;
import com.introvd.template.module.iap.utils.C8083g;
import com.introvd.template.router.user.UserServiceProxy;
import com.introvd.template.vivaiap.payment.C9054a;
import com.introvd.template.vivaiap.payment.PayParam;
import com.introvd.template.vivaiap.payment.PayParam.C9046a;
import com.introvd.template.vivaiap.payment.PayResult;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.sdk.controller.BannerJSAdapter;
import com.p131c.p132a.p135c.C2575a;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/* renamed from: com.introvd.template.module.iap.b.d.f */
public abstract class C7778f extends C7792f {
    private OnDismissListener anh = new OnDismissListener() {
        public void onDismiss(DialogInterface dialogInterface) {
            C7778f.this.dRh = null;
        }
    };
    /* access modifiers changed from: private */
    public C7889b dRh;
    private long dVG = System.currentTimeMillis();
    /* access modifiers changed from: protected */
    public String dVy = null;

    /* renamed from: com.introvd.template.module.iap.b.d.f$a */
    private static class C7783a implements C7794g {
        private C7783a() {
        }

        /* renamed from: cc */
        public boolean mo32596cc(Context context, String str) {
            if (!C8048e.aBe().isInChina()) {
                ToastUtils.show(context, "Please restart application.", 0);
                return true;
            } else if (UserServiceProxy.isLogin()) {
                return false;
            } else {
                C8048e.aBe().mo23621Mm();
                return true;
            }
        }

        public String getId() {
            return "DomesticLoginWithVip";
        }
    }

    public C7778f() {
        mo32654a(new C7783a());
        if (aEN()) {
            C8083g.init();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public String m22727a(PayResult payResult, String str) {
        String str2;
        if (payResult == null) {
            return "PayResult is null.";
        }
        if (payResult.isSuccess()) {
            str2 = "success";
        } else if ("wx".equals(str)) {
            str2 = payResult.getCode() == -2 ? "user_cancelled" : BannerJSAdapter.FAIL;
        } else if (TextUtils.isEmpty(payResult.getMessage())) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(":");
            sb.append(payResult.getCode());
            str2 = sb.toString();
        } else if (payResult.getMessage().contains("user_cancelled")) {
            str2 = "user_cancelled";
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("fail:");
            sb2.append(payResult.getMessage());
            str2 = sb2.toString();
        }
        return str2;
    }

    /* access modifiers changed from: private */
    /* renamed from: lL */
    public void m22729lL(String str) {
        int parseInt = C2575a.parseInt(C8079c.m23446lU(str));
        String lT = C8079c.m23445lT(str);
        C7827b bVar = new C7827b(lT);
        C7827b bVar2 = (C7827b) C7738c.aEv().aNx().mo35913ri(lT);
        if (bVar2 == null || !bVar2.isValid()) {
            bVar.mo32703ld(String.valueOf(this.dVG));
        } else {
            bVar.mo32703ld(String.valueOf(bVar2.aCw()));
        }
        bVar.mo32705st(parseInt);
        C7738c.aEv().aNx().mo35911dg(Collections.singletonList(bVar));
        C7776e.m22721a(UserServiceProxy.getUserId(), this.dVG, C7738c.aEv().aNx().mo35914wS());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public PayParam mo32643a(String str, String str2, C7832c cVar, String str3, String str4) {
        PayParam aNB = new C9046a(str, str2).mo35867rd(UserServiceProxy.getUserId()).mo35866rc(str).mo35870vK((int) cVar.aCE()).mo35868re(cVar.getCurrencyCode()).mo35869rf(C8048e.aBe().getCountryCode()).mo35864ra(cVar.getName()).mo35863jM(false).mo35865rb(TextUtils.isEmpty(cVar.getDescription()) ? cVar.getName() : cVar.getDescription()).aNB();
        Bundle extra = aNB.getExtra();
        extra.putString("configId", str3);
        extra.putString("couponCode", str4);
        extra.putSerializable("requestParam", (Serializable) C8048e.aBe().mo23658hc(IronSourceConstants.INTERSTITIAL_DAILY_CAPPED));
        extra.putString("extend", C7719a.m22632lJ(this.dVy));
        return aNB;
    }

    /* access modifiers changed from: protected */
    public boolean aEN() {
        return true;
    }

    /* access modifiers changed from: protected */
    public String aEO() {
        return null;
    }

    /* renamed from: b */
    public void mo32602b(Context context, String str, String str2, C9054a aVar) {
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (!activity.isFinishing()) {
                this.dVy = C7897a.m23024c("Iap_Purchase_Template_Id", new String[0]);
                if (TextUtils.isEmpty(this.dVy) || "unknown".equals(this.dVy)) {
                    this.dVy = null;
                }
                if (!aEN()) {
                    mo32640l(activity, str, str2, aEO());
                    return;
                }
                C8083g.init();
                C7891a aVar2 = new C7891a(context);
                final Context context2 = context;
                final Activity activity2 = activity;
                final String str3 = str;
                final String str4 = str2;
                C77802 r0 = new C7762a() {
                    /* renamed from: lM */
                    public List<String> mo32636lM(String str) {
                        return C8083g.m23457mb(str);
                    }

                    /* renamed from: lN */
                    public OnClickListener mo32637lN(final String str) {
                        return new OnClickListener() {
                            public void onClick(View view) {
                                if (!C8048e.aBe().mo23644bB(true)) {
                                    ToastUtils.show(context2, R.string.xiaoying_str_com_msg_network_inactive, 1);
                                    return;
                                }
                                if ("wx".equals(str)) {
                                    if (!C8048e.aBe().mo23627Ms()) {
                                        Toast makeText = Toast.makeText(activity2, activity2.getString(R.string.xiaoying_str_sns_wechat_not_installed), 0);
                                        makeText.setGravity(17, 0, 0);
                                        makeText.show();
                                        return;
                                    }
                                    C8048e.aBe().mo23642b(activity2, false);
                                    C7778f.this.mo32640l(activity2, str3, str4, "wx");
                                } else if ("alipay".equals(str)) {
                                    C7778f.this.mo32640l(activity2, str3, str4, "alipay");
                                }
                            }
                        };
                    }
                };
                this.dRh = aVar2.mo32827a(r0).aCs();
                this.dRh.setOnDismissListener(this.anh);
                try {
                    if (!activity.isFinishing() && this.dRh != null) {
                        this.dRh.show();
                    }
                } catch (BadTokenException e) {
                    C8048e.aBe().logException(e);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: gu */
    public void mo32644gu(Context context) {
        if (this.dRh != null && this.dRh.isShowing() && (context instanceof Activity) && !((Activity) context).isFinishing()) {
            try {
                this.dRh.dismiss();
            } catch (BadTokenException unused) {
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public void mo32640l(Context context, String str, String str2, String str3) {
        C7832c kw = C8045d.aAZ().mo33074kw(str);
        if (kw != null && !TextUtils.isEmpty(str)) {
            String aCF = kw.aCF();
            String replace = C8072q.aBx().mo33073kv(str) ? str.replace("vip_subscription", "vip_normal") : str;
            C7897a.m23022b(str3, C7898b.dTa, new String[0]);
            C7834a.m22836l(str, kw.mo32756sp(), this.dVy, str2);
            final String str4 = replace;
            final C7832c cVar = kw;
            final String str5 = str2;
            PayParam a = mo32643a(str3, str4, cVar, aCF, str5);
            C7897a.m23022b(str3, "Iap_Last_Select_Pay_Way", new String[0]);
            C7738c aEv = C7738c.aEv();
            final String str6 = str3;
            final Context context2 = context;
            C77823 r1 = new C9054a() {
                /* renamed from: a */
                public void mo32328a(PayResult payResult) {
                    boolean c = C7765b.m22704c(payResult);
                    C8048e.aBe().mo23623Mo();
                    C7834a.m22832a(str4, cVar.mo32756sp(), c, C7778f.this.m22727a(payResult, str6), C7778f.this.dVy, str5);
                    if (!C8048e.aBe().mo23626Mr()) {
                        C7835b.aCP();
                    } else if (!c) {
                        if (TextUtils.isEmpty(str5)) {
                            C7858e.m22924la("10");
                        } else {
                            C7858e.m22923kZ(str5);
                        }
                    } else {
                        C7778f.this.m22729lL(str4);
                        C7778f.this.mo32644gu(context2);
                    }
                }
            };
            aEv.mo35846a(context, a, r1);
        }
    }
}
