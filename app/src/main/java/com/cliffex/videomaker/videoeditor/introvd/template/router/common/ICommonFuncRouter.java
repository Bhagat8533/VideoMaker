package com.introvd.template.router.common;

import android.app.Activity;
import android.os.Bundle;
import com.aiii.android.arouter.facade.template.C1949c;
import com.introvd.template.router.todoCode.TODOParamModel;

public interface ICommonFuncRouter extends C1949c {
    public static final String VIVA_COMMON_ROUTER_FUNC = "/VivaCommonRouter/CommonFuncRouter";

    void executeTodo(Activity activity, TODOParamModel tODOParamModel, Bundle bundle);
}
