package com.introvd.template.module.iap.utils;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.introvd.template.module.iap.utils.f */
public final class C8082f {
    /* renamed from: b */
    public static String m23455b(String str, String str2, Object obj) {
        if (TextUtils.isEmpty(str)) {
            str = "{}";
        }
        JSONObject jSONObject = null;
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (jSONObject == null) {
            return str;
        }
        try {
            jSONObject.put(str2, obj);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }
}
