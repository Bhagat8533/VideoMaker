package com.introvd.template.explorer.music.p303a;

import android.content.Context;
import android.text.TextUtils;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.common.UserBehaviorLog;
import java.util.HashMap;

/* renamed from: com.introvd.template.explorer.music.a.a */
public class C7256a {
    /* renamed from: a */
    public static void m21406a(Context context, int i, String str, String str2) {
        try {
            HashMap hashMap = new HashMap();
            String str3 = "";
            switch (i) {
                case 1:
                    str3 = "online";
                    break;
                case 2:
                    str3 = "downloaded";
                    break;
                case 3:
                    str3 = "local";
                    break;
            }
            hashMap.put("music", str3);
            hashMap.put("BGM_name", str);
            hashMap.put("music_category", str2);
            UserBehaviorLog.onKVEvent(context, "VE_BGM_Add", hashMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void awZ() {
        try {
            UserBehaviorLog.onKVEvent(VivaBaseApplication.m8749FZ(), "VE_BGM_Copyright_Dialog_Show", new HashMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    public static void m21407b(int i, Object... objArr) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("name", objArr[1]);
            hashMap.put("category", objArr[2]);
            UserBehaviorLog.onKVEvent(objArr[0], i == 1 ? "Template_Download_Dubbing" : "Template_Download_Music", hashMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    public static void m21408b(Context context, int i, String str, String str2) {
        if (i == 0) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("name", str);
                hashMap.put("category", str2);
                UserBehaviorLog.onKVEvent(context, "VE_BGM_Download_Done", hashMap);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: bU */
    public static void m21409bU(Context context, String str) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("category", str);
        }
        UserBehaviorLog.onKVEvent(context, "VE_BGM_Category_Click", hashMap);
    }

    /* renamed from: bV */
    public static void m21410bV(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("tab", str);
        UserBehaviorLog.onKVEvent(context, "VE_Dubbing_Tab_Click", hashMap);
    }

    /* renamed from: c */
    public static void m21411c(int i, Object... objArr) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("name", objArr[1]);
            hashMap.put("category", objArr[2]);
            hashMap.put("result", objArr[3]);
            UserBehaviorLog.onKVEvent(objArr[0], i == 1 ? "Template_Download_Dubbing" : "Template_Download_Music", hashMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: c */
    public static void m21412c(Context context, int i, String str, String str2) {
        if (i == 0) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("name", str);
                hashMap.put("category", str2);
                UserBehaviorLog.onKVEvent(context, "VE_BGM_Download_Failed", hashMap);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: fS */
    public static void m21413fS(Context context) {
        try {
            UserBehaviorLog.onKVEvent(context, "VE_BGM_From_Video_Entry_Click", new HashMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: fT */
    public static void m21414fT(Context context) {
        try {
            UserBehaviorLog.onKVEvent(context, "VE_BGM_From_Video_Add_Click", new HashMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: fU */
    public static void m21415fU(Context context) {
        try {
            UserBehaviorLog.onKVEvent(context, "VE_BGM_downloaded_Delete", new HashMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: fV */
    public static void m21416fV(Context context) {
        try {
            UserBehaviorLog.onKVEvent(context, "VE_BGM_ScanFile", new HashMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: fW */
    public static void m21417fW(Context context) {
        try {
            UserBehaviorLog.onKVEvent(context, "VE_BGM_Search_Click", new HashMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: fX */
    public static void m21418fX(Context context) {
        try {
            UserBehaviorLog.onKVEvent(context, "VE_BGM_Search_Result_Click", new HashMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
