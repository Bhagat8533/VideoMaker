package com.introvd.template.module.iap.business.home;

import android.app.Activity;
import android.text.TextUtils;
import com.introvd.template.module.iap.C8048e;
import com.introvd.template.module.iap.business.VipSignQueryActivity;
import com.introvd.template.module.iap.utils.C8079c;
import com.introvd.template.router.user.UserServiceProxy;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* renamed from: com.introvd.template.module.iap.business.home.a */
public final class C7958a {

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.introvd.template.module.iap.business.home.a$a */
    public @interface C7959a {
        public static final String dTk = C8079c.m23444E("vip_normal", 30);
        public static final String dTl = C8079c.m23444E("vip_normal", 92);
        public static final String dTm = C8079c.m23444E("vip_normal", 365);
    }

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.introvd.template.module.iap.business.home.a$b */
    public @interface C7960b {
        public static final String dTk = C8079c.m23444E("vip_subscription", 30);
        public static final String dTl = C8079c.m23444E("vip_subscription", 92);
        public static final String dTm = C8079c.m23444E("vip_subscription", 365);
    }

    /* renamed from: g */
    public static void m23117g(Activity activity, String str) {
        C8048e.aBe().mo23623Mo();
        if (!TextUtils.isEmpty(UserServiceProxy.getUserId())) {
            VipSignQueryActivity.m22797bY(activity, str);
        }
    }

    /* renamed from: lx */
    public static boolean m23118lx(String str) {
        return C7959a.dTk.equals(str) || C7959a.dTl.equals(str) || C7959a.dTm.equals(str);
    }

    /* renamed from: ly */
    public static boolean m23119ly(String str) {
        return C7960b.dTk.equals(str) || C7960b.dTl.equals(str) || C7960b.dTm.equals(str);
    }
}
