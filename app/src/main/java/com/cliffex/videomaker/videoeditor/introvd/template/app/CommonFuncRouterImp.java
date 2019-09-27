package com.introvd.template.app;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.aiii.android.arouter.facade.p094a.C1942a;
import com.aiii.android.arouter.p091c.C1919a;
import com.introvd.template.router.common.ICommonFuncRouter;
import com.introvd.template.router.community.ICommunityService;
import com.introvd.template.router.todoCode.BizAppTodoActionManager;
import com.introvd.template.router.todoCode.TODOParamModel;

@C1942a(mo10417rZ = "/VivaCommonRouter/CommonFuncRouter")
public class CommonFuncRouterImp implements ICommonFuncRouter {
    public void executeTodo(Activity activity, TODOParamModel tODOParamModel, Bundle bundle) {
        ICommunityService iCommunityService = (ICommunityService) C1919a.m5529sc().mo10356i(ICommunityService.class);
        if (!(iCommunityService != null ? iCommunityService.executeTodo(activity, tODOParamModel) : false)) {
            BizAppTodoActionManager.getInstance().executeTodo(activity, tODOParamModel, bundle);
        }
    }

    public void init(Context context) {
    }
}
