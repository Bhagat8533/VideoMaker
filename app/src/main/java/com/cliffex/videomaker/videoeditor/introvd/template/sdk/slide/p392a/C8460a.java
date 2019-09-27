package com.introvd.template.sdk.slide.p392a;

import android.text.TextUtils;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.sdk.slide.model.SlideModuleData;
import com.introvd.template.sdk.slide.model.SlideModuleData.Builder;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.introvd.template.sdk.slide.a.a */
public class C8460a {
    /* renamed from: h */
    public static List<SlideModuleData> m24496h(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                JSONArray jSONArray = jSONObject.getJSONArray("list");
                if (jSONArray != null && jSONArray.length() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        String optString = jSONObject2.optString("title");
                        String optString2 = jSONObject2.optString("desc");
                        arrayList.add(new Builder().setTitle(optString).setDesc(optString2).setMaterialNum(jSONObject2.optInt(SocialConstDef.SEARCH_HISTORY_COUNT)).build());
                    }
                    return arrayList;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /* renamed from: i */
    public static int m24497i(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optInt("videoLimit");
        }
        return 0;
    }

    /* renamed from: j */
    public static String m24498j(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optString("name");
        }
        return null;
    }

    /* renamed from: k */
    public static Long m24499k(JSONObject jSONObject) {
        if (jSONObject == null) {
            return Long.valueOf(0);
        }
        String optString = jSONObject.optString("id");
        return TextUtils.isEmpty(optString) ? Long.valueOf(0) : Long.decode(optString);
    }

    /* renamed from: l */
    public static String m24500l(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optString("url");
        }
        return null;
    }

    /* renamed from: m */
    public static String m24501m(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optString("hashtag");
        }
        return null;
    }

    /* renamed from: n */
    public static boolean m24502n(JSONObject jSONObject) {
        return "8".equals(m24503o(jSONObject));
    }

    /* renamed from: o */
    public static String m24503o(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optString("subTcid");
        }
        return null;
    }

    /* renamed from: p */
    public static int m24504p(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("extend");
            if (optJSONObject != null) {
                return optJSONObject.optInt("materialMax");
            }
        }
        return 0;
    }

    /* renamed from: q */
    public static int m24505q(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("extend");
            if (optJSONObject != null) {
                return optJSONObject.optInt("materialMin");
            }
        }
        return 0;
    }
}
