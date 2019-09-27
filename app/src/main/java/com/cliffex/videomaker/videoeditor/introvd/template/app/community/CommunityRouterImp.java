package com.introvd.template.app.community;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.aiii.android.arouter.facade.p094a.C1942a;
import com.introvd.template.C4681i;
import com.introvd.template.app.manager.C4041a;
import com.introvd.template.app.manager.C4059d;
import com.introvd.template.app.manager.C4059d.C4063a;
import com.introvd.template.app.manager.C4059d.C4064b;
import com.introvd.template.app.push.C4103b;
import com.introvd.template.app.setting.SettingActivityV6;
import com.introvd.template.app.setting.SettingNotificationActivity;
import com.introvd.template.app.utils.C4395c;
import com.introvd.template.app.webview.CommonWebPage;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.common.behavior.UserBehaviorUtilsV5;
import com.introvd.template.common.p236ui.modechooser.ModeItemInfo;
import com.introvd.template.community.ICommunityFuncRouter;
import com.introvd.template.component.feedback.C5349b;
import com.introvd.template.datacenter.SocialServiceDef;
import com.introvd.template.origin.route.C8145c;
import com.introvd.template.router.BizServiceManager;
import com.introvd.template.router.app.IAppService;
import com.introvd.template.router.editor.EditorRouter;
import com.introvd.template.router.editor.IEditorService;
import com.introvd.template.router.todoCode.BizAppTodoActionManager;
import com.introvd.template.router.todoCode.TODOParamModel;
import com.introvd.template.router.todoCode.TodoConstants;
import com.introvd.template.router.todoCode.TodoH5UrlFromParamHandler;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import p037b.p050b.C1834l;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p057e.C1517e;
import p037b.p050b.p076j.C1820a;

@C1942a(mo10417rZ = "/VivaRouter/CommunityFuncRouter")
public class CommunityRouterImp implements ICommunityFuncRouter {
    public void doInstagramClick(Activity activity, String str) {
        SettingActivityV6.doInstagramClick(activity, str);
    }

    public void executeEditorTodo(Activity activity, ModeItemInfo modeItemInfo) {
        if (TodoConstants.isEditorTodoCode(modeItemInfo.todoCode)) {
            IEditorService iEditorService = (IEditorService) BizServiceManager.getService(IEditorService.class);
            if (iEditorService != null) {
                iEditorService.setProjectExtraInfo();
            }
        }
        TODOParamModel tODOParamModel = new TODOParamModel();
        tODOParamModel.mTODOCode = modeItemInfo.todoCode;
        tODOParamModel.mJsonParam = modeItemInfo.todoParameter;
        Bundle bundle = new Bundle();
        bundle.putString(EditorRouter.COMMON_PARAM_POSITION, "100");
        if (activity != null) {
            if (activity.getIntent() != null) {
                activity.getIntent().removeExtra(TodoConstants.KEY_TODOCODE_PARAM_MODEL);
            }
            BizAppTodoActionManager.getInstance().executeTodo(activity, tODOParamModel, bundle);
        }
        UserBehaviorUtilsV5.onEventShortCutClick(String.valueOf(modeItemInfo.todoCode));
    }

    public void feedback(Activity activity, long j) {
        C4395c.m11088a(activity, j);
    }

    public void handleIMNotificationStart(Context context, String str, String str2) {
        C4103b.m10185a(context, TodoConstants.TODO_TYPE_QA_TEST, str, str2, "", "", "");
    }

    public void init(Context context) {
    }

    public boolean isFeedbackItemNew(Context context) {
        return C5349b.m14582ek(context);
    }

    public boolean isReceiveIMNotification() {
        return SettingNotificationActivity.m10836dZ("pref_notification_im");
    }

    public void onRouterClientConfigure(Context context, String str, String str2) {
        C4681i.m12184Gp().mo25016Gr().onRouterClientConfigure(context, false, str, str2, null);
    }

    public void recordEventWithAppFlyer(Context context, String str, Map map) {
        StringBuilder sb = new StringBuilder();
        sb.append("recordEventWithAppFlyer : ");
        sb.append(str);
        LogUtilsV2.m14230i(sb.toString());
        C4041a.m10046c(context, str, map);
    }

    public void reloadWebPageUrl(Activity activity, String str) {
        if (activity != null) {
            if (activity instanceof CommonWebPage) {
                ((CommonWebPage) activity).mo24676et(str);
            } else {
                C1834l.m5257ah(str).mo10152c(C1820a.aVi()).mo10164f(1, TimeUnit.SECONDS).mo10152c(C1487a.aUa()).mo10168g((C1517e<? super T>) new C1517e<String>() {
                    /* renamed from: dn */
                    public void accept(String str) {
                        IAppService iAppService = (IAppService) BizServiceManager.getService(IAppService.class);
                        if (iAppService != null) {
                            iAppService.startHybridPage(TodoH5UrlFromParamHandler.addFromParamToUrl(str, ""));
                        }
                    }
                });
            }
        }
    }

    public void setUserZoneInfo(Context context, String str, String str2) {
        C8145c.setUserZoneInfo(context, str, str2);
        C8145c.aFd().mo33228aI(str, str2);
    }

    public void showPublishPopWindows(final Activity activity) {
        final C4064b hf = C4059d.m10110hf(370);
        if (hf != null) {
            C4059d.m10102b(activity, hf, new C4063a() {
                public void onCancel() {
                    HashMap hashMap = new HashMap();
                    hashMap.put("name", "cancel");
                    hashMap.put(SocialServiceDef.EXTRAS_UPGRADE_FROM, "ExportResultPage");
                    UserBehaviorLog.onKVEvent(activity.getApplicationContext(), "Home_Pop_Click", hashMap);
                }

                public void onClick() {
                    TODOParamModel tODOParamModel = new TODOParamModel();
                    tODOParamModel.mTODOCode = hf.buJ;
                    tODOParamModel.mJsonParam = hf.buK;
                    TodoH5UrlFromParamHandler.addFromParam(tODOParamModel, TodoH5UrlFromParamHandler.FROM_APP_POPUP, hf.mTitle);
                    BizAppTodoActionManager.getInstance().executeTodo(activity, tODOParamModel);
                    HashMap hashMap = new HashMap();
                    hashMap.put("name", hf.mTitle);
                    hashMap.put(SocialServiceDef.EXTRAS_UPGRADE_FROM, "ExportResultPage");
                    UserBehaviorLog.onKVEvent(activity.getApplicationContext(), "Home_Pop_Click", hashMap);
                }

                public void onClose() {
                    HashMap hashMap = new HashMap();
                    hashMap.put("name", "close");
                    hashMap.put(SocialServiceDef.EXTRAS_UPGRADE_FROM, "ExportResultPage");
                    UserBehaviorLog.onKVEvent(activity.getApplicationContext(), "Home_Pop_Click", hashMap);
                }
            });
            HashMap hashMap = new HashMap();
            hashMap.put("name", hf.mTitle);
            hashMap.put(SocialServiceDef.EXTRAS_UPGRADE_FROM, "ExportResultPage");
            UserBehaviorLog.onKVEvent(activity.getApplicationContext(), "Home_Pop_Show", hashMap);
        }
    }

    public void showRateDialog(Activity activity) {
        C4681i.m12184Gp().mo25016Gr().showRateDialog(activity);
    }
}
