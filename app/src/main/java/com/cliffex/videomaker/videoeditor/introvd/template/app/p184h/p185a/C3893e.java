package com.introvd.template.app.p184h.p185a;

import android.text.TextUtils;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.channel.C5206b;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.LogUtilsV2;
import com.ironsource.mediationsdk.utils.ServerResponseWrapper;
import com.vivavideo.mobile.h5api.api.C9335a;
import com.vivavideo.mobile.h5api.api.C9345j;
import com.vivavideo.mobile.h5api.api.C9358q;
import com.vivavideo.mobile.h5api.p432a.C9334a;
import org.json.JSONException;
import org.json.JSONObject;

@C9334a(aPx = {"deviceInfo"})
/* renamed from: com.introvd.template.app.h.a.e */
public class C3893e implements C9358q {
    /* renamed from: EJ */
    private String m9580EJ() {
        String appSettingStr = AppPreferencesSetting.getInstance().getAppSettingStr("AppKey", "");
        return TextUtils.isEmpty(appSettingStr) ? C5206b.m14212dV(VivaBaseApplication.m8749FZ()) : appSettingStr;
    }

    /* renamed from: LZ */
    private JSONObject m9581LZ() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(ServerResponseWrapper.APP_KEY_FIELD, m9580EJ());
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
        JSONObject LZ = m9581LZ();
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
