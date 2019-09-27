package com.introvd.template.module.iap.p341b.p345d.p348c;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.module.iap.C8048e;
import com.introvd.template.module.iap.C8072q;
import com.introvd.template.module.iap.R;
import com.introvd.template.module.iap.business.home.C7958a;
import com.introvd.template.module.iap.business.p349a.C7832c;
import com.introvd.template.module.iap.business.p352b.C7834a;
import com.introvd.template.module.iap.business.p356e.C7897a;
import com.introvd.template.module.iap.business.p356e.C7898b;
import com.introvd.template.module.iap.p341b.C7738c;
import com.introvd.template.module.iap.p341b.p342a.C7719a;
import com.introvd.template.module.iap.p341b.p345d.C7778f;
import com.introvd.template.router.user.UserServiceProxy;
import com.introvd.template.router.user.model.LoginUserInfo;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.quvideo.plugin.payclient.alipay.C4848b;
import com.quvideo.plugin.payclient.alipay.C4850c;
import com.quvideo.plugin.payclient.common.C4852b;
import com.quvideo.plugin.payclient.common.C4860d;
import com.quvideo.plugin.payclient.common.model.ChargeWithSignParam;
import com.quvideo.plugin.payclient.common.model.SignStatusParam;
import com.quvideo.plugin.payclient.common.model.SignStatusResult;
import com.quvideo.plugin.payclient.wechat.C4884b;
import p037b.p050b.C1848s;
import p037b.p050b.C1850u;
import p037b.p050b.p073g.C1810c;

/* renamed from: com.introvd.template.module.iap.b.d.c.b */
public class C7771b extends C7778f {
    /* renamed from: ce */
    private boolean m22715ce(Context context, String str) {
        boolean z;
        String str2;
        if ("alipay".equals(str)) {
            z = C4850c.m12451bc(context);
            str2 = context.getString(R.string.xiaoying_str_iap_vip_alipay_is_installed);
        } else if ("wx".equals(str)) {
            z = C8048e.aBe().mo23627Ms();
            str2 = context.getString(R.string.xiaoying_str_sns_wechat_not_installed);
        } else if ("huawei".equals(str)) {
            return true;
        } else {
            str2 = null;
            z = false;
        }
        if (!TextUtils.isEmpty(str2) && !z) {
            ToastUtils.show(context, str2, 0);
        }
        return z;
    }

    /* access modifiers changed from: private */
    /* renamed from: lQ */
    public String m22716lQ(String str) {
        if ("alipay".equals(str)) {
            return "alipay";
        }
        if ("wx".equals(str)) {
            return "wx";
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: lR */
    public C4860d m22717lR(String str) {
        C77732 r0 = new Runnable() {
            public void run() {
            }
        };
        if ("wx".equals(str)) {
            return C4884b.m12490h(r0);
        }
        if ("alipay".equals(str)) {
            return C4848b.m12448g(r0);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public void mo32640l(Context context, String str, String str2, String str3) {
        if (!C8072q.aBx().mo33073kv(str)) {
            super.mo32640l(context, str, str2, str3);
        } else if (m22715ce(context, str3)) {
            C1848s a = C4852b.m12463a(UserServiceProxy.getUserId(), new SignStatusParam(str, C8048e.aBe().getCountryCode()));
            final Context context2 = context;
            final String str4 = str;
            final String str5 = str2;
            final String str6 = str3;
            C77721 r1 = new C1810c<SignStatusResult>() {
                /* renamed from: b */
                public void onSuccess(SignStatusResult signStatusResult) {
                    if (signStatusResult.subscribeStatus == 1) {
                        C7771b.super.mo32640l(context2, str4, str5, str6);
                    } else {
                        C7832c cVar = (C7832c) C7738c.aEv().aNw().mo35913ri(str4);
                        if (cVar != null) {
                            C7897a.m23022b(str4, C7898b.dSY, new String[0]);
                            if (context2 instanceof Activity) {
                                C7958a.m23117g((Activity) context2, str4);
                            }
                            LoginUserInfo userInfo = UserServiceProxy.getUserInfo();
                            String str = null;
                            if (userInfo != null && !TextUtils.isEmpty(userInfo.nickname)) {
                                str = userInfo.nickname.replaceAll("[\\ud800\\udc00-\\udbff\\udfff\\ud800-\\udfff]", "*");
                            }
                            if (str == null || str.length() == 0) {
                                str = context2.getString(R.string.xiaoying_str_default_vivavideo_sign_name);
                            }
                            if (str.length() >= 32) {
                                str = str.substring(0, 32);
                            }
                            ChargeWithSignParam chargeWithSignParam = new ChargeWithSignParam(str, C7771b.this.m22716lQ(str6), str4, C8048e.aBe().getCountryCode(), (int) cVar.aCE(), cVar.aCF(), C8048e.aBe().mo23658hc(IronSourceConstants.INTERSTITIAL_DAILY_CAPPED), null, str5, C7719a.m22632lJ(C7771b.this.dVy));
                            C7897a.m23022b(str6, C7898b.dTa, new String[0]);
                            C7834a.m22836l(str4, cVar.mo32756sp(), C7771b.this.dVy, str5);
                            C4860d b = C7771b.this.m22717lR(str6);
                            if (b != null) {
                                C4852b.m12464a(context2, UserServiceProxy.getUserId(), chargeWithSignParam, b);
                                C7771b.this.mo32644gu(context2);
                            }
                        }
                    }
                }

                public void onError(Throwable th) {
                    ToastUtils.show(context2, R.string.xiaoying_str_com_msg_network_inactive, 0);
                }
            };
            a.mo10188a((C1850u<? super T>) r1);
        }
    }
}
