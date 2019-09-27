package com.introvd.template.router.todoCode;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.aiii.android.arouter.facade.template.C1949c;
import com.introvd.template.router.todoCode.TODOParamModel;
public abstract class BaseTodoInterceptor implements C1949c {
    public boolean executeQATestTodo(Context context, TODOParamModel tODOParamModel, Bundle bundle) {
        return false;
    }

    public final boolean executeTodo(Activity activity, TODOParamModel tODOParamModel) {
        if (activity.getIntent() != null) {
            activity.getIntent().removeExtra(com.introvd.template.router.todoCode.TodoConstants.KEY_TODOCODE_PARAM_MODEL);
        }
        if ("{}".equals(tODOParamModel.mJsonParam)) {
            tODOParamModel.mJsonParam = "";
        }
        return executeTodo(activity, tODOParamModel, null);
    }

    public boolean executeTodo(Activity activity, TODOParamModel tODOParamModel, int i, String str) {
        return false;
    }

    public boolean executeTodo(Activity activity, TODOParamModel tODOParamModel, Bundle bundle) {
        return false;
    }

    public String getTodoCodeName(int i) {
        return null;
    }

    public final void init(Context context) {
    }
}
