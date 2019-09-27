package com.introvd.template.module.iap;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import com.introvd.template.module.iap.business.dialog.VipThemeNoticeBottomLayout;
import com.introvd.template.module.iap.business.dialog.VipThemeNoticeBottomLayout.C7884a;
import com.introvd.template.vivaiap.payment.C9054a;
import com.quvideo.priority.p217a.C4892c;
import com.quvideo.priority.p217a.C4892c.C4893a;
import java.util.List;
import p037b.p050b.C1848s;

/* renamed from: com.introvd.template.module.iap.h */
public interface C8058h {
    /* renamed from: A */
    void mo33076A(Boolean bool);

    /* renamed from: EO */
    boolean mo33077EO();

    /* renamed from: a */
    C1848s<Boolean> mo33078a(Activity activity, List<Integer> list);

    /* renamed from: a */
    VipThemeNoticeBottomLayout mo33079a(Activity activity, Long l, C7884a aVar);

    /* renamed from: a */
    C4892c mo33080a(C4893a aVar);

    /* renamed from: a */
    void mo33081a(Context context, String str, String str2, C9054a aVar);

    void aBg();

    void aBh();

    void aBi();

    boolean aBj();

    void aBk();

    boolean aBl();

    boolean aBm();

    C4892c aBn();

    boolean aBo();

    C1848s<String> aBp();

    C1848s<String> aBq();

    boolean aBr();

    /* renamed from: aF */
    void mo33094aF(Activity activity);

    /* renamed from: aG */
    void mo33095aG(Activity activity);

    /* renamed from: aH */
    boolean mo33096aH(Activity activity);

    /* renamed from: b */
    void mo33097b(Context context, String str, String str2, String str3, int i);

    /* renamed from: d */
    boolean mo33098d(Activity activity, Runnable runnable);

    /* renamed from: e */
    void mo33099e(Activity activity, int i, String str);

    /* renamed from: g */
    Dialog mo33100g(Context context, int i, String str);

    /* renamed from: iL */
    boolean mo33101iL(String str);

    boolean isNeedToPurchase(String str);

    /* renamed from: kA */
    C1848s<Boolean> mo33103kA(String str);

    /* renamed from: kz */
    void mo33104kz(String str);

    void restoreGoodsAndPurchaseInfo();

    /* renamed from: sf */
    String mo33106sf(int i);
}
