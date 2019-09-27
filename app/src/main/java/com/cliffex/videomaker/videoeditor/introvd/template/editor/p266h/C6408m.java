package com.introvd.template.editor.p266h;

import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextUtils;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.utils.Typefaces;
import com.introvd.template.template.p408f.C8752f;

/* renamed from: com.introvd.template.editor.h.m */
public class C6408m {
    public static String FONT_FAMILY_FILE = "/system/fonts/DroidSansFallback.ttf";
    public static Typeface dlk;

    static {
        try {
            FONT_FAMILY_FILE = C8752f.aMl();
            dlk = Typefaces.get(null, FONT_FAMILY_FILE);
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("exception:");
            sb.append(e.getMessage());
            LogUtils.m14223i("SvgTextManager_Log", sb.toString());
        }
    }

    @Deprecated
    /* renamed from: D */
    public static int m18452D(int i, int i2, int i3) {
        if (i2 == 0) {
            return 0;
        }
        return Math.round((((float) i) * ((float) i3)) / ((float) i2));
    }

    /* renamed from: a */
    public static Rect m18453a(RectF rectF, int i, int i2) {
        if (rectF == null || i <= 0 || i2 <= 0) {
            return null;
        }
        Rect rect = new Rect();
        rect.left = m18452D((int) rectF.left, i, 10000);
        rect.top = m18452D((int) rectF.top, i2, 10000);
        rect.right = m18452D((int) rectF.right, i, 10000);
        rect.bottom = m18452D((int) rectF.bottom, i2, 10000);
        return rect;
    }

    /* renamed from: iO */
    public static boolean m18454iO(String str) {
        if (str != null) {
            String trim = str.trim();
            if (!TextUtils.isEmpty(trim)) {
                int length = trim.length();
                for (int i = 0; i < length; i++) {
                    char charAt = trim.charAt(i);
                    if (charAt != 10 && charAt != 9 && charAt != ' ' && charAt != 13) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
