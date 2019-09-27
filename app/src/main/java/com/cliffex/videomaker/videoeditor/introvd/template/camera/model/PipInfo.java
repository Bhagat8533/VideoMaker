package com.introvd.template.camera.model;

import android.text.TextUtils;
import com.introvd.template.router.editor.EditorRouter;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class PipInfo {
    private static final String EXTRA_INFO_PIP = "pip";
    private static final String PIP_CURRENT_INDEX = "pip_current_index";
    private static final String PIP_SEQUENCE = "pip_sequence";
    private static final String PIP_TEMPLATE_ID = "pip_template_id";
    public int mCurrentIndex;
    public List<Integer> mSequence = new ArrayList();
    public long mTemplateId;

    public static String addPipExtraInfo(String str, PipInfo pipInfo) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(PIP_TEMPLATE_ID, pipInfo.mTemplateId);
            jSONObject.put(PIP_CURRENT_INDEX, pipInfo.mCurrentIndex);
            String str2 = "";
            for (int i = 0; i < pipInfo.mSequence.size(); i++) {
                StringBuilder sb = new StringBuilder();
                sb.append(str2);
                sb.append(pipInfo.mSequence.get(i));
                sb.append(EditorRouter.KEY_TOOL_LIST_ORDER_SPLIT_OP);
                str2 = sb.toString();
            }
            jSONObject.put(PIP_SEQUENCE, str2);
            JSONObject jSONObject2 = TextUtils.isEmpty(str) ? new JSONObject() : new JSONObject(str);
            jSONObject2.put(EXTRA_INFO_PIP, jSONObject);
            return jSONObject2.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public static PipInfo getPipExtraInfo(String str) {
        PipInfo pipInfo = new PipInfo();
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject(EXTRA_INFO_PIP);
            if (optJSONObject != null) {
                pipInfo.mTemplateId = optJSONObject.getLong(PIP_TEMPLATE_ID);
                pipInfo.mCurrentIndex = optJSONObject.getInt(PIP_CURRENT_INDEX);
                String string = optJSONObject.getString(PIP_SEQUENCE);
                ArrayList arrayList = new ArrayList();
                String[] split = string.split(EditorRouter.KEY_TOOL_LIST_ORDER_SPLIT_OP);
                for (String valueOf : split) {
                    arrayList.add(Integer.valueOf(valueOf));
                }
                pipInfo.mSequence = arrayList;
            }
        } catch (Exception unused) {
        }
        return pipInfo;
    }

    public static String removePipExtraInfo(String str) {
        try {
            JSONObject jSONObject = TextUtils.isEmpty(str) ? new JSONObject() : new JSONObject(str);
            jSONObject.remove(EXTRA_INFO_PIP);
            return jSONObject.toString();
        } catch (Exception unused) {
            return "";
        }
    }
}
