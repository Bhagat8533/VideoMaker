package com.introvd.template.module.iap.business.p353c;

import android.app.Activity;
import android.support.p021v4.content.ContextCompat;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.module.iap.C8048e;
import com.introvd.template.module.iap.C8072q;
import com.introvd.template.module.iap.R;
import com.introvd.template.module.iap.business.coupon.C7846a;
import com.introvd.template.module.iap.business.coupon.C7858e;
import com.introvd.template.module.iap.business.dialog.C7885a.C7886a;
import com.introvd.template.module.iap.business.home.C7958a.C7959a;
import com.introvd.template.module.iap.business.p352b.C7835b;
import com.introvd.template.module.iap.business.p356e.C7899c;
import com.introvd.template.module.iap.p341b.C7738c;
import com.introvd.template.module.p338b.C7686a;
import com.introvd.template.module.p339c.C7689a;
import com.introvd.template.router.AdRouter;
import com.introvd.template.router.iap.IapRTConstants;
import com.introvd.template.router.user.UserServiceProxy;
import com.yan.rippledrawable.RippleLayout;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* renamed from: com.introvd.template.module.iap.business.c.a */
public class C7839a {
    private static String dSJ = "guid_showed";
    private static String dSK = "guid_during_start";
    private static String dSL = "guid_during_end";
    private static boolean dSM;

    private static void aDc() {
        long j = C7899c.aDg().getLong(dSK, -1);
        if (j != -1) {
            int g = m22874g(System.currentTimeMillis(), j);
            String str = null;
            if (g >= 30) {
                str = "30=<X";
            } else if (g >= 15) {
                str = "15=<X<30";
            } else if (g >= 8) {
                str = "8=<X<15";
            } else if (g == 7) {
                str = "value=7";
            }
            if (str != null) {
                C7835b.m22849aC(str, String.valueOf(g));
            }
        }
    }

    public static boolean aDd() {
        boolean z;
        if (!dSM) {
            boolean z2 = false;
            if (!C7686a.aAP() || !C8048e.aBe().isInChina() || !UserServiceProxy.isLogin() || C8072q.aBx().isVip()) {
                return false;
            }
            boolean z3 = C7899c.aDg().getBoolean(dSJ, false);
            Calendar instance = Calendar.getInstance();
            long j = C7899c.aDg().getLong(dSK, -1);
            long j2 = C7899c.aDg().getLong(dSL, -1);
            if (!(j == -1 || j2 == -1)) {
                int i = instance.get(6);
                instance.setTimeInMillis(j);
                int i2 = instance.get(6);
                instance.setTimeInMillis(j2);
                int i3 = instance.get(6);
                StringBuilder sb = new StringBuilder();
                sb.append("showVipGuideDialog   ");
                sb.append(i2);
                sb.append("   ");
                sb.append(i3);
                LogUtilsV2.m14228e(sb.toString());
                if (i3 - i2 <= 0 ? i >= i2 || i < i3 : i >= i2 && i < i3) {
                    z = true;
                    if (!z || !z3) {
                        z2 = true;
                    }
                    dSM = z2;
                }
            }
            z = false;
            z2 = true;
            dSM = z2;
        }
        return dSM;
    }

    /* access modifiers changed from: private */
    /* renamed from: aK */
    public static void m22870aK(Activity activity) {
        C7835b.m22861lq("Exit_dialog");
        String str = C7959a.dTk;
        if (C7686a.aAQ()) {
            int i = C8048e.aBe().mo23628Mt() ? 2 : (!C7686a.aAR() || C8048e.aBe().mo23615MG()) ? 5 : 6;
            C7846a kW = C7858e.m22920kW(str);
            C7738c.aEv().mo32611a(activity, str, kW != null ? kW.code : null, i, null);
            C7835b.m22841D(true, true);
            return;
        }
        AdRouter.launchVipRenew(activity, str, IapRTConstants.REQUEST_CODE_FOR_VIP);
        C7835b.m22841D(true, false);
    }

    /* renamed from: e */
    public static boolean m22872e(Activity activity, Runnable runnable) {
        if (!aDd()) {
            return false;
        }
        dSM = false;
        aDc();
        long currentTimeMillis = System.currentTimeMillis();
        C7899c.aDg().setBoolean(dSJ, true);
        m22875h(currentTimeMillis, 604800000 + currentTimeMillis);
        m22873f(activity, runnable);
        return true;
    }

    /* renamed from: f */
    private static void m22873f(final Activity activity, final Runnable runnable) {
        ImageView imageView = new ImageView(activity);
        imageView.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.iap_vip_bg_exit_guide_img));
        imageView.setPadding(0, C7689a.m22599ii(25), 0, C7689a.m22599ii(8));
        imageView.setLayoutParams(new LayoutParams(-1, -2));
        new C7886a(activity) {
            /* renamed from: b */
            public C7886a mo32761b(String str, OnClickListener onClickListener) {
                super.mo32761b(str, onClickListener);
                this.dQW.getLayoutParams().height = -2;
                this.dQW.getLayoutParams().width = -2;
                this.dQW.setTextColor(ContextCompat.getColor(activity, R.color.color_999999));
                this.dQW.setBackground(RippleLayout.m27642a(null, ContextCompat.getDrawable(activity, R.drawable.iap_vip_shape_bg_common_dialog_btn_n), RippleLayout.DEFAULT_COLOR));
                return this;
            }
        }.mo32820de(imageView).mo32815A(activity.getString(R.string.xiaoying_str_domestic_vip_retry_title)).mo32818c(R.string.xiaoying_str_discount_purchase, new OnClickListener() {
            public void onClick(View view) {
                C7839a.m22870aK(activity);
            }
        }).mo32819d(R.string.xiaoying_str_cruel_leave, new OnClickListener() {
            public void onClick(View view) {
                runnable.run();
                C7835b.m22841D(false, false);
            }
        }).aCm().show();
    }

    /* renamed from: g */
    private static int m22874g(long j, long j2) {
        Calendar instance = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        instance.setTimeInMillis(j);
        Date time = instance.getTime();
        instance.setTimeInMillis(j2);
        Date time2 = instance.getTime();
        String format = simpleDateFormat.format(time);
        String format2 = simpleDateFormat.format(time2);
        try {
            return (int) ((simpleDateFormat.parse(format).getTime() - simpleDateFormat.parse(format2).getTime()) / 86400000);
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* renamed from: h */
    private static void m22875h(long j, long j2) {
        C7899c.aDg().setLong(dSK, j);
        C7899c.aDg().setLong(dSL, j2);
    }
}
