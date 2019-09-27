package com.introvd.template.module.iap;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.support.p021v4.content.ContextCompat;
import android.text.TextUtils;
import com.afollestad.materialdialogs.C1885b;
import com.afollestad.materialdialogs.C1890f;
import com.afollestad.materialdialogs.C1890f.C1895a;
import com.afollestad.materialdialogs.C1890f.C1904j;
import com.introvd.template.module.iap.business.coupon.CouponTipPopF;
import com.introvd.template.module.iap.business.dialog.VipThemeNoticeBottomLayout;
import com.introvd.template.module.iap.business.dialog.VipThemeNoticeBottomLayout.C7884a;
import com.introvd.template.module.iap.business.home.C7980e;
import com.introvd.template.module.iap.business.home.C7990j;
import com.introvd.template.module.iap.business.p349a.C7825a;
import com.introvd.template.module.iap.business.p352b.C7835b;
import com.introvd.template.module.iap.business.p353c.C7839a;
import com.introvd.template.module.iap.business.p356e.C7899c;
import com.introvd.template.module.iap.business.p356e.C7900d;
import com.introvd.template.module.iap.business.p357f.C7940b;
import com.introvd.template.module.iap.business.vip.C8009a;
import com.introvd.template.module.iap.business.vip.VipActivityDialogActivity;
import com.introvd.template.module.iap.business.vip.p360a.C8018d;
import com.introvd.template.module.iap.business.vip.p360a.C8033i;
import com.introvd.template.module.iap.guide.C8056b;
import com.introvd.template.module.iap.guide.VipGuideStrategy;
import com.introvd.template.module.iap.p341b.C7738c;
import com.introvd.template.router.AdRouter;
import com.introvd.template.router.BizServiceManager;
import com.introvd.template.router.kiwi.LDPProtect;
import com.introvd.template.router.p377ad.AdServiceProxy;
import com.introvd.template.router.template.ITemplateService;
import com.introvd.template.router.user.UserServiceProxy;
import com.introvd.template.vivaiap.payment.C9054a;
import com.quvideo.plugin.payclient.common.C4852b;
import com.quvideo.plugin.payclient.common.model.SignStatusParam;
import com.quvideo.plugin.payclient.common.model.SignStatusResult;
import com.quvideo.priority.p217a.C4892c;
import com.quvideo.priority.p217a.C4892c.C4893a;
import java.util.List;
import p037b.p050b.C1848s;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p057e.C1518f;
import p037b.p050b.p076j.C1820a;

@LDPProtect
/* renamed from: com.introvd.template.module.iap.f */
public class C8049f implements C8058h {
    private static final C8058h dOu = new C8049f();
    private static boolean dOv = true;
    private static String dOw = null;

    /* renamed from: H */
    private boolean m23315H(Context context, String str, String str2) {
        return VipActivityDialogActivity.m23184L(context, str, str2) || C8009a.m23200cb(context, str);
    }

    public static C8058h aBf() {
        return dOu;
    }

    /* renamed from: A */
    public void mo33076A(Boolean bool) {
        C7899c.aDg().setBoolean("iap_ad_key_xybat_enable", bool.booleanValue());
    }

    /* renamed from: EO */
    public boolean mo33077EO() {
        return C7738c.aEv().mo32610EO();
    }

    /* renamed from: a */
    public C1848s<Boolean> mo33078a(Activity activity, List<Integer> list) {
        return C7940b.m23078a(activity, list);
    }

    /* renamed from: a */
    public VipThemeNoticeBottomLayout mo33079a(Activity activity, Long l, C7884a aVar) {
        return VipThemeNoticeBottomLayout.m22958b(activity, l, aVar);
    }

    /* renamed from: a */
    public C4892c mo33080a(C4893a aVar) {
        return new C8056b(aVar);
    }

    /* renamed from: a */
    public void mo33081a(Context context, String str, String str2, C9054a aVar) {
        C7738c.aEv().mo32612a(context, str, str2, aVar);
    }

    public void aBg() {
        C7738c.aEv().aNu().aNr();
    }

    public void aBh() {
        C7738c.aEv().aNu().aNs();
    }

    public void aBi() {
        C8009a.m23201du(0, 1);
        C8009a.m23200cb(C8048e.aBe().getContext(), null);
    }

    public boolean aBj() {
        return C7899c.aDg().getBoolean("iap_ad_key_xybat_enable", false);
    }

    public void aBk() {
        if (dOv) {
            if (C7738c.aEv().aNw().isEmpty()) {
                restoreGoodsAndPurchaseInfo();
            }
            dOv = false;
        }
    }

    public boolean aBl() {
        return "Non-organic".equalsIgnoreCase(dOw);
    }

    public boolean aBm() {
        return C7899c.aDg().getBoolean("vip_key_can_remove_ad", false);
    }

    public C4892c aBn() {
        return new CouponTipPopF();
    }

    public boolean aBo() {
        return VipGuideStrategy.aBo();
    }

    public C1848s<String> aBp() {
        return C4852b.m12467cF(UserServiceProxy.getUserId());
    }

    public C1848s<String> aBq() {
        VipGuideStrategy.aEk();
        return new C7980e().aDn();
    }

    public boolean aBr() {
        return C7940b.aBr();
    }

    /* renamed from: aF */
    public void mo33094aF(Activity activity) {
        new C8018d(activity, 0).show();
    }

    /* renamed from: aG */
    public void mo33095aG(final Activity activity) {
        if (!C8072q.aBx().mo33072ku(C7825a.DURATION_LIMIT.getId())) {
            String str = "key_exceed_duration_tip";
            if (!C7899c.aDg().getBoolean(str, false)) {
                new C1895a(activity).mo10315r(activity.getString(R.string.xiaoying_str_export_with_duration_limit, new Object[]{"5"})).mo10299dr(R.string.xiaoying_str_remove_duration_limit).mo10300ds(ContextCompat.getColor(activity, R.color.color_ff5e13)).mo10281a((C1904j) new C1904j() {
                    public void onClick(C1890f fVar, C1885b bVar) {
                        C8049f.this.mo33097b(activity, C8070o.aBw(), C7825a.DURATION_LIMIT.getId(), "preview di duration limit", -1);
                        fVar.dismiss();
                    }
                }).mo10303dv(R.string.xiaoying_str_com_cancel).mo10302du(ContextCompat.getColor(activity, R.color.black)).mo10314qv();
                C7899c.aDg().setBoolean(str, true);
            }
        }
    }

    /* renamed from: aH */
    public boolean mo33096aH(Activity activity) {
        return C7839a.aDd();
    }

    /* renamed from: b */
    public void mo33097b(Context context, String str, String str2, String str3, int i) {
        C7835b.m22861lq(str3);
        if (C8048e.aBe().isInChina()) {
            AdRouter.launchVipRenew(context, null, i);
        } else if (!m23315H(context, str2, str)) {
            AdRouter.launchVipHome(context, str, str2, i);
        }
    }

    /* renamed from: d */
    public boolean mo33098d(Activity activity, Runnable runnable) {
        return C7839a.m22872e(activity, runnable);
    }

    /* renamed from: e */
    public void mo33099e(Activity activity, int i, String str) {
        C8033i.m23243e(activity, i, str);
    }

    /* renamed from: g */
    public Dialog mo33100g(Context context, int i, String str) {
        Dialog dialog = (Dialog) AdServiceProxy.execute(AdServiceProxy.getEncourageAdDialog, context, Integer.valueOf(i), C7825a.ALL_TEMPLATE.getId().equals(str) ? C7825a.ALL_TEMPLATE.getId() : C7717b.m22629ks(str));
        if (dialog != null) {
            dialog.show();
        }
        return dialog;
    }

    /* renamed from: iL */
    public boolean mo33101iL(String str) {
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (isNeedToPurchase(str)) {
            C8071p aBx = C8072q.aBx();
            StringBuilder sb = new StringBuilder();
            sb.append("iap.template.");
            sb.append(str);
            if (!aBx.mo33072ku(sb.toString().toLowerCase())) {
                z = true;
            }
        }
        return z;
    }

    public boolean isNeedToPurchase(String str) {
        ITemplateService iTemplateService = (ITemplateService) BizServiceManager.getService(ITemplateService.class);
        if (iTemplateService == null) {
            return false;
        }
        return iTemplateService.isNeedToPurchase(str);
    }

    /* renamed from: kA */
    public C1848s<Boolean> mo33103kA(final String str) {
        if (!UserServiceProxy.isLogin()) {
            return C1848s.m5326ai(Boolean.valueOf(false)).mo10196g(C1820a.aVi()).mo10194f(C1487a.aUa());
        }
        return C4852b.m12463a(UserServiceProxy.getUserId(), new SignStatusParam("vip_subscription#30", C8048e.aBe().getCountryCode())).mo10199i(new C1518f<SignStatusResult, Boolean>() {
            /* renamed from: a */
            public Boolean apply(SignStatusResult signStatusResult) throws Exception {
                boolean z = false;
                if (TextUtils.isEmpty(str)) {
                    return Boolean.valueOf(false);
                }
                if (signStatusResult.isSuccessful() && str.equals(signStatusResult.platform)) {
                    z = true;
                }
                return Boolean.valueOf(z);
            }
        });
    }

    /* renamed from: kz */
    public void mo33104kz(String str) {
        dOw = str;
    }

    public void restoreGoodsAndPurchaseInfo() {
        C7738c.aEv().aNu().aNr();
        C7738c.aEv().aNu().aNs();
    }

    /* renamed from: sf */
    public String mo33106sf(int i) {
        C7990j jVar = new C7990j();
        return new C7900d(jVar.aDj()).mo32861lw(2 == i ? jVar.aDl() : jVar.aDk());
    }
}
