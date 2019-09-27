package com.introvd.template.app.p189i;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.introvd.template.R;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.module.iap.C8072q;
import com.introvd.template.module.iap.business.C7833b;
import com.introvd.template.module.iap.business.exchange.C7916c;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.router.user.UserServiceProxy;
import com.introvd.template.xyui.C9136a;
import java.util.concurrent.TimeUnit;
import p037b.p050b.C1848s;
import p037b.p050b.C1850u;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p073g.C1810c;
import p037b.p050b.p076j.C1820a;

/* renamed from: com.introvd.template.app.i.a */
public class C4003a {
    private static C9136a btl = null;
    private static boolean btm = false;
    private static String userId = "";

    /* renamed from: I */
    private static String m9888I(Context context, int i) {
        String str = "";
        if (3 == i) {
            str = context.getString(R.string.iap_vip_tab_tip_privilege);
        }
        if (2 == i) {
            str = context.getString(R.string.iap_vip_tab_tip_vivacoin);
        }
        if (!m9894gY(i)) {
            return str;
        }
        return context.getString(R.string.iap_vip_tab_tip_available_vip_days, new Object[]{String.valueOf(C7833b.aBA())});
    }

    /* renamed from: Mg */
    private static int m9889Mg() {
        if (m9895gZ(3)) {
            return 3;
        }
        if (m9895gZ(2)) {
            return 2;
        }
        int i = -C7833b.aBA();
        if (m9893gX(i)) {
            return i;
        }
        return 0;
    }

    /* renamed from: a */
    public static void m9890a(final Activity activity, final View view) {
        if (AppStateModel.getInstance().isInChina() && UserServiceProxy.isLogin() && !btm) {
            userId = UserServiceProxy.getUserId();
            final int Mg = m9889Mg();
            final String I = m9888I(activity, Mg);
            if (!TextUtils.isEmpty(I)) {
                C1848s.m5326ai(Boolean.valueOf(true)).mo10196g(C1820a.aVi()).mo10200k(500, TimeUnit.MILLISECONDS).mo10194f(C1487a.aUa()).mo10188a((C1850u<? super T>) new C1810c<Boolean>() {
                    /* renamed from: e */
                    public void onSuccess(Boolean bool) {
                        C4003a.m9891a(activity, view, I, Mg);
                    }

                    public void onError(Throwable th) {
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static void m9891a(Activity activity, View view, String str, int i) {
        if (btl == null) {
            btl = new C9136a(activity);
        }
        btl.mo36087f(view, 5, C4580b.m11666qi());
        btl.mo36086dt(str);
        btl.mo36098vP(160);
        btl.mo36085dT(0, C4583d.m11670O(activity, 8));
        btm = true;
        m9896ha(i);
    }

    public static void dismiss() {
        if (btl != null) {
            btl.aNX();
            btl = null;
        }
    }

    /* renamed from: gX */
    private static boolean m9893gX(int i) {
        boolean z = false;
        if (!m9894gY(i)) {
            return false;
        }
        if ((C8072q.aBx().isVip() && C7833b.aBA() <= 3) && !AppPreferencesSetting.getInstance().getAppSettingBoolean(m9897hb(i), false)) {
            z = true;
        }
        return z;
    }

    /* renamed from: gY */
    private static boolean m9894gY(int i) {
        return i < 0;
    }

    /* renamed from: gZ */
    private static boolean m9895gZ(int i) {
        return (C7916c.aCW().mo32880sz(i) > 0) && !AppPreferencesSetting.getInstance().getAppSettingBoolean(m9897hb(i), false);
    }

    /* renamed from: ha */
    private static void m9896ha(int i) {
        AppPreferencesSetting.getInstance().setAppSettingBoolean(m9897hb(i), true);
    }

    /* renamed from: hb */
    private static String m9897hb(int i) {
        if (m9894gY(i)) {
            StringBuilder sb = new StringBuilder();
            sb.append("key_for_user_vip_tip_prefix_");
            sb.append(userId);
            sb.append("vip");
            sb.append(i);
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("key_for_user_vip_tip_prefix_");
        sb2.append(userId);
        sb2.append(i);
        return sb2.toString();
    }
}
