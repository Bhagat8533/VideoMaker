package com.introvd.template.module.iap.business.coupon.p354a;

import android.text.TextUtils;
import com.introvd.template.module.iap.business.p356e.C7899c;
import com.introvd.template.router.editor.EditorRouter;

/* renamed from: com.introvd.template.module.iap.business.coupon.a.e */
final class C7851e {
    /* renamed from: a */
    static String m22896a(String str, int i, String str2, int i2) {
        String string = C7899c.aDg().getString(str, "");
        String str3 = null;
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        String[] split = string.split(EditorRouter.KEY_TOOL_LIST_ORDER_SPLIT_OP);
        if (split == null || split.length <= 0) {
            return null;
        }
        for (String str4 : split) {
            if (!TextUtils.isEmpty(str4)) {
                String[] split2 = str4.split("_");
                if (split2.length >= i2 + 1 && split2.length >= i + 1 && !TextUtils.isEmpty(split2[i]) && split2[i].equals(str2)) {
                    str3 = split2[i2];
                }
            }
        }
        return str3;
    }

    /* renamed from: aw */
    static boolean m22897aw(String str, String str2) {
        return !TextUtils.isEmpty(m22896a(str, 0, str2, 0));
    }

    /* renamed from: e */
    static void m22898e(String str, String... strArr) {
        String string = C7899c.aDg().getString(str, "");
        if (!TextUtils.isEmpty(string)) {
            StringBuilder sb = new StringBuilder();
            sb.append(string);
            sb.append(EditorRouter.KEY_TOOL_LIST_ORDER_SPLIT_OP);
            string = sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(string);
        sb2.append(m22899j(strArr));
        C7899c.aDg().setString(str, sb2.toString());
    }

    /* renamed from: j */
    private static String m22899j(String... strArr) {
        if (strArr == null || strArr.length <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strArr.length; i++) {
            sb.append(strArr[i]);
            if (i < strArr.length - 1) {
                sb.append("_");
            }
        }
        return sb.toString();
    }
}
