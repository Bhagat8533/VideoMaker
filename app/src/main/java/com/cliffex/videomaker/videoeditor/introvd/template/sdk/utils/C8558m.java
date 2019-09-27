package com.introvd.template.sdk.utils;

import android.text.TextUtils;
import com.introvd.template.router.editor.EditorRouter;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.introvd.template.sdk.utils.m */
public class C8558m {
    public static volatile boolean egQ;
    public static String egR;

    /* renamed from: a */
    public static String m25016a(String str, Float f) {
        try {
            JSONObject jSONObject = new JSONObject();
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(f);
            jSONObject.put("camspeedvalue", sb.toString());
            JSONObject jSONObject2 = new JSONObject();
            if (!TextUtils.isEmpty(str)) {
                jSONObject2 = new JSONObject(str);
            }
            jSONObject2.put("cameraSpeed", jSONObject);
            return jSONObject2.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    public static String aJh() {
        String str = "";
        if (egQ) {
            str = m25032oo("");
            egQ = false;
        }
        if (!TextUtils.isEmpty(egR)) {
            str = m25020aX(str, egR);
            egR = null;
        }
        return m25029ol(str);
    }

    /* renamed from: aU */
    public static String m25017aU(String str, String str2) {
        String str3 = "";
        try {
            JSONObject jSONObject = TextUtils.isEmpty(str) ? new JSONObject() : new JSONObject(str);
            jSONObject.put("slide_prj_hash_tag", str2);
            return jSONObject.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return str3;
        }
    }

    /* renamed from: aV */
    public static String m25018aV(String str, String str2) {
        JSONObject jSONObject;
        if (TextUtils.isEmpty(str)) {
            jSONObject = new JSONObject();
        } else {
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException e) {
                e.printStackTrace();
                jSONObject = null;
            }
        }
        if (jSONObject != null) {
            try {
                jSONObject.put(str2, true);
                return jSONObject.toString();
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return str;
    }

    /* renamed from: aW */
    public static boolean m25019aW(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return new JSONObject(str).optBoolean(str2, false);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /* renamed from: aX */
    private static String m25020aX(String str, String str2) {
        JSONObject jSONObject;
        if (TextUtils.isEmpty(str)) {
            jSONObject = new JSONObject();
        } else {
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException e) {
                e.printStackTrace();
                jSONObject = null;
            }
        }
        if (jSONObject != null) {
            try {
                jSONObject.put("prj_todo_content", str2);
                return jSONObject.toString();
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return str;
    }

    /* renamed from: d */
    public static String m25021d(String str, Long l) {
        String str2 = "";
        try {
            JSONObject jSONObject = TextUtils.isEmpty(str) ? new JSONObject() : new JSONObject(str);
            jSONObject.put("slide_prj_theme_id", l);
            return jSONObject.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return str2;
        }
    }

    /* renamed from: g */
    public static String m25022g(String str, int i, int i2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("paramRatio", i);
            jSONObject.put("paramMode", i2);
            JSONObject jSONObject2 = new JSONObject();
            if (!TextUtils.isEmpty(str)) {
                jSONObject2 = new JSONObject(str);
            }
            jSONObject2.put("cameraParam", jSONObject);
            return jSONObject2.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    /* renamed from: k */
    public static String m25023k(String str, long j) {
        try {
            JSONObject jSONObject = TextUtils.isEmpty(str) ? new JSONObject() : new JSONObject(str);
            jSONObject.put("coverTime", j);
            return jSONObject.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    /* renamed from: og */
    public static String m25024og(String str) {
        String str2 = "";
        try {
            return new JSONObject(str).optString("slide_prj_hash_tag");
        } catch (Exception e) {
            e.printStackTrace();
            return str2;
        }
    }

    /* renamed from: oh */
    public static Long m25025oh(String str) {
        long j;
        try {
            j = new JSONObject(str).optLong("slide_prj_theme_id");
        } catch (Exception e) {
            e.printStackTrace();
            j = 0;
        }
        return Long.valueOf(j);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* renamed from: oi */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static float m25026oi(java.lang.String r2) {
        /*
            r0 = 1065353216(0x3f800000, float:1.0)
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x0020 }
            r1.<init>(r2)     // Catch:{ Exception -> 0x0020 }
            java.lang.String r2 = "cameraSpeed"
            org.json.JSONObject r2 = r1.optJSONObject(r2)     // Catch:{ Exception -> 0x0020 }
            if (r2 == 0) goto L_0x0024
            java.lang.String r1 = "camspeedvalue"
            java.lang.String r2 = r2.getString(r1)     // Catch:{ Exception -> 0x0020 }
            boolean r1 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0020 }
            if (r1 != 0) goto L_0x0024
            float r2 = java.lang.Float.parseFloat(r2)     // Catch:{ Exception -> 0x0020 }
            goto L_0x0026
        L_0x0020:
            r2 = move-exception
            r2.printStackTrace()
        L_0x0024:
            r2 = 1065353216(0x3f800000, float:1.0)
        L_0x0026:
            r1 = 0
            int r1 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r1 > 0) goto L_0x002d
            r2 = 1065353216(0x3f800000, float:1.0)
        L_0x002d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.sdk.utils.C8558m.m25026oi(java.lang.String):float");
    }

    /* renamed from: oj */
    public static int[] m25027oj(String str) {
        int[] iArr = {-1, -1};
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("cameraParam");
            if (optJSONObject != null) {
                int i = optJSONObject.getInt("paramRatio");
                int i2 = optJSONObject.getInt("paramMode");
                iArr[0] = i;
                iArr[1] = i2;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return iArr;
    }

    /* renamed from: ok */
    public static String[] m25028ok(String str) {
        String[] strArr = {"", ""};
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("commonBehaviorParam");
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("prj_behavior_todocode", "0");
                String optString2 = optJSONObject.optString("prj_behavior_position", EditorRouter.COMMON_BEHAVIOR_POSITION_OTHER);
                strArr[0] = optString;
                strArr[1] = optString2;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strArr;
    }

    /* renamed from: ol */
    public static String m25029ol(String str) {
        int om = m25030om(str) + 1;
        try {
            JSONObject jSONObject = TextUtils.isEmpty(str) ? new JSONObject() : new JSONObject(str);
            jSONObject.put("prj_edit_times", om);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return str;
        }
    }

    /* renamed from: om */
    public static int m25030om(String str) {
        try {
            return new JSONObject(str).optInt("prj_edit_times", 0);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* renamed from: on */
    public static Long m25031on(String str) {
        long j;
        try {
            j = new JSONObject(str).optLong("coverTime");
        } catch (Exception e) {
            e.printStackTrace();
            j = 0;
        }
        return Long.valueOf(j);
    }

    /* renamed from: oo */
    public static String m25032oo(String str) {
        return m25018aV(str, "prj_mini_flag");
    }

    /* renamed from: op */
    public static boolean m25033op(String str) {
        return m25019aW(str, "prj_mini_flag");
    }

    /* renamed from: oq */
    public static String m25034oq(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return new JSONObject(str).optString("prj_todo_content");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /* renamed from: or */
    public static JSONObject m25035or(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return new JSONObject(str).optJSONObject("video_desc_user_refer");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /* renamed from: v */
    public static String m25036v(String str, String str2, String str3) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("prj_behavior_todocode", str2);
            jSONObject.put("prj_behavior_position", str3);
            JSONObject jSONObject2 = new JSONObject();
            if (!TextUtils.isEmpty(str)) {
                jSONObject2 = new JSONObject(str);
            }
            jSONObject2.put("commonBehaviorParam", jSONObject);
            return jSONObject2.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }
}
