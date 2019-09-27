package com.introvd.template.module.iap.p341b.p344c;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager.BadTokenException;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.module.iap.C8045d;
import com.introvd.template.module.iap.C8048e;
import com.introvd.template.module.iap.C8061k;
import com.introvd.template.module.iap.R;
import com.introvd.template.module.iap.business.p349a.C7832c;
import com.introvd.template.module.iap.business.p352b.C7835b;
import com.introvd.template.module.iap.business.p356e.C7897a;
import com.introvd.template.module.iap.business.p356e.C7899c;
import com.introvd.template.module.iap.business.vip.p360a.C8011a;
import com.introvd.template.module.iap.p341b.C7738c;
import com.introvd.template.module.iap.p341b.C7792f;
import com.introvd.template.vivaiap.payment.C9054a;
import com.introvd.template.vivaiap.payment.PayParam;
import com.introvd.template.vivaiap.payment.PayParam.C9046a;
import com.introvd.template.vivaiap.payment.PayResult;
import com.p131c.p132a.C2561a;
import com.p131c.p132a.p135c.C2575a;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.introvd.template.module.iap.b.c.c */
public final class C7747c extends C7792f {
    /* access modifiers changed from: private */
    public String dVy = null;

    /* access modifiers changed from: private */
    /* renamed from: aF */
    public void m22667aF(String str, String str2) {
        if (str != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", str);
            C7832c kw = C8045d.aAZ().mo33074kw(str);
            String str3 = "known0";
            if (kw != null) {
                double aCE = ((double) kw.aCE()) / 1000000.0d;
                hashMap.put("ilegal", String.valueOf(C2575a.parseDouble(kw.mo32756sp()) != aCE));
                String currencyCode = kw.getCurrencyCode();
                C8048e.aBe().mo23640a(str, aCE, currencyCode);
                StringBuilder sb = new StringBuilder();
                sb.append(currencyCode);
                sb.append(aCE);
                String sb2 = sb.toString();
                hashMap.put("source", kw.toString());
                C8048e.aBe().mo23641a(str, sb2, BigDecimal.valueOf(aCE), Currency.getInstance(currencyCode));
                str3 = sb2;
            }
            if (!TextUtils.isEmpty(str2)) {
                hashMap.put("templateId", str2);
            }
            hashMap.put("price", str3);
            hashMap.put("versionName", "6.0.4");
            C8048e.aBe().mo23653g("IAP_Success_Callback", hashMap);
        }
    }

    /* renamed from: gt */
    private void m22668gt(final Context context) {
        if (C7899c.aDg().getBoolean("key_pref_can_show_non_gp_tip", true)) {
            C8011a aVar = new C8011a(context);
            aVar.setContent(context.getString(R.string.xiaoying_str_tip_gp_channel_overried));
            aVar.mo33011g(new OnClickListener() {
                public void onClick(View view) {
                    C7899c.aDg().setBoolean("key_pref_can_show_non_gp_tip", false);
                }
            });
            aVar.mo33010f(null);
            aVar.mo33009e(new OnClickListener() {
                public void onClick(View view) {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    StringBuilder sb = new StringBuilder();
                    sb.append("market://details?id=");
                    sb.append(context.getPackageName());
                    intent.setData(Uri.parse(sb.toString()));
                    try {
                        if (!(context instanceof Activity)) {
                            intent.addFlags(268435456);
                        }
                        context.startActivity(intent);
                    } catch (Exception e) {
                        e.printStackTrace();
                        ToastUtils.show(context, R.string.xiaoying_str_studio_msg_app_not_found, 0);
                    }
                }
            });
            try {
                aVar.show();
            } catch (BadTokenException e) {
                C8048e.aBe().logException(e);
            }
        }
    }

    /* renamed from: b */
    public void mo32602b(Context context, final String str, String str2, final C9054a aVar) {
        if (C2561a.aOP()) {
            m22668gt(context);
        } else if (!TextUtils.isEmpty(str)) {
            PayParam aNB = new C9046a("google", str).aNB();
            List aBs = C8061k.aBs();
            if (aBs != null && !aBs.isEmpty() && !str.equals(aBs.get(0))) {
                aNB.getExtra().putString("goodsId_to_replace", (String) aBs.get(0));
            }
            this.dVy = C7897a.m23024c("Iap_Purchase_Template_Id", new String[0]);
            if (TextUtils.isEmpty(this.dVy) || "unknown".equals(this.dVy)) {
                this.dVy = null;
            }
            C7835b.m22851az(str, this.dVy);
            C7738c.aEv().mo35846a(context, aNB, new C9054a() {
                /* renamed from: a */
                public void mo32328a(PayResult payResult) {
                    if (!C8048e.aBe().mo23626Mr()) {
                        C7835b.m22846a(false, str, "crack", -1, C7747c.this.dVy);
                        return;
                    }
                    C7835b.m22846a(payResult.isSuccess(), str, payResult.getMessage(), payResult.getCode(), C7747c.this.dVy);
                    if (aVar != null) {
                        aVar.mo32328a(payResult);
                    }
                    if (payResult.isSuccess()) {
                        C7747c.this.m22667aF(str, C7747c.this.dVy);
                    }
                }
            });
        }
    }
}
