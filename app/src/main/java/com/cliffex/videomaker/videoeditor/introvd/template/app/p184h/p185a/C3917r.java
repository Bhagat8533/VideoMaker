package com.introvd.template.app.p184h.p185a;

import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.router.iap.IapRouter.IapPayResult;
import com.introvd.template.router.iap.IapServiceProxy;
import com.vivavideo.mobile.h5api.api.C9335a;
import com.vivavideo.mobile.h5api.api.C9345j;
import com.vivavideo.mobile.h5api.api.C9358q;
import com.vivavideo.mobile.h5api.p432a.C9334a;
import org.json.JSONException;
import org.json.JSONObject;

@C9334a(aPx = {"userIsVip", "buyVip"})
/* renamed from: com.introvd.template.app.h.a.r */
public class C3917r implements C9358q {
    /* renamed from: Mf */
    private JSONObject m9624Mf() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(IapServiceProxy.isVip, isVip());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("h5Event response = ");
        sb.append(jSONObject);
        LogUtilsV2.m14227d(sb.toString());
        return jSONObject;
    }

    /* access modifiers changed from: private */
    /* renamed from: bA */
    public JSONObject m9626bA(boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status", z);
            jSONObject.put("code", 0);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("h5Event vip pay response = ");
        sb.append(jSONObject);
        LogUtilsV2.m14227d(sb.toString());
        return jSONObject;
    }

    private boolean isVip() {
        return ((Boolean) IapServiceProxy.execute(IapServiceProxy.isVip, new Object[0])).booleanValue();
    }

    public void getFilter(C9335a aVar) {
    }

    public boolean handleEvent(final C9345j jVar) throws JSONException {
        String action = jVar.getAction();
        if ("userIsVip".equalsIgnoreCase(action)) {
            StringBuilder sb = new StringBuilder();
            sb.append("h5Event getAction = ");
            sb.append(action);
            LogUtilsV2.m14227d(sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("h5Event getParam = ");
            sb2.append(jVar.aPD());
            LogUtilsV2.m14227d(sb2.toString());
            jVar.mo36588x(m9624Mf());
        } else if ("buyVip".equalsIgnoreCase(action)) {
            IapServiceProxy.payForH5(new IapPayResult() {
                public void onPayResult(boolean z) {
                    jVar.mo36588x(C3917r.this.m9626bA(z));
                }
            });
        }
        return true;
    }

    public boolean interceptEvent(C9345j jVar) throws JSONException {
        return false;
    }

    public void onRelease() {
    }
}
