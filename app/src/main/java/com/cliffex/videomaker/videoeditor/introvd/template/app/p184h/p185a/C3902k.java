package com.introvd.template.app.p184h.p185a;

import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.router.iap.IapServiceProxy;
import com.introvd.template.router.iap.InfoMessenger;
import com.vivavideo.mobile.h5api.api.C9335a;
import com.vivavideo.mobile.h5api.api.C9345j;
import com.vivavideo.mobile.h5api.api.C9358q;
import com.vivavideo.mobile.h5api.p432a.C9334a;
import org.json.JSONException;
import org.json.JSONObject;

@C9334a(aPx = {"redemmCode"})
/* renamed from: com.introvd.template.app.h.a.k */
public class C3902k implements C9358q {
    public void getFilter(C9335a aVar) {
    }

    public boolean handleEvent(final C9345j jVar) throws JSONException {
        String action = jVar.getAction();
        StringBuilder sb = new StringBuilder();
        sb.append("h5Event getAction = ");
        sb.append(action);
        LogUtilsV2.m14227d(sb.toString());
        JSONObject aPD = jVar.aPD();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("h5Event getParam = ");
        sb2.append(aPD);
        LogUtilsV2.m14227d(sb2.toString());
        String optString = aPD != null ? aPD.optString("code") : null;
        StringBuilder sb3 = new StringBuilder();
        sb3.append("h5Event getParam = ");
        sb3.append(optString);
        LogUtilsV2.m14227d(sb3.toString());
        IapServiceProxy.execute(IapServiceProxy.exchangeVipForCode, optString, new InfoMessenger<Boolean>() {
            /* renamed from: g */
            public void onMessage(Boolean bool) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("result", bool);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                jVar.mo36588x(jSONObject);
            }
        });
        return true;
    }

    public boolean interceptEvent(C9345j jVar) throws JSONException {
        return false;
    }

    public void onRelease() {
    }
}
