package com.introvd.template.app.p184h.p185a;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.introvd.template.apicore.C3625c;
import com.introvd.template.apicore.p175a.C3620b;
import com.introvd.template.common.LogUtilsV2;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.p131c.p132a.p135c.C2575a;
import com.vivavideo.mobile.h5api.api.C9335a;
import com.vivavideo.mobile.h5api.api.C9345j;
import com.vivavideo.mobile.h5api.api.C9358q;
import com.vivavideo.mobile.h5api.p432a.C9334a;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
import p037b.p050b.C1834l;
import p037b.p050b.C1842q;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p076j.C1820a;

@C9334a(aPx = {"rpc"})
/* renamed from: com.introvd.template.app.h.a.l */
public class C3904l implements C9358q {
    /* access modifiers changed from: private */
    /* renamed from: i */
    public JSONObject m9606i(int i, String str, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(IronSourceConstants.EVENTS_ERROR_CODE, i);
        if (str != null) {
            jSONObject.put("errorMsg", str);
        }
        if (str2 != null) {
            jSONObject.put("data", str2);
        }
        return jSONObject;
    }

    public void getFilter(C9335a aVar) {
    }

    public boolean handleEvent(final C9345j jVar) throws JSONException {
        C1834l lVar;
        String action = jVar.getAction();
        StringBuilder sb = new StringBuilder();
        sb.append("h5Event getAction = ");
        sb.append(action);
        LogUtilsV2.m14227d(sb.toString());
        JSONObject aPD = jVar.aPD();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("h5Event paramJson = ");
        sb2.append(aPD);
        LogUtilsV2.m14227d(sb2.toString());
        if (aPD == null) {
            jVar.mo36588x(m9606i(2, "params null", null));
            return false;
        }
        String optString = aPD.optString("operationFullUrl");
        String optString2 = aPD.optString("method");
        if (optString2.equalsIgnoreCase("get") || optString2.equalsIgnoreCase("post")) {
            JSONObject optJSONObject = aPD.optJSONObject("requestData");
            String jSONObject = optJSONObject != null ? optJSONObject.toString() : null;
            if (TextUtils.isEmpty(optString)) {
                String optString3 = aPD.optString("operationUrl");
                String optString4 = aPD.optString("operationType");
                if (TextUtils.isEmpty(optString3) || TextUtils.isEmpty(optString4)) {
                    jVar.mo36588x(m9606i(2, "operationUrl or operationType or method params null", null));
                    return true;
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append("h5Event apiName = ");
                sb3.append(optString3);
                sb3.append(",method = ");
                sb3.append(optString2);
                sb3.append(", routerName = ");
                sb3.append(optString4);
                sb3.append(",params = ");
                sb3.append(jSONObject);
                LogUtilsV2.m14227d(sb3.toString());
                String cZ = C3625c.m8880GI().mo22964cZ(optString4);
                StringBuilder sb4 = new StringBuilder();
                sb4.append("h5Event domain = ");
                sb4.append(cZ);
                LogUtilsV2.m14227d(sb4.toString());
                if (TextUtils.isEmpty(cZ)) {
                    jVar.mo36588x(m9606i(2, "domain error", null));
                    return true;
                }
                lVar = C3620b.m8857f(optString2, cZ, optString3, jSONObject);
            } else {
                lVar = C3620b.m8858g(optString2, optString, jSONObject);
            }
            if (lVar == null) {
                return true;
            }
            lVar.mo10157d(C1820a.aVi()).mo10152c(C1487a.aUa()).mo10149b((C1842q<? super T>) new C1842q<String>() {
                /* renamed from: a */
                public void mo9877a(C1495b bVar) {
                }

                /* renamed from: dA */
                public void mo9886K(String str) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("h5Event onNext = ");
                    sb.append(str);
                    LogUtilsV2.m14227d(sb.toString());
                    try {
                        jVar.mo36588x(C3904l.this.m9606i(0, "request OK", str));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                public void onComplete() {
                    LogUtilsV2.m14227d("h5Event onComplete = ");
                }

                public void onError(Throwable th) {
                    th.printStackTrace();
                    HashMap l = C3620b.m8859l(th);
                    try {
                        jVar.mo36588x(C3904l.this.m9606i(C2575a.parseInt((String) l.get(IronSourceConstants.EVENTS_ERROR_CODE)), (String) l.get("errorMsg"), null));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("h5Event onError = ");
                    sb.append(new Gson().toJson((Object) l));
                    LogUtilsV2.m14227d(sb.toString());
                }
            });
            return true;
        }
        jVar.mo36588x(m9606i(2, "method params error", null));
        return true;
    }

    public boolean interceptEvent(C9345j jVar) throws JSONException {
        return false;
    }

    public void onRelease() {
    }
}
