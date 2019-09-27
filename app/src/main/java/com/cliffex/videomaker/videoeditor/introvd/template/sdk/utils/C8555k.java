package com.introvd.template.sdk.utils;

import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.sdk.model.editor.EffectInfoModel;
import com.introvd.template.sdk.p383c.C8399c;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.introvd.template.sdk.utils.k */
public class C8555k {
    /* renamed from: k */
    public static Long m25011k(JSONObject jSONObject) {
        if (m25013s(jSONObject) <= 0) {
            return Long.valueOf(0);
        }
        List r = m25012r(jSONObject);
        if (r != null) {
            for (int i = 0; i < r.size(); i++) {
                EffectInfoModel effectInfoModel = (EffectInfoModel) r.get(i);
                if (C8399c.ecX.equals(effectInfoModel.mTCID)) {
                    return Long.valueOf(effectInfoModel.mTemplateId);
                }
            }
        }
        return Long.valueOf(0);
    }

    /* renamed from: r */
    public static List<EffectInfoModel> m25012r(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                JSONArray jSONArray = jSONObject.getJSONArray(SocialConstDef.ACTIVITY_JOIN_TEMPLATES);
                if (jSONArray != null && jSONArray.length() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        String optString = jSONObject2.optString("url");
                        String optString2 = jSONObject2.optString("TCID");
                        String optString3 = jSONObject2.optString("ttid");
                        EffectInfoModel effectInfoModel = new EffectInfoModel();
                        effectInfoModel.mTemplateId = Long.decode(optString3).longValue();
                        effectInfoModel.mName = "test";
                        effectInfoModel.mTCID = optString2;
                        effectInfoModel.setmUrl(optString);
                        effectInfoModel.mType = "bgm";
                        arrayList.add(effectInfoModel);
                    }
                    return arrayList;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /* renamed from: s */
    public static int m25013s(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                JSONArray jSONArray = jSONObject.getJSONArray(SocialConstDef.ACTIVITY_JOIN_TEMPLATES);
                if (jSONArray != null) {
                    return jSONArray.length();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }
}
