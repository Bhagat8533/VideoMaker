package com.introvd.template.editor.export;

import android.text.TextUtils;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.CommonConfigure;
import com.p131c.p132a.p135c.C2575a;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import lib.C12177i;

/* renamed from: com.introvd.template.editor.export.i */
public class C6255i {
    /* renamed from: aA */
    private static boolean m17926aA(long j) {
        return ((float) ((System.currentTimeMillis() - j) / 3600000)) >= 24.0f;
    }

    /* renamed from: b */
    private static void m17927b(boolean z, String str, int i) {
        if (i < 202) {
            StringBuilder sb = new StringBuilder(str);
            sb.append("/");
            sb.append(i + 1);
            AppPreferencesSetting.getInstance().setAppSettingStr("key_show_share_dialog_flag", sb.toString());
            return;
        }
        AppPreferencesSetting.getInstance().setAppSettingStr("key_show_share_dialog_flag", "8888/8888");
    }

    /* renamed from: fI */
    public static String m17928fI(boolean z) {
        return z ? "http://hybrid.xiaoying.tv/vivavideo/help/cn/FAQindex.html" : "http://hybrid.xiaoying.tv/vivavideo/help/en/FAQindex.html";
    }

    /* renamed from: fJ */
    public static void m17929fJ(boolean z) {
        if (AppPreferencesSetting.getInstance().getAppSettingInt("key_show_rate_dialog_flag", 101) != 103) {
            AppPreferencesSetting.getInstance().setAppSettingInt("key_show_rate_dialog_flag", 102);
        }
        if (z) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(System.currentTimeMillis()));
            sb.append("/");
            sb.append(201);
            String appSettingStr = AppPreferencesSetting.getInstance().getAppSettingStr("key_show_share_dialog_flag", sb.toString());
            if (!"9999/9999".equals(appSettingStr) && !TextUtils.isEmpty(appSettingStr)) {
                String[] split = appSettingStr.split("/");
                if (split.length >= 2) {
                    m17927b(m17926aA(C2575a.parseLong(split[0])), split[0], C2575a.parseInt(split[1]));
                }
            }
        }
    }

    /* renamed from: hF */
    public static String m17930hF(String str) {
        String format = new SimpleDateFormat("yyyyMMddHHmmss", Locale.US).format(new Date());
        String substring = str.substring(0, str.lastIndexOf(46));
        StringBuilder sb = new StringBuilder();
        sb.append(substring);
        sb.append("_cover_");
        sb.append(format);
        sb.append(".jpg");
        return sb.toString();
    }

    /* renamed from: u */
    public static int m17931u(boolean z, boolean z2) {
        return (z || !z2) ? C12177i.f6158n : CommonConfigure.MAX_UPLOAD_DURATION;
    }
}
