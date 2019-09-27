package com.introvd.template.app.school;

import android.content.res.Resources.NotFoundException;
import android.text.TextUtils;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.p242d.C5527a;
import java.util.HashMap;

/* renamed from: com.introvd.template.app.school.m */
public class C4205m {
    /* renamed from: Q */
    public static void m10499Q(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("ttid", str);
        hashMap.put("position", str2);
        UserBehaviorLog.onKVEvent(VivaBaseApplication.m8749FZ(), "School_Module_Show", hashMap);
    }

    /* renamed from: c */
    static void m10500c(String str, int i, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("ttid", str);
        hashMap.put("position", C5527a.m14968kj(i));
        hashMap.put("tab", str2);
        UserBehaviorLog.onKVEvent(VivaBaseApplication.m8749FZ(), "School_Module_Use", hashMap);
    }

    /* renamed from: dP */
    public static void m10501dP(String str) {
        HashMap hashMap = new HashMap();
        String str2 = "type";
        if (TextUtils.isEmpty(str)) {
            str = "<7.13.0";
        }
        hashMap.put(str2, str);
        UserBehaviorLog.onKVEvent(VivaBaseApplication.m8749FZ(), "Click_Module_GoToAll", hashMap);
    }

    /* renamed from: r */
    public static void m10502r(String str, int i) {
        HashMap hashMap = new HashMap();
        if (TextUtils.isEmpty(str)) {
            try {
                str = VivaBaseApplication.m8749FZ().getString(i);
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        }
        hashMap.put("name", str);
        UserBehaviorLog.onKVEvent(VivaBaseApplication.m8749FZ(), "Home_Click_China_New", hashMap);
    }
}
