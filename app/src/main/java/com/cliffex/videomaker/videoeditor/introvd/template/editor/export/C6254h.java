package com.introvd.template.editor.export;

import android.content.Context;
import android.text.TextUtils;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.datacenter.SocialServiceDef;
import com.introvd.template.router.editor.EditorRouter;
import java.util.HashMap;

/* renamed from: com.introvd.template.editor.export.h */
public class C6254h {
    /* renamed from: bq */
    public static void m17917bq(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", str);
        UserBehaviorLog.onKVEvent(context, "Share_Export_Resolution", hashMap);
    }

    /* renamed from: br */
    public static void m17918br(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("choose", str);
        UserBehaviorLog.onKVEvent(context, "Share_Export_hardware_Dialog", hashMap);
    }

    /* renamed from: bs */
    public static void m17919bs(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("name", str);
        UserBehaviorLog.onKVEvent(context, "Share_Export_HD_Unlock", hashMap);
    }

    /* renamed from: bt */
    public static void m17920bt(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            HashMap hashMap = new HashMap();
            hashMap.put("Goal", str);
            UserBehaviorLog.onKVEvent(context, "Share_Export_Gif_Goal", hashMap);
        }
    }

    /* renamed from: eY */
    public static void m17921eY(Context context) {
        UserBehaviorLog.onKVEvent(context, "HD_Free_Export_Dialog_Show", new HashMap());
    }

    /* renamed from: eZ */
    public static void m17922eZ(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("Reason", "click");
        UserBehaviorLog.onKVEvent(context, "Cover_Enter", hashMap);
    }

    /* renamed from: f */
    public static void m17923f(Context context, String str, boolean z) {
        String m = m17924m(str, z);
        HashMap hashMap = new HashMap();
        hashMap.put(SocialServiceDef.EXTRAS_UPGRADE_FROM, m);
        UserBehaviorLog.onKVEvent(context, "Publish_Enter", hashMap);
    }

    /* renamed from: m */
    private static String m17924m(String str, boolean z) {
        String str2 = "";
        if (str == null) {
            str = "";
        }
        char c = 65535;
        int hashCode = str.hashCode();
        if (hashCode != 145764778) {
            if (hashCode != 415209253) {
                if (hashCode != 1674148759) {
                    if (hashCode == 1829269719 && str.equals("VideoEditorActivity")) {
                        c = 1;
                    }
                } else if (str.equals("XiaoYingActivity")) {
                    c = 3;
                }
            } else if (str.equals("StudioActivity")) {
                c = 2;
            }
        } else if (str.equals("EditorPreviewActivity")) {
            c = 0;
        }
        switch (c) {
            case 0:
                return EditorRouter.ENTRANCE_QUICK_PREVIEW;
            case 1:
                return z ? "mv" : EditorRouter.ENTRANCE_EDIT;
            case 2:
                return EditorRouter.ENTRANCE_STUDIO;
            case 3:
                return EditorRouter.ENTRANCE_ME_STUDIO;
            default:
                return str2;
        }
    }

    /* renamed from: w */
    public static void m17925w(Context context, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("Dest", str);
        UserBehaviorLog.onKVEvent(context, str2, hashMap);
    }
}
