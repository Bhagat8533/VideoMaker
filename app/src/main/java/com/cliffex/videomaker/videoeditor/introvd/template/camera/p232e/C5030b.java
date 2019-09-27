package com.introvd.template.camera.p232e;

import android.text.TextUtils;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.router.camera.CameraCodeMgr;
import org.json.JSONObject;

/* renamed from: com.introvd.template.camera.e.b */
public class C5030b {
    /* renamed from: C */
    public static void m13201C(int i, boolean z) {
        String str = "";
        String str2 = "pref_view_auto_record_pre_";
        if (CameraCodeMgr.isCameraParamDefault(i)) {
            str = "normal";
        } else if (CameraCodeMgr.isCameraParamMV(i)) {
            str = "mv";
        } else if (CameraCodeMgr.isCameraParamPIP(i)) {
            str = "pip";
        } else if (CameraCodeMgr.isCameraParamFB(i)) {
            str = "fb";
        }
        AppPreferencesSetting instance = AppPreferencesSetting.getInstance();
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append(str);
        instance.setAppSettingBoolean(sb.toString(), z);
    }

    /* renamed from: YP */
    public static void m13202YP() {
        m13201C(1, false);
        m13201C(8, false);
        m13201C(6, true);
        m13201C(9, false);
    }

    /* renamed from: fj */
    public static int m13203fj(String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("autoRec");
            if (optJSONObject == null) {
                return 0;
            }
            m13201C(1, optJSONObject.getBoolean("normal"));
            m13201C(6, optJSONObject.getBoolean("mv"));
            m13201C(9, optJSONObject.getBoolean("pip"));
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* renamed from: fk */
    public static String m13204fk(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("normal", m13205jL(1));
            jSONObject.put("mv", m13205jL(6));
            jSONObject.put("pip", m13205jL(9));
            JSONObject jSONObject2 = TextUtils.isEmpty(str) ? new JSONObject() : new JSONObject(str);
            jSONObject2.put("autoRec", jSONObject);
            return jSONObject2.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    /* renamed from: jL */
    public static boolean m13205jL(int i) {
        boolean z;
        String str = "pref_view_auto_record_pre_";
        if (CameraCodeMgr.isCameraParamDefault(i)) {
            AppPreferencesSetting instance = AppPreferencesSetting.getInstance();
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("normal");
            z = instance.getAppSettingBoolean(sb.toString(), false);
        } else {
            z = false;
        }
        if (CameraCodeMgr.isCameraParamMV(i)) {
            AppPreferencesSetting instance2 = AppPreferencesSetting.getInstance();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append("mv");
            return instance2.getAppSettingBoolean(sb2.toString(), true);
        } else if (CameraCodeMgr.isCameraParamPIP(i)) {
            AppPreferencesSetting instance3 = AppPreferencesSetting.getInstance();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str);
            sb3.append("pip");
            return instance3.getAppSettingBoolean(sb3.toString(), false);
        } else if (!CameraCodeMgr.isCameraParamFB(i)) {
            return z;
        } else {
            AppPreferencesSetting instance4 = AppPreferencesSetting.getInstance();
            StringBuilder sb4 = new StringBuilder();
            sb4.append(str);
            sb4.append("fb");
            return instance4.getAppSettingBoolean(sb4.toString(), false);
        }
    }
}
