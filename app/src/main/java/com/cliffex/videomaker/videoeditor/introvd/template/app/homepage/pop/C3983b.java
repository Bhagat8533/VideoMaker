package com.introvd.template.app.homepage.pop;

import android.app.Activity;
import com.introvd.template.C3569a;
import com.introvd.template.app.manager.C4059d;
import com.introvd.template.app.manager.C4059d.C4063a;
import com.introvd.template.app.manager.C4059d.C4064b;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.common.behavior.UserBehaviorABTestUtils;
import com.introvd.template.datacenter.SocialServiceDef;
import com.introvd.template.router.todoCode.BizAppTodoActionManager;
import com.introvd.template.router.todoCode.TODOParamModel;
import com.introvd.template.router.todoCode.TodoH5UrlFromParamHandler;
import java.util.HashMap;

/* renamed from: com.introvd.template.app.homepage.pop.b */
public class C3983b {
    /* renamed from: a */
    public static boolean m9859a(Activity activity, C4063a aVar) {
        return m9861a(activity, C4059d.m10098Nf(), aVar);
    }

    /* renamed from: a */
    public static boolean m9860a(Activity activity, C4064b bVar) {
        return m9861a(activity, bVar, null);
    }

    /* renamed from: a */
    public static boolean m9861a(final Activity activity, final C4064b bVar, final C4063a aVar) {
        if (bVar == null || bVar.buI == 3 || activity.isFinishing() || C3569a.m8772FK()) {
            return false;
        }
        C4059d.m10102b(activity, bVar, new C4063a() {
            public void onCancel() {
                HashMap hashMap = new HashMap();
                hashMap.put("name", "cancel");
                hashMap.put(SocialServiceDef.EXTRAS_UPGRADE_FROM, "hot");
                UserBehaviorLog.onKVEvent(activity.getApplicationContext(), "Home_Pop_Click", hashMap);
                if (aVar != null) {
                    aVar.onCancel();
                }
            }

            public void onClick() {
                TODOParamModel tODOParamModel = new TODOParamModel();
                tODOParamModel.mTODOCode = bVar.buJ;
                tODOParamModel.mJsonParam = bVar.buK;
                TodoH5UrlFromParamHandler.addFromParam(tODOParamModel, TodoH5UrlFromParamHandler.FROM_APP_POPUP, bVar.mTitle);
                BizAppTodoActionManager.getInstance().executeTodo(activity, tODOParamModel);
                HashMap hashMap = new HashMap();
                hashMap.put("name", bVar.mTitle);
                hashMap.put(SocialServiceDef.EXTRAS_UPGRADE_FROM, "hot");
                UserBehaviorLog.onKVEvent(activity.getApplicationContext(), "Home_Pop_Click", hashMap);
                Activity activity = activity;
                String str = bVar.mTitle;
                StringBuilder sb = new StringBuilder();
                sb.append(bVar.buF);
                sb.append("");
                UserBehaviorABTestUtils.onEventShowHomePop(activity, str, sb.toString(), false);
                if (aVar != null) {
                    aVar.onClick();
                }
            }

            public void onClose() {
                HashMap hashMap = new HashMap();
                hashMap.put("name", "close");
                hashMap.put(SocialServiceDef.EXTRAS_UPGRADE_FROM, "hot");
                UserBehaviorLog.onKVEvent(activity.getApplicationContext(), "Home_Pop_Click", hashMap);
                if (aVar != null) {
                    aVar.onClose();
                }
            }
        });
        HashMap hashMap = new HashMap();
        hashMap.put("name", bVar.mTitle);
        hashMap.put(SocialServiceDef.EXTRAS_UPGRADE_FROM, "hot");
        UserBehaviorLog.onKVEvent(activity.getApplicationContext(), "Home_Pop_Show", hashMap);
        String str = bVar.mTitle;
        StringBuilder sb = new StringBuilder();
        sb.append(bVar.buF);
        sb.append("");
        UserBehaviorABTestUtils.onEventShowHomePop(activity, str, sb.toString(), true);
        return true;
    }
}
