package com.introvd.template.app.p184h.p185a;

import android.text.TextUtils;
import com.aiii.android.arouter.p091c.C1919a;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.router.community.ICommunityAPI;
import com.introvd.template.router.user.UserServiceProxy;
import com.vivavideo.mobile.h5api.api.C9335a;
import com.vivavideo.mobile.h5api.api.C9345j;
import com.vivavideo.mobile.h5api.api.C9358q;
import com.vivavideo.mobile.h5api.p432a.C9334a;
import org.json.JSONException;
import org.json.JSONObject;

@C9334a(aPx = {"watchVideoTimesByDuid", "shareVideoTimesByDuid", "userIsSVIP"})
/* renamed from: com.introvd.template.app.h.a.d */
public class C3892d implements C9358q {
    public void getFilter(C9335a aVar) {
    }

    public boolean handleEvent(C9345j jVar) {
        String action = jVar.getAction();
        StringBuilder sb = new StringBuilder();
        sb.append("h5Event getAction = ");
        sb.append(action);
        LogUtilsV2.m14227d(sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("h5Event getParam = ");
        sb2.append(jVar.aPD());
        LogUtilsV2.m14227d(sb2.toString());
        ICommunityAPI iCommunityAPI = (ICommunityAPI) C1919a.m5529sc().mo10356i(ICommunityAPI.class);
        if (iCommunityAPI == null) {
            return true;
        }
        if ("watchVideoTimesByDuid".equalsIgnoreCase(action)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("times", iCommunityAPI.getTaskVideoPlayCount());
                jVar.mo36588x(jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else if ("shareVideoTimesByDuid".equalsIgnoreCase(action)) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("times", iCommunityAPI.getTaskVideoShareCount());
                jVar.mo36588x(jSONObject2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        } else if ("userIsSVIP".equalsIgnoreCase(action)) {
            JSONObject jSONObject3 = new JSONObject();
            try {
                String userId = UserServiceProxy.getUserId();
                if (TextUtils.isEmpty(userId)) {
                    return true;
                }
                jSONObject3.put("isSVIP", iCommunityAPI.isSvip(userId));
                jVar.mo36588x(jSONObject3);
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
        }
        return true;
    }

    public boolean interceptEvent(C9345j jVar) {
        return false;
    }

    public void onRelease() {
    }
}
