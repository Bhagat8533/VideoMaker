package com.introvd.template.common.gson;

import android.text.TextUtils;
import com.google.gson.Gson;

public class GsonUtils {
    public static <T> T fromJson(String str, Class<T> cls) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new Gson().fromJson(str, cls);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
