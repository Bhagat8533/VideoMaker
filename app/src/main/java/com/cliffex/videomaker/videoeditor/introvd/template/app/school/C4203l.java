package com.introvd.template.app.school;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.aiii.android.arouter.p091c.C1919a;
import com.introvd.template.app.push.api.model.CommonResponseResult;
import com.introvd.template.app.school.api.C4153h;
import com.introvd.template.app.school.api.model.TemplateInfo;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.router.BizServiceManager;
import com.introvd.template.router.common.CommonParams;
import com.introvd.template.router.common.ICommonFuncRouter;
import com.introvd.template.router.editor.IEditorService;
import com.introvd.template.router.iap.IapServiceProxy;
import com.introvd.template.router.todoCode.BizAppTodoActionManager;
import com.introvd.template.router.todoCode.TODOParamModel;
import com.introvd.template.router.todoCode.TodoConstants;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
import p037b.p050b.C1850u;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p076j.C1820a;

/* renamed from: com.introvd.template.app.school.l */
public class C4203l {
    /* renamed from: NK */
    private static boolean m10493NK() {
        Object execute = IapServiceProxy.execute(IapServiceProxy.isVip, new Object[0]);
        return (execute instanceof Boolean) && ((Boolean) execute).booleanValue();
    }

    /* renamed from: a */
    private static TODOParamModel m10494a(TemplateInfo templateInfo) {
        if (templateInfo.isVip() && !m10493NK()) {
            return m10496b(templateInfo);
        }
        TODOParamModel tODOParamModel = new TODOParamModel();
        tODOParamModel.mTODOCode = 423;
        tODOParamModel.mJsonParam = templateInfo.getEventContent();
        return tODOParamModel;
    }

    /* renamed from: a */
    public static void m10495a(TemplateInfo templateInfo, Activity activity, int i, String str) {
        ICommonFuncRouter iCommonFuncRouter = (ICommonFuncRouter) C1919a.m5529sc().mo10356i(ICommonFuncRouter.class);
        if (iCommonFuncRouter != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("ttid", templateInfo.getTtid());
            UserBehaviorLog.onKVEvent(activity, "Click_Module_Cover_Use", hashMap);
            C4205m.m10500c(templateInfo.getTtid(), i, str);
            TODOParamModel tODOParamModel = new TODOParamModel();
            if (templateInfo.isVip() && !m10493NK()) {
                tODOParamModel = m10496b(templateInfo);
            } else if (templateInfo.getEventCode() > 0) {
                tODOParamModel.mTODOCode = templateInfo.getEventCode();
                tODOParamModel.mJsonParam = templateInfo.getEventContent();
            } else {
                tODOParamModel = m10494a(templateInfo);
            }
            if (tODOParamModel.mTODOCode == 423 || tODOParamModel.mTODOCode == 16007) {
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
                bundle.putInt(TODOParamModel.TODO_PARAM_PAGE_FROM, i);
                BizAppTodoActionManager.getInstance().executeTodo(activity, tODOParamModel, bundle);
            } else {
                iCommonFuncRouter.executeTodo(activity, tODOParamModel, null);
            }
            C4153h.m10366dQ(templateInfo.getTtid()).mo10196g(C1820a.aVi()).mo10188a((C1850u<? super T>) new C1850u<CommonResponseResult<Void>>() {
                /* renamed from: a */
                public void mo9883a(C1495b bVar) {
                }

                /* renamed from: a */
                public void onSuccess(CommonResponseResult<Void> commonResponseResult) {
                }

                public void onError(Throwable th) {
                    th.printStackTrace();
                }
            });
        }
    }

    /* renamed from: b */
    private static TODOParamModel m10496b(TemplateInfo templateInfo) {
        TODOParamModel tODOParamModel = new TODOParamModel();
        tODOParamModel.mTODOCode = TodoConstants.TODO_TYPE_VIP_NEW_VIP;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("fromTodocode", templateInfo.getTtid());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        tODOParamModel.mJsonParam = jSONObject.toString();
        return tODOParamModel;
    }
}
