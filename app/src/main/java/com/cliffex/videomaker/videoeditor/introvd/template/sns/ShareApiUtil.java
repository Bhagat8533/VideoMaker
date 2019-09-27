package com.introvd.template.sns;

import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.editor.p252e.C5878a;
import org.json.JSONObject;

public class ShareApiUtil {
    private static final String API_RESPONSE_FORWARD_SNSINFO_DOT = "b";
    private static final String API_RESPONSE_FORWARD_SNSINFO_DOT_KEY = "a";
    private static final String API_RESPONSE_FORWARD_SNSINFO_DOT_RESULT_DESC = "desc";
    private static final String API_RESPONSE_FORWARD_SNSINFO_DOT_RESULT_DOT = "c";
    private static final String API_RESPONSE_FORWARD_SNSINFO_DOT_RESULT_IMAGE = "image";
    private static final String API_RESPONSE_FORWARD_SNSINFO_DOT_RESULT_SNSTYPE = "snstype";
    private static final String API_RESPONSE_FORWARD_SNSINFO_DOT_RESULT_URL = "url";
    private static final String API_RESPONSE_FORWARD_SNSINFO_TYPE = "a";

    public static class ActivityShareInfo {
        public int nShareType;
        public int nSnsType;
        public String strActivityId;
        public String strDesc;
        public String strImgUrl;
        public String strPageUrl;
    }

    public static ActivityShareInfo paserJsonString(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("strJson: ");
        sb.append(str);
        LogUtilsV2.m14230i(sb.toString());
        ActivityShareInfo activityShareInfo = new ActivityShareInfo();
        try {
            JSONObject jSONObject = new JSONObject(str);
            activityShareInfo.nShareType = jSONObject.getInt(C5878a.TAG);
            JSONObject jSONObject2 = jSONObject.getJSONArray("b").getJSONObject(0);
            activityShareInfo.strActivityId = jSONObject2.getString(C5878a.TAG);
            JSONObject jSONObject3 = jSONObject2.getJSONObject(API_RESPONSE_FORWARD_SNSINFO_DOT_RESULT_DOT);
            activityShareInfo.nSnsType = jSONObject3.getInt("snstype");
            activityShareInfo.strImgUrl = jSONObject3.getString("image");
            activityShareInfo.strDesc = jSONObject3.getString("desc");
            activityShareInfo.strPageUrl = jSONObject3.getString("url");
            return activityShareInfo;
        } catch (Exception unused) {
            return null;
        }
    }
}
