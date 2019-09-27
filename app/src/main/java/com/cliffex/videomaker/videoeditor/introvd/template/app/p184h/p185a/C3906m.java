package com.introvd.template.app.p184h.p185a;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.introvd.template.R;
import com.introvd.template.app.model.ShareToAppInfo;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.ToastUtils;
import com.vivavideo.mobile.h5api.api.C9335a;
import com.vivavideo.mobile.h5api.api.C9345j;
import com.vivavideo.mobile.h5api.api.C9358q;
import com.vivavideo.mobile.h5api.p432a.C9334a;
import org.json.JSONException;
import org.json.JSONObject;

@C9334a(aPx = {"shareToApp"})
/* renamed from: com.introvd.template.app.h.a.m */
public class C3906m implements C9358q {
    private C9345j bsV;

    /* renamed from: M */
    private void m9610M(String str, String str2) {
        if (TextUtils.isEmpty(str2) || !m9612dB(str2)) {
            ToastUtils.show(this.bsV.getActivity().getApplicationContext(), R.string.xiaoying_str_video_download_douyin_not_install, 0);
            return;
        }
        Uri parse = Uri.parse(str);
        Intent intent = new Intent();
        intent.setPackage(str2);
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.STREAM", parse);
        intent.setType("video/*");
        this.bsV.getActivity().startActivity(intent);
        this.bsV.mo36588x(m9611Mc());
    }

    /* renamed from: Mc */
    private JSONObject m9611Mc() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status", true);
            jSONObject.put("code", 0);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* renamed from: dB */
    private boolean m9612dB(String str) {
        PackageInfo packageInfo;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            packageInfo = this.bsV.getActivity().getPackageManager().getPackageInfo(str, 0);
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            packageInfo = null;
        }
        return packageInfo != null;
    }

    public void getFilter(C9335a aVar) {
    }

    public boolean handleEvent(C9345j jVar) throws JSONException {
        this.bsV = jVar;
        if ((this.bsV == null && this.bsV.aPD() == null) || this.bsV.getActivity().isFinishing()) {
            return true;
        }
        String action = jVar.getAction();
        JSONObject aPD = this.bsV.aPD();
        StringBuilder sb = new StringBuilder();
        sb.append("h5Event getAction = ");
        sb.append(action);
        LogUtilsV2.m14227d(sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("h5Event getParam = ");
        sb2.append(this.bsV.aPD());
        LogUtilsV2.m14227d(sb2.toString());
        ShareToAppInfo shareToAppInfo = (ShareToAppInfo) new Gson().fromJson(aPD.toString(), ShareToAppInfo.class);
        if (shareToAppInfo == null) {
            return true;
        }
        String str = shareToAppInfo.url;
        String str2 = shareToAppInfo.packageName;
        if (1 != shareToAppInfo.type && 2 == shareToAppInfo.type) {
            m9610M(str, str2);
        }
        return true;
    }

    public boolean interceptEvent(C9345j jVar) throws JSONException {
        return false;
    }

    public void onRelease() {
    }
}
