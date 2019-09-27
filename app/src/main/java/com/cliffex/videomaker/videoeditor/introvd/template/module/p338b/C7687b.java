package com.introvd.template.module.p338b;

import android.text.TextUtils;
import com.introvd.template.router.app.config.AppConfigObserver;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.introvd.template.module.b.b */
public class C7687b extends AppConfigObserver {
    private static final C7687b dNZ = new C7687b();

    public static AppConfigObserver aAW() {
        return dNZ;
    }

    public void onChange(int i, String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                C7686a.dNQ = jSONObject.optInt("SubscriptionDescription", 0);
                C7686a.dNR = jSONObject.optInt("AlipayDisplay", 0);
                C7686a.dNS = jSONObject.optInt("iqiyiDisplay", 0);
                C7686a.dNT = jSONObject.optInt("Exit_Purchase_Display", 0);
                C7686a.dNU = jSONObject.optInt("Exit_Direct_Purchase", 0);
                C7686a.dNV = jSONObject.optInt("Exit_Direct_Purchase_Pay", 0);
                C7686a.dNW = jSONObject.optInt("Subscription_Coupon", 0);
                C7686a.dNX = jSONObject.optInt("Guide_Page_NewUI", 0);
                C7686a.dNY = jSONObject.optInt("guide_purchase_popup", 0);
                C7686a.dNP = jSONObject.optInt("VIP_Privilege_Group", 0);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
