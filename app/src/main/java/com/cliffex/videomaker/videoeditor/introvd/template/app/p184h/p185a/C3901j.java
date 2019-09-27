package com.introvd.template.app.p184h.p185a;

import android.net.Uri;
import android.text.TextUtils;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.app.p177b.C3742b;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.UserBehaviorLog;
import com.ironsource.sdk.controller.BannerJSAdapter;
import com.vivavideo.mobile.h5api.api.C9335a;
import com.vivavideo.mobile.h5api.api.C9345j;
import com.vivavideo.mobile.h5api.api.C9358q;
import com.vivavideo.mobile.h5api.p432a.C9334a;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

@C9334a(aPx = {"h5PageStarted", "h5PageError", "h5PageFinished"})
/* renamed from: com.introvd.template.app.h.a.j */
public class C3901j implements C9358q {
    private HashMap<String, String> bsX = new HashMap<>();

    /* renamed from: dz */
    private String m9601dz(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Uri parse = Uri.parse(str);
        if (parse == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(parse.getScheme());
        sb.append("://");
        sb.append(parse.getHost());
        sb.append(parse.getPath());
        return sb.toString();
    }

    /* renamed from: e */
    private void m9602e(boolean z, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("result", z ? "success" : BannerJSAdapter.FAIL);
        hashMap.put("url", str);
        UserBehaviorLog.onKVEvent(VivaBaseApplication.m8749FZ(), "WebPage_Load_Result", hashMap);
    }

    /* renamed from: f */
    private void m9603f(boolean z, String str) {
        if (TextUtils.equals(m9601dz(C3742b.m9111II().mo23147JO()), str)) {
            HashMap hashMap = new HashMap();
            hashMap.put("result", z ? "success" : BannerJSAdapter.FAIL);
            UserBehaviorLog.onKVEvent(VivaBaseApplication.m8749FZ(), "VivaSchool_Load_Result", hashMap);
        }
    }

    public void getFilter(C9335a aVar) {
    }

    public boolean handleEvent(C9345j jVar) throws JSONException {
        return false;
    }

    public boolean interceptEvent(C9345j jVar) throws JSONException {
        String action = jVar.getAction();
        JSONObject aPD = jVar.aPD();
        if (aPD == null) {
            return false;
        }
        String dz = m9601dz(aPD.optString("url", ""));
        if (TextUtils.isEmpty(dz)) {
            return false;
        }
        if ("h5PageFinished".equals(action)) {
            StringBuilder sb = new StringBuilder();
            sb.append("H5_PAGE_FINISHED : ");
            sb.append(dz);
            LogUtilsV2.m14230i(sb.toString());
            if (TextUtils.equals((CharSequence) this.bsX.get(dz), "h5PageStarted")) {
                this.bsX.remove(dz);
                m9602e(true, dz);
                m9603f(true, dz);
            }
        } else if ("h5PageError".equals(action)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("H5_PAGE_ERROR : ");
            sb2.append(dz);
            LogUtilsV2.m14230i(sb2.toString());
            if (TextUtils.equals((CharSequence) this.bsX.get(dz), "h5PageStarted")) {
                this.bsX.remove(dz);
                m9602e(false, dz);
                m9603f(false, dz);
            }
        } else if ("h5PageStarted".equals(action)) {
            this.bsX.put(dz, action);
            StringBuilder sb3 = new StringBuilder();
            sb3.append("H5_PAGE_STARTED : ");
            sb3.append(dz);
            LogUtilsV2.m14230i(sb3.toString());
        }
        return false;
    }

    public void onRelease() {
    }
}
