package com.introvd.template.router.todoCode;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class TODOParamModel implements Parcelable {
    public static final int ACTIVITY_FLAG_NONE = 0;
    public static final int ACTIVITY_FLAG_REVERSE = 1;
    public static final int ACTIVITY_FLAG_TANABATA = 3;
    public static final int ACTIVITY_FLAG_THEMEAPPLY = 4;
    public static final int ACTIVITY_FLAG_VALENTINE = 2;
    public static final String ACTIVITY_TODO_PARAM_CAMERAID = "cameraid";
    public static final String ACTIVITY_TODO_PARAM_CAMERAMODE = "cameramode";
    public static final String ACTIVITY_TODO_PARAM_ENTERPREVIEW = "enterPreview";
    public static final String ACTIVITY_TODO_PARAM_EVENTTAG = "hashtag";
    public static final String ACTIVITY_TODO_PARAM_FLAG = "flag";
    public static final String ACTIVITY_TODO_PARAM_MAXDURATION = "duration";
    public static final String ACTIVITY_TODO_PARAM_SHARETYPE = "shareType";
    public static final String ACTIVITY_TODO_PARAM_THEMESTATE = "themeState";
    public static final Creator<TODOParamModel> CREATOR = new Creator<TODOParamModel>() {
        public TODOParamModel createFromParcel(Parcel parcel) {
            return new TODOParamModel(parcel);
        }

        public TODOParamModel[] newArray(int i) {
            return new TODOParamModel[i];
        }
    };
    public static final String TODO_PARAM_FB_DOWNLOAD = "fbDownload";
    static final String TODO_PARAM_FROM_TITLE = "fromTitle";
    public static final String TODO_PARAM_PAGE_FROM = "pageFrom";
    private transient JSONObject mJsonContentObj;
    public String mJsonParam;
    public int mTODOCode;

    public TODOParamModel() {
        this.mTODOCode = 0;
        this.mJsonParam = "";
    }

    private TODOParamModel(Parcel parcel) {
        this.mTODOCode = 0;
        this.mJsonParam = "";
        this.mTODOCode = parcel.readInt();
        this.mJsonParam = parcel.readString();
    }

    public static int getPageFromParam(String str) {
        int i;
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            i = new JSONObject(str).optInt(TODO_PARAM_PAGE_FROM);
        } catch (JSONException e) {
            e.printStackTrace();
            i = -1;
        }
        return i;
    }

    public int describeContents() {
        return 0;
    }

    public int getActivityFlag() {
        JSONObject jsonObj = getJsonObj();
        if (jsonObj != null) {
            return jsonObj.optInt("flag");
        }
        return 0;
    }

    public boolean getAutoCloseParam() {
        JSONObject jsonObj = getJsonObj();
        if (jsonObj != null) {
            return jsonObj.optBoolean(TodoConstants.KEY_TODOCODE_PARAM_AUTOCLOSE);
        }
        return false;
    }

    public int getCameraId() {
        JSONObject jsonObj = getJsonObj();
        if (jsonObj != null) {
            return jsonObj.optInt(ACTIVITY_TODO_PARAM_CAMERAID);
        }
        return 0;
    }

    public int getCameraMode() {
        JSONObject jsonObj = getJsonObj();
        if (jsonObj != null) {
            return jsonObj.optInt(ACTIVITY_TODO_PARAM_CAMERAMODE);
        }
        return 0;
    }

    public String getHashTag() {
        JSONObject jsonObj = getJsonObj();
        return jsonObj != null ? jsonObj.optString("hashtag") : "";
    }

    public JSONObject getJsonObj() {
        if (this.mJsonContentObj != null) {
            return this.mJsonContentObj;
        }
        if (TextUtils.isEmpty(this.mJsonParam)) {
            return null;
        }
        try {
            this.mJsonContentObj = new JSONObject(this.mJsonParam);
            return this.mJsonContentObj;
        } catch (JSONException unused) {
            return null;
        }
    }

    public int getLimitDuration() {
        JSONObject jsonObj = getJsonObj();
        if (jsonObj != null) {
            return jsonObj.optInt("duration", 0) * 1000;
        }
        return 0;
    }

    public int getPageFromParam() {
        JSONObject jsonObj = getJsonObj();
        if (jsonObj != null) {
            return jsonObj.optInt(TODO_PARAM_PAGE_FROM);
        }
        return 0;
    }

    public int getTitleEditFlag() {
        JSONObject jsonObj = getJsonObj();
        if (jsonObj != null) {
            return jsonObj.optInt(ACTIVITY_TODO_PARAM_THEMESTATE, 2);
        }
        return 0;
    }

    /* access modifiers changed from: 0000 */
    public String getTodoParamValue(String str) {
        try {
            JSONObject jsonObj = getJsonObj();
            if (jsonObj != null) {
                return jsonObj.optString(str, "");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public boolean isEnterPreview() {
        JSONObject jsonObj = getJsonObj();
        boolean z = false;
        if (jsonObj == null) {
            return false;
        }
        if (jsonObj.optInt(ACTIVITY_TODO_PARAM_ENTERPREVIEW, 0) == 1) {
            z = true;
        }
        return z;
    }

    public boolean isNormalShare() {
        JSONObject jsonObj = getJsonObj();
        boolean z = false;
        if (jsonObj == null) {
            return false;
        }
        if (jsonObj.optInt(ACTIVITY_TODO_PARAM_SHARETYPE, 1) == 0) {
            z = true;
        }
        return z;
    }

    /* access modifiers changed from: 0000 */
    public void setTodoParam(String str, String str2) {
        try {
            JSONObject jsonObj = getJsonObj();
            if (jsonObj != null) {
                jsonObj.put(str, str2);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mTODOCode);
        parcel.writeString(this.mJsonParam);
    }
}
