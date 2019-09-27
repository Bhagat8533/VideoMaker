package com.introvd.template.app.p184h.p185a;

import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.p203b.C4580b;
import com.vivavideo.mobile.h5api.api.C9335a;
import com.vivavideo.mobile.h5api.api.C9345j;
import com.vivavideo.mobile.h5api.api.C9358q;
import com.vivavideo.mobile.h5api.p432a.C9334a;
import org.json.JSONException;
import org.json.JSONObject;

@C9334a(aPx = {"getLanguage"})
/* renamed from: com.introvd.template.app.h.a.i */
public class C3900i implements C9358q {
    /* renamed from: LZ */
    private JSONObject m9600LZ() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("language", C4580b.m11635Si());
        return jSONObject;
    }

    public void getFilter(C9335a aVar) {
    }

    public boolean handleEvent(C9345j jVar) throws JSONException {
        String action = jVar.getAction();
        StringBuilder sb = new StringBuilder();
        sb.append("h5Event getAction = ");
        sb.append(action);
        LogUtilsV2.m14227d(sb.toString());
        JSONObject LZ = m9600LZ();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("h5Event response = ");
        sb2.append(LZ.toString());
        LogUtilsV2.m14227d(sb2.toString());
        jVar.mo36588x(LZ);
        return true;
    }

    public boolean interceptEvent(C9345j jVar) throws JSONException {
        return false;
    }

    public void onRelease() {
    }
}
