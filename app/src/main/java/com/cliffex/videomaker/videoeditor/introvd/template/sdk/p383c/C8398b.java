package com.introvd.template.sdk.p383c;

import com.introvd.template.sdk.utils.p394b.C8501a;
import java.util.Locale;
import xiaoying.engine.QEngine;
import xiaoying.engine.base.QUtils;

/* renamed from: com.introvd.template.sdk.c.b */
public class C8398b {
    public static float ecV = 1.0f;
    private static Integer ecW = null;
    public static Locale mLocale = Locale.CHINESE;

    public static int aHC() {
        if (ecW != null) {
            return ecW.intValue();
        }
        QEngine aJv = C8501a.aJs().aJv();
        if (aJv == null) {
            return 3;
        }
        try {
            ecW = Integer.valueOf(QUtils.QueryHWDecCap(aJv, 4, QUtils.VIDEO_RES_1080P_HEIGHT, QUtils.VIDEO_RES_1080P_WIDTH, false));
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (ecW == null) {
            return 3;
        }
        return ecW.intValue();
    }
}
