package com.introvd.template.editor.p244a;

import android.text.TextUtils;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.router.editor.EditorRouter;
import java.util.HashMap;

/* renamed from: com.introvd.template.editor.a.a */
public class C5553a {
    public static String bix = "0";
    private static HashMap cyK = new HashMap();
    public static String cyL = EditorRouter.COMMON_BEHAVIOR_POSITION_OTHER;
    public static boolean cyM = true;

    public static void aeH() {
        UserBehaviorLog.clearCommonMap();
    }

    /* renamed from: b */
    public static void m15009b(String str, String str2, boolean z) {
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = EditorRouter.COMMON_BEHAVIOR_POSITION_OTHER;
        }
        bix = str;
        cyL = str2;
        cyM = z;
        if (cyK == null) {
            cyK = new HashMap();
        }
        cyK.put("com_function", bix);
        cyK.put("com_position", cyL);
        cyK.put("com_Status", cyM ? "New" : "Draft");
        UserBehaviorLog.addCommonMap(cyK);
    }
}
