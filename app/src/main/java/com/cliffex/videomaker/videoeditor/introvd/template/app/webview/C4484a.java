package com.introvd.template.app.webview;

import android.webkit.JavascriptInterface;
import org.json.JSONObject;

/* renamed from: com.introvd.template.app.webview.a */
public abstract class C4484a {
    /* renamed from: b */
    public abstract void mo24695b(String str, JSONObject jSONObject);

    /* renamed from: en */
    public abstract void mo24696en(String str);

    @JavascriptInterface
    public void execute(String str, String str2) {
        if ("GetHTML".equals(str)) {
            mo24696en(str2);
            return;
        }
        JSONObject jSONObject = null;
        if (str2 != null) {
            try {
                jSONObject = new JSONObject(str2);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        mo24695b(str, jSONObject);
    }
}
