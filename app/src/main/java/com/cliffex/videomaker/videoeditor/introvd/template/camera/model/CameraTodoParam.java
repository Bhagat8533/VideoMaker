package com.introvd.template.camera.model;

import android.text.TextUtils;
import com.introvd.template.router.todoCode.TODOParamModel;
import org.json.JSONException;
import org.json.JSONObject;

public class CameraTodoParam {
    private static final String CAMERA_TODO_PARAM_CAMERA_DUR = "cameraDuration";
    private static final String CAMERA_TODO_PARAM_CAMERA_OPEN_FILTER = "openFilter";
    private static final String CAMERA_TODO_PARAM_CAMERA_OPEN_FILTER_COUNT = "upcount";
    private static final String CAMERA_TODO_PARAM_CAMERA_RATIO = "cameraRatio";
    private static final String CAMERA_TODO_PARAM_CAMERA_STICKER_GROUP_CODE = "stikerGroupCode";
    private static final String CAMERA_TODO_PARAM_CAMERA_SWAP = "cameraSwap";
    private static final String CAMERA_TODO_PARAM_TEMPLATE_ROLL_CODE = "TemplateRollCode";
    private JSONObject mJsonContentObj;
    private String mJsonParam;

    public CameraTodoParam(TODOParamModel tODOParamModel) {
        this.mJsonParam = tODOParamModel.mJsonParam;
    }

    private JSONObject getJsonObj() {
        if (this.mJsonContentObj != null) {
            return this.mJsonContentObj;
        }
        if (TextUtils.isEmpty(this.mJsonParam)) {
            return null;
        }
        try {
            this.mJsonContentObj = new JSONObject(this.mJsonParam);
            return this.mJsonContentObj;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int getCameraDurLimit() {
        if (this.mJsonContentObj == null) {
            this.mJsonContentObj = getJsonObj();
        }
        if (this.mJsonContentObj != null) {
            return this.mJsonContentObj.optInt(CAMERA_TODO_PARAM_CAMERA_DUR);
        }
        return 0;
    }

    public String getCameraFilterRollCode() {
        if (this.mJsonContentObj == null) {
            this.mJsonContentObj = getJsonObj();
        }
        if (this.mJsonContentObj != null) {
            return this.mJsonContentObj.optString(CAMERA_TODO_PARAM_TEMPLATE_ROLL_CODE);
        }
        return null;
    }

    public int getCameraId() {
        if (this.mJsonContentObj == null) {
            this.mJsonContentObj = getJsonObj();
        }
        if (this.mJsonContentObj != null) {
            if ("front".equals(this.mJsonContentObj.optString(CAMERA_TODO_PARAM_CAMERA_SWAP))) {
                return 1;
            }
        }
        return 0;
    }

    public int getCameraRatio() {
        if (this.mJsonContentObj == null) {
            this.mJsonContentObj = getJsonObj();
        }
        if (this.mJsonContentObj == null) {
            return 2;
        }
        String optString = this.mJsonContentObj.optString(CAMERA_TODO_PARAM_CAMERA_RATIO);
        if ("1x1".equals(optString)) {
            return 0;
        }
        return "4x3".equals(optString) ? 1 : 2;
    }

    public int getCametaFilterUpCount() {
        if (this.mJsonContentObj == null) {
            this.mJsonContentObj = getJsonObj();
        }
        if (this.mJsonContentObj != null) {
            return this.mJsonContentObj.optInt(CAMERA_TODO_PARAM_CAMERA_OPEN_FILTER_COUNT);
        }
        return 0;
    }

    public String getStickerGroupCode() {
        if (this.mJsonContentObj == null) {
            this.mJsonContentObj = getJsonObj();
        }
        if (this.mJsonContentObj != null) {
            return this.mJsonContentObj.optString(CAMERA_TODO_PARAM_CAMERA_STICKER_GROUP_CODE);
        }
        return null;
    }

    public int isNeedOpenFilter() {
        if (this.mJsonContentObj == null) {
            this.mJsonContentObj = getJsonObj();
        }
        if (this.mJsonContentObj != null) {
            String optString = this.mJsonContentObj.optString(CAMERA_TODO_PARAM_CAMERA_OPEN_FILTER);
            if ("YES".equals(optString)) {
                return 1;
            }
            if ("YES&UNFOLD".equals(optString)) {
                return 2;
            }
        }
        return 0;
    }
}
