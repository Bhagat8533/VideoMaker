package com.introvd.template.app.p184h.p185a;

import android.os.Bundle;
import android.text.TextUtils;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.router.BizServiceManager;
import com.introvd.template.router.common.CommonParams;
import com.introvd.template.router.editor.IEditorService;
import com.introvd.template.router.todoCode.BizAppTodoActionManager;
import com.introvd.template.router.todoCode.TODOParamModel;
import com.introvd.template.router.todoCode.TodoConstants;
import com.vivavideo.mobile.h5api.api.C9335a;
import com.vivavideo.mobile.h5api.api.C9345j;
import com.vivavideo.mobile.h5api.api.C9358q;
import com.vivavideo.mobile.h5api.p432a.C9334a;
import org.json.JSONException;
import org.json.JSONObject;

@C9334a(aPx = {"useTodoCode"})
/* renamed from: com.introvd.template.app.h.a.o */
public class C3913o implements C9358q {
    public void getFilter(C9335a aVar) {
    }

    public boolean handleEvent(C9345j jVar) throws JSONException {
        String action = jVar.getAction();
        StringBuilder sb = new StringBuilder();
        sb.append("h5Event getAction = ");
        sb.append(action);
        LogUtilsV2.m14227d(sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("h5Event getParam = ");
        sb2.append(jVar.aPD());
        LogUtilsV2.m14227d(sb2.toString());
        JSONObject optJSONObject = jVar.aPD().optJSONObject(SocialConstDef.TEMPLATEMONETIZATION_ITEM_TODOCODE);
        TODOParamModel tODOParamModel = new TODOParamModel();
        tODOParamModel.mTODOCode = optJSONObject.optInt(SocialConstDef.POPUPWINDOW_ITEM_EVENTTYPE);
        JSONObject optJSONObject2 = optJSONObject.optJSONObject(SocialConstDef.MESSAGE_LIST_NEW_EVENT_CONTENT);
        if (optJSONObject2 != null) {
            optJSONObject2.put(TodoConstants.KEY_TODOCODE_PARAM_AUTOCLOSE, optJSONObject2.optBoolean("auto_close", false));
            tODOParamModel.mJsonParam = optJSONObject2.toString();
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("h5Event = TodoParams = ");
        sb3.append(tODOParamModel);
        LogUtilsV2.m14227d(sb3.toString());
        String hashTag = tODOParamModel.getHashTag();
        if (!TextUtils.isEmpty(hashTag)) {
            IEditorService iEditorService = (IEditorService) BizServiceManager.getService(IEditorService.class);
            if (iEditorService != null) {
                iEditorService.setTagInfo(hashTag);
            }
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean(CommonParams.KEY_CHECK_TEMPLATE_DOWNLOAD, true);
        bundle.putInt(CommonParams.ACTIVITY_TODOCODE, tODOParamModel.mTODOCode);
        bundle.putString("activityID", hashTag);
        BizAppTodoActionManager.getInstance().executeTodo(jVar.getActivity(), tODOParamModel, bundle);
        return true;
    }

    public boolean interceptEvent(C9345j jVar) throws JSONException {
        return false;
    }

    public void onRelease() {
    }
}
