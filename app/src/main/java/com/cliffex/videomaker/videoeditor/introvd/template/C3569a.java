package com.introvd.template;

import android.content.Context;
import android.text.TextUtils;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.p203b.C4582c;
import com.vivavideo.mobile.component.sharedpref.C9324b;
import com.vivavideo.mobile.component.sharedpref.C9327e;

/* renamed from: com.introvd.template.a */
public class C3569a {
    private static String bfq = "";
    private static long bfr;
    private static int bfs;
    private static int bft;

    /* renamed from: FK */
    public static boolean m8772FK() {
        return bft == 1;
    }

    /* renamed from: FL */
    public static boolean m8773FL() {
        return bft == 2;
    }

    /* renamed from: FM */
    public static boolean m8774FM() {
        return bft == 0;
    }

    @Deprecated
    /* renamed from: FN */
    public static void m8775FN() {
        bft = 0;
    }

    /* renamed from: FO */
    public static String m8776FO() {
        return bfq;
    }

    /* renamed from: bk */
    public static void m8777bk(Context context) {
        C9324b cR = C9327e.m27034cR(context, "App_RuntimeSp");
        bfr = cR.getLong("last_launch_time_millis", System.currentTimeMillis());
        cR.setLong("last_launch_time_millis", System.currentTimeMillis());
        String dD = C4582c.m11667dD(context);
        String appSettingStr = AppPreferencesSetting.getInstance().getAppSettingStr("pref_apk_last_version", "");
        int i = 1;
        boolean z = !dD.equals(appSettingStr) && !TextUtils.isEmpty(appSettingStr);
        if (!TextUtils.equals(appSettingStr, "")) {
            i = z ? 2 : 0;
        }
        bft = i;
        bfq = appSettingStr;
        StringBuilder sb = new StringBuilder();
        sb.append("s_LastVerName = ");
        sb.append(bfq);
        sb.append(",launchState = ");
        sb.append(i);
        LogUtilsV2.m14227d(sb.toString());
    }

    /* renamed from: bl */
    static void m8778bl(Context context) {
        AppPreferencesSetting.getInstance().setAppSettingStr("pref_apk_last_version", C4582c.m11667dD(VivaBaseApplication.m8749FZ()));
    }
}
