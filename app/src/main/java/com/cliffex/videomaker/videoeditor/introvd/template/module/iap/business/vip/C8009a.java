package com.introvd.template.module.iap.business.vip;

import android.content.Context;
import com.introvd.template.common.LogUtils;
import com.introvd.template.module.iap.C8048e;
import com.introvd.template.module.iap.C8049f;
import com.introvd.template.module.iap.C8061k;
import com.introvd.template.module.iap.business.p349a.C7825a;
import com.introvd.template.module.iap.business.p356e.C7899c;
import com.introvd.template.module.iap.p341b.C7738c;
import com.p131c.p132a.p135c.C2575a;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import p037b.p050b.p051a.p053b.C1487a;

/* renamed from: com.introvd.template.module.iap.business.vip.a */
public class C8009a {
    private static int[] dUp = new int[2];

    /* access modifiers changed from: private */
    /* renamed from: J */
    public static boolean m23198J(Context context, String str, String str2) {
        if (C8048e.aBe().isInChina()) {
            return false;
        }
        List aNG = C7738c.aEv().aNx().aNG();
        if (aNG == null || aNG.isEmpty()) {
            return false;
        }
        Iterator it = aNG.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            String kC = C8061k.m23408kC((String) it.next());
            if (!kC.equals(C7825a.GOLD_YEARLY.getId())) {
                if (kC.equals(C7825a.GOLD_MONTHLY.getId())) {
                    str2 = C8049f.aBf().mo33106sf(1);
                    break;
                }
            } else {
                str2 = C8049f.aBf().mo33106sf(2);
                break;
            }
        }
        if (str2 == null) {
            return false;
        }
        GoldUpDialogStyleActivity.m23177I(context, str2, str);
        return true;
    }

    /* renamed from: cb */
    public static boolean m23200cb(final Context context, final String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("--- launchVipHome --- ");
        sb.append(str);
        sb.append("  tag -   homeActivityAndRequestBackFlags ");
        sb.append(Arrays.toString(dUp));
        LogUtils.m14222e("launchVipHome", sb.toString());
        if (str != null && !C7825a.ALL_TEMPLATE.getId().equals(str) && !C7825a.VIDEO_PARAM_ADJUST.getId().equals(str) && !C7825a.ANIM_TITLE.getId().equals(str) && !C7825a.CUSTOMIZED_BACKGROUND.getId().equals(str)) {
            return false;
        }
        if (str != null) {
            return m23198J(context, str, null);
        }
        if (dUp[0] != 1 || dUp[1] != 1) {
            return false;
        }
        if (System.currentTimeMillis() - C2575a.parseLong(C7899c.aDg().getString("last_gold_up_dialog_show", "0").replaceAll("\\D+", "")) < 2592000000L) {
            return false;
        }
        C7899c.aDg().setString("last_gold_up_dialog_show", String.valueOf(System.currentTimeMillis()));
        C1487a.aUa().mo9777a(new Runnable(null) {
            public void run() {
                C8009a.m23198J(context, str, null);
            }
        }, 1000, TimeUnit.MILLISECONDS);
        return true;
    }

    /* renamed from: du */
    public static void m23201du(int i, int i2) {
        if (i < dUp.length) {
            dUp[i] = i2;
        }
    }

    /* renamed from: gs */
    public static boolean m23202gs(Context context) {
        return m23198J(context, null, null);
    }
}
