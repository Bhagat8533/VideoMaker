package com.introvd.template.app;

import android.app.Activity;
import android.os.Bundle;
import com.aiii.android.arouter.p091c.C1919a;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.editor.p252e.C5878a;
import com.introvd.template.explorer.extract.C7234b;
import com.introvd.template.router.community.ICommunityAPI;
import com.introvd.template.router.todoCode.BizAppTodoActionManager;
import com.introvd.template.router.todoCode.TODOParamModel;
import com.p131c.p132a.p135c.C2575a;
import org.json.JSONObject;

/* renamed from: com.introvd.template.app.k */
public class C4027k {
    /* renamed from: a */
    public static void m9994a(Activity activity, Bundle bundle, TODOParamModel tODOParamModel) {
        try {
            if (tODOParamModel.mTODOCode > 0) {
                if (activity != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("TODO code: ");
                    sb.append(tODOParamModel.mTODOCode);
                    LogUtilsV2.m14227d(sb.toString());
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("TODO content: ");
                    sb2.append(tODOParamModel.mJsonParam);
                    LogUtilsV2.m14227d(sb2.toString());
                    int i = tODOParamModel.mTODOCode;
                    TODOParamModel tODOParamModel2 = new TODOParamModel();
                    tODOParamModel2.mTODOCode = i;
                    tODOParamModel2.mJsonParam = tODOParamModel.mJsonParam;
                    BizAppTodoActionManager.getInstance().executeTodo(activity, tODOParamModel2, bundle);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
            ICommunityAPI iCommunityAPI = (ICommunityAPI) C1919a.m5529sc().mo10356i(ICommunityAPI.class);
            if (iCommunityAPI != null) {
                iCommunityAPI.refreshMessageStatisticalInfo(activity.getApplicationContext());
            }
        }
    }

    /* renamed from: dj */
    public static TODOParamModel m9995dj(String str) {
        TODOParamModel tODOParamModel = new TODOParamModel();
        try {
            JSONObject jSONObject = new JSONObject(str);
            tODOParamModel.mJsonParam = jSONObject.optString(C7234b.TAG);
            tODOParamModel.mTODOCode = C2575a.parseInt(jSONObject.optString(C5878a.TAG));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tODOParamModel;
    }
}
