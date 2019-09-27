package com.introvd.template.app.p184h.p185a;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.UserBehaviorLog;
import com.vivavideo.mobile.h5api.api.C9335a;
import com.vivavideo.mobile.h5api.api.C9345j;
import com.vivavideo.mobile.h5api.api.C9358q;
import com.vivavideo.mobile.h5api.p432a.C9334a;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

@C9334a(aPx = {"userEvent"})
/* renamed from: com.introvd.template.app.h.a.p */
public class C3914p implements C9358q {
    /* renamed from: f */
    private void m9619f(String str, HashMap<String, String> hashMap) {
        StringBuilder sb = new StringBuilder();
        sb.append("h5Event ub = ");
        sb.append(str);
        sb.append(", params = ");
        sb.append(new Gson().toJson((Object) hashMap));
        LogUtilsV2.m14227d(sb.toString());
        if (!TextUtils.isEmpty(str)) {
            UserBehaviorLog.onKVEvent(VivaBaseApplication.m8749FZ(), str, hashMap);
        }
    }

    public void getFilter(C9335a aVar) {
    }

    public boolean handleEvent(C9345j jVar) throws JSONException {
        String action = jVar.getAction();
        StringBuilder sb = new StringBuilder();
        sb.append("h5Event getAction = ");
        sb.append(action);
        LogUtilsV2.m14227d(sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("h5Event getParam = ");
        sb2.append(jVar.aPD());
        LogUtilsV2.m14227d(sb2.toString());
        JSONObject aPD = jVar.aPD();
        String optString = aPD.optString("seedId");
        JSONObject optJSONObject = aPD.optJSONObject("params");
        HashMap hashMap = new HashMap();
        if (optJSONObject != null) {
            Iterator keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                hashMap.put(str, optJSONObject.getString(str));
            }
        }
        m9619f(optString, hashMap);
        return true;
    }

    public boolean interceptEvent(C9345j jVar) throws JSONException {
        return false;
    }

    public void onRelease() {
    }
}
