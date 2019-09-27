package com.introvd.template.app.webview;

import com.introvd.template.router.todoCode.TODOParamModel;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.introvd.template.app.webview.c */
public class C4486c extends C4484a {
    private static final String TAG = "c";
    private C4485b bIr = null;

    public C4486c(C4485b bVar) {
        this.bIr = bVar;
    }

    /* renamed from: b */
    public void mo24695b(String str, JSONObject jSONObject) {
        if ("Click".equals(str) && jSONObject != null) {
            try {
                int i = jSONObject.getInt("code");
                String optString = jSONObject.optString("content", "");
                boolean optBoolean = jSONObject.optBoolean("auto_close");
                TODOParamModel tODOParamModel = new TODOParamModel();
                tODOParamModel.mTODOCode = i;
                tODOParamModel.mJsonParam = optString;
                if (this.bIr != null) {
                    this.bIr.mo24691b(tODOParamModel, optBoolean);
                }
            } catch (JSONException unused) {
            }
        }
    }

    /* renamed from: en */
    public void mo24696en(String str) {
        if (this.bIr != null) {
            this.bIr.mo24692eu(str);
        }
    }
}
