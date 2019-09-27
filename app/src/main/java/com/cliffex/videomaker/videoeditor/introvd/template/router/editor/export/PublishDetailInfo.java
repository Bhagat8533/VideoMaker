package com.introvd.template.router.editor.export;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class PublishDetailInfo {
    private static final String PRJ_TODO_CONTENT = "prj_todo_content";
    private static final String VIDEO_DESC_USER_REFER = "video_desc_user_refer";
    public String prjTodoContent;
    public JSONObject referUserJson;
    public String strActivityData;
    public String strExtra;
    public String strPrjTitle;
    public String strVideoDesc;

    public PublishDetailInfo(String str, String str2, String str3, String str4, JSONObject jSONObject, String str5) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.strPrjTitle = str;
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        this.strVideoDesc = str2;
        if (TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        this.strActivityData = str3;
        if (TextUtils.isEmpty(str4)) {
            str4 = "";
        }
        this.strExtra = str4;
        this.referUserJson = jSONObject;
        if (TextUtils.isEmpty(str5)) {
            str5 = "";
        }
        this.prjTodoContent = str5;
    }

    private static String addVideoDescUserRefer(String str, JSONObject jSONObject) {
        JSONObject jSONObject2;
        if (TextUtils.isEmpty(str)) {
            jSONObject2 = new JSONObject();
        } else {
            try {
                jSONObject2 = new JSONObject(str);
            } catch (JSONException e) {
                e.printStackTrace();
                jSONObject2 = null;
            }
        }
        if (jSONObject2 != null) {
            try {
                jSONObject2.put(VIDEO_DESC_USER_REFER, jSONObject);
                return jSONObject2.toString();
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return str;
    }

    private static String updatePrjJsonTodoContent(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(PRJ_TODO_CONTENT, jSONObject);
            return jSONObject2.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void addDescUserRefer(JSONObject jSONObject) {
        this.strExtra = addVideoDescUserRefer(this.strExtra, jSONObject);
    }

    public void updatePrjTodoContent(JSONObject jSONObject) {
        this.strExtra = updatePrjJsonTodoContent(jSONObject);
    }
}
