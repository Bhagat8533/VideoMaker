package com.introvd.template.camera.p231d;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import com.introvd.template.common.FileUtils;
import com.introvd.template.explorer.music.C7255a;
import com.introvd.template.explorer.p300e.C7213f;
import com.introvd.template.router.camera.CameraIntentInfo;
import com.introvd.template.router.camera.CameraIntentInfo.Builder;
import com.introvd.template.router.explorer.MusicDataItem;
import com.introvd.template.router.todoCode.TODOParamModel;
import com.introvd.template.sdk.model.template.TemplateInfo;
import com.introvd.template.sdk.p383c.C8399c;
import com.introvd.template.template.p407e.C8715a;
import com.introvd.template.template.p407e.C8715a.C8719d;
import com.introvd.template.template.p409g.C8762d;
import com.introvd.template.vivacamera.R;
import com.p131c.p132a.p135c.C2575a;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.introvd.template.camera.d.a */
public class C5024a {
    /* access modifiers changed from: private */
    public TODOParamModel bRK;
    private Bundle bRL;
    private C5026a bRM;
    /* access modifiers changed from: private */
    public String bRN;
    /* access modifiers changed from: private */
    public C8715a bRO;
    private Map<String, C5027b> bRP = new LinkedHashMap();
    private int cameraMode;
    private int cameraModeParam;
    /* access modifiers changed from: private */
    public MusicDataItem musicDataItem;

    /* renamed from: com.introvd.template.camera.d.a$a */
    public interface C5026a {
        /* renamed from: a */
        void mo24971a(CameraIntentInfo cameraIntentInfo, TODOParamModel tODOParamModel);
    }

    public C5024a(int i, int i2, TODOParamModel tODOParamModel, Bundle bundle) {
        this.cameraMode = i;
        this.cameraModeParam = i2;
        this.bRK = tODOParamModel;
        this.bRL = bundle;
        m13174WO();
    }

    /* renamed from: WO */
    private void m13174WO() {
        if (this.bRK != null && !TextUtils.isEmpty(this.bRK.mJsonParam)) {
            try {
                String optString = new JSONObject(this.bRK.mJsonParam).optString("templatesJson");
                if (optString != null) {
                    JSONArray jSONArray = new JSONArray(optString);
                    if (jSONArray.length() > 0) {
                        for (int i = 0; i < jSONArray.length(); i++) {
                            JSONObject jSONObject = jSONArray.getJSONObject(i);
                            this.bRP.put(jSONObject.optString("ttid"), new C5028a().mo25884eZ(jSONObject.optString("TCID")).mo25883eY(jSONObject.optString("ttid")).mo25885fa(jSONObject.optString("url")).mo25882WS());
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: WP */
    public void m13175WP() {
        Builder builder = new Builder();
        builder.setCameraMode(this.cameraMode);
        builder.setCameraModeParam(this.cameraModeParam);
        int i = 0;
        builder.setbNewCam(9 != this.cameraModeParam);
        if (this.cameraModeParam == 12) {
            i = 1;
        }
        builder.setCaptureMode(i);
        int i2 = 4100;
        if (this.bRL != null) {
            String string = this.bRL.getString("activityID");
            if (!TextUtils.isEmpty(string)) {
                i2 = 4099;
                builder.setActivityID(string);
            }
        }
        builder.setCameraIntent(i2);
        if (this.bRK != null && !TextUtils.isEmpty(this.bRK.mJsonParam) && this.bRK.getActivityFlag() > 0 && this.bRK.getCameraMode() > 0) {
            builder.setCameraModeParam(this.bRK.getCameraMode());
        }
        if (this.musicDataItem != null) {
            builder.setMusicDataItem(this.musicDataItem);
        }
        if (this.bRN != null) {
            builder.setStickerPath(this.bRN);
        }
        if (this.bRM != null) {
            this.bRM.mo24971a(builder.build(), i != 0 ? null : this.bRK);
        }
    }

    /* renamed from: WQ */
    private boolean m13176WQ() {
        if (this.bRP != null && this.bRP.size() > 0) {
            for (C5027b bVar : this.bRP.values()) {
                if (bVar != null) {
                    if (C8399c.edc.equals(bVar.mo25879WR())) {
                        if (bVar.getUrl() != null) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(C7255a.dAf);
                            sb.append(C7213f.m21302jv(bVar.getUrl()));
                            if (!FileUtils.isFileExisted(sb.toString())) {
                                return true;
                            }
                        } else {
                            continue;
                        }
                    } else if (C8399c.edg.equals(bVar.mo25879WR()) && bVar.getTtid() != null && C8762d.aMt().mo35228bE(C2575a.m7391rq(bVar.getTtid()))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public MusicDataItem m13179a(JSONObject jSONObject, String str) {
        if (str != null) {
            C5027b bVar = (C5027b) this.bRP.get(str);
            if (bVar != null) {
                String optString = jSONObject.optString("musicTrimStartPos", null);
                String optString2 = jSONObject.optString("musicTrimEndPos", null);
                String optString3 = jSONObject.optString("musicTitle", null);
                MusicDataItem musicDataItem2 = new MusicDataItem();
                musicDataItem2.title = optString3;
                StringBuilder sb = new StringBuilder();
                sb.append(C7255a.dAf);
                sb.append(C7213f.m21302jv(bVar.getUrl()));
                musicDataItem2.filePath = sb.toString();
                if (optString != null) {
                    musicDataItem2.startTimeStamp = Integer.valueOf(optString).intValue();
                    musicDataItem2.currentTimeStamp = musicDataItem2.startTimeStamp;
                }
                if (optString2 != null) {
                    musicDataItem2.stopTimeStamp = Integer.valueOf(optString2).intValue();
                }
                return musicDataItem2;
            }
        }
        return null;
    }

    /* renamed from: ac */
    private void m13182ac(Activity activity) {
        if (this.bRK == null || TextUtils.isEmpty(this.bRK.mJsonParam)) {
            m13175WP();
            return;
        }
        String string = activity.getResources().getString(R.string.xiaoying_str_common_preparing);
        final ProgressDialog progressDialog = new ProgressDialog(activity);
        this.bRO = new C8715a(activity, new C8719d() {
            /* renamed from: a */
            public void mo25876a(String str, boolean z, String str2) {
                if (z) {
                    try {
                        JSONObject jSONObject = new JSONObject(new JSONObject(C5024a.this.bRK.mJsonParam).optString("cameraJson"));
                        C5024a.this.musicDataItem = C5024a.this.m13179a(jSONObject, jSONObject.optString("musicId", null));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }

            /* renamed from: cb */
            public void mo25877cb(int i, int i2) {
                if (progressDialog != null) {
                    progressDialog.dismiss();
                }
                if (C5024a.this.bRO != null) {
                    C5024a.this.bRO.release();
                }
                C5024a.this.m13175WP();
            }

            public void onXytDownloadResult(Long l, boolean z) {
                if (z) {
                    C5024a.this.bRN = C8762d.aMt().mo35225bB(l.longValue());
                }
            }
        });
        try {
            JSONObject jSONObject = new JSONObject(new JSONObject(this.bRK.mJsonParam).optString("cameraJson"));
            String optString = jSONObject.optString("musicId", null);
            String optString2 = jSONObject.optString("fbPasterId", null);
            C5027b bVar = (C5027b) this.bRP.get(optString);
            C5027b bVar2 = (C5027b) this.bRP.get(optString2);
            if (bVar != null) {
                String url = bVar.getUrl();
                if (!TextUtils.isEmpty(url)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(C7255a.dAf);
                    sb.append(C7213f.m21302jv(url));
                    if (!FileUtils.isFileExisted(sb.toString())) {
                        this.bRO.mo35098z(url, C7213f.m21302jv(url), C7255a.dAf);
                    } else {
                        this.musicDataItem = m13179a(jSONObject, optString);
                    }
                }
            }
            if (bVar2 != null) {
                if (C8762d.aMt().mo35228bE(Long.decode(optString2).longValue())) {
                    String url2 = bVar2.getUrl();
                    if (!TextUtils.isEmpty(url2)) {
                        TemplateInfo templateInfo = new TemplateInfo();
                        templateInfo.strUrl = url2;
                        templateInfo.ttid = optString2;
                        this.bRO.mo35094B(templateInfo);
                    }
                } else {
                    this.bRN = C8762d.aMt().mo35225bB(Long.decode(optString2).longValue());
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        progressDialog.setMessage(string);
        progressDialog.setCancelable(true);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
    }

    /* renamed from: a */
    public void mo25874a(C5026a aVar) {
        this.bRM = aVar;
    }

    /* renamed from: ab */
    public void mo25875ab(Activity activity) {
        if (m13176WQ()) {
            m13182ac(activity);
            return;
        }
        if (this.bRK != null && !TextUtils.isEmpty(this.bRK.mJsonParam)) {
            try {
                String optString = new JSONObject(this.bRK.mJsonParam).optString("cameraJson", null);
                if (optString != null) {
                    JSONObject jSONObject = new JSONObject(optString);
                    String optString2 = jSONObject.optString("musicId", null);
                    String optString3 = jSONObject.optString("fbPasterId", null);
                    this.musicDataItem = m13179a(jSONObject, optString2);
                    if (optString3 != null) {
                        this.bRN = C8762d.aMt().mo35225bB(Long.decode(optString3).longValue());
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        m13175WP();
    }
}
