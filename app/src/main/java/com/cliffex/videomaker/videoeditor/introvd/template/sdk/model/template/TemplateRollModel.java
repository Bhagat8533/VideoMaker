package com.introvd.template.sdk.model.template;

import android.text.TextUtils;
import com.introvd.template.sdk.model.BaseObject;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TemplateRollModel extends BaseObject implements Cloneable {
    public static final String FILTER_STATIC_TYPE_BEAUTY = "2";
    public static final String FILTER_STATIC_TYPE_EDITOR = "3";
    public static final String FILTER_STATIC_TYPE_NORMAL = "0";
    private static final String ROLL_ICONINFO_JSON_BIGICON = "bigicon";
    private static final String ROLL_ICONINFO_JSON_ICON = "icon";
    private static final String ROLL_ICONINFO_JSON_XYTINFOS = "templateinfo";
    private static final String ROLL_ICONINFO_JSON_XYTINFO_ICON = "icon";
    private static final String ROLL_ICONINFO_JSON_XYTINFO_PREVIEW = "preview";
    private static final String ROLL_ICONINFO_JSON_XYTINFO_TITLE = "title";
    private static final String ROLL_SCRIPT_JSON_COPYRIGHT = "copyright";
    private static final String ROLL_SCRIPT_JSON_DETAILINTRO = "details";
    private static final String ROLL_SCRIPT_JSON_SIMPLEINTRO = "littleIntro";
    private static final String ROLL_SCRIPT_JSON_TITLE = "title";
    public static final String SUBTITLE_STATIC_TYPE = "0";
    public static final String SUBTITLE_STATIC_TYPE_ANIM = "1";
    public static final String SUBTITLE_STATIC_TYPE_COMBINE = "2";
    public String engineVer = "";
    public int isShowInMC = 0;
    public String lang = "";
    public int mNewFlag = 0;
    public RollIconInfo mRollIconInfo = null;
    public RollScriptInfo mRollScriptInfo = null;
    public String rollCode = "";
    public String rollDownUrl = "";
    public String rollPrice = "";
    public String rollScript = "";
    public String rollXytInfos = "";
    public String strSubType = "0";
    public String strTCID = "";

    private RollScriptInfo getRollScriptInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        RollScriptInfo rollScriptInfo = new RollScriptInfo();
        try {
            JSONObject jSONObject = new JSONObject(str);
            rollScriptInfo.rollTitle = jSONObject.optString("title");
            rollScriptInfo.rollCopyRightInfo = jSONObject.optString(ROLL_SCRIPT_JSON_COPYRIGHT);
            rollScriptInfo.rollSimpleIntro = jSONObject.optString(ROLL_SCRIPT_JSON_SIMPLEINTRO);
            rollScriptInfo.rollDetailIntro = jSONObject.optString(ROLL_SCRIPT_JSON_DETAILINTRO);
        } catch (JSONException unused) {
        }
        return rollScriptInfo;
    }

    public Object clone() {
        try {
            TemplateRollModel templateRollModel = (TemplateRollModel) super.clone();
            try {
                templateRollModel.mRollIconInfo = (RollIconInfo) templateRollModel.mRollIconInfo.clone();
                templateRollModel.mRollScriptInfo = (RollScriptInfo) templateRollModel.mRollScriptInfo.clone();
                return templateRollModel;
            } catch (CloneNotSupportedException unused) {
                return templateRollModel;
            }
        } catch (CloneNotSupportedException unused2) {
            return null;
        }
    }

    public RollIconInfo getRollIconInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        RollIconInfo rollIconInfo = new RollIconInfo();
        try {
            JSONObject jSONObject = new JSONObject(str);
            rollIconInfo.mIconUrl = jSONObject.optString("icon");
            rollIconInfo.mBigIconUrl = jSONObject.optString("bigicon");
            JSONArray jSONArray = new JSONArray(jSONObject.optString(ROLL_ICONINFO_JSON_XYTINFOS));
            int length = jSONArray.length();
            if (length > 0) {
                rollIconInfo.mXytList = new ArrayList();
                for (int i = 0; i < length; i++) {
                    RollXytInfo rollXytInfo = new RollXytInfo();
                    JSONObject jSONObject2 = (JSONObject) jSONArray.get(i);
                    rollXytInfo.mXytIconUrl = jSONObject2.optString("icon");
                    rollXytInfo.mXytPreviewUrl = jSONObject2.optString(ROLL_ICONINFO_JSON_XYTINFO_PREVIEW);
                    rollXytInfo.mName = jSONObject2.optString("title");
                    rollIconInfo.mXytList.add(rollXytInfo);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rollIconInfo;
    }

    public RollScriptInfo getRollScriptInfo() {
        return getRollScriptInfo(this.rollScript);
    }

    public boolean isAnimSubType() {
        return "1".equals(this.strSubType);
    }

    public boolean isCombineSubType() {
        return "2".equals(this.strSubType);
    }

    public boolean isNormalSubType() {
        return "0".equals(this.strSubType);
    }
}
